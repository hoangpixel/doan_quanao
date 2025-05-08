/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author laptop
 */
public class PhieuNhapDTO {
    private int maPN;
    private int maNV;
    private int maNCC;
    private int tongTien;
    private String ngayNhap;
    private int trangThai;

    public PhieuNhapDTO() {
    }

    public PhieuNhapDTO(int maPN, int maNV, int maNCC, int tongTien, String ngayNhap, int trangThai) {
        this.maPN = maPN;
        this.maNV = maNV;
        this.maNCC = maNCC;
        this.tongTien = tongTien;
        this.ngayNhap = ngayNhap;
        this.trangThai = trangThai;
    }

    public int getMaPN() {
        return maPN;
    }

    public int getMaNV() {
        return maNV;
    }

    public int getMaNCC() {
        return maNCC;
    }

    public int getTongTien() {
        return tongTien;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }
    
    public int getTrangThai(){
        return trangThai;
    }
    
    public void setMaPN(int maPN) {
        this.maPN = maPN;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
    
    public void setTrangThai(int trangThai){
        this.trangThai = trangThai;
    } 
}
