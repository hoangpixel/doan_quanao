/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import DTO.LoaiSanPhamDTO;
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
    
    public LoaiSanPhamDAO() {
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
    public ArrayList<LoaiSanPhamDTO> docLSP() {
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
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin loại sản phẩm!");
        }
        return dslsp;
    }
    
    public void them(LoaiSanPhamDTO lsp) {
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
    
    public void xoa(String ma) {
        try {
            String qry = "Delete from lsp where MALOAI = '" + ma + "'";
            st = conn.createStatement();
            st.executeUpdate(qry);
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi xóa loại sản phẩm!");
        }
    }
    
    public void sua(LoaiSanPhamDTO lsp) {
        try {
            String qry = "Update loaisp Set";
            qry = qry + " " + "HO=" + "'" + lsp.getTenLoai() + "'";
            qry = qry + " " + " where MALOAI='" + lsp.getMaLoai() + "'";
            st = conn.createStatement();
            st.executeUpdate(qry);
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi sửa loại sản phẩm!");
        }
    }
}
