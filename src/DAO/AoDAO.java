/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.AoDTO;
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
public class AoDAO {
    
    public ArrayList<AoDTO> docDSA() {
        ArrayList<AoDTO> ds = new ArrayList<>();
        String query = "select * from ao where is_deleted=0";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                AoDTO a = new AoDTO();
                a.setMaLoai(rs.getInt("MALOAI"));
                a.setTenAo(rs.getString("TENAO"));
                ds.add(a);
            }
            
            rs.close();
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(AoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnect.closeConnection(conn);
        }
        return ds;
    }
    
    public int them(AoDTO a) {
        Connection conn = null;
        int maloai = -1;
        try {
            conn = DBConnect.getConnection();
            conn.setAutoCommit(false);
            String query = "insert into ao (MALOAI, TENAO, is_deleted) values (?, ?, 0)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, a.getMaLoai());
            st.setString(2, a.getTenAo());
            
            int row = st.executeUpdate();
            if (row > 0) {
                maloai = a.getMaLoai();
                conn.commit();
            }
            else
                conn.rollback();
        } catch (SQLException e) {
            Logger.getLogger(AoDAO.class.getName()).log(Level.SEVERE, null, e);
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return -1;
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    DBConnect.closeConnection(conn);
                }
            } catch (SQLException e) {
                Logger.getLogger(AoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return maloai;
    }
    
    public void sua(AoDTO a) {
        String query = """
                       update ao
                       set TENAO = ?
                       where MALOAI = ? AND is_deleted = 0
                       """;
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, a.getTenAo());
            st.setInt(2, a.getMaLoai());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(AoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnect.closeConnection(conn);
        }
    }
    
    public void xoa(int maao) {
        String query = "Update ao set is_deleted = 1 where MALOAI = ?";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, maao);
            int rows = st.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Đã xóa áo thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy áo để xóa.");
            }
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(AoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnect.closeConnection(conn);
        }
    }
    
    public AoDTO layAoTheoMa(int maao) {
        String query = "select * from ao where MALOAI = ? AND is_deleted = 0";
        Connection conn = null;
        AoDTO a = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, maao);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                a = new AoDTO();
                a.setMaLoai(rs.getInt("MALOAI"));
                a.setTenAo(rs.getString("TENAO"));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(AoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnect.closeConnection(conn);
        }
        return a;
    }
    
    
}
