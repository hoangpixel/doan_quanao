package main;

import GUI.NhaCungCapGUI;
import GUI.SanPhamGUI;
import GUI.ctkmspGUI;
import GUI.ctkmGUI;
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


        // Thêm các panel cần hiển thị
        ctkmGUI ctkmPanel = new ctkmGUI();
        contentPanel.add(ctkmPanel, "CTKM");
        ctkmspGUI ctkmspPanel = new ctkmspGUI();
        contentPanel.add(ctkmspPanel,"CTKMSP");
        // panel sản phẩm
        SanPhamGUI sanPhamPanel = new SanPhamGUI();
        contentPanel.add(sanPhamPanel, "SanPham");
        //panel ncc
        NhaCungCapGUI nhaCungCapGUI = new NhaCungCapGUI();
        contentPanel.add(nhaCungCapGUI, "NhaCungCap");

        add(contentPanel, BorderLayout.CENTER);
        

        // Bắt sự kiện các nút trong navleft
        nav.btnCTKM.addActionListener(e -> cardLayout.show(contentPanel, "CTKM"));
        nav.btnCTKMSP.addActionListener(e -> cardLayout.show(contentPanel, "CTKMSP"));
        nav.btnSanPham.addActionListener(e -> cardLayout.show(contentPanel, "SanPham"));
        nav.btnNCC.addActionListener(e -> cardLayout.show(contentPanel, "NhaCungCap"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new run().setVisible(true);
        });
    }
}
