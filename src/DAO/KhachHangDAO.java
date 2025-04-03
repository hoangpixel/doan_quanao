/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.KhachHangDTO;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author laptop
 */
public class KhachHangDAO {
    String user="root",pass="",url="jdbc:mysql://localhost:3306/doan_quanao";
    Connection con;
    Statement st;
    ResultSet rs;

    public KhachHangDAO() {
        if(con==null)
        {
            try {
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url,user,pass);
                
            } catch (Exception e) {
            }
        }
    }
public ArrayList<KhachHangDTO> DSKhachHangDTOs()
    {
        ArrayList ds = new ArrayList<KhachHangDTO>();
        try {
            String qry = "select * from khachhang";
            st = con.createStatement();
            rs = st.executeQuery(qry);
            while(rs.next())
            {
                KhachHangDTO kh = new KhachHangDTO();
                kh.setMaKH(rs.getInt(1));
                kh.setHoKH(rs.getString(2));
                kh.setSDT(rs.getString(3));
                kh.setDiaChi(rs.getString(4));
                kh.seteMail(rs.getString(5));
                ds.add(kh);
            }
        } catch (Exception e) {
        }
        return ds;
    }
    
    
    
    public void them(KhachHangDTO kh)
    {
        try {
            String qry = "Insert into khachhang (HOKH,TENKH,SDT,DIACHI,EMAIL) values (";
            qry = qry + "'" + kh.getHoKH() + "',";
            qry = qry + "'" + kh.getTenKH() + "'";
            qry = qry + "'" + kh.getSDT() + "',";
            qry = qry + "'" + kh.getDiaChi() + "',";
            qry = qry + "'" + kh.geteMail() + "',";
            qry = qry + ")";
            st = con.createStatement();
            st.executeUpdate(qry);
        } catch (Exception e) {
        }
    }
    
    public void xoa(int ma)
    {
        try {
            
            String qry = "Delete from khachhang where MAKH = '" + ma + "'";
            st = con.createStatement();
            st.executeUpdate(qry);
            
        } catch (Exception e) {
        }
    }
    
    
    public void sua(KhachHangDTO kh)
    {
        try {
            
        String qry = "Update khachhang Set ";
        qry = qry + " " + "HOKH=" + "'" + kh.getHoKH() + "'";
        qry = qry + ",TENKH=" + "'" + kh.getTenKH() + "'";
        qry = qry + ",SDT=" + "'" + kh.getSDT() + "'";
        qry = qry + ",DIACHI=" + "'" + kh.getDiaChi() + "'";
        qry = qry + ",EMAIL=" + "'" + kh.geteMail() + "'";
        qry = qry + " " + " where MAKH='" + kh.getMaKH() + "'";
            st = con.createStatement();
            st.executeUpdate(qry);            
        } catch (Exception e) {
        }
    }
}
