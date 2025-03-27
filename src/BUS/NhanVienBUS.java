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
    static ArrayList <NhanVienDTO> dsnv;
    NhanVienBUS() {}
    void docDSNV() {
        NhanVienDAO data = new NhanVienDAO();
        if(dsnv == null)
            dsnv = new ArrayList<NhanVienDTO>();
        dsnv = data.docDSNV();
    }
    void them(NhanVienDTO nv) {
        NhanVienDAO data = new NhanVienDAO();
        data.them(nv);
        dsnv.add(nv);
    }
}
