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

public class Student extends javax.swing.JFrame {
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
  
  Student_SC SerialObj;
    
    public Student() {
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
        SerialObj = new Student_SC();
        
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
                while((SerialObj =  (Student_SC)clientObjectStreamReader.readObject()) != null ){
                    
                   txtRegno.setText(SerialObj.regno);
                    txtFirstName.setText(SerialObj.Fname);
                    txtLastName.setText(SerialObj.Lname);
                    txtStudentID.setText(SerialObj.SID);
                    txtAddressID.setText(SerialObj.AID);
                    txtProgramID.setText(SerialObj.PID);
                    
                    
                    
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

        lblRegno = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        txtRegno = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        lblLastName = new javax.swing.JLabel();
        lblStudentID = new javax.swing.JLabel();
        lblAddressID = new javax.swing.JLabel();
        txtStudentID = new javax.swing.JTextField();
        lbProgramID = new javax.swing.JLabel();
        txtAddressID = new javax.swing.JTextField();
        txtProgramID = new javax.swing.JTextField();
        btnFirst = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(73, 73, 191));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRegno.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        lblRegno.setText("Reg no");
        getContentPane().add(lblRegno, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 80, 40));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 91, -1, -1));

        lblFirstName.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        lblFirstName.setText("First Name");
        getContentPane().add(lblFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, 40));

        btnSave.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        btnSave.setForeground(java.awt.Color.black);
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 80, 40));

        btnFind.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });
        getContentPane().add(btnFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 80, 40));

        txtRegno.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        getContentPane().add(txtRegno, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 12, 420, 50));

        txtFirstName.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 420, 50));

        txtLastName.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        txtLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 420, 50));

        lblLastName.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        lblLastName.setText("Last Name");
        getContentPane().add(lblLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, 40));

        lblStudentID.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        lblStudentID.setText("Student ID");
        getContentPane().add(lblStudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, 40));

        lblAddressID.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        lblAddressID.setText("Address ID");
        getContentPane().add(lblAddressID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, 40));

        txtStudentID.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        txtStudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentIDActionPerformed(evt);
            }
        });
        getContentPane().add(txtStudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 420, 50));

        lbProgramID.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        lbProgramID.setText("Program ID");
        getContentPane().add(lbProgramID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, 40));

        txtAddressID.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        txtAddressID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressIDActionPerformed(evt);
            }
        });
        getContentPane().add(txtAddressID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 420, 50));

        txtProgramID.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        getContentPane().add(txtProgramID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 335, 420, 50));

        btnFirst.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });
        getContentPane().add(btnFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 90, 40));

        btnLast.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });
        getContentPane().add(btnLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, 90, 40));

        btnNext.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        getContentPane().add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, 80, 40));

        btnPrevious.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        btnPrevious.setText("Preview");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });
        getContentPane().add(btnPrevious, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 400, 110, 40));

        btnDelete.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, 100, 40));

        kGradientPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
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
                .addGap(0, 624, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 424, Short.MAX_VALUE))
        );

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
              String s1 =  txtRegno.getText();
String s2 =  txtFirstName.getText();
String s3 =  txtLastName.getText();
String s4 =  txtStudentID.getText();
String s5 =  txtAddressID.getText();
String s6 =  txtProgramID.getText();
try {
    
    Class.forName("com.mysql.cj.jdbc.Driver");//register JDBC driver
    
    con = DriverManager.getConnection(cs,user,password);
    st = con.createStatement();
    query = "INSERT INTO Student (Reg_No,First_Name,Last_Name,Student_info_Student_id,Address_Address_id,Program_Program_id) VALUES ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"')";
    st. executeUpdate(query);
    JOptionPane.showMessageDialog(null,"Record saved successfully");
    
    txtRegno.setText("");
     txtFirstName.setText("");
     txtLastName.setText("");
     txtStudentID.setText("");
     txtAddressID.setText("");
     txtProgramID.setText("");
   
     
     txtRegno.requestFocus();  //setting focus on REGNO   
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
    
    
     PreparedStatement st = con.prepareStatement("SELECT * FROM Student WHERE   Reg_no ='"+txtRegno.getText()+"'", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = st.executeQuery();
    
    if(rs.first()){
       txtRegno.setText(rs.getString("Reg_no")); 
       txtFirstName.setText(rs.getString("First_Name"));
       txtLastName.setText(rs.getString("Last_Name"));
       txtStudentID.setText(rs.getString("Student_info_Student_id"));
       txtAddressID.setText(rs.getString("Address_Address_id"));
       txtProgramID.setText(rs.getString("Program_Program_id"));
    }
    else{
        JOptionPane.showMessageDialog(null,"Record not found");
         txtRegno.setText("");
         txtRegno.requestFocus();
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

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        try {
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    con = DriverManager.getConnection(cs,user,password);
    st = con.createStatement();
    //query = "SELECT * FROM students ";
    //st. executeUpdate(query);
    //JOptionPane.showMessageDialog(null,"Record saved");
    PreparedStatement st = con.prepareStatement("SELECT * FROM Student", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = st.executeQuery();
    
    
    
    if(rs.first()){
       txtRegno.setText(rs.getString("Reg_no")); 
       txtFirstName.setText(rs.getString("First_Name"));
       txtLastName.setText(rs.getString("Last_Name"));
       txtStudentID.setText(rs.getString("Student_info_Student_id"));
       txtAddressID.setText(rs.getString("Address_Address_id"));
       txtProgramID.setText(rs.getString("Program_Program_id"));
    }
    else{
        JOptionPane.showMessageDialog(null,"Record not found");
        txtRegno.setText("");
        txtRegno.requestFocus();
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

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
         try {
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    con = DriverManager.getConnection(cs,user,password);
    st = con.createStatement();
    PreparedStatement st = con.prepareStatement("SELECT * FROM Student", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = st.executeQuery();
    
    if(rs.last()){
       txtRegno.setText(rs.getString("Reg_no")); 
       txtFirstName.setText(rs.getString("First_Name"));
       txtLastName.setText(rs.getString("Last_Name"));
       txtStudentID.setText(rs.getString("Student_info_Student_id"));
       txtAddressID.setText(rs.getString("Address_Address_id"));
       txtProgramID.setText(rs.getString("Program_Program_id"));
    }
    else{
        JOptionPane.showMessageDialog(null,"Record not found");
        txtRegno.setText("");
        txtRegno.requestFocus();
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

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        try {
   
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    con = DriverManager.getConnection(cs,user,password);
    st = con.createStatement();
    PreparedStatement st = con.prepareStatement("SELECT * FROM Student", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    if(!bnext){
      rs = st.executeQuery();  
       rs.first();
   
       txtRegno.setText(rs.getString("Reg_no")); 
       txtFirstName.setText(rs.getString("First_Name"));
       txtLastName.setText(rs.getString("Last_Name"));
       txtStudentID.setText(rs.getString("Student_info_Student_id"));
       txtAddressID.setText(rs.getString("Address_Address_id"));
       txtProgramID.setText(rs.getString("Program_Program_id"));
       bnext = true;
    }
    else if(rs.next()){
        
        txtRegno.setText(rs.getString("Reg_no")); 
       txtFirstName.setText(rs.getString("First_Name"));
       txtLastName.setText(rs.getString("Last_Name"));
       txtStudentID.setText(rs.getString("Student_info_Student_id"));
       txtAddressID.setText(rs.getString("Address_Address_id"));
       txtProgramID.setText(rs.getString("Program_Program_id"));
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

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        try {
   
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    con = DriverManager.getConnection(cs,user,password);
    st = con.createStatement();
    
    PreparedStatement st = con.prepareStatement("SELECT * FROM Student", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    
    if(!bprevious){
      rs = st.executeQuery();  
       rs.last();
   
       txtRegno.setText(rs.getString("Reg_no")); 
       txtFirstName.setText(rs.getString("First_Name"));
       txtLastName.setText(rs.getString("Last_Name"));
       txtStudentID.setText(rs.getString("Student_info_Student_id"));
       txtAddressID.setText(rs.getString("Address_Address_id"));
       txtProgramID.setText(rs.getString("Program_Program_id"));
       bprevious = true;
    }
    else if(rs.previous()){
        
        txtRegno.setText(rs.getString("Reg_no")); 
       txtFirstName.setText(rs.getString("First_Name"));
       txtLastName.setText(rs.getString("Last_Name"));
       txtStudentID.setText(rs.getString("Student_info_Student_id"));
       txtAddressID.setText(rs.getString("Address_Address_id"));
       txtProgramID.setText(rs.getString("Program_Program_id"));
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
    
    
    PreparedStatement st = con.prepareStatement("DELETE  FROM Student WHERE   Reg_no ='"+txtRegno.getText()+"'", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    
     if(st.executeUpdate() == 1){
         JOptionPane.showMessageDialog(null,"Record with RegNo: '"+txtRegno.getText()+"'deleted");
         
     }
     else if(st.executeUpdate() == 0){
         JOptionPane.showMessageDialog(null,"Record with RegNo: '"+txtRegno.getText()+"'does not exist");
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
          txtRegno.requestFocus();
          return ;
      }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtStudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentIDActionPerformed

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastNameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      Main_page ma = new Main_page();
      ma.setVisible(true);
      this.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtAddressIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressIDActionPerformed

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
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lbProgramID;
    private javax.swing.JLabel lblAddressID;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblRegno;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JTextField txtAddressID;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtProgramID;
    private javax.swing.JTextField txtRegno;
    private javax.swing.JTextField txtStudentID;
    // End of variables declaration//GEN-END:variables
}
