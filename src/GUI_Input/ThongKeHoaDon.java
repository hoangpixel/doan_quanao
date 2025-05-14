package GUI_Input;

import BUS.HoaDonBUS;
import DTO.HoaDonDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Dialog for selecting a year and displaying quarterly revenue statistics.
 */
public class ThongKeHoaDon extends JDialog {
    private JSpinner yearSpinner;
    private JButton statisticsButton;
    private JTable revenueTable;
    private DefaultTableModel tableModel;
    private HoaDonBUS hoaDonBUS;

    public ThongKeHoaDon(JFrame parent,boolean model) {
        super(parent,"Thống kê doanh thu theo quý",model);
        hoaDonBUS = new HoaDonBUS();
        initComponents();
        setLocationRelativeTo(parent);
    }

    private void initComponents() {
        setLayout(null);
        setSize(400, 400);

        // Year selection panel
        JLabel yearLabel = new JLabel("Chọn năm:");
        yearLabel.setBounds(20, 20, 80, 25);
        add(yearLabel);

        // Spinner for year selection (from 2000 to current year)
        SpinnerNumberModel yearModel = new SpinnerNumberModel(
            Calendar.getInstance().get(Calendar.YEAR), 2000, 
            Calendar.getInstance().get(Calendar.YEAR), 1);
        // yearSpinner = new JSpinner(yearModel);
        // yearSpinner.setBounds(100, 20, 80, 25);
        // add(yearSpinner);
        yearSpinner = new JSpinner(yearModel);
JSpinner.NumberEditor editor = new JSpinner.NumberEditor(yearSpinner, "####");
yearSpinner.setEditor(editor);
yearSpinner.setBounds(100, 20, 80, 25);
add(yearSpinner);


        // Statistics button
        statisticsButton = new JButton("Thống kê");
        statisticsButton.setBounds(200, 20, 100, 25);
        statisticsButton.addActionListener(e -> displayQuarterlyRevenue());
        add(statisticsButton);

        // Table for displaying quarterly revenue
        String[] columns = {"Quý", "Doanh thu"};
        tableModel = new DefaultTableModel(columns, 0);
        revenueTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(revenueTable);
        scrollPane.setBounds(20, 60, 350, 300);
        add(scrollPane);
    }

private void displayQuarterlyRevenue() {
    // Clear existing table data
    tableModel.setRowCount(0);

    int selectedYear = (int) yearSpinner.getValue();

    // Gọi logic từ BUS
    long[] quarterlyRevenue = hoaDonBUS.tinhDoanhThuTheoQuy(selectedYear);

    for (int i = 0; i < 4; i++) {
        tableModel.addRow(new Object[]{
            "Quý " + (i + 1),
            String.format("%,d", quarterlyRevenue[i]) // Format number with commas
        });
    }
}

//
//    public static void main(String[] args) {
//        // For testing purposes
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        ThongKeHoaDon dialog = new ThongKeHoaDon(frame);
//        dialog.setVisible(true);
//    }
}