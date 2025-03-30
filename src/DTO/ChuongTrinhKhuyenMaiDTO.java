/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author mhoang
 */
public class ChuongTrinhKhuyenMaiDTO {
    public String ngayBD,ngayKT;
    public int maCTKM;
    public ChuongTrinhKhuyenMaiDTO(){                           
}
    public ChuongTrinhKhuyenMaiDTO(int maCTKM,String ngayBD,String ngayKT)
    {
        this.maCTKM=maCTKM;
        this.ngayBD=ngayBD;
        this.ngayKT=ngayKT;
    }

    public int getMaCTKM() {
        return maCTKM;
    }


    public String getNgayBD() {
        return ngayBD;
    }

    public String getNgayKT() {
        return ngayKT;
    }

    public void setMaCTKM(int maCTKM) {
        this.maCTKM = maCTKM;
    }

    public void setNgayBD(String ngayBD) {
        this.ngayBD = ngayBD;
    }

    public void setNgayKT(String ngayKT) {
        this.ngayKT = ngayKT;
    }

    
    
}

