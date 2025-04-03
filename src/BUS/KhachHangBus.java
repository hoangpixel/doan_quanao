/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import java.util.ArrayList;

/**
 *
 * @author laptop
 */
public class KhachHangBus {
    private static ArrayList<KhachHangDTO> ds;
    public void docDSKH(){
        KhachHangDAO dskh = new KhachHangDAO();
        ds=dskh.DSKhachHangDTOs();
    }
    
    public void themKH(KhachHangDTO kh){
        KhachHangDAO data = new KhachHangDAO();
        data.them(kh);
    }
    
    public void xoaKH(int ma){
        KhachHangDAO data = new KhachHangDAO();
        data.xoa(ma);
    }
    
    public void sua(KhachHangDTO kh){
        KhachHangDAO data = new KhachHangDAO();
        data.sua(kh);
    }
}
