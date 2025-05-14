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
                
                String qry = "select * from hoadon where is_deleted = 0";
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
        
//        public void xoa(int ma)
//        {
//            try {
//                
//                String qry1 = "Delete from hoadon where MAHD = " + ma;
//                String qry2 = "Delete from chitiethoadon where MAHD = " + ma;
//                con = DBConnect.getConnection();
//                st = con.createStatement();
//                st.executeUpdate(qry2);
//                st.executeUpdate(qry1);
//                
//            } catch (Exception e) {
//            }
//        }

public void capNhatLaiSoLuongSauXoa(int mahd) {
    try {
        con = DBConnect.getConnection();

        // 1. Lấy danh sách MAPB và SL từ CTHD của hóa đơn cần xóa
        String qry = "SELECT MAPB, SL FROM cthd WHERE MAHD = ?";
        PreparedStatement ps = con.prepareStatement(qry);
        ps.setInt(1, mahd);
        ResultSet rs = ps.executeQuery();

        // 2. Cập nhật lại bảng phienbansp
        while (rs.next()) {
            int mapb = rs.getInt("MAPB");
            int sl = rs.getInt("SL");

            String update = "UPDATE phienbansp SET SLPB = SLPB + ? WHERE MAPB = ?";
            PreparedStatement psUpdate = con.prepareStatement(update);
            psUpdate.setInt(1, sl);
            psUpdate.setInt(2, mapb);
            psUpdate.executeUpdate();
            psUpdate.close();
        }

        rs.close();
        ps.close();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try { if (con != null) con.close(); } catch (Exception e) {}
    }
}

        
public void xoa(int ma) {
    try {
        con = DBConnect.getConnection();
        String qry = "UPDATE hoadon SET is_deleted = 1 WHERE MAHD = ?";
        PreparedStatement ps = con.prepareStatement(qry);
        ps.setInt(1, ma);
        ps.executeUpdate();
        ps.close();

        // Gọi cập nhật lại tồn kho
        capNhatLaiSoLuongSauXoa(ma);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try { if (con != null) con.close(); } catch (Exception e) {}
    }
}




        
        public void capnhat(HoaDonDTO hd)
        {
            try {
                
                String qry = "Update hoadon Set ";
                qry += " " + "NGAYLAP='" + hd.getNgaylap() + "'";
                qry += ",MANV='" + hd.getManv() + "'";
                qry += ",MAKH='" + hd.getMakh() + "'";
                qry += ",TONGTIEN='" + hd.getTongtien() + "'";
                qry += " Where MAHD='" + hd.getMahd() +"'";
                con = DBConnect.getConnection();
                st = con.createStatement();
                st.executeUpdate(qry);
            } catch (Exception e) {
            }
        }
        
        
        public boolean ktraMaHD(int ma)
        {
            try {
                String qry = "select count(*) from hoadon where mahd = " + ma;
                con = DBConnect.getConnection();
                st = con.createStatement();
                rs = st.executeQuery(qry);
                if(rs.next())
                {
                    int d=rs.getInt(1);
                    if(d>0)
                    {
                        return true;
                    }
                }
            } catch (Exception e) {
            }
            return false;
        }
        
        public boolean ktraHopLe(HoaDonDTO ct)
        {
            if(ct.getTongtien() < 0)
            {
                return false;
            }
            
            try {
                String qry = "select count(*) from nhanvien where manv = " + ct.getManv();
                con = DBConnect.getConnection();
                st = con.createStatement();
                rs = st.executeQuery(qry);
                if(rs.next())
                {
                    int d= rs.getInt(1);
                    if(d==0)
                    {
                        return false;
                    }
                }
            } catch (Exception e) {
                
            }
            try {
                String qry = "select count(*) from khachhang where makh = " + ct.getMakh();
                con = DBConnect.getConnection();
                st = con.createStatement();
                rs = st.executeQuery(qry);
                if(rs.next())
                {
                    int d = rs.getInt(1);
                    if(d==0)
                    {
                        return false;
                    }
                }
            } catch (Exception e) {
            }
            return true;
        }
        
        public int getTrangThai(int mahd)
        {
            int trangthai = 0;
            try {
                String qry = "select TRANGTHAI from hoadon where MAHD = " +  mahd;
                con = DBConnect.getConnection();
                st = con.createStatement();
                rs = st.executeQuery(qry);
                while(rs.next())
                {
                    trangthai = rs.getInt("TRANGTHAI");
                }
            } catch (Exception e) {
            }
            return trangthai;
        }
}
