/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constructor;

/**
 *
 * @author suvie
 */
public class ChiTietHoaDon {
    //Attributes
    private int mahoadon;
    private int masanpham;
    private int soluong;
    private int dongia;
    //Constructors
    public ChiTietHoaDon() {
        this.mahoadon = 0;
        this.masanpham = 0;
        this.soluong = 0;
        this.dongia = 0;
    }
    public ChiTietHoaDon(int mahoadon, int masanpham, int soluong, int dongia) {
        this.mahoadon = mahoadon;
        this.masanpham = masanpham;
        this.soluong = soluong;
        this.dongia = dongia;
    }
    public ChiTietHoaDon(ChiTietHoaDon cthd) {
        this.mahoadon = cthd.mahoadon;
        this.masanpham = cthd.masanpham;
        this.soluong = cthd.soluong;
        this.dongia = cthd.dongia;
    }
    //Methods
    //Getter
    public int getMaHoaDon() {
        return mahoadon;
    }
    public int getMaSanPham() {
        return masanpham;
    }
    public int getSoLuong() {
        return soluong;
    }
    public int getDonGia() {
        return dongia;
    }
    public int getThanhTien() {
        return soluong * dongia;
    }
    //Setter
    public void setMaHoaDon(int mahoadon) {
        this.mahoadon = mahoadon;
    }
    public void setMaSanPham(int masanpham) {
        this.masanpham = masanpham;
    }
    public void setSoLuong(int soluong) {
        this.soluong = soluong;
    }
    public void setDonGia(int dongia) {
        this.dongia = dongia;
    }
}
