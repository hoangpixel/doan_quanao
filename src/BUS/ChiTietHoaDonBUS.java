/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.ChiTietHoaDonDAO;
import DTO.ChiTietHoaDonDTO;
import java.util.ArrayList;
/**
 *
 * @author suvie
 */
public class ChiTietHoaDonBUS {
    private static ArrayList<ChiTietHoaDonDTO> dscthd;
    
    public boolean kiemTraMaDuyNhat(int mahd, int masp)
    {
        if(dscthd != null) {
            for(ChiTietHoaDonDTO cthd : dscthd) {
                if(cthd.getMaHoaDon() == mahd && cthd.getMaSanPham() == masp)
                    return false;
            }
        }
        return true;
    }
    
    public void them(ChiTietHoaDonDTO cthd) {
        if(dscthd == null) {
            dscthd = new ArrayList<>();
        }
        cthd.setMaHoaDon(new ChiTietHoaDonDAO().them(cthd));
        dscthd.add(cthd);
    }
    
    public void sua(ChiTietHoaDonDTO cthd) {
        new ChiTietHoaDonDAO().sua(cthd);
        for(ChiTietHoaDonDTO cthd1 : dscthd) {
            if(cthd1.getMaHoaDon() == cthd.getMaHoaDon() && cthd1.getMaSanPham() == cthd.getMaSanPham()) {
                cthd1.setSoLuong(cthd.getSoLuong());
                cthd1.setDonGia(cthd.getDonGia());
                break;
            }
        }
    }
    
    public void xoa(int mahd, int masp) {
        new ChiTietHoaDonDAO().xoa(mahd, masp);
        dscthd.removeIf(n -> n.getMaHoaDon() == mahd && n.getMaSanPham() == masp);
    }
    
    public ArrayList<ChiTietHoaDonDTO> layChiTietHoaDonTheoMaHoaDon(int mahd) {
        return new ChiTietHoaDonDAO().layChiTietHoaDonTheoMaHoaDon(mahd);
    }
    
    public ArrayList<ChiTietHoaDonDTO> layChiTietHoaDonTheoMaSanPham(int masp) {
        return new ChiTietHoaDonDAO().layChiTietHoaDonTheoMaSanPham(masp);
    }
    
    public ChiTietHoaDonDTO layChiTietHoaDonTheoCaHaiMa(int mahd, int masp) {
        return new ChiTietHoaDonDAO().layChiTietHoaDonTheoCaHaiMa(mahd, masp);
    }
    
    public ArrayList<ChiTietHoaDonDTO> layTatCaCTHD() {
        if(dscthd == null) {
            dscthd = new ChiTietHoaDonDAO().layTatCaCTHD();
        }
        return dscthd;
    }
    
    public void refreshDanhSach() {
        dscthd = new ChiTietHoaDonDAO().layTatCaCTHD();
    }

    public static ArrayList<ChiTietHoaDonDTO> getDSCTHD() {
        return dscthd;
    }
    
    public ArrayList<ChiTietHoaDonDTO> timKiemTheoMaHoaDon(int mahd) {
        ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<>();
        if (dscthd != null) {
            for(ChiTietHoaDonDTO cthd : dscthd) {
                if(cthd.getMaHoaDon() == mahd) {
                    ds.add(cthd);
                }
            }
        }
        return ds;
    }
    
    public ArrayList<ChiTietHoaDonDTO> timKiemTheoMaSanPham(int masp) {
        ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<>();
        if (dscthd != null) {
            for(ChiTietHoaDonDTO cthd : dscthd) {
                if(cthd.getMaSanPham() == masp) {
                    ds.add(cthd);
                }
            }
        }
        return ds;
    }
    
    public ArrayList<ChiTietHoaDonDTO> timKiemTheoCaHaiMa(int mahd, int masp) {
        ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<>();
        if (dscthd != null) {
            for(ChiTietHoaDonDTO cthd : dscthd) {
                if(cthd.getMaHoaDon() == mahd && cthd.getMaSanPham() == masp) {
                    ds.add(cthd);
                    break;
                }
            }
        }
        return ds;
    }
    
    public ArrayList<ChiTietHoaDonDTO> timKiemTheoSoLuong(int soluong) {
        ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<>();
        for(ChiTietHoaDonDTO cthd : dscthd) {
            if(cthd.getSoLuong() == soluong) {
                ds.add(cthd);
            }
        }
        return ds;
    }
    
    public ArrayList<ChiTietHoaDonDTO> timKiemTheoDonGia(int dongia) {
        ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<>();
        for(ChiTietHoaDonDTO cthd : dscthd) {
            if(cthd.getDonGia() == dongia) {
                ds.add(cthd);
            }
        }
        return ds;
    }
    
    public ArrayList<ChiTietHoaDonDTO> timKiemTheoThanhTien(int thanhtien) {
        ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<>();
        for(ChiTietHoaDonDTO cthd : dscthd) {
            if((cthd.getDonGia() * cthd.getSoLuong()) == thanhtien) {
                ds.add(cthd);
            }
        }
        return ds;
    }
}
