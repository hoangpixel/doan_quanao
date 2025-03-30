/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;

/**
 *
 * @author Vinh
 */
public class NhaCungCapBUS {
    private static ArrayList<NhaCungCapDTO> dsncc;
    
    public void themNCC(NhaCungCapDTO ncc) {
        if(dsncc == null) {
            dsncc = new ArrayList<>();
        }
        ncc.setMaNCC(new NhaCungCapDAO().themNCC(ncc));
        dsncc.add(ncc);
    }
    
    public void suaNCC (NhaCungCapDTO ncc) {
        new NhaCungCapDAO().suaNCC(ncc);
        for(NhaCungCapDTO n : dsncc) {
            if(n.getMaNCC() == ncc.getMaNCC()) {
                n.setTenNCC(ncc.getTenNCC());
                n.setSdtNCC(ncc.getSdtNCC());
                n.setDiaChi(ncc.getDiaChi());
                break;
            }
        }
    }
    
    public void xoaNCC (int maNCC) {
        new NhaCungCapDAO().xoaNCC(maNCC);
        dsncc.removeIf(n -> n.getMaNCC() == maNCC);
    }
    
    public NhaCungCapDTO layNCCTheoMa(int maNCC) {
        return new NhaCungCapDAO().layNCCTheoMaNCC(maNCC);
    }
    
    public ArrayList<NhaCungCapDTO> layTatCaNCC () {
        if(dsncc == null) {
            dsncc = new NhaCungCapDAO().layTatCaNCC();
        }
        return dsncc;
    }
    
    public void refreshDanhSac () {
        dsncc = new NhaCungCapDAO().layTatCaNCC();
    }

    public static ArrayList<NhaCungCapDTO> getDsncc() {
        return dsncc;
    }

    
    
}
