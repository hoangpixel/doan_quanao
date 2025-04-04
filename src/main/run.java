package main;

import GUI.ChuongTrinhKhuyenMaiHoaDonGUI;
import GUI.NhaCungCapGUI;
import GUI.SanPhamGUI;
import GUI.ChuongTrinhKhuyenMaiSanPhamGUI;
import GUI.ChuongTrinhKhuyenMaiGUI;
import GUI.hoadonGUI;
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
        

        // Bắt sự kiện các nút trong navleft
        nav.btnCTKM.addActionListener(e -> cardLayout.show(contentPanel, "CTKM"));
        nav.btnCTKMSP.addActionListener(e -> cardLayout.show(contentPanel, "CTKMSP"));
        nav.btnSanPham.addActionListener(e -> cardLayout.show(contentPanel, "SanPham"));
        nav.btnNCC.addActionListener(e -> cardLayout.show(contentPanel, "NhaCungCap"));
        nav.btnHoaDon.addActionListener(e -> cardLayout.show(contentPanel, "hoadon"));
        nav.btnCTKMHD.addActionListener(e -> cardLayout.show(contentPanel, "CTKMHD"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new run().setVisible(true);
        });
    }
}
