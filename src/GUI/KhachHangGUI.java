
package GUI;

import DTO.KhachHangDTO;
import BUS.KhachHangBUS;
import GUI_Input.XoaKH;
import GUI_Input.ThemKhachHang;
import GUI_Input.SuaKhachHang;
import java.awt.Font;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.util.ArrayList;

/**
 *
 * @author laptop
 */
public class KhachHangGUI extends javax.swing.JPanel {

    /**
     * Creates new form KhachHangGUI
     */
    DefaultTableModel model = new DefaultTableModel();
    
    public KhachHangGUI() {
        initComponents();
        headerTable();
        docDB();
    }
    public void headerTable(){
        Vector header = new Vector();
        header.add("Mã KH");
        header.add("Họ KH");
        header.add("Tên KH");
        header.add("SĐT");
        header.add("Địa chỉ");
        header.add("Email");
        model = new DefaultTableModel(header,0)
                {
                    @Override
                    public boolean isCellEditable(int row,int column)
                {
                    return false;
                }
                };
        tblKH.setModel(model);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        // Căn nội dung ra chính giữa
        for (int i = 0; i < tblKH.getColumnCount(); i++) {
        tblKH.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        //căn header ra center
        JTableHeader headerTB = tblKH.getTableHeader();
        DefaultTableCellRenderer center = (DefaultTableCellRenderer) headerTB.getDefaultRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);
        headerTB.setFont(new Font("Segoe UI",Font.BOLD,14));
    }
    public void docDB(){
        model.setRowCount(0);
        KhachHangBUS khbus = new KhachHangBUS();
        if(KhachHangBUS.ds == null){
            khbus.docDSKH();
        }
        for( KhachHangDTO kh : KhachHangBUS.ds){
            Vector row = new Vector();
            row.add(kh.getMaKH());
            row.add(kh.getHoKH());
            row.add(kh.getTenKH());
            row.add(kh.getSDT());
            row.add(kh.getDiaChi());
            row.add(kh.geteMail());
            model.addRow(row);
        }
        tblKH.setModel(model);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        cbbSearch = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKH = new javax.swing.JTable();

        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/addIcon.png"))); // NOI18N
        btnAdd.setText("THÊM");
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editIcon.png"))); // NOI18N
        btnUpdate.setText("SỬA");
        btnUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUpdate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/deleteIcon.png"))); // NOI18N
        btnDelete.setText("XÓA");
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.png"))); // NOI18N
        btnExcel.setText("XUẤT EXCEL");
        btnExcel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refreshIcon.png"))); // NOI18N
        btnRefresh.setText("REFRESH");
        btnRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        cbbSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã KH", "Họ KH", "Tên KH", "Địa chỉ", "SĐT" }));
        cbbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSearchActionPerformed(evt);
            }
        });

        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                .addComponent(cbbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))))
        );

        tblKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblKH.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblKH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        ThemKhachHang dialog = new ThemKhachHang(topFrame, true);
        dialog.setVisible(true);
        if(dialog.xacNhanThem())
        {
            KhachHangDTO khachhang = dialog.getKH();
            KhachHangBUS khbus = new KhachHangBUS();
            khbus.themKH(khachhang);
            khbus.docDSKH();
            model.setRowCount(0);
            for(KhachHangDTO kh : KhachHangBUS.ds)
            {
                Vector row = new Vector();
                row.add(kh.getMaKH());
                row.add(kh.getHoKH());
                row.add(kh.getTenKH());
                row.add(kh.getSDT());
                row.add(kh.getDiaChi());
                row.add(kh.geteMail());
                model.addRow(row);
            }
            tblKH.setModel(model);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int i = tblKH.getSelectedRow();
        if(i<0)
        {
           JLabel lbchonMaXoa = new JLabel("Vui lòng chọn mã để cập nhật");
           lbchonMaXoa.setFont(new Font("Segoe UI",Font.BOLD,16));
           JOptionPane.showMessageDialog(this, lbchonMaXoa,"Chọn mã cần xóa",JOptionPane.ERROR_MESSAGE);
           return;            
        }
        
        int ma = (int) tblKH.getValueAt(i, 0);
        String hokh = tblKH.getValueAt(i, 1).toString();
        String tenkh = tblKH.getValueAt(i, 2).toString();
        String sdt = tblKH.getValueAt(i, 3).toString();
        String diachi = tblKH.getValueAt(i, 4).toString();
        String email = tblKH.getValueAt(i, 5).toString();
        
        KhachHangDTO kh = new KhachHangDTO(ma, hokh, tenkh, sdt, diachi, email);
        
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        SuaKhachHang dialog = new SuaKhachHang(topFrame, true, kh);
        dialog.setVisible(true);
        
        if(dialog.xacNhanSua())
        {
            KhachHangBUS khbus = new KhachHangBUS();
            KhachHangDTO cus = dialog.getKH();
            khbus.sua(cus);
            model.setValueAt(cus.getHoKH(), i, 1);
            model.setValueAt(cus.getTenKH(), i, 2);
            model.setValueAt(cus.getSDT(), i, 3);
            model.setValueAt(cus.getDiaChi(), i, 4);
            model.setValueAt(cus.geteMail(), i,5);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int i = tblKH.getSelectedRow();
        if(i<0)
        {
           JLabel lbchonMaXoa = new JLabel("Vui lòng chọn mã để xóa");
           lbchonMaXoa.setFont(new Font("Segoe UI",Font.BOLD,16));
           JOptionPane.showMessageDialog(this, lbchonMaXoa,"Chọn mã cần xóa",JOptionPane.ERROR_MESSAGE);
           return;
        }
        
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        XoaKH dialog = new XoaKH(topFrame,true);
        dialog.setVisible(true);
        if(dialog.xacNhanXoa())
        {
            int ma = (int) tblKH.getValueAt(i, 0);
            KhachHangBUS khbus = new KhachHangBUS();
            khbus.xoaKH(ma);
            model.removeRow(i);
            JLabel lb = new JLabel("Xóa thành công!");
            lb.setFont(new Font("Segoe UI", Font.BOLD, 16));
            JOptionPane.showMessageDialog(this, lb, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        KhachHangBUS.ds=null;
        docDB();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void cbbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbSearchActionPerformed
    
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String search = txtSearch.getText().trim();
        if(search.isEmpty())
        {
            docDB();
            return;
        }
        int i = cbbSearch.getSelectedIndex();
        KhachHangBUS khbus = new KhachHangBUS();
        ArrayList<KhachHangDTO> kq = khbus.timKiemThuong(search, i);
        updateTB(kq);

        String mess ="";
        if(kq.isEmpty())
        {
            mess = "Không tìm thấy kết quả: " + search  + " trong dữ liệu";
            JLabel lbNull = new JLabel(mess);
            lbNull.setFont(new Font("Segoe UI",Font.BOLD,16));
            JOptionPane.showMessageDialog(this, lbNull,"Thông báo",JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnSearchActionPerformed
    public void updateTB(ArrayList<KhachHangDTO> dskq)
    {
        model.setRowCount(0);
        for(KhachHangDTO kh : dskq)
        {
            Vector row = new Vector();
            row.add(kh.getMaKH());
            row.add(kh.getHoKH());
            row.add(kh.getTenKH());
            row.add(kh.getSDT());
            row.add(kh.getDiaChi());
            row.add(kh.geteMail());
            model.addRow(row);
        }
        tblKH.setModel(model);
    }
    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbbSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKH;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
