/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.AoDAO;
import DTO.AoDTO;
import java.util.ArrayList;
/**
 *
 * @author suvie
 */
public class AoBUS {
    
    public static ArrayList<AoDTO> dsa;
    
    public boolean kiemTraMaLoai(int maloai) {
        AoDTO a = layAoTheoMa(maloai);
        return a != null;
    }
    
     public ArrayList<AoDTO> docDSA() {
        if(dsa == null) {
            dsa = new AoDAO().docDSA();
        }
        return dsa;
    }
    
    public void them(AoDTO a) {
        if(dsa == null) {
            dsa = new ArrayList<>();
        }
        a.setMaLoai(new AoDAO().them(a));
        dsa.add(a);
    }
    
    public void sua(AoDTO a) {
        new AoDAO().sua(a);
        for(AoDTO a1 : dsa) {
            if(a1.getMaLoai() == a.getMaLoai()) {
                a1.setTenAo(a.getTenAo());
                break;
            }
        }
    }
    
    public void xoa(int malsp) {
        new AoDAO().xoa(malsp);
        dsa.removeIf(n -> n.getMaLoai() == malsp);
    }
    
    public AoDTO layAoTheoMa(int malsp) {
        return new AoDAO().layAoTheoMa(malsp);
    }

    public static ArrayList<AoDTO> getDSA() {
        return dsa;
    }
    
    public ArrayList<AoDTO> timKiemTheoMa(int malsp) {
        ArrayList<AoDTO> ds = new ArrayList<>();
        if (dsa != null) {
            for(AoDTO lsp : dsa) {
                if(lsp.getMaLoai() == malsp) {
                    ds.add(lsp);
                    break;
                }
            }
        }
        return ds;
    }
    
    public ArrayList<AoDTO> timKiemTheoTen(String ten) {
        ArrayList<AoDTO> ds = new ArrayList<>();
        if (ten != null && !ten.isEmpty()) {
           for (AoDTO a : dsa) {
                if (a.getTenAo().toLowerCase().contains(ten.toLowerCase())) {
                        ds.add(a);
                }
            }
        }
        return ds;
    }
}
