/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author suvie
 */
public class NhanVien {
    //Attributes
    private int ma;
    private String ho;
    private String ten;
    private String sdt;
    private String diachi;
    private String email;
    private int luong;
    //Constructors
    public NhanVien() {
        this.ma = 0;
        this.ho = "";
        this.ten = "";
        this.diachi = "";
        this.sdt = "";
        this.email = "";
        this.luong = 0;
    }
    public NhanVien(int ma, String ho, String ten, String sdt, String diachi, String email, int luong) {
        this.ma = ma;
        this.ho = ho;
        this.ten = ten;
        this.diachi = diachi;
        this.sdt = sdt;
        this.email = email;
        this.luong = luong;
    }
    public NhanVien(NhanVien nv) {
        this.ma = nv.ma;
        this.ho = nv.ho;
        this.ten = nv.ten;
        this.diachi = nv.diachi;
        this.sdt = nv.sdt;
        this.email = nv.email;
        this.luong = nv.luong;
    }
    //Getter
    public int getMa() {
        return ma;
    }
    public String getHo() {
        return ho;
    }
    public String getTen() {
        return ten;
    }
    public String getDiaChi() {
        return diachi;
    }
    public String getSDT() {
        return sdt;
    }
    public String getEmail() {
        return email;
    }
    public int getLuong() {
        return luong;
    }
    //Setter
    public void setMa(int ma) {
        this.ma = ma;
    }
    public void setHo(String ho) {
        this.ho = ho;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public void setDiaChi(String diachi) {
        this.diachi = diachi;
    }
    public void setSDT(String sdt) {
        this.sdt = sdt;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setLuong(int luong) {
        this.luong = luong;
    }
}
