/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.QuanDTO;
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
public class QuanDAO {
    
    public ArrayList<QuanDTO> docDSQ() {
        ArrayList<QuanDTO> ds = new ArrayList<>();
        String query = "select * from quan where is_deleted=0";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                QuanDTO q = new QuanDTO();
                q.setMaLoai(rs.getInt("MALOAI"));
                q.setTenQuan(rs.getString("TENQUAN"));
                ds.add(q);
            }
            
            rs.close();
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(QuanDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnect.closeConnection(conn);
        }
        return ds;
    }
    
    public int them(QuanDTO q) {
        Connection conn = null;
        int maloai = -1;
        try {
            conn = DBConnect.getConnection();
            conn.setAutoCommit(false);
            String query = "insert into quan (MALOAI, TENQUAN, is_deleted) values (?, ?, 0)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, q.getMaLoai());
            st.setString(2, q.getTenQuan());
            
            int row = st.executeUpdate();
            if (row > 0) {
                maloai = q.getMaLoai();
                conn.commit();
            }
            else
                conn.rollback();
        } catch (SQLException e) {
            Logger.getLogger(QuanDAO.class.getName()).log(Level.SEVERE, null, e);
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                Logger.getLogger(QuanDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return -1;
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    DBConnect.closeConnection(conn);
                }
            } catch (SQLException e) {
                Logger.getLogger(QuanDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return maloai;
    }
    
    public void sua(QuanDTO q) {
        String query = """
                       update quan
                       set TENQUAN = ?
                       where MALOAI = ? AND is_deleted = 0
                       """;
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,q.getTenQuan());
            st.setInt(2, q.getMaLoai());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(QuanDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnect.closeConnection(conn);
        }
    }
    
    public void xoa(int maquan) {
        String query = "delete from quan where MALOAI = ?";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, maquan);
            int rows = st.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Đã xóa quần thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy quần để xóa.");
            }
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(QuanDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnect.closeConnection(conn);
        }
    }
    
    public QuanDTO layQuanTheoMa(int maloai) {
        String query = "select * from quan where MALOAI = ? AND is_deleted = 0";
        Connection conn = null;
        QuanDTO q = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, maloai);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                q = new QuanDTO();
                q.setMaLoai(rs.getInt("MALOAI"));
                q.setTenQuan(rs.getString("TENQUAN"));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(QuanDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnect.closeConnection(conn);
        }
        return q;
    }
}
