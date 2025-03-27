/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author suvie
 */
public class LoaiSanPhamDTO {
    //Attributes
    private int maloai;
    private String tenloai;
    //Constructors
    public LoaiSanPhamDTO() {
        maloai = 0;
        tenloai = "";
    }
    public LoaiSanPhamDTO(int maloai, String tenloai) {
        this.maloai = maloai;
        this.tenloai = tenloai;
    }
    public LoaiSanPhamDTO(LoaiSanPhamDTO lsp) {
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
