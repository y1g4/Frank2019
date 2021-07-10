import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.lang.NullPointerException;
//import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.lang.NullPointerException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;



public class Department extends javax.swing.JFrame {
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
  
   ObjectOutputStream clientObjectStreamWriter;
  ObjectInputStream clientObjectStreamReader, isReader;
  
  Socket sock;
  
  Department_SC SerialObj;
  
    public Department() {
        go();
        initComponents();
         con = null;
    st = null;
    statement = null;
    
    cs = "jdbc:mysql://localhost:3306/admission";
    user = "root";
    password = "peacebewithyouall2020";
    }
    public void go() {
        try{
            
            sock = new Socket("127.0.0.1",50000);
        SerialObj = new Department_SC();
        
        clientObjectStreamWriter = new ObjectOutputStream(sock.getOutputStream());
        clientObjectStreamReader = new ObjectInputStream(sock.getInputStream());
        System.out.println("networking established");
        
        Thread t = new Thread((Runnable) new ClientRunnable());

	t.start();
	System.out.println("got a connection");
        }
        catch(java.net.ConnectException e){
            JOptionPane.showMessageDialog(null,"CONNECTION REFUSED!! SERVER DOWN MAYBE");
            System.exit(0);
                 } catch (IOException ex) {
        Logger.getLogger(Department.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public class ClientRunnable implements Runnable{

        @Override
        public void run() {
            try{
                while((SerialObj =  (Department_SC)clientObjectStreamReader.readObject()) != null ){
                    
                    txtDepartment_ID.setText(SerialObj.Dep_ID);
                    txtDepartment_Name.setText(SerialObj. Dep_Name);
                    txtFaculty_ID.setText(SerialObj.Fac_ID);
                    
                    
                    
                    go();
                }
            }
             catch (IOException ex) {
                        ex.printStackTrace();
                    }
            catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
        }
        
    }
    
    

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDepartment_ID = new javax.swing.JLabel();
        lblDepartment_Name = new javax.swing.JLabel();
        lblFaculty_ID = new javax.swing.JLabel();
        Savebtn = new javax.swing.JButton();
        Findbtn = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtDepartment_Name = new javax.swing.JTextField();
        txtDepartment_ID = new javax.swing.JTextField();
        txtFaculty_ID = new javax.swing.JTextField();
        btnFirst = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        lastbtn = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDepartment_ID.setFont(new java.awt.Font("DejaVu Serif", 1, 24)); // NOI18N
        lblDepartment_ID.setText("Department ID");
        getContentPane().add(lblDepartment_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 56, -1, 59));

        lblDepartment_Name.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        lblDepartment_Name.setText("Department Name");
        getContentPane().add(lblDepartment_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 176, 220, 62));

        lblFaculty_ID.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        lblFaculty_ID.setText("Faculty ID");
        getContentPane().add(lblFaculty_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 289, 130, 61));

        Savebtn.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        Savebtn.setText("Save");
        Savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SavebtnActionPerformed(evt);
            }
        });
        getContentPane().add(Savebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 381, 86, 44));

        Findbtn.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        Findbtn.setText("Find");
        Findbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindbtnActionPerformed(evt);
            }
        });
        getContentPane().add(Findbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 381, 99, 44));

        btnDelete.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 383, 104, 41));

        txtDepartment_Name.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        txtDepartment_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartment_NameActionPerformed(evt);
            }
        });
        getContentPane().add(txtDepartment_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 177, 405, 62));

        txtDepartment_ID.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        txtDepartment_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartment_IDActionPerformed(evt);
            }
        });
        getContentPane().add(txtDepartment_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 59, 405, 59));

        txtFaculty_ID.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        txtFaculty_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFaculty_IDActionPerformed(evt);
            }
        });
        getContentPane().add(txtFaculty_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 281, 405, 61));

        btnFirst.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });
        getContentPane().add(btnFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 381, 79, 44));

        btnNext.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        getContentPane().add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 382, 79, 42));

        lastbtn.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        lastbtn.setText("Last");
        lastbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastbtnActionPerformed(evt);
            }
        });
        getContentPane().add(lastbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 382, 77, 42));

        btnPrevious.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });
        getContentPane().add(btnPrevious, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 382, 106, 42));

        kGradientPanel1.setkEndColor(java.awt.Color.white);
        kGradientPanel1.setkStartColor(java.awt.Color.blue);

        jButton1.setText("B");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 710, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 432, Short.MAX_VALUE))
        );

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtDepartment_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartment_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartment_IDActionPerformed

    private void txtFaculty_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFaculty_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFaculty_IDActionPerformed

    private void SavebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavebtnActionPerformed
        // TODO add your handling code here:
        
       String s1 =  txtDepartment_ID.getText();
     String s2 =  txtDepartment_Name.getText();
     String s3 =  txtFaculty_ID.getText();


try {
    
    Class.forName("com.mysql.cj.jdbc.Driver");//register JDBC driver
    
    con = DriverManager.getConnection(cs,user,password);
    st = con.createStatement();
    query = "INSERT INTO Department (Department_id,Department_Name, Faculty_Faculty_id ) VALUES ('"+s1+"','"+s2+"','"+s3+"')";
    st. executeUpdate(query);
    JOptionPane.showMessageDialog(null,"Record saved successfully");
    
    txtDepartment_ID.setText("");
     txtDepartment_Name.setText("");
     txtFaculty_ID.setText("");
    
     
     txtDepartment_ID.requestFocus();  //setting focus on REGNO   
}catch (ClassNotFoundException e){
  e.printStackTrace();  //checks if the driver  is not configured
}       catch (SQLException ex) {
            Logger.getLogger(Department_Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        //displays information about SQL statement incase you typed table name or field name that is not existing
        //it displays where the error may be
        

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

        
    }//GEN-LAST:event_SavebtnActionPerformed

    private void txtDepartment_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartment_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartment_NameActionPerformed

    private void FindbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FindbtnActionPerformed
        // TODO add your handling code here:
        try {
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    con = DriverManager.getConnection(cs,user,password);
    
    
     PreparedStatement st = con.prepareStatement("SELECT * FROM Department WHERE   Department_id ='"+txtDepartment_ID.getText()+"'", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = st.executeQuery();
    
    if(rs.first()){
       txtDepartment_ID.setText(rs.getString("Department_id")); 
       txtDepartment_Name.setText(rs.getString("Department_Name"));
       txtFaculty_ID.setText(rs.getString("Faculty_Faculty_id"));
       
    }
    else{
        JOptionPane.showMessageDialog(null,"Record not found");
         txtDepartment_ID.setText("");
         txtDepartment_ID.requestFocus();
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

    }//GEN-LAST:event_FindbtnActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        try {
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    con = DriverManager.getConnection(cs,user,password);
    st = con.createStatement();
    //query = "SELECT * FROM students ";
    //st. executeUpdate(query);
    //JOptionPane.showMessageDialog(null,"Record saved");
    PreparedStatement st = con.prepareStatement("SELECT * FROM Department", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = st.executeQuery();
    
    
    
    if(rs.first()){
       txtDepartment_ID.setText(rs.getString("Department_id")); 
       txtDepartment_Name.setText(rs.getString("Department_Name"));
       txtFaculty_ID.setText(rs.getString("Faculty_Faculty_id"));
       
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
    PreparedStatement st = con.prepareStatement("SELECT * FROM Department", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    if(!bnext){
      rs = st.executeQuery();  
       rs.first();
   
       txtDepartment_ID.setText(rs.getString("Department_id")); 
       txtDepartment_Name.setText(rs.getString("Department_Name"));
       txtFaculty_ID.setText(rs.getString("Faculty_Faculty_id"));
       
       bnext = true;
    }
    else if(rs.next()){
        
        txtDepartment_ID.setText(rs.getString("Department_id")); 
       txtDepartment_Name.setText(rs.getString("Department_Name"));
       txtFaculty_ID.setText(rs.getString("Faculty_Faculty_id"));
      
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

    private void lastbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastbtnActionPerformed
        // TODO add your handling code here:
         try {
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    con = DriverManager.getConnection(cs,user,password);
    st = con.createStatement();
    PreparedStatement st = con.prepareStatement("SELECT * FROM Department", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = st.executeQuery();
    
    if(rs.last()){
       txtDepartment_ID.setText(rs.getString("Department_id")); 
       txtDepartment_Name.setText(rs.getString("Department_Name"));
       txtFaculty_ID.setText(rs.getString("Faculty_Faculty_id"));
      
    }
    else{
        JOptionPane.showMessageDialog(null,"Record not found");
        txtDepartment_ID.setText("");
        txtDepartment_ID.requestFocus();
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
    }//GEN-LAST:event_lastbtnActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        try {
   
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    con = DriverManager.getConnection(cs,user,password);
    st = con.createStatement();
    
    PreparedStatement st = con.prepareStatement("SELECT * FROM Department", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    
    if(!bprevious){
      rs = st.executeQuery();  
       rs.last();
   
       txtDepartment_ID.setText(rs.getString("Department_id")); 
       txtDepartment_Name.setText(rs.getString("Department_Name"));
       txtFaculty_ID.setText(rs.getString("Faculty_Faculty_id"));
       
       bprevious = true;
    }
    else if(rs.previous()){
        
        txtDepartment_ID.setText(rs.getString("Department_id")); 
       txtDepartment_Name.setText(rs.getString("Department_Name"));
       txtFaculty_ID.setText(rs.getString("Faculty_Faculty_id"));
      
     bnext = true;
      
    }
    
    
       
}
catch (SQLException ex){
    ex.printStackTrace();
}
catch (ClassNotFoundException e){
  e.printStackTrace();  
}

    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
         int answer = JOptionPane.showConfirmDialog(this,"Are you sure you want to delete?","confirm",JOptionPane.YES_NO_OPTION);
        
    if(answer == YES_OPTION){
     try {
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    con = DriverManager.getConnection(cs,user,password);
    st = con.createStatement();
    
    
    PreparedStatement st = con.prepareStatement("DELETE  FROM Department WHERE   Department_id ='"+txtDepartment_ID.getText()+"'", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    
     if(st.executeUpdate() == 1){
         JOptionPane.showMessageDialog(null,"Record with RegNo: '"+txtDepartment_ID.getText()+"'deleted");
         
     }
     else if(st.executeUpdate() == 0){
         JOptionPane.showMessageDialog(null,"Record with RegNo: '"+txtDepartment_ID.getText()+"'does not exist");
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
          txtDepartment_ID.requestFocus();
          return ;
      }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Main_page ma = new Main_page();
      ma.setVisible(true);
      this.setVisible(true);
        dispose();
       
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Department.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Department.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Department.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Department.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Department().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Findbtn;
    private javax.swing.JButton Savebtn;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton jButton1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JButton lastbtn;
    private javax.swing.JLabel lblDepartment_ID;
    private javax.swing.JLabel lblDepartment_Name;
    private javax.swing.JLabel lblFaculty_ID;
    private javax.swing.JTextField txtDepartment_ID;
    private javax.swing.JTextField txtDepartment_Name;
    private javax.swing.JTextField txtFaculty_ID;
    // End of variables declaration//GEN-END:variables
}
