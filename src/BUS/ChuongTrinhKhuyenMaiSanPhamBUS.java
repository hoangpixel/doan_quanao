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
        ds.add(ct);
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
    
  
    
    public ArrayList<ChuongTrinhKhuyenMaiSanPhamDTO> timKiemThuong(String tim,int index)
    {
        if(ds == null)
        {
            docDSCTKMSP();
        }
        
        ArrayList<ChuongTrinhKhuyenMaiSanPhamDTO> kq = new ArrayList<>();
        for(ChuongTrinhKhuyenMaiSanPhamDTO ct : ds)
        {
            switch(index)
            {
                case 0:
                {
                    if(tim.contains(String.valueOf(ct.getMactkmsp())))
                    {
                        kq.add(ct);
                    }
                    break;
                }
                case 1:
                {
                    if(tim.contains(String.valueOf(ct.getMactkm())))
                    {
                        kq.add(ct);
                    }
                    break;
                }
                case 2:
                {
                    if(tim.contains(String.valueOf(ct.getMasp())))
                    {
                        kq.add(ct);
                    }
                    break;
                }
                case 3:
                {
                    if(tim.contains(String.valueOf(ct.getPtgg())))
                    {
                        kq.add(ct);
                    }
                    break;
                }
            }
        }
        return kq;
    }
    
    public ArrayList<ChuongTrinhKhuyenMaiSanPhamDTO> layDsTheoMaCTKM(int ma)
    {
        ArrayList<ChuongTrinhKhuyenMaiSanPhamDTO> kq = new ArrayList<>();
        for(ChuongTrinhKhuyenMaiSanPhamDTO ct : ds)
        {
            if(ma == ct.getMactkm())
            {
                kq.add(ct);
            }
        }
        return kq;
    }
    public boolean ktraMa(int ma)
    {
        ChuongTrinhKhuyenMaiSanPhamDAO data = new ChuongTrinhKhuyenMaiSanPhamDAO();
        return data.ktraMa(ma);
    }
    
    public boolean ktraHopLe(ChuongTrinhKhuyenMaiSanPhamDTO ct)
    {
        ChuongTrinhKhuyenMaiSanPhamDAO data = new ChuongTrinhKhuyenMaiSanPhamDAO();
        return data.ktraHopLe(ct);
    }
}
