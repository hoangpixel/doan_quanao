/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.CTPNDTO;
import java.util.ArrayList;
import java.sql.*;
import config.DBConnect;
/**
 *
 * @author laptop
 */
public class CTPNDAO {
    Connection con;
    Statement st;
    ResultSet rs;
public ArrayList<CTPNDTO> DSCTPNDAOs()
    {
        ArrayList ds = new ArrayList<CTPNDTO>();
        try {
            String qry = "select * from ctpn";
            con = DBConnect.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(qry);
            while(rs.next())
            {
                CTPNDTO ctpn = new CTPNDTO();
                ctpn.setMaPN(rs.getInt(1));
                ctpn.setMaSP(rs.getInt(2));
                ctpn.setMaPB(rs.getInt(3));
                ctpn.setSoLuong(rs.getInt(4));
                ctpn.setDonGia(rs.getInt(5));
                ctpn.setThanhTien(rs.getInt(6));
                ds.add(ctpn);
            }
        } catch (Exception e) {
        }
        return ds;
    }
    
    
    
    public boolean them(CTPNDTO ctpn)
    {
        try {
            String qry = "Insert into ctpn (MAPN,MASP,MAPB,SOLUONG,DONGIA,THANHTIEN) values (";
            qry = qry + "'" + ctpn.getMaPN() + "',";
            qry = qry + "'" + ctpn.getMaSP() + "',";
            qry = qry + "'" + ctpn.getMaPB() + "',";
            qry = qry + "'" + ctpn.getSoLuong() + "',";
            qry = qry + "'" + ctpn.getDonGia() + "',";
            qry = qry + "'" + ctpn.getThanhTien() + "'";
            qry = qry + ")";
            con = DBConnect.getConnection();
            st = con.createStatement();
            st.executeUpdate(qry);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
    public boolean sua(CTPNDTO ctpn)
    {
        try {
            
        String qry = "Update ctpn Set ";
        qry = qry + " " + "MASP=" + "'" + ctpn.getMaSP() + "'";
        qry = qry + ",MAPB=" + "'" + ctpn.getMaPB() + "'";
        qry = qry + ",SOLUONG=" + "'" + ctpn.getSoLuong() + "'";
        qry = qry + ",DONGIA=" + "'" + ctpn.getDonGia() + "'";
        qry = qry + ",THANHTIEN=" + "'" + ctpn.getThanhTien() + "'";
        qry = qry + " " + " where MAPN='" + ctpn.getMaPN() + "'";
        con = DBConnect.getConnection();
        st = con.createStatement();
        st.executeUpdate(qry);            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean xoa(int maPN)
    {
        try {
            String qry = "Delete from ctpn where MAPN = " + maPN;
            con = DBConnect.getConnection();
            st = con.createStatement();
            st.executeUpdate(qry);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
