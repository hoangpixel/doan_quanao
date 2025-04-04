/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.HoaDonDAO;
import DTO.HoaDonDTO;
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
    
    public void xoa(int ma)
    {
        HoaDonDAO data = new HoaDonDAO();
        data.xoa(ma);
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
    
    
    public ArrayList<HoaDonDTO> timKiemNangCao(int mahd,String ngaybd,String ngaykt,int manv,int makh,int tienMin,int tienMax)
    {
        ArrayList<HoaDonDTO> kq = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date timBD=null;
        Date timKT=null;
        Date bd=null;
        try {
                if(!ngaybd.isEmpty())
                {
                    timBD = sdf.parse(ngaybd);
                }
                if(!ngaykt.isEmpty())
                {
                    timKT = sdf.parse(ngaykt);
                }
        } catch (Exception e) {
        }
        for(HoaDonDTO hd : ds)
        {
            boolean dk = false;
            try {
            bd = sdf.parse(hd.getNgaylap());
            if(mahd!=-1 && hd.getMahd()!=mahd )
            {
                dk = true;
            }

            if(timBD!=null && bd.before(timBD))
            {
                dk = true;
            }
            
            if(timKT!=null && bd.after(timKT))
            {
                dk = true;
            }
            
            if(manv!=-1 && hd.getManv()!=manv)
            {
                dk=true;
            }
            
            if(makh!=-1 && hd.getMakh()!=makh)
            {
                dk = true;
            }
            
            if(tienMin!=-1 && hd.getTongtien() <= tienMin)
            {
                dk = true;
            }
            
            if(tienMax!=-1 && hd.getTongtien() >= tienMax)
            {
                dk=true;
            }
        if(!dk)
        {
            kq.add(hd);
        }
            } catch (Exception e) {
            }
            
        }
        return kq;
    }
}
    