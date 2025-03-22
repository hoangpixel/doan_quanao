/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constructor;

/**
 *
 * @author mhoang
 */
public class ctkm {
    public String maCTKM,ngayBD,ngayKT;
    public ctkm(){
}
    public ctkm(String maCTKM,String ngayBD,String ngayKT)
    {
        this.maCTKM=maCTKM;
        this.ngayBD=ngayBD;
        this.ngayKT=ngayKT;
    }

    public String getMaCTKM() {
        return maCTKM;
    }

    public String getNgayBD() {
        return ngayBD;
    }

    public String getNgayKT() {
        return ngayKT;
    }

    public void setMaCTKM(String maCTKM) {
        this.maCTKM = maCTKM;
    }

    public void setNgayBD(String ngayBD) {
        this.ngayBD = ngayBD;
    }

    public void setNgayKT(String ngayKT) {
        this.ngayKT = ngayKT;
    }

    
    
}

