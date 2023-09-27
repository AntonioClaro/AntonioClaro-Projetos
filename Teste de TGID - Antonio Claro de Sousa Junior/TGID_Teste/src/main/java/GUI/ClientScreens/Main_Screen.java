package GUI.ClientScreens;
import java.util.ArrayList;
import tgid_teste.ConnectionDB;

/**
 *
 * @author WIN10
 */
public class Main_Screen extends javax.swing.JFrame {
    String cnpj;
    ArrayList<Object> clientData;
    
    public Main_Screen() {
        initComponents();
    }
    
    public Main_Screen(String CPF) {
        ConnectionDB con = new ConnectionDB();
        clientData = new ArrayList<Object>();
        
        initComponents();
        clientData = con.data(CPF, "client");
        name.setText(String.valueOf(clientData.get(0)));
        companyName.setText(String.valueOf(clientData.get(3)));
        cpfNumber.setText(String.valueOf(clientData.get(1)));
        amountField.setText(String.valueOf((Double)clientData.get(2)));
        taxField.setText(String.valueOf((Double)clientData.get(4)));
        cnpj = String.valueOf(clientData.get(5));
    }
    
    public Main_Screen(String name, String companyName, String cpfNumber, String amountField, String taxField, String cnpj) {
        initComponents();
        this.name.setText(name);
        this.companyName.setText(companyName);
        this.cpfNumber.setText(cpfNumber);
        this.amountField.setText(amountField);
        this.taxField.setText(taxField);
        this.cnpj = cnpj;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        welcome = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        amountLabel = new javax.swing.JLabel();
        amountField = new javax.swing.JTextField();
        taxLabel = new javax.swing.JLabel();
        taxField = new javax.swing.JTextField();
        companyLabel = new javax.swing.JLabel();
        companyName = new javax.swing.JLabel();
        withdrawBTN = new javax.swing.JButton();
        depositBTN = new javax.swing.JButton();
        cpfLabel = new javax.swing.JLabel();
        cpfNumber = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        background.setBackground(new java.awt.Color(0, 153, 153));

        welcome.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        welcome.setForeground(new java.awt.Color(102, 255, 204));
        welcome.setText("Bem Vindo,");

        name.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        name.setForeground(new java.awt.Color(102, 255, 204));
        name.setText("Nome do Usuario");

        amountLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        amountLabel.setForeground(new java.awt.Color(102, 255, 204));
        amountLabel.setText("Seu Saldo Atual nesta Empresa:");

        amountField.setEditable(false);
        amountField.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        amountField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        amountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountFieldActionPerformed(evt);
            }
        });

        taxLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        taxLabel.setForeground(new java.awt.Color(102, 255, 204));
        taxLabel.setText("Taxa de Sistema para essa Empresa:");

        taxField.setEditable(false);
        taxField.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        taxField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        taxField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taxFieldActionPerformed(evt);
            }
        });

        companyLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        companyLabel.setForeground(new java.awt.Color(102, 255, 204));
        companyLabel.setText("Nome da Sua Empresa:");

        companyName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        companyName.setForeground(new java.awt.Color(102, 255, 204));
        companyName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        companyName.setText("Nome da Empresa");

        withdrawBTN.setBackground(new java.awt.Color(102, 255, 204));
        withdrawBTN.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        withdrawBTN.setText("Sacar");
        withdrawBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawBTNActionPerformed(evt);
            }
        });

        depositBTN.setBackground(new java.awt.Color(102, 255, 204));
        depositBTN.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        depositBTN.setText("Depositar");
        depositBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositBTNActionPerformed(evt);
            }
        });

        cpfLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        cpfLabel.setForeground(new java.awt.Color(102, 255, 204));
        cpfLabel.setText("CPF:");

        cpfNumber.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        cpfNumber.setForeground(new java.awt.Color(102, 255, 204));
        cpfNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cpfNumber.setText("000.000.000-00");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(welcome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(taxLabel)
                                .addGap(198, 198, 198)
                                .addComponent(taxField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(companyLabel)
                                .addGap(18, 18, 18)
                                .addComponent(companyName, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backgroundLayout.createSequentialGroup()
                                    .addComponent(cpfLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cpfNumber))
                                .addGroup(backgroundLayout.createSequentialGroup()
                                    .addComponent(amountLabel)
                                    .addGap(102, 102, 102)
                                    .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(592, 592, 592)
                        .addComponent(withdrawBTN)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(backgroundLayout.createSequentialGroup()
                    .addGap(250, 250, 250)
                    .addComponent(depositBTN)
                    .addContainerGap(895, Short.MAX_VALUE)))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(welcome)
                    .addComponent(name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(companyLabel)
                    .addComponent(companyName))
                .addGap(18, 18, 18)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpfLabel)
                    .addComponent(cpfNumber))
                .addGap(18, 18, 18)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amountLabel)
                    .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(taxLabel)
                    .addComponent(taxField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(104, 104, 104)
                .addComponent(withdrawBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                    .addContainerGap(507, Short.MAX_VALUE)
                    .addComponent(depositBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(53, 53, 53)))
        );

        name.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void amountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountFieldActionPerformed

    private void taxFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taxFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_taxFieldActionPerformed

    private void depositBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositBTNActionPerformed
        Deposit_Screen ds = new Deposit_Screen(Double.parseDouble(amountField.getText()), Double.parseDouble(taxField.getText()), cpfNumber.getText(), cnpj, name.getText(), companyName.getText());
        ds.setVisible(true);
        dispose();
    }//GEN-LAST:event_depositBTNActionPerformed

    private void withdrawBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawBTNActionPerformed
        Withdraw_Screen ws = new Withdraw_Screen(Double.parseDouble(amountField.getText()), Double.parseDouble(taxField.getText()), cpfNumber.getText(), cnpj, name.getText(), companyName.getText());
        ws.setVisible(true);
        dispose();
    }//GEN-LAST:event_withdrawBTNActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Screen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountField;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JPanel background;
    private javax.swing.JLabel companyLabel;
    private javax.swing.JLabel companyName;
    private javax.swing.JLabel cpfLabel;
    private javax.swing.JLabel cpfNumber;
    private javax.swing.JButton depositBTN;
    private javax.swing.JLabel name;
    private javax.swing.JTextField taxField;
    private javax.swing.JLabel taxLabel;
    private javax.swing.JLabel welcome;
    private javax.swing.JButton withdrawBTN;
    // End of variables declaration//GEN-END:variables
}