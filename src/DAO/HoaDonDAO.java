/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
import DTO.HoaDonDTO;
import java.util.ArrayList;
import config.DBConnect;
/**
 *
 * @author mhoang
 */
public class HoaDonDAO {
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;

        public ArrayList<HoaDonDTO> docDSHD()
        {
            ArrayList ds = new ArrayList<HoaDonDTO>();
            try {
                
                String qry = "select * from hoadon";
                con = DBConnect.getConnection();
                st = con.createStatement();
                rs = st.executeQuery(qry);
                while(rs.next())
                {
                    HoaDonDTO hd = new HoaDonDTO();
                    hd.setMahd(rs.getInt("MAHD"));
                    hd.setNgaylap(rs.getString("NGAYLAP"));
                    hd.setManv(rs.getInt("MANV"));
                    hd.setMakh(rs.getInt("MAKH"));
                    hd.setTongtien(rs.getInt("TONGTIEN"));
                    ds.add(hd);
                }
                
            } catch (Exception e) {
                
            }
            return ds;
        }
        
        public void them(HoaDonDTO hd)
        {
            try {
                
            String qry = "Insert into hoadon (NGAYLAP,MANV,MAKH,TONGTIEN) values (";
            qry += "'" + hd.getNgaylap() + "',";
            qry += "'" + hd.getManv() + "',";
            qry += "'" + hd.getMakh() + "',";
            qry += "'" + hd.getTongtien() + "'";
            qry += ")";
            con = DBConnect.getConnection();            
            st = con.createStatement();
            st.execute(qry);
                
            } catch (Exception e) {
            }
        }
        
        public void xoa(int ma)
        {
            try {
                
                String qry = "Delete from hoadon where MAHD = " + ma;
                con = DBConnect.getConnection();
                st = con.createStatement();
                st.executeUpdate(qry);
                
            } catch (Exception e) {
            }
        }
        
        public void capnhat(HoaDonDTO hd)
        {
            try {
                
                String qry = "Update hoadon Set ";
                qry += " " + "NGAYLAP='" + hd.getNgaylap() + "'";
                qry += ",MANV='" + hd.getManv() + "'";
                qry += ",MAKH='" + hd.getMakh() + "'";
                qry += " Where MAHD='" + hd.getMahd() +"'";
                con = DBConnect.getConnection();
                st = con.createStatement();
                st.executeUpdate(qry);
            } catch (Exception e) {
            }
        }
        
}
