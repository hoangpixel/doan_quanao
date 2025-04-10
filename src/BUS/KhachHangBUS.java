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
public class KhachHangBUS {
    public static ArrayList<KhachHangDTO> ds;
    public void docDSKH(){
        KhachHangDAO dskh = new KhachHangDAO();
        ds=dskh.DSKhachHangDTOs();
    }
    
    public void themKH(KhachHangDTO kh){
        KhachHangDAO data = new KhachHangDAO();
        data.them(kh);
        ds.add(kh);
    }
    
    public void xoaKH(int ma){
        KhachHangDAO data = new KhachHangDAO();
        data.xoa(ma);
    }
    
    public void sua(KhachHangDTO kh){
        KhachHangDAO data = new KhachHangDAO();
        data.sua(kh);
    }
    public ArrayList<KhachHangDTO> timKiemThuong(String tim, int index) {
        if (ds == null) {
            docDSKH();
        }
    
        ArrayList<KhachHangDTO> kq = new ArrayList<>();
        for (KhachHangDTO kh : ds) {
            switch (index) {
                case 0: {
                    if (String.valueOf(kh.getMaKH()).contains(tim)) {
                        kq.add(kh);
                    }
                    break;
                }
                case 1: {
                    // Tìm kiếm theo họ khách hàng
                    if(kh.getHoKH().toLowerCase().contains(tim.toLowerCase())) {
                        kq.add(kh);
                    }
                    break;
                }
                case 2: {
                    //  Tìm kiếm theo tên khách hàng
                    if (kh.getTenKH().toLowerCase().contains(tim.toLowerCase())) {
                        kq.add(kh);
                    }
                    break;
                }
                case 3: {
                    // Tìm kiếm theo địa chỉ
                    if (kh.getDiaChi().toLowerCase().contains(tim.toLowerCase())) {
                        kq.add(kh);
                    }
                    break;
                }
                case 4: {
                    // Tìm kiếm theo số điện thoại
                    if (kh.getSDT().contains(tim)) {
                        kq.add(kh);
                    }
                    break;
                }
            }
        }
        return kq;
    }
    
    public boolean ktraMaKH(int makh)
    {
        KhachHangDAO data = new KhachHangDAO();
        return data.ktraMaKH(makh);
    }
}
