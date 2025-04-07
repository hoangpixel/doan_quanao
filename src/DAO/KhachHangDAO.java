/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.KhachHangDTO;
import config.DBConnect;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author laptop
 */
public class KhachHangDAO {
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
public ArrayList<KhachHangDTO> DSKhachHangDTOs()
    {
        ArrayList ds = new ArrayList<KhachHangDTO>();
        try {
            String qry = "select * from khachhang";
            con = DBConnect.getConnection();
            st = con.createStatement();            
            rs = st.executeQuery(qry);
            while(rs.next())
            {
                KhachHangDTO kh = new KhachHangDTO();
                kh.setMaKH(rs.getInt(1));
                kh.setHoKH(rs.getString(2));
                kh.setTenKH(rs.getString(3));
                kh.setSDT(rs.getString(4));
                kh.setDiaChi(rs.getString(5));
                kh.seteMail(rs.getString(6));
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
            qry = qry + "'" + kh.getTenKH() + "',";
            qry = qry + "'" + kh.getSDT() + "',";
            qry = qry + "'" + kh.getDiaChi() + "',";
            qry = qry + "'" + kh.geteMail() + "'";
            qry = qry + ")";
            con = DBConnect.getConnection();
            st = con.createStatement();
            st.executeUpdate(qry);
        } catch (Exception e) {
        }
    }
    
    public void xoa(int ma)
    {
        try {
            
            String qry = "Delete from khachhang where makh = '" + ma + "'";
            con = DBConnect.getConnection();  
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
        con = DBConnect.getConnection(); 
        st = con.createStatement();
        st.executeUpdate(qry);            
        } catch (Exception e) {
        }
    }
}
