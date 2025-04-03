/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.PhieuNhapDTO;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author laptop
 */
public class PhieuNhapDAO {
    String user="root",pass="",url="jdbc:mysql://localhost:3306/doan_quanao";
    Connection con;
    Statement st;
    ResultSet rs;

    public PhieuNhapDAO() {
        if(con==null)
        {
            try {
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url,user,pass);
                
            } catch (Exception e) {
            }
        }
    }
public ArrayList<PhieuNhapDTO> DSPhieuNhapDTOs()
    {
        ArrayList ds = new ArrayList<PhieuNhapDTO>();
        try {
            String qry = "select * from phieunhap";
            st = con.createStatement();
            rs = st.executeQuery(qry);
            while(rs.next())
            {
                PhieuNhapDTO pn = new PhieuNhapDTO();
                pn.setMaPN(rs.getInt(1));
                pn.setMaNV(rs.getInt(2));
                pn.setMaNCC(rs.getInt(3));
                pn.setTongTien(rs.getInt(4));
                pn.setNgayNhap(rs.getString(5));
                ds.add(pn);
            }
        } catch (Exception e) {
        }
        return ds;
    }
    
    
    
    public void them(PhieuNhapDTO pn)
    {
        try {
            String qry = "Insert into phieunhap (TONGTIEN,NGAYNHAP) values (";
            qry = qry + "'" + pn.getTongTien() + "',";
            qry = qry + "'" + pn.getNgayNhap() + "'";
            qry = qry + ")";
            st = con.createStatement();
            st.executeUpdate(qry);
        } catch (Exception e) {
        }
    }
    
    public void xoa(int ma)
    {
        try {
            
            String qry = "Delete from phieunhap where MAPN = '" + ma + "'";
            st = con.createStatement();
            st.executeUpdate(qry);
            
        } catch (Exception e) {
        }
    }
    
    
    public void sua(PhieuNhapDTO pn)
    {
        try {
            
        String qry = "Update phieunhap Set ";
        qry = qry + " " + "TONGTIEN=" + "'" + pn.getTongTien() + "'";
        qry = qry + ",NGAYNHAP=" + "'" + pn.getNgayNhap() + "'";
        qry = qry + " " + " where MAPN='" + pn.getMaPN() + "'";
            st = con.createStatement();
            st.executeUpdate(qry);            
        } catch (Exception e) {
        }
    }
}
