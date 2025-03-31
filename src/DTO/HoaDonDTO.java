/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author mhoang
 */
public class HoaDonDTO {
    public int mahd,manv,makh,tongtien=0;
    public String ngaylap;
    public HoaDonDTO(){}
    public HoaDonDTO(int mahd,String ngaylap,int manv,int makh,int tongtien)
    {
        this.mahd = mahd;
        this.ngaylap=ngaylap;
        this.manv=manv;
        this.makh=makh;
        this.tongtien=tongtien;
    }

    public int getMahd() {
        return mahd;
    }

    public int getMakh() {
        return makh;
    }

    public int getManv() {
        return manv;
    }

    public String getNgaylap() {
        return ngaylap;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public void setNgaylap(String ngaylap) {
        this.ngaylap = ngaylap;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }
    
    
}
