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
            st.setInt(5, cthd.getMaSanPham());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnect.closeConnection(conn);
        }
    }
    
    public void xoa(int mahd, int masp) {
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
