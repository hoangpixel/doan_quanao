/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.LoaiSanPhamDAO;
import DTO.LoaiSanPhamDTO;
import java.util.ArrayList;

/**
 *
 * @author suvie
 */
public class LoaiSanPhamBUS {
    
    private static ArrayList<LoaiSanPhamDTO> dslsp;
    
    public boolean kiemTraMaLoai(int malsp) {
        LoaiSanPhamDTO lsp = layLSPTheoMa(malsp);
        return lsp != null;
    }
    
    public ArrayList<LoaiSanPhamDTO> docDSLSP() {
        if(dslsp == null) {
            dslsp = new LoaiSanPhamDAO().docDSLSP();
        }
        return dslsp;
    }
    
    public void them(LoaiSanPhamDTO lsp) {
        if(dslsp == null) {
            dslsp = new ArrayList<>();
        }
        lsp.setMaLoai(new LoaiSanPhamDAO().them(lsp));
        dslsp.add(lsp);
    }
    
    public void sua(LoaiSanPhamDTO lsp) {
        new LoaiSanPhamDAO().sua(lsp);
        for(LoaiSanPhamDTO lsp1 : dslsp) {
            if(lsp1.getMaLoai() == lsp.getMaLoai()) {
                lsp1.setTenLoai(lsp.getTenLoai());
                break;
            }
        }
    }
    
    public void xoa(int malsp) {
        new LoaiSanPhamDAO().xoa(malsp);
        dslsp.removeIf(n -> n.getMaLoai() == malsp);
    }
    
    public LoaiSanPhamDTO layLSPTheoMa(int malsp) {
        return new LoaiSanPhamDAO().layLSPTheoMaLoai(malsp);
    }
    
    public static ArrayList<LoaiSanPhamDTO> getDSLSP() {
        return dslsp;
    }
    
    public ArrayList<LoaiSanPhamDTO> timKiemTheoMa(int malsp) {
        ArrayList<LoaiSanPhamDTO> ds = new ArrayList<>();
        if (dslsp != null) {
            for(LoaiSanPhamDTO lsp : dslsp) {
                if(lsp.getMaLoai() == malsp) {
                    ds.add(lsp);
                    break;
                }
            }
        }
        return ds;
    }
    
    public ArrayList<LoaiSanPhamDTO> timKiemTheoTen(String ten) {
        ArrayList<LoaiSanPhamDTO> ds = new ArrayList<>();
        if (ten != null && !ten.isEmpty()) {
           for (LoaiSanPhamDTO lsp : dslsp) {
                if (lsp.getTenLoai().toLowerCase().contains(ten.toLowerCase())) {
                        ds.add(lsp);
                }
            }
        }
        return ds;
    }
}
