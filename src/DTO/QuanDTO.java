/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author suvie
 */
public class QuanDTO extends LoaiSanPhamDTO {
    //Attributes
    private String tenquan;
    //Constructors
    public QuanDTO() {
        super();
        this.tenquan = "";
    }
    public QuanDTO(int maloai, String tenloai, String tenquan) {
        super(maloai, tenloai);
        this.tenquan = tenquan;
    }
    public QuanDTO(QuanDTO q) {
        super(q);
        this.tenquan = q.tenquan;
    }
    //Getter
    public String getTenQuan() {
        return tenquan;
    }
    //Setter
    public void setTenQuan(String tenquan) {
        this.tenquan = tenquan;
    }
}
