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
    
    public static ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<>();
    
    public ChiTietHoaDonBUS() {}
    
    public void docDSCTHD(){
        ChiTietHoaDonDAO data = new ChiTietHoaDonDAO();
        ds = data.docDSCTHD();
    }

    public boolean them(ChiTietHoaDonDTO cthd){
        ChiTietHoaDonDAO data = new ChiTietHoaDonDAO();
        boolean result = data.them(cthd);
        if (result) {
            ds.add(cthd);
        }
        return result;
    }

    public boolean sua(ChiTietHoaDonDTO cthd){
        ChiTietHoaDonDAO data = new ChiTietHoaDonDAO();
        return data.sua(cthd);
    }

    public boolean xoa(int maHD){
        ChiTietHoaDonDAO data = new ChiTietHoaDonDAO();
        return data.xoa(maHD);
    }
}
