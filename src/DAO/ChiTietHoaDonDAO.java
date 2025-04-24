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
    
    public int them(ChiTietHoaDonDTO cthd) {
        if (!capNhatSoLuongTonKho(cthd.getMaSanPham(), cthd.getSoLuong())) {
            return -1; // Return -1 to indicate failure due to insufficient stock
        }
        String query = "insert into cthd (MASP, SL, DONGIA, THANHTIEN) values (?, ?, ?, ?)";
        Connection conn = null;
        int mahd = -1;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, cthd.getMaSanPham());
            st.setInt(2, cthd.getSoLuong());
            st.setInt(3, cthd.getDonGia());
            st.setInt(4, cthd.getSoLuong() * cthd.getDonGia());
            
            int row = st.executeUpdate();
            if(row > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()) {
                    mahd = rs.getInt(1);
                }
                rs.close();
            }
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            DBConnect.closeConnection(conn);
        }
        return mahd;
    }
    
    public boolean sua(ChiTietHoaDonDTO cthd, int oldSoLuong) {
        int quantityDiff = cthd.getSoLuong() - oldSoLuong;
        if (quantityDiff > 0) {
            // Check if there is enough stock for the increased quantity
            if (!capNhatSoLuongTonKho(cthd.getMaSanPham(), quantityDiff)) {
                return false;
            }
        } else if (quantityDiff < 0) {
            // Increase stock if the new quantity is less than the old quantity
            tangSoLuongTonKho(cthd.getMaSanPham(), -quantityDiff);
        }

        String query = """
                       update cthd
                       set SL = ?, DONGIA = ?, THANHTIEN = ?
                       where MAHD = ? AND MASP = ?
                       """;
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            int thanhtien = cthd.getSoLuong() * cthd.getDonGia();
            st.setInt(1, cthd.getSoLuong());
            st.setInt(2, cthd.getDonGia());
            st.setInt(3, thanhtien);
            st.setInt(4, cthd.getMaHoaDon());
            st.setInt(5, cthd.getMaSanPham());
            int rows = st.executeUpdate();
            st.close();
            return rows > 0;
        } catch (SQLException e) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            DBConnect.closeConnection(conn);
        }
    }
    
    public void xoa(int mahd, int masp) {
        int soLuong = laySoLuongHienTai(mahd, masp);
        if (soLuong > 0) {
            tangSoLuongTonKho(masp, soLuong);
        }

        String query = "delete from cthd where MAHD = ? AND MASP = ?";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, mahd);
            st.setInt(2, masp);
            int rows = st.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Đã xóa chi tiết hóa đơn thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy chi tiết hóa đơn để xóa.");
            }
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnect.closeConnection(conn);
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
