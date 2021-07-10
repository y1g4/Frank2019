
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.net.ServerSocket;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
//////////// end ///////////////

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;


public class Faculty_Server extends javax.swing.JFrame {

   
    Connection con; //establish connection
  PreparedStatement statement; //execute sql statement more of optimised
  Statement st;//execute sql statement less of optimised
  String cs; //holding path of the database
  String user;//username for the database
  String password;//password for the database
  String query;
  ResultSet rs;
  String records;
  Boolean bnext = false;
  Boolean bprevious = true;
  
  ObjectOutputStream serverObjectStreamWriter;
  ObjectInputStream serverObjectStreamReader, isReader;
  
  ServerSocket serverSock ;
  Socket clientSocket;
  
  Faculty_SC SerialObj;
  
    public Faculty_Server() {
        initComponents();
        
        con = null;
    st = null;
    statement = null;
    
    cs = "jdbc:mysql://localhost:3306/admission";
    user = "root";
    password = "peacebewithyouall2020";
    
    //serverObjectStreamWriter = null;
        //serverObjectStreamReader = null;
        //serverSock = null;
        //clientSocket = null;
       // SerialObj = null;
   // go();
    }

   public void go(){
       try{
           serverSock = new ServerSocket(50000);
           SerialObj= new Faculty_SC();
           
           clientSocket = serverSock.accept();
           serverObjectStreamReader = new ObjectInputStream(clientSocket.getInputStream());
	   serverObjectStreamWriter = new ObjectOutputStream(clientSocket.getOutputStream());
				
	   Thread t = new Thread(new ServerRunnable());

	   t.start();
	   System.out.println("got a connection");
       }
       catch(Exception ex){
			ex.printStackTrace();
		}
   }
   
   public class ServerRunnable implements Runnable{

        @Override
        public void run() {
            try{
                while((SerialObj =  (Faculty_SC)serverObjectStreamReader.readObject()) != null){
                     
             Class.forName("com.mysql.cj.jdbc.Driver");//register JDBC driver
    
   con = DriverManager.getConnection(cs,user,password);
   st = con.createStatement();
   
   
   
   //if(SerialObj.bSave == true){
       
       facultyID.setText(SerialObj.Fac_ID);
        txtfacultyname.setText(SerialObj.Fac_Name);
                     
    query = "INSERT INTO Faculty (Faculty_id,Faculty_Name) VALUES ('"+SerialObj.Fac_ID+"','"+SerialObj.Fac_Name+"')";
   // st. executeUpdate(query);
    JOptionPane.showMessageDialog(null,"Record saved successfully");
  // }
         //SerialObj.bSave = false;   
         

if(SerialObj.bFind == true){
    
    
    PreparedStatement st = con.prepareStatement("SELECT * FROM Faculty WHERE   Faculty_id ='"+SerialObj.Fac_ID+"'", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = st.executeQuery();
   //query = " SELECT * FROM Faculty WHERE   Faculty_id ='"+SerialObj.Fac_ID+"'";
   //st. executeUpdate(query);
   
    if(rs.first()){
       SerialObj.Fac_ID = rs.getString("Faculty_id"); 
       SerialObj.Fac_Name = rs.getString("Faculty_Name");
       
       //serverObjectStreamReader.writeObject()
       serverObjectStreamWriter.writeObject(SerialObj);
    }
    else{
        JOptionPane.showMessageDialog(null,"Record not found");
         facultyID
                 .setText("");
         facultyID.requestFocus();
    }}
   

if(SerialObj.bFirst == true){
    
    PreparedStatement st = con.prepareStatement("SELECT * FROM Faculty ", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = st.executeQuery();
    
    if(rs.first()){
       SerialObj.Fac_ID = rs.getString("Faculty_id"); 
       SerialObj.Fac_Name = rs.getString("Faculty_Name");
       
       serverObjectStreamWriter.writeObject(SerialObj);
    }
}
         //serverObjectStreamWriter.close();
         //serverObjectStreamReader.close();
              //       go();
                }
            }
             catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (SQLException ex) {
                Logger.getLogger(Faculty_Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFacultyID = new javax.swing.JLabel();
        lblfacultyname = new javax.swing.JLabel();
        facultyID = new javax.swing.JTextField();
        txtfacultyname = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        findbtn = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        previousbtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SERVER");

        lblFacultyID.setText("Faculty id");

        lblfacultyname.setText("FAculty Name");

        btnsave.setText("Save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        findbtn.setText("Find");
        findbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findbtnActionPerformed(evt);
            }
        });

        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        previousbtn.setText("Previous");
        previousbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousbtnActionPerformed(evt);
            }
        });

        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblfacultyname)
                            .addComponent(lblFacultyID))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(facultyID, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfacultyname, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnsave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(findbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFirst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLast)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(previousbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deletebtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFacultyID)
                    .addComponent(facultyID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblfacultyname)
                    .addComponent(txtfacultyname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsave)
                    .addComponent(findbtn)
                    .addComponent(btnFirst)
                    .addComponent(btnNext)
                    .addComponent(btnLast)
                    .addComponent(previousbtn)
                    .addComponent(deletebtn))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
       
   
    }//GEN-LAST:event_btnsaveActionPerformed

    private void findbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findbtnActionPerformed
    
    }//GEN-LAST:event_findbtnActionPerformed

    private void previousbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousbtnActionPerformed
        // TODO add your handling code here:
        try {
   
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    con = DriverManager.getConnection(cs,user,password);
    st = con.createStatement();
    
    PreparedStatement st = con.prepareStatement("SELECT * FROM Faculty", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    
    if(!bprevious){
      rs = st.executeQuery();  
       rs.last();
   
       facultyID.setText(rs.getString("Faculty_id")); 
       txtfacultyname.setText(rs.getString("Faculty_Name"));
      
       bprevious = true;
    }
    else if(rs.previous()){
        
        facultyID.setText(rs.getString("Faculty_id")); 
      facultyID.setText(rs.getString("Faculty_Name"));
       
     bnext = true;
      
    }
    
    
       
}
catch (SQLException ex){
    ex.printStackTrace();
}
catch (ClassNotFoundException e){
  e.printStackTrace();  
}


    }//GEN-LAST:event_previousbtnActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        try {
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    con = DriverManager.getConnection(cs,user,password);
    st = con.createStatement();
    //query = "SELECT * FROM students ";
    //st. executeUpdate(query);
    //JOptionPane.showMessageDialog(null,"Record saved");
    PreparedStatement st = con.prepareStatement("SELECT * FROM Faculty", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = st.executeQuery();
    
    
    
    if(rs.first()){
       facultyID.setText(rs.getString("Faculty_id")); 
       txtfacultyname.setText(rs.getString("Faculty_Name"));
       
    }
    else{
        JOptionPane.showMessageDialog(null,"Record not found");
        facultyID.setText("");
        facultyID.requestFocus();
    }
    
    
       
}
catch (SQLException ex){
    ex.printStackTrace();
}
catch (ClassNotFoundException e){
  e.printStackTrace();  
}

finally{
    
    try{
        if(st != null)
        {
            st.close();
        }
        if(con != null){
            con.close();
        }
    }
        catch (SQLException ex){
                ex.printStackTrace();
                }
    }
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
         try {
   
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    con = DriverManager.getConnection(cs,user,password);
    st = con.createStatement();
    PreparedStatement st = con.prepareStatement("SELECT * FROM Faculty", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    if(!bnext){
      rs = st.executeQuery();  
       rs.first();
   
       facultyID.setText(rs.getString("Faculty_id")); 
       txtfacultyname.setText(rs.getString("Faculty_Name"));
       
       bnext = true;
    }
    else if(rs.next()){
        
        facultyID.setText(rs.getString("Faculty_id")); 
       txtfacultyname.setText(rs.getString("Faculty_Name"));
       
     bnext = true;
      
    }
    
    
       
}
catch (SQLException ex){
    ex.printStackTrace();
}
catch (ClassNotFoundException e){
  e.printStackTrace();  
}

    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
         try {
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    con = DriverManager.getConnection(cs,user,password);
    st = con.createStatement();
    PreparedStatement st = con.prepareStatement("SELECT * FROM Faculty", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = st.executeQuery();
    
    if(rs.last()){
       facultyID.setText(rs.getString("Faculty_id")); 
       txtfacultyname.setText(rs.getString("Faculty_Name"));
       
    }
    else{
        JOptionPane.showMessageDialog(null,"Record not found");
        facultyID.setText("");
        facultyID.requestFocus();
    }
    
    
       
}
catch (SQLException ex){
    ex.printStackTrace();
}
catch (ClassNotFoundException e){
  e.printStackTrace();  
}

 finally{
    
    try{
        if(st != null)
        {
            st.close();
        }
        if(con != null){
            con.close();
        }
    }
        catch (SQLException ex){
                ex.printStackTrace();
                }
    }
    }//GEN-LAST:event_btnLastActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        // TODO add your handling code here:
        int answer = JOptionPane.showConfirmDialog(this,"Are you sure you want to delete?","confirm",JOptionPane.YES_NO_OPTION);
        
    if(answer == YES_OPTION){
     try {
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    con = DriverManager.getConnection(cs,user,password);
    st = con.createStatement();
    
    
    PreparedStatement st = con.prepareStatement("DELETE  FROM Faculty WHERE   Faculty_id ='"+facultyID.getText()+"'", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    
     if(st.executeUpdate() == 1){
         JOptionPane.showMessageDialog(null,"Record with RegNo: '"+facultyID.getText()+"'deleted");
         
     }
     else if(st.executeUpdate() == 0){
         JOptionPane.showMessageDialog(null,"Record with RegNo: '"+facultyID.getText()+"'does not exist");
     }
  }
     
catch (SQLException ex){
    ex.printStackTrace();
}
catch (ClassNotFoundException e){
  e.printStackTrace();  
}

finally{
    
    try{
        if(st != null)
        {
            st.close();
        }
        if(con != null){
            con.close();
        }
    }
        catch (SQLException ex){
                ex.printStackTrace();
                }
    }
    
    
    }                                            
else if(answer == NO_OPTION){
          deletebtn.requestFocus();
          return ;
      }
    }//GEN-LAST:event_deletebtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String []args) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Faculty_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Faculty_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Faculty_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Faculty_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new Faculty_Server().setVisible(true);
               Faculty_Server ty = new Faculty_Server();
               ty.setSize(600,600);
               ty.setVisible(true);
               ty.go();
            }
        }); */
        Faculty_Server ty = new Faculty_Server();
               ty.setSize(600,600);
               ty.setVisible(true);
               ty.go();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton deletebtn;
    private javax.swing.JTextField facultyID;
    private javax.swing.JButton findbtn;
    private javax.swing.JLabel lblFacultyID;
    private javax.swing.JLabel lblfacultyname;
    private javax.swing.JButton previousbtn;
    private javax.swing.JTextField txtfacultyname;
    // End of variables declaration//GEN-END:variables
}
