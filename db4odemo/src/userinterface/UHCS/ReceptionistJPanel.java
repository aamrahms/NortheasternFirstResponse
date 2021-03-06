/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.UHCS;

import Business.Complaint.Complaint;
import Business.EcoSystem;
import Business.Student.Student;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fianrodrigues
 */
public class ReceptionistJPanel extends javax.swing.JPanel
{

    /**
     * Creates new form ReceptionistJPanel
     */
    JPanel userProcessContainer;
    UserAccount account;
    EcoSystem system;
    Complaint mainComplaint;
    ArrayList<Complaint> complaintListWorkQueue;       //WorkRequest is complaint
    int selectedRow = -1;
    
    public ReceptionistJPanel(JPanel userProcessContainer, UserAccount account, EcoSystem system) 
    {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;     // logged user; UserAccount has both Employee (basic details) & WorkQueue (complaintlist)
        this.system = system;
        complaintListWorkQueue = this.account.getWorkQueue().getComplaintList();       //Work Queue is holding ComplaintList
        
        
        disableAll();
        
        populateTable();
    }
    
    public void disableAll() {
        
        btnAcceptCase.setEnabled(false);
        btnAssignDoctor.setEnabled(false);
        btnUhcsCompleted.setEnabled(false);
    }
    
    //Method to populate Open (pending) complaints under UHCS Complaints
    public void populateTable() {   
        //newly getting values
        complaintListWorkQueue = this.account.getWorkQueue().getComplaintList();
        
        DefaultTableModel md=(DefaultTableModel)tblComplaintsWithOpenStatus.getModel();
        md.setRowCount(0);
        Object row[]= new Object[8];
        
        for(Complaint complaintWorkRequest : complaintListWorkQueue){
            
            if (complaintWorkRequest.getStatus()!=null && complaintWorkRequest.getStatus().startsWith("UHCS")) {
            
                if (!"UHCS Completed".equals(complaintWorkRequest.getStatus())) {
                    row[0] = complaintWorkRequest; //in toString it is ID
                    row[1] = complaintWorkRequest.getTypeOfComplaint();
                    row[2] = complaintWorkRequest.getVictimStudent().getName();
                    row[3] = complaintWorkRequest.getDateOfIncident();
                    row[4] = complaintWorkRequest.getTypeOfIncident();
                    row[5] = complaintWorkRequest.getDescription();
                    row[6] = complaintWorkRequest.getDescription(); //must be feedback
                    row[7] = complaintWorkRequest.getStatus();
                     
                    md.addRow(row);
                    btnDecide.setEnabled(true); 
                }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblComplaintsWithOpenStatus = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        btnRefreshStatus = new javax.swing.JButton();
        btnAcceptCase = new javax.swing.JButton();
        btnAssignDoctor = new javax.swing.JButton();
        btnUhcsCompleted = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnDecide = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSelectedTable = new javax.swing.JTable();
        btnClearSelection = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 153));

        tblComplaintsWithOpenStatus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Type of Complaint", "Victim", "Date Of Incident", "Type of Incident", "Description", "Feedback", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblComplaintsWithOpenStatus);

        lblTitle.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Pending Compliant Status");

        btnRefreshStatus.setText("Refresh Status");
        btnRefreshStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshStatusActionPerformed(evt);
            }
        });

        btnAcceptCase.setText("Accept Case");
        btnAcceptCase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptCaseActionPerformed(evt);
            }
        });

        btnAssignDoctor.setText("Assign Doctor");
        btnAssignDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignDoctorActionPerformed(evt);
            }
        });

        btnUhcsCompleted.setText("UHCS Completed & Notify Chief Officier");
        btnUhcsCompleted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUhcsCompletedActionPerformed(evt);
            }
        });

        jLabel1.setText("Open Complaints under UHCS:");

        btnDecide.setText("Decide");
        btnDecide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecideActionPerformed(evt);
            }
        });

        jLabel2.setText("Selected Complaint for Deciding:");

        tblSelectedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Type of Complaint", "Victim", "Date Of Incident", "Type of Incident", "Description", "Feedback", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblSelectedTable);

        btnClearSelection.setText("Clear Selection");
        btnClearSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearSelectionActionPerformed(evt);
            }
        });

        btnBack.setText("<-- Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel3.setText("Close the case from UHCS side:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDecide))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addGap(129, 129, 129)
                                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnUhcsCompleted)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnClearSelection))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btnAcceptCase))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(btnAssignDoctor)
                        .addGap(156, 156, 156)
                        .addComponent(jLabel3)))
                .addContainerGap(90, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 655, Short.MAX_VALUE)
                .addComponent(btnRefreshStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefreshStatus)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnDecide))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnClearSelection)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btnAcceptCase)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAssignDoctor)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUhcsCompleted)
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshStatusActionPerformed
        
        disableAll();
        
        // clear selected table
        DefaultTableModel model = (DefaultTableModel) tblSelectedTable.getModel();
        model.setRowCount(0);
        
        //repopulates main table
        populateTable();
    }//GEN-LAST:event_btnRefreshStatusActionPerformed

    private void btnAcceptCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptCaseActionPerformed
        Complaint complaintWorkRequest = (Complaint) tblSelectedTable.getValueAt(0, 0);
        complaintWorkRequest.setStatus("UHCS Accepted");
        
        mainComplaint=system.getComplaintDirectory().getComplaint(complaintWorkRequest.getComplaintID());
        mainComplaint.setReceptionistAccepted(true);
//enable buttons
        btnAssignDoctor.setEnabled(true);
        btnAcceptCase.setEnabled(false);
        
        //update tables
        populateSelectedTable(complaintWorkRequest);
        populateTable();
    }//GEN-LAST:event_btnAcceptCaseActionPerformed

    private void btnDecideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecideActionPerformed
        
        
        selectedRow = tblComplaintsWithOpenStatus.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a Row!!");
            return;
        }
        disableAll();
        //cant add another to selected table
        btnDecide.setEnabled(false);
        
        Complaint complaintWorkRequest = (Complaint) tblComplaintsWithOpenStatus.getValueAt(selectedRow, 0);
        
        populateSelectedTable(complaintWorkRequest);
        
        String status = String.valueOf(complaintWorkRequest.getStatus());
        if ("UHCS New".equals(status)) {
            btnAcceptCase.setEnabled(true);
        } else if ("UHCS Accepted".equals(status)) {
            btnAssignDoctor.setEnabled(true);
            btnAcceptCase.setEnabled(false);
        } else if ("UHCS Doctor Completed".equals(status)) { // button not to be enabled for all statuses from "UHCS Assigned Doctor" till before this
            btnUhcsCompleted.setEnabled(true);
            btnAssignDoctor.setEnabled(false);
            btnAcceptCase.setEnabled(false);
        } else if ("UHCS Advisor Completed".equals(status)) {
            btnUhcsCompleted.setEnabled(true);
            btnAssignDoctor.setEnabled(false);
            btnAcceptCase.setEnabled(false);
        } 
    
    }//GEN-LAST:event_btnDecideActionPerformed
    
    public void populateSelectedTable(Complaint complaintWorkRequest) {
        DefaultTableModel md=(DefaultTableModel)tblSelectedTable.getModel();
        md.setRowCount(0);
        Object row[]= new Object[8];
        
        row[0] = complaintWorkRequest; //in toString it is ID
        row[1] = complaintWorkRequest.getTypeOfComplaint();
        row[2] = complaintWorkRequest.getVictimStudent().getName();
        row[3] = complaintWorkRequest.getDateOfIncident();
        row[4] = complaintWorkRequest.getTypeOfIncident();
        row[5] = complaintWorkRequest.getDescription();
        row[6] = complaintWorkRequest.getDescription(); //must be feedback
        row[7] = complaintWorkRequest.getStatus();
                     
        md.addRow(row);
        
    }
    
    private void btnClearSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearSelectionActionPerformed
        //equivalent to refresh
        
        disableAll();
        // clear selected table
        DefaultTableModel model = (DefaultTableModel) tblSelectedTable.getModel();
        model.setRowCount(0);
        
        //repopulates main table
        populateTable();
        
        //back screen
    }//GEN-LAST:event_btnClearSelectionActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        
        disableAll();
        // clear table
        DefaultTableModel model = (DefaultTableModel) tblSelectedTable.getModel();
        model.setRowCount(0);
        
        //back page
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnUhcsCompletedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUhcsCompletedActionPerformed
              
        //status to be changed into "UHCS Completed"
        Complaint complaintWorkRequest = (Complaint) tblComplaintsWithOpenStatus.getValueAt(selectedRow, 0);
        complaintWorkRequest.setStatus("UHCS Completed");
        
        //original complaint updation
        Complaint originalObject = system.getComplaintDirectory().getComplaint(complaintWorkRequest.getComplaintID());
        if (originalObject.getTypeOfIncident().equals("Injury")) {
            originalObject.setStatus("CaseClosed");
        } else if (originalObject.getTypeOfIncident().equals("Sexual Assault")) {
            originalObject.setStatus("UHCS Completed");
        }
        originalObject.setUHCS(false);
        originalObject.setDoctorFeedback(complaintWorkRequest.getDoctorFeedback());
        originalObject.setAdvisorFeedback(complaintWorkRequest.getAdvisorFeedback());
        
        //update in student's complaint
        Student originalStudent = system.getStudentDirectory().getStudent(complaintWorkRequest.getVictimStudent().getUsername());
            if (originalStudent !=null) {        
                Complaint originalStudentComplaint = originalStudent.getMyComplaint(complaintWorkRequest.getComplaintID());
                if (originalStudentComplaint!=null) {
                    originalObject.setUHCS(false);
                    originalObject.setDoctorFeedback(complaintWorkRequest.getDoctorFeedback());
                    originalObject.setAdvisorFeedback(complaintWorkRequest.getAdvisorFeedback());
                }
            }
        
        JOptionPane.showMessageDialog(null,"UHCS, thats a great job of closing the complaint. Thank you!");
        
        //then we refresh button to see complaint moved to old status table
        disableAll();
        // clear table
        DefaultTableModel model = (DefaultTableModel) tblSelectedTable.getModel();
        model.setRowCount(0);
        //repopulates table with that complaint gone
        populateTable();
    }//GEN-LAST:event_btnUhcsCompletedActionPerformed

    private void btnAssignDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignDoctorActionPerformed
        Complaint complaintWorkRequest = (Complaint) tblSelectedTable.getValueAt(0, 0);
        
        //status is set in next page
        //enable buttons
        btnAssignDoctor.setEnabled(false);
        
        //move to next page
        AssignDoctorJPanel assignDoctorPage = new AssignDoctorJPanel(userProcessContainer,account,complaintWorkRequest,system);
        userProcessContainer.add("Assign Doctor Page",assignDoctorPage);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
                
        //update tables - this will be done, when moved from next page
        /*populateSelectedTable(complaintWorkRequest);
        populateTable();*/
    }//GEN-LAST:event_btnAssignDoctorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcceptCase;
    private javax.swing.JButton btnAssignDoctor;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClearSelection;
    private javax.swing.JButton btnDecide;
    private javax.swing.JButton btnRefreshStatus;
    private javax.swing.JButton btnUhcsCompleted;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblComplaintsWithOpenStatus;
    private javax.swing.JTable tblSelectedTable;
    // End of variables declaration//GEN-END:variables
}
