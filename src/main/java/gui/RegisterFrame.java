package gui;

import com.kelompok1.vinesfinancial.VinesFinancial;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import utility.Signal;


public class RegisterFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RegisterFrame.class.getName());
    public Signal<HashMap<String, Object>> onSigninClicked = new Signal<>();

    public RegisterFrame() {
        initComponents();
        setTitle("Vines Financial");

        loginLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openLogin();
            }

        });
    }

    public void close() {
        setVisible(false);
    }

    public void open() {
        displayWarning();
        setVisible(true);
    }

    public void clear() {
        usernameField.setText("");
        passwordField.setText("");
        confirmPassword.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        signin = new javax.swing.JButton();
        warningLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        confirmPassword = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        loginLink = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(51, 51, 51));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" Vines Financial");
        jLabel1.setToolTipText("");
        jLabel1.setName(""); // NOI18N

        jLabel2.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel3.setText("Password");

        usernameField.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        passwordField.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        signin.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        signin.setText("Sign in");
        signin.addActionListener(this::signinPerformed);

        warningLabel.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        warningLabel.setForeground(new java.awt.Color(255, 0, 0));
        warningLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel4.setText("Confirm Password");

        confirmPassword.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Already have account?");

        loginLink.setFont(new java.awt.Font("Monospaced", 2, 12)); // NOI18N
        loginLink.setForeground(new java.awt.Color(0, 204, 255));
        loginLink.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginLink.setText("Login now.");
        loginLink.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(confirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(signin))
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addComponent(loginLink))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(warningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(3, 3, 3)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addComponent(confirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(signin)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(loginLink))
                .addGap(6, 6, 6)
                .addComponent(warningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void signinPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinPerformed
        onSigninClicked.emit(getSigninInfo());
        //VinesFinancial.querySignin(getSigninInfo());
    }//GEN-LAST:event_signinPerformed

    private void openLogin() {
        VinesFinancial.loginFrame.open();
        dispose();
    }

    public static void main(String args[]) {}
    
    public HashMap<String, Object> getSigninInfo() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user", usernameField.getText().trim());
        map.put("pass", new String(passwordField.getPassword()));
        map.put("passConfirm", new String(confirmPassword.getPassword()));
        return map;
    }

    public void displayWarning() {
        warningLabel.setText("");
    }

    public void displayWarning(String str) {
        warningLabel.setText(str);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirmPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel loginLink;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton signin;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel warningLabel;
    // End of variables declaration//GEN-END:variables
}
