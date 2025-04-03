/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.util.ArrayList;
import java.sql.*;
import DTO.ChuongTrinhKhuyenMaiSanPhamDTO;
import config.DBConnect;
/**
 *
 * @author mhoang
 */
public class ChuongTrinhKhuyenMaiSanPhamDAO {
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;

    
    public ArrayList<ChuongTrinhKhuyenMaiSanPhamDTO> docDSCTKMSP()
    {
        ArrayList ds = new ArrayList<ChuongTrinhKhuyenMaiSanPhamDTO>();
        try {
        String qry = "select * from ctkmsp";
        con = DBConnect.getConnection();      
        st = con.createStatement();
        rs = st.executeQuery(qry);
        while(rs.next())
        {
            ChuongTrinhKhuyenMaiSanPhamDTO ct = new ChuongTrinhKhuyenMaiSanPhamDTO();
            ct.setMactkm(rs.getInt("MACTKM"));
            ct.setMactkmsp(rs.getInt("MACTKMSP"));
            ct.setMasp(rs.getInt("MASP"));
            ct.setPtgg(rs.getInt("PTGG"));
            ds.add(ct);
        }
        } catch (Exception e) {
        }
        return ds;
    }
    
    public void them(ChuongTrinhKhuyenMaiSanPhamDTO ct)
    {
        try {
            String qry = "Insert into ctkmsp (MACTKM,MASP,PTGG) values (";
            qry = qry + "'" + ct.getMactkm() + "',";
            qry = qry + "'" + ct.getMasp() + "',";
            qry = qry + "'" + ct.getPtgg() + "'";
            qry = qry + ")";
            con = DBConnect.getConnection();
            st=con.createStatement();
            st.executeUpdate(qry);
        } catch (Exception e) {
        }
    }
    
    public void xoa(int maXoa)
    {
        try {
            String qry = "Delete from ctkmsp where MACTKMSP = '" + maXoa + "'";
            con = DBConnect.getConnection();
            st=con.createStatement();
            st.executeUpdate(qry);
        } catch (Exception e) {
        }
    }
    
public void capnhat(ChuongTrinhKhuyenMaiSanPhamDTO ct)
{
    try {
        String qry = "UPDATE ctkmsp SET " +
                     "MACTKM = " + ct.getMactkm() + ", " +
                     "MASP = " + ct.getMasp() + ", " +
                     "PTGG = " + ct.getPtgg() + 
                     " WHERE MACTKMSP = " + ct.getMactkmsp();
        con = DBConnect.getConnection();
        st = con.createStatement();
        st.executeUpdate(qry);
    } catch (Exception e) {
    }
}



}
