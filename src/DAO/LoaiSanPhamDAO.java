/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import DTO.LoaiSanPhamDTO;
import DTO.NhanVienDTO;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author suvie
 */
public class LoaiSanPhamDAO {
    String user = "root";
    String password = "";
    String url;
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    
    LoaiSanPhamDAO() {
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
    ArrayList docLSP() {
        ArrayList dslsp = new ArrayList <LoaiSanPhamDTO>();
        try {
            String qry = "select * from loaisp";
            st = conn.createStatement();
            rs = st.executeQuery(qry);
            while(rs.next()) {
                LoaiSanPhamDTO lsp = new LoaiSanPhamDTO();
                lsp.setMaLoai(rs.getInt(1));
                lsp.setTenLoai(rs.getString(2));
                dslsp.add(lsp);
            }
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin nhân viên!");
        }
        return dslsp;
    }
    
    void them(LoaiSanPhamDTO lsp) {
        try {
            String qry = "Insert into loaisp values(";
            qry = qry + "'" + lsp.getMaLoai() + "'";
            qry = qry + "," + "'" + lsp.getTenLoai() + "'";
            qry = qry + ")";
            st = conn.createStatement();
            st.executeUpdate(qry);
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin loại sản phẩm!");
        }
    }
    
    void xoa(String ma) {
        try {
            String qry = "Delete from nhanvien where MANV = '" + ma + "'";
            st = conn.createStatement();
            st.executeUpdate(qry);
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi xóa nhân viên!");
        }
    }
    
    void sua(NhanVienDTO nv) {
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
