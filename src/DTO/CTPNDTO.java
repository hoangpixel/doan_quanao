/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author laptop
 */
public class CTPNDTO {
    private int maPN;
    private int maSP;
    private int soLuong;
    private int donGia;
    private int thanhTien;

    public CTPNDTO() {
    }

    public CTPNDTO(int maPN, int maSP, int soLuong, int donGia, int thanhTien) {
        this.maPN = maPN;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public int getMaPN() {
        return maPN;
    }

    public int getMaSP() {
        return maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setMaPN(int maPN) {
        this.maPN = maPN;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }
    
    
}
