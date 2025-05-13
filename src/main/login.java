/*
 * Modernized login interface with a sleek, elegant design.
 */
package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.RoundRectangle2D;

public class login extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;

    public login() {
        setTitle("Đăng nhập");
        setSize(450, 370);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        // Main panel with gradient background
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gradient = new GradientPaint(0, 0, new Color(94, 114, 228), 0, getHeight(), new Color(29, 79, 145));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setLayout(null);

        // Card panel for login form
        JPanel cardPanel = new JPanel();
        cardPanel.setBackground(new Color(255, 255, 255, 240));
        cardPanel.setBounds(50, 40, 350, 260);
        cardPanel.setLayout(null);
        cardPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Apply rounded corners to card panel
        cardPanel.setOpaque(false);
        cardPanel.setUI(new javax.swing.plaf.basic.BasicPanelUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(cardPanel.getBackground());
                g2d.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
                super.paint(g, c);
            }
        });

        // Title
        JLabel lblTitle = new JLabel("ĐĂNG NHẬP", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitle.setForeground(new Color(33, 37, 41));
        lblTitle.setBounds(20, 20, 310, 30);
        cardPanel.add(lblTitle);

        // Username label and field
        JLabel lblUser = new JLabel("Tài khoản:");
        lblUser.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblUser.setForeground(new Color(33, 37, 41));
        lblUser.setBounds(20, 70, 100, 25);
        cardPanel.add(lblUser);

        txtUsername = new RoundedTextField(10);
        txtUsername.setBounds(20, 95, 310, 35);
        txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtUsername.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        cardPanel.add(txtUsername);

        // Password label and field
        JLabel lblPass = new JLabel("Mật khẩu:");
        lblPass.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblPass.setForeground(new Color(33, 37, 41));
        lblPass.setBounds(20, 135, 100, 25);
        cardPanel.add(lblPass);

        txtPassword = new RoundedPasswordField(10);
        txtPassword.setBounds(20, 160, 310, 35);
        txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPassword.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        cardPanel.add(txtPassword);

        // Login button
        JButton btnLogin = new RoundedButton("Đăng nhập");
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnLogin.setBounds(20, 210, 310, 40);
        btnLogin.setBackground(new Color(52, 152, 219));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setBorder(BorderFactory.createEmptyBorder());
        btnLogin.addActionListener(this::handleLogin);
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogin.setBackground(new Color(41, 128, 185));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogin.setBackground(new Color(52, 152, 219));
            }
        });
        cardPanel.add(btnLogin);

        mainPanel.add(cardPanel);
        add(mainPanel);
    }

    private void handleLogin(ActionEvent e) {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword());

        if (username.equals("admin") && password.equals("123")) {
            JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
            new main().setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Sai tài khoản hoặc mật khẩu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Custom rounded text field
    static class RoundedTextField extends JTextField {
        private Shape shape;

        public RoundedTextField(int size) {
            super(size);
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
            super.paintComponent(g);
        }

        @Override
        protected void paintBorder(Graphics g) {
            g.setColor(new Color(200, 200, 200));
            g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        }

        @Override
        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
            }
            return shape.contains(x, y);
        }
    }

    // Custom rounded password field
    static class RoundedPasswordField extends JPasswordField {
        private Shape shape;

        public RoundedPasswordField(int size) {
            super(size);
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
            super.paintComponent(g);
        }

        @Override
        protected void paintBorder(Graphics g) {
            g.setColor(new Color(200, 200, 200));
            g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        }

        @Override
        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
            }
            return shape.contains(x, y);
        }
    }

    // Custom rounded button
static class RoundedButton extends JButton {
    private Shape shape; // ✅ Thêm dòng này

    public RoundedButton(String text) {
        super(text);
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (getModel().isArmed()) {
            g2d.setColor(getBackground().darker());
        } else {
            g2d.setColor(getBackground());
        }
        g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // No border
    }

    @Override
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        }
        return shape.contains(x, y);
    }
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new login().setVisible(true));
    }
}