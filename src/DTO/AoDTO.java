/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author suvie
 */
public class AoDTO extends LoaiSanPhamDTO {
    //Attributes
    private String tenao;
    //Constructors
    public AoDTO() {
        super();
        this.tenao = "";
    }
    public AoDTO(int maloai, String tenloai, String tenao) {
        super(maloai, tenloai);
        this.tenao = tenao;
    }
    public AoDTO(AoDTO a) {
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
