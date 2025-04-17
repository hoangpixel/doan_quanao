/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.LoaiSanPhamDTO;
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
public class LoaiSanPhamDAO {
    
    public ArrayList<LoaiSanPhamDTO> docDSLSP() {
        ArrayList<LoaiSanPhamDTO> ds = new ArrayList<>();
        String query = "select * from loaisp";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                LoaiSanPhamDTO lsp = new LoaiSanPhamDTO();
                lsp.setMaLoai(rs.getInt("MALOAI"));
                lsp.setTenLoai(rs.getString("TENLOAI"));
                ds.add(lsp);
            }
            
            rs.close();
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnect.closeConnection(conn);
        }
        return ds;
    }
    
    public int them(LoaiSanPhamDTO lsp) {
        String query = "insert into loaisp (TENLOAI) values (?)";
        Connection conn = null;
        int maloai = -1;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, lsp.getTenLoai());
            
            int row = st.executeUpdate();
            if(row > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()) {
                    maloai = rs.getInt(1);
                }
                rs.close();
            }
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            DBConnect.closeConnection(conn);
        }
        return maloai;
    }
    
    public void sua(LoaiSanPhamDTO lsp) {
        String query = """
                       update loaisp
                       set TENLOAI = ?
                       where MALOAI = ?
                       """;
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, lsp.getTenLoai());
            st.setInt(2, lsp.getMaLoai());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnect.closeConnection(conn);
        }
    }
    
    public void xoa(int ma) {
        String query = "delete from loaisp where MALOAI = ?";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, ma);
            int rows = st.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Đã xóa loại sản phẩm thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy loại sản phẩm để xóa.");
            }
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnect.closeConnection(conn);
        }
    }
    
    public LoaiSanPhamDTO layLSPTheoMaLoai(int maloai) {
        String query = "select * from loaisp where MALOAI = ?";
        Connection conn = null;
        LoaiSanPhamDTO lsp = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, maloai);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                lsp = new LoaiSanPhamDTO();
                lsp.setMaLoai(rs.getInt("MALOAI"));
                lsp.setTenLoai(rs.getString("TENLOAI"));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnect.closeConnection(conn);
        }
        return lsp;
    }
}
