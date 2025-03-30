/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.NhaCungCapDTO;
import config.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Vinh
 */
public class NhaCungCapDAO {
    public void themNCC(NhaCungCapDTO ncc) {
        String query = "insert into ncc (TENNCC, SDTNCC, DIACHI) values (?, ?, ?)";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            
            st.setString(1, ncc.getTenNCC());
            st.setString(2, ncc.getSdtNCC());
            st.setString(3, ncc.getDiaChi());
            
            st.executeUpdate();
            
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            DBConnect.closeConnection(conn);
        }
    }
    
    public void suaNCC (NhaCungCapDTO ncc) {
        String query = """
                       update ncc
                       set TENNCC = ?, SDTNCC = ?, DIACHI = ?
                       where MANCC = ?;
                       """;
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            
            st.setString(1, ncc.getTenNCC());
            st.setString(2, ncc.getSdtNCC());
            st.setString(3, ncc.getDiaChi());
            st.setInt(4, ncc.getMaNCC());   // Điều kiện where
            
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            DBConnect.closeConnection(conn);
        }
    }
    
    public void xoaNCC (int maNCC) {
        String query = "delete from ncc where MANCC = ?";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, maNCC);
            int row = st.executeUpdate();
            
            if (row > 0) {
                JOptionPane.showMessageDialog(null, "Đã xóa sản phẩm thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm để xóa.");
            }
        } catch (SQLException e) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            DBConnect.closeConnection(conn);
        }
    }
    
    public NhaCungCapDTO layNCCTheoMaNCC (int maNCC) {
        NhaCungCapDTO ncc = new NhaCungCapDTO();
        String query = "select * from ncc where MANCC = ?";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, maNCC);
            
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                ncc.setMaNCC(rs.getInt("MANCC"));
                ncc.setTenNCC(rs.getString("TENNCC"));
                ncc.setSdtNCC(rs.getString("SDTNCC"));
                ncc.setDiaChi(rs.getString("DIACHI"));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            DBConnect.closeConnection(conn);
        }
        return ncc;
    }
    
    public ArrayList<NhaCungCapDTO> layTatCaNCC() {
        ArrayList<NhaCungCapDTO> dsncc = new ArrayList<>();
        String query = "select * from ncc";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                NhaCungCapDTO ncc = new NhaCungCapDTO();
                ncc.setMaNCC(rs.getInt("MANCC"));
                ncc.setTenNCC(rs.getString("TENNCC"));
                ncc.setSdtNCC(rs.getString("SDTNCC"));
                ncc.setDiaChi(rs.getString("DIACHI"));
                dsncc.add(ncc);
            }
            rs.close();
            st.close();
            
        } catch (SQLException e) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            DBConnect.closeConnection(conn);
        }
        return dsncc;
    }
}
