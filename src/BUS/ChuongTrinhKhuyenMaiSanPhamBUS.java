/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DTO.ChuongTrinhKhuyenMaiSanPhamDTO;
import DAO.ChuongTrinhKhuyenMaiSanPhamDAO;
import java.util.ArrayList;
/**
 *
 * @author mhoang
 */
public class ChuongTrinhKhuyenMaiSanPhamBUS {
    public static ArrayList<ChuongTrinhKhuyenMaiSanPhamDTO> ds;
    public void docDSCTKMSP()
    {
        ChuongTrinhKhuyenMaiSanPhamDAO data = new ChuongTrinhKhuyenMaiSanPhamDAO();
        ds = data.docDSCTKMSP();
    }
    
    public void them(ChuongTrinhKhuyenMaiSanPhamDTO ct)
    {
        ChuongTrinhKhuyenMaiSanPhamDAO data = new ChuongTrinhKhuyenMaiSanPhamDAO();
        data.them(ct);
//        ds.add(ct);
    }
    
    public void xoa(int maXoa)
    {
        ChuongTrinhKhuyenMaiSanPhamDAO data = new ChuongTrinhKhuyenMaiSanPhamDAO();
        data.xoa(maXoa);
    }
    
    public void capnhat(ChuongTrinhKhuyenMaiSanPhamDTO ct)
    {
        ChuongTrinhKhuyenMaiSanPhamDAO data = new ChuongTrinhKhuyenMaiSanPhamDAO();
        data.capnhat(ct);
    }
    
    
}
