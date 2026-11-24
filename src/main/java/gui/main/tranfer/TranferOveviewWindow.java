package gui.main.tranfer;

import account.AccountServer;
import gui.components.MonospaceButton;
import utility.VinesUtil;

public class TranferOveviewWindow extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TranferOveviewWindow.class.getName());

    
    public TranferOveviewWindow() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        confirmButton = new gui.components.MonospaceButton();
        monospaceLabel1 = new gui.components.MonospaceLabel();
        feeLabel = new gui.components.MonospaceLabel();
        jPanel1 = new javax.swing.JPanel();
        balanceLabel = new gui.components.MonospaceLabel();
        idLabel = new gui.components.MonospaceLabel();
        amountLabel = new gui.components.MonospaceLabel();
        totalLabel = new gui.components.MonospaceLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        confirmButton.setBackground(new java.awt.Color(51, 51, 51));
        confirmButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        confirmButton.setText("Confirm");

        monospaceLabel1.setText("Account:");
        monospaceLabel1.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N

        feeLabel.setText("Fee: Rp. 10");

        jPanel1.setBackground(new java.awt.Color(38, 38, 38));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        balanceLabel.setText("Balance: Rp. 0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(balanceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(balanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        idLabel.setText("Hello - 122200");

        amountLabel.setText("Amount: Rp. 100");
        amountLabel.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N

        totalLabel.setText("Total: Rp. 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 145, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(monospaceLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(feeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(totalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(amountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(monospaceLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(feeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(93, 93, 93)
                    .addComponent(amountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(182, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void setInformation(String accountId, double amount, double balance) {
        String amountFormat = VinesUtil.formatNumber(amount);
        String balanceFormat = VinesUtil.formatNumber(balance);
        String feeFormat = VinesUtil.formatNumber(AccountServer.FEE);
        String totalFormat = VinesUtil.formatNumber( (amount + AccountServer.FEE ) );


        String amountStr = "Amount: Rp. %s".formatted(amountFormat);
        String balanceStr = "Balance: Rp. %s".formatted(balanceFormat);
        String feeStr = "Fee: Rp. %s".formatted(feeFormat);
        String totalStr = "Total: Rp. %s".formatted(feeFormat);

        account.Account account = AccountServer.getAccountById(accountId);
        String idStr = "%s - %s".formatted(account.username, accountId);

        idLabel.setText(idStr);
        amountLabel.setText(amountStr);
        balanceLabel.setText(balanceStr);
        feeLabel.setText(feeStr);
        totalLabel.setText(totalStr);
    }

    public MonospaceButton confirmButton() {
        return confirmButton;
    }

    public void open() {
        setVisible(true);
    }


    public void close() {
        setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.components.MonospaceLabel amountLabel;
    private gui.components.MonospaceLabel balanceLabel;
    private gui.components.MonospaceButton confirmButton;
    private gui.components.MonospaceLabel feeLabel;
    private gui.components.MonospaceLabel idLabel;
    private javax.swing.JPanel jPanel1;
    private gui.components.MonospaceLabel monospaceLabel1;
    private gui.components.MonospaceLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}
