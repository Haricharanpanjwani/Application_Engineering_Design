package UserInterface.SupplierRole;

import Business.Supplier;
import Business.SupplierDirectory;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Mihir Mehta / Hechen Gao
 */
public class LoginSupplier extends javax.swing.JPanel {
    
    private SupplierDirectory supplierDirectory;
    private JPanel userProcessContainer;
    
    public LoginSupplier(SupplierDirectory supplierDirectory, JPanel userProcessContainer) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.supplierDirectory = supplierDirectory;
        
        supplierComboBox.removeAllItems();
        
        for(Supplier supplier : supplierDirectory.getSupplierList())
            supplierComboBox.addItem(supplier);
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        sNmaeTextField1 = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        supplierComboBox = new javax.swing.JComboBox();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Supplier Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, 30));

        sNmaeTextField1.setEditable(false);
        sNmaeTextField1.setBorder(null);
        sNmaeTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sNmaeTextField1ActionPerformed(evt);
            }
        });
        add(sNmaeTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 150, 30));

        btnFind.setText("GO>>");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });
        add(btnFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, -1, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Supplier Login");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, -1, -1));

        supplierComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        supplierComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierComboBoxActionPerformed(evt);
            }
        });
        add(supplierComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 150, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
            
        Supplier supplier = (Supplier)supplierComboBox.getSelectedItem();
        SupplierWorkAreaJPanel swjp = new SupplierWorkAreaJPanel(supplier, userProcessContainer);
        userProcessContainer.add("SupplierWorkArea", swjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer); 
    }//GEN-LAST:event_btnFindActionPerformed

    private void supplierComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierComboBoxActionPerformed

    }//GEN-LAST:event_supplierComboBoxActionPerformed

    private void sNmaeTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sNmaeTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sNmaeTextField1ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFind;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField sNmaeTextField1;
    private javax.swing.JComboBox supplierComboBox;
    // End of variables declaration//GEN-END:variables
    
}
