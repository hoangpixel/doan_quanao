/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.HoaDonDAO;
import DTO.HoaDonDTO;
import java.util.ArrayList;
/**
 *
 * @author mhoang
 */
public class HoaDonBUS {
    public static ArrayList<HoaDonDTO> ds;
    
    public void docDSHD()
    {
        HoaDonDAO data = new HoaDonDAO();
        ds = data.docDSHD();
    }
    
    public void them(HoaDonDTO hd)
    {
        HoaDonDAO data = new HoaDonDAO();
        data.them(hd);
    }
    

}
