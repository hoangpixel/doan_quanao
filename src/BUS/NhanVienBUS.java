/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;

/**
 *
 * @author suvie
 */
public class NhanVienBUS {

    public static ArrayList<NhanVienDTO> dsnv;

    public NhanVienBUS() {}
    public void docDSNV()
    {
        NhanVienDAO data = new NhanVienDAO();
            dsnv = data.docDSNV();
    }
    
    public void them(NhanVienDTO nv)
    {
        NhanVienDAO data = new NhanVienDAO();
        data.them(nv);
    }
    
    public void xoa(int ma)
    {
        NhanVienDAO data = new NhanVienDAO();
        data.xoa(ma);
    }
    
    public void sua(NhanVienDTO nv)
    {
        NhanVienDAO data = new NhanVienDAO();
        data.sua(nv);
    }
    
    public ArrayList<NhanVienDTO> timKiemThuong(String tim,int index)
    {
        if(dsnv == null)
        {
            docDSNV();
        }
        
        ArrayList<NhanVienDTO> kq = new ArrayList<>();
        if(index == 1 || index == 2)
        {
            String regex = "^\\d{2}/\\d{2}\\d{4}$";
            if(!tim.matches(regex))
            {
                return kq;
            }
        }
        for(NhanVienDTO nv : dsnv)
        {

            switch (index)
            {
                case 0:
                {
                    if(String.valueOf(nv.getMa()).contains(tim))
                    {
                        kq.add(nv);
                    }
                    break;
                }
                case 1:
                {
                    if(nv.getHo().contains(tim))
                    {
                        kq.add(nv);
                    }
                    break;
                }
                case 2:
                {
                    if(nv.getTen().contains(tim))
                    {
                        kq.add(nv);
                    }
                    break;
                }
            }
        }
        return kq;
    }
    
    public boolean ktraMa(int ma)
    {
        if(dsnv == null)
        {
            docDSNV();
        }
        for(NhanVienDTO ct : dsnv)
        {
            if(ct.getMa() == ma)
            {
                return true;
            }
        }
        return false;
    }
}
