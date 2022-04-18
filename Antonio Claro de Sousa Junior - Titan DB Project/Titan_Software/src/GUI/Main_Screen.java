package GUI;

import javax.swing.table.DefaultTableModel;
import titan_software.ConnectionDB;
public class Main_Screen extends javax.swing.JFrame {

    public static DefaultTableModel dtm;
    public static ConnectionDB con = new ConnectionDB();
    Insert_Screen ins = new Insert_Screen();
    Edit_Screen ed = new Edit_Screen();
    Exit_Screen exi = new Exit_Screen();
    public String type = "WHERE veiculo_estacionado = 0 OR veiculo_estacionado=1";
    
    public Main_Screen() {
        initComponents();
        dtm = new DefaultTableModel();
        jTable1.setModel(dtm);
        dtm.setRowCount(0);
        addColumnDTM();
        con.Entry();
        //jTable1.removeColumn(jTable1.getColumnModel().getColumn(0));
    }
    
    public static void addColumnDTM(){
        dtm.addColumn("id");
        dtm.addColumn("Plate");
        dtm.addColumn("Model");
        dtm.addColumn("Entry");
        dtm.addColumn("Departure");
        dtm.addColumn("Time");
        dtm.addColumn("Value");
        dtm.addColumn("Parked");
        
    }
    
    public static void addRowDTM() {
        dtm.addRow(new Object[]{null,null,null,null,null,null,null,null});
    }
    
    public static void emptyJTable() {
        dtm.setRowCount(0);
    }
    
    public static void setJTable(int line, int id, String plate, String model, String entry, String departure, String time, Double value, boolean parked) {
        String p;
        
        if(parked==true){
            p = "PARKED";
        }
        else{
            p = "NOT PARKED";
        }
        
        addRowDTM();
        jTable1.setValueAt(id,line,0);
        jTable1.setValueAt(plate,line,1);
        jTable1.setValueAt(model,line,2);
        jTable1.setValueAt(entry,line,3);
        jTable1.setValueAt(departure,line,4);
        jTable1.setValueAt(time,line,5);
        jTable1.setValueAt(value,line,6);
        jTable1.setValueAt(p,line,7);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 128, 128));

        jButton1.setBackground(new java.awt.Color(0, 255, 0));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setText("Vehicle Entry");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 255, 0));
        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setText("Vehicle Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 255, 0));
        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setText("Vehicle Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox1.setBackground(new java.awt.Color(0, 255, 0));
        jComboBox1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Vehicles", "Parked Vehicles", "Departed Vehicles" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Plate", "Model", "Entry", "Departure", "Time", "Value", "Parked"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setName(""); // NOI18N
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(60, 60, 60)
                        .addComponent(jButton3)))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ins.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        int s = jComboBox1.getSelectedIndex();
        
        switch(s) {
            case 0:
                type = "WHERE veiculo_estacionado = 0 OR veiculo_estacionado=1";
                break;
            case 1:
                type = "WHERE veiculo_estacionado = 1";
                break;
            case 2:
                type = "WHERE veiculo_estacionado = 0";
                break;
            default:
                break;
        }
        emptyJTable();
        con.Select(type);
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            int id = (int) jTable1.getValueAt(jTable1.getSelectedRow(),0);
            String plate = (String) jTable1.getValueAt(jTable1.getSelectedRow(),1);
            String name = (String) jTable1.getValueAt(jTable1.getSelectedRow(),2);
            ed.setEditor(id,plate,name);
            ed.setVisible(true);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if((String) jTable1.getValueAt(jTable1.getSelectedRow(),7) == "PARKED"){
            try{
                int id = (int) jTable1.getValueAt(jTable1.getSelectedRow(),0);
                String plate = (String) jTable1.getValueAt(jTable1.getSelectedRow(),1);
                String name = (String) jTable1.getValueAt(jTable1.getSelectedRow(),2);
                String entry = (String) jTable1.getValueAt(jTable1.getSelectedRow(),3);
                exi.setExit(id,plate,name,entry);
                exi.setVisible(true);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Screen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
