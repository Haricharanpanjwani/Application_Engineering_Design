/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DoctorRole;

import Business.Enterprise.Enterprise;
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
public class GraphRepresentation extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private Patient patient;

    private DefaultCategoryDataset vitalSignDataSet;
    private VitalSignHistory vitalSignHistory;
    private int age;
    
    ChartPanel CP;

    /**
     * Creates new form GraphRepresentation
     */
    public GraphRepresentation(JPanel userProcessContainer, UserAccount userAccount, Enterprise enterprise, Patient patient) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        this.patient = patient;

        vitalSignHistory = patient.getVitalSignList();

        recLabel.setText(("Doctor Name: " + userAccount.getUsername()));
        hospitalLabel.setText("Hospital Name: " + enterprise.getName());
        hospitalLabel1.setText("Patient Name: " + patient.getName());

    }

    public void populateGraph() {

        barGraph.removeAll();

        try {
            if (patient != null) {
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
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void populatePieChart() {

        barGraph.removeAll();

        try {
            if(patient != null) {
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
            }
        } catch (Exception e) {

        }
    }

    public void populateLineGraph() {

        barGraph.removeAll();

        try {
            if(patient != null) {
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

        lineGraphBtn = new javax.swing.JButton();
        pieChartBtn = new javax.swing.JButton();
        barGraphBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        recLabel = new javax.swing.JLabel();
        hospitalLabel = new javax.swing.JLabel();
        hospitalLabel1 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        barGraph = new javax.swing.JPanel();

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

        barGraphBtn.setIcon(new javax.swing.ImageIcon("/Users/hpanjwani/Documents/NEU/1st Sem/5100 AED Lab/panjwani_hari_001664735/Project/images/Bar-chart.png")); // NOI18N
        barGraphBtn.setToolTipText("Bar Graph");
        barGraphBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barGraphBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("PATIENT HEALTH CHART");

        recLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        recLabel.setText("jLabel2");

        hospitalLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        hospitalLabel.setText("jLabel2");

        hospitalLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        hospitalLabel1.setText("jLabel2");

        backBtn.setIcon(new javax.swing.ImageIcon("/Users/hpanjwani/Documents/NEU/1st Sem/5100 AED Lab/panjwani_hari_001664735/Project/images/back.png")); // NOI18N
        backBtn.setToolTipText("Go to Previous Page");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(barGraphBtn)
                            .addComponent(lineGraphBtn))
                        .addGap(246, 246, 246)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hospitalLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel1))
                            .addComponent(recLabel)
                            .addComponent(hospitalLabel)))
                    .addComponent(backBtn)
                    .addComponent(pieChartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(459, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(173, 173, 173)
                    .addComponent(barGraph, javax.swing.GroupLayout.PREFERRED_SIZE, 1011, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(13, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addComponent(recLabel)
                .addGap(18, 18, 18)
                .addComponent(hospitalLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(hospitalLabel1)
                        .addGap(560, 560, 560)
                        .addComponent(backBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(barGraphBtn)
                        .addGap(30, 30, 30)
                        .addComponent(lineGraphBtn)
                        .addGap(40, 40, 40)
                        .addComponent(pieChartBtn)))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(167, 167, 167)
                    .addComponent(barGraph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lineGraphBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineGraphBtnActionPerformed
        // TODO add your handling code here:
        populateLineGraph();
    }//GEN-LAST:event_lineGraphBtnActionPerformed

    private void pieChartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pieChartBtnActionPerformed
        // TODO add your handling code here:
        populatePieChart();
    }//GEN-LAST:event_pieChartBtnActionPerformed

    private void barGraphBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barGraphBtnActionPerformed
        // TODO add your handling code here:
        populateGraph();
    }//GEN-LAST:event_barGraphBtnActionPerformed

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
    private javax.swing.JLabel hospitalLabel;
    private javax.swing.JLabel hospitalLabel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton lineGraphBtn;
    private javax.swing.JButton pieChartBtn;
    private javax.swing.JLabel recLabel;
    // End of variables declaration//GEN-END:variables
}
