/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.NhanVienDTO;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author suvie
 */
public class NhanVienDAO {
    String user = "root";
    String password = "";
    String url;
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    
    public NhanVienDAO() {
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
    public ArrayList<NhanVienDTO> docDSNV() {
        ArrayList dsnv = new ArrayList <NhanVienDTO>();
        try {
            String qry = "select * from nhanvien";
            st = conn.createStatement();
            rs = st.executeQuery(qry);
            while(rs.next()) {
                NhanVienDTO nv = new NhanVienDTO();
                nv.setMa(rs.getInt(1));
                nv.setHo(rs.getString(2));
                nv.setTen(rs.getString(3));
                nv.setLuong(rs.getInt(4));
                nv.setSDT(rs.getString(5));
                nv.setDiaChi(rs.getString(6));
                nv.setEmail(rs.getString(7));
                dsnv.add(nv);
            }
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin nhân viên!");
        }
        return dsnv;
    }
    
    public void them(NhanVienDTO nv) {
        try {
            String qry = "Insert into nhanvien values(";
            qry = qry + "'" + nv.getMa() + "'";
            qry = qry + "," + "'" + nv.getHo() + "'";
            qry = qry + "," + "'" + nv.getTen() + "'";
            qry = qry + "," + "'" + nv.getLuong() + "'";
            qry = qry + "," + "'" + nv.getSDT() + "'";
            qry = qry + "," + "'" + nv.getDiaChi() + "'";
            qry = qry + "," + "'" + nv.getEmail() + "'";
            qry = qry + ")";
            st = conn.createStatement();
            st.executeUpdate(qry);
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin nhân viên!");
        }
    }
    
    public void xoa(String ma) {
        try {
            String qry = "Delete from nhanvien where MANV = '" + ma + "'";
            st = conn.createStatement();
            st.executeUpdate(qry);
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi xóa nhân viên!");
        }
    }
    
    public void sua(NhanVienDTO nv) {
        try {
            String qry = "Update nhanvien Set";
            qry = qry + " " + "HO=" + "'" + nv.getHo() + "'";
            qry = qry + ",TEN=" + "'" + nv.getTen() + "'";
            qry = qry + ",LUONG=" + "'" + nv.getLuong() + "'";
            qry = qry + ",SDT=" + "'" + nv.getSDT() + "'";
            qry = qry + ",DIACHI=" + "'" + nv.getDiaChi() + "'";
            qry = qry + ",EMAIL=" + "'" + nv.getEmail() + "'";
            qry = qry + " " + " where MANV='" + nv.getMa() + "'";
            st = conn.createStatement();
            st.executeUpdate(qry);
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi sửa nhân viên!");
        }
    }
}
