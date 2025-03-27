/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author suvie
 */
public class NhanVienDTO {
    //Attributes
    private int ma;
    private String ho;
    private String ten;
    private int luong;
    private String sdt;
    private String diachi;
    private String email;
    //Constructors
    public NhanVienDTO() {
        this.ma = 0;
        this.ho = "";
        this.ten = "";
        this.luong = 0;
        this.sdt = "";
        this.diachi = "";
        this.email = "";
    }
    public NhanVienDTO(int ma, String ho, String ten, int luong, String sdt, String diachi, String email) {
        this.ma = ma;
        this.ho = ho;
        this.ten = ten;
        this.luong = luong;
        this.sdt = sdt;
        this.diachi = diachi;
        this.email = email;
    }
    public NhanVienDTO(NhanVienDTO nv) {
        this.ma = nv.ma;
        this.ho = nv.ho;
        this.ten = nv.ten;
        this.luong = nv.luong;
        this.sdt = nv.sdt;
        this.diachi = nv.diachi;
        this.email = nv.email;
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
