package gui;

import account.Account;
import account.AccountException;
import com.kelompok1.vinesfinancial.RequestHandler;
import com.kelompok1.vinesfinancial.VinesFinancial;
import gui.main.deposit.DepositWindow;
import gui.main.tranfer.TranferWindow;
import gui.main.withdraw.WithdrawWindow;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import utility.Signal;

public class MainFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainFrame.class.getName());

    public TranferWindow tWindow = createTranferWindow();
    public DepositWindow dWindow = createDepositWindow();
    public WithdrawWindow wWindow = createWithdrawWindow();

    public Signal onTranferClicked = new Signal();
    public Signal onWithdrawClicked = new Signal();
    public Signal onDepositClicked = new Signal();
    public Signal onHistoryClicked = new Signal();

    public MainFrame() {
        initComponents();

        logoutLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                VinesFinancial.querylogout();
            }

        });
    }

    private TranferWindow createTranferWindow() {
        TranferWindow tranferWindow = new TranferWindow();

        tranferWindow.getTranferButton().onClicked.connect(e -> {
            RequestHandler.Tranfer tranferRequest = tranferWindow.getTranferRequest();
            tranferRequest.resolve();
        });

        return tranferWindow;
    }

    private DepositWindow createDepositWindow() {
        DepositWindow depositWindow = new DepositWindow();

        depositWindow.getConfirmButton().onClicked.connect(e -> {
            RequestHandler.Deposit request = depositWindow.getDepositRequest();
            request.resolve();
        });

        return depositWindow;
    }

    private WithdrawWindow createWithdrawWindow() {
        WithdrawWindow withdrawWindow = new WithdrawWindow();

        withdrawWindow.getConfirmButton().onClicked.connect(e -> {
            RequestHandler.Withdraw request = withdrawWindow.getWithdrawRequest();
            request.resolve();
        });

        return withdrawWindow;
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
        idLabel = new gui.components.MonospaceLabel();
        logoutLink = new javax.swing.JLabel();

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

        idLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        idLabel.setText("012010101001");
        idLabel.setToolTipText("");

        logoutLink.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        logoutLink.setForeground(new java.awt.Color(255, 0, 0));
        logoutLink.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoutLink.setText("LOG OUT");
        logoutLink.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(logoutLink, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(balanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(greetingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addContainerGap()
                .addComponent(greetingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(balanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 326, Short.MAX_VALUE)
                .addComponent(logoutLink)
                .addContainerGap())
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
                    .addContainerGap(59, Short.MAX_VALUE)))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void historyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyButtonActionPerformed
        if (VinesFinancial.isBusy()) return;
        onHistoryClicked.emit(ABORT);
    }//GEN-LAST:event_historyButtonActionPerformed

    private void withdrawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawButtonActionPerformed
        if (VinesFinancial.isBusy()) return;
        wWindow.open();
        onWithdrawClicked.emit(ABORT);
    }//GEN-LAST:event_withdrawButtonActionPerformed

    private void depositButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositButtonActionPerformed
        if (VinesFinancial.isBusy()) return;
        dWindow.open();
        onDepositClicked.emit(ABORT);
    }//GEN-LAST:event_depositButtonActionPerformed

    private void tranferButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tranferButtonActionPerformed
        if (VinesFinancial.isBusy()) return;
        tWindow.open();
        onTranferClicked.emit(ABORT);
    }//GEN-LAST:event_tranferButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
    }

    public void open() {setVisible(true); onOpen();}
    public void close() {setVisible(false);}

    private void onOpen() throws AccountException.InvalidLoggedAccountException{
       Account logged = VinesFinancial.loggedAccount;
       if (logged == null) { throw new AccountException.InvalidLoggedAccountException("Logged Account is null"); }

       String greeingStr = "Hello, %s.".formatted(logged.username);
       String idStr = "%s".formatted(logged.id);
       idLabel.setText(idStr);
       greetingLabel.setText(greeingStr);

       updateVisual(logged);

       logged.balanceChange.connect(e -> updateVisual(logged));
    }

    private void updateVisual(Account logged) {
         String balanceStr = "Balance: Rp. %s".formatted(utility.VinesUtil.formatNumber(logged.balance));
         balanceLabel.setText(balanceStr);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.components.MonospaceLabel balanceLabel;
    private gui.components.MonospaceButton depositButton;
    private gui.components.MonospaceLabel greetingLabel;
    private gui.components.MonospaceButton historyButton;
    private gui.components.MonospaceLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logoutLink;
    private gui.components.MonospaceButton tranferButton;
    private gui.components.MonospaceButton withdrawButton;
    // End of variables declaration//GEN-END:variables
}
