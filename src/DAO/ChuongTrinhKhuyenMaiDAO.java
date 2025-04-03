
package DAO;
import DTO.ChuongTrinhKhuyenMaiDTO;
import java.util.ArrayList;
import java.sql.*;
import config.DBConnect;
/**
 *
 * @author mhoang
 */
public class ChuongTrinhKhuyenMaiDAO {
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;


    public ArrayList<ChuongTrinhKhuyenMaiDTO> docDSCTKM()
    {
        ArrayList ds = new ArrayList<ChuongTrinhKhuyenMaiDTO>();
        try {

            String qry = "select * from ctkm";
            con = DBConnect.getConnection();
            st = con.createStatement();            
            rs = st.executeQuery(qry);
            while(rs.next())
            {
                ChuongTrinhKhuyenMaiDTO ct = new ChuongTrinhKhuyenMaiDTO();
                ct.setMaCTKM(rs.getInt(1));
                ct.setNgayBD(rs.getString(2));
                ct.setNgayKT(rs.getString(3));
                ds.add(ct);
            }
        } catch (Exception e) {
        }
        return ds;
    }
    
    
    
    public void them(ChuongTrinhKhuyenMaiDTO ct)
    {
        try {
            String qry = "Insert into ctkm (NGAYBD,NGAYKT) values (";
            qry = qry + "'" + ct.getNgayBD() + "',";
            qry = qry + "'" + ct.getNgayKT() + "'";
            qry = qry + ")";
            con = DBConnect.getConnection();
            st = con.createStatement();
            st.executeUpdate(qry);
        } catch (Exception e) {
        }
    }
    
    public void xoa(int ma)
    {
        try {
            
            String qry = "Delete from ctkm where mactkm = '" + ma + "'";
            con = DBConnect.getConnection();          
            st = con.createStatement();
            st.executeUpdate(qry);
            
        } catch (Exception e) {
        }
    }
    
    
    public void sua(ChuongTrinhKhuyenMaiDTO ct)
    {
        try {
            
        String qry = "Update ctkm Set ";
        qry = qry + " " + "NGAYBD=" + "'" + ct.getNgayBD() + "'";
        qry = qry + ",NGAYKT=" + "'" + ct.getNgayKT() + "'";
        qry = qry + " " + " where MACTKM='" + ct.getMaCTKM() + "'";
            con = DBConnect.getConnection();       
            st = con.createStatement();
            st.executeUpdate(qry);            
        } catch (Exception e) {
        }
    }
            
    
    public boolean ktraMa(int ma)
    {
        try {
            String qry = "select count(*) from ctkm where mactkm=" + ma;
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
}
