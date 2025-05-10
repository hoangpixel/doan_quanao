/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.HoaDonDTO;
import DTO.PhieuNhapDTO;
import config.DBConnect;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author laptop
 */
public class PhieuNhapDAO {
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;

public ArrayList<PhieuNhapDTO> DSPhieuNhapDTOs()
    {
        ArrayList ds = new ArrayList<PhieuNhapDTO>();
        try {
            String qry = "select * from phieunhap where is_deleted=0";
            con = DBConnect.getConnection();
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
                pn.setTrangThai(rs.getInt(6));
                ds.add(pn);
            }
        } catch (Exception e) {
        }
        return ds;
    }
        
    public boolean them(PhieuNhapDTO pn)
    {
        try {
            String qry = "Insert into phieunhap (MANV, MANCC, TONGTIEN, NGAYNHAP, TRANGTHAI, is_deleted) values (";
            qry = qry + pn.getMaNV() + ",";
            qry = qry + pn.getMaNCC() + ",";
            qry = qry + pn.getTongTien() + ",";
            qry = qry + "'" + pn.getNgayNhap() + "',";
            qry = qry  + pn.getTrangThai() + ",";
            qry = qry + "0";
            qry = qry + ")";          
            con = DBConnect.getConnection();
            st = con.createStatement();
            st.executeUpdate(qry);
            
            System.out.println("Thêm phiếu nhập thành công");
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi thêm phiếu nhập: " + e.getMessage());
            e.printStackTrace();
            return false;
        } 
    }
    
    public boolean xoa(int ma)
    {
        try {
            String qry = "Update phieunhap set is_deleted = '1' where MAPN = '" + ma + "'";
            con = DBConnect.getConnection();
            st = con.createStatement();
            st.executeUpdate(qry);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
    public boolean sua(PhieuNhapDTO pn)
    {
        try {
            String qry = "Update phieunhap Set ";
            qry = qry + " MANV= " + "'" + pn.getMaNV() + "'";
            qry = qry + ",MANCC=" + "'" + pn.getMaNCC() + "'";
            qry = qry + ",TONGTIEN=" + "'" + pn.getTongTien() + "'";
            qry = qry + ",NGAYNHAP=" + "'" + pn.getNgayNhap() + "'";
            qry = qry + ",TRANGTHAI=" + "'" + pn.getTrangThai() + "'";
            qry = qry + " " + " where MAPN='" + pn.getMaPN() + "'";
            con = DBConnect.getConnection();
            st = con.createStatement();
            st.executeUpdate(qry);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean ktraMaNV(int ma)
    {
        try {
            String qry = "select count(*) from nhanvien where manv=" + ma;
            con = DBConnect.getConnection();            
            st = con.createStatement();
            rs = st.executeQuery(qry);
            if(rs.next());
            {
                int d = rs.getInt(1);
                return d > 0;
            }
        } catch (Exception e) {
        }
        return false;
    }
    public boolean ktraMaNCC(int ma)
    {
        try {
            String qry = "select count(*) from ncc where mancc=" + ma;
            con = DBConnect.getConnection();            
            st = con.createStatement();
            rs = st.executeQuery(qry);
            if(rs.next());
            {
                int d = rs.getInt(1);
                return d > 0;
            }
        } catch (Exception e) {
        }
        return false;
    }
    public int getAI(){
        int result = 0;
        try {
            String qry = "SELECT `AUTO_INCREMENT` FROM INFORMATION_SCHEMA.TABLES " +
                     "WHERE TABLE_SCHEMA = 'java_quanao' AND TABLE_NAME = 'phieunhap'";
        con = DBConnect.getConnection();
        st = con.createStatement();
        rs = st.executeQuery(qry);
        if (rs.next()) {
            result = rs.getInt("AUTO_INCREMENT");
        }
        } catch (Exception e) {
        }
        return result;
    }
    public boolean ktraMaPN(int ma)
        {
            try {
                String qry = "select count(*) from phieunhap where mapn = " + ma;
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

    public boolean ktraHopLe(PhieuNhapDTO ct)
        {
            if(ct.getTongTien() < 0)
            {
                return false;
            }
            
            try {
                String qry = "select count(*) from nhanvien where manv = " + ct.getMaNV();
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
                String qry = "select count(*) from ncc where mancc = " + ct.getMaNCC();
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
}
