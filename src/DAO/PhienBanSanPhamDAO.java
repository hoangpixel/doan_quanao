/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PhienBanSanPhamDTO;
import java.util.ArrayList;
import java.sql.*;
import config.DBConnect;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author laptop
 */
public class PhienBanSanPhamDAO {

    Connection con = null;
    PreparedStatement pstm = null;
    Statement st = null;
    ResultSet rs = null;

    public ArrayList<PhienBanSanPhamDTO> docDSPB() {
        ArrayList ds = new ArrayList<PhienBanSanPhamDTO>();
        try {
            String qry = "select * from phienbansp where is_deleted = 0";
            con = DBConnect.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(qry);
            while (rs.next()) {
                PhienBanSanPhamDTO pbsp = new PhienBanSanPhamDTO();
                pbsp.setMaPB(rs.getInt(1));
                pbsp.setMaSP(rs.getInt(2));
                pbsp.setSize(rs.getString(3));
                pbsp.setMau(rs.getString(4));
                pbsp.setSoLuong(rs.getInt(5));
                ds.add(pbsp);
            }
        } catch (Exception e) {
        }
        return ds;
    }

    public int thayDoiSLPB(int sl, int mapb) {
        int result = 0;
        try {
            String qry = "Update phienbansp set SLPB = SLPB + ? where MAPB = ?";
            con = DBConnect.getConnection();
            pstm = con.prepareStatement(qry);
            pstm.setInt(1, sl);
            pstm.setInt(2, mapb);
            result = pstm.executeUpdate();
        } catch (Exception e) {
        }
        return result;
    }

    public int themPBSP(PhienBanSanPhamDTO pbsp) {
        String query = "INSERT INTO phienbansp (MASP, SIZE, MAU, SLPB) values (?,?,?,?)";
        Connection conn = null;
        int mapb = -1;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            st.setInt(1, pbsp.getMaSP());
            st.setString(2, pbsp.getMau());
            st.setString(3, pbsp.getSize());
            st.setInt(4, 0);

            int row = st.executeUpdate();

            if (row > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    mapb = rs.getInt(1);
                }
                rs.close();
            }

            st.close();

        } catch (Exception e) {
            Logger.getLogger(PhienBanSanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            // Đóng kết nối
            DBConnect.closeConnection(conn);
        }
        return mapb;

    }

    public void suaPBSP(PhienBanSanPhamDTO pbsp) {
        String query = """
                       UPDATE phienbansp 
                       SET MASP = ?, SIZE = ?, MAU = ?, SLPB = ?
                       WHERE MAPB = ?; """;
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);

            st.setInt(1, pbsp.getMaSP());
            st.setString(2, pbsp.getSize());
            st.setString(3, pbsp.getMau());
            st.setInt(4, pbsp.getSoLuong());
            st.setInt(5, pbsp.getMaPB());  // Điều kiện WHERE

            st.executeUpdate();

            st.close();
        } catch (SQLException e) {
            Logger.getLogger(PhienBanSanPhamDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            DBConnect.closeConnection(conn);
        }

    }

    public void xoaPhienBanSanPham(int mapb) {
        String query = "UPDATE phienbansp SET is_deleted = 1 WHERE MAPB = ?";
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);

            st.setInt(1, mapb);

            int rows = st.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Đã xóa sản phẩm thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm để xóa.");
            }
            st.close();
        } catch (Exception e) {
        } finally {
            DBConnect.closeConnection(conn);
        }
    }
    
    public ArrayList<PhienBanSanPhamDTO> layPBSPTheoMaSP(int masp) {
        ArrayList<PhienBanSanPhamDTO> ds = new ArrayList<>();
        String query = """
                       SELECT * 
                       FROM phienbansp
                       WHERE MASP = ? AND is_deleted = 0
                       """;
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            
            st.setInt(1, masp);
            
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                PhienBanSanPhamDTO pbsp = new PhienBanSanPhamDTO();
                pbsp.setMaSP(masp);
                pbsp.setMaPB(rs.getInt("MAPB"));
                pbsp.setSize(rs.getString("SIZE"));
                pbsp.setMau(rs.getString("MAU"));
                pbsp.setSoLuong(rs.getInt("SLPB"));
                ds.add(pbsp);
            }
            rs.close();
            st.close();

        } catch (Exception e) {
        }
        finally{
            DBConnect.closeConnection(conn);
        }
        return ds;
    }

}
