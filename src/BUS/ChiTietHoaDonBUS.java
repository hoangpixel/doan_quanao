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
    
    public ArrayList<ChiTietHoaDonDTO> dscthd;
    private final ChiTietHoaDonDAO cthdDAO;

    public ChiTietHoaDonBUS() {
        this.dscthd = new ArrayList<>();
        this.cthdDAO = new ChiTietHoaDonDAO();
        refreshDanhSach();
    }

    public boolean kiemTraMaDuyNhat(int mahd, int masp, int mapb) {
        for (ChiTietHoaDonDTO cthd : dscthd) {
            if (cthd.getMaHoaDon() == mahd && cthd.getMaSanPham() == masp && cthd.getMaPhienBan() == mapb) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<ChiTietHoaDonDTO> docDSCTHD() {
        if (dscthd.isEmpty()) {
            refreshDanhSach();
        }
        return new ArrayList<>(dscthd);
    }

    public boolean them(ChiTietHoaDonDTO cthd) {
        int generatedMaHD = cthdDAO.them(cthd);
        if (generatedMaHD == -1) {
            return false; // Stock insufficient or DB error
        }
        // Check if the CTHD already exists in dscthd to update or add
        boolean found = false;
        for (int i = 0; i < dscthd.size(); i++) {
            ChiTietHoaDonDTO existing = dscthd.get(i);
            if (existing.getMaHoaDon() == cthd.getMaHoaDon() &&
                existing.getMaSanPham() == cthd.getMaSanPham() &&
                existing.getMaPhienBan() == cthd.getMaPhienBan()) {
                existing.setSoLuong(existing.getSoLuong() + cthd.getSoLuong());
                //existing.setThanhTien(existing.getSoLuong() * existing.getDonGia());
                dscthd.set(i, existing);
                found = true;
                break;
            }
        }
        if (!found) {
            dscthd.add(cthd);
        }
        return true;
    }

    public boolean sua(ChiTietHoaDonDTO cthd) {
        int oldSoLuong = cthdDAO.laySoLuongHienTai(cthd.getMaHoaDon(), cthd.getMaSanPham(), cthd.getMaPhienBan());
        boolean success = cthdDAO.sua(cthd, oldSoLuong);
        if (success) {
            for (int i = 0; i < dscthd.size(); i++) {
                ChiTietHoaDonDTO existing = dscthd.get(i);
                if (existing.getMaHoaDon() == cthd.getMaHoaDon() &&
                    existing.getMaSanPham() == cthd.getMaSanPham() &&
                    existing.getMaPhienBan() == cthd.getMaPhienBan()) {
                    dscthd.set(i, new ChiTietHoaDonDTO(cthd));
                    break;
                }
            }
        }
        return success;
    }

    public boolean xoa(int mahd, int masp, int mapb) {
        boolean success = cthdDAO.xoa(mahd, masp, mapb);
        if (success) {
            dscthd.removeIf(cthd -> cthd.getMaHoaDon() == mahd && cthd.getMaSanPham() == masp && cthd.getMaPhienBan() == mapb);
        }
        return success;
    }

    public ChiTietHoaDonDTO layChiTietHoaDonTheoBaMa(int mahd, int masp, int mapb) {
        return cthdDAO.layChiTietHoaDonTheoBaMa(mahd, masp, mapb);
    }
    
    public ArrayList<ChiTietHoaDonDTO> layCTHDTheoMaHoaDon(int maHoaDon) {
        return cthdDAO.layCTHDTheoMaHoaDon(maHoaDon);
    }

    public void refreshDanhSach() {
        dscthd = cthdDAO.docDSCTHD();
    }
    
    public ArrayList<ChiTietHoaDonDTO> timKiemTheoMaHoaDon(int mahd) {
        ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<>();
        for (ChiTietHoaDonDTO cthd : dscthd) {
            if (cthd.getMaHoaDon() == mahd) {
                ds.add(cthd);
            }
        }
        return ds;
    }

    public ArrayList<ChiTietHoaDonDTO> timKiemTheoMaSanPham(int masp) {
        ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<>();
        for (ChiTietHoaDonDTO cthd : dscthd) {
            if (cthd.getMaSanPham() == masp) {
                ds.add(cthd);
            }
        }
        return ds;
    }

    public ArrayList<ChiTietHoaDonDTO> timKiemTheoMaPhienBan(int mapb) {
        ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<>();
        for (ChiTietHoaDonDTO cthd : dscthd) {
            if (cthd.getMaPhienBan() == mapb) {
                ds.add(cthd);
            }
        }
        return ds;
    }

    public ArrayList<ChiTietHoaDonDTO> timKiemTheoSoLuong(int soluong) {
        ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<>();
        for (ChiTietHoaDonDTO cthd : dscthd) {
            if (cthd.getSoLuong() == soluong) {
                ds.add(cthd);
            }
        }
        return ds;
    }

    public ArrayList<ChiTietHoaDonDTO> timKiemTheoDonGia(int dongia) {
        ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<>();
        for (ChiTietHoaDonDTO cthd : dscthd) {
            if (cthd.getDonGia() == dongia) {
                ds.add(cthd);
            }
        }
        return ds;
    }

    public ArrayList<ChiTietHoaDonDTO> timKiemTheoThanhTien(int thanhtien) {
        ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<>();
        for (ChiTietHoaDonDTO cthd : dscthd) {
            if (cthd.getThanhTien() == thanhtien) {
                ds.add(cthd);
            }
        }
        return ds;
    }
    
    public int getLatestMaHoaDon() {
        return new ChiTietHoaDonDAO().getLatestMaHoaDon();
    }
    
    public boolean capNhatTongTienHoaDon(int maHoaDon) {
        return cthdDAO.capNhatTongTienHoaDon(maHoaDon);
    }
}
