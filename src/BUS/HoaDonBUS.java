/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.HoaDonDAO;
import DTO.HoaDonDTO;
import DTO.ChiTietHoaDonDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        ds.add(hd);
    }
    
    public void capnhat(HoaDonDTO hd)
    {
        HoaDonDAO data = new HoaDonDAO();
        data.capnhat(hd);
    }
    
    //Nam sửa phần này
    public void xoa(int ma) {
        HoaDonDAO data = new HoaDonDAO();
        ChiTietHoaDonBUS cthdBUS = new ChiTietHoaDonBUS();

        // Xóa các chi tiết hóa đơn liên quan trước
        ArrayList<ChiTietHoaDonDTO> dscthd = cthdBUS.timKiemTheoMaHoaDon(ma);
        for (ChiTietHoaDonDTO cthd : dscthd) {
            cthdBUS.xoa(cthd.getMaHoaDon(), cthd.getMaSanPham(), cthd.getMaPhienBan());
        }

        // Sau đó xóa hóa đơn
        data.xoa(ma);
        ds.removeIf(hd -> hd.getMahd() == ma);
    }
    
    public ArrayList<HoaDonDTO> timKiemThuong(String tim,int index)
    {
        if(ds.isEmpty())
        {
            docDSHD();
        }
        ArrayList<HoaDonDTO> kq = new ArrayList<>();
        
        for(HoaDonDTO hd : ds)
        {
            switch(index)
            {
                case 0:
                {
                    if(tim.contains(String.valueOf(hd.getMahd())))
                    {
                        kq.add(hd);
                    }
                    break;
                }
                case 1:
                {
                    if(tim.contains(hd.getNgaylap()))
                    {
                        kq.add(hd);
                    }
                    break;
                }
                case 2:
                {
                    if(tim.contains(String.valueOf(hd.getManv())))
                    {
                        kq.add(hd);
                    }
                    break;
                }
                case 3:
                {
                    if(tim.contains(String.valueOf(hd.getMakh())))
                    {
                        kq.add(hd);
                    }
                    break;
                }
                case 4:
                {
                    if(tim.contains(String.valueOf(hd.getTongtien())))
                    {
                        kq.add((hd));
                    }
                    break;
                }
            }
        }
        return kq;
    }
    
    
    public ArrayList<HoaDonDTO> timKiemNangCao(int mahd,Date ngaybd,Date ngaykt,int manv,int makh,int tienMin,int tienMax)
    {
        ArrayList<HoaDonDTO> dskq = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for(HoaDonDTO ct : ds)
        {
            boolean dk = false;

            try {
                Date bd = sdf.parse(ct.getNgaylap());
                if(mahd != -1 && mahd == ct.getMahd())
                {
                    dk = true;
                }
                
                if(ngaybd != null && ngaykt != null 
                && bd.compareTo(ngaybd) >=0 && bd.compareTo(ngaykt) <= 0)
                {
                    dk=true;
                }else if(ngaybd != null && ngaykt == null && bd.compareTo(ngaybd) >= 0)
                {
                    dk=true;
                }else if(ngaybd == null && ngaykt != null && bd.compareTo(ngaykt) <= 0)
                {
                    dk=true;
                }
                
                if(manv != -1  && manv == ct.getManv())
                {
                    dk=true;
                }
                
                if(makh != -1 && makh == ct.getMakh())
                {
                    dk=true;
                }
                
                if(tienMin != -1 && tienMax != -1 && ct.getTongtien() >= tienMin && ct.getTongtien() <= tienMax)
                {
                    dk=true;
                }else if(tienMin != -1 && ct.getTongtien() >= tienMin)
                {
                    dk=true;
                }else if(tienMax != -1 && ct.getTongtien() <= tienMax)
                {
                    dk=true;
                }
                
                if(dk)
                {
                    dskq.add(ct);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dskq;
    }
    
    public boolean ktraMaHD(int ma)
    {
        HoaDonDAO data = new HoaDonDAO();
        return data.ktraMaHD(ma);
    }
    public boolean ktraHopLe(HoaDonDTO ct)
    {
        HoaDonDAO data = new HoaDonDAO();
        return data.ktraHopLe(ct);
    }
}
    