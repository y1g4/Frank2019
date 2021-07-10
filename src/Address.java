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
import java.lang.NullPointerException;
import java.net.Socket;
import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;


public class Address extends javax.swing.JFrame {

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
  
  Address_SC SerialObj;
  
    public Address() {
        initComponents();
        go();
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
        SerialObj = new Address_SC();
        
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
                while((SerialObj =  (Address_SC)clientObjectStreamReader.readObject()) != null ){
                    
                   txtAddressID.setText(SerialObj.ADID);
                    txtDistrict.setText(SerialObj.DIS);
                    
                    
                    
                    
                    
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

        lblAddress_ID = new javax.swing.JLabel();
        lblDistrict = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        Nextbtn = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        lastbtn = new javax.swing.JButton();
        txtAddressID = new javax.swing.JTextField();
        Deletebtn = new javax.swing.JButton();
        txtDistrict = new javax.swing.JTextField();
        btnfirst = new javax.swing.JButton();
        previewbtn = new javax.swing.JButton();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAddress_ID.setFont(new java.awt.Font("DejaVu Serif", 1, 24)); // NOI18N
        lblAddress_ID.setText("Address ID");
        getContentPane().add(lblAddress_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 49, -1, 65));

        lblDistrict.setFont(new java.awt.Font("DejaVu Serif", 1, 24)); // NOI18N
        lblDistrict.setText("District");
        getContentPane().add(lblDistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 166, 119, 67));

        btnSave.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 308, 85, 47));

        Nextbtn.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        Nextbtn.setText("Next");
        Nextbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextbtnActionPerformed(evt);
            }
        });
        getContentPane().add(Nextbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 308, 91, 47));

        btnFind.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });
        getContentPane().add(btnFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 308, 74, 47));

        lastbtn.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        lastbtn.setText("Last");
        lastbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastbtnActionPerformed(evt);
            }
        });
        getContentPane().add(lastbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 308, 102, 47));

        txtAddressID.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        txtAddressID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressIDActionPerformed(evt);
            }
        });
        getContentPane().add(txtAddressID, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 49, 360, 65));

        Deletebtn.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        Deletebtn.setText("Delete");
        Deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletebtnActionPerformed(evt);
            }
        });
        getContentPane().add(Deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 308, -1, 47));

        txtDistrict.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        txtDistrict.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDistrictActionPerformed(evt);
            }
        });
        getContentPane().add(txtDistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 166, 360, 67));

        btnfirst.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        btnfirst.setText("First");
        btnfirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfirstActionPerformed(evt);
            }
        });
        getContentPane().add(btnfirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 308, 83, 47));

        previewbtn.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        previewbtn.setText("Preview");
        previewbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewbtnActionPerformed(evt);
            }
        });
        getContentPane().add(previewbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 308, 114, 47));

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
                .addGap(0, 650, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 352, Short.MAX_VALUE))
        );

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 380));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtAddressIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressIDActionPerformed

    private void txtDistrictActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDistrictActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDistrictActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
     
         
        String s2 =  txtAddressID.getText();
String s3 =  txtDistrict.getText();

try {
    
    Class.forName("com.cj.mysql.jdbc.Driver");//register JDBC driver
    
    con = DriverManager.getConnection(cs,user,password);
    st = con.createStatement();
    query = "INSERT INTO Address (Address_id, District) VALUES ('"+s2+"','"+s3+"')";
    st. executeUpdate(query);
    JOptionPane.showMessageDialog(null,"Record saved successfully");
    
   
     txtAddressID.setText("");
     txtDistrict.setText("");
   
     
    txtAddressID.requestFocus();  //setting focus on REGNO   
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

    private void NextbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextbtnActionPerformed
        // TODO add your handling code here:
        try {
   
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    con = DriverManager.getConnection(cs,user,password);
    st = con.createStatement();
    PreparedStatement st = con.prepareStatement("SELECT * FROM Address", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    if(!bnext){
      rs = st.executeQuery();  
       rs.first();
   
       txtAddressID.setText(rs.getString("Address_id")); 
       txtDistrict.setText(rs.getString("District"));
       
       
       bnext = true;
    }
    else if(rs.next()){
        
        txtAddressID.setText(rs.getString("Address_id")); 
       txtDistrict.setText(rs.getString("District"));
       
      
     bnext = true;
      
    }
    
    
       
}
catch (SQLException ex){
    ex.printStackTrace();
}
catch (ClassNotFoundException e){
  e.printStackTrace();  
}

    }//GEN-LAST:event_NextbtnActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
         try {
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    con = DriverManager.getConnection(cs,user,password);
    
    
     PreparedStatement st = con.prepareStatement("SELECT * FROM Address WHERE   Address_id ='"+txtAddressID.getText()+"'", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = st.executeQuery();
    
    if(rs.first()){
       txtAddressID.setText(rs.getString("Address_id")); 
       txtDistrict.setText(rs.getString("District"));
       
       
    }
    else{
        JOptionPane.showMessageDialog(null,"Record not found");
         txtAddressID.setText("");
         txtAddressID.requestFocus();
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

    private void btnfirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfirstActionPerformed
        // TODO add your handling code here:
        try {
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    con = DriverManager.getConnection(cs,user,password);
    st = con.createStatement();
    //query = "SELECT * FROM students ";
    //st. executeUpdate(query);
    //JOptionPane.showMessageDialog(null,"Record saved");
    PreparedStatement st = con.prepareStatement("SELECT * FROM Address", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = st.executeQuery();
    
    
    
    if(rs.first()){
       txtAddressID.setText(rs.getString("Address_id")); 
       txtDistrict.setText(rs.getString("District"));
       
    }
    else{
        JOptionPane.showMessageDialog(null,"Record not found");
         txtAddressID.setText("");
        txtAddressID.requestFocus();
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
    }//GEN-LAST:event_btnfirstActionPerformed

    private void lastbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastbtnActionPerformed
        // TODO add your handling code here:
        try {
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    con = DriverManager.getConnection(cs,user,password);
    st = con.createStatement();
    PreparedStatement st = con.prepareStatement("SELECT * FROM Address", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = st.executeQuery();
    
    if(rs.last()){
       txtAddressID.setText(rs.getString("Address_id")); 
       txtDistrict.setText(rs.getString("District"));
      
    }
    else{
        JOptionPane.showMessageDialog(null,"Record not found");
        txtAddressID.setText("");
        txtAddressID.requestFocus();
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
    
    PreparedStatement st = con.prepareStatement("SELECT * FROM Address", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    
    if(!bprevious){
      rs = st.executeQuery();  
       rs.last();
   
      txtAddressID.setText(rs.getString("Address_id")); 
       txtDistrict.setText(rs.getString("District"));
       
       bprevious = true;
    }
    else if(rs.previous()){
        
        txtAddressID.setText(rs.getString("Address_id")); 
       txtDistrict.setText(rs.getString("District"));
      
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

    private void DeletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletebtnActionPerformed
        // TODO add your handling code here:
         int answer = JOptionPane.showConfirmDialog(this,"Are you sure you want to delete?","confirm",JOptionPane.YES_NO_OPTION);
        
    if(answer == YES_OPTION){
     try {
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    con = DriverManager.getConnection(cs,user,password);
    st = con.createStatement();
    
    
    PreparedStatement st = con.prepareStatement("DELETE  FROM Address WHERE   Address_id ='"+txtAddressID.getText()+"'", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    
     if(st.executeUpdate() == 1){
         JOptionPane.showMessageDialog(null,"Record with RegNo: '"+txtAddressID.getText()+"'deleted");
         
     }
     else if(st.executeUpdate() == 0){
         JOptionPane.showMessageDialog(null,"Record with RegNo: '"+txtAddressID.getText()+"'does not exist");
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
          txtAddressID.requestFocus();
          return ;
      }
    }//GEN-LAST:event_DeletebtnActionPerformed

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
            java.util.logging.Logger.getLogger(Address.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Address.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Address.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Address.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Address().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Deletebtn;
    private javax.swing.JButton Nextbtn;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnfirst;
    private javax.swing.JButton jButton1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JButton lastbtn;
    private javax.swing.JLabel lblAddress_ID;
    private javax.swing.JLabel lblDistrict;
    private javax.swing.JButton previewbtn;
    private javax.swing.JTextField txtAddressID;
    private javax.swing.JTextField txtDistrict;
    // End of variables declaration//GEN-END:variables
}
