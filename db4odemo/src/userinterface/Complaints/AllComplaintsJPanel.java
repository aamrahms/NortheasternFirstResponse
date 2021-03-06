/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Complaints;

import Business.Complaint.Complaint;
import Business.EcoSystem;
import Business.Student.Student;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fianrodrigues
 */
public class AllComplaintsJPanel extends javax.swing.JPanel 
{

    /**
     * Creates new form AllComplaintsJPanel
     */
    JPanel userProcessContainer;
    EcoSystem system;
    UserAccount account;
    ArrayList<Complaint> complaintDirectory;
    ArrayList<Student> studentList;
    Student victimStudent;
    DefaultTableModel md;
    int selectedRow = -1;
    
    public AllComplaintsJPanel(JPanel userProcessContainer,  UserAccount account, EcoSystem system) 
    {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.account = account;
        complaintDirectory= this.system.getComplaintDirectory().getComplaintList();
        studentList=system.getStudentDirectory().getStudentDir();
        for(Student student : studentList)
        {
            if(student.getUserAccount().equals(account))
            {
                victimStudent=student;
            }
           
        }
        populateTable();
        
        disableAll();
    }

     public void populateTable()
     {
        int i=0;
        md=(DefaultTableModel)tblAllComplaints.getModel();
        md.setRowCount(0);
        Object row[]= new Object[7];
        try{
            for(Complaint c : victimStudent.getMyComplaints())
            {
                
                row[0]=c.getComplaintID();
                row[1]=c.getTypeOfComplaint();
                row[2]=c.getVictimStudent().getName();
                try{
                    row[3]=c.getAccusedStudent().getName();
                }
                catch(NullPointerException e){
                    row[3]="";
                }
                row[4]=c.getLocation();
                row[5]=c.getVictimStudent().getPhone();
                row[6]=c.getStatus();
                md.addRow(row);
                
                //notifications
                if (c.isNotifyFromDoctor()) {
                    JOptionPane.showMessageDialog(null,"Notification: For complaint: "+c.getComplaintID()+" Doctor scheduled appointment, visit your doctor- name: "+c.getDoctorName(),"Warning",JOptionPane.WARNING_MESSAGE);
                    c.setNotifyFromDoctor(false);
                }
                if (c.isNotifyFromAdvisor()) {
                    JOptionPane.showMessageDialog(null,"Notification: For complaint: "+c.getComplaintID()+" Advisor scheduled appointment, visit your advisor- name: "+c.getAdvisorName(),"Warning",JOptionPane.WARNING_MESSAGE);
                    c.setNotifyFromAdvisor(false);
                }
                

            }
        }
        catch(NullPointerException e){
            JOptionPane.showMessageDialog(this, "You have no complaints");
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
        tblAllComplaints = new javax.swing.JTable();
        lblHeading = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnSelect = new javax.swing.JButton();
        lblDoctor = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDoctorFeedback = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblAdvisor = new javax.swing.JLabel();
        txtAdvisorFeedback = new javax.swing.JTextField();
        lblDriver = new javax.swing.JLabel();
        txtDriverFeedback = new javax.swing.JTextField();
        lblPoliceofficier = new javax.swing.JLabel();
        txtPoliceOfficerFeedback = new javax.swing.JTextField();
        lblcoordinator = new javax.swing.JLabel();
        txtCoordinatorFeedback = new javax.swing.JTextField();
        btnClearSelection = new javax.swing.JButton();
        btnRefreshStatus = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));
        setLayout(null);

        tblAllComplaints.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Complaint ID", "Priority", "Victim", "Accused", "Location", "Contact", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAllComplaints);

        add(jScrollPane1);
        jScrollPane1.setBounds(124, 167, 696, 109);

        lblHeading.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        lblHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeading.setText("ALL COMPLAINTS");
        add(lblHeading);
        lblHeading.setBounds(0, 55, 922, 22);

        btnBack.setText("< Go Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(0, 14, 108, 29);

        btnSelect.setText("Select");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });
        add(btnSelect);
        btnSelect.setBounds(840, 200, 81, 29);

        lblDoctor.setText("Doctor:");
        add(lblDoctor);
        lblDoctor.setBounds(110, 450, 60, 16);
        add(txtStatus);
        txtStatus.setBounds(190, 340, 380, 40);

        jLabel2.setText("Feedbacks:");
        add(jLabel2);
        jLabel2.setBounds(140, 410, 90, 16);
        add(txtDoctorFeedback);
        txtDoctorFeedback.setBounds(190, 440, 380, 30);

        jLabel3.setText("Status:");
        add(jLabel3);
        jLabel3.setBounds(140, 350, 43, 16);

        lblAdvisor.setText("Advisor:");
        add(lblAdvisor);
        lblAdvisor.setBounds(110, 490, 60, 16);
        add(txtAdvisorFeedback);
        txtAdvisorFeedback.setBounds(190, 480, 380, 30);

        lblDriver.setText("Driver:");
        add(lblDriver);
        lblDriver.setBounds(110, 530, 50, 16);
        add(txtDriverFeedback);
        txtDriverFeedback.setBounds(190, 520, 380, 30);

        lblPoliceofficier.setText("Police Officer:");
        add(lblPoliceofficier);
        lblPoliceofficier.setBounds(80, 580, 90, 16);
        add(txtPoliceOfficerFeedback);
        txtPoliceOfficerFeedback.setBounds(190, 570, 380, 30);

        lblcoordinator.setText("OUEC Coordinator:");
        add(lblcoordinator);
        lblcoordinator.setBounds(50, 630, 130, 16);
        add(txtCoordinatorFeedback);
        txtCoordinatorFeedback.setBounds(190, 620, 380, 30);

        btnClearSelection.setText("Clear Selection");
        btnClearSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearSelectionActionPerformed(evt);
            }
        });
        add(btnClearSelection);
        btnClearSelection.setBounds(830, 240, 130, 29);

        btnRefreshStatus.setText("Refresh Status");
        btnRefreshStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshStatusActionPerformed(evt);
            }
        });
        add(btnRefreshStatus);
        btnRefreshStatus.setBounds(670, 120, 134, 29);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout cardlayout = (CardLayout) userProcessContainer.getLayout();
        cardlayout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        selectedRow = tblAllComplaints.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a Row!!");
            return;
        }
        
        String complaintID = (String) tblAllComplaints.getValueAt(selectedRow, 0);
        Complaint selectedComplaint = system.getStudentDirectory().getStudent(account.getUsername()).getMyComplaint(complaintID);
        
        if(null!=selectedComplaint.getDoctorFeedback() && !selectedComplaint.getDoctorFeedback().isEmpty()) {
            txtDoctorFeedback.setEnabled(true);
            txtDoctorFeedback.setText(selectedComplaint.getDoctorFeedback());
        }
        if(null!=selectedComplaint.getOUECCoordinatorFeedback() && !selectedComplaint.getOUECCoordinatorFeedback().isEmpty()) {
            txtCoordinatorFeedback.setEnabled(true);
            txtCoordinatorFeedback.setText(selectedComplaint.getOUECCoordinatorFeedback());
        } 
        if(null!=selectedComplaint.getDriverFeedback() && !selectedComplaint.getDriverFeedback().isEmpty()) {
            txtDriverFeedback.setEnabled(true);
            txtDriverFeedback.setText(selectedComplaint.getDriverFeedback());
        }
        
        if(null!=selectedComplaint.getPoliceOfficerFeedback() && !selectedComplaint.getPoliceOfficerFeedback().isEmpty()) {
            txtPoliceOfficerFeedback.setEnabled(true);
            txtPoliceOfficerFeedback.setText(selectedComplaint.getPoliceOfficerFeedback());
        } 
        if(null!=selectedComplaint.getStatus() && !selectedComplaint.getStatus().isEmpty()) {
            txtStatus.setEnabled(true);
            txtStatus.setText(selectedComplaint.getStatus());
        }
        
    }//GEN-LAST:event_btnSelectActionPerformed

    private void btnClearSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearSelectionActionPerformed
        selectedRow = -1;
        disableAll();
    }//GEN-LAST:event_btnClearSelectionActionPerformed

    private void btnRefreshStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshStatusActionPerformed

        disableAll();

        selectedRow=-1;

        //repopulates main table
        populateTable();
    }//GEN-LAST:event_btnRefreshStatusActionPerformed
    
    public void disableAll() {
        txtAdvisorFeedback.setEnabled(false);
        txtCoordinatorFeedback.setEnabled(false);
        txtDoctorFeedback.setEnabled(false);
        txtDriverFeedback.setEnabled(false);
        //txtInvestigatorFeedback.setEnabled(false);
        txtPoliceOfficerFeedback.setEnabled(false);
        txtStatus.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClearSelection;
    private javax.swing.JButton btnRefreshStatus;
    private javax.swing.JButton btnSelect;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdvisor;
    private javax.swing.JLabel lblDoctor;
    private javax.swing.JLabel lblDriver;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblPoliceofficier;
    private javax.swing.JLabel lblcoordinator;
    private javax.swing.JTable tblAllComplaints;
    private javax.swing.JTextField txtAdvisorFeedback;
    private javax.swing.JTextField txtCoordinatorFeedback;
    private javax.swing.JTextField txtDoctorFeedback;
    private javax.swing.JTextField txtDriverFeedback;
    private javax.swing.JTextField txtPoliceOfficerFeedback;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
