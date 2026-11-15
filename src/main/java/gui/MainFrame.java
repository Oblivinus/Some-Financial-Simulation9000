package gui;

import account.Account;
import account.AccountException;
import com.kelompok1.vinesfinancial.VinesFinancial;

public class MainFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainFrame.class.getName());

    public MainFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        greetingLabel = new gui.components.MonospaceLabel();
        balanceLabel = new gui.components.MonospaceLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(483, 483));

        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" Vines Financial");
        jLabel1.setToolTipText("");
        jLabel1.setName(""); // NOI18N

        greetingLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        greetingLabel.setText("Hello, User.");
        greetingLabel.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N

        balanceLabel.setText("Balance: Rp. 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(greetingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(balanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(greetingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(balanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
    }

    public void open() {setVisible(true); onOpen();}
    public void close() {setVisible(false);}

    private void onOpen() throws AccountException.InvalidLoggedAccountException{
       Account logged = VinesFinancial.loggedAccount;
       if (logged == null) { throw new AccountException.InvalidLoggedAccountException("Logged Account is null"); }

       String greeingStr = "Hello, %s.".formatted(logged.username);
       greetingLabel.setText(greeingStr);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.components.MonospaceLabel balanceLabel;
    private gui.components.MonospaceLabel greetingLabel;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
