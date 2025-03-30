/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author mhoang
 */
public class ChuongTrinhKhuyenMaiSanPhamDTO {
    public int mactkm,mactkmsp,masp,ptgg;
    public ChuongTrinhKhuyenMaiSanPhamDTO(){}
    public ChuongTrinhKhuyenMaiSanPhamDTO(int mactkmsp,int mactkm,int masp,int ptgg)
    {
        this.mactkmsp=mactkmsp;
        this.mactkm=mactkm;
        this.masp=masp;
        this.ptgg=ptgg;
    }

    public int getMactkm() {
        return mactkm;
    }

    public int getMactkmsp() {
        return mactkmsp;
    }

    public int getMasp() {
        return masp;
    }

    public int getPtgg() {
        return ptgg;
    }

    public void setMactkm(int mactkm) {
        this.mactkm = mactkm;
    }

    public void setMactkmsp(int mactkmsp) {
        this.mactkmsp = mactkmsp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public void setPtgg(int ptgg) {
        this.ptgg = ptgg;
    }
    
    
    
    
    
    
    
}
