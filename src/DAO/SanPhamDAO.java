
package DAO;

import DTO.SanPhamDTO;
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
public class SanPhamDAO {

    public void themSanPham(SanPhamDTO sp) {
        // Câu lệnh thêm sản phẩm
        String query = "insert into sanpham (TENSP, DONGIA, DONVITINH, CHATLIEU, MOTA, MALOAI) values (?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        try {
            
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            
            st.setString(1, sp.getTenSP());
            st.setInt(2, sp.getDonGia());
            st.setString(3, sp.getDonViTinh());
            st.setString(4, sp.getChatLieu());
            st.setString(5, sp.getMoTa());
            st.setInt(6, sp.getMaLoai());
            
            st.executeUpdate();
            
            st.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi thêm: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            // Đóng kết nối
            DBConnect.closeConnection(conn);
        }
    }
    
    public void suaSanPham(SanPhamDTO sp) {
        String query = """
                       UPDATE sanpham 
                       SET TENSP = ?, DONGIA = ?, DONVITINH = ?, CHATLIEU = ?, MOTA = ?, MALOAI = ? 
                       WHERE MASP = ?; """;
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            
            st.setString(1, sp.getTenSP());
            st.setInt(2, sp.getDonGia());
            st.setString(3, sp.getDonViTinh());
            st.setString(4, sp.getChatLieu());
            st.setString(5, sp.getMoTa());
            st.setInt(6, sp.getMaLoai());
            st.setInt(7, sp.getMaSP());  // Điều kiện WHERE
            
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi sửa: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            DBConnect.closeConnection(conn);
        }
    }
    
    public void xoaSanPham(int maSP) {
        String query = "delete from sanpham where MASP = ?";
        Connection conn = null;
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, maSP);
            
            int rows = st.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Đã xóa sản phẩm thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm để xóa.");
            }
            st.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi xóa: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        } finally {
            DBConnect.closeConnection(conn);
        }
    }
    
    public SanPhamDTO laySanPhamTheoMaSP (int maSP) {
        SanPhamDTO sp = null;
        String query = "select * from sanpham where MASP = ?";
        Connection conn = null;
        
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, maSP);
            
            ResultSet rs = st.executeQuery();
            if (rs.next()) {   
                sp = new SanPhamDTO();
                sp.setMaSP(rs.getInt("MASP"));
                sp.setTenSP(rs.getString("TENSP"));
                sp.setDonGia(rs.getInt("DONGIA"));
                sp.setDonViTinh(rs.getString("DONVITINH"));
                sp.setChatLieu(rs.getString("CHATLIEU"));
                sp.setMoTa(rs.getString("MOTA"));
                sp.setMaLoai(rs.getInt("MALOAI"));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn sản phẩm: " + e.getMessage(),
                "Lỗi", JOptionPane.ERROR_MESSAGE);
        } finally {
            DBConnect.closeConnection(conn);
        }
                
        return sp;
    }
    
    public ArrayList<SanPhamDTO> layTatCaSanPham() {
        ArrayList<SanPhamDTO> dssp = new ArrayList<>();
        String query = "selct * from sanpham";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()) {
                SanPhamDTO sp = new SanPhamDTO();
                sp.setMaSP(rs.getInt("MASP"));
                sp.setTenSP(rs.getString("TENSP"));
                sp.setDonGia(rs.getInt("DONGIA"));
                sp.setDonViTinh(rs.getString("DONVITINH"));
                sp.setChatLieu(rs.getString("CHATLIEU"));
                sp.setMoTa(rs.getString("MOTA"));
                sp.setMaLoai(rs.getInt("MALOAI"));
                
                dssp.add(sp);
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn sản phẩm: " + e.getMessage(),
                "Lỗi", JOptionPane.ERROR_MESSAGE);
        } finally {
            DBConnect.closeConnection(conn);
        }
        
        return dssp;
    }
    
    public boolean kiemTraTonTai(int maSP) {
        String query = "select * from sanpham where MASP = ?";
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = DBConnect.getConnection();
            st = conn.prepareStatement(query);
            st.setInt(1, maSP);
            rs = st.executeQuery();
            
            if(rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            DBConnect.closeConnection(conn);
        }
        return false;
    }
    
}   
