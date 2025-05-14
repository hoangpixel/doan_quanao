/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DTO.PhieuNhapDTO;
import DAO.PhieuNhapDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    
    public boolean them(PhieuNhapDTO pn){
        PhieuNhapDAO data = new PhieuNhapDAO();
        boolean result = data.them(pn);
        if (result) {
            ds.add(pn);
        }
        return result;
    }
    
    public boolean xoa(int ma){
        PhieuNhapDAO data = new PhieuNhapDAO();
        return data.xoa(ma);
    }
    
    public boolean sua(PhieuNhapDTO pn){
        PhieuNhapDAO data = new PhieuNhapDAO();
        return data.sua(pn);
    }
    
    public boolean ktraMaNV(int ma)
    {
        PhieuNhapDAO data = new PhieuNhapDAO();
        return data.ktraMaNV(ma);
    }
    
    public boolean ktraMaNCC(int ma)
    {
        PhieuNhapDAO data = new PhieuNhapDAO();
        return data.ktraMaNCC(ma);
    }
    public int getAI(){
        PhieuNhapDAO data = new PhieuNhapDAO();
        return data.getAI();
    }
    public ArrayList<PhieuNhapDTO> timKiemThuong(String tim, int index){
        if(ds == null){
            docDSPN();
        }
        ArrayList<PhieuNhapDTO> kq = new ArrayList<>();
        for (PhieuNhapDTO pn : ds) {
            switch (index) {
                case 0:{
                    if(String.valueOf(pn.getMaPN()).contains(tim))
                        kq.add(pn);
                }    
                    break;
                case 1:{
                    if(String.valueOf(pn.getMaNV()).contains(tim))
                        kq.add(pn);
                }
                    break;
                    
                case 2:{
                    if(String.valueOf(pn.getMaNCC()).contains(tim)){
                        kq.add(pn);
                    }
                    break;
                }
                case 3: {
                    if("Chưa xử lí".equals(tim)) {
                        if (pn.getTrangThai() == 0) {
                            kq.add(pn);
                        }
                    } 
                    else if ("Đã xử lí".equals(tim)) {
                        if (pn.getTrangThai() == 1) {
                            kq.add(pn);
                        }
                    }
                    break;
                }
            }
        }
        return kq;
    }
    public boolean ktraMaPN(int ma)
    {
        PhieuNhapDAO data = new PhieuNhapDAO();
        return data.ktraMaPN(ma);
    }
    public boolean ktraHopLe(PhieuNhapDTO ct)
    {
        PhieuNhapDAO data = new PhieuNhapDAO();
        return data.ktraHopLe(ct);
    }
    public long[] tinhDoanhThuTheoQuy(int nam) {
    if (ds == null || ds.isEmpty()) {
        docDSPN(); // Nạp dữ liệu nếu chưa có
    }

    long[] doanhThu = new long[4]; // Q1 → Q4
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    for (PhieuNhapDTO pn : ds) {
        try {
            Date ngay = sdf.parse(pn.getNgayNhap());
            Calendar cal = Calendar.getInstance();
            cal.setTime(ngay);
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH); // 0-based

            if (year == nam) {
                int quy = month / 3; // 0 = Q1, 1 = Q2,...
                doanhThu[quy] += pn.getTongTien();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    return doanhThu;
}
}
