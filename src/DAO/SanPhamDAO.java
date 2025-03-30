
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
    
    // Trả về mã sản phẩm mới được tạo tự động
    public int themSanPham(SanPhamDTO sp) {
        // Câu lệnh thêm sản phẩm
        String query = "insert into sanpham (TENSP, DONGIA, DONVITINH, CHATLIEU, MOTA, MALOAI) values (?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        int maSP = -1;
        try {
            
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            st.setString(1, sp.getTenSP());
            st.setInt(2, sp.getDonGia());
            st.setString(3, sp.getDonViTinh());
            st.setString(4, sp.getChatLieu());
            st.setString(5, sp.getMoTa());
            st.setInt(6, sp.getMaLoai());
            
            int row = st.executeUpdate();
            
            if(row > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()) {
                    maSP = rs.getInt(1);
                }
                rs.close();
            }
            
            st.close();
            
        } catch (SQLException e) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);

        }
        finally {
            // Đóng kết nối
            DBConnect.closeConnection(conn);
        }
        return maSP;
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
            
            st.executeUpdate();
            
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);

        }
        finally {
            DBConnect.closeConnection(conn);
        }
    }
    
    public void xoaSanPham(int maSP) {
        String query = "delete from sanpham where MASP = ?";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
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
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            DBConnect.closeConnection(conn);
        }
    }
    
    public SanPhamDTO laySanPhamTheoMaSP (int maSP) {
        SanPhamDTO sp = null;
        String query = "select * from sanpham where MASP = ?";
        Connection conn = null;
        
        try {
            conn = DBConnect.getConnection();
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
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            DBConnect.closeConnection(conn);
        }
                
        return sp;
    }
    
    public ArrayList<SanPhamDTO> layTatCaSanPham() {
        ArrayList<SanPhamDTO> dssp = new ArrayList<>();
        String query = "select * from sanpham";
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
            rs.close();
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);

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
        } catch (SQLException e) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);

        }
        finally {
            try {
                st.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            try {
                rs.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            DBConnect.closeConnection(conn);
        }
        return false;
    }
    
}   
