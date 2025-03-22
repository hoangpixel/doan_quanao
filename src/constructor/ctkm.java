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
    public String ngayBD,ngayKT;
    public int maCTKM;
    public ctkm(){
}
    public ctkm(int maCTKM,String ngayBD,String ngayKT)
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

