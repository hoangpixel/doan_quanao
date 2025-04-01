/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChuongTrinhKhuyenMaiHoaDonDAO;
import DTO.ChuongTrinhKhuyenMaiHoaDonDTO;
import java.util.ArrayList;

/**
 *
 * @author Vinh
 */
public class ChuongTrinhKhuyenMaiHoaDonBUS {
    private static ArrayList<ChuongTrinhKhuyenMaiHoaDonDTO> ds;
    
    public void themCTKMHD (ChuongTrinhKhuyenMaiHoaDonDTO ctkmhd) {
        if(ds == null)
            ds = new ArrayList<>();
        ctkmhd.setMaCTKMHD(new ChuongTrinhKhuyenMaiHoaDonDAO().themCTKMHD(ctkmhd));
        ds.add(ctkmhd);
    }
    
    public void suaCTKMHD (ChuongTrinhKhuyenMaiHoaDonDTO ctkmhd) {
        new ChuongTrinhKhuyenMaiHoaDonDAO().suaCTKMHD(ctkmhd);
        for(ChuongTrinhKhuyenMaiHoaDonDTO ct : ds) {
            if(ct.getMaCTKMHD() == ctkmhd.getMaCTKMHD()) {
                ct.setMaCTKM(ctkmhd.getMaCTKM());
                ct.setSoTienHD(ctkmhd.getSoTienHD());
                ct.setPhanTramGiamGia(ctkmhd.getPhanTramGiamGia());
                break;
            }
        }
    }
    
    public void xoaCTKMHD (int ma) {
        new ChuongTrinhKhuyenMaiHoaDonDAO().xoaCTKMHD(ma);
        ds.removeIf(ct -> ct.getMaCTKMHD() == ma);
    }
    
    public ChuongTrinhKhuyenMaiHoaDonDTO layCTKMHDTheoMa (int ma) {
        return new ChuongTrinhKhuyenMaiHoaDonDAO().layCTKMHDTheoMa(ma);
    }
    
    public ArrayList<ChuongTrinhKhuyenMaiHoaDonDTO> layTatCaCTKMHD() {
        if(ds == null) {
            ds = new ChuongTrinhKhuyenMaiHoaDonDAO().layTatCaCTKMHD();
        }
        return ds;
    }
    
    public void refreshDanhSach() {
        ds = new ChuongTrinhKhuyenMaiHoaDonDAO().layTatCaCTKMHD();
    }

    public static ArrayList<ChuongTrinhKhuyenMaiHoaDonDTO> getDs() {
        return ds;
    }
    
    public ArrayList<ChuongTrinhKhuyenMaiHoaDonDTO> timKiemTheoMaCTKM (int maCTKM) {
        return new ChuongTrinhKhuyenMaiHoaDonDAO().timKiemTheoMaCTKM(maCTKM);
    }
    
    public ArrayList<ChuongTrinhKhuyenMaiHoaDonDTO> timKiemTheoTongTienThapNhat (int tongtien) {
        return new ChuongTrinhKhuyenMaiHoaDonDAO().timKiemTheoTongTienThapNhat(tongtien);
    }
    
    public ArrayList<ChuongTrinhKhuyenMaiHoaDonDTO> timKiemTheoTongTienCaoNhat (int tongtien) {
        return new ChuongTrinhKhuyenMaiHoaDonDAO().timKiemTheoTongTienCaoNhat(tongtien);
    }
    
    public ArrayList<ChuongTrinhKhuyenMaiHoaDonDTO> timKiemTheoPTGGThapNhat (int ptgg) {
        return new ChuongTrinhKhuyenMaiHoaDonDAO().timKiemTheoPTGGThapNhat(ptgg);
    }
    
    public ArrayList<ChuongTrinhKhuyenMaiHoaDonDTO> timKiemTheoPTGGCaoNhat (int ptgg) {
        return new ChuongTrinhKhuyenMaiHoaDonDAO().timKiemTheoPTGGCaoNhat(ptgg);
    }
    
    
}
