/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ReceptionistRole;

import Business.Enterprise.Enterprise;
import Business.Organization.Hospital.DoctorOrganization;
import Business.Organization.Hospital.Organization;
import Business.Organization.Hospital.ReceptionistOrganization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.UserPriviligeWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author hpanjwani
 */
public class AppointmentWaitingListPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private ReceptionistOrganization receptionistOrganization;
    //private PatientOrganization patientOrganization;
    private Patient patient;
    private UserPriviligeWorkRequest request;
    private Organization org = null;

    int flag = 0;

    /**
     * Creates new form ReceptionistWorkAreaPanel
     */
    public AppointmentWaitingListPanel(JPanel userProcessContainer, UserAccount account, ReceptionistOrganization organization, Enterprise enterprise, Patient patient) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.enterprise = enterprise;
        this.receptionistOrganization = organization;
        this.patient = patient;

//        for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList())
//            if(org instanceof PatientOrganization)
//                patientOrganization = (PatientOrganization)org;
        recLabel.setText(("Receptionist Name: " + userAccount.getUsername()));
        hospitalLabel.setText("Hospital Name: " + enterprise.getName());

        for (WorkRequest checkRequest : userAccount.getWorkQueue().getWorkRequestList()) {
            if (((UserPriviligeWorkRequest) checkRequest).getPatient().equals((Patient) patient)) {
                if ((checkRequest.getStatus().equals("Waiting")) || (checkRequest.getStatus().equals("Added to Queue"))) {
                    JOptionPane.showMessageDialog(this, "Patient is already waiting for the doctor", "WARNING", JOptionPane.WARNING_MESSAGE);
                    flag = 1;
                    break;
                }
            }
        }

        if (flag == 0) {
            if (patient != null) {
                request = new UserPriviligeWorkRequest();
                request.setMessage(patient + " waitng for Doctor");
                request.setSender(userAccount);
                request.setPatient(patient);
                request.setRequestDate(new Date());
                request.setStatus("Waiting");

                userAccount.getWorkQueue().getWorkRequestList().add(request);
            }
        }

        populateVisitRequestTable();

    }

    public void populateVisitRequestTable() {
        DefaultTableModel model = (DefaultTableModel) visitRequestTable.getModel();
        model.setRowCount(0);

        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            //if (((UserPriviligeWorkRequest) request).getPatient().equals((Patient)patient)) {
            if ((request.getStatus().equals("Waiting")) || (request.getStatus().equals("Added to Queue"))
                    || (request.getStatus().equals("Check up Done"))) {

                Patient patient = (Patient) ((UserPriviligeWorkRequest) request).getPatient();

                //int size = patient.getDonationList().size() - 1;
                //                if(size < 0)   {
                //                    break;
                //                }
                //                else    {
                Object[] row = new Object[5];

                row[0] = request;
                row[1] = patient;
                row[2] = request.getReceiver();
                row[3] = request.getRequestDate();
                row[4] = request.getStatus();
                //                    row[5] = request.getResolveDate();
                //                    String result = ((LabTestWorkRequest) request).getTestResult();
                //                    row[6] = result == null ? "Waiting" : result;
                //                    
                //                    if(result != null)    {
                //                        for(int j = 0; j < d.getDonationList().size(); j++)   {
                //                            if(d.getDonationList().get(j).equals(result))   {
                //                                size  = j;
                //                                System.out.println(size);
                //                                break;
                //                            }
                //                        }
                //                    }
                //                    
                //                    int unit = d.getDonationList().get(size).getUnit();
                //                    row[7] = String.valueOf(unit) == null ? "Waiting" : String.valueOf(unit);

                model.addRow(row);
                //}
            }
            //}
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

        jScrollPane1 = new javax.swing.JScrollPane();
        visitRequestTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        removeBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        pNameTextField = new javax.swing.JTextField();
        pIDTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ageTextField = new javax.swing.JTextField();
        docNameTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pharmacyTextField = new javax.swing.JTextField();
        hospitalLabel = new javax.swing.JLabel();
        recLabel = new javax.swing.JLabel();
        city = new javax.swing.JLabel();
        cityTextField = new javax.swing.JTextField();
        historyBtn = new javax.swing.JButton();

        visitRequestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Message", "Pateint Name", "Doctor Name", "Appointment Date", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        visitRequestTable.setToolTipText("Appointment Queue");
        visitRequestTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                visitRequestTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(visitRequestTable);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("DOCTOR APPOINTMENT QUEUE");

        backBtn.setText("<< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        addBtn.setText("ADD TO QUEUE");
        addBtn.setEnabled(false);
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        removeBtn.setText("Remove Patient");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Patient Name:");

        pNameTextField.setEditable(false);
        pNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pNameTextFieldActionPerformed(evt);
            }
        });

        pIDTextField.setEditable(false);

        jLabel4.setText("Patient ID:");

        jLabel5.setText("Age:");

        ageTextField.setEditable(false);

        docNameTextField.setEditable(false);

        jLabel6.setText("Primary Doctor Name:");

        jLabel7.setText("Preffered Pharmacy:");

        pharmacyTextField.setEditable(false);

        hospitalLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        hospitalLabel.setText("jLabel2");

        recLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        recLabel.setText("jLabel2");

        city.setText("City:");

        cityTextField.setEditable(false);

        historyBtn.setText("Appointment History");
        historyBtn.setToolTipText("Patient Appointment History");
        historyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGap(90, 90, 90)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(54, 54, 54)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(city))
                            .addGap(39, 39, 39)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(docNameTextField)
                                .addComponent(pharmacyTextField)
                                .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(historyBtn)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(removeBtn)
                                    .addComponent(backBtn))
                                .addGap(469, 469, 469)
                                .addComponent(addBtn)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(104, 104, 104)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(hospitalLabel)
                                .addComponent(recLabel)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(211, 211, 211)
                            .addComponent(jLabel1))))
                .addContainerGap(229, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(recLabel)
                .addGap(18, 18, 18)
                .addComponent(hospitalLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(historyBtn)
                    .addComponent(removeBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(backBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(pNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(pIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(docNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(pharmacyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(city)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        int selectedRow = visitRequestTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a patient to be add to queue!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        } else {

            UserPriviligeWorkRequest waitingRequest = (UserPriviligeWorkRequest) visitRequestTable.getValueAt(selectedRow, 0);
            waitingRequest.setStatus("Added to Queue");

            for (Organization orga : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if (orga instanceof DoctorOrganization) {
                    org = orga;
                    break;
                }
            }
            if (org != null) {
                org.getWorkQueue().getWorkRequestList().add(waitingRequest);
            }

            JOptionPane.showMessageDialog(this, "Added to waiting Queue!!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
            populateVisitRequestTable();
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = visitRequestTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a patient to remove!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            WorkRequest request = (WorkRequest) visitRequestTable.getValueAt(selectedRow, 0);

            for (Organization orga : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if (orga instanceof DoctorOrganization) {
                    org = orga;
                    break;
                }
            }

            org.getWorkQueue().getWorkRequestList().remove(request);
            userAccount.getWorkQueue().getWorkRequestList().remove(request);
            populateVisitRequestTable();
        }
    }//GEN-LAST:event_removeBtnActionPerformed

    private void visitRequestTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visitRequestTableMousePressed
        // TODO add your handling code here:

        int selectedRow = visitRequestTable.getSelectedRow();

        TableCellRenderer renderer = visitRequestTable.getCellRenderer(selectedRow, 0);
        Component component = visitRequestTable.prepareRenderer(renderer, selectedRow, 0);
        Object value = (WorkRequest) visitRequestTable.getModel().getValueAt(selectedRow, 0);

        UserPriviligeWorkRequest request = (UserPriviligeWorkRequest) visitRequestTable.getValueAt(selectedRow, 0);

        Patient patient = request.getPatient();

        pNameTextField.setText(patient.getName());
        pIDTextField.setText(String.valueOf(patient.getId()));
        ageTextField.setText(String.valueOf(patient.getAge()));
        docNameTextField.setText(String.valueOf(patient.getpDocName()));
        pharmacyTextField.setText(patient.getPharmacy());
        cityTextField.setText(patient.getTown());

        if (request.getStatus().equals("Added to Queue")) {

            UserAccount account = (UserAccount) visitRequestTable.getModel().getValueAt(selectedRow, 2);

            //Include if the user itself has assigned him that patient
            addBtn.setEnabled(false);
            removeBtn.setEnabled(true);

//                JOptionPane.showMessageDialog(this, "The patient is already being processed by " + account, "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
//                assignBtn.setEnabled(false);
//                requestBtn.setEnabled(false);
//                rejectBtn.setEnabled(false);
        } else if (request.getStatus().equals("Waiting")) {
            //JOptionPane.showMessageDialog(this, "The patient is already being granted access!!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
            addBtn.setEnabled(true);
            removeBtn.setEnabled(false);
        } else {
            addBtn.setEnabled(false);
            removeBtn.setEnabled(false);
        }


    }//GEN-LAST:event_visitRequestTableMousePressed

    private void pNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pNameTextFieldActionPerformed

    private void historyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyBtnActionPerformed
        // TODO add your handling code here:
        PreviousAppointmentPanel previousAppointmentPanel = new PreviousAppointmentPanel(userProcessContainer, userAccount, enterprise, patient);
        userProcessContainer.add("PreviousAppointmentPanel", previousAppointmentPanel );
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_historyBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField ageTextField;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel city;
    private javax.swing.JTextField cityTextField;
    private javax.swing.JTextField docNameTextField;
    private javax.swing.JButton historyBtn;
    private javax.swing.JLabel hospitalLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pIDTextField;
    private javax.swing.JTextField pNameTextField;
    private javax.swing.JTextField pharmacyTextField;
    private javax.swing.JLabel recLabel;
    private javax.swing.JButton removeBtn;
    private javax.swing.JTable visitRequestTable;
    // End of variables declaration//GEN-END:variables
}
