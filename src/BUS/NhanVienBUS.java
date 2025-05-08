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
    
    public boolean kiemTraMaNhanVien(int manv) {
        NhanVienDTO nv = layNhanVienTheoMa(manv);
        return nv != null;
    }
    
    public ArrayList<NhanVienDTO> docDSNV() {
        if(dsnv == null) {
            dsnv = new NhanVienDAO().docDSNV();
        }
        return dsnv;
    }
    
    public void them(NhanVienDTO nv) {
        if(dsnv == null) {
            dsnv = new ArrayList<>();
        }
        nv.setMa(new NhanVienDAO().them(nv));
        dsnv.add(nv);
    }
    
    public void sua(NhanVienDTO nv) {
        new NhanVienDAO().sua(nv);
        for(NhanVienDTO nv1 : dsnv) {
            if(nv1.getMa() == nv.getMa()) {
                nv1.setHo(nv.getHo());
                nv1.setTen(nv.getTen());
                nv1.setLuong(nv.getLuong());
                nv1.setSDT(nv.getSDT());
                nv1.setDiaChi(nv.getDiaChi());
                nv1.setEmail(nv.getEmail());
                break;
            }
        }
    }
    
    public void xoa(int manv) {
        new NhanVienDAO().xoa(manv);
        dsnv.removeIf(n -> n.getMa() == manv);
    }
    
    public NhanVienDTO layNhanVienTheoMa(int manv) {
        return new NhanVienDAO().layNhanVienTheoMa(manv);
    }

    public static ArrayList<NhanVienDTO> getDSNV() {
        return dsnv;
    }
    
    public ArrayList<NhanVienDTO> timKiemTheoMaNhanVien(int manv) {
        ArrayList<NhanVienDTO> ds = new ArrayList<>();
        if (dsnv != null) {
            for(NhanVienDTO nv : dsnv) {
                if(nv.getMa() == manv) {
                    ds.add(nv);
                    break;
                }
            }
        }
        return ds;
    }
    
    public ArrayList<NhanVienDTO> timKiemTheoHoTen(String hoten) {
        ArrayList<NhanVienDTO> ds = new ArrayList<>();
        if (hoten != null && !hoten.isEmpty()) {
           for (NhanVienDTO nv : dsnv) {
            String hoTenDayDu = nv.getHo().toLowerCase() + " " + nv.getTen().toLowerCase();
                if (hoTenDayDu.contains(hoten.toLowerCase()) || 
                    nv.getHo().toLowerCase().contains(hoten.toLowerCase())
                    || nv.getTen().toLowerCase().contains(hoten.toLowerCase())) {
                        ds.add(nv);
                }
            }
        }
        return ds;
    }
    
    public ArrayList<NhanVienDTO> timKiemTheoMucLuong(int mucluong) {
        ArrayList<NhanVienDTO> ds = new ArrayList<>();
        for(NhanVienDTO nv : dsnv) {
            if(nv.getLuong() >= mucluong) {
                ds.add(nv);
            }
        }
        return ds;
    }
    
    public ArrayList<NhanVienDTO> timKiemTheoSDT(String sdt) {
        ArrayList<NhanVienDTO> ds = new ArrayList<>();
        if (sdt != null && !sdt.isEmpty()) {
           for (NhanVienDTO nv : dsnv) {
                if (nv.getSDT().toLowerCase().contains(sdt.toLowerCase())) {
                    ds.add(nv);
                }
            }
        }
        return ds;
    }
    
    public ArrayList<NhanVienDTO> timKiemTheoDiaChi(String diachi) {
        ArrayList<NhanVienDTO> ds = new ArrayList<>();
        if (diachi != null && !diachi.isEmpty()) {
           for (NhanVienDTO nv : dsnv) {
                if (nv.getDiaChi().toLowerCase().contains(diachi.toLowerCase())) {
                    ds.add(nv);
                }   
            }
        }
        return ds;
    }
    
    public ArrayList<NhanVienDTO> timKiemTheoEmail(String email) {
        ArrayList<NhanVienDTO> ds = new ArrayList<>();
        if (email != null && !email.isEmpty()) {
           for (NhanVienDTO nv : dsnv) {
                if (nv.getEmail().toLowerCase().contains(email.toLowerCase())) {
                    ds.add(nv);
                }
            }
        }
        return ds;
    }
    
    public ArrayList<Object[]> thongKeLuongTheoQuyNam(int nam) {
        return new NhanVienDAO().thongKeLuongTheoQuyNam(nam);
    }
    
    public Object[] thongKeTheoDiaChi() {
        return new NhanVienDAO().thongKeTheoDiaChi();
    }
}
