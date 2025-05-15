/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.ChuongTrinhKhuyenMaiSanPhamDTO;
import DAO.ChuongTrinhKhuyenMaiSanPhamDAO;
import DTO.ChuongTrinhKhuyenMaiDTO;
import DTO.SanPhamDTO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author mhoang
 */
public class ChuongTrinhKhuyenMaiSanPhamBUS {

    public static ArrayList<ChuongTrinhKhuyenMaiSanPhamDTO> ds;

    public void docDSCTKMSP() {
        ChuongTrinhKhuyenMaiSanPhamDAO data = new ChuongTrinhKhuyenMaiSanPhamDAO();
        ds = data.docDSCTKMSP();
    }

    public boolean ktraMaTrung(int ma) {
        for (ChuongTrinhKhuyenMaiSanPhamDTO ct : ds) {
            if (ct.getMactkmsp() == ma) {
                return true;
            }
        }
        return false;
    }

    public void them(ChuongTrinhKhuyenMaiSanPhamDTO ct) {
        ChuongTrinhKhuyenMaiSanPhamDAO data = new ChuongTrinhKhuyenMaiSanPhamDAO();
        data.them(ct);
        ds.add(ct);
    }

    public void xoa(int maXoa) {
        ChuongTrinhKhuyenMaiSanPhamDAO data = new ChuongTrinhKhuyenMaiSanPhamDAO();
        data.xoa(maXoa);
    }

    public void capnhat(ChuongTrinhKhuyenMaiSanPhamDTO ct) {
        ChuongTrinhKhuyenMaiSanPhamDAO data = new ChuongTrinhKhuyenMaiSanPhamDAO();
        data.capnhat(ct);
    }

    public ArrayList<ChuongTrinhKhuyenMaiSanPhamDTO> timKiemThuong(String tim, int index) {
        if (ds == null) {
            docDSCTKMSP();
        }

        ArrayList<ChuongTrinhKhuyenMaiSanPhamDTO> kq = new ArrayList<>();
        for (ChuongTrinhKhuyenMaiSanPhamDTO ct : ds) {
            switch (index) {
                case 0: {
                    if (tim.contains(String.valueOf(ct.getMactkmsp()))) {
                        kq.add(ct);
                    }
                    break;
                }
                case 1: {
                    if (tim.contains(String.valueOf(ct.getMactkm()))) {
                        kq.add(ct);
                    }
                    break;
                }
                case 2: {
                    if (tim.contains(String.valueOf(ct.getMasp()))) {
                        kq.add(ct);
                    }
                    break;
                }
                case 3: {
                    if (tim.contains(String.valueOf(ct.getPtgg()))) {
                        kq.add(ct);
                    }
                    break;
                }
            }
        }
        return kq;
    }

    public ArrayList<ChuongTrinhKhuyenMaiSanPhamDTO> layDsTheoMaCTKM(int ma) {
        ArrayList<ChuongTrinhKhuyenMaiSanPhamDTO> kq = new ArrayList<>();
        for (ChuongTrinhKhuyenMaiSanPhamDTO ct : ds) {
            if (ma == ct.getMactkm()) {
                kq.add(ct);
            }
        }
        return kq;
    }

    public boolean ktraMa(int ma) {
        ChuongTrinhKhuyenMaiSanPhamDAO data = new ChuongTrinhKhuyenMaiSanPhamDAO();
        return data.ktraMa(ma);
    }

    public boolean ktraHopLe(ChuongTrinhKhuyenMaiSanPhamDTO ct) {
        ChuongTrinhKhuyenMaiSanPhamDAO data = new ChuongTrinhKhuyenMaiSanPhamDAO();
        return data.ktraHopLe(ct);
    }

    public double tinhGiamGiaChoSanPham(int maSanPham, int soLuong) {
        double tongGiamGia = 0;

        // Load danh sách CTKM chung (có NgayBD, NgayKT)
        ChuongTrinhKhuyenMaiBUS ctkmBUS = new ChuongTrinhKhuyenMaiBUS();
        ctkmBUS.docDSCTKM();
        ArrayList<ChuongTrinhKhuyenMaiDTO> dsCTKM = ChuongTrinhKhuyenMaiBUS.ds;

        LocalDate now = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // điều chỉnh đúng format ngày bạn dùng

        for (ChuongTrinhKhuyenMaiSanPhamDTO ctsp : ds) { // ds là danh sách CTKM sản phẩm
            if (ctsp.getMasp() == maSanPham) {
                // Tìm chương trình khuyến mãi chung tương ứng
                for (ChuongTrinhKhuyenMaiDTO ct : dsCTKM) {
                    if (ct.getMaCTKM() == ctsp.getMactkm()) {
                        // Kiểm tra ngày bắt đầu/kết thúc của chương trình
                        LocalDate ngayBD = LocalDate.parse(ct.getNgayBD(), dtf);
                        LocalDate ngayKT = LocalDate.parse(ct.getNgayKT(), dtf);
                        if ((now.isEqual(ngayBD) || now.isAfter(ngayBD))
                                && (now.isEqual(ngayKT) || now.isBefore(ngayKT))) {
                            // CTKM trong thời gian hiệu lực

                            int donGia = new SanPhamBUS().getDonGiaByMaSP(maSanPham);
                            double giaTriGiam = donGia * soLuong * ctsp.getPtgg() / 100.0;

                            tongGiamGia += giaTriGiam;
                        }
                        break; // tìm thấy CTKM chung rồi, thoát vòng lặp
                    }
                }
            }
        }

        return tongGiamGia;
    }
}
