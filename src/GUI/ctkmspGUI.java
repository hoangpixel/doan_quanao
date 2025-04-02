/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import java.awt.Font;
import javax.swing.*;
import java.util.Vector;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import borderRadius.roundedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import DTO.ChuongTrinhKhuyenMaiSanPhamDTO;
import BUS.ChuongTrinhKhuyenMaiSanPhamBUS;
import GUI_Input.insertCTKMSP;
import GUI_Input.deleteCTKMSP;
import GUI_Input.updateCTKMSP;
/**
 *
 * @author mhoang
 */
public class ctkmspGUI extends javax.swing.JPanel {

    /**
     * Creates new form listCTKM
     */
    DefaultTableModel model = new DefaultTableModel();

    
//  
    public ctkmspGUI() {
        initComponents();
        headerTable();
        docSQL();
    }


    public void headerTable()
    {
        Vector header = new Vector();
        header.add("Mã chương trình khuyến mãi sản phẩm");
        header.add("Mã chương trình khuyến mãi");
        header.add("Mã sản phẩm");
        header.add("Phần trăm giảm giá");
        model = new DefaultTableModel(header,0);
        tbCTKMSP.setModel(model);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        // Căn nội dung ra chính giữa
        for (int i = 0; i < tbCTKMSP.getColumnCount(); i++) {
        tbCTKMSP.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
}

        //căn header ra center
        JTableHeader headerTB = tbCTKMSP.getTableHeader();
        DefaultTableCellRenderer center = (DefaultTableCellRenderer) headerTB.getDefaultRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);
        headerTB.setFont(new Font("Segoe UI",Font.BOLD,14));
    }
    public void docSQL()
    {
        model.setRowCount(0);
        ChuongTrinhKhuyenMaiSanPhamBUS bus = new ChuongTrinhKhuyenMaiSanPhamBUS();

            bus.docDSCTKMSP();
        
        for(ChuongTrinhKhuyenMaiSanPhamDTO ct : ChuongTrinhKhuyenMaiSanPhamBUS.ds)
        {
            Vector row = new Vector();
            row.add(ct.getMactkmsp());
            row.add(ct.getMactkm());
            row.add(ct.getMasp());
            row.add(ct.getPtgg());
            model.addRow(row);
        }
        tbCTKMSP.setModel(model);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        cbTim = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCTKMSP = new javax.swing.JTable();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBorder(new roundedBorder(15)
        );

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/addIcon.png"))); // NOI18N
        btnThem.setText("THÊM");
        btnThem.setToolTipText("");
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/deleteIcon.png"))); // NOI18N
        btnXoa.setText("XÓA");
        btnXoa.setToolTipText("");
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnXoa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editIcon.png"))); // NOI18N
        btnUpdate.setText("SỬA");
        btnUpdate.setToolTipText("");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUpdate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnExcel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.png"))); // NOI18N
        btnExcel.setText("XUẤT EXCEL");
        btnExcel.setToolTipText("");
        btnExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refreshIcon.png"))); // NOI18N
        btnRefresh.setText("REFRESH");
        btnRefresh.setToolTipText("");
        btnRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        cbTim.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbTim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tìm theo mã CTKMSP", "Tìm theo mã CTKM", "Tìm theo mã SP", "Tìm theo PTGG", "Tìm theo PTGG tăng dần", "Tìm theo PTGG giảm dần" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(cbTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoa))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnExcel)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnRefresh))
                                .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch)
                            .addComponent(cbTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbCTKMSP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbCTKMSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCTKMSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCTKMSP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    // Gọi thư mục inputCTKM.java để điền info
    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked

         JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
         insertCTKMSP dialog = new insertCTKMSP(topFrame, true);
         dialog.setVisible(true);
         
         if(dialog.xacNhanNhap())
         {
             ChuongTrinhKhuyenMaiSanPhamDTO km = dialog.getCTKMSP();
             ChuongTrinhKhuyenMaiSanPhamBUS bus = new ChuongTrinhKhuyenMaiSanPhamBUS();
             bus.them(km);
             bus.docDSCTKMSP();
             model.setRowCount(0);
             for(ChuongTrinhKhuyenMaiSanPhamDTO ct : ChuongTrinhKhuyenMaiSanPhamBUS.ds)
             {
                 Vector row = new Vector();
                 row.add(ct.getMactkmsp());
                 row.add(ct.getMactkm());
                 row.add(ct.getMasp());
                 row.add(ct.getPtgg());
                 model.addRow(row);
             }
             tbCTKMSP.setModel(model);
         }
        
    }//GEN-LAST:event_btnThemMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int i = tbCTKMSP.getSelectedRow();
        if(i<0)
        {
           JLabel lbchonMaXoa = new JLabel("Vui lòng chọn mã để xóa");
           lbchonMaXoa.setFont(new Font("Segoe UI",Font.BOLD,16));
           JOptionPane.showMessageDialog(this, lbchonMaXoa,"Chọn mã cần xóa",JOptionPane.ERROR_MESSAGE);
           return;
        }        
        
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        deleteCTKMSP dialog = new deleteCTKMSP(topFrame, true);
        dialog.setVisible(true);
        
        if(dialog.xacNhanXoa())
        {
            int maXoa = (int) tbCTKMSP.getValueAt(i, 0);
            ChuongTrinhKhuyenMaiSanPhamBUS bus = new ChuongTrinhKhuyenMaiSanPhamBUS();
            bus.xoa(maXoa);
            model.removeRow(i);
            JLabel lb = new JLabel("Xóa thành công!");
            lb.setFont(new Font("Segoe UI", Font.BOLD, 16));
            JOptionPane.showMessageDialog(this, lb, "Thông báo", JOptionPane.INFORMATION_MESSAGE);            
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        int i = tbCTKMSP.getSelectedRow();
        if(i<0)
        {
           JLabel lbchonMaXoa = new JLabel("Vui lòng chọn mã để cập nhật");
           lbchonMaXoa.setFont(new Font("Segoe UI",Font.BOLD,16));
           JOptionPane.showMessageDialog(this, lbchonMaXoa,"Chọn mã cần xóa",JOptionPane.ERROR_MESSAGE);
           return;
        }   
        int mactkmsp = (int) tbCTKMSP.getValueAt(i, 0);
        int mactkm = (int) tbCTKMSP.getValueAt(i, 1);
        int masp = (int) tbCTKMSP.getValueAt(i, 2);
        int ptgg = (int) tbCTKMSP.getValueAt(i, 3);
        ChuongTrinhKhuyenMaiSanPhamDTO ct = new ChuongTrinhKhuyenMaiSanPhamDTO(mactkmsp,mactkm,masp,ptgg);
        
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        updateCTKMSP dialog = new updateCTKMSP(topFrame, true, ct);
        dialog.setVisible(true);
        
        if(dialog.xacNhanUpdate())
        {
            ChuongTrinhKhuyenMaiSanPhamDTO km = dialog.getCTKMSP();
            ChuongTrinhKhuyenMaiSanPhamBUS bus = new ChuongTrinhKhuyenMaiSanPhamBUS();
            bus.capnhat(km);
            
            model.setValueAt(km.getMactkm(), i, 1);
            model.setValueAt(km.getMasp(), i, 2);
            model.setValueAt(km.getPtgg(), i, 3);
            
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tbCTKMSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCTKMSPMouseClicked

    }//GEN-LAST:event_tbCTKMSPMouseClicked
    public void updateTB(ArrayList<ChuongTrinhKhuyenMaiSanPhamDTO> dsctkmsp)
    {
        model.setRowCount(0);
        for(ChuongTrinhKhuyenMaiSanPhamDTO ct :dsctkmsp)
        {
            Vector row = new Vector();
            row.add(ct.getMactkmsp());
            row.add(ct.getMactkm());
            row.add(ct.getMasp());
            row.add(ct.getPtgg());
            model.addRow(row);
        }
        tbCTKMSP.setModel(model);
    }
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        
        String tim = txtSearch.getText().trim();
        if(tim.isEmpty())
        {
            docSQL();
            return;
        }
        int i =cbTim.getSelectedIndex();
        ChuongTrinhKhuyenMaiSanPhamBUS bus = new ChuongTrinhKhuyenMaiSanPhamBUS();
        ArrayList<ChuongTrinhKhuyenMaiSanPhamDTO> dsctkmsp = bus.timKiemThuong(tim, i);
        updateTB(dsctkmsp);
        
        if(dsctkmsp.isEmpty())
        {
            String mess = "Không tìm thấy kết quả: " + tim + " trong dữ liệu";
            JLabel lbNull = new JLabel(mess);
            lbNull.setFont(new Font("Segoe UI",Font.BOLD,16));
            JOptionPane.showMessageDialog(this, lbNull,"Thông báo",JOptionPane.ERROR_MESSAGE);     
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        docSQL();
    }//GEN-LAST:event_btnRefreshActionPerformed

   
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbTim;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCTKMSP;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}   
