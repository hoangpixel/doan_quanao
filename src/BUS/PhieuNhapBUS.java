/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DTO.PhieuNhapDTO;
import DAO.PhieuNhapDAO;
import java.util.ArrayList;
/**
 *
 * @author laptop
 */
public class PhieuNhapBUS {
    public static ArrayList<PhieuNhapDTO> ds;

    public PhieuNhapBUS() {
    }
    
    public void docDSPN(){
        PhieuNhapDAO data = new PhieuNhapDAO();
        ds = data.DSPhieuNhapDTOs();
    }
    
    public void them(PhieuNhapDTO pn){
        PhieuNhapDAO data = new PhieuNhapDAO();
        data.them(pn);
    }
    
    public void xoa(int ma){
        PhieuNhapDAO data = new PhieuNhapDAO();
        data.xoa(ma);
    }
    
    public void sua(PhieuNhapDTO pn){
        PhieuNhapDAO data = new PhieuNhapDAO();
        data.sua(pn);
    }
}
