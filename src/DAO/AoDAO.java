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
    // Thêm áo trả về mã loại
    public int them(AoDTO a) {
        String query = "insert into ao (TENAO) values (?)";
        Connection conn = null;
        int maloai = -1;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, a.getTenAo());
            
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
            Logger.getLogger(AoDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            DBConnect.closeConnection(conn);
        }
        return maloai;
    }
    
    public void sua(AoDTO a) {
        String query = """
                       update ao
                       set TENAO = ?
                       where MALOAI = ?
                       """;
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, a.getTenAo());
            st.setInt(2, a.getMaLoai());     // Điều kiện của where
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
        } finally {
            DBConnect.closeConnection(conn);
        }
    }
    
    public void xoa(int maao) {
        String query = "delete from ao where MALOAI = ?";
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
        } catch (Exception e) {
        } finally {
            DBConnect.closeConnection(conn);
        }
    }
    
    public AoDTO layAoTheoMa (int maao) {
        String query = "select * from ao where MALOAI = ?";
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
        } catch (Exception e) {
        } finally {
            DBConnect.closeConnection(conn);
        }
        return a;
    }
    
    public ArrayList<AoDTO> layTatCaAo () {
        ArrayList<AoDTO> ds = new ArrayList<>();
        String query = "select * from ao";
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
        } catch (Exception e) {
        } finally {
            DBConnect.closeConnection(conn);
        }
        return ds;
    }
    
    public ArrayList<AoDTO> timKiemTheoMa(int maloai) {
        ArrayList<AoDTO> ds = new ArrayList<>();
        String query = "select * from ao where MALOAI = ?";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, maloai);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                AoDTO a = new AoDTO();
                a.setMaLoai(rs.getInt("MALOAI"));
                a.setTenAo(rs.getString("TENAO"));
                ds.add(a);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
        } finally {
            DBConnect.closeConnection(conn);
        }
        return ds;
    }
    
    public ArrayList<AoDTO> timKiemTheoTenAo(String tenao) {
        ArrayList<AoDTO> ds = new ArrayList<>();
        // Kiểm tra nếu tenao null hoặc chuỗi rỗng thì return danh sách rỗng
        if (tenao == null || tenao.trim().isEmpty()) {
            return ds;
        }

        String query = "select * from ao where TENAO LIKE ?";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, "%" + tenao + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                AoDTO a = new AoDTO();
                a.setMaLoai(rs.getInt("MALOAI"));
                a.setTenAo(rs.getString("TENAO"));
                ds.add(a);
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
