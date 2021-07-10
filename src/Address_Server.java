

import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
public class Address_Server extends javax.swing.JFrame {

    /**
     * Creates new form Address_Server
     */
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
  
  Address_SC SerialObj;
  
    public Address_Server() {
        initComponents();
        
         
        con = null;
    st = null;
    statement = null;
    
    cs = "jdbc:mysql://localhost:3306/admission";
    user = "root";
    password = "peacebewithyouall2020";
    
    serverObjectStreamWriter = null;
        serverObjectStreamReader = null;
        serverSock = null;
        clientSocket = null;
        SerialObj = null;
    go();
    }
    
    public void go(){
       try{
           serverSock = new ServerSocket(50000);
           SerialObj= new Address_SC();
           
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
                while((SerialObj =  (Address_SC)serverObjectStreamReader.readObject()) != null){
                     txtAddressID.setText(SerialObj.ADID);
                     txtDistrict.setText(SerialObj.DIS);
                    
                     
                     
                     go();
                }
            }
             catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
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

        lblAddress_ID = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        txtAddressID = new javax.swing.JTextField();
        txtDistrict = new javax.swing.JTextField();
        btnPreview = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblAddress_ID.setText("Address ID");

        jLabel2.setText("District");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnFind.setText("Find");

        btnFirst.setText("First");

        btnNext.setText("Next");

        btnLast.setText("Last");

        txtAddressID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressIDActionPerformed(evt);
            }
        });

        btnPreview.setText("Preview");

        btnDelete.setText("Delete");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAddress_ID)
                                .addGap(84, 84, 84)
                                .addComponent(txtAddressID, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFind)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFirst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext)
                        .addGap(18, 18, 18)
                        .addComponent(btnLast)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPreview)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(btnDelete)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAddress_ID)
                        .addGap(84, 84, 84))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtAddressID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnFind)
                    .addComponent(btnFirst)
                    .addComponent(btnNext)
                    .addComponent(btnLast)
                    .addComponent(btnPreview)
                    .addComponent(btnDelete))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAddressIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressIDActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        
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
            java.util.logging.Logger.getLogger(Address_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Address_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Address_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Address_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Address_Server().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPreview;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblAddress_ID;
    private javax.swing.JTextField txtAddressID;
    private javax.swing.JTextField txtDistrict;
    // End of variables declaration//GEN-END:variables
}