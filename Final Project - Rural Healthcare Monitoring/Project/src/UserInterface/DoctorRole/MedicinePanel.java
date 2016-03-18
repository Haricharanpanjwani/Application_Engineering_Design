/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DoctorRole;

import Business.Enterprise.Enterprise;
import Business.Medicine.Medicine;
import Business.Organization.Hospital.LabOrganization;
import Business.Organization.Hospital.Organization;
import Business.Organization.Hospital.PatientOrganization;
import Business.Patient.Appointment;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.UserPriviligeWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author hpanjwani
 */
public class MedicinePanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private WorkRequest requestAlert;

    private Patient patient;
    private Appointment appoint;
    private String disease;

    /**
     * Creates new form MedicinePanel
     */
    public MedicinePanel(JPanel userProcessContainer, UserAccount userAccount, Enterprise enterprise, WorkRequest requestAlert) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        this.requestAlert = requestAlert;
        this.patient = ((UserPriviligeWorkRequest) requestAlert).getPatient();

        this.disease = patient.getDisease();
        
        //if((disease.equals("Diabetes Type I")) || (disease.equals("Diabetes Type II")))
            

        docLabel.setText("Doctor Name  Dr. " + userAccount.getUsername());
        patientLabel.setText("Patient Name:  " + patient.getName());
        diseaseLabel.setText("Symptoms suggest you have : " + this.disease);

        docLabel1.setText("Doctor Name  Dr. " + userAccount.getUsername());
        patientLabel1.setText("Patient Name  Mr. " + patient.getName());
        diseaseLabel1.setText("Symptoms suggest you have : " + this.disease);

        nextBtn.setEnabled(false);

        populateComboBox();

        medicineTabbedPane.setEnabledAt(1, false);

        //Hide all Checkboxes
        malariaTest.setVisible(false);
        jaundiceTest.setVisible(false);
        typhoidTest.setVisible(false);
        dengueTest.setVisible(false);

        if (disease.equals("Malaria")) {
            malariaTest.setVisible(true);
        } else if (disease.equals("Dengue")) {
            dengueTest.setVisible(true);
        } else if (disease.equals("Typhoid")) {
            typhoidTest.setVisible(true);
        } else if (disease.equals("Jaundice")) {
            jaundiceTest.setVisible(true);
        }
    }

    public void populateComboBox() {
        medComboBox.removeAllItems();
        medComboBox2.removeAllItems();
        medComboBox3.removeAllItems();
        medComboBox4.removeAllItems();

        if (disease.equals("Malaria")) {

            medComboBox.addItem("Chloroquine");
            medComboBox.addItem("Mefloquine");
            medComboBox.addItem("Combination");
            medComboBox.addItem("Quinine sulfate");

            medComboBox2.addItem("Chloroquine");
            medComboBox2.addItem("Mefloquine");
            medComboBox2.addItem("Combination");
            medComboBox2.addItem("Quinine sulfate");

            medComboBox3.addItem("Chloroquine");
            medComboBox3.addItem("Mefloquine");
            medComboBox3.addItem("Combination");
            medComboBox3.addItem("Quinine sulfate");

            medComboBox4.addItem("Chloroquine");
            medComboBox4.addItem("Mefloquine");
            medComboBox4.addItem("Combination");
            medComboBox4.addItem("Quinine sulfate");

        } else if (disease.equals("Dengue")) {

            medComboBox.addItem("Acetaminophen");
            medComboBox.addItem("Dichloralphenazone");
            medComboBox.addItem("Amidrine");
            medComboBox.addItem("Duradrin");

            medComboBox2.addItem("Acetaminophen");
            medComboBox2.addItem("Dichloralphenazone");
            medComboBox2.addItem("Amidrine");
            medComboBox2.addItem("Duradrin");

            medComboBox3.addItem("Acetaminophen");
            medComboBox3.addItem("Dichloralphenazone");
            medComboBox3.addItem("Amidrine");
            medComboBox3.addItem("Duradrin");

            medComboBox4.addItem("Acetaminophen");
            medComboBox4.addItem("Dichloralphenazone");
            medComboBox4.addItem("Amidrine");
            medComboBox4.addItem("Duradrin");

        } else if (disease.equals("Typhoid")) {

            medComboBox.addItem("Ampicillin");
            medComboBox.addItem("Amoxicillin");
            medComboBox.addItem("Chloramphenicol");
            medComboBox.addItem("Trimethoprim");

            medComboBox2.addItem("Ampicillin");
            medComboBox2.addItem("Amoxicillin");
            medComboBox2.addItem("Chloramphenicol");
            medComboBox2.addItem("Trimethoprim");

            medComboBox3.addItem("Ampicillin");
            medComboBox3.addItem("Amoxicillin");
            medComboBox3.addItem("Chloramphenicol");
            medComboBox3.addItem("Trimethoprim");

            medComboBox4.addItem("Ampicillin");
            medComboBox4.addItem("Amoxicillin");
            medComboBox4.addItem("Chloramphenicol");
            medComboBox4.addItem("Trimethoprim");

        } else if (disease.equals("Jaundice")) {

            medComboBox.addItem("Acetaminophen");
            medComboBox.addItem("Lactulose");
            medComboBox.addItem("Mucomyst");
            medComboBox.addItem("Tylenol");

            medComboBox2.addItem("Acetaminophen");
            medComboBox2.addItem("Lactulose");
            medComboBox2.addItem("Mucomyst");
            medComboBox2.addItem("Tylenol");

            medComboBox3.addItem("Acetaminophen");
            medComboBox3.addItem("Lactulose");
            medComboBox3.addItem("Mucomyst");
            medComboBox3.addItem("Tylenol");

            medComboBox4.addItem("Acetaminophen");
            medComboBox4.addItem("Lactulose");
            medComboBox4.addItem("Mucomyst");
            medComboBox4.addItem("Tylenol");
        } else if (disease.equals("Diabetes Type I")) {

            medComboBox.addItem("Apidra");
            medComboBox.addItem("Humalog");
            medComboBox.addItem("Humulin N");
            medComboBox.addItem("Lantus");

            medComboBox2.addItem("Apidra");
            medComboBox2.addItem("Humalog");
            medComboBox2.addItem("Humulin N");
            medComboBox2.addItem("Lantus");

            medComboBox3.addItem("Apidra");
            medComboBox3.addItem("Humalog");
            medComboBox3.addItem("Humulin N");
            medComboBox3.addItem("Lantus");

            medComboBox4.addItem("Apidra");
            medComboBox4.addItem("Humalog");
            medComboBox4.addItem("Humulin N");
            medComboBox4.addItem("Lantus");

        } else if (disease.equals("Diabetes Type II")) {

            medComboBox.addItem("Velosulin BR");
            medComboBox.addItem("Levemir");
            medComboBox.addItem("Iletin Lente");
            medComboBox.addItem("ReliOn");

            medComboBox2.addItem("Velosulin BR");
            medComboBox2.addItem("Levemir");
            medComboBox2.addItem("Iletin Lente");
            medComboBox2.addItem("ReliOn");

            medComboBox3.addItem("Velosulin BR");
            medComboBox3.addItem("Levemir");
            medComboBox3.addItem("Iletin Lente");
            medComboBox3.addItem("ReliOn");

            medComboBox4.addItem("Velosulin BR");
            medComboBox4.addItem("Levemir");
            medComboBox4.addItem("Iletin Lente");
            medComboBox4.addItem("ReliOn");

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

        medicineTabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        medComboBox = new javax.swing.JComboBox();
        quantTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        medComboBox2 = new javax.swing.JComboBox();
        quant2TextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        medComboBox3 = new javax.swing.JComboBox();
        quant3TextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        medComboBox4 = new javax.swing.JComboBox();
        quant4TextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        notesTextArea = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        submitBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        docLabel = new javax.swing.JLabel();
        patientLabel = new javax.swing.JLabel();
        backBtn1 = new javax.swing.JButton();
        diseaseLabel = new javax.swing.JLabel();
        nextBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        malariaTest = new javax.swing.JCheckBox();
        jaundiceTest = new javax.swing.JCheckBox();
        typhoidTest = new javax.swing.JCheckBox();
        dengueTest = new javax.swing.JCheckBox();
        sendBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        docLabel1 = new javax.swing.JLabel();
        patientLabel1 = new javax.swing.JLabel();
        diseaseLabel1 = new javax.swing.JLabel();

        jLabel1.setText("Medication 1:");

        medComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Medication 2:");

        medComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Medication 3:");

        medComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Medication 4:");

        medComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        notesTextArea.setColumns(20);
        notesTextArea.setRows(5);
        jScrollPane1.setViewportView(notesTextArea);

        jLabel5.setText("Additional Notes");

        submitBtn.setText("Prescribe");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel6.setText("LIST OF MEDICINES");

        docLabel.setText("<doctorName>");

        patientLabel.setText("<patientName>");

        backBtn1.setText("<< Back");
        backBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtn1ActionPerformed(evt);
            }
        });

        diseaseLabel.setText("<disease>");

        nextBtn.setText("Next >>");
        nextBtn.setEnabled(false);
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(medComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(quant4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(medComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(quant3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(medComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(quant2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(medComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(quantTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(docLabel)
                                .addComponent(patientLabel)
                                .addComponent(diseaseLabel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(backBtn1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nextBtn)
                                    .addComponent(submitBtn))))))
                .addContainerGap(264, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(docLabel)
                .addGap(18, 18, 18)
                .addComponent(patientLabel)
                .addGap(18, 18, 18)
                .addComponent(diseaseLabel)
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(medComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(medComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quant2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(medComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quant3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(medComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quant4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitBtn)
                    .addComponent(backBtn1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextBtn)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        medicineTabbedPane.addTab("Medication", jPanel1);

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel7.setText("RECOMMENDED TESTS");

        malariaTest.setText("Drug Resistance Tests");
        malariaTest.setRolloverEnabled(true);
        malariaTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                malariaTestActionPerformed(evt);
            }
        });

        jaundiceTest.setText("Hepatitis B");
        jaundiceTest.setRolloverEnabled(true);
        jaundiceTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jaundiceTestActionPerformed(evt);
            }
        });

        typhoidTest.setText("Bone Marrow Test");
        typhoidTest.setRolloverEnabled(true);
        typhoidTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typhoidTestActionPerformed(evt);
            }
        });

        dengueTest.setText("MAC ELISA (IgM)");
        dengueTest.setRolloverEnabled(true);
        dengueTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dengueTestActionPerformed(evt);
            }
        });

        sendBtn.setText("Send to Lab");
        sendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtnActionPerformed(evt);
            }
        });

        backBtn.setText("<< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        docLabel1.setText("<doctorName>");

        patientLabel1.setText("<patientName>");

        diseaseLabel1.setText("<disease>");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(malariaTest)
                            .addComponent(jaundiceTest)
                            .addComponent(typhoidTest)
                            .addComponent(dengueTest)
                            .addComponent(backBtn))
                        .addGap(43, 43, 43)
                        .addComponent(sendBtn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(docLabel1)
                            .addComponent(patientLabel1)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(diseaseLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(docLabel1)
                .addGap(18, 18, 18)
                .addComponent(patientLabel1)
                .addGap(18, 18, 18)
                .addComponent(diseaseLabel1)
                .addGap(18, 18, 18)
                .addComponent(malariaTest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jaundiceTest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typhoidTest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dengueTest)
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(sendBtn))
                .addContainerGap(171, Short.MAX_VALUE))
        );

        medicineTabbedPane.addTab("Lab Test", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(medicineTabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(medicineTabbedPane)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        // TODO add your handling code here:

        appoint = patient.getAppointmentHistory().addAppointment();

        appoint.setDocName(userAccount.getEmployee());
        appoint.setDate(new Date());
        appoint.setDisease(disease);

        if (quantTextField.getText().trim().isEmpty() && quant2TextField.getText().trim().isEmpty()
                && quant3TextField.getText().trim().isEmpty() && quant4TextField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "All Dosage cannot be blank! Atleasst one has to be prescribed", "Error", JOptionPane.OK_OPTION);
            quantTextField.setBackground(Color.yellow);
            quant2TextField.setBackground(Color.yellow);
            quant3TextField.setBackground(Color.yellow);
            quant4TextField.setBackground(Color.yellow);

        } else {

            if (!(quantTextField.getText().trim().isEmpty())) {
                if (!(quantTextField.getText().matches("[0-9-]*"))) {
                    patient.getAppointmentHistory().removeAppointment(appoint);
                    JOptionPane.showMessageDialog(this, "Dosage can only have digits!", "Error", JOptionPane.OK_OPTION);
                    quantTextField.setBackground(Color.yellow);
                    return;
                } else {
                    Medicine m = new Medicine();
                    m.setName((String) medComboBox.getSelectedItem());
                    m.setDosage(quantTextField.getText());
                    appoint.getPrescribeMedicineList().add(m);
                }
            }

            if (!(quant2TextField.getText().trim().isEmpty())) {
                if (!(quant2TextField.getText().matches("[0-9-]*"))) {
                    patient.getAppointmentHistory().removeAppointment(appoint);
                    JOptionPane.showMessageDialog(this, "Dosage can only have digits!", "Error", JOptionPane.OK_OPTION);
                    quant2TextField.setBackground(Color.yellow);
                    return;
                } else {
                    Medicine me = new Medicine();
                    me.setName((String) medComboBox2.getSelectedItem());
                    me.setDosage(quant2TextField.getText());
                    appoint.getPrescribeMedicineList().add(me);
                }
            }

            if (!(quant3TextField.getText().trim().isEmpty())) {
                if (!(quant3TextField.getText().matches("[0-9-]*"))) {
                    patient.getAppointmentHistory().removeAppointment(appoint);
                    JOptionPane.showMessageDialog(this, "Dosage can only have digits!", "Error", JOptionPane.OK_OPTION);
                    quant3TextField.setBackground(Color.yellow);
                    return;
                } else {
                    Medicine med = new Medicine();
                    med.setName((String) medComboBox3.getSelectedItem());
                    med.setDosage(quant3TextField.getText());
                    appoint.getPrescribeMedicineList().add(med);
                }
            }

            if (!(quant4TextField.getText().trim().isEmpty())) {
                if (!(quant4TextField.getText().matches("[0-9-]*"))) {
                    patient.getAppointmentHistory().removeAppointment(appoint);
                    JOptionPane.showMessageDialog(this, "Dosage can only have digits!", "Error", JOptionPane.OK_OPTION);
                    quant4TextField.setBackground(Color.yellow);
                    return;
                } else {
                    Medicine mede = new Medicine();
                    mede.setName((String) medComboBox4.getSelectedItem());
                    mede.setDosage(quant4TextField.getText());
                    appoint.getPrescribeMedicineList().add(mede);
                }
            }

            appoint.setAdditonalNotes(notesTextArea.getText());

            JOptionPane.showMessageDialog(this, "Details of Appointment saved successfully!!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);

            medicineTabbedPane.setEnabledAt(1, true);
            medicineTabbedPane.setSelectedIndex(1);
            medicineTabbedPane.setEnabledAt(0, false);
            nextBtn.setEnabled(true);
        }
    }//GEN-LAST:event_submitBtnActionPerformed

    private void backBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtn1ActionPerformed
        // TODO add your handling code here:



        patient.getAppointmentHistory().removeAppointment(appoint);

        medComboBox.removeAllItems();
        medComboBox2.removeAllItems();
        medComboBox3.removeAllItems();
        medComboBox4.removeAllItems();

        quantTextField.setText("");
        quant2TextField.setText("");
        quant3TextField.setText("");
        quant4TextField.setText("");

        medicineTabbedPane.setEnabledAt(0, true);
        medicineTabbedPane.setSelectedIndex(0);
        medicineTabbedPane.setEnabledAt(1, false);

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtn1ActionPerformed

    private void malariaTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_malariaTestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_malariaTestActionPerformed

    private void jaundiceTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jaundiceTestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jaundiceTestActionPerformed

    private void typhoidTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typhoidTestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typhoidTestActionPerformed

    private void dengueTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dengueTestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dengueTestActionPerformed

    private void sendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBtnActionPerformed
        // TODO add your handling code here:

        if (malariaTest.isSelected()) {
            appoint.getPrescribeLabTest().add(malariaTest.getText());
        } else if (jaundiceTest.isSelected()) {
            appoint.getPrescribeLabTest().add(jaundiceTest.getText());
        } else if (typhoidTest.isSelected()) {
            appoint.getPrescribeLabTest().add(typhoidTest.getText());
        } else if (dengueTest.isSelected()) {
            appoint.getPrescribeLabTest().add(dengueTest.getText());
        }

        int flag = 1;

        if (malariaTest.isSelected() || jaundiceTest.isSelected() || typhoidTest.isSelected() || dengueTest.isSelected()) {
            flag = 0;
        }

        if (flag == 1) {

            requestAlert.setStatus("Medicine Prescribed");

            for (int i = 0; i < appoint.getPrescribeLabTest().size(); i++) {
                System.out.println(appoint.getPrescribeLabTest().get(i));
            }

            UserPriviligeWorkRequest labRequest = new UserPriviligeWorkRequest();
            labRequest.setMessage("Lab Test");
            labRequest.setSender(userAccount);
            labRequest.setPatient(patient);
            labRequest.setRequestDate(new Date());
            labRequest.setStatus("Pending Test");

            Organization patientOrg = null;
            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if (organization instanceof PatientOrganization) {
                    patientOrg = organization;
                    break;
                }
            }

            Organization org = null;
            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if (organization instanceof LabOrganization) {
                    org = organization;
                    break;
                }
            }
            if (org != null) {
                org.getWorkQueue().getWorkRequestList().add(labRequest);
                userAccount.getWorkQueue().getWorkRequestList().add(labRequest);
            }

            if (patientOrg != null) {
                for (UserAccount account : patientOrg.getUserAccountDirectory().getUserAccountList()) {
                    if (account.getUsername().equals(patient.getName())) {
                        account.getWorkQueue().getWorkRequestList().add(labRequest);
                        break;
                    }
                }
            }

            JOptionPane.showMessageDialog(this, "Request has been sent to Lab Assistant!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a test which has to be sent to Lab Assistant!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
        }
//                SendLabTestPanel sendLabTestPanel = new SendLabTestPanel(userProcessContainer, userAccount, request_Lab);
//                userProcessContainer.add("SendLabTestPanel", sendLabTestPanel);
//                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
//                layout.next(userProcessContainer);
    }//GEN-LAST:event_sendBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        submitBtn.setEnabled(false);

        medComboBox.setEditable(false);
        medComboBox2.setEditable(false);
        medComboBox3.setEditable(false);
        medComboBox4.setEditable(false);

        quantTextField.setEditable(false);
        quant2TextField.setEditable(false);
        quant3TextField.setEditable(false);
        quant4TextField.setEditable(false);

        medicineTabbedPane.setEnabledAt(1, false);
        medicineTabbedPane.setSelectedIndex(0);
        medicineTabbedPane.setEnabledAt(0, true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        // TODO add your handling code here:
        medicineTabbedPane.setEnabledAt(1, true);
        medicineTabbedPane.setSelectedIndex(1);
        medicineTabbedPane.setEnabledAt(0, false);
    }//GEN-LAST:event_nextBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton backBtn1;
    private javax.swing.JCheckBox dengueTest;
    private javax.swing.JLabel diseaseLabel;
    private javax.swing.JLabel diseaseLabel1;
    private javax.swing.JLabel docLabel;
    private javax.swing.JLabel docLabel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jaundiceTest;
    private javax.swing.JCheckBox malariaTest;
    private javax.swing.JComboBox medComboBox;
    private javax.swing.JComboBox medComboBox2;
    private javax.swing.JComboBox medComboBox3;
    private javax.swing.JComboBox medComboBox4;
    private javax.swing.JTabbedPane medicineTabbedPane;
    private javax.swing.JButton nextBtn;
    private javax.swing.JTextArea notesTextArea;
    private javax.swing.JLabel patientLabel;
    private javax.swing.JLabel patientLabel1;
    private javax.swing.JTextField quant2TextField;
    private javax.swing.JTextField quant3TextField;
    private javax.swing.JTextField quant4TextField;
    private javax.swing.JTextField quantTextField;
    private javax.swing.JButton sendBtn;
    private javax.swing.JButton submitBtn;
    private javax.swing.JCheckBox typhoidTest;
    // End of variables declaration//GEN-END:variables
}
