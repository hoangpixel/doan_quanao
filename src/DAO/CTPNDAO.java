/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.CTPNDTO;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author laptop
 */
public class CTPNDAO {
    String user="root",pass="",url="jdbc:mysql://localhost:3306/doan_quanao";
    Connection con;
    Statement st;
    ResultSet rs;

    public CTPNDAO() {
        if(con==null)
        {
            try {
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url,user,pass);
                
            } catch (Exception e) {
            }
        }
    }
public ArrayList<CTPNDTO> DSCTPNDAOs()
    {
        ArrayList ds = new ArrayList<CTPNDTO>();
        try {
            String qry = "select * from ctpn";
            st = con.createStatement();
            rs = st.executeQuery(qry);
            while(rs.next())
            {
                CTPNDTO ctpn = new CTPNDTO();
                ctpn.setMaPN(rs.getInt(1));
                ctpn.setMaSP(rs.getInt(2));
                ctpn.setSoLuong(rs.getInt(3));
                ctpn.setDonGia(rs.getInt(4));
                ctpn.setThanhTien(rs.getInt(5));
                ds.add(ctpn);
            }
        } catch (Exception e) {
        }
        return ds;
    }
    
    
    
    public void them(CTPNDTO ctpn)
    {
        try {
            String qry = "Insert into ctpn (SOLUONG,DONGIA,THANHTIEN) values (";
            qry = qry + "'" + ctpn.getSoLuong() + "',";
            qry = qry + "'" + ctpn.getDonGia() + "',";
            qry = qry + "'" + ctpn.getThanhTien() + "'";
            qry = qry + ")";
            st = con.createStatement();
            st.executeUpdate(qry);
        } catch (Exception e) {
        }
    }
    
    
    public void sua(CTPNDTO ctpn)
    {
        try {
            
        String qry = "Update ctpn Set ";
        qry = qry + " " + "SOLUONG=" + "'" + ctpn.getSoLuong() + "'";
        qry = qry + ",DONGIA=" + "'" + ctpn.getDonGia() + "'";
        qry = qry + ",THANHTIEN=" + "'" + ctpn.getThanhTien() + "'";
        qry = qry + " " + " where MAPN='" + ctpn.getMaPN() + "'";
            st = con.createStatement();
            st.executeUpdate(qry);            
        } catch (Exception e) {
        }
    }
}
