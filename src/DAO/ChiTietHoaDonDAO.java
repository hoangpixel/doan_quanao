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
import javax.swing.JOptionPane;
/**
 *
 * @author suvie
 */
public class ChiTietHoaDonDAO {
    
    public ArrayList<ChiTietHoaDonDTO> docDSCTHD() {
        ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<>();
        String query = "select * from cthd";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                ChiTietHoaDonDTO cthd = new ChiTietHoaDonDTO();
                cthd.setMaHoaDon(rs.getInt("MAHD"));
                cthd.setMaSanPham(rs.getInt("MASP"));
                cthd.setSoLuong(rs.getInt("SL"));
                cthd.setDonGia(rs.getInt("DONGIA"));
                ds.add(cthd);
            }
            
            rs.close();
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnect.closeConnection(conn);
        }
        return ds;
    }
    
    public boolean capNhatSoLuongTonKho(int masp, int soluong) {
        String queryCheck = "SELECT SLSP FROM phienbansp WHERE MASP = ?";
        String queryUpdate = "UPDATE phienbansp SET SLSP = SLSP - ? WHERE MASP = ?";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(queryCheck);
            st.setInt(1, masp);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int currentStock = rs.getInt("SLSP");
                if (currentStock < soluong) {
                    JOptionPane.showMessageDialog(null, "Số lượng tồn kho không đủ! Chỉ còn " + currentStock + " sản phẩm.");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy phiên bản sản phẩm với MASP = " + masp);
                return false;
            }
            rs.close();
            st.close();
            PreparedStatement stUpdate = conn.prepareStatement(queryUpdate);
            stUpdate.setInt(1, soluong);
            stUpdate.setInt(2, masp);
            int rows = stUpdate.executeUpdate();
            stUpdate.close();
            return rows > 0;
        } catch (SQLException e) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            DBConnect.closeConnection(conn);
        }
    }

    public void tangSoLuongTonKho(int masp, int soluong) {
        String queryUpdate = "UPDATE phienbansp SET SLSP = SLSP + ? WHERE MASP = ?";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(queryUpdate);
            st.setInt(1, soluong);
            st.setInt(2, masp);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnect.closeConnection(conn);
        }
    }

    public int laySoLuongHienTai(int mahd, int masp) {
        String query = "SELECT SL FROM cthd WHERE MAHD = ? AND MASP = ?";
        Connection conn = null;
        int soluong = 0;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, mahd);
            st.setInt(2, masp);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                soluong = rs.getInt("SL");
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnect.closeConnection(conn);
        }
        return soluong;
    }
    
    public boolean capNhatTongTienHoaDon(int mahd) {
        String querySum = "SELECT SUM(THANHTIEN) AS TONGTIEN FROM cthd WHERE MAHD = ?";
        String queryUpdate = "UPDATE hoadon SET TONGTIEN = ? WHERE MAHD = ?";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            // Tính tổng THANHTIEN
            PreparedStatement stSum = conn.prepareStatement(querySum);
            stSum.setInt(1, mahd);
            ResultSet rs = stSum.executeQuery();
            int tongTien = 0;
            if (rs.next()) {
                tongTien = rs.getInt("TONGTIEN");
            }
            rs.close();
            stSum.close();

            // Cập nhật TONGTIEN trong bảng hoadon
            PreparedStatement stUpdate = conn.prepareStatement(queryUpdate);
            stUpdate.setInt(1, tongTien);
            stUpdate.setInt(2, mahd);
            int rows = stUpdate.executeUpdate();
            stUpdate.close();
            return rows > 0;
        } catch (SQLException e) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            DBConnect.closeConnection(conn);
        }
    }
    
    public int them(ChiTietHoaDonDTO cthd) {
        Connection conn = null;
        int mahd = -1;
        try {
            conn = DBConnect.getConnection();
            conn.setAutoCommit(false); // Bắt đầu transaction

            // Kiểm tra và cập nhật số lượng tồn kho
            if (!capNhatSoLuongTonKho(cthd.getMaSanPham(), cthd.getSoLuong())) {
                conn.rollback();
                return -1; // Thất bại do không đủ tồn kho
            }

            // Thêm chi tiết hóa đơn
            String query = "INSERT INTO cthd (MAHD, MASP, SL, DONGIA, THANHTIEN) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, cthd.getMaHoaDon());
            st.setInt(2, cthd.getMaSanPham());
            st.setInt(3, cthd.getSoLuong());
            st.setInt(4, cthd.getDonGia());
            st.setInt(5, cthd.getSoLuong() * cthd.getDonGia());
            
            int row = st.executeUpdate();
            if (row > 0) {
                mahd = cthd.getMaHoaDon();
                // Cập nhật tổng tiền hóa đơn
                if (!capNhatTongTienHoaDon(mahd)) {
                    conn.rollback();
                    return -1; // Thất bại do không cập nhật được tổng tiền
                }
                conn.commit(); // Commit transaction
            } else {
                conn.rollback();
            }
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, e);
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return -1;
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    DBConnect.closeConnection(conn);
                }
            } catch (SQLException e) {
                Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return mahd;
    }
    
    public boolean sua(ChiTietHoaDonDTO cthd, int oldSoLuong) {
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            conn.setAutoCommit(false); // Bắt đầu transaction

            int quantityDiff = cthd.getSoLuong() - oldSoLuong;
            if (quantityDiff > 0) {
                // Kiểm tra số lượng tồn kho nếu tăng số lượng
                if (!capNhatSoLuongTonKho(cthd.getMaSanPham(), quantityDiff)) {
                    conn.rollback();
                    return false;
                }
            } else if (quantityDiff < 0) {
                // Tăng tồn kho nếu giảm số lượng
                tangSoLuongTonKho(cthd.getMaSanPham(), -quantityDiff);
            }

            // Cập nhật chi tiết hóa đơn
            String query = """
                           UPDATE cthd
                           SET SL = ?, DONGIA = ?, THANHTIEN = ?
                           WHERE MAHD = ? AND MASP = ?
                           """;
            PreparedStatement st = conn.prepareStatement(query);
            int thanhtien = cthd.getSoLuong() * cthd.getDonGia();
            st.setInt(1, cthd.getSoLuong());
            st.setInt(2, cthd.getDonGia());
            st.setInt(3, thanhtien);
            st.setInt(4, cthd.getMaHoaDon());
            st.setInt(5, cthd.getMaSanPham());
            int rows = st.executeUpdate();
            
            if (rows > 0) {
                // Cập nhật tổng tiền hóa đơn
                if (!capNhatTongTienHoaDon(cthd.getMaHoaDon())) {
                    conn.rollback();
                    return false;
                }
                conn.commit(); // Commit transaction
            } else {
                conn.rollback();
                return false;
            }
            st.close();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, e);
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    DBConnect.closeConnection(conn);
                }
            } catch (SQLException e) {
                Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    public void xoa(int mahd, int masp) {
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            conn.setAutoCommit(false); // Bắt đầu transaction

            // Lấy số lượng hiện tại để hoàn lại tồn kho
            int soLuong = laySoLuongHienTai(mahd, masp);
            if (soLuong > 0) {
                tangSoLuongTonKho(masp, soLuong);
            }

            // Xóa chi tiết hóa đơn
            String query = "DELETE FROM cthd WHERE MAHD = ? AND MASP = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, mahd);
            st.setInt(2, masp);
            int rows = st.executeUpdate();
            
            if (rows > 0) {
                // Cập nhật tổng tiền hóa đơn
                if (!capNhatTongTienHoaDon(mahd)) {
                    conn.rollback();
                    JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật tổng tiền hóa đơn!");
                } else {
                    conn.commit(); // Commit transaction
                    JOptionPane.showMessageDialog(null, "Đã xóa chi tiết hóa đơn thành công!");
                }
            } else {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Không tìm thấy chi tiết hóa đơn để xóa.");
            }
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, e);
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    DBConnect.closeConnection(conn);
                }
            } catch (SQLException e) {
                Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
   
    public ChiTietHoaDonDTO layChiTietHoaDonTheoHaiMa(int mahd, int masp) {
        String query = "select * from cthd where MAHD = ? AND MASP = ?";
        Connection conn = null;
        ChiTietHoaDonDTO cthd = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, mahd);
            st.setInt(2, masp);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                cthd = new ChiTietHoaDonDTO();
                cthd.setMaHoaDon(rs.getInt("MAHD"));
                cthd.setMaSanPham(rs.getInt("MASP"));
                cthd.setSoLuong(rs.getInt("SL"));
                cthd.setDonGia(rs.getInt("DONGIA"));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnect.closeConnection(conn);
        }
        return cthd;
    }
}
