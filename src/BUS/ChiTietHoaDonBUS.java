/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.ChiTietHoaDonDAO;
import DTO.ChiTietHoaDonDTO;
import java.util.ArrayList;
/**
 *
 * @author suvie
 */
public class ChiTietHoaDonBUS {
    public static ArrayList<ChiTietHoaDonDTO> dscthd;

    public ChiTietHoaDonBUS() {
    }
    public void docDSCTHD()
    {
        ChiTietHoaDonDAO data = new ChiTietHoaDonDAO();
//            dscthd = data.docDSCTHD();
    }
    
    public void them(ChiTietHoaDonDTO cthd)
    {
        ChiTietHoaDonDAO data = new ChiTietHoaDonDAO();
        data.them(cthd);
    }
    
    public void xoa(int mahd, int masp)
    {
        ChiTietHoaDonDAO data = new ChiTietHoaDonDAO();
//        data.xoa(mahd, masp);
    }
    
    public void sua(ChiTietHoaDonDTO cthd)
    {
        ChiTietHoaDonDAO data = new ChiTietHoaDonDAO();
        data.sua(cthd);
    }
    
}
