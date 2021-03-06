/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PatientRole;

import Business.Patient.Appointment;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hpanjwani
 */
public class AppointmentHistoryPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Patient patient;
    /**
     * Creates new form AppointmentHistoryPanel
     */
    public AppointmentHistoryPanel(JPanel userProcessContainer, UserAccount userAccount) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        
        patient = (Patient)userAccount.getEmployee();
        
        
//        for (Appointment app : patient.getAppointmentHistory().getAppointmentHistory()) {
//            System.out.println(app.getDate() + " " + app.getPrescribeMedicineList());
//        }
        
//        medTextField.setVisible(false);
//        med2TextField.setVisible(false);
//        med3TextField.setVisible(false);
//        med4TextField.setVisible(false);
//        
//        dosage.setVisible(false);
//        dosage2.setVisible(false);
//        dosage3.setVisible(false);
//        dosage4.setVisible(false);
        
        populateAppointmentTable();      
    }
    
    public void populateAppointmentTable()   {
        
        DefaultTableModel model = (DefaultTableModel) appointmentTable.getModel();
        model.setRowCount(0);

        for (Appointment app : patient.getAppointmentHistory().getAppointmentHistory()) {
                Object[] row = new Object[5];

                //request.setMessage("")
                row[0] = app.getDocName();
                row[1] = app;
                row[2] = app.getDisease();
                if(app.getPrescribeMedicineList().size() <= 0)
                    row[3] = "No";
                else
                    row[3] = "Yes";
                if(app.getPrescribeLabTest().size() <= 0)
                    row[4] = "No";
                else 
                    row[4] = "Yes";

                model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        appointmentTable = new javax.swing.JTable();
        backBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        medTextField = new javax.swing.JTextField();
        med2TextField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        med3TextField = new javax.swing.JTextField();
        med4TextField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        labTestTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        notesTextField = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        dosage2 = new javax.swing.JTextField();
        dosage = new javax.swing.JTextField();
        dosage3 = new javax.swing.JTextField();
        dosage4 = new javax.swing.JTextField();
        Quantity = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("APPOINTMENT HISOTRY");

        appointmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Doctor Name", "Appointment Date", "Disease", "Prescribed Medicine", "Prescribed Test"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(appointmentTable);

        backBtn.setText("<< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        jButton1.setText("View Detail");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel12.setText("Medicine 1:");

        medTextField.setEditable(false);

        med2TextField.setEditable(false);

        jLabel13.setText("Medicine 2:");

        jLabel15.setText("Medicine 3:");

        med3TextField.setEditable(false);

        med4TextField.setEditable(false);

        jLabel16.setText("Medicine 4:");

        jLabel14.setText("Lab Test:");

        labTestTextField.setEditable(false);

        jLabel6.setText("Additional Comments");

        notesTextField.setEditable(false);
        notesTextField.setColumns(20);
        notesTextField.setRows(5);
        jScrollPane2.setViewportView(notesTextField);

        jLabel3.setText("Medicine Name");

        dosage2.setEditable(false);

        dosage.setEditable(false);

        dosage3.setEditable(false);

        dosage4.setEditable(false);

        Quantity.setText("Quantity");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(412, 412, 412))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 301, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(med2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dosage2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(dosage, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(71, 71, 71)
                                        .addComponent(jLabel14)
                                        .addGap(18, 18, 18)
                                        .addComponent(labTestTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(Quantity))
                                    .addComponent(medTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(med4TextField)
                            .addComponent(med3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dosage3)
                            .addComponent(dosage4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(backBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1))))
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Quantity))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(medTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(med2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dosage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dosage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)
                        .addComponent(labTestTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(med3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dosage3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(med4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dosage4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(35, 35, 35)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        medTextField.setText("");
        med2TextField.setText("");
        med3TextField.setText("");
        med4TextField.setText("");
        
        dosage.setText("");
        dosage2.setText("");
        dosage3.setText("");
        dosage4.setText("");
        
        labTestTextField.setText("");
        
        int selectedRow = appointmentTable.getSelectedRow();

        if(selectedRow >= 0) {

            Appointment appoint = (Appointment)appointmentTable.getValueAt(selectedRow, 1);
            
            notesTextField.setText(appoint.getAdditonalNotes());
            
            if(!(appoint.getPrescribeLabTest().isEmpty()))
                labTestTextField.setText(appoint.getPrescribeLabTest().get(0));         
            
            if(!(appoint.getPrescribeMedicineList().isEmpty())) {

                if(appoint.getPrescribeMedicineList().size() == 1) {
                    
                    medTextField.setText(appoint.getPrescribeMedicineList().get(0).getName());
                    dosage.setText(appoint.getPrescribeMedicineList().get(0).getDosage());
                } else if(appoint.getPrescribeMedicineList().size() == 2) {
                    
                    medTextField.setText(appoint.getPrescribeMedicineList().get(0).getName());
                    dosage.setText(appoint.getPrescribeMedicineList().get(0).getDosage());
                    
                    med2TextField.setText(appoint.getPrescribeMedicineList().get(1).getName());
                    dosage2.setText(appoint.getPrescribeMedicineList().get(1).getDosage());
                } else if(appoint.getPrescribeMedicineList().size() == 3) {
                    
                    medTextField.setText(appoint.getPrescribeMedicineList().get(0).getName());
                    dosage.setText(appoint.getPrescribeMedicineList().get(0).getDosage());
                    
                    med2TextField.setText(appoint.getPrescribeMedicineList().get(1).getName());
                    dosage2.setText(appoint.getPrescribeMedicineList().get(1).getDosage());
                    
                    med3TextField.setText(appoint.getPrescribeMedicineList().get(2).getName());
                    dosage3.setText(appoint.getPrescribeMedicineList().get(2).getDosage());
                } else if(appoint.getPrescribeMedicineList().size() == 4) {
                    
                    medTextField.setText(appoint.getPrescribeMedicineList().get(0).getName());
                    dosage.setText(appoint.getPrescribeMedicineList().get(0).getDosage());
                    
                    med2TextField.setText(appoint.getPrescribeMedicineList().get(1).getName());
                    dosage2.setText(appoint.getPrescribeMedicineList().get(1).getDosage());
                    
                    med3TextField.setText(appoint.getPrescribeMedicineList().get(2).getName());
                    dosage3.setText(appoint.getPrescribeMedicineList().get(2).getDosage());
                    
                    med4TextField.setText(appoint.getPrescribeMedicineList().get(2).getName());
                    dosage4.setText(appoint.getPrescribeMedicineList().get(2).getDosage());
                }           
            }

//            VitalSign = appoint.ge
//            
//            respRateTextField.setText(String.valueOf(vs.getRespRate()));
//            heartRateTextField.setText(String.valueOf(vs.getHeartRate()));
//            bpTextField.setText(String.valueOf(vs.getBp()));
//            weightTextField.setText(String.valueOf(vs.getWeight()));
//            
//            glucoseTextField.setText(String.valueOf(vs.getGlucose()));
//            plateletsTextField.setText(String.valueOf(vs.getPlatelets()));
//            pulseTextField.setText(String.valueOf(vs.getPulse()));
//            tempTextField.setText(String.valueOf(vs.getTemp()));
//            hemoTextField.setText(String.valueOf(vs.getHemo()));
//            bloodGroupTextField.setText(vs.getBloodGroup());
        }   else    {
            JOptionPane.showMessageDialog(this, "Please select a row!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Quantity;
    private javax.swing.JTable appointmentTable;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField dosage;
    private javax.swing.JTextField dosage2;
    private javax.swing.JTextField dosage3;
    private javax.swing.JTextField dosage4;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField labTestTextField;
    private javax.swing.JTextField med2TextField;
    private javax.swing.JTextField med3TextField;
    private javax.swing.JTextField med4TextField;
    private javax.swing.JTextField medTextField;
    private javax.swing.JTextArea notesTextField;
    // End of variables declaration//GEN-END:variables
}
