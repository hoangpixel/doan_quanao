/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import java.util.ArrayList;

/**
 *
 * @author Vinh
 */
public class SanPhamBUS {
    public static ArrayList<SanPhamDTO> dssp;
    
    public void themSanPham(SanPhamDTO sp) {
        SanPhamDAO spDAO = new SanPhamDAO();
        if(dssp == null)
            dssp = new ArrayList<>();
        sp.setMaSP(spDAO.themSanPham(sp));
        dssp.add(sp);
    }
    
    public void suaSanPham(SanPhamDTO sp) {
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        sanPhamDAO.suaSanPham(sp);
        for(SanPhamDTO spDTO : dssp) {
            if(spDTO.getMaSP() == sp.getMaSP()) {
                spDTO.setChatLieu(sp.getChatLieu());
                spDTO.setDonGia(sp.getDonGia());
                spDTO.setDonViTinh(sp.getDonViTinh());
                spDTO.setMaLoai(sp.getMaLoai());
                spDTO.setMoTa(sp.getMoTa());
                spDTO.setTenSP(sp.getTenSP());
                break;
            }
        }
    }
    
    public void xoaSanPham(int maSP) {
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        sanPhamDAO.xoaSanPham(maSP);
        dssp.removeIf(sp -> sp.getMaSP() == maSP);
    }
    
    public SanPhamDTO laySanPhamTheoMaSP(int maSP) {
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        return sanPhamDAO.laySanPhamTheoMaSP(maSP);
    }
    
    public ArrayList<SanPhamDTO> layTatCaSanPham() {
        if(dssp == null){
            SanPhamDAO sanPhamDAO = new SanPhamDAO();
            dssp = sanPhamDAO.layTatCaSanPham();
        }
        return dssp;
    }
    
    public void refreshDanhSach() {
        SanPhamDAO dao = new SanPhamDAO();
        dssp = dao.layTatCaSanPham();
    }
}
