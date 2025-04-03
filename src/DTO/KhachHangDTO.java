/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author laptop
 */
public class KhachHangDTO {
    private int maKH;
    private String hoKH;
    private String tenKH;
    private String SDT;
    private String diaChi;
    private String eMail;

    public KhachHangDTO() {
    }

    public KhachHangDTO(int maKH, String hoKH, String tenKH, String SDT, String diaChi, String eMail) {
        this.maKH = maKH;
        this.hoKH = hoKH;
        this.tenKH = tenKH;
        this.SDT = SDT;
        this.diaChi = diaChi;
        this.eMail = eMail;
    }

    public int getMaKH() {
        return maKH;
    }

    public String getHoKH() {
        return hoKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String geteMail() {
        return eMail;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public void setHoKH(String hoKH) {
        this.hoKH = hoKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    
    
}
