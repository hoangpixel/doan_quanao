/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.PhienBanSanPhamDTO;
import DAO.PhienBanSanPhamDAO;
import java.util.ArrayList;

/**
 *
 * @author laptop
 */
public class PhienBanSanPhamBUS {

    public static ArrayList<PhienBanSanPhamDTO> ds;

    public PhienBanSanPhamBUS() {
        if (ds == null) {
            ds = new PhienBanSanPhamDAO().docDSPB(); // hoặc new ArrayList<>();
        }
    }

    public void docDSPB() {
        PhienBanSanPhamDAO data = new PhienBanSanPhamDAO();
        ds = data.docDSPB();
    }

    public ArrayList<PhienBanSanPhamDTO> getPhienBanByMaSP(int masp) {
        ArrayList<PhienBanSanPhamDTO> dspb = new ArrayList<>();
        docDSPB();
        try {
            for (PhienBanSanPhamDTO pb : ds) {
                if (pb.getMaSP() == masp) {;
                    dspb.add(pb);
                }
            }
        } catch (Exception e) {
        }
        return dspb;
    }

    public String getPhienBanByMaPB(int mapb) {
        String pb = null;
        if (ds == null) {
            docDSPB();
        }
        try {
            for (PhienBanSanPhamDTO p : ds) {
                if (p.getMaPB() == mapb) {
                    pb = p.getSize() + " - " + p.getMau();
                }
            }
        } catch (Exception e) {
        }
        return pb;
    }
    
    //Nam thêm 2 phần này
    /*public PhienBanSanPhamDTO layPBSPTheoMAPB(int mapb) {
        for (PhienBanSanPhamDTO p : ds) {
            if (p.getMaPB() == mapb) {
                return p; // Return the matching PhienBanSanPhamDTO
            }
        }
        return null;
    }
    
    public static ArrayList<PhienBanSanPhamDTO> getDSPBSP() {
        return ds;
    }*/

    public ArrayList<PhienBanSanPhamDTO> layPBSPTheoMaSP(int masp) {
        return new PhienBanSanPhamDAO().layPBSPTheoMaSP(masp);
    }

    public void themPBSP(PhienBanSanPhamDTO pb) {
        if (ds == null) {
            ds = new ArrayList<>();
        }
        pb.setMaSP(new PhienBanSanPhamDAO().themPBSP(pb));
        ds.add(pb);
    }

    public void suaPBSP(PhienBanSanPhamDTO pb) {
        new PhienBanSanPhamDAO().suaPBSP(pb);
        for (PhienBanSanPhamDTO d : ds) {
            if (d.getMaPB() == pb.getMaPB()) {
                d.setMaSP(pb.getMaSP());
                d.setSize(pb.getSize());
                d.setMau(pb.getMau());
                break;
            }
        }
    }

    public void xoaPBSP(int mapb) {
        new PhienBanSanPhamDAO().xoaPhienBanSanPham(mapb);
        ds.removeIf(d -> d.getMaPB() == mapb);
    }
    public int thayDoiSLPB(int sl, int mapb) {
        PhienBanSanPhamDAO pbspdao = new PhienBanSanPhamDAO();
        return pbspdao.thayDoiSLPB(sl,mapb);
    }
    
    // public int thayDoiSLPBTrongHD(int sl, int mapb) {
    //     PhienBanSanPhamDAO pbspdao = new PhienBanSanPhamDAO();
    //     return pbspdao.thayDoiSLPBTrongHD(sl,mapb);
    // }
    public int thayDoiSLPBTrongHD(int sl, int mapb) {
    System.out.println("Trừ tồn kho: MaPB = " + mapb + ", SL = " + sl);
    int result = 0;
    PhienBanSanPhamDAO pbspdao = new PhienBanSanPhamDAO();
    result = pbspdao.thayDoiSLPBTrongHD(sl, mapb);
    System.out.println("Kết quả trừ tồn kho: " + result);
    return result;
}

        // Hàm kiểm tra số lượng nhập có vượt quá tồn kho không
    public boolean kiemTraTonKho(int maPB, int soLuongNhap) {
                PhienBanSanPhamDAO pbspdao = new PhienBanSanPhamDAO();

        int tonKhoHienTai = pbspdao.getTonKhoByMaPB(maPB);
        return soLuongNhap <= tonKhoHienTai;
    }
}
