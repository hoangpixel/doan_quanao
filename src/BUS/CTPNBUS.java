/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DTO.CTPNDTO;
import DAO.CTPNDAO;
import java.util.ArrayList;

/**
 *
 * @author laptop
 */
public class CTPNBUS {
    public static ArrayList<CTPNDTO> ds = new ArrayList<>();
    public CTPNBUS() {}
    
    public void docDSPN(){
        CTPNDAO data = new CTPNDAO();
        ds = data.DSCTPNDAOs();
    }

    public boolean them(CTPNDTO ctpn){
        CTPNDAO data = new CTPNDAO();
        boolean result = data.them(ctpn);
        if (result) {
            ds.add(ctpn);
        }
        return result;
    }

    public boolean sua(CTPNDTO ctpn){
        CTPNDAO data = new CTPNDAO();
        return data.sua(ctpn);
    }

    public boolean xoa(int maPN, int maSP){
        CTPNDAO data = new CTPNDAO();
        return data.xoa(maPN, maSP);
    }      
}
