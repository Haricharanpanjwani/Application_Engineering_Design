package UserInterface.SupplierRole;

import Business.Product;
import Business.ProductCatalog;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Mihir Mehta / Hechen Gao
 */
public class SearchForProductJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private ManageProductCatalogJPanel managePanel;
    private ProductCatalog productCatalog;
    
    public SearchForProductJPanel(ProductCatalog productCatalog, JPanel userProcessContainer, ManageProductCatalogJPanel managePanel) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.productCatalog = productCatalog;
        this.managePanel = managePanel;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Search for Product");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 25, -1, 52));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Product Id");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 116, -1, -1));

        searchTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(searchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 145, 250, -1));

        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSearch.setText("Search Now >>");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 144, 160, -1));

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        
        int id = Integer.parseInt(searchTextField.getText());
        
        Product product = productCatalog.searchProduct(id);
        
        if(product == null) {
            JOptionPane.showMessageDialog(this, "No Product Available with this Product ID!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
        }
        else    {
            
            ViewProductDetailJPanel viewProduct = new ViewProductDetailJPanel(product, userProcessContainer, managePanel);
            userProcessContainer.add("ViewProductPanel",viewProduct);
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
}//GEN-LAST:event_btnSearchActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField searchTextField;
    // End of variables declaration//GEN-END:variables
}
