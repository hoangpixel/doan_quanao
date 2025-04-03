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
    private static ArrayList<SanPhamDTO> dssp;
    
    public void themSanPham(SanPhamDTO sp) {
        if(dssp == null)
            dssp = new ArrayList<>();
        sp.setMaSP(new SanPhamDAO().themSanPham(sp));
        dssp.add(sp);
    }
    
    public void suaSanPham(SanPhamDTO sp) {
        new SanPhamDAO().suaSanPham(sp);
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
        new SanPhamDAO().xoaSanPham(maSP);
        dssp.removeIf(sp -> sp.getMaSP() == maSP);
    }
    
    public SanPhamDTO laySanPhamTheoMaSP(int maSP) {
        return new SanPhamDAO().laySanPhamTheoMaSP(maSP);
    }
    
    public ArrayList<SanPhamDTO> layTatCaSanPham() {
        if(dssp == null){
            dssp = new SanPhamDAO().layTatCaSanPham();
        }
        return dssp;
    }
    
    public void refreshDanhSach() {
        dssp = new SanPhamDAO().layTatCaSanPham();
    }
    
    public static ArrayList<SanPhamDTO> getDanhSachSanPham() {
        return dssp;
    }
    
    public ArrayList<SanPhamDTO> timKiemSanPhamTheoTen (String tenSP) {
        ArrayList<SanPhamDTO> ds = new ArrayList<>();
        if(tenSP != null && !tenSP.isEmpty()) {
            for(int i = 0; i < dssp.size(); i++) {
                if(dssp.get(i).getTenSP().toLowerCase().contains(tenSP)){
                    ds.add(dssp.get(i));
                }
            }
        }
        return ds;
    }
    
    public ArrayList<SanPhamDTO> timKiemSanPhamTheoGiaThapNhat (int giaThapNhat) {
        ArrayList<SanPhamDTO> ds = new ArrayList<>();
        for(int i = 0; i < dssp.size(); i++) {
            if(dssp.get(i).getDonGia() >= giaThapNhat) {
                ds.add(dssp.get(i));
            }
        }
        return ds;
    }
    
    public ArrayList<SanPhamDTO> timKiemSanPhamTheoGiCaoNhat (int giaCaoNhat) {
        ArrayList<SanPhamDTO> ds = new ArrayList<>();
        for(int i = 0; i < dssp.size(); i++) {
            if(dssp.get(i).getDonGia() <= giaCaoNhat) {
                ds.add(dssp.get(i));
            }
        }
        return ds;
    }
    
    public ArrayList<SanPhamDTO> timKiemSanPhamTheoChatLieu (String chatLieu) {
        ArrayList<SanPhamDTO> ds = new ArrayList<>();
        if(chatLieu != null && !chatLieu.isEmpty()) {
            for(int i = 0; i < dssp.size(); i++) {
                if(dssp.get(i).getChatLieu().toLowerCase().contains(chatLieu)){
                    ds.add(dssp.get(i));
                }
            }
        }
        return ds;
    }
    
    public boolean ktraMaSP(int ma)
    {
        SanPhamDAO data = new SanPhamDAO();
        return data.ktraMaSP(ma);
    }
    
}
