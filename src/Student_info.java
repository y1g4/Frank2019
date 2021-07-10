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
import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
public class Student_info extends javax.swing.JFrame {

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
  
  Student_info_SC SerialObj;
  
    public Student_info() {
        initComponents();
            con = null;
    st = null;
    statement = null;
    
    cs = "jdbc:mysql://localhost:3306/admission";
    user = "root";
    password = "peacebewithyouall2020";
    go();
    }

   public void go() {
        try{
            
            sock = new Socket("127.0.0.1",50000);
        SerialObj = new Student_info_SC();
        
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
       
    }
    }
   
   public class ClientRunnable implements Runnable{

        @Override
        public void run() {
            try{
                while((SerialObj =  (Student_info_SC)clientObjectStreamReader.readObject()) != null ){
                    
                   txtStudentID.setText(SerialObj.STID);
                    txtFormerSchool.setText(SerialObj.FS);
                    txtResults.setText(SerialObj.RES);
                    txtGender.setText(SerialObj.GEN);
                    
                    
                    
                    
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

        lblStudentID = new javax.swing.JLabel();
        lblFormerSchool = new javax.swing.JLabel();
        lblResults = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        txtStudentID = new javax.swing.JTextField();
        txtFormerSchool = new javax.swing.JTextField();
        txtResults = new javax.swing.JTextField();
        firstbtn = new javax.swing.JButton();
        nextbtn = new javax.swing.JButton();
        lastbtn = new javax.swing.JButton();
        previewbtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        lblgender = new javax.swing.JLabel();
        txtGender = new javax.swing.JTextField();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.blue);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblStudentID.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        lblStudentID.setText("Student ID");
        getContentPane().add(lblStudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 12, 148, 53));

        lblFormerSchool.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        lblFormerSchool.setText("Former School");
        getContentPane().add(lblFormerSchool, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 112, -1, 59));

        lblResults.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        lblResults.setText("Results");
        getContentPane().add(lblResults, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 226, 148, 57));

        btnSave.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 384, 75, 47));

        btnFind.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });
        getContentPane().add(btnFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 384, 84, 47));

        txtStudentID.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        txtStudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentIDActionPerformed(evt);
            }
        });
        getContentPane().add(txtStudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 12, 366, 53));

        txtFormerSchool.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        getContentPane().add(txtFormerSchool, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 112, 366, 59));

        txtResults.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        txtResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtResultsActionPerformed(evt);
            }
        });
        getContentPane().add(txtResults, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 226, 366, 57));

        firstbtn.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        firstbtn.setText("First");
        firstbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstbtnActionPerformed(evt);
            }
        });
        getContentPane().add(firstbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 384, 77, 47));

        nextbtn.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        nextbtn.setText("Next");
        nextbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextbtnActionPerformed(evt);
            }
        });
        getContentPane().add(nextbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 384, 82, 47));

        lastbtn.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        lastbtn.setText("Last");
        lastbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastbtnActionPerformed(evt);
            }
        });
        getContentPane().add(lastbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 384, 95, 47));

        previewbtn.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        previewbtn.setText("Preview");
        previewbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewbtnActionPerformed(evt);
            }
        });
        getContentPane().add(previewbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 384, -1, 47));

        deletebtn.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });
        getContentPane().add(deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, 100, 47));

        lblgender.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        lblgender.setText("Gender");
        getContentPane().add(lblgender, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 317, 148, 49));

        txtGender.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        getContentPane().add(txtGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 366, 58));

        kGradientPanel2.setkEndColor(java.awt.Color.white);
        kGradientPanel2.setkStartColor(java.awt.Color.blue);

        jButton1.setText("B");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 670, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 422, Short.MAX_VALUE))
        );

        getContentPane().add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtResultsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtResultsActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
              String s1 =  txtStudentID.getText();
String s2 =  txtFormerSchool.getText();
String s3 =  txtResults.getText();
String s4 =  txtGender.getText();

try {
    
    Class.forName("com.mysql.cj.jdbc.Driver");//register JDBC driver
    
    con = DriverManager.getConnection(cs,user,password);
    st = con.createStatement();
    query = "INSERT INTO Student_info (Student_id,Former_School,Results,Gender) VALUES ('"+s1+"','"+s2+"','"+s3+"','"+s4+"')";
    st. executeUpdate(query);
    JOptionPane.showMessageDialog(null,"Record saved successfully");
    
    txtStudentID.setText("");
    txtFormerSchool.setText("");
     txtResults.setText("");
     txtGender.setText("");
     
     txtStudentID.requestFocus();  //setting focus on REGNO   
}
catch (SQLException ex){
    ex.printStackTrace();//displays information about SQL statement incase you typed table name or field name that is not existing
    //it displays where the error may be
}
catch (ClassNotFoundException e){
  e.printStackTrace();  //checks if the driver  is not configured
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
        

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
         try {
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    con = DriverManager.getConnection(cs,user,password);
    
    
     PreparedStatement st = con.prepareStatement("SELECT * FROM Student_info WHERE   Student_id ='"+txtStudentID.getText()+"'", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = st.executeQuery();
    
    if(rs.first()){
       txtStudentID.setText(rs.getString("Student_id")); 
       txtFormerSchool.setText(rs.getString("Former_School"));
       txtResults.setText(rs.getString("Results"));
       txtGender.setText(rs.getString("Gender"));
      
    }
    else{
        JOptionPane.showMessageDialog(null,"Record not found");
         txtStudentID.setText("");
         txtStudentID.requestFocus();
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

    }//GEN-LAST:event_btnFindActionPerformed

    private void firstbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstbtnActionPerformed
        // TODO add your handling code here:
         try {
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    con = DriverManager.getConnection(cs,user,password);
    st = con.createStatement();
    //query = "SELECT * FROM students ";
    //st. executeUpdate(query);
    //JOptionPane.showMessageDialog(null,"Record saved");
    PreparedStatement st = con.prepareStatement("SELECT * FROM Student_info", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = st.executeQuery();
    
    
    
    if(rs.first()){
       txtStudentID.setText(rs.getString("Student_id")); 
       txtFormerSchool.setText(rs.getString("Former_School"));
       txtResults.setText(rs.getString("Results"));
       txtGender.setText(rs.getString("Gender"));
       
    }
    else{
        JOptionPane.showMessageDialog(null,"Record not found");
        txtStudentID.setText("");
        txtStudentID.requestFocus();
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
    }//GEN-LAST:event_firstbtnActionPerformed

    private void nextbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextbtnActionPerformed
        // TODO add your handling code here:
         try {
   
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    con = DriverManager.getConnection(cs,user,password);
    st = con.createStatement();
    PreparedStatement st = con.prepareStatement("SELECT * FROM Student_info", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    if(!bnext){
      rs = st.executeQuery();  
       rs.first();
   
       txtStudentID.setText(rs.getString("Student_id")); 
       txtFormerSchool.setText(rs.getString("Former_School"));
       txtResults.setText(rs.getString("Results"));
       txtGender.setText(rs.getString("Gender"));
       bnext = true;
    }
    else if(rs.next()){
        
       txtStudentID.setText(rs.getString("Student_id")); 
       txtFormerSchool.setText(rs.getString("Former_School"));
       txtResults.setText(rs.getString("Results"));
       txtGender.setText(rs.getString("Gender"));
     bnext = true;
      
    }
    
    
       
}
catch (SQLException ex){
    ex.printStackTrace();
}
catch (ClassNotFoundException e){
  e.printStackTrace();  
}
    }//GEN-LAST:event_nextbtnActionPerformed

    private void lastbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastbtnActionPerformed
        // TODO add your handling code here:
        try {
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    con = DriverManager.getConnection(cs,user,password);
    st = con.createStatement();
    PreparedStatement st = con.prepareStatement("SELECT * FROM Student_info", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = st.executeQuery();
    
    if(rs.last()){
       txtStudentID.setText(rs.getString("Student_id")); 
       txtFormerSchool.setText(rs.getString("Former_School"));
       txtResults.setText(rs.getString("Results"));
       txtGender.setText(rs.getString("Gender"));
       
    }
    else{
        JOptionPane.showMessageDialog(null,"Record not found");
        txtStudentID.setText("");
        txtStudentID.requestFocus();
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

    private void previewbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewbtnActionPerformed
        // TODO add your handling code here:
        try {
   
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    con = DriverManager.getConnection(cs,user,password);
    st = con.createStatement();
    
    PreparedStatement st = con.prepareStatement("SELECT * FROM Student_info", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    
    if(!bprevious){
      rs = st.executeQuery();  
       rs.last();
   
       txtStudentID.setText(rs.getString("Student_id")); 
       txtFormerSchool.setText(rs.getString("Former_School"));
       txtResults.setText(rs.getString("Results"));
       txtGender.setText(rs.getString("Gender"));
       
       bprevious = true;
    }
    else if(rs.previous()){
        
        txtStudentID.setText(rs.getString("Student_id")); 
       txtFormerSchool.setText(rs.getString("Former_School"));
       txtResults.setText(rs.getString("Results"));
       txtGender.setText(rs.getString("Gender"));
       
       
     bnext = true;
      
    }
    
    
       
}
catch (SQLException ex){
    ex.printStackTrace();
}
catch (ClassNotFoundException e){
  e.printStackTrace();  
}

    }//GEN-LAST:event_previewbtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        // TODO add your handling code here:
        int answer = JOptionPane.showConfirmDialog(this,"Are you sure you want to delete?","confirm",JOptionPane.YES_NO_OPTION);
        
    if(answer == YES_OPTION){
     try {
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    con = DriverManager.getConnection(cs,user,password);
    st = con.createStatement();
    
    
    PreparedStatement st = con.prepareStatement("DELETE  FROM Student_info WHERE   Student_id ='"+txtStudentID.getText()+"'", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    
     if(st.executeUpdate() == 1){
         JOptionPane.showMessageDialog(null,"Record with RegNo: '"+txtStudentID.getText()+"'deleted");
         
     }
     else if(st.executeUpdate() == 0){
         JOptionPane.showMessageDialog(null,"Record with RegNo: '"+txtStudentID.getText()+"'does not exist");
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
          txtStudentID.requestFocus();
          return ;
      }
    }//GEN-LAST:event_deletebtnActionPerformed

    private void txtStudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentIDActionPerformed

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
            java.util.logging.Logger.getLogger(Student_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_info().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton firstbtn;
    private javax.swing.JButton jButton1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JButton lastbtn;
    private javax.swing.JLabel lblFormerSchool;
    private javax.swing.JLabel lblResults;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JLabel lblgender;
    private javax.swing.JButton nextbtn;
    private javax.swing.JButton previewbtn;
    private javax.swing.JTextField txtFormerSchool;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtResults;
    private javax.swing.JTextField txtStudentID;
    // End of variables declaration//GEN-END:variables
}
