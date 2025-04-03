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
    // Thêm quần trả về mã loại
    public int them(QuanDTO a) {
        String query = "insert into quan (TENQUAN) values (?)";
        Connection conn = null;
        int maloai = -1;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, a.getTenQuan());
            
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
            Logger.getLogger(QuanDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            DBConnect.closeConnection(conn);
        }
        return maloai;
    }
    
    public void sua(QuanDTO q) {
        String query = """
                       update quan
                       set TENQUAN = ?
                       where MALOAI = ?
                       """;
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,q.getTenQuan());
            st.setInt(2, q.getMaLoai());     // Điều kiện của where
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
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
        } catch (Exception e) {
        } finally {
            DBConnect.closeConnection(conn);
        }
    }
    
    public QuanDTO layQuanTheoMa (int maquan) {
        String query = "select * from quan where MALOAI = ?";
        Connection conn = null;
        QuanDTO q = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, maquan);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                q = new QuanDTO();
                q.setMaLoai(rs.getInt("MALOAI"));
                q.setTenQuan(rs.getString("TENQUAN"));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
        } finally {
            DBConnect.closeConnection(conn);
        }
        return q;
    }
    
    public ArrayList<QuanDTO> layTatCaQuan () {
        ArrayList<QuanDTO> ds = new ArrayList<>();
        String query = "select * from quan";
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
        } catch (Exception e) {
        } finally {
            DBConnect.closeConnection(conn);
        }
        return ds;
    }
    
    public ArrayList<QuanDTO> timKiemTheoMa(int maloai) {
        ArrayList<QuanDTO> ds = new ArrayList<>();
        String query = "select * from quan where MALOAI = ?";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, maloai);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                QuanDTO q = new QuanDTO();
                q.setMaLoai(rs.getInt("MALOAI"));
                q.setTenQuan(rs.getString("TENQUAN"));
                ds.add(q);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
        } finally {
            DBConnect.closeConnection(conn);
        }
        return ds;
    }
    
    public ArrayList<QuanDTO> timKiemTheoTenQuan(String tenquan) {
        ArrayList<QuanDTO> ds = new ArrayList<>();
        // Kiểm tra nếu tenquan null hoặc chuỗi rỗng thì return danh sách rỗng
        if (tenquan == null || tenquan.trim().isEmpty()) {
            return ds;
        }

        String query = "select * from quan where TENQUAN LIKE ?";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, "%" + tenquan + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                QuanDTO q = new QuanDTO();
                q.setMaLoai(rs.getInt("MALOAI"));
                q.setTenQuan(rs.getString("TENQUAN"));
                ds.add(q);
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
