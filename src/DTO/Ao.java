/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constructor;

/**
 *
 * @author suvie
 */
public class Ao extends LoaiSanPham {
    //Attributes
    private String tenao;
    //Constructors
    public Ao() {
        super();
        this.tenao = "";
    }
    public Ao(int maloai, String tenloai, String tenao) {
        super(maloai, tenloai);
        this.tenao = tenao;
    }
    public Ao(Ao a) {
        super(a);
        this.tenao = a.tenao;
    }
    //Getter
    public String getTenAo() {
        return tenao;
    }
    //Setter
    public void setTenAo(String tenao) {
        this.tenao = tenao;
    }
}
