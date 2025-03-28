
package DAO;
import DTO.ChuongTrinhKhuyenMaiDTO;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author mhoang
 */
public class ChuongTrinhKhuyenMaiDAO {
    String user="root",pass="",url="jdbc:mysql://localhost:3306/java_quanao";
    Connection con;
    Statement st;
    ResultSet rs;

    public ChuongTrinhKhuyenMaiDAO() {
        if(con==null)
        {
            try {
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url,user,pass);
                
            } catch (Exception e) {
            }
        }
    }
    
    public ArrayList<ChuongTrinhKhuyenMaiDTO> docDSCTKM()
    {
        ArrayList ds = new ArrayList<ChuongTrinhKhuyenMaiDTO>();
        try {
            String qry = "select * from ctkm";
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
            st = con.createStatement();
            st.executeUpdate(qry);
        } catch (Exception e) {
        }
    }
    
    public void xoa(int ma)
    {
        try {
            
            String qry = "Delete from ctkm where mactkm = '" + ma + "'";
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
            st = con.createStatement();
            st.executeUpdate(qry);            
        } catch (Exception e) {
        }
    }
            
    
    
}
