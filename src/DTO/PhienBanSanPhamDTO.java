
package DTO;

public class PhienBanSanPhamDTO {
    private int maPB;
    private int maSP;
    private String size;
    private String mau;
    private int soLuong;

    public PhienBanSanPhamDTO() {
    }

    public PhienBanSanPhamDTO(int maPB, int maSP, String size, String mau, int soLuong) {
        this.maPB = maPB;
        this.maSP = maSP;
        this.size = size;
        this.mau = mau;
        this.soLuong = soLuong;
    }

    public int getMaPB() {
        return maPB;
    }

    public int getMaSP() {
        return maSP;
    }

    public String getSize() {
        return size;
    }

    public String getMau() {
        return mau;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setMaPB(int maPB) {
        this.maPB = maPB;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    
    
    
}