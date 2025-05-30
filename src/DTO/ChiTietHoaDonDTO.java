/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author suvie
 */
public class ChiTietHoaDonDTO {
    //Attributes
    private int mahoadon;
    private int masanpham;
    private int maphienban;
    private int soluong;
    private int dongia;
    private int thanhtien;
    //Constructors
    public ChiTietHoaDonDTO() {
        this.mahoadon = 0;
        this.masanpham = 0;
        this.maphienban = 0;
        this.soluong = 0;
        this.dongia = 0;
        this.thanhtien = 0;
    }
    public ChiTietHoaDonDTO(int mahoadon, int masanpham, int maphienban, int soluong, int dongia, int thanhtien) {
        this.mahoadon = mahoadon;
        this.masanpham = masanpham;
        this.maphienban = maphienban;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
    }
    public ChiTietHoaDonDTO(ChiTietHoaDonDTO cthd) {
        this.mahoadon = cthd.mahoadon;
        this.masanpham = cthd.masanpham;
        this.maphienban = cthd.maphienban;
        this.soluong = cthd.soluong;
        this.dongia = cthd.dongia;
        this.thanhtien = cthd.thanhtien;
    }
    //Getter
    public int getMaHoaDon() {
        return mahoadon;
    }
    public int getMaSanPham() {
        return masanpham;
    }
    public int getMaPhienBan() {
        return maphienban;
    }
    public int getSoLuong() {
        return soluong;
    }
    public int getDonGia() {
        return dongia;
    }
    public int getThanhTien() {
        return thanhtien;
    }
    //Setter
    public void setMaHoaDon(int mahoadon) {
        this.mahoadon = mahoadon;
    }
    public void setMaSanPham(int masanpham) {
        this.masanpham = masanpham;
    }
    public void setMaPhienBan(int maphienban) {
        this.maphienban = maphienban;
    }
    public void setSoLuong(int soluong) {
        this.soluong = soluong;
    }
    public void setDonGia(int dongia) {
        this.dongia = dongia;
    }
    public void setThanhTien(int thanhtien) {
        this.thanhtien = thanhtien;
    }
}
