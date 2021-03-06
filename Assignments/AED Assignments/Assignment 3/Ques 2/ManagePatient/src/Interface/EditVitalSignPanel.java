/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.VitalSign;
import Business.VitalSignHistory;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author hpanjwani
 */
public class EditVitalSignPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private VitalSignHistory vitalSignHistory;
    private int age;
    private String time;
    
    /**
     * Creates new form EditVitalSign
     */
    public EditVitalSignPanel(VitalSignHistory vitalSignHistory, int age, JPanel userProcessContainer) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.vitalSignHistory = vitalSignHistory;
        this.age = age;
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        respRateTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        heartRateTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        weightTextField = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        Hint = new javax.swing.JButton();
        bpTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        respRate = new javax.swing.JLabel();
        heartRate = new javax.swing.JLabel();
        bp = new javax.swing.JLabel();
        weight = new javax.swing.JLabel();
        timeTextField = new javax.swing.JLabel();
        status = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 204));
        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("Respiration Rate:");

        respRateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                respRateTextFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Update Patient VitalSign Record");

        jLabel3.setBackground(new java.awt.Color(255, 255, 204));
        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setText("Heart Rate:");

        jLabel4.setBackground(new java.awt.Color(255, 255, 204));
        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setText("Systolic Blood Pressure:");

        jLabel5.setBackground(new java.awt.Color(255, 255, 204));
        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setText("Weight (in pounds):");

        saveBtn.setBackground(new java.awt.Color(255, 255, 204));
        saveBtn.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        backBtn.setBackground(new java.awt.Color(255, 255, 204));
        backBtn.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        backBtn.setText("<< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        Hint.setBackground(new java.awt.Color(255, 255, 204));
        Hint.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        Hint.setText("Hint");
        Hint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HintActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 204));
        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel6.setText("Time of detail entered:");

        respRate.setBackground(new java.awt.Color(255, 255, 204));
        respRate.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        heartRate.setBackground(new java.awt.Color(255, 255, 204));
        heartRate.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        bp.setBackground(new java.awt.Color(255, 255, 204));
        bp.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        weight.setBackground(new java.awt.Color(255, 255, 204));
        weight.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        timeTextField.setBackground(new java.awt.Color(255, 255, 204));
        timeTextField.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        status.setBackground(new java.awt.Color(255, 255, 204));
        status.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(saveBtn)
                                        .addGap(96, 96, 96))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(219, 219, 219)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(bpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(weightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(heartRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(respRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addComponent(jLabel1)))
                                        .addGap(43, 43, 43)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Hint)
                                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bp, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(respRate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(heartRate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(70, 70, 70)
                                .addComponent(timeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(backBtn))))
                .addGap(204, 204, 204))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(respRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(heartRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(heartRate, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bp, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(weightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveBtn)
                            .addComponent(Hint)
                            .addComponent(backBtn)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(respRate, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(timeTextField))
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void respRateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_respRateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_respRateTextFieldActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:

        Timestamp timeStamp = new Timestamp(new Date().getTime());
        time = String.valueOf(timeStamp);
        timeTextField.setText(String.valueOf(time));

        if(age == 0)    {
            JOptionPane.showMessageDialog(this, "Please Enter Patient details!!", "Error", JOptionPane.OK_OPTION);
            resetFields();
        }
        else    {
            if(respRateTextField.getText().trim().isEmpty())    {
                JOptionPane.showMessageDialog(this, "Respiration Rate cannot be blank!", "Error", JOptionPane.OK_OPTION);
                respRateTextField.setBackground(Color.red);
            }
            else if(!respRateTextField.getText().matches("^(\\d+\\.)?\\d+$"))  {
                JOptionPane.showMessageDialog(this, "Respiration Rate can only have digits!", "Error", JOptionPane.OK_OPTION);
                respRateTextField.setBackground(Color.red);
            }
            else if(heartRateTextField.getText().trim().isEmpty())    {
                JOptionPane.showMessageDialog(this, "Heart Rate cannot be blank!", "Error", JOptionPane.OK_OPTION);
                heartRateTextField.setBackground(Color.red);
            }
            else if(!heartRateTextField.getText().matches("^(\\d+\\.)?\\d+$"))  {
                JOptionPane.showMessageDialog(this, "Heart Rate can only have digits!", "Error", JOptionPane.OK_OPTION);
                heartRateTextField.setBackground(Color.red);
            }
            else if(bpTextField.getText().trim().isEmpty())    {
                JOptionPane.showMessageDialog(this, "Blood Pressure cannot be blank!", "Error", JOptionPane.OK_OPTION);
                bpTextField.setBackground(Color.red);
            }
            else if(!bpTextField.getText().matches("^(\\d+\\.)?\\d+$"))  {
                JOptionPane.showMessageDialog(this, "Blood Pressure can only have digits!", "Error", JOptionPane.OK_OPTION);
                bpTextField.setBackground(Color.red);
            }
            else if(weightTextField.getText().trim().isEmpty())    {
                JOptionPane.showMessageDialog(this, "Weight cannot be blank!", "Error", JOptionPane.OK_OPTION);
                weightTextField.setBackground(Color.red);
            }
            else if(!weightTextField.getText().matches("^(\\d+\\.)?\\d+$"))  {
                JOptionPane.showMessageDialog(this, "Weight can only have digits!", "Error", JOptionPane.OK_OPTION);
                weightTextField.setBackground(Color.red);
            }
            else    {

                VitalSign vitalSign = vitalSignHistory.addVitalSign();

                vitalSign.setRespRate(Float.parseFloat(respRateTextField.getText()));
                vitalSign.setHeartRate(Float.parseFloat(heartRateTextField.getText()));
                vitalSign.setBp(Float.parseFloat(bpTextField.getText()));
                vitalSign.setWeight(Float.parseFloat(weightTextField.getText()));
                vitalSign.setTime(time);

                JOptionPane.showMessageDialog(this, "VitalSign Record is successfully saved!", "Information", JOptionPane.INFORMATION_MESSAGE);
                resetFields();
            }
        }
        }

        public void resetFields()   {
            respRateTextField.setText("");
            respRateTextField.setBackground(Color.white);
            heartRateTextField.setText("");
            heartRateTextField.setBackground(Color.white);
            bpTextField.setText("");
            bpTextField.setBackground(Color.white);
            weightTextField.setText("");
            weightTextField.setBackground(Color.white);
            //timeTextField.setText(String.valueOf(vs.getTime()));
    }//GEN-LAST:event_saveBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length  - 1];
        
        ViewPatientPanel viewPatientPanel = (ViewPatientPanel)component;
        viewPatientPanel.populateTable();
        
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Hint;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel bp;
    private javax.swing.JTextField bpTextField;
    private javax.swing.JLabel heartRate;
    private javax.swing.JTextField heartRateTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel respRate;
    private javax.swing.JTextField respRateTextField;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel status;
    private javax.swing.JLabel timeTextField;
    private javax.swing.JLabel weight;
    private javax.swing.JTextField weightTextField;
    // End of variables declaration//GEN-END:variables
}
