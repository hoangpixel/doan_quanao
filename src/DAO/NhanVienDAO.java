/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.NhanVienDTO;
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
public class NhanVienDAO {
    // Thêm nhân viên trả về mã nhân viên
    public int them(NhanVienDTO nv) {
        String query = "insert into nhanvien (HO, TEN, LUONG, SDT, DIACHI, EMAIL) values (?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        int manv = -1;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, nv.getHo());
            st.setString(2, nv.getTen());
            st.setInt(3, nv.getLuong());
            st.setString(4, nv.getSDT());
            st.setString(5, nv.getDiaChi());
            st.setString(6, nv.getEmail());
            
            int row = st.executeUpdate();
            if(row > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()) {
                    manv = rs.getInt(1);
                }
                rs.close();
            }
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            DBConnect.closeConnection(conn);
        }
        return manv;
    }
    
    public void sua(NhanVienDTO nv) {
        String query = """
                       update nhanvien
                       set HO = ?, TEN = ?, LUONG = ?, SDT = ?, DIACHI = ?, EMAIL = ?
                       where MANV = ?
                       """;
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, nv.getHo());
            st.setString(2, nv.getTen());
            st.setInt(3, nv.getLuong());
            st.setString(4, nv.getSDT());
            st.setString(5, nv.getDiaChi());
            st.setString(6, nv.getEmail());
            st.setInt(7, nv.getMa());     // Điều kiện của where
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnect.closeConnection(conn);
        }
    }
    
    public void xoa(int manv) {
        String query = "delete from nhanvien where MANV = ?";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, manv);
            int rows = st.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Đã xóa nhân viên thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên để xóa.");
            }
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnect.closeConnection(conn);
        }
    }
    
    public NhanVienDTO layNhanVienTheoMa (int manv) {
        String query = "select * from nhanvien where MANV = ?";
        Connection conn = null;
        NhanVienDTO nv = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, manv);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                nv = new NhanVienDTO();
                nv.setMa(rs.getInt("MANV"));
                nv.setHo(rs.getString("HO"));
                nv.setTen(rs.getString("TEN"));
                nv.setLuong(rs.getInt("LUONG"));
                nv.setSDT(rs.getString("SDT"));
                nv.setDiaChi(rs.getString("DIACHI"));
                nv.setEmail(rs.getString("EMAIL"));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnect.closeConnection(conn);
        }
        return nv;
    }
    
    public ArrayList<NhanVienDTO> layTatCaNhanVien () {
        ArrayList<NhanVienDTO> ds = new ArrayList<>();
        String query = "select * from nhanvien";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                NhanVienDTO nv = new NhanVienDTO();
                nv.setMa(rs.getInt("MANV"));
                nv.setHo(rs.getString("HO"));
                nv.setTen(rs.getString("TEN"));
                nv.setLuong(rs.getInt("LUONG"));
                nv.setSDT(rs.getString("SDT"));
                nv.setDiaChi(rs.getString("DIACHI"));
                nv.setEmail(rs.getString("EMAIL"));
                ds.add(nv);
            }
            
            rs.close();
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnect.closeConnection(conn);
        }
        return ds;
    }
}
