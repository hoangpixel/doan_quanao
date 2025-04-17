/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
/**
 *
 * @author suvie
 */
public class NhanVienBUS {

    private static ArrayList<NhanVienDTO> dsnv;
    
    public boolean kiemTraMaNhanVien(int manv) {
        NhanVienDTO nv = layNhanVienTheoMa(manv);
        return nv != null;
    }
    
    public boolean kiemTraHopLe(NhanVienDTO nv) {
        if (nv == null) {
            JOptionPane.showMessageDialog(null, "Dữ liệu nhân viên không được null!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validate Họ
        if (nv.getHo() == null || nv.getHo().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Họ nhân viên không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!Pattern.matches("^[A-Za-zÀ-ỹ\\s-]+$", nv.getHo().trim())) {
            JOptionPane.showMessageDialog(null, "Họ nhân viên chỉ được chứa chữ cái, dấu cách hoặc dấu gạch ngang!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validate Tên
        if (nv.getTen() == null || nv.getTen().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên nhân viên không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!Pattern.matches("^[A-Za-zÀ-ỹ\\s-]+$", nv.getTen().trim())) {
            JOptionPane.showMessageDialog(null, "Tên nhân viên chỉ được chứa chữ cái, dấu cách hoặc dấu gạch ngang!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validate Lương
        if (nv.getLuong() < 1_000_000) {
            JOptionPane.showMessageDialog(null, "Lương phải lớn hơn hoặc bằng " + String.format("%,d", 1_000_000) + "!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validate Số điện thoại
        if (nv.getSDT() == null || nv.getSDT().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!Pattern.matches("^0[0-9]{9}$", nv.getSDT().trim())) {
            JOptionPane.showMessageDialog(null, "Số điện thoại phải là 10 chữ số và bắt đầu bằng 0!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validate Địa chỉ
        if (nv.getDiaChi() == null || nv.getDiaChi().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validate Email
        if (nv.getEmail() == null || nv.getEmail().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Email không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", nv.getEmail().trim())) {
            JOptionPane.showMessageDialog(null, "Email không đúng định dạng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Check for duplicate email (excluding current employee for updates)
        for (NhanVienDTO existingNv : docDSNV()) {
            if (existingNv.getEmail().equalsIgnoreCase(nv.getEmail().trim()) && existingNv.getMa() != nv.getMa()) {
                JOptionPane.showMessageDialog(null, "Email đã được sử dụng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        return true;
    }
    
    public ArrayList<NhanVienDTO> docDSNV() {
        if(dsnv == null) {
            dsnv = new NhanVienDAO().docDSNV();
        }
        return dsnv;
    }
    
    public void them(NhanVienDTO nv) {
        if(dsnv == null) {
            dsnv = new ArrayList<>();
        }
        nv.setMa(new NhanVienDAO().them(nv));
        dsnv.add(nv);
    }
    
    public void sua(NhanVienDTO nv) {
        new NhanVienDAO().sua(nv);
        for(NhanVienDTO nv1 : dsnv) {
            if(nv1.getMa() == nv.getMa()) {
                nv1.setHo(nv.getHo());
                nv1.setTen(nv.getTen());
                nv1.setLuong(nv.getLuong());
                nv1.setSDT(nv.getSDT());
                nv1.setDiaChi(nv.getDiaChi());
                nv1.setEmail(nv.getEmail());
                break;
            }
        }
    }
    
    public void xoa(int manv) {
        new NhanVienDAO().xoa(manv);
        dsnv.removeIf(n -> n.getMa() == manv);
    }
    
    public NhanVienDTO layNhanVienTheoMa(int manv) {
        return new NhanVienDAO().layNhanVienTheoMa(manv);
    }

    public static ArrayList<NhanVienDTO> getDSNV() {
        return dsnv;
    }
    
    public ArrayList<NhanVienDTO> timKiemTheoMaNhanVien(int manv) {
        ArrayList<NhanVienDTO> ds = new ArrayList<>();
        if (dsnv != null) {
            for(NhanVienDTO nv : dsnv) {
                if(nv.getMa() == manv) {
                    ds.add(nv);
                    break;
                }
            }
        }
        return ds;
    }
    
    public ArrayList<NhanVienDTO> timKiemTheoHoTen(String hoten) {
        ArrayList<NhanVienDTO> ds = new ArrayList<>();
        if (hoten != null && !hoten.isEmpty()) {
           for (NhanVienDTO nv : dsnv) {
            String hoTenDayDu = nv.getHo().toLowerCase() + " " + nv.getTen().toLowerCase();
                if (hoTenDayDu.contains(hoten.toLowerCase()) || 
                    nv.getHo().toLowerCase().contains(hoten.toLowerCase())
                    || nv.getTen().toLowerCase().contains(hoten.toLowerCase())) {
                        ds.add(nv);
                }
            }
        }
        return ds;
    }
    
    public ArrayList<NhanVienDTO> timKiemTheoMucLuong(int mucluong) {
        ArrayList<NhanVienDTO> ds = new ArrayList<>();
        for(NhanVienDTO nv : dsnv) {
            if(nv.getLuong() >= mucluong) {
                ds.add(nv);
            }
        }
        return ds;
    }
    
    public ArrayList<NhanVienDTO> timKiemTheoSDT(String sdt) {
        ArrayList<NhanVienDTO> ds = new ArrayList<>();
        if (sdt != null && !sdt.isEmpty()) {
           for (NhanVienDTO nv : dsnv) {
                if (nv.getSDT().toLowerCase().contains(sdt.toLowerCase())) {
                    ds.add(nv);
                }
            }
        }
        return ds;
    }
    
    public ArrayList<NhanVienDTO> timKiemTheoDiaChi(String diachi) {
        ArrayList<NhanVienDTO> ds = new ArrayList<>();
        if (diachi != null && !diachi.isEmpty()) {
           for (NhanVienDTO nv : dsnv) {
                if (nv.getDiaChi().toLowerCase().contains(diachi.toLowerCase())) {
                    ds.add(nv);
                }   
            }
        }
        return ds;
    }
    
    public ArrayList<NhanVienDTO> timKiemTheoEmail(String email) {
        ArrayList<NhanVienDTO> ds = new ArrayList<>();
        if (email != null && !email.isEmpty()) {
           for (NhanVienDTO nv : dsnv) {
                if (nv.getEmail().toLowerCase().contains(email.toLowerCase())) {
                    ds.add(nv);
                }
            }
        }
        return ds;
    }
}
