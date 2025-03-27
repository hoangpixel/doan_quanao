/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constructor;

/**
 *
 * @author suvie
 */
public class LoaiSanPham {
    //Attributes
    private int maloai;
    private String tenloai;
    //Constructors
    public LoaiSanPham() {
        maloai = 0;
        tenloai = "";
    }
    public LoaiSanPham(int maloai, String tenloai) {
        this.maloai = maloai;
        this.tenloai = tenloai;
    }
    public LoaiSanPham(LoaiSanPham lsp) {
        this.maloai = lsp.maloai;
        this.tenloai = lsp.tenloai;
    }
    //Getter
    public int getMaLoai() {
        return maloai;
    }
    public String getTenLoai() {
        return tenloai;
    }
    //Setter
    public void setMaLoai(int maloai) {
        this.maloai = maloai;
    }
    public void setTenLoai(String tenloai) {
        this.tenloai = tenloai;
    }
}
