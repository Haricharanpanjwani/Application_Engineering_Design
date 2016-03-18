/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PatientRole;

import Business.Enterprise.Enterprise;
import Business.Patient.Appointment;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author hpanjwani
 */
public class PrescribeMedicine extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private Patient patient;

    /**
     * Creates new form PrescribeMedicine
     */
    public PrescribeMedicine(JPanel userProcessContainer, UserAccount account, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.enterprise = enterprise;

        patient = (Patient) userAccount.getEmployee();

        patientLabel.setText("Patient Name: " + userAccount.getUsername());
        enterpriseLabel.setText("Hospital Name: " + enterprise.getName());
        diseaseLabel.setText("Symptoms suggest you have: " + patient.getDisease());

        populateColumns();
    }

    public void populateColumns() {

        int size = patient.getAppointmentHistory().getAppointmentHistory().size();

        Appointment appoint = patient.getAppointmentHistory().getAppointmentHistory().get(size - 1);
        
        date.setText("Appointment Date : " + String.valueOf(appoint.getDate()));
        
        notesTextField.setText(appoint.getAdditonalNotes());

        if (!(appoint.getPrescribeLabTest().isEmpty())) {
            resultBtn.setEnabled(true);
            labTestTextField.setText(appoint.getPrescribeLabTest().get(0));
        }

        if (!(appoint.getPrescribeMedicineList().isEmpty())) {
            System.out.println("hello");
            System.out.println(appoint.getPrescribeMedicineList().size());
            if (appoint.getPrescribeMedicineList().size() == 1) {
                medTextField.setVisible(true);
                dosage.setVisible(true);

                medTextField.setText(appoint.getPrescribeMedicineList().get(0).getName());
                dosage.setText(appoint.getPrescribeMedicineList().get(0).getDosage());
            } else if (appoint.getPrescribeMedicineList().size() == 2) {
                medTextField.setVisible(true);
                dosage.setVisible(true);
                med2TextField.setVisible(true);
                dosage2.setVisible(true);

                medTextField.setText(appoint.getPrescribeMedicineList().get(0).getName());
                dosage.setText(appoint.getPrescribeMedicineList().get(0).getDosage());

                med2TextField.setText(appoint.getPrescribeMedicineList().get(1).getName());
                dosage2.setText(appoint.getPrescribeMedicineList().get(1).getDosage());
            } else if (appoint.getPrescribeMedicineList().size() == 3) {
                medTextField.setVisible(true);
                dosage.setVisible(true);
                med2TextField.setVisible(true);
                dosage2.setVisible(true);
                med3TextField.setVisible(true);
                dosage3.setVisible(true);

                medTextField.setText(appoint.getPrescribeMedicineList().get(0).getName());
                dosage.setText(appoint.getPrescribeMedicineList().get(0).getDosage());

                med2TextField.setText(appoint.getPrescribeMedicineList().get(1).getName());
                dosage2.setText(appoint.getPrescribeMedicineList().get(1).getDosage());

                med3TextField.setText(appoint.getPrescribeMedicineList().get(2).getName());
                dosage3.setText(appoint.getPrescribeMedicineList().get(2).getDosage());
            } else if (appoint.getPrescribeMedicineList().size() == 4) {
                System.out.println("hi");

                medTextField.setVisible(true);
                dosage.setVisible(true);
                med2TextField.setVisible(true);
                dosage2.setVisible(true);
                med3TextField.setVisible(true);
                dosage3.setVisible(true);
                med4TextField.setVisible(true);
                dosage4.setVisible(true);

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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backBtn = new javax.swing.JButton();
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
        jLabel1 = new javax.swing.JLabel();
        patientLabel = new javax.swing.JLabel();
        enterpriseLabel = new javax.swing.JLabel();
        resultBtn = new javax.swing.JButton();
        date = new javax.swing.JLabel();
        diseaseLabel = new javax.swing.JLabel();

        backBtn.setText("<< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("PRESCRIBED MEDICINE");

        patientLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        patientLabel.setText("jLabel2");

        enterpriseLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        enterpriseLabel.setText("jLabel3");

        resultBtn.setText("View Result");
        resultBtn.setEnabled(false);
        resultBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultBtnActionPerformed(evt);
            }
        });

        date.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        date.setText("jLabel2");

        diseaseLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        diseaseLabel.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(453, 453, 453)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(388, 388, 388)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(diseaseLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(enterpriseLabel)
                                    .addComponent(patientLabel))
                                .addGap(167, 167, 167)
                                .addComponent(date))
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
                                            .addComponent(dosage, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel14))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(med4TextField)
                                            .addComponent(med3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(dosage3)
                                            .addComponent(dosage4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(labTestTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(resultBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(backBtn)))))
                .addContainerGap(302, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addComponent(patientLabel)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(enterpriseLabel)
                    .addComponent(date))
                .addGap(18, 18, 18)
                .addComponent(diseaseLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Quantity))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dosage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(medTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(med2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dosage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(labTestTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resultBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(backBtn)
                .addContainerGap(109, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed

    private void resultBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultBtnActionPerformed
        // TODO add your handling code here:
        LabHistoryPanel labHistoryPanel = new LabHistoryPanel(userProcessContainer, userAccount, enterprise);
        userProcessContainer.add("LabHistoryPanel", labHistoryPanel);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_resultBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Quantity;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel date;
    private javax.swing.JLabel diseaseLabel;
    private javax.swing.JTextField dosage;
    private javax.swing.JTextField dosage2;
    private javax.swing.JTextField dosage3;
    private javax.swing.JTextField dosage4;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField labTestTextField;
    private javax.swing.JTextField med2TextField;
    private javax.swing.JTextField med3TextField;
    private javax.swing.JTextField med4TextField;
    private javax.swing.JTextField medTextField;
    private javax.swing.JTextArea notesTextField;
    private javax.swing.JLabel patientLabel;
    private javax.swing.JButton resultBtn;
    // End of variables declaration//GEN-END:variables
}
