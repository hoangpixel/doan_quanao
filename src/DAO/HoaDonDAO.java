/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
import DTO.HoaDonDTO;
import java.util.ArrayList;
/**
 *
 * @author mhoang
 */
public class HoaDonDAO {
    String user="root",pass="",url="jdbc:mysql://localhost:3306/java_quanao";
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
        public HoaDonDAO() {
        if(con==null)
        {
            try {
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url,user,pass);
                
            } catch (Exception e) {
            }
        }
    }
        
        public ArrayList<HoaDonDTO> docDSHD()
        {
            ArrayList ds = new ArrayList<HoaDonDTO>();
            try {
                
                String qry = "select * from hoadon";
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
            
            st = con.createStatement();
            st.execute(qry);
                
            } catch (Exception e) {
            }
        }

    public boolean ktraMaNV(int manv) {
        try {
            String qry = "SELECT COUNT(*) FROM nhanvien WHERE MANV = " + manv;
            System.out.println("Truy vấn kiểm tra MANV: " + qry); // In truy vấn để kiểm tra
            st = con.createStatement();
            rs = st.executeQuery(qry);
            if (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("Số dòng tìm thấy cho MANV " + manv + ": " + count);
                return count > 0;
            } else {
                System.out.println("Không có kết quả trả về từ truy vấn.");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi kiểm tra MANV: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
        
        public boolean ktraMaKH(int makh)
        {
            try {
                String qry = "select count(*) from khachhang where makh='" + makh + "'";
                st = con.createStatement();
                rs = st.executeQuery(qry);
                if(rs.next())
                {
                    return rs.getInt(1)>0;
                }
            } catch (Exception e) {
            }
            return false;
        }
}
