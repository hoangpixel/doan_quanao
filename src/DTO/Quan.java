/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author suvie
 */
public class Quan extends LoaiSanPham {
    //Attributes
    private String tenquan;
    //Constructors
    public Quan() {
        super();
        this.tenquan = "";
    }
    public Quan(int maloai, String tenloai, String tenquan) {
        super(maloai, tenloai);
        this.tenquan = tenquan;
    }
    public Quan(Quan q) {
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
