
package DTO;

public class SanPhamDTO {
    private int maSP;
    private String tenSP;
    private int donGia;
    private String donViTinh;
    private String chatLieu;
    private String maLoai;
    private String moTa;

    public SanPhamDTO() {
    }

    public SanPhamDTO(int maSP, String tenSP, int donGia, String donViTinh, String chatLieu, String maLoai, String moTa) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.donViTinh = donViTinh;
        this.chatLieu = chatLieu;
        this.maLoai = maLoai;
        this.moTa = moTa;
    }

    public int getMaSP() {
        return maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public int getDonGia() {
        return donGia;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
    
}