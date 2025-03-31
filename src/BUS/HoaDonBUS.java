/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import java.util.ArrayList;
import DAO.HoaDonDAO;
import DTO.HoaDonDTO;
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
//        ds.add(hd);
    }
    public void capnhat(HoaDonDTO hd)
    {
        HoaDonDAO data = new HoaDonDAO();
        data.capnhat(hd);
    }
    public void xoa(int maXoa)
    {
        HoaDonDAO data = new HoaDonDAO();
        data.xoa(maXoa);
    }
}
