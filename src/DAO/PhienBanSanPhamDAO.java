/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.PhienBanSanPhamDTO;
import java.util.ArrayList;
import java.sql.*;
import config.DBConnect; 

/**
 *
 * @author laptop
 */
public class PhienBanSanPhamDAO {
    Connection con = null;
    PreparedStatement pstm = null;
    Statement st = null;
    ResultSet rs = null;
    public ArrayList<PhienBanSanPhamDTO> docDSPB(){
        ArrayList ds = new ArrayList<PhienBanSanPhamDTO>();
        try {
            String qry = "select * from phienbansp";
            con = DBConnect.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(qry);
            while(rs.next())
            {
                PhienBanSanPhamDTO pbsp = new PhienBanSanPhamDTO();
                pbsp.setMaPB(rs.getInt(1));
                pbsp.setMaSP(rs.getInt(2));
                pbsp.setSize(rs.getString(3));
                pbsp.setMau(rs.getString(4));
                pbsp.setSoLuong(rs.getInt(5));
                ds.add(pbsp);
            }
        } catch (Exception e) {
        }
        return ds;
    }
    public int thayDoiSLPB(int sl, int mapb){
        int result = 0;
        try {
            String qry = "Update phienbansp set SLPB = SLPB + ? where MAPB = ?";
            con = DBConnect.getConnection();
            pstm = con.prepareStatement(qry);
            pstm.setInt(1, sl);
            pstm.setInt(2, mapb);
            result = pstm.executeUpdate();
        } catch (Exception e) {
        }
        return result;
    }
}
