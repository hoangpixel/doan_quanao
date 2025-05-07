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
    
    public ArrayList<NhanVienDTO> docDSNV() {
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
            st.setInt(7, nv.getMa());
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
    
    public NhanVienDTO layNhanVienTheoMa(int manv) {
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
    
    public Object[] thongKeTheoDiaChi() {
        Object[] result = new Object[10]; // Adjust size based on unique addresses
        String query = """
                       SELECT DIACHI, SUM(LUONG) AS TongLuong
                       FROM nhanvien
                       GROUP BY DIACHI
                       """;
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            int index = 0;
            while (rs.next() && index < result.length) {
                result[index] = new Object[] { rs.getString("DIACHI"), rs.getInt("TongLuong") };
                index++;
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnect.closeConnection(conn);
        }
        return result;
    }
    
    // Lấy thời gian từ phiếu nhập
    public ArrayList<Object[]> thongKeLuongTheoQuyNam(int nam) {
        ArrayList<Object[]> ds = new ArrayList<>();
        String query = """
                       SELECT 
                           CASE 
                               WHEN QUARTER(STR_TO_DATE(NGAYNHAP, '%d/%m/%Y')) = 1 THEN 'Quý 1'
                               WHEN QUARTER(STR_TO_DATE(NGAYNHAP, '%d/%m/%Y')) = 2 THEN 'Quý 2'
                               WHEN QUARTER(STR_TO_DATE(NGAYNHAP, '%d/%m/%Y')) = 3 THEN 'Quý 3'
                               WHEN QUARTER(STR_TO_DATE(NGAYNHAP, '%d/%m/%Y')) = 4 THEN 'Quý 4'
                           END AS Quy,
                           SUM(LUONG) AS TongLuong
                       FROM nhanvien
                       JOIN phieunhap ON nhanvien.MANV = phieunhap.MANV
                       WHERE YEAR(STR_TO_DATE(NGAYNHAP, '%d/%m/%Y')) = ?
                       GROUP BY 
                           CASE 
                               WHEN QUARTER(STR_TO_DATE(NGAYNHAP, '%d/%m/%Y')) = 1 THEN 'Quý 1'
                               WHEN QUARTER(STR_TO_DATE(NGAYNHAP, '%d/%m/%Y')) = 2 THEN 'Quý 2'
                               WHEN QUARTER(STR_TO_DATE(NGAYNHAP, '%d/%m/%Y')) = 3 THEN 'Quý 3'
                               WHEN QUARTER(STR_TO_DATE(NGAYNHAP, '%d/%m/%Y')) = 4 THEN 'Quý 4'
                           END
                       """;
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, nam);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[2];
                row[0] = rs.getString("Quy");
                row[1] = rs.getInt("TongLuong");
                ds.add(row);
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
