
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import java.awt.Desktop;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.NO_OPTION;


import static javax.swing.JOptionPane.YES_OPTION;public class Reports extends javax.swing.JFrame {

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
  
  ArrayList<String> basicSql,colName;
    String genderChoice;
    int age;
    String ageLimit;
    
    public Reports() {
        initComponents();
         con = null;
    st = null;
    statement = null;
    
    cs = "jdbc:mysql://localhost:3306/admission";
    user = "root";
    password = "peacebewithyouall2020";
    
    
    basicSql = new ArrayList<String>();
    colName = new ArrayList<String>();
        
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bxGender = new javax.swing.JComboBox();
        REPORTBTN = new javax.swing.JButton();
        checkRegNo = new javax.swing.JCheckBox();
        checkFname = new javax.swing.JCheckBox();
        checkLName = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bxGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        bxGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bxGenderActionPerformed(evt);
            }
        });

        REPORTBTN.setText("REPORT");
        REPORTBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REPORTBTNActionPerformed(evt);
            }
        });

        checkRegNo.setText("Reg No");

        checkFname.setText("First Name");

        checkLName.setText("Last Name");

        jLabel1.setText("Gender");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(REPORTBTN)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkLName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bxGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkRegNo)
                    .addComponent(checkFname))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(checkRegNo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkFname)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bxGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(88, 88, 88))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkLName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(REPORTBTN)
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bxGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bxGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bxGenderActionPerformed

    private void REPORTBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REPORTBTNActionPerformed
        // TODO add your handling code here:
        
        try{
            if(checkRegNo.isSelected()||checkFname.isSelected()||checkLName.isSelected()){
            
                String base = "select ";
                
                
                if(checkRegNo.isSelected()){
            basicSql.add("Reg_no");
            colName.add("REG NO");
        }
                
        if(checkFname.isSelected()){
            basicSql.add("First_Name");
            colName.add("FIRST NAME");
        }
        if(checkLName.isSelected()){
            basicSql.add("Last_Name");
            colName.add("LAST NAME");
        }
        
        genderChoice = (String) bxGender.getSelectedItem();
        
         String subsql = "select ";
         
         for(String item : basicSql){
                    //System.out.print(item + ",");
                    subsql = subsql.concat(item + ",");
                    
                }
         String operator = "";
         
         subsql = subsql.substring(0, subsql.length()-1) + " from STUDENTS"  ;
         
         String lastsql =  subsql + " where Gender = '"+genderChoice+"'"+";";
         
         System.out.println(lastsql);
         
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");//registers the jdbc Driver
            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        String RESULT = "Students.pdf";

        Document document = new Document(PageSize.A5.rotate());
        try {
            PdfWriter.getInstance(document, new FileOutputStream(RESULT));//Need to write in a table
        } catch (DocumentException ex) {

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }

        document.open();

        Image img = null;
        try {
            img = Image.getInstance("/home/frank/Pictures/UN.png");
        } catch (BadElementException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        img.scaleToFit(500, 100);
        try {
            document.add(img);
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            document.add(new Paragraph("    UNDERGRADUATE PRIVATE ADMISSIONS 2019/2020 \n", FontFactory.getFont(FontFactory.TIMES_BOLD, 20)));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
                       
          
        try {
            document.add(new Paragraph("     "));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        PdfPTable table = new PdfPTable(basicSql.size());//create table with 2 columns
        table.setWidthPercentage(110);
        
            query = lastsql;
            rs = st.executeQuery(query);
        
         for(int j = 0;j<=colName.size()-1;j++){
                  table.addCell(colName.get(j));
                }
                
                
                    while(rs.next()){
                        
                        for(int i=0;i<=basicSql.size()-1;i++){
                            table.addCell(rs.getString(basicSql.get(i)));
                            
                        }
                    }
                        
                    
                        
                        //rs = st.executeQuery();
                        
                        
                        
                        
                        try {
                            document.add(table);
                        } catch (DocumentException ex) {
                            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        /////////////////////////////
                        
                        DateFormat df = new SimpleDateFormat("dd/MM/yy");
                        Calendar calobj = Calendar.getInstance();
                        String cal1 = df.format(calobj.getTime()).toString();
                        
                        
                        Chunk glue1 = new Chunk(new VerticalPositionMark());
                        Paragraph ptot1 = new Paragraph("Generated by: Yiga Frank",
                                FontFactory.getFont(FontFactory.TIMES_BOLD, 15, Font.ITALIC,
                                        BaseColor.BLACK));
                        ptot1.add(new Chunk(glue1));
                        ptot1.add("Issued on: " + cal1 + "");
                        try {
                            document.add(ptot1);
                        } catch (DocumentException ex) {
                            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (Desktop.isDesktopSupported()) {
                            
                            try {
                                Runtime.getRuntime().exec("evince " + "Students.pdf");
                            } catch (IOException ex) {
                                Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }
                        document.close();//close a pdf document
 
                    
        
        
        }
            else{
            JOptionPane.showMessageDialog(null, "Select some Items to generate Report","Important Message",JOptionPane.WARNING_MESSAGE);
        
            }
            }
                
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Select some Items to generate Report","Important Message",JOptionPane.WARNING_MESSAGE);
        
        }
        
        
    }//GEN-LAST:event_REPORTBTNActionPerformed
                 
        ////////////////////
        
    
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
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton REPORTBTN;
    private javax.swing.JComboBox bxGender;
    private javax.swing.JCheckBox checkFname;
    private javax.swing.JCheckBox checkLName;
    private javax.swing.JCheckBox checkRegNo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
