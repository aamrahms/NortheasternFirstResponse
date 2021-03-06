/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.NUPD;

import Business.Complaint.Complaint;
import Business.EcoSystem;
import Business.Logic.NUPD.PoliceOfficer;
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
public class PoliceOfficerJPanel extends javax.swing.JPanel 
{

    /**
     * Creates new form PoliceOfficerStatusJPanel
     */
    
    JPanel userProcessContainer;
    UserAccount account;
    EcoSystem system;
    ArrayList<Complaint> complaintDirectory;
    ArrayList<PoliceOfficer> policeList;
    PoliceOfficer police;
    DefaultTableModel md;
    
    public PoliceOfficerJPanel(JPanel userProcessContainer, UserAccount account, EcoSystem system)
    {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.system = system;
        complaintDirectory = this.system.getComplaintDirectory().getComplaintList();
        policeList=this.system.getPoliceDirectory().getPoliceOfficerList();
        for(PoliceOfficer p : policeList)
        {
            if(p.getUsername().equals(account.getUsername()))
            {
                police=p;
            }
        }
        populateTable();
        
    }
    
    public void populateTable()
    {
        int i=0;
        md=(DefaultTableModel)tblComplaints.getModel();
        md.setRowCount(0);
        Object row[]= new Object[8];
        
        for(Complaint c : police.getPoliceComplaints())
        {
//            if(c.getPoliceOfficer()==null)
//            {
//                continue;
//            }
//            else if(c.getPoliceOfficer()==police)
//            {
                i=1;
            
                if(c.getTypeOfComplaint().equalsIgnoreCase("Emergency"))
                {
                    row[0]=c;
                    row[1]=c.getTypeOfComplaint();
                    row[2]=c.getTypeOfIncident();
                    row[3]=c.getVictimStudent().getName();
                    if(c.getAccusedStudent()==null)
                    {
                        row[4]="";
                    }
                    else
                    {
                        row[4]=c.getAccusedStudent().getName();
                    }

                    row[5]=c.getLocation();
                    row[6]=c.getVictimStudent().getPhone();
                    try{
                        row[7]=c.getStatus();
                    }
                    catch(NullPointerException e)
                    {
                        row[7]="New Case";
                    }
                    

    //              row[7]=c.getNatureOfIncident();
                    md.addRow(row);
                }
                    
            //}          
        }
        if(i==0)
        {
            
            JOptionPane.showMessageDialog(this,"You dont have any complaints assigned to you");
       
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
        tblComplaints = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        btnProcessComplaints = new javax.swing.JButton();
        btnRefreshStatus = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        tblComplaints.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Complaint ID", "Priority", "Type of Incident", "Victim", "Accused", "Location", "Contact", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblComplaints);

        add(jScrollPane1);
        jScrollPane1.setBounds(79, 142, 926, 107);

        lblTitle.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("COMPLAINT STATUS");
        add(lblTitle);
        lblTitle.setBounds(0, 32, 1056, 59);

        btnProcessComplaints.setBackground(new java.awt.Color(0, 153, 153));
        btnProcessComplaints.setText("Process Complaint");
        btnProcessComplaints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessComplaintsActionPerformed(evt);
            }
        });
        add(btnProcessComplaints);
        btnProcessComplaints.setBounds(242, 319, 209, 29);

        btnRefreshStatus.setBackground(new java.awt.Color(0, 153, 153));
        btnRefreshStatus.setText("Refresh Status");
        btnRefreshStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshStatusActionPerformed(evt);
            }
        });
        add(btnRefreshStatus);
        btnRefreshStatus.setBounds(665, 319, 202, 29);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshStatusActionPerformed
        // TODO add your handling code here:
        populateTable();
        tblComplaints.repaint();
        
    }//GEN-LAST:event_btnRefreshStatusActionPerformed

    private void btnProcessComplaintsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessComplaintsActionPerformed
        // TODO add your handling code here:
        int selectedRow =tblComplaints.getSelectedRow();
        
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please pick a complaint to process!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{
            
            Complaint complaint= (Complaint) tblComplaints.getValueAt(selectedRow, 0);
//            JOptionPane.showMessageDialog(null, complaint.getTypeOfIncident(), "Warning", JOptionPane.WARNING_MESSAGE);
            if (complaint.getTypeOfIncident().equalsIgnoreCase("Injury") )
            {
                InjuryStatusJPanel injuryPanel= new InjuryStatusJPanel(userProcessContainer, account, system, police, complaint);
                userProcessContainer.add("CheckComplaintJPanel",injuryPanel);
                CardLayout cardlayout= (CardLayout) userProcessContainer.getLayout();
                cardlayout.next(userProcessContainer);
            }
            else if (complaint.getTypeOfIncident().equalsIgnoreCase("Firearm") )
            {
                FirearmsStatusJPanel firearmsPanel= new FirearmsStatusJPanel(userProcessContainer, account, system,police, complaint);
                userProcessContainer.add("CheckComplaintJPanel",firearmsPanel);
                CardLayout cardlayout= (CardLayout) userProcessContainer.getLayout();
                cardlayout.next(userProcessContainer);
            }
            else if (complaint.getTypeOfIncident().equalsIgnoreCase("Threats or Stalking") )
            {
                ThreatsOrStalkingStatusJPanel threatsPanel= new ThreatsOrStalkingStatusJPanel(userProcessContainer, account, system,police, complaint);
                userProcessContainer.add("CheckComplaintJPanel",threatsPanel);
                CardLayout cardlayout= (CardLayout) userProcessContainer.getLayout();
                cardlayout.next(userProcessContainer);
            }
            else if (complaint.getTypeOfIncident().equalsIgnoreCase("Sexual Assault") )
            {
                SexualAssaultStatusJPanel assaultPanel= new SexualAssaultStatusJPanel(userProcessContainer, account, system, police,complaint);
                userProcessContainer.add("CheckComplaintJPanel",assaultPanel);
                CardLayout cardlayout= (CardLayout) userProcessContainer.getLayout();
                cardlayout.next(userProcessContainer);
            }
      
        
        }
    }//GEN-LAST:event_btnProcessComplaintsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcessComplaints;
    private javax.swing.JButton btnRefreshStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblComplaints;
    // End of variables declaration//GEN-END:variables
}
