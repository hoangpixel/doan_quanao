/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.QuanDAO;
import DTO.QuanDTO;
import java.util.ArrayList;

/**
 *
 * @author suvie
 */
public class QuanBUS {
    
    private static ArrayList<QuanDTO> dsq;
    
    public boolean kiemTraMaLoai(int maloai) {
        QuanDTO q = layQuanTheoMa(maloai);
        return q != null;
    }
    
    public ArrayList<QuanDTO> docDSQ() {
        if(dsq == null) {
            dsq = new QuanDAO().docDSQ();
        }
        return dsq;
    }
    
    
    public void them(QuanDTO q) {
        if(dsq == null) {
            dsq = new ArrayList<>();
        }
        q.setMaLoai(new QuanDAO().them(q));
        dsq.add(q);
    }
    
    public void sua(QuanDTO q) {
        new QuanDAO().sua(q);
        for(QuanDTO q1 : dsq) {
            if(q1.getMaLoai() == q.getMaLoai()) {
                q1.setTenQuan(q.getTenQuan());
                break;
            }
        }
    }
    
    public void xoa(int maloai) {
        new QuanDAO().xoa(maloai);
        dsq.removeIf(n -> n.getMaLoai() == maloai);
    }
    
    public QuanDTO layQuanTheoMa(int malsp) {
        return new QuanDAO().layQuanTheoMa(malsp);
    }

    public static ArrayList<QuanDTO> getDSQ() {
        return dsq;
    }
    
    public ArrayList<QuanDTO> timKiemTheoMa(int malsp) {
        ArrayList<QuanDTO> ds = new ArrayList<>();
        if (dsq != null) {
            for(QuanDTO q : dsq) {
                if(q.getMaLoai() == malsp) {
                    ds.add(q);
                    break;
                }
            }
        }
        return ds;
    }
    
    public ArrayList<QuanDTO> timKiemTheoTen(String ten) {
        ArrayList<QuanDTO> ds = new ArrayList<>();
        if (ten != null && !ten.isEmpty()) {
           for (QuanDTO q : dsq) {
                if (q.getTenQuan().toLowerCase().contains(ten.toLowerCase())) {
                        ds.add(q);
                }
            }
        }
        return ds;
    }
}
