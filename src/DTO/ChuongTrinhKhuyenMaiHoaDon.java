
package DTO;

public class ChuongTrinhKhuyenMaiHoaDon {
    private int maCTKM;
    private int maCTKMHD;
    private int soTienHD;
    private int phanTramGiamGia;

    public ChuongTrinhKhuyenMaiHoaDon() {
    }

    public ChuongTrinhKhuyenMaiHoaDon(int maCTKM, int maCTKMHD, int soTienHD, int phanTramGiamGia) {
        this.maCTKM = maCTKM;
        this.maCTKMHD = maCTKMHD;
        this.soTienHD = soTienHD;
        this.phanTramGiamGia = phanTramGiamGia;
    }

    public int getMaCTKM() {
        return maCTKM;
    }

    public int getMaCTKMHD() {
        return maCTKMHD;
    }

    public int getSoTienHD() {
        return soTienHD;
    }

    public int getPhanTramGiamGia() {
        return phanTramGiamGia;
    }

    public void setMaCTKM(int maCTKM) {
        this.maCTKM = maCTKM;
    }

    public void setMaCTKMHD(int maCTKMHD) {
        this.maCTKMHD = maCTKMHD;
    }

    public void setSoTienHD(int soTienHD) {
        this.soTienHD = soTienHD;
    }

    public void setPhanTramGiamGia(int phanTramGiamGia) {
        this.phanTramGiamGia = phanTramGiamGia;
    }
    
    
}
