/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DTO.PhienBanSanPhamDTO;
import DAO.PhienBanSanPhamDAO;
import java.util.ArrayList;
/**
 *
 * @author laptop
 */
public class PhienBanSanPhamBUS {
    public static ArrayList<PhienBanSanPhamDTO> ds;
    
    public PhienBanSanPhamBUS(){}
    public void docDSPB(){
        PhienBanSanPhamDAO data = new PhienBanSanPhamDAO();
        ds = data.docDSPB();
    }
    
    public  ArrayList<PhienBanSanPhamDTO> getPhienBanByMaSP(int masp){
        ArrayList<PhienBanSanPhamDTO> dspb = new ArrayList<>();
        docDSPB();
        try {
            for (PhienBanSanPhamDTO pb : ds) {
                if (pb.getMaSP()== masp) {;
                    dspb.add(pb);
                }
            }
        } catch (Exception e) {
        }
        return dspb;
    }
//    public static void main(String[] args) {
//
//        PhienBanSanPhamBUS bus = new PhienBanSanPhamBUS();
//        
//    System.out.println(bus.getPhienBanByMaSP(1).size());
//    }
}
