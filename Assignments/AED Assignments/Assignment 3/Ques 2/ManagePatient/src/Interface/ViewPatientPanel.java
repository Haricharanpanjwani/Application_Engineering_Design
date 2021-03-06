/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.Patient;
import Business.Person;
import Business.VitalSign;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hpanjwani
 */
public class ViewPatientPanel extends javax.swing.JPanel {
   
    private Person person;
    private ArrayList<Patient> patientList;
    private Patient patient;
    private JPanel userProcessContainer;
    private int age;
    
    /**
     * Creates new form ViewPatientPanel
     */
    public ViewPatientPanel(Person person, JPanel userProcessContainer) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.person = person;
        patientList = this.person.getPatientList();
        patient = patientList.get(0);
        
        age = patient.getAge();
        
        ID.setText(String.valueOf(patient.getpID()));
        
        pIDTextField.setText(String.valueOf(patient.getpID()));
        nameTextField.setText(patient.getpName());
        ageTextField.setText(String.valueOf(patient.getAge()));
        docNameTextField.setText(patient.getDocName());
        pharmacyTextField.setText(patient.getPharmacy());
        
        populateTable();
    }
    
    public void populateTable() {
        
        //Get the Table Model
        DefaultTableModel dtm = (DefaultTableModel)patientTable.getModel();
        
        dtm.setRowCount(0);
        
        for(VitalSign vs :  patient.getVitalSignHistory().getVitalSignList())   {   
            Object row[] = new Object[2];
            
            row[0] = vs;
            
            if(age >= 1 && age <= 3)   {
                if( ((vs.getRespRate() < 20) || (vs.getRespRate() > 30)) ||
                     (vs.getHeartRate() < 80) || (vs.getHeartRate() > 130) ||
                     (vs.getBp() < 80) || (vs.getBp() > 110) ||
                     (vs.getWeight() < 22) || (vs.getWeight() > 31))  
                {
                    row[1] = "Abnormal";
                }
                else    {
                    row[1] = "Normal";
                }
            }
            else if(age >= 4 && age <= 5)   {
                if( ((vs.getRespRate() < 20) || (vs.getRespRate() > 30)) ||
                     (vs.getHeartRate() < 80) || (vs.getHeartRate() > 120) ||
                     (vs.getBp() < 80) || (vs.getBp() >= 110) ||
                     (vs.getWeight() < 31) || (vs.getWeight() > 40))  
                {
                    row[1] = "Abormal";
                }
                else    {
                    row[1] = "Normal";
                }
            }
            else if(age >= 6 && age <= 12)   {
                if( ((vs.getRespRate() < 20) || (vs.getRespRate() > 30)) ||
                     (vs.getHeartRate() < 70) || (vs.getHeartRate() > 110) ||
                     (vs.getBp() < 80) || (vs.getBp() >= 120) ||
                     (vs.getWeight() < 41) || (vs.getWeight() >= 92))  
                {
                    row[1] = "Abnormal";
                }
                else    {
                    row[1] = "Normal";
                }
            }
            else {
                if( ((vs.getRespRate() < 12) || (vs.getRespRate() > 20)) ||
                     (vs.getHeartRate() < 55) || (vs.getHeartRate() > 105) ||
                     (vs.getBp() < 110) || (vs.getBp() >= 120) ||
                     (vs.getWeight() < 110))
                {
                    row[1] = "Abnormal";
                }
                else    {
                    row[1] = "Normal";
                }
            }
            
            
            //add each person to the table for dispalay
            dtm.addRow(row);
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
        jLabel2 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pIDTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ageTextField = new javax.swing.JTextField();
        docNameTextField = new javax.swing.JTextField();
        pharmacyTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientTable = new javax.swing.JTable();
        viewBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        respRate = new javax.swing.JLabel();
        heartRate = new javax.swing.JLabel();
        bp = new javax.swing.JLabel();
        weight = new javax.swing.JLabel();
        Hint = new javax.swing.JButton();
        status = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        addVitalBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("VIEW PATIENT INFORMATION #");

        jLabel2.setBackground(new java.awt.Color(255, 255, 204));
        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("Patient Name:");

        nameTextField.setEditable(false);
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 204));
        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setText("Patient ID:");

        pIDTextField.setEditable(false);

        jLabel4.setBackground(new java.awt.Color(255, 255, 204));
        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setText("Age:");

        ageTextField.setEditable(false);

        docNameTextField.setEditable(false);

        pharmacyTextField.setEditable(false);

        jLabel6.setBackground(new java.awt.Color(255, 255, 204));
        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel6.setText("Preffered Pharmacy:");

        jLabel5.setBackground(new java.awt.Color(255, 255, 204));
        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setText("Primary Doctor Name:");

        backBtn.setBackground(new java.awt.Color(255, 255, 204));
        backBtn.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        backBtn.setText("<< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        patientTable.setBackground(new java.awt.Color(204, 255, 255));
        patientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TimeStamp", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(patientTable);

        viewBtn.setBackground(new java.awt.Color(255, 255, 204));
        viewBtn.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        viewBtn.setText("View VitalSign");
        viewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(255, 255, 204));
        deleteBtn.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        deleteBtn.setText("Delete VitalSign");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        respRate.setBackground(new java.awt.Color(255, 255, 204));
        respRate.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        heartRate.setBackground(new java.awt.Color(255, 255, 204));
        heartRate.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        bp.setBackground(new java.awt.Color(255, 255, 204));
        bp.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        weight.setBackground(new java.awt.Color(255, 255, 204));
        weight.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        Hint.setBackground(new java.awt.Color(255, 255, 204));
        Hint.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        Hint.setText("Hint");
        Hint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HintActionPerformed(evt);
            }
        });

        status.setBackground(new java.awt.Color(255, 255, 204));
        status.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        ID.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        ID.setText("jLabel7");

        addVitalBtn.setBackground(new java.awt.Color(255, 255, 204));
        addVitalBtn.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        addVitalBtn.setText("Add VitalSign");
        addVitalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVitalBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(docNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(pharmacyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(pIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(backBtn)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addVitalBtn)
                                    .addGap(18, 18, 18)
                                    .addComponent(deleteBtn)
                                    .addGap(18, 18, 18)
                                    .addComponent(viewBtn))))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Hint)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bp, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(respRate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(heartRate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel1)
                        .addGap(40, 40, 40)
                        .addComponent(ID)))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ID))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(docNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(pharmacyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(viewBtn)
                            .addComponent(backBtn)
                            .addComponent(Hint)
                            .addComponent(deleteBtn)
                            .addComponent(addVitalBtn)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(heartRate, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bp, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(respRate, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        
        //get the selected row
        int selectedRow = patientTable.getSelectedRow();

        if(selectedRow >= 0)    {

            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this row ?", "Warning", dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION)  {

                VitalSign vs = (VitalSign)patientTable.getValueAt(selectedRow, 0);
                patient.getVitalSignHistory().deleteVitalSign(vs);
                
                JOptionPane.showMessageDialog(this, "Patient Information has been deleted", "Information", JOptionPane.INFORMATION_MESSAGE);

                //Populate the new Table after deleting the account
                populateTable();
            }
        }
        else    {
            JOptionPane.showMessageDialog(this, "Please select a row!", "Warning", JOptionPane.WARNING_MESSAGE);
        }        
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void viewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBtnActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = patientTable.getSelectedRow();

        if(selectedRow >= 0)    {
            //get the selected row
            //Patient patient = (Patient)patientTable.getValueAt(selectedRow, 0);
            VitalSign vitalSign = (VitalSign)patientTable.getValueAt(selectedRow, 0);
            //patient.getVitalSignHistory();

            ViewVitalSignPanel viewVitalSignPanel = new ViewVitalSignPanel(vitalSign, userProcessContainer);
            userProcessContainer.add("ViewVitalSignPanel",viewVitalSignPanel);
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
        else    {
            JOptionPane.showMessageDialog(this, "Please select a row!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_viewBtnActionPerformed

    private void HintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HintActionPerformed
        // TODO add your handling code here:

        status.setText("Normal Status");

        if((age >= 1) && (age <= 3)) {
            respRate.setText("20-30");
            heartRate.setText("80-130");
            bp.setText("80-110");
            weight.setText("22-31");
        }
        else if((age >= 4) && (age <= 5)) {
            respRate.setText("20-30");
            heartRate.setText("80-120");
            bp.setText("80-110");
            weight.setText("31-40");
        }
        else if((age >= 6) && (age <= 12)) {
            respRate.setText("20-30");
            heartRate.setText("70-110");
            bp.setText("80-120");
            weight.setText("41-92");
        }
        else  {
            respRate.setText("12-20");
            heartRate.setText("55-105");
            bp.setText("110-120");
            weight.setText("> 110");
        }
    }//GEN-LAST:event_HintActionPerformed

    
    private void addVitalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVitalBtnActionPerformed
        // TODO add your handling code here:
        EditVitalSignPanel editVitalSignPanel = new EditVitalSignPanel(patient.getVitalSignHistory(), age, userProcessContainer);
        userProcessContainer.add("EditVitalSignPanel", editVitalSignPanel);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
//        resetFields();
//        textFieldUpdate();
//
//        Timestamp timeStamp = new Timestamp(new Date().getTime());
//        time = String.valueOf(timeStamp);
//        timeTextField.setText(String.valueOf(time));
//
//        if(age == 0)    {
//            JOptionPane.showMessageDialog(this, "Please Enter Patient details!!", "Error", JOptionPane.OK_OPTION);
//            resetFields();
//        }
//        else    {
//            if(respRateTextField.getText().trim().isEmpty())    {
//                JOptionPane.showMessageDialog(this, "Respiration Rate cannot be blank!", "Error", JOptionPane.OK_OPTION);
//                respRateTextField.setBackground(Color.red);
//            }
//            else if(!respRateTextField.getText().matches("^(\\d+\\.)?\\d+$"))  {
//                JOptionPane.showMessageDialog(this, "Respiration Rate can only have digits!", "Error", JOptionPane.OK_OPTION);
//                respRateTextField.setBackground(Color.red);
//            }
//            else if(heartRateTextField.getText().trim().isEmpty())    {
//                JOptionPane.showMessageDialog(this, "Heart Rate cannot be blank!", "Error", JOptionPane.OK_OPTION);
//                heartRateTextField.setBackground(Color.red);
//            }
//            else if(!heartRateTextField.getText().matches("^(\\d+\\.)?\\d+$"))  {
//                JOptionPane.showMessageDialog(this, "Heart Rate can only have digits!", "Error", JOptionPane.OK_OPTION);
//                heartRateTextField.setBackground(Color.red);
//            }
//            else if(bpTextField.getText().trim().isEmpty())    {
//                JOptionPane.showMessageDialog(this, "Blood Pressure cannot be blank!", "Error", JOptionPane.OK_OPTION);
//                bpTextField.setBackground(Color.red);
//            }
//            else if(!bpTextField.getText().matches("^(\\d+\\.)?\\d+$"))  {
//                JOptionPane.showMessageDialog(this, "Blood Pressure can only have digits!", "Error", JOptionPane.OK_OPTION);
//                bpTextField.setBackground(Color.red);
//            }
//            else if(weightTextField.getText().trim().isEmpty())    {
//                JOptionPane.showMessageDialog(this, "Weight cannot be blank!", "Error", JOptionPane.OK_OPTION);
//                weightTextField.setBackground(Color.red);
//            }
//            else if(!weightTextField.getText().matches("^(\\d+\\.)?\\d+$"))  {
//                JOptionPane.showMessageDialog(this, "Weight can only have digits!", "Error", JOptionPane.OK_OPTION);
//                weightTextField.setBackground(Color.red);
//            }
//            else    {
//
//                VitalSign vitalSign = vitalSignHistory.addVitalSign();
//
//                vitalSign.setRespRate(Float.parseFloat(respRateTextField.getText()));
//                vitalSign.setHeartRate(Float.parseFloat(heartRateTextField.getText()));
//                vitalSign.setBp(Float.parseFloat(bpTextField.getText()));
//                vitalSign.setWeight(Float.parseFloat(weightTextField.getText()));
//                vitalSign.setTime(time);
//
//                JOptionPane.showMessageDialog(this, "VitalSign Record is successfully saved!", "Information", JOptionPane.INFORMATION_MESSAGE);
//                resetFields();
//            }
//        }
    }//GEN-LAST:event_addVitalBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Hint;
    private javax.swing.JLabel ID;
    private javax.swing.JButton addVitalBtn;
    private javax.swing.JTextField ageTextField;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel bp;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField docNameTextField;
    private javax.swing.JLabel heartRate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField pIDTextField;
    private javax.swing.JTable patientTable;
    private javax.swing.JTextField pharmacyTextField;
    private javax.swing.JLabel respRate;
    private javax.swing.JLabel status;
    private javax.swing.JButton viewBtn;
    private javax.swing.JLabel weight;
    // End of variables declaration//GEN-END:variables
}
