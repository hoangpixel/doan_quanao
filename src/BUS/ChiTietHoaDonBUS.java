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
    
    public static ArrayList<ChiTietHoaDonDTO> dscthd;
    
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
    
    public ArrayList<ChiTietHoaDonDTO> docDSCTHD() {
        if(dscthd == null) {
            dscthd = new ChiTietHoaDonDAO().docDSCTHD();
        }
        return dscthd;
    }
    
    public boolean them(ChiTietHoaDonDTO cthd) {
        if (dscthd == null) {
            dscthd = new ArrayList<>();
        }
        int generatedMaHD = new ChiTietHoaDonDAO().them(cthd);
        if (generatedMaHD == -1) {
            return false; // Stock insufficient
        }
        cthd.setMaHoaDon(generatedMaHD);
        dscthd.add(cthd);
        return true;
    }
    
    public boolean sua(ChiTietHoaDonDTO cthd) {
        // Get the original quantity
        int oldSoLuong = new ChiTietHoaDonDAO().laySoLuongHienTai(cthd.getMaHoaDon(), cthd.getMaSanPham());
        // Update database and stock
        boolean success = new ChiTietHoaDonDAO().sua(cthd, oldSoLuong);
        if (success) {
            // Update in-memory list
            for (ChiTietHoaDonDTO cthd1 : dscthd) {
                if (cthd1.getMaHoaDon() == cthd.getMaHoaDon() && cthd1.getMaSanPham() == cthd.getMaSanPham()) {
                    cthd1.setSoLuong(cthd.getSoLuong());
                    cthd1.setDonGia(cthd.getDonGia());
                    break;
                }
            }
        }
        return success;
    }
    
    public void xoa(int mahd, int masp) {
        new ChiTietHoaDonDAO().xoa(mahd, masp);
        dscthd.removeIf(n -> n.getMaHoaDon() == mahd && n.getMaSanPham() == masp);
    }
    
    public ChiTietHoaDonDTO layChiTietHoaDonTheoHaiMa(int mahd, int masp) {
        return new ChiTietHoaDonDAO().layChiTietHoaDonTheoHaiMa(mahd, masp);
    }
    
    public void refreshDanhSach() {
        dscthd = new ChiTietHoaDonDAO().docDSCTHD();
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

    public ArrayList<ChiTietHoaDonDTO> layDScthdTheoMAHD(int mahd)
    {
        ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<>();
        for(ChiTietHoaDonDTO ct : dscthd)
        {
            if(ct.getMaHoaDon() == mahd)
            {
                ds.add(ct);
            }
        }
        return ds;
    }
}
