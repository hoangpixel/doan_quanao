/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.util.ArrayList;
import java.sql.*;
import DTO.ChuongTrinhKhuyenMaiSanPhamDTO;
/**
 *
 * @author mhoang
 */
public class ChuongTrinhKhuyenMaiSanPhamDAO {
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    String user="root",pass="",url="jdbc:mysql://localhost:3306/java_quanao";
    public ChuongTrinhKhuyenMaiSanPhamDAO()
    {
        if(con==null)
        {
            try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pass);               
            } catch (Exception e) {
            }
        }
    }
    
    public ArrayList<ChuongTrinhKhuyenMaiSanPhamDTO> docDSCTKMSP()
    {
        ArrayList ds = new ArrayList<ChuongTrinhKhuyenMaiSanPhamDTO>();
        try {
        String qry = "select * from ctkmsp";
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
            st=con.createStatement();
            st.executeUpdate(qry);
        } catch (Exception e) {
        }
    }
    
    public void xoa(int maXoa)
    {
        try {
            String qry = "Delete from ctkmsp where MACTKMSP = '" + maXoa + "'";
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
        
        st = con.createStatement();
        st.executeUpdate(qry);
    } catch (Exception e) {
    }
}

}
