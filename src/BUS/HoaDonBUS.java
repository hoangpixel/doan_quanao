/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.HoaDonDAO;
import DTO.HoaDonDTO;
import java.util.ArrayList;
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
}
    