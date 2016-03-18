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
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author hpanjwani
 */
public class GraphicalPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;

    private DefaultCategoryDataset vitalSignDataSet;
    private VitalSignHistory vitalSignHistory;
    private Patient patient;
    private int age;

    ChartPanel CP;

    /**
     * Creates new form GraphicalPanel
     */
    public GraphicalPanel(JPanel userProcessContainer, UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;

        patient = (Patient) userAccount.getEmployee();
        vitalSignHistory = patient.getVitalSignList();
        
        patientLabel.setText("Patient Name: " + userAccount.getUsername());

    }

    public void populateGraph() {
        
        barGraph.removeAll();
        
        try {
            vitalSignDataSet = new DefaultCategoryDataset();
            if (!(vitalSignHistory.getVitalSignList().isEmpty())) {
                for (VitalSign vs : vitalSignHistory.getVitalSignList()) {

                    vitalSignDataSet.addValue(vs.getRespRate(), "Respiration Rate", vs.getTime());
                    vitalSignDataSet.addValue(vs.getHeartRate(), "Heart Rate", vs.getTime());
                    vitalSignDataSet.addValue(vs.getBp(), "Blood Pressure", vs.getTime());
                    vitalSignDataSet.addValue(vs.getWeight(), "Weight", vs.getTime());
                }

                JFreeChart chartFactory = ChartFactory.createBarChart3D(patient.getName() + "'s VitalSign Pattern", "Timestamp", "VitalSign", vitalSignDataSet, PlotOrientation.VERTICAL, true, true, false);
                chartFactory.setBackgroundPaint(Color.white);
                CategoryPlot plot = chartFactory.getCategoryPlot();
                ((BarRenderer) plot.getRenderer()).setBarPainter(new StandardBarPainter());
                BarRenderer r = (BarRenderer) chartFactory.getCategoryPlot().getRenderer();
//        
//        //plot.setRangeGridlinePaint(Color.BLUE);
//        //renderer = new BarRenderer();
//        
////        ChartFrame frame = new ChartFrame("Bar Chart for VitalSign", chartFactory);
////        frame.setVisible(true);
////        frame.setSize(700, 700);
                CP = new ChartPanel(chartFactory);
                barGraph.add(CP, BorderLayout.CENTER);
                barGraph.validate();
            } else {
                JOptionPane.showMessageDialog(this, "No Vital Signs To Display On Graph!!!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void populatePieChart() {

        barGraph.removeAll();
        
        try {
            DefaultPieDataset dataset = new DefaultPieDataset();
            if (!(vitalSignHistory.getVitalSignList().isEmpty())) {
                for (VitalSign vs : vitalSignHistory.getVitalSignList()) {

                    dataset.setValue("Respiration Rate", vs.getRespRate());
                    dataset.setValue("Heart Rate", vs.getHeartRate());
                    dataset.setValue("Blood Pressure", vs.getBp());
                    dataset.setValue("Weight", vs.getWeight());
                }

                JFreeChart chartFactory = ChartFactory.createPieChart3D(patient.getName() + "'s VitalSign Pattern", dataset, true, true, true);//, true, true, false);      
                chartFactory.setBackgroundPaint(Color.white);
                PiePlot plot = (PiePlot) chartFactory.getPlot();

                CP = new ChartPanel(chartFactory);
                barGraph.add(CP, BorderLayout.CENTER);
                barGraph.validate();
            } else {
                JOptionPane.showMessageDialog(this, "No Vital Signs To Display On Graph!!!");
            }
        } catch (Exception e) {

        }
    }

    public void populateLineGraph() {
        
        barGraph.removeAll();
        
        try {
            XYSeriesCollection dataset = new XYSeriesCollection();
            if (!(vitalSignHistory.getVitalSignList().isEmpty())) {
                for (VitalSign vs : vitalSignHistory.getVitalSignList()) {

                    XYSeries series1 = new XYSeries(vs.getBp());
                    series1.add(10, vs.getBp());
                    series1.add(20, vs.getHeartRate());
                    series1.add(30, vs.getRespRate());
                    series1.add(40, vs.getWeight());
                    dataset.addSeries(series1);

                }

                JFreeChart chartFactory = ChartFactory.createXYLineChart("GRAPHICAL REPRESENTATION OF SENSOR DATA", "X-Axis", "SIGN", dataset);
                XYLineAndShapeRenderer renderer = null;
                XYPlot plot = chartFactory.getXYPlot();
                renderer = new XYLineAndShapeRenderer();

                CP = new ChartPanel(chartFactory);
                barGraph.add(CP, BorderLayout.CENTER);
                barGraph.validate();
            } else {
                JOptionPane.showMessageDialog(this, "No Vital Signs To Display On Graph!!!");
            }
        } catch (Exception e) {
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
        barGraphBtn = new javax.swing.JButton();
        barGraph = new javax.swing.JPanel();
        lineGraphBtn = new javax.swing.JButton();
        pieChartBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        patientLabel = new javax.swing.JLabel();

        backBtn.setIcon(new javax.swing.ImageIcon("/Users/hpanjwani/Documents/NEU/1st Sem/5100 AED Lab/panjwani_hari_001664735/Project/images/back.png")); // NOI18N
        backBtn.setToolTipText("Go to Previous Page");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        barGraphBtn.setIcon(new javax.swing.ImageIcon("/Users/hpanjwani/Documents/NEU/1st Sem/5100 AED Lab/panjwani_hari_001664735/Project/images/Bar-chart.png")); // NOI18N
        barGraphBtn.setToolTipText("Bar Graph");
        barGraphBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barGraphBtnActionPerformed(evt);
            }
        });

        lineGraphBtn.setIcon(new javax.swing.ImageIcon("/Users/hpanjwani/Documents/NEU/1st Sem/5100 AED Lab/panjwani_hari_001664735/Project/images/Actions-office-chart-area-stacked-icon.png")); // NOI18N
        lineGraphBtn.setToolTipText("Line Chart");
        lineGraphBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineGraphBtnActionPerformed(evt);
            }
        });

        pieChartBtn.setIcon(new javax.swing.ImageIcon("/Users/hpanjwani/Documents/NEU/1st Sem/5100 AED Lab/panjwani_hari_001664735/Project/images/pie-chart-icon.jpg")); // NOI18N
        pieChartBtn.setToolTipText("Pie Chart");
        pieChartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pieChartBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("PATIENT HEALTH CHART");

        patientLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        patientLabel.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(barGraphBtn)
                            .addComponent(lineGraphBtn)
                            .addComponent(pieChartBtn)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barGraph, javax.swing.GroupLayout.PREFERRED_SIZE, 1043, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(patientLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(patientLabel)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(barGraph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(barGraphBtn)
                        .addGap(30, 30, 30)
                        .addComponent(lineGraphBtn)
                        .addGap(40, 40, 40)
                        .addComponent(pieChartBtn)
                        .addGap(116, 116, 116)
                        .addComponent(backBtn)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void barGraphBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barGraphBtnActionPerformed
        // TODO add your handling code here:
        populateGraph();
    }//GEN-LAST:event_barGraphBtnActionPerformed

    private void pieChartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pieChartBtnActionPerformed
        // TODO add your handling code here:
        populatePieChart();
    }//GEN-LAST:event_pieChartBtnActionPerformed

    private void lineGraphBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineGraphBtnActionPerformed
        // TODO add your handling code here:
        populateLineGraph();
    }//GEN-LAST:event_lineGraphBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JPanel barGraph;
    private javax.swing.JButton barGraphBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton lineGraphBtn;
    private javax.swing.JLabel patientLabel;
    private javax.swing.JButton pieChartBtn;
    // End of variables declaration//GEN-END:variables
}
