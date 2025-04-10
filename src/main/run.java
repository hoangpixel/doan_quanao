package main;

import GUI.ChuongTrinhKhuyenMaiHoaDonGUI;
import GUI.NhaCungCapGUI;
import GUI.SanPhamGUI;
import GUI.ChuongTrinhKhuyenMaiSanPhamGUI;
import GUI.ChuongTrinhKhuyenMaiGUI;
import GUI.KhachHangGUI;
import GUI.PhieuNhapGUI;
import GUI.hoadonGUI;
import GUI.NhanVienGUI;
import GUI.LoaiSanPhamGUI;
import GUI.AoGUI;
import GUI.QuanGUI;
import GUI.navleft;
import java.awt.*;
import javax.swing.*;

public class run extends JFrame {

    private JPanel contentPanel;
    private CardLayout cardLayout;

    public run() {
        setTitle("Quản lý chương trình");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1330, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel trái
        navleft nav = new navleft();
        add(nav, BorderLayout.WEST);

        // Panel phải
        contentPanel = new JPanel();
        cardLayout = new CardLayout();
        contentPanel.setLayout(cardLayout);
	
	nav.btnCTKM.addActionListener(e -> {
        cardLayout.show(contentPanel, "CTKM");
        nav.highlightButton(nav.btnCTKM);
        });

        nav.btnCTKMSP.addActionListener(e -> {
        cardLayout.show(contentPanel, "CTKMSP");
        nav.highlightButton(nav.btnCTKMSP);
        });
        
        nav.btnSanPham.addActionListener(e -> {
        cardLayout.show(contentPanel, "SanPham");
        nav.highlightButton(nav.btnSanPham);
        });
        
        nav.btnNCC.addActionListener(e -> {
        cardLayout.show(contentPanel, "NhaCungCap");
        nav.highlightButton(nav.btnNCC);
        });
        
        nav.btnHoaDon.addActionListener(e -> {
        cardLayout.show(contentPanel, "hoadon");
        nav.highlightButton(nav.btnHoaDon);
        });
        
        nav.btnCTKMHD.addActionListener(e -> {
        cardLayout.show(contentPanel, "CTKMHD");
        nav.highlightButton(nav.btnCTKMHD);
        });
        
        nav.btnKH.addActionListener(e -> {
        cardLayout.show(contentPanel, "khachhang");
        nav.highlightButton(nav.btnKH);
        });
        
        nav.btnPhieuNhap.addActionListener(e -> {
        cardLayout.show(contentPanel, "phieunhap");
        nav.highlightButton(nav.btnPhieuNhap);
        });
        
        nav.btnNhanVien.addActionListener(e -> {
            cardLayout.show(contentPanel, "nhanvien");
            nav.highlightButton(nav.btnNhanVien);
        });
        
        nav.btnLoaiSanPham.addActionListener(e -> {
            cardLayout.show(contentPanel, "loaisanpham");
            nav.highlightButton(nav.btnLoaiSanPham);
        });
        
        nav.btnAo.addActionListener(e -> {
            cardLayout.show(contentPanel, "ao");
            nav.highlightButton(nav.btnAo);
        });
        
        nav.btnQuan.addActionListener(e -> {
            cardLayout.show(contentPanel, "quan");
            nav.highlightButton(nav.btnQuan);
        });
        // Thêm các panel cần hiển thị
        ChuongTrinhKhuyenMaiGUI ctkmPanel = new ChuongTrinhKhuyenMaiGUI();
        contentPanel.add(ctkmPanel, "CTKM");
        ChuongTrinhKhuyenMaiSanPhamGUI ctkmspPanel = new ChuongTrinhKhuyenMaiSanPhamGUI();
        contentPanel.add(ctkmspPanel,"CTKMSP");
        // panel sản phẩm
        SanPhamGUI sanPhamPanel = new SanPhamGUI();
        contentPanel.add(sanPhamPanel, "SanPham");
        //panel ncc
        NhaCungCapGUI nhaCungCapGUI = new NhaCungCapGUI();
        contentPanel.add(nhaCungCapGUI, "NhaCungCap");
        //panel hóa đơn
        hoadonGUI hdPanel = new hoadonGUI();
        contentPanel.add(hdPanel,"hoadon");
        add(contentPanel, BorderLayout.CENTER);
        // panel CTKMHD
        ChuongTrinhKhuyenMaiHoaDonGUI ctkmhdgui = new ChuongTrinhKhuyenMaiHoaDonGUI();
        contentPanel.add(ctkmhdgui,"CTKMHD");
        add(contentPanel, BorderLayout.CENTER);
        // panel KhachHang
        KhachHangGUI khgui = new KhachHangGUI();
        contentPanel.add(khgui,"khachhang");
        add(contentPanel,BorderLayout.CENTER);
        // panel PhieuNhap
        PhieuNhapGUI pn = new PhieuNhapGUI();
        contentPanel.add(pn,"phieunhap");
        add(contentPanel,BorderLayout.CENTER);
        // panel NhanVien
        NhanVienGUI nvgui = new NhanVienGUI();
        contentPanel.add(nvgui, "nhanvien");
        add(contentPanel,BorderLayout.CENTER);
        // panel LoaiSanPham
        LoaiSanPhamGUI lspgui = new LoaiSanPhamGUI();
        contentPanel.add(lspgui, "loaisanpham");
        add(contentPanel,BorderLayout.CENTER);
        // panel Ao
        AoGUI aogui = new AoGUI();
        contentPanel.add(lspgui, "ao");
        add(contentPanel,BorderLayout.CENTER);
        // panel Quan
        QuanGUI quangui = new QuanGUI();
        contentPanel.add(lspgui, "quan");
        add(contentPanel,BorderLayout.CENTER);
        // Bắt sự kiện các nút trong navleft
        nav.btnCTKM.addActionListener(e -> cardLayout.show(contentPanel, "CTKM"));
        nav.btnCTKMSP.addActionListener(e -> cardLayout.show(contentPanel, "CTKMSP"));
        nav.btnSanPham.addActionListener(e -> cardLayout.show(contentPanel, "SanPham"));
        nav.btnNCC.addActionListener(e -> cardLayout.show(contentPanel, "NhaCungCap"));
        nav.btnHoaDon.addActionListener(e -> cardLayout.show(contentPanel, "hoadon"));
        nav.btnCTKMHD.addActionListener(e -> cardLayout.show(contentPanel, "CTKMHD"));
        nav.btnKH.addActionListener(e -> cardLayout.show(contentPanel, "khachhang"));
        nav.btnPhieuNhap.addActionListener(e -> cardLayout.show(contentPanel,"phieunhap" ));
        nav.btnNhanVien.addActionListener(e -> cardLayout.show(contentPanel,"nhanvien"));
        nav.btnLoaiSanPham.addActionListener(e -> cardLayout.show(contentPanel,"loaisanpham"));
        nav.btnAo.addActionListener(e -> cardLayout.show(contentPanel,"ao"));
        nav.btnQuan.addActionListener(e -> cardLayout.show(contentPanel,"quan"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new run().setVisible(true);
        });
    }
}
