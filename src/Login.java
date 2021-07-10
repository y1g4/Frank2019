
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
import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
public class Login extends javax.swing.JFrame {
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
   
    public Login() {
        initComponents();
         con = null;
    st = null;
    statement = null;
    
    cs = "jdbc:mysql://localhost:3306/admission";
    user = "root";
    password = "peacebewithyouall2020";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblusername = new javax.swing.JLabel();
        lblpassword = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        txtusername = new javax.swing.JTextField();
        btnlogin = new javax.swing.JButton();
        signupbtn = new javax.swing.JButton();
        checkpass = new javax.swing.JCheckBox();
        kGradientPanel1 = new keeptoo.KGradientPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(163, 161, 63));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblusername.setFont(new java.awt.Font("DejaVu Serif", 1, 24)); // NOI18N
        lblusername.setForeground(java.awt.Color.black);
        lblusername.setText("Username");
        getContentPane().add(lblusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 70, -1, 64));

        lblpassword.setFont(new java.awt.Font("DejaVu Serif", 1, 24)); // NOI18N
        lblpassword.setText("Password");
        getContentPane().add(lblpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 174, 140, 68));

        txtpassword.setFont(new java.awt.Font("DejaVu Serif", 0, 24)); // NOI18N
        getContentPane().add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 175, 219, 68));

        txtusername.setFont(new java.awt.Font("DejaVu Serif", 1, 24)); // NOI18N
        getContentPane().add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 219, 64));

        btnlogin.setFont(new java.awt.Font("DejaVu Serif", 1, 24)); // NOI18N
        btnlogin.setText("Login");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });
        getContentPane().add(btnlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 325, 125, 47));

        signupbtn.setFont(new java.awt.Font("DejaVu Serif", 1, 24)); // NOI18N
        signupbtn.setText("Sign up");
        signupbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupbtnActionPerformed(evt);
            }
        });
        getContentPane().add(signupbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 325, 137, 47));

        checkpass.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        checkpass.setText("Check Password");
        checkpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkpassActionPerformed(evt);
            }
        });
        getContentPane().add(checkpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 281, -1, -1));

        kGradientPanel1.setForeground(new java.awt.Color(24, 123, 240));
        kGradientPanel1.setkEndColor(java.awt.Color.white);
        kGradientPanel1.setkStartColor(java.awt.Color.blue);

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 390));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void signupbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupbtnActionPerformed
        // TODO add your handling code here:
String s1 =  txtusername.getText();
String s2 =  txtpassword.getText();


try {
    
    Class.forName("com.mysql.cj.jdbc.Driver");//register JDBC driver
    
    con = DriverManager.getConnection(cs,user,password);
    st = con.createStatement();
    query = "INSERT INTO Login (Username,Password) VALUES ('"+s1+"','"+s2+"')";
    st. executeUpdate(query);
    JOptionPane.showMessageDialog(null,"Sign up successfull\n You can now Login");
    
    txtusername.setText("");
    txtpassword.setText("");
    txtusername.requestFocus();  //setting focus on REGNO  
    
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
    }//GEN-LAST:event_signupbtnActionPerformed

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        // TODO add your handling code here:
        
        if(txtusername.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please insert  Username");
           txtusername.requestFocus();
            return;
        }
        if(txtpassword.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please insert  Password ");
            txtpassword.requestFocus();
            return;
        } 
        try{
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(cs,user,password);
                st = con.createStatement();
                PreparedStatement st = con.prepareStatement("SELECT * FROM Login WHERE   Username ='"+txtusername.getText()+"'  and "
                        + "Password ='"+txtpassword.getText()+"'", 
  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                //query = "select * from signup where RegNo = '"+txtusername.getText()+"'";
           //st.executeUpdate(query);
           //JOptionPane.showMessageDialog(null,"record saved");
           ResultSet rs = st.executeQuery();
           
           if(rs.first())
           {
               //rs.last
               
           
           
           
           
           txtusername.setText(rs.getString("Username"));
           
           txtpassword.setText(rs.getString("Password"));
           
           txtusername.requestFocus();
           
           dispose();
         // new Main_page().Main();
           
           

           }
           else{
               JOptionPane.showMessageDialog(null,"Wrong password");
                       txtusername.setText("");
                       txtusername.requestFocus();
           }

                }
                
                catch(SQLException ex){
                    ex.printStackTrace();
                
                }
                  catch(ClassNotFoundException e){
                    e.printStackTrace();
                
                }
                
                finally{
                
                try{
                if (st != null)
                {
                    st.close();
                }
                
                if (con !=null){
                    con.close();
                }
                
                }
                catch (SQLException ex){
                        ex.printStackTrace();
                        }
                }
                
    }//GEN-LAST:event_btnloginActionPerformed

    private void checkpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkpassActionPerformed
        // TODO add your handling code here:
        if(evt.getSource() == checkpass)
            if(checkpass.isSelected()){
              txtpassword.setEchoChar((char) 0);
            }
            else{
               txtpassword.setEchoChar('*');
            }
    }//GEN-LAST:event_checkpassActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlogin;
    private javax.swing.JCheckBox checkpass;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblpassword;
    private javax.swing.JLabel lblusername;
    private javax.swing.JButton signupbtn;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
