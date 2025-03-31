/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;

/**
 *
 * @author suvie
 */
public class NhanVienBUS {
    public static ArrayList <NhanVienDTO> dsnv;
    public NhanVienBUS() {}
    public void docDSNV() {
        NhanVienDAO data = new NhanVienDAO();
        dsnv = data.docDSNV();
    }
    public void them(NhanVienDTO nv) {
        NhanVienDAO data = new NhanVienDAO();
        data.them(nv);
        dsnv.add(nv);
    }
    public boolean ktraMaNv(int maKtra)
    {
        for(NhanVienDTO nv : dsnv)
        {
            if(nv.getMa() == maKtra)
            {
                return true;
            }
        }
        return false;
    }
    
}
