/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daquinta;

import java.sql.*;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author toshiba
 */
public class ListaRestaurantes extends javax.swing.JFrame {

    /**
     * Creates new form ListaRestaurantes
     */
    
    static String dbName = "daquinta_teste"; //Nome do Banco criado
    
    Connection con;
    Statement stmt;
    ResultSet rs;
    int curRow = 0;
    int IDs = 1;
    DB conDB = new DB();
    boolean editar = false, criarnovo=false;
    DefaultListModel modelRestaurantes = new DefaultListModel(); //create a new list model
   
    public ListaRestaurantes() {
        initComponents();
        DoConnect();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSaveRecord1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListRestaurantes = new javax.swing.JList();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnUpdateRecord1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurantes");
        setResizable(false);

        btnSaveRecord1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/118.png"))); // NOI18N
        btnSaveRecord1.setText("Cancelar");
        btnSaveRecord1.setMaximumSize(new java.awt.Dimension(111, 41));
        btnSaveRecord1.setMinimumSize(new java.awt.Dimension(111, 41));
        btnSaveRecord1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveRecord1ActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/120.png"))); // NOI18N
        jLabel9.setText("Clientes | Restaurantes");

        jListRestaurantes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListRestaurantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListRestaurantesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListRestaurantes);

        jLabel1.setText("Fornecedor");

        btnUpdateRecord1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/2.png"))); // NOI18N
        btnUpdateRecord1.setText("Editar");
        btnUpdateRecord1.setMaximumSize(new java.awt.Dimension(111, 41));
        btnUpdateRecord1.setMinimumSize(new java.awt.Dimension(111, 41));
        btnUpdateRecord1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateRecord1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnUpdateRecord1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSaveRecord1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUpdateRecord1, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(btnSaveRecord1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveRecord1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveRecord1ActionPerformed
        // TODO add your handling code here:
        closeApplication();
    }//GEN-LAST:event_btnSaveRecord1ActionPerformed

    private void btnUpdateRecord1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateRecord1ActionPerformed
        // TODO add your handling code here:

        String jtext1;
        jtext1 = (String) jListRestaurantes.getSelectedValue();
        jTextField1.setText(jtext1);
        try {


            //javax.swing.JOptionPane.showMessageDialog( Login.this, "Utilizador Válido"   );
            FormsRestaurantes produ = new  FormsRestaurantes();


            //tipoUtilizador=isValid;
            produ.setUser(jtext1);
            produ.setVisible(true);
            closeApplication();


        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(ListaRestaurantes.this, "ERRO");
        }
    }//GEN-LAST:event_btnUpdateRecord1ActionPerformed

    private void jListRestaurantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListRestaurantesMouseClicked
        String jtext1;
        jtext1 =  (String) jListRestaurantes.getSelectedValue();
        jTextField1.setText(jtext1);
    }//GEN-LAST:event_jListRestaurantesMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaRestaurantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaRestaurantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaRestaurantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaRestaurantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ListaRestaurantes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveRecord1;
    private javax.swing.JButton btnUpdateRecord1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jListRestaurantes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void DoConnect() {
        try {
            
            String host = "jdbc:mysql://localhost:3306/" + dbName;
            String uName = "root";
            String uPass ="admin";
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmt = con.createStatement();
            String sql = "SELECT * FROM restaurantes";
            rs = stmt.executeQuery(sql);
            
            int Tipo;
            
            rs.next();
            rs.beforeFirst();
            
            while (rs.next()){  
               String ItemList = rs.getString("Nome"); //get the element in column "item_code"
               modelRestaurantes.addElement(ItemList); //add each item to the model
               
            }   
        
            jListRestaurantes.setModel(modelRestaurantes);
          
            
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(ListaRestaurantes.this, err.getMessage());
        }
    }

    private void closeApplication() {
        dispose();
    }
}
