/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChuongTrinhKhuyenMaiHoaDonDTO;
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
public class ChuongTrinhKhuyenMaiHoaDonDAO {
    
    // Thêm chương trình khuyến mãi hóa đơn trả về mã chi tiết khuyến mãi hóa đơn
    public int themCTKMHD(ChuongTrinhKhuyenMaiHoaDonDTO ctkmhd) {
        String query = "insert into ctkmhd (MACTKM, TONGTIENHD, PTGG) values (?, ?, ?)";
        Connection conn = null;
        int maCTKMHD = -1;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, ctkmhd.getMaCTKM());
            st.setInt(2, ctkmhd.getSoTienHD());
            st.setInt(3, ctkmhd.getPhanTramGiamGia());
            
            int row = st.executeUpdate();
            if(row > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()) {
                    maCTKMHD = rs.getInt(1);
                }
                rs.close();
            }
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            DBConnect.closeConnection(conn);
        }
        return maCTKMHD;
    }
    
    public void suaCTKMHD(ChuongTrinhKhuyenMaiHoaDonDTO ctkmhd) {
        String query = """
                       update ctkmhd
                       set MACTKM = ?, TONGTIENHD = ?, PTGG = ?
                       where CTKMHD = ?
                       """;
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, ctkmhd.getMaCTKM());
            st.setInt(2, ctkmhd.getSoTienHD());
            st.setInt(3, ctkmhd.getPhanTramGiamGia());
            st.setInt(4, ctkmhd.getMaCTKMHD());     // Điều kiện của where
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
        } finally {
            DBConnect.closeConnection(conn);
        }
    }
    
    public void xoaCTKMHD (int ma) {
        String query = "delete from ctkmhd where MACTKMHD = ?";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, ma);
            int rows = st.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Đã xóa chương trình khuyến mãi hóa đơn thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy chương trình khuyến mãi hóa đơn để xóa.");
            }
            st.close();
        } catch (Exception e) {
        } finally {
            DBConnect.closeConnection(conn);
        }
    }
    
    public ChuongTrinhKhuyenMaiHoaDonDTO layCTKMHDTheoMa (int maCTKMHD) {
        String query = "select * from ctkmhd where MACTKMHD = ?";
        Connection conn = null;
        ChuongTrinhKhuyenMaiHoaDonDTO ctkmhd = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, maCTKMHD);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                ctkmhd = new ChuongTrinhKhuyenMaiHoaDonDTO();
                ctkmhd.setMaCTKM(rs.getInt("MACTKM"));
                ctkmhd.setMaCTKMHD(rs.getInt("MACTKMHD"));
                ctkmhd.setSoTienHD(rs.getInt("TONGTIENHD"));
                ctkmhd.setPhanTramGiamGia(rs.getInt("PTGG"));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
        } finally {
            DBConnect.closeConnection(conn);
        }
        return ctkmhd;
    }
    
    public ArrayList<ChuongTrinhKhuyenMaiHoaDonDTO> layTatCaCTKMHD () {
        ArrayList<ChuongTrinhKhuyenMaiHoaDonDTO> ds = new ArrayList<>();
        String query = "select * from ctkmhd";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                ChuongTrinhKhuyenMaiHoaDonDTO ctkmhd = new ChuongTrinhKhuyenMaiHoaDonDTO();
                ctkmhd.setMaCTKM(rs.getInt("MACTKM"));
                ctkmhd.setMaCTKMHD(rs.getInt("MACTKMHD"));
                ctkmhd.setSoTienHD(rs.getInt("TONGTIENHD"));
                ctkmhd.setPhanTramGiamGia(rs.getInt("PTGG"));
                ds.add(ctkmhd);
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
