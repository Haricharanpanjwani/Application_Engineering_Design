/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PatientRole;

import Business.Patient.Patient;
import Business.Patient.VitalSign;
import Business.Patient.VitalSignHistory;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author hpanjwani
 */
public class ViewVitalSign extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    
    private DefaultCategoryDataset vitalSignDataSet;
    private VitalSignHistory vitalSignHistory;
    private Patient patient;
    private int age;
    
    /**
     * Creates new form ViewVitalSign
     */
    public ViewVitalSign(JPanel userProcessContainer, UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        
        patient = (Patient)userAccount.getEmployee();
        vitalSignHistory = patient.getVitalSignList();
        age = patient.getAge();
        
        if(!(vitalSignHistory.getVitalSignList().isEmpty()))  {
            vitalSignHistory = patient.getVitalSignList();
            VitalSign vs = vitalSignHistory.getVitalSignList().get(0);

            respRateTextField.setText(String.valueOf(vs.getRespRate()));
            heartRateTextField.setText(String.valueOf(vs.getHeartRate()));
            bpTextField.setText(String.valueOf(vs.getBp()));
            weightTextField.setText(String.valueOf(vs.getWeight()));

            glucoseTextField.setText(String.valueOf(vs.getGlucose()));
            plateletsTextField.setText(String.valueOf(vs.getPlatelets()));
            pulseTextField.setText(String.valueOf(vs.getPulse()));
            tempTextField.setText(String.valueOf(vs.getTemp()));
            hemoTextField.setText(String.valueOf(vs.getHemo()));
            bloodGroupTextField.setText(String.valueOf(vs.getBloodGroup()));
        }
                
        populateVitalSignTable();
    }
    
    public void populateVitalSignTable()    {
        DefaultTableModel dtm  = (DefaultTableModel)vitalSignTable.getModel();     
        dtm.setRowCount(0);
        
        for(VitalSign vs : vitalSignHistory.getVitalSignList()) {
            
            Object row[] = new Object[11];
            
            row[0] = vs.getRespRate();
            row[1] = vs.getHeartRate();    
            row[2] = vs.getBp();
            row[3] = vs.getWeight();
            row[4] = vs.getPulse();
            row[5] = vs.getPlatelets();
            row[6] = vs.getTemp();
            row[7] = vs.getHemo();
            row[8] = vs.getGlucose();
            row[9] = vs;
            
            if(patient.getAge() >= 1 && patient.getAge() <= 3)   {
                if( ((vs.getRespRate() >= 20) && (vs.getRespRate() <= 30)) &&
                     (vs.getHeartRate() >= 80) && (vs.getHeartRate() <= 130) &&
                     (vs.getBp() >= 80) && (vs.getBp() <= 110) &&
                     (vs.getWeight() >= 22) && (vs.getWeight() <= 31))  
                {
                    row[10] = "Normal";
                }
                else    {
                    row[10] = "Abnormal";
                }
            }
            else if(patient.getAge() >= 4 && patient.getAge() <= 5)   {
                if( ((vs.getRespRate() >= 20) && (vs.getRespRate() <= 30)) &&
                     (vs.getHeartRate() >= 80) && (vs.getHeartRate() <= 120) &&
                     (vs.getBp() >= 80) && (vs.getBp() <= 110) &&
                     (vs.getWeight() >= 31) && (vs.getWeight() <= 40))  
                {
                    row[5] = "Normal";
                }
                else    {
                    row[5] = "Abormal";
                }
            }
            else if(patient.getAge() >= 6 && patient.getAge() <= 12)   {
                if( ((vs.getRespRate() >= 20) && (vs.getRespRate() <= 30)) &&
                     (vs.getHeartRate() >= 70) && (vs.getHeartRate() <= 110) &&
                     (vs.getBp() >= 80) && (vs.getBp() <= 120) &&
                     (vs.getWeight() >= 41) && (vs.getWeight() <= 92))  
                {
                    row[10] = "Normal";
                }
                else    {
                    row[10] = "Abnormal";
                }
            }
            else {
                if( ((vs.getRespRate() >= 12) && (vs.getRespRate() <= 20)) &&
                     (vs.getHeartRate() >= 55) && (vs.getHeartRate() <= 105) &&
                     (vs.getBp() >= 110) && (vs.getBp() <= 120) &&
                     (vs.getWeight() > 110))
                {
                    row[10] = "Normal";
                }
                else    {
                    row[10] = "Abnormal";
                }
            }
            
            dtm.addRow(row);
        }
    }
    
    public void populateGraph() {
      try   {
        vitalSignDataSet = new DefaultCategoryDataset();
          
        for(VitalSign vs : vitalSignHistory.getVitalSignList())   {
            
            vitalSignDataSet.addValue(vs.getRespRate(), "Respiration Rate", vs.getTime());
            vitalSignDataSet.addValue(vs.getHeartRate(), "Heart Rate", vs.getTime());
            vitalSignDataSet.addValue(vs.getBp(), "Blood Pressure", vs.getTime());
            vitalSignDataSet.addValue(vs.getWeight(), "Weight", vs.getTime());
        }
        
        JFreeChart chartFactory = ChartFactory.createBarChart3D("VitalSign Pattern", "Timestamp", "VitalSign", vitalSignDataSet, PlotOrientation.VERTICAL, true, true, false);      
        BarRenderer renderer = null;
        CategoryPlot plot = chartFactory.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLUE);
        renderer = new BarRenderer();
        
        ChartFrame frame = new ChartFrame("Bar Chart for VitalSign", chartFactory);
        frame.setVisible(true);
        frame.setSize(700, 700);
        
//        ChartPanel panel = new ChartPanel(chartFactory);
//        panel.
//        
//        this.removeAll();
//        this.add(panel);
//        this.updateUI();
        
        int length = (vitalSignHistory.getVitalSignList().size() - 1) ;
        
        VitalSign vs = vitalSignHistory.getVitalSignList().get(length);
        
        if(age >= 1 && age <= 3)   {
                if( ((vs.getRespRate() < 20) || (vs.getRespRate() > 30)) ||
                     (vs.getHeartRate() < 80) || (vs.getHeartRate() > 130) ||
                     (vs.getBp() < 80) || (vs.getBp() > 110) ||
                     (vs.getWeight() < 22) || (vs.getWeight() > 31))  
                {
                    JOptionPane.showMessageDialog(this, "The last vital sign of the Patient is Abnormal!\n Please take a good look on the graph", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                }
//                else    {
//                    row[5] = "Normal";
//                }
            }
            else if(age >= 4 && age <= 5)   {
                if( ((vs.getRespRate() < 20) || (vs.getRespRate() > 30)) ||
                     (vs.getHeartRate() < 80) || (vs.getHeartRate() > 120) ||
                     (vs.getBp() < 80) || (vs.getBp() >= 110) ||
                     (vs.getWeight() < 31) || (vs.getWeight() > 40))  
                {
                    JOptionPane.showMessageDialog(this, "The last vital sign of the Patient is Abnormal!\n Please take a good look on the graph", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                }
//                else    {
//                    row[5] = "Normal";
//                }
            }
            else if(age >= 6 && age <= 12)   {
                if( ((vs.getRespRate() < 20) || (vs.getRespRate() > 30)) ||
                     (vs.getHeartRate() < 70) || (vs.getHeartRate() > 110) ||
                     (vs.getBp() < 80) || (vs.getBp() >= 120) ||
                     (vs.getWeight() < 41) || (vs.getWeight() >= 92))  
                {
                    JOptionPane.showMessageDialog(this, "The last vital sign of the Patient is Abnormal!\n Please take a good look on the graph", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                }
//                else    {
//                    row[5] = "Normal";
//                }
            }
            else {
                if( ((vs.getRespRate() < 12) || (vs.getRespRate() > 20)) ||
                     (vs.getHeartRate() < 55) || (vs.getHeartRate() > 105) ||
                     (vs.getBp() < 110) || (vs.getBp() >= 120) ||
                     (vs.getWeight() > 110))
                {
                    JOptionPane.showMessageDialog(this, "The last vital sign of the Patient is Abnormal!\n Please take a good look on the graph", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                }
//                else    {
//                    row[5] = "Normal";
//                }
            }
      }
      catch(Exception e)    {
          System.out.println(e);
      }   
    }
    
    public void populateLineGraph() {
        
       if(patient!=null) {
            XYSeriesCollection dataset = new XYSeriesCollection();
            
            if(!(patient.getVitalSignList().getVitalSignList().isEmpty())) {
                for(VitalSign vs : patient.getVitalSignList().getVitalSignList()) {
                //int size = patient.getVitalSignList().getVitalSignList().size();
                  //VitalSign vs =  patient.getVitalSignList().getVitalSignList().get(size - 1);
                    
                  XYSeries series1 = new XYSeries(vs.getBp());                   
                    series1.add(10,vs.getBp());
                    //series1.add(vs.getHeartRate(),vs.getHeartRate());
                    //series1.add(vs,vs.getRespRate());
                    //series1.add(40,vs.getWeight());
                    dataset.addSeries(series1);    
                    //i++;
                }

                JFreeChart chartFactory = ChartFactory.createXYLineChart("GRAPHICAL REPRESENTATION OF SENSOR DATA", "X-Axis", "SIGN",dataset);
                XYLineAndShapeRenderer renderer = null;
                XYPlot plot = chartFactory.getXYPlot();
                renderer = new XYLineAndShapeRenderer();
                ChartFrame frame = new ChartFrame("Line Chart Of Sensor Data", chartFactory);
                frame.setVisible(true);
                frame.setSize(700, 320);
            }
            else {
                JOptionPane.showMessageDialog(this, "No Vital Signs To Display On Graph!!!");
            }
       }
       else {
           JOptionPane.showMessageDialog(this, "No Patient In The Record!!!");
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
        vitalSignTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        viewBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        glucoseTextField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        hemoTextField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        pulseTextField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        plateletsTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        respRateTextField = new javax.swing.JTextField();
        heartRateTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bpTextField = new javax.swing.JTextField();
        weightTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tempTextField = new javax.swing.JTextField();
        bloodGroupTextField = new javax.swing.JTextField();

        vitalSignTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Respiration Rate", "Heart Rate", "Blood Pressure", "Weight", "Pulse", "Body Temperature", "Blood Platelets", "Hemoglobin", "Glucose Level", "TimeStamp", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(vitalSignTable);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("PATIENT SUMMARY");

        viewBtn.setText("View Detail");
        viewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBtnActionPerformed(evt);
            }
        });

        jButton1.setText("<< Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel12.setText("Blood Glucose Level");

        glucoseTextField.setEditable(false);

        jLabel13.setText("Hemoglobin Level");

        hemoTextField.setEditable(false);

        jLabel15.setText("Blood Group");

        pulseTextField.setEditable(false);

        jLabel16.setText("Pulse");

        jLabel14.setText("Blood Platelets");

        plateletsTextField.setEditable(false);

        jLabel2.setText("Respiration Rate:");

        respRateTextField.setEditable(false);
        respRateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                respRateTextFieldActionPerformed(evt);
            }
        });

        heartRateTextField.setEditable(false);

        jLabel3.setText("Heart Rate:");

        jLabel4.setText("Systolic Blood Pressure:");

        bpTextField.setEditable(false);

        weightTextField.setEditable(false);

        jLabel5.setText("Weight (in pounds):");

        jLabel17.setText("Body Temperature");

        tempTextField.setEditable(false);

        bloodGroupTextField.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(232, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addGap(42, 42, 42)
                                    .addComponent(glucoseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addGap(134, 134, 134)
                                    .addComponent(pulseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addGap(75, 75, 75)
                                    .addComponent(plateletsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel15))
                                    .addGap(54, 54, 54)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(bloodGroupTextField)
                                        .addComponent(hemoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(157, 157, 157)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addGap(43, 43, 43)
                                    .addComponent(tempTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(33, 33, 33)
                                            .addComponent(weightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(6, 6, 6)
                                                .addComponent(bpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(86, 86, 86)
                                                        .addComponent(respRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(heartRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))))))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewBtn)))
                .addContainerGap(198, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(457, 457, 457))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(glucoseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(jLabel13))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(hemoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(bloodGroupTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel16))
                            .addComponent(pulseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(plateletsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel14))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(respRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(heartRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel4))
                                    .addComponent(bpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel5))
                            .addComponent(weightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tempTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel17)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewBtn)
                    .addComponent(jButton1))
                .addContainerGap(62, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = vitalSignTable.getSelectedRow();

        if(selectedRow >= 0) {

            VitalSign vs = (VitalSign)vitalSignTable.getValueAt(selectedRow, 9);

            respRateTextField.setText(String.valueOf(vs.getRespRate()));
            heartRateTextField.setText(String.valueOf(vs.getHeartRate()));
            bpTextField.setText(String.valueOf(vs.getBp()));
            weightTextField.setText(String.valueOf(vs.getWeight()));
            
            glucoseTextField.setText(String.valueOf(vs.getGlucose()));
            plateletsTextField.setText(String.valueOf(vs.getPlatelets()));
            pulseTextField.setText(String.valueOf(vs.getPulse()));
            tempTextField.setText(String.valueOf(vs.getTemp()));
            hemoTextField.setText(String.valueOf(vs.getHemo()));
            bloodGroupTextField.setText(vs.getBloodGroup());
            //timeTextField.setText(String.valueOf(vs.getTime()));
        }   else    {
            JOptionPane.showMessageDialog(this, "Please select a row!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_viewBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void respRateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_respRateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_respRateTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bloodGroupTextField;
    private javax.swing.JTextField bpTextField;
    private javax.swing.JTextField glucoseTextField;
    private javax.swing.JTextField heartRateTextField;
    private javax.swing.JTextField hemoTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField plateletsTextField;
    private javax.swing.JTextField pulseTextField;
    private javax.swing.JTextField respRateTextField;
    private javax.swing.JTextField tempTextField;
    private javax.swing.JButton viewBtn;
    private javax.swing.JTable vitalSignTable;
    private javax.swing.JTextField weightTextField;
    // End of variables declaration//GEN-END:variables
}
