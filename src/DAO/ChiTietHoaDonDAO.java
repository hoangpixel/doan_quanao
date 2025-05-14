/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.ChiTietHoaDonDTO;
import config.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author suvie
 */
public class ChiTietHoaDonDAO {
    
    private static final Logger LOGGER = Logger.getLogger(ChiTietHoaDonDAO.class.getName());

    public ArrayList<ChiTietHoaDonDTO> docDSCTHD() {
        ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<>();
        String query = "SELECT * FROM cthd";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement st = conn.prepareStatement(query);
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                ChiTietHoaDonDTO cthd = new ChiTietHoaDonDTO();
                cthd.setMaHoaDon(rs.getInt("MAHD"));
                cthd.setMaSanPham(rs.getInt("MASP"));
                cthd.setMaPhienBan(rs.getInt("MAPB"));
                cthd.setSoLuong(rs.getInt("SL"));
                cthd.setDonGia(rs.getInt("DONGIA"));
                ds.add(cthd);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error reading CTHD list", e);
        }
        return ds;
    }

    public boolean capNhatSoLuongTonKho(int masp, int mapb, int soluong) {
        String queryCheck = "SELECT SLPB FROM phienbansp WHERE MASP = ? AND MAPB = ?";
        String queryUpdate = "UPDATE phienbansp SET SLPB = SLPB - ? WHERE MASP = ? AND MAPB = ?";
        try (Connection conn = DBConnect.getConnection()) {
            PreparedStatement st = conn.prepareStatement(queryCheck);
            st.setInt(1, masp);
            st.setInt(2, mapb);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int currentStock = rs.getInt("SLPB");
                if (currentStock < soluong) {
                    throw new SQLException("Số lượng tồn kho không đủ! Chỉ còn " + currentStock + " sản phẩm.");
                }
            } else {
                throw new SQLException("Không tìm thấy phiên bản sản phẩm với MASP = " + masp + " và MAPB = " + mapb);
            }
            rs.close();
            st.close();

            PreparedStatement stUpdate = conn.prepareStatement(queryUpdate);
            stUpdate.setInt(1, soluong);
            stUpdate.setInt(2, masp);
            stUpdate.setInt(3, mapb);
            int rows = stUpdate.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating stock", e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public void tangSoLuongTonKho(int masp, int mapb, int soluong) {
        String queryUpdate = "UPDATE phienbansp SET SLPB = SLPB + ? WHERE MASP = ? AND MAPB = ?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement st = conn.prepareStatement(queryUpdate)) {
            st.setInt(1, soluong);
            st.setInt(2, masp);
            st.setInt(3, mapb);
            st.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error increasing stock", e);
            throw new RuntimeException("Error increasing stock", e);
        }
    }

    public int laySoLuongHienTai(int mahd, int masp, int mapb) {
        String query = "SELECT SL FROM cthd WHERE MAHD = ? AND MASP = ? AND MAPB = ?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement st = conn.prepareStatement(query)) {
            st.setInt(1, mahd);
            st.setInt(2, masp);
            st.setInt(3, mapb);
            ResultSet rs = st.executeQuery();
            return rs.next() ? rs.getInt("SL") : 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error fetching current quantity", e);
            return 0;
        }
    }

    public boolean capNhatTongTienHoaDon(int mahd) {
        String querySum = "SELECT SUM(THANHTIEN) AS TONGTIEN FROM cthd WHERE MAHD = ?";
        String queryUpdate = "UPDATE hoadon SET TONGTIEN = ? WHERE MAHD = ?";
        try (Connection conn = DBConnect.getConnection()) {
            PreparedStatement stSum = conn.prepareStatement(querySum);
            stSum.setInt(1, mahd);
            ResultSet rs = stSum.executeQuery();
            int tongTien = rs.next() ? rs.getInt("TONGTIEN") : 0;
            rs.close();

            PreparedStatement stUpdate = conn.prepareStatement(queryUpdate);
            stUpdate.setInt(1, tongTien);
            stUpdate.setInt(2, mahd);
            int rows = stUpdate.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating total bill", e);
            return false;
        }
    }

    public int them(ChiTietHoaDonDTO cthd) {
        String querySelect = "Select SL from cthd where MAHD = ? and MASP = ? and MAPB = ?";
        String queryUpdate = "Update cthd set SL = SL + ?, THANHTIEN = (SL +?) * DONGIA Where MAHD = ? and MASP = ? and MAPB = ?";
        String queryInsert = "INSERT INTO cthd (MAHD, MASP, MAPB, SL, DONGIA, THANHTIEN) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnect.getConnection()) {
            conn.setAutoCommit(false);
            PreparedStatement stSelect = conn.prepareStatement(querySelect);
            stSelect.setInt(1, cthd.getMaHoaDon());
            stSelect.setInt(2, cthd.getMaSanPham());
            stSelect.setInt(3, cthd.getMaPhienBan());
            ResultSet rs = stSelect.executeQuery();
            if(rs.next()) {
                int currentSL = rs.getInt("SL");
                if (!capNhatSoLuongTonKho(cthd.getMaSanPham(), cthd.getMaPhienBan(), cthd.getSoLuong())) {
                    conn.rollback();
                    return -1;
                }
                PreparedStatement stUpdate = conn.prepareStatement(queryUpdate);
            
                stUpdate.setInt(1, cthd.getSoLuong());
                stUpdate.setInt(2, cthd.getSoLuong());
                stUpdate.setInt(3, cthd.getMaHoaDon());
                stUpdate.setInt(4, cthd.getMaSanPham());
                stUpdate.setInt(5, cthd.getMaPhienBan());
                int rows = stUpdate.executeUpdate();

                if (rows > 0 && capNhatTongTienHoaDon(cthd.getMaHoaDon())) {
                    conn.commit();
                    return cthd.getMaHoaDon();
                }
                conn.rollback();
                return -1;
            } else {
                if (!capNhatSoLuongTonKho(cthd.getMaSanPham(), cthd.getMaPhienBan(), cthd.getSoLuong())) {
                    conn.rollback();
                    return -1;
                }

                PreparedStatement stInsert = conn.prepareStatement(queryInsert);
                stInsert.setInt(1, cthd.getMaHoaDon());
                stInsert.setInt(2, cthd.getMaSanPham());
                stInsert.setInt(3, cthd.getMaPhienBan());
                stInsert.setInt(4, cthd.getSoLuong());
                stInsert.setInt(5, cthd.getDonGia());
                stInsert.setInt(6, cthd.getThanhTien());
                int row = stInsert.executeUpdate();

                if (row > 0 && capNhatTongTienHoaDon(cthd.getMaHoaDon())) {
                    conn.commit();
                    return cthd.getMaHoaDon();
                }
                conn.rollback();
                return -1;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error adding CTHD", e);
            try (Connection conn = DBConnect.getConnection()) {
                conn.rollback();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error during rollback", ex);
            }
            return -1;
        }
    }

    public boolean sua(ChiTietHoaDonDTO cthd, int oldSoLuong) {
        String query = "UPDATE cthd SET SL = ?, DONGIA = ?, THANHTIEN = ? WHERE MAHD = ? AND MASP = ? AND MAPB = ?";
        try (Connection conn = DBConnect.getConnection()) {
            conn.setAutoCommit(false);
            int quantityDiff = cthd.getSoLuong() - oldSoLuong;
            if (quantityDiff > 0) {
                if (!capNhatSoLuongTonKho(cthd.getMaSanPham(), cthd.getMaPhienBan(), quantityDiff)) {
                    conn.rollback();
                    return false;
                }
            } else if (quantityDiff < 0) {
                tangSoLuongTonKho(cthd.getMaSanPham(), cthd.getMaPhienBan(), -quantityDiff);
            }

            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, cthd.getSoLuong());
            st.setInt(2, cthd.getDonGia());
            st.setInt(3, cthd.getThanhTien());
            st.setInt(4, cthd.getMaHoaDon());
            st.setInt(5, cthd.getMaSanPham());
            st.setInt(6, cthd.getMaPhienBan());
            int rows = st.executeUpdate();

            if (rows > 0 && capNhatTongTienHoaDon(cthd.getMaHoaDon())) {
                conn.commit();
                return true;
            }
            conn.rollback();
            return false;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating CTHD", e);
            try (Connection conn = DBConnect.getConnection()) {
                conn.rollback();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error during rollback", ex);
            }
            return false;
        }
    }

    public boolean xoa(int mahd, int masp, int mapb) {
        String query = "DELETE FROM cthd WHERE MAHD = ? AND MASP = ? AND MAPB = ?";
        try (Connection conn = DBConnect.getConnection()) {
            conn.setAutoCommit(false);
            int soLuong = laySoLuongHienTai(mahd, masp, mapb);
            if (soLuong > 0) {
                tangSoLuongTonKho(masp, mapb, soLuong);
            }

            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, mahd);
            st.setInt(2, masp);
            st.setInt(3, mapb);
            int rows = st.executeUpdate();

            if (rows > 0 && capNhatTongTienHoaDon(mahd)) {
                conn.commit();
                return true;
            }
            conn.rollback();
            return false;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting CTHD", e);
            try (Connection conn = DBConnect.getConnection()) {
                conn.rollback();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error during rollback", ex);
            }
            return false;
        }
    }

    public ChiTietHoaDonDTO layChiTietHoaDonTheoBaMa(int mahd, int masp, int mapb) {
        String query = "SELECT * FROM cthd WHERE MAHD = ? AND MASP = ? AND MAPB = ?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement st = conn.prepareStatement(query)) {
            st.setInt(1, mahd);
            st.setInt(2, masp);
            st.setInt(3, mapb);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                ChiTietHoaDonDTO cthd = new ChiTietHoaDonDTO();
                cthd.setMaHoaDon(rs.getInt("MAHD"));
                cthd.setMaSanPham(rs.getInt("MASP"));
                cthd.setMaPhienBan(rs.getInt("MAPB"));
                cthd.setSoLuong(rs.getInt("SL"));
                cthd.setDonGia(rs.getInt("DONGIA"));
                return cthd;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error fetching CTHD by IDs", e);
        }
        return null;
    }
    
    public int getLatestMaHoaDon() {
        String query = "SELECT MAX(MAHD) AS MAX_MAHD FROM hoadon";
        try (Connection conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("MAX_MAHD");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public ArrayList<ChiTietHoaDonDTO> layCTHDTheoMaHoaDon(int maHoaDon) {
        ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<>();
        String query = "SELECT * FROM cthd WHERE MAHD = ?";
        try (Connection conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query)) {
            st.setInt(1, maHoaDon);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    ChiTietHoaDonDTO cthd = new ChiTietHoaDonDTO();
                    cthd.setMaHoaDon(rs.getInt("MAHD"));
                    cthd.setMaSanPham(rs.getInt("MASP"));
                    cthd.setMaPhienBan(rs.getInt("MAPB"));
                    cthd.setSoLuong(rs.getInt("SL"));
                    cthd.setDonGia(rs.getInt("DONGIA"));
                    ds.add(cthd);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error fetching CTHD by MAHD", e);
        }
        return ds;
    }
}
