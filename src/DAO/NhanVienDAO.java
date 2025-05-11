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
        String query = "select * from nhanvien where is_deleted=0";
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
        String query = "insert into nhanvien (HO, TEN, LUONG, SDT, DIACHI, EMAIL, is_deleted) values (?, ?, ?, ?, ?, ?, 0)";
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
                       where MANV = ? AND is_deleted = 0
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
        String query = "Update nhanvien set is_deleted = 1 where MANV = ?";
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
        String query = "select * from nhanvien where MANV = ? AND is_deleted = 0";
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
    
    public ArrayList<Object[]> thongKeSoLuongTheoDiaChi() {
        ArrayList<Object[]> result = new ArrayList<>(); // Sử dụng ArrayList để linh hoạt
        String query = """
                   SELECT DIACHI, COUNT(*) AS SoLuongNhanVien
                   FROM nhanvien
                   WHERE is_deleted = 0
                   GROUP BY DIACHI
                   ORDER BY SoLuongNhanVien DESC -- (Tùy chọn: Sắp xếp theo số lượng giảm dần)
                   """;
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                result.add(new Object[] {
                    rs.getString("DIACHI"),
                    rs.getInt("SoLuongNhanVien") // Lấy số lượng nhân viên
                });
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
        // Ghi log lỗi cụ thể hơn
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, "Lỗi khi thống kê số lượng nhân viên theo địa chỉ", e);
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
                       WHERE YEAR(STR_TO_DATE(NGAYNHAP, '%d/%m/%Y')) = ? AND nhanvien.is_deleted = 0
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
