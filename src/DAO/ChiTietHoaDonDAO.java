/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.ChiTietHoaDonDTO;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author suvie
 */
public class ChiTietHoaDonDAO {
    String user = "root";
    String password = "";
    String url;
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    
    public ChiTietHoaDonDAO() {
        this.url = "jdbc:mysql://localhost:3306/java_quanao";
        if(conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, password);
            }
            catch(ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Lỗi kết nối database!");
            }
            catch(SQLException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi kết nối database!");
            }
        }
    }
    public ArrayList<ChiTietHoaDonDTO> docDSCTHD() {
        ArrayList dscthd = new ArrayList <ChiTietHoaDonDTO>();
        try {
            String qry = "select * from cthd";
            st = conn.createStatement();
            rs = st.executeQuery(qry);
            while(rs.next()) {
                ChiTietHoaDonDTO cthd = new ChiTietHoaDonDTO();
                cthd.setMaHoaDon(rs.getInt(1));
                cthd.setMaSanPham(rs.getInt(2));
                cthd.setSoLuong(rs.getInt(3));
                cthd.setDonGia(rs.getInt(4));
                dscthd.add(cthd);
            }
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin chi tiết hóa đơn!");
        }
        return dscthd;
    }
    
    public void them(ChiTietHoaDonDTO cthd) {
        try {
            String qry = "Insert into cthd values(";
            qry = qry + "'" + cthd.getMaHoaDon() + "'";
            qry = qry + "," + "'" + cthd.getMaSanPham() + "'";
            qry = qry + "," + "'" + cthd.getSoLuong() + "'";
            qry = qry + "," + "'" + cthd.getDonGia() + "'";
            qry = qry + "," + "'" + cthd.getThanhTien() + "'";
            qry = qry + ")";
            st = conn.createStatement();
            st.executeUpdate(qry);
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin chi tiết hóa đơn!");
        }
    }
    
    public void xoa(int mahd, int masp) {
        try {
            String qry = "Delete from cthd where MAHD = '" + mahd + "' and MASP = '" + masp + "'";
            st = conn.createStatement();
            st.executeUpdate(qry);
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi xóa chi tiết hóa đơn!");
        }
    }
    
    public void sua(ChiTietHoaDonDTO cthd) {
        try {
            String qry = "Update cthd Set";
            qry = qry + " " + "SL=" + "'" + cthd.getSoLuong() + "'";
            qry = qry + ",DONGIA=" + "'" + cthd.getDonGia() + "'";
            qry = qry + ",THANHTIEN=" + "'" + cthd.getThanhTien() + "'";
            qry = qry + " " + " where MAHD='" + cthd.getMaHoaDon() + "' and MASP = '" + cthd.getMaSanPham() + "'";
            st = conn.createStatement();
            st.executeUpdate(qry);
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi sửa chi tiết hóa đơn!");
        }
    }
}
