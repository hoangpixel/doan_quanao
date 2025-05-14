/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.ChiTietHoaDonDTO;
import config.DBConnect;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author suvie
 */
public class ChiTietHoaDonDAO {
    
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    public ArrayList<ChiTietHoaDonDTO> docDSCTHD()
    {
        ArrayList ds = new ArrayList<ChiTietHoaDonDTO>();
        try {
            String qry = "select * from cthd";
            con = DBConnect.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(qry);
            while(rs.next())
            {
                ChiTietHoaDonDTO cthd = new ChiTietHoaDonDTO();
                cthd.setMaHoaDon(rs.getInt(1));
                cthd.setMaSanPham(rs.getInt(2));
                cthd.setMaPhienBan(rs.getInt(3));
                cthd.setSoLuong(rs.getInt(4));
                cthd.setDonGia(rs.getInt(5));
                cthd.setThanhTien(rs.getInt(6));
                ds.add(cthd);
            }
        } catch (Exception e) {
        }
        return ds;
    }
    
    
    
    public boolean them(ChiTietHoaDonDTO cthd)
    {
        try {
            String qry = "Insert into cthd (MAHD,MASP,MAPB,SOLUONG,DONGIA,THANHTIEN) values (";
            qry = qry + "'" + cthd.getMaHoaDon() + "',";
            qry = qry + "'" + cthd.getMaSanPham() + "',";
            qry = qry + "'" + cthd.getMaPhienBan() + "',";
            qry = qry + "'" + cthd.getSoLuong() + "',";
            qry = qry + "'" + cthd.getDonGia() + "',";
            qry = qry + "'" + cthd.getThanhTien() + "'";
            qry = qry + ")";
            con = DBConnect.getConnection();
            st = con.createStatement();
            st.executeUpdate(qry);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
    public boolean sua(ChiTietHoaDonDTO cthd)
    {
        try {
            
        String qry = "Update cthd Set ";
        qry = qry + " " + "MASP=" + "'" + cthd.getMaSanPham() + "'";
        qry = qry + ",MAPB=" + "'" + cthd.getMaPhienBan() + "'";
        qry = qry + ",SOLUONG=" + "'" + cthd.getSoLuong() + "'";
        qry = qry + ",DONGIA=" + "'" + cthd.getDonGia() + "'";
        qry = qry + ",THANHTIEN=" + "'" + cthd.getThanhTien() + "'";
        qry = qry + " " + " where MAHD='" + cthd.getMaHoaDon() + "'";
        con = DBConnect.getConnection();
        st = con.createStatement();
        st.executeUpdate(qry);            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean xoa(int maHD)
    {
        try {
            String qry = "Delete from cthd where MAHD = " + maHD;
            con = DBConnect.getConnection();
            st = con.createStatement();
            st.executeUpdate(qry);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
