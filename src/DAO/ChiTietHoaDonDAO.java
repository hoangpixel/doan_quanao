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
    // Thêm chi tiết hóa đơn trả về mã hóa đơn
    public int them(ChiTietHoaDonDTO cthd) {
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
    
    public void sua(ChiTietHoaDonDTO cthd) {
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
            st.setInt(5, cthd.getMaSanPham()); // Điều kiện của where
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
        } finally {
            DBConnect.closeConnection(conn);
        }
    }
    
    public void xoaTheoMaHoaDon(int mahd) {
        String query = "delete from cthd where MAHD = ?";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, mahd);
            int rows = st.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Đã xóa " + rows + " chi tiết hóa đơn thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy chi tiết hóa đơn để xóa.");
            }
            st.close();
        } catch (Exception e) {
        } finally {
            DBConnect.closeConnection(conn);
        }
    }
    
    public void xoaTheoMaSanPham(int masp) {
        String query = "delete from cthd where MASP = ?";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, masp);
            int rows = st.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Đã xóa " + rows + " chi tiết hóa đơn thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy chi tiết hóa đơn để xóa.");
            }
            st.close();
        } catch (Exception e) {
        } finally {
            DBConnect.closeConnection(conn);
        }
    }
    
    public void xoaTheoCaHaiMa(int mahd, int masp) {
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
        } catch (Exception e) {
        } finally {
            DBConnect.closeConnection(conn);
        }
    }
    
    public ArrayList<ChiTietHoaDonDTO> layChiTietHoaDonTheoMaHoaDon (int mahd) {
        String query = "select * from cthd where MAHD = ?";
        Connection conn = null;
        ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<>();
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, mahd);
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
        } catch (Exception e) {
        } finally {
            DBConnect.closeConnection(conn);
        }
        return ds;
    }
    
    public ArrayList<ChiTietHoaDonDTO> layChiTietHoaDonTheoMaSanPham (int masp) {
        String query = "select * from cthd where MASP = ?";
        Connection conn = null;
        ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<>();
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, masp);
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
        } catch (Exception e) {
        } finally {
            DBConnect.closeConnection(conn);
        }
        return ds;
    }
    
    public ChiTietHoaDonDTO layChiTietHoaDonTheoCaHaiMa (int mahd, int masp) {
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
        } catch (Exception e) {
        } finally {
            DBConnect.closeConnection(conn);
        }
        return cthd;
    }
    
    public ArrayList<ChiTietHoaDonDTO> layTatCaCTHD () {
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
        } catch (Exception e) {
        } finally {
            DBConnect.closeConnection(conn);
        }
        return ds;
    }
    
    public ArrayList<ChiTietHoaDonDTO> timKiemTheoMaHoaDon(int mahd) {
        ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<>();
        String query = "select * from cthd where MAHD = ?";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, mahd);
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
        } catch (Exception e) {
        } finally {
            DBConnect.closeConnection(conn);
        }
        return ds;
    }
    
    public ArrayList<ChiTietHoaDonDTO> timKiemTheoMaSanPham(int masp) {
        ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<>();
        String query = "select * from cthd where MASP = ?";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, masp);
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
        } catch (Exception e) {
        } finally {
            DBConnect.closeConnection(conn);
        }
        return ds;
    }
    
    public ArrayList<ChiTietHoaDonDTO> timKiemTheoCaHaiMa(int mahd, int masp) {
        ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<>();
        String query = "select * from cthd where MAHD = ? AND MASP = ?";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, mahd);
            st.setInt(2, masp);
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
        } catch (Exception e) {
        } finally {
            DBConnect.closeConnection(conn);
        }
        return ds;
    }
    
    public ArrayList<ChiTietHoaDonDTO> timKiemTheoSoLuong(int soluong) {
        ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<>();
        String query = "select * from cthd where SL >= ?";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, soluong);
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
        } catch (Exception e) {
        } finally {
            DBConnect.closeConnection(conn);
        }
        return ds;
    } 
    
    public ArrayList<ChiTietHoaDonDTO> timKiemTheoDonGia(int min, int max) {
        ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<>();
        String query = "select * from cthd where DONGIA BETWEEN ? AND ?";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, min);
            st.setInt(2, max);
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
        } catch (Exception e) {
        } finally {
            DBConnect.closeConnection(conn);
        }
        return ds;
    } 
    
    public ArrayList<ChiTietHoaDonDTO> timKiemTheoThanhTien(int thanhtien) {
        ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<>();
        String query = "select * from cthd where THANHTIEN >= ?";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, thanhtien);
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
        } catch (Exception e) {
        } finally {
            DBConnect.closeConnection(conn);
        }
        return ds;
    } 
}
