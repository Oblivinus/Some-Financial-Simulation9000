package gui;

import account.Account;
import account.AccountException;
import com.kelompok1.vinesfinancial.VinesFinancial;
import gui.main.TranferWindow;
import structure.TranferRequest;
import utility.Signal;

public class MainFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainFrame.class.getName());

    TranferWindow tWindow = createTranferWindow();

    public Signal onTranferClicked = new Signal();
    public Signal onWithdrawClicked = new Signal();
    public Signal onDepositClicked = new Signal();
    public Signal onHistoryClicked = new Signal();

    public Signal<TranferRequest> onTranferRequest = new Signal();

    public MainFrame() {
        initComponents();
    }

    public TranferWindow createTranferWindow() {
        TranferWindow tranferWindow = new TranferWindow();

        tranferWindow.getTranferButton().onClicked.connect(e -> {
            TranferRequest info = tranferWindow.getTranferRequest();
            onTranferRequest.emit(info);
        });

        return tranferWindow;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        greetingLabel = new gui.components.MonospaceLabel();
        balanceLabel = new gui.components.MonospaceLabel();
        tranferButton = new gui.components.MonospaceButton();
        depositButton = new gui.components.MonospaceButton();
        withdrawButton = new gui.components.MonospaceButton();
        historyButton = new gui.components.MonospaceButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(510, 500));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" Vines Financial");
        jLabel1.setToolTipText("");
        jLabel1.setName(""); // NOI18N

        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));

        greetingLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        greetingLabel.setText("Hello, User.");
        greetingLabel.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N

        balanceLabel.setText("Balance: Rp. 0");

        tranferButton.setBackground(new java.awt.Color(51, 51, 51));
        tranferButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tranferButton.setText("Tranfer");
        tranferButton.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        tranferButton.addActionListener(this::tranferButtonActionPerformed);

        depositButton.setBackground(new java.awt.Color(51, 51, 51));
        depositButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        depositButton.setText("Desposit");
        depositButton.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        depositButton.addActionListener(this::depositButtonActionPerformed);

        withdrawButton.setBackground(new java.awt.Color(51, 51, 51));
        withdrawButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        withdrawButton.setText("Withdraw");
        withdrawButton.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        withdrawButton.addActionListener(this::withdrawButtonActionPerformed);

        historyButton.setBackground(new java.awt.Color(51, 51, 51));
        historyButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        historyButton.setText("History");
        historyButton.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        historyButton.addActionListener(this::historyButtonActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(balanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(greetingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tranferButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(depositButton, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                        .addComponent(withdrawButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(historyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(greetingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(balanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(316, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addComponent(tranferButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(depositButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(withdrawButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(historyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tranferButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tranferButtonActionPerformed
       tWindow.setVisible(true);
        onTranferClicked.emit(ABORT);
    }//GEN-LAST:event_tranferButtonActionPerformed

    private void depositButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositButtonActionPerformed
        onDepositClicked.emit(ABORT);
    }//GEN-LAST:event_depositButtonActionPerformed

    private void withdrawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawButtonActionPerformed
        onWithdrawClicked.emit(ABORT);
    }//GEN-LAST:event_withdrawButtonActionPerformed

    private void historyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyButtonActionPerformed
        onHistoryClicked.emit(ABORT);
    }//GEN-LAST:event_historyButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
    }

    public void open() {setVisible(true); onOpen();}
    public void close() {setVisible(false);}

    private void onOpen() throws AccountException.InvalidLoggedAccountException{
       Account logged = VinesFinancial.loggedAccount;
       if (logged == null) { throw new AccountException.InvalidLoggedAccountException("Logged Account is null"); }

       String greeingStr = "Hello, %s.".formatted(logged.username);
       String balanceStr = "Balance: Rp. %s".formatted(utility.VinesUtil.formatNumber(logged.balance));
       greetingLabel.setText(greeingStr);
       balanceLabel.setText(balanceStr);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.components.MonospaceLabel balanceLabel;
    private gui.components.MonospaceButton depositButton;
    private gui.components.MonospaceLabel greetingLabel;
    private gui.components.MonospaceButton historyButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private gui.components.MonospaceButton tranferButton;
    private gui.components.MonospaceButton withdrawButton;
    // End of variables declaration//GEN-END:variables
}
