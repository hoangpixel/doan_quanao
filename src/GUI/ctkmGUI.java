/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import GUI_Input.insertCTKM;
import GUI_Input.deleteCTKM;
import GUI_Input.updateCTKM;
import BUS.ChuongTrinhKhuyenMaiBUS;
import DTO.ChuongTrinhKhuyenMaiDTO;
import java.awt.Font;
import javax.swing.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import borderRadius.roundedBorder;
import java.lang.reflect.Array;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.util.ArrayList;
/**
 *
 * @author mhoang
 */
public class ctkmGUI extends javax.swing.JPanel {

    /**
     * Creates new form listCTKM
     */
    DefaultTableModel model = new DefaultTableModel();

    
    public ctkmGUI() {
        initComponents();
        headerTable();
        docSQL();
    }
    
    public void docSQL()
    {
        model.setRowCount(0);
        ChuongTrinhKhuyenMaiBUS bus = new ChuongTrinhKhuyenMaiBUS();
        if(ChuongTrinhKhuyenMaiBUS.ds == null)
        {
            bus.docDSCTKM();
        }
        for(ChuongTrinhKhuyenMaiDTO ct : ChuongTrinhKhuyenMaiBUS.ds)
        {
            Vector row = new Vector();
            row.add(ct.getMaCTKM());
            row.add(ct.getNgayBD());
            row.add(ct.getNgayKT());
            model.addRow(row);
        }
        tbCTKM.setModel(model);
    }
    
    public void headerTable()
    {
        Vector header = new Vector();
        header.add("Mã chi tiết khuyến mãi");
        header.add("Ngày bắt đầu");
        header.add("Ngày kết thúc");
        model = new DefaultTableModel(header,0);
        tbCTKM.setModel(model);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        // Căn nội dung ra chính giữa
        for (int i = 0; i < tbCTKM.getColumnCount(); i++) {
        tbCTKM.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
}

        //căn header ra center
        JTableHeader headerTB = tbCTKM.getTableHeader();
        DefaultTableCellRenderer center = (DefaultTableCellRenderer) headerTB.getDefaultRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);
        headerTB.setFont(new Font("Segoe UI",Font.BOLD,14));
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
        tbCTKM = new javax.swing.JTable();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(new roundedBorder(15)
        );

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/addIcon.png"))); // NOI18N
        btnThem.setToolTipText("");
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/deleteIcon.png"))); // NOI18N
        btnXoa.setToolTipText("");
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editIcon.png"))); // NOI18N
        btnUpdate.setToolTipText("");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.png"))); // NOI18N
        btnExcel.setToolTipText("");
        btnExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refreshIcon.png"))); // NOI18N
        btnRefresh.setToolTipText("");
        btnRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        cbTim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tìm theo mã", "Tìm theo ngày nhập", "Tìm theo ngày kết thúc" }));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
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
                .addContainerGap(10, Short.MAX_VALUE))
        );

        tbCTKM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbCTKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCTKMMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCTKM);

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
        insertCTKM dialog = new insertCTKM(topFrame, true);
        dialog.setVisible(true);
        if(dialog.xacNhanInsert())
        {
            ChuongTrinhKhuyenMaiDTO km = dialog.getCTKM();
            ChuongTrinhKhuyenMaiBUS bus = new ChuongTrinhKhuyenMaiBUS();
            bus.them(km);
            bus.docDSCTKM();
            model.setRowCount(0);
            for(ChuongTrinhKhuyenMaiDTO ct : ChuongTrinhKhuyenMaiBUS.ds)
            {
                Vector row = new Vector();
                row.add(ct.getMaCTKM());
                row.add(ct.getNgayBD());
                row.add(ct.getNgayKT());
                model.addRow(row);
            }
            tbCTKM.setModel(model);
        }
    }//GEN-LAST:event_btnThemMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:      
        int i = tbCTKM.getSelectedRow();
        if(i<0)
        {
           JLabel lbchonMaXoa = new JLabel("Vui lòng chọn mã để xóa");
           lbchonMaXoa.setFont(new Font("Segoe UI",Font.BOLD,16));
           JOptionPane.showMessageDialog(this, lbchonMaXoa,"Chọn mã cần xóa",JOptionPane.ERROR_MESSAGE);
           return;
        }
        
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        deleteCTKM dialog = new deleteCTKM(topFrame,true);
        dialog.setVisible(true);
        
        if(dialog.xacNhanXoa())
        {
            int ma = (int) tbCTKM.getValueAt(i, 0);
            ChuongTrinhKhuyenMaiBUS bus = new ChuongTrinhKhuyenMaiBUS();
            bus.xoa(ma);
            model.removeRow(i);
            JLabel lb = new JLabel("Xóa thành công!");
            lb.setFont(new Font("Segoe UI", Font.BOLD, 16));
            JOptionPane.showMessageDialog(this, lb, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        int i = tbCTKM.getSelectedRow();
        if(i<0)
        {
           JLabel lbchonMaXoa = new JLabel("Vui lòng chọn mã để cập nhật");
           lbchonMaXoa.setFont(new Font("Segoe UI",Font.BOLD,16));
           JOptionPane.showMessageDialog(this, lbchonMaXoa,"Chọn mã cần xóa",JOptionPane.ERROR_MESSAGE);
           return;            
        }
        
        int ma = (int) tbCTKM.getValueAt(i, 0);
        String bd = tbCTKM.getValueAt(i, 1).toString();
        String kt = tbCTKM.getValueAt(i, 2).toString();
        
        ChuongTrinhKhuyenMaiDTO ct = new ChuongTrinhKhuyenMaiDTO(ma,bd,kt);
        
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        updateCTKM dialog = new updateCTKM(topFrame, true, ct);
        dialog.setVisible(true);
        
        if(dialog.xacNhanUpdate())
        {
            ChuongTrinhKhuyenMaiBUS bus = new ChuongTrinhKhuyenMaiBUS();
            ChuongTrinhKhuyenMaiDTO km = dialog.getCTKM();
            bus.sua(km);
            
            
            model.setValueAt(km.getNgayBD(), i, 1);
            model.setValueAt(km.getNgayKT(), i, 2);
                    JLabel lbThanhCong = new JLabel("Cập nhật thành công");
                    lbThanhCong.setFont(new Font("Segoe UI",Font.BOLD,16));
                    JOptionPane.showMessageDialog(this, lbThanhCong,"Thông báo",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tbCTKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCTKMMouseClicked

    }//GEN-LAST:event_tbCTKMMouseClicked
    public void updateTB(ArrayList<ChuongTrinhKhuyenMaiDTO> dskq)
    {
        model.setRowCount(0);
        for(ChuongTrinhKhuyenMaiDTO ct : dskq)
        {
            Vector row = new Vector();
            row.add(ct.getMaCTKM());
            row.add(ct.getNgayBD());
            row.add(ct.getNgayKT());
            model.addRow(row);
        }
        tbCTKM.setModel(model);
    }
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String tim = txtSearch.getText().trim();
        if(tim.isEmpty())
        {
            docSQL();
            return;
        }
        int i = cbTim.getSelectedIndex();
        ChuongTrinhKhuyenMaiBUS bus = new ChuongTrinhKhuyenMaiBUS();
        ArrayList<ChuongTrinhKhuyenMaiDTO> kq = bus.timKiemThuong(tim, i);
        updateTB(kq);
        
        String mess ="";
        if(kq.isEmpty())
        {
            mess = "Không tìm thấy kết quả: " + tim + " trong dữ liệu";
        if(i == 1 || i == 2)
        {
            
            String regex = "^\\d{2}/\\d{2}\\/d{4}$";
            if(!tim.matches(regex))
            {
            mess = "Vui lòng nhập đúng định dạng (dd/MM/yyyy)";          
            }
        }
            JLabel lbNull = new JLabel(mess);
            lbNull.setFont(new Font("Segoe UI",Font.BOLD,16));
            JOptionPane.showMessageDialog(this, lbNull,"Thông báo",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnSearchActionPerformed

    
    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        ChuongTrinhKhuyenMaiBUS.ds = null;
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
    private javax.swing.JTable tbCTKM;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}   
