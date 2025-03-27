
package DTO;

public class NhaCungCapDTO {
    private int maNCC;
    private String tenNCC;
    private String sdtNCC;
    private String diaChi;

    public NhaCungCapDTO() {
    }
    
    public NhaCungCapDTO(int maNCC, String tenNCC, String sdtNCC, String diaChi) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.sdtNCC = sdtNCC;
        this.diaChi = diaChi;
    }

    public int getMaNCC() {
        return maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public String getSdtNCC() {
        return sdtNCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public void setSdtNCC(String sdtNCC) {
        this.sdtNCC = sdtNCC;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    
    
}