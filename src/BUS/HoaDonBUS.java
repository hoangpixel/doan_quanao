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
import java.util.Calendar;
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
    
    public boolean ktraMaTrung(int mahd)
    {
        for(HoaDonDTO ct : ds)
        {
            if(ct.getMahd() == mahd)
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean them(HoaDonDTO hd){
        HoaDonDAO data = new HoaDonDAO();
        boolean result = data.them(hd);
        if (result) {
            ds.add(hd);
        }
        return result;
    }
    
    public boolean xoa(int ma){
        HoaDonDAO data = new HoaDonDAO();
        return data.xoa(ma);
    }
    
    public boolean capnhat(HoaDonDTO pn){
        HoaDonDAO data = new HoaDonDAO();
        return data.capnhat(pn);
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
    
    public boolean ktraMaNV(int ma)
    {
        HoaDonDAO data = new HoaDonDAO();
        return data.ktraMaNV(ma);
    }
    
    public boolean ktraMaKH(int ma)
    {
        HoaDonDAO data = new HoaDonDAO();
        return data.ktraMaKH(ma);
    }
    public int getAI(){
        HoaDonDAO data = new HoaDonDAO();
        return data.getAI();
    }
    
    public boolean ktraHopLe(HoaDonDTO ct)
    {
        HoaDonDAO data = new HoaDonDAO();
        return data.ktraHopLe(ct);
    }
    public long[] tinhDoanhThuTheoQuy(int nam) {
    if (ds == null || ds.isEmpty()) {
        docDSHD(); // Nạp dữ liệu nếu chưa có
    }

    long[] doanhThu = new long[4]; // Q1 → Q4
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    for (HoaDonDTO hd : ds) {
        try {
            Date ngay = sdf.parse(hd.getNgaylap());
            Calendar cal = Calendar.getInstance();
            cal.setTime(ngay);
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH); // 0-based

            if (year == nam) {
                int quy = month / 3; // 0 = Q1, 1 = Q2,...
                doanhThu[quy] += hd.getTongtien();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    return doanhThu;
}
    /*
public int getTrangThai(int mahd)
{
    HoaDonDAO data = new HoaDonDAO();
    return data.getTrangThai(mahd);
}*/

}
    