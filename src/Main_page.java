
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import java.awt.Desktop;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main_page extends javax.swing.JFrame {

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

    public Main_page() {
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

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        PROGRAM = new javax.swing.JMenuItem();
        studentinfomenu = new javax.swing.JMenu();
        reportFaculty = new javax.swing.JMenuItem();
        studentreport = new javax.swing.JMenuItem();
        menudepartment = new javax.swing.JMenuItem();
        menuprogram = new javax.swing.JMenuItem();
        infomenu = new javax.swing.JMenuItem();
        addressmenu = new javax.swing.JMenuItem();
        students = new javax.swing.JMenu();
        menucompscie = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        malemenu = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(33, 111, 246));
        setForeground(java.awt.Color.blue);

        kGradientPanel1.setkEndColor(java.awt.Color.white);
        kGradientPanel1.setkStartColor(java.awt.Color.blue);

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(java.awt.Color.black);
        jMenuBar1.setForeground(java.awt.Color.red);

        jMenu1.setText("File");
        jMenu1.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N

        jMenuItem6.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        jMenuItem6.setText("ADMITTED STUDENTS");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem7.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        jMenuItem7.setText("ADDRESS");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem8.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        jMenuItem8.setText("STUDENT INFO");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuItem9.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        jMenuItem9.setText("DEPARTMENT");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jMenuItem10.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        jMenuItem10.setText("FACULTY");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        PROGRAM.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        PROGRAM.setText("PROGRAM");
        PROGRAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PROGRAMActionPerformed(evt);
            }
        });
        jMenu1.add(PROGRAM);

        jMenuBar1.add(jMenu1);

        studentinfomenu.setBackground(java.awt.Color.blue);
        studentinfomenu.setText("Report");
        studentinfomenu.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N

        reportFaculty.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        reportFaculty.setText("FACULTY");
        reportFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportFacultyActionPerformed(evt);
            }
        });
        studentinfomenu.add(reportFaculty);

        studentreport.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        studentreport.setText("ADMITTED STUDENTS");
        studentreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentreportActionPerformed(evt);
            }
        });
        studentinfomenu.add(studentreport);

        menudepartment.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        menudepartment.setText("DEPARTMENT");
        menudepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menudepartmentActionPerformed(evt);
            }
        });
        studentinfomenu.add(menudepartment);

        menuprogram.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        menuprogram.setText("PROGRAM");
        menuprogram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuprogramActionPerformed(evt);
            }
        });
        studentinfomenu.add(menuprogram);

        infomenu.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        infomenu.setText("STUDENT INFO");
        infomenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infomenuActionPerformed(evt);
            }
        });
        studentinfomenu.add(infomenu);

        addressmenu.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        addressmenu.setText("ADDRESS");
        addressmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressmenuActionPerformed(evt);
            }
        });
        studentinfomenu.add(addressmenu);

        students.setText("STUDENTS");
        students.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N

        menucompscie.setText("COMPUTER SCIENCE");
        menucompscie.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        jMenuItem1.setText("ALL STUDENTS");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menucompscie.add(jMenuItem1);

        malemenu.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        malemenu.setText("MALE");
        malemenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                malemenuActionPerformed(evt);
            }
        });
        menucompscie.add(malemenu);

        jMenuItem2.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        jMenuItem2.setText("FEMALE");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menucompscie.add(jMenuItem2);

        students.add(menucompscie);

        jMenu2.setText("SOFTWARE ENGINEERING");
        jMenu2.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N

        jMenuItem3.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        jMenuItem3.setText("ALL STUDENTS");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        jMenuItem4.setText("MALE");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        jMenuItem5.setText("FEMALE");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        students.add(jMenu2);

        jMenu3.setText("AGRICULTURAL LIVELIHOOD");
        jMenu3.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N

        jMenuItem11.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        jMenuItem11.setText("ALL STUDENTS");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuItem12.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        jMenuItem12.setText("MALE");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem12);

        jMenuItem13.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        jMenuItem13.setText("FEMALE");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem13);

        students.add(jMenu3);

        jMenu4.setText("EDUCATION CHEM/MTC");
        jMenu4.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N

        jMenuItem14.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        jMenuItem14.setText("ALL STUDENTS");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem14);

        jMenuItem15.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        jMenuItem15.setText("MALE");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem15);

        jMenuItem16.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        jMenuItem16.setText("FEMALE");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem16);

        students.add(jMenu4);

        studentinfomenu.add(students);

        jMenuBar1.add(studentinfomenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void reportFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportFacultyActionPerformed
        // TODO add your handling code here:

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//registers the jdbc Driver
            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        String RESULT = "Faculties.pdf";

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
            document.add(new Paragraph("                          LIST OF ALL FACULTIES\n", FontFactory.getFont(FontFactory.TIMES_BOLD, 18)));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            document.add(new Paragraph("     "));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }

        PdfPTable table = new PdfPTable(2);//create table with 2 columns

        // PdfWriter writer = new PdfWriter();
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM Faculty ",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery();

            table.addCell("FACULTY ID");
            table.addCell("FACULTY NAME");

            while (rs.next()) {
                table.addCell(rs.getString("Faculty_id"));
                table.addCell(rs.getString("Faculty_Name"));

            }
            document.add(table);

            DateFormat df = new SimpleDateFormat("dd/MM/yy");
         Calendar calobj = Calendar.getInstance();
         String cal1 = df.format(calobj.getTime()).toString();
         
            
             Chunk glue1 = new Chunk(new VerticalPositionMark());
                    Paragraph ptot1 = new Paragraph("Generated by: Yiga Frank",FontFactory.getFont(FontFactory.TIMES_BOLD, 15, Font.ITALIC, BaseColor.BLACK));
                    ptot1.add(new Chunk(glue1));
                    ptot1.add("Issued on: " + cal1 + "");
                    document.add(ptot1);

            if (Desktop.isDesktopSupported()) {

                // File myfile = new File("///home/frank/NetBeansProjects/Management/Faculty.pdf");
                //File myfile = new File("Faculty.pdf");
                //Desktop.getDesktop().open(new File(new URI("///home/frank/NetBeansProjects/Management/Faculty.pdf").getPath()));
                Runtime.getRuntime().exec("evince " + "Faculties.pdf");

            }
            document.close();//close a pdf document

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_reportFacultyActionPerformed

    private void studentreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentreportActionPerformed
        // TODO add your handling code here:
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
            document.add(new Paragraph("    UNDERGRADUATE PRIVATE ADMISSIONS 2020/2021\n", FontFactory.getFont(FontFactory.TIMES_BOLD, 20)));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            document.add(new Paragraph("     "));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        PdfPTable table = new PdfPTable(6);//create table with 2 columns
        table.setWidthPercentage(110);
        
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM STUDENTS",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery();

            table.addCell("REG NO");
            table.addCell("FIRST NAME");
            table.addCell("LAST NAME");
            table.addCell("GENDER");
            table.addCell("DISTRICT");
            table.addCell("WEIGHT");

            while (rs.next()) {
                table.addCell(rs.getString("Reg_no"));
                table.addCell(rs.getString("First_Name"));
                table.addCell(rs.getString("Last_Name"));
                table.addCell(rs.getString("Gender"));
                table.addCell(rs.getString("District"));
                table.addCell(rs.getString("Results"));

            }
            
            document.add(table);
            
          /////////////////////////////
          
DateFormat df = new SimpleDateFormat("dd/MM/yy");
         Calendar calobj = Calendar.getInstance();
         String cal1 = df.format(calobj.getTime()).toString();
         
            
             Chunk glue1 = new Chunk(new VerticalPositionMark());
                    Paragraph ptot1 = new Paragraph("Generated by: Yiga Frank",FontFactory.getFont(FontFactory.TIMES_BOLD, 15, Font.ITALIC, BaseColor.BLACK));
                    ptot1.add(new Chunk(glue1));
                    ptot1.add("Issued on: " + cal1 + "");
                    document.add(ptot1);
            if (Desktop.isDesktopSupported()) {

                Runtime.getRuntime().exec("evince " + "Students.pdf");

            }
            document.close();//close a pdf document

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_studentreportActionPerformed

    private void menudepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menudepartmentActionPerformed
        // TODO add your handling code here:

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//registers the jdbc Driver
            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        String RESULT = "Departments.pdf";

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
            document.add(new Paragraph("                          LIST OF ALL DEPARTMENTS\n", FontFactory.getFont(FontFactory.TIMES_BOLD, 18)));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            document.add(new Paragraph("     "));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }

        PdfPTable table = new PdfPTable(3);//create table with 2 columns
        
        //table.setWidthPercentage(110);
        

        try {
            PreparedStatement st = con.prepareStatement("select Department_id,Department_Name,"
                 + "Faculty_Name from Department INNER JOIN Faculty WHERE "
                    + "Department.Faculty_Faculty_id = Faculty.Faculty_id",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery();

            table.addCell("DEPARTMENT ID");
            table.addCell("DEPARTMENT NAME");
            table.addCell("FACULTY NAME");

            while (rs.next()) {
                table.addCell(rs.getString("Department_id"));
                table.addCell(rs.getString("Department_Name"));
                table.addCell(rs.getString("Faculty_Name"));

            }
            document.add(table);

            DateFormat df = new SimpleDateFormat("dd/MM/yy");
         Calendar calobj = Calendar.getInstance();
         String cal1 = df.format(calobj.getTime()).toString();
         
            
             Chunk glue1 = new Chunk(new VerticalPositionMark());
                    Paragraph ptot1 = new Paragraph("Generated by: Yiga Frank",FontFactory.getFont(FontFactory.TIMES_BOLD, 15, Font.ITALIC, BaseColor.BLACK));
                    ptot1.add(new Chunk(glue1));
                    ptot1.add("Issued on: " + cal1 + "");
                    document.add(ptot1);

            if (Desktop.isDesktopSupported()) {

                Runtime.getRuntime().exec("evince " + "Departments.pdf");

            }
            document.close();//close a pdf document

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menudepartmentActionPerformed

    private void menuprogramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuprogramActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//registers the jdbc Driver
            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        String RESULT = "Program.pdf";

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
            document.add(new Paragraph("                          LIST OF ALL PROGRAMS \n", FontFactory.getFont(FontFactory.TIMES_BOLD, 18)));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            document.add(new Paragraph("     "));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        PdfPTable table = new PdfPTable(3);//create table with 2 columns
        
        table.setWidthPercentage(110);
        try {
            PreparedStatement st = con.prepareStatement("select Program_id,Program_Name,"
                    + "Department_Name from Program INNER JOIN Department "
                    + "WHERE Program.Department_Department_id = Department.Department_id ",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery();

            table.addCell("PROGRAM ID");
            table.addCell("PROGRAM NAME");
            table.addCell("DEPARTMENT NAME");

            while (rs.next()) {
                table.addCell(rs.getString("Program_id"));
                table.addCell(rs.getString("Program_Name"));
                table.addCell(rs.getString("Department_Name"));

            }
            document.add(table);

            DateFormat df = new SimpleDateFormat("dd/MM/yy");
         Calendar calobj = Calendar.getInstance();
         String cal1 = df.format(calobj.getTime()).toString();
         
            
             Chunk glue1 = new Chunk(new VerticalPositionMark());
                    Paragraph ptot1 = new Paragraph("Generated by: Yiga Frank",FontFactory.getFont(FontFactory.TIMES_BOLD, 15, Font.ITALIC, BaseColor.BLACK));
                    ptot1.add(new Chunk(glue1));
                    ptot1.add("Issued on: " + cal1 + "");
                    document.add(ptot1);

            if (Desktop.isDesktopSupported()) {

                Runtime.getRuntime().exec("evince " + "Program.pdf");

            }
            document.close();//close a pdf document

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuprogramActionPerformed

    private void infomenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infomenuActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//registers the jdbc Driver
            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        String RESULT = "Student_info.pdf";

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
            document.add(new Paragraph("                    ADMITTED STUDENTS INFO \n", FontFactory.getFont(FontFactory.TIMES_BOLD, 18)));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            document.add(new Paragraph("     "));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        PdfPTable table = new PdfPTable(3);//create table with 2 columns

        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM Student_info ",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery();

            table.addCell("STUDENT ID");
            table.addCell("FORMER SCHOOL");
            table.addCell("WEIGHT");

            while (rs.next()) {
                table.addCell(rs.getString("Student_id"));
                table.addCell(rs.getString("Former_School"));
                table.addCell(rs.getString("Results"));

            }
            document.add(table);

            DateFormat df = new SimpleDateFormat("dd/MM/yy");
         Calendar calobj = Calendar.getInstance();
         String cal1 = df.format(calobj.getTime()).toString();
         
            
             Chunk glue1 = new Chunk(new VerticalPositionMark());
                    Paragraph ptot1 = new Paragraph("Generated by: Yiga Frank",FontFactory.getFont(FontFactory.TIMES_BOLD, 15, Font.ITALIC, BaseColor.BLACK));
                    ptot1.add(new Chunk(glue1));
                    ptot1.add("Issued on: " + cal1 + "");
                    document.add(ptot1);

            if (Desktop.isDesktopSupported()) {

                Runtime.getRuntime().exec("evince " + "Student_info.pdf");

            }
            document.close();//close a pdf document

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_infomenuActionPerformed

    private void addressmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressmenuActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//registers the jdbc Driver
            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        String RESULT = "Address.pdf";

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
            document.add(new Paragraph("                    ADMITTED STUDENTS INFO \n", FontFactory.getFont(FontFactory.TIMES_BOLD, 18)));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            document.add(new Paragraph("     "));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        PdfPTable table = new PdfPTable(2);//create table with 2 columns

        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM Address ",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery();

            table.addCell("ADDRESS ID");
            table.addCell("DISTRICT");

            while (rs.next()) {
                table.addCell(rs.getString("Address_id"));
                table.addCell(rs.getString("District"));

            }
            document.add(table);
            DateFormat df = new SimpleDateFormat("dd/MM/yy");
         Calendar calobj = Calendar.getInstance();
         String cal1 = df.format(calobj.getTime()).toString();
         
            
             Chunk glue1 = new Chunk(new VerticalPositionMark());
                    Paragraph ptot1 = new Paragraph("Generated by: Yiga Frank",FontFactory.getFont(FontFactory.TIMES_BOLD, 15, Font.ITALIC, BaseColor.BLACK));
                    ptot1.add(new Chunk(glue1));
                    ptot1.add("Issued on: " + cal1 + "");
                    document.add(ptot1);

            if (Desktop.isDesktopSupported()) {

                Runtime.getRuntime().exec("evince " + "Address.pdf");

            }
            document.close();//close a pdf document

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addressmenuActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//registers the jdbc Driver
            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        String RESULT = "bse_Students.pdf";

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
            document.add(new Paragraph("   ADMITTED STUDENTS IN SOFTWARE ENG 2019/2020 \n", FontFactory.getFont(FontFactory.TIMES_BOLD, 18)));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            document.add(new Paragraph("     "));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        PdfPTable table = new PdfPTable(6);//create table with 2 columns
         table.setWidthPercentage(110);
        
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM STUDENTS WHERE Reg_no LIKE \"%/bse/%\" ",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery();

           table.addCell("REG NO");
            table.addCell("FIRST NAME");
            table.addCell("LAST NAME");
            table.addCell("GENDER");
            table.addCell("DISTRICT");
            table.addCell("WEIGHT");
            
            
            

            while (rs.next()) {
                table.addCell(rs.getString("Reg_no"));
                table.addCell(rs.getString("First_Name"));
                table.addCell(rs.getString("Last_Name"));
                table.addCell(rs.getString("Gender"));
                table.addCell(rs.getString("District"));
                table.addCell(rs.getString("Results"));

            }
            document.add(table);
           DateFormat df = new SimpleDateFormat("dd/MM/yy");
         Calendar calobj = Calendar.getInstance();
         String cal1 = df.format(calobj.getTime()).toString();
         
            
             Chunk glue1 = new Chunk(new VerticalPositionMark());
                    Paragraph ptot1 = new Paragraph("Generated by: Yiga Frank",FontFactory.getFont(FontFactory.TIMES_BOLD, 15, Font.ITALIC, BaseColor.BLACK));
                    ptot1.add(new Chunk(glue1));
                    ptot1.add("Issued on: " + cal1 + "");
                    document.add(ptot1);

            if (Desktop.isDesktopSupported()) {

                Runtime.getRuntime().exec("evince " + "bse_Students.pdf");

            }
            document.close();//close a pdf document

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void PROGRAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PROGRAMActionPerformed
        // TODO add your handling code here:
        new Program().program();
        dispose();
    }//GEN-LAST:event_PROGRAMActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        new Student().student();
        dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        new Faculty().faculty();
        dispose();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        
       new Department().department();
       dispose();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        new Student_info().info();
        dispose();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        new Address().address();
       dispose(); 
        
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//registers the jdbc Driver
            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        String RESULT = "bcs_Students.pdf";

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
            document.add(new Paragraph("ADMITTED STUDENTS IN COMPUTER SCIENCE 2019/2020 \n", FontFactory.getFont(FontFactory.TIMES_BOLD, 18)));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            document.add(new Paragraph("     "));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        PdfPTable table = new PdfPTable(6);//create table with 2 columns
         table.setWidthPercentage(110);
        
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM STUDENTS WHERE Reg_no LIKE \"%/bcs/%\" ",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery();

           table.addCell("REG NO");
            table.addCell("FIRST NAME");
            table.addCell("LAST NAME");
            table.addCell("GENDER");
            table.addCell("DISTRICT");
            table.addCell("WEIGHT");
            
            
            

            while (rs.next()) {
                table.addCell(rs.getString("Reg_no"));
                table.addCell(rs.getString("First_Name"));
                table.addCell(rs.getString("Last_Name"));
                table.addCell(rs.getString("Gender"));
                table.addCell(rs.getString("District"));
                table.addCell(rs.getString("Results"));

            }
            document.add(table);
           DateFormat df = new SimpleDateFormat("dd/MM/yy");
         Calendar calobj = Calendar.getInstance();
         String cal1 = df.format(calobj.getTime()).toString();
         
            
             Chunk glue1 = new Chunk(new VerticalPositionMark());
                    Paragraph ptot1 = new Paragraph("Generated by: Yiga Frank",FontFactory.getFont(FontFactory.TIMES_BOLD, 15, Font.ITALIC, BaseColor.BLACK));
                    ptot1.add(new Chunk(glue1));
                    ptot1.add("Issued on: " + cal1 + "");
                    document.add(ptot1);

            if (Desktop.isDesktopSupported()) {

                Runtime.getRuntime().exec("evince " + "bcs_Students.pdf");

            }
            document.close();//close a pdf document

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void malemenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_malemenuActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//registers the jdbc Driver
            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        String RESULT = "bcs_Students.pdf";

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
            document.add(new Paragraph("      MALE STUDENTS IN COMPUTER SCIENCE  2019/2020 \n", FontFactory.getFont(FontFactory.TIMES_BOLD, 18)));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            document.add(new Paragraph("     "));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        PdfPTable table = new PdfPTable(6);//create table with 2 columns
         table.setWidthPercentage(110);
        
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM STUDENTS WHERE Reg_no LIKE \"%/bcs/%\" AND Gender = \"Male\"",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery();

           table.addCell("REG NO");
            table.addCell("FIRST NAME");
            table.addCell("LAST NAME");
            table.addCell("GENDER");
            table.addCell("DISTRICT");
            table.addCell("WEIGHT");
            
            
            

            while (rs.next()) {
                table.addCell(rs.getString("Reg_no"));
                table.addCell(rs.getString("First_Name"));
                table.addCell(rs.getString("Last_Name"));
                table.addCell(rs.getString("Gender"));
                table.addCell(rs.getString("District"));
                table.addCell(rs.getString("Results"));

            }
            document.add(table);
           DateFormat df = new SimpleDateFormat("dd/MM/yy");
         Calendar calobj = Calendar.getInstance();
         String cal1 = df.format(calobj.getTime()).toString();
         
            
             Chunk glue1 = new Chunk(new VerticalPositionMark());
                    Paragraph ptot1 = new Paragraph("Generated by: Yiga Frank",FontFactory.getFont(FontFactory.TIMES_BOLD, 15, Font.ITALIC, BaseColor.BLACK));
                    ptot1.add(new Chunk(glue1));
                    ptot1.add("Issued on: " + cal1 + "");
                    document.add(ptot1);

            if (Desktop.isDesktopSupported()) {

                Runtime.getRuntime().exec("evince " + "bcs_Students.pdf");

            }
            document.close();//close a pdf document

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_malemenuActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//registers the jdbc Driver
            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        String RESULT = "bcs_Students.pdf";

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
            document.add(new Paragraph("     FEMALE STUDENTS IN COMPUTER SCIENCE  2019/2020 \n", FontFactory.getFont(FontFactory.TIMES_BOLD, 18)));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            document.add(new Paragraph("     "));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        PdfPTable table = new PdfPTable(6);//create table with 2 columns
         table.setWidthPercentage(110);
        
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM STUDENTS WHERE Reg_no LIKE \"%/bcs/%\" AND Gender = \"Female\"",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery();

           table.addCell("REG NO");
            table.addCell("FIRST NAME");
            table.addCell("LAST NAME");
            table.addCell("GENDER");
            table.addCell("DISTRICT");
            table.addCell("WEIGHT");
            
            
            

            while (rs.next()) {
                table.addCell(rs.getString("Reg_no"));
                table.addCell(rs.getString("First_Name"));
                table.addCell(rs.getString("Last_Name"));
                table.addCell(rs.getString("Gender"));
                table.addCell(rs.getString("District"));
                table.addCell(rs.getString("Results"));

            }
            document.add(table);
            DateFormat df = new SimpleDateFormat("dd/MM/yy");
         Calendar calobj = Calendar.getInstance();
         String cal1 = df.format(calobj.getTime()).toString();
         
            
             Chunk glue1 = new Chunk(new VerticalPositionMark());
                    Paragraph ptot1 = new Paragraph("Generated by: Yiga Frank",FontFactory.getFont(FontFactory.TIMES_BOLD, 15, Font.ITALIC, BaseColor.BLACK));
                    ptot1.add(new Chunk(glue1));
                    ptot1.add("Issued on: " + cal1 + "");
                    document.add(ptot1);

            if (Desktop.isDesktopSupported()) {

                Runtime.getRuntime().exec("evince " + "bcs_Students.pdf");

            }
            document.close();//close a pdf document

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//registers the jdbc Driver
            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        String RESULT = "bse_Students.pdf";

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
            document.add(new Paragraph("MALE  STUDENTS IN SOFTWARE  ENGINEERING  2019/2020 \n", FontFactory.getFont(FontFactory.TIMES_BOLD, 18)));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            document.add(new Paragraph("     "));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        PdfPTable table = new PdfPTable(6);//create table with 2 columns
         table.setWidthPercentage(110);
        
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM STUDENTS WHERE Reg_no LIKE \"%/bse/%\" AND Gender = \"Male\"",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery();

           table.addCell("REG NO");
            table.addCell("FIRST NAME");
            table.addCell("LAST NAME");
            table.addCell("GENDER");
            table.addCell("DISTRICT");
            table.addCell("WEIGHT");
            
            
            

            while (rs.next()) {
                table.addCell(rs.getString("Reg_no"));
                table.addCell(rs.getString("First_Name"));
                table.addCell(rs.getString("Last_Name"));
                table.addCell(rs.getString("Gender"));
                table.addCell(rs.getString("District"));
                table.addCell(rs.getString("Results"));

            }
            document.add(table);
            DateFormat df = new SimpleDateFormat("dd/MM/yy");
         Calendar calobj = Calendar.getInstance();
         String cal1 = df.format(calobj.getTime()).toString();
         
            
             Chunk glue1 = new Chunk(new VerticalPositionMark());
                    Paragraph ptot1 = new Paragraph("Generated by: Yiga Frank",FontFactory.getFont(FontFactory.TIMES_BOLD, 15, Font.ITALIC, BaseColor.BLACK));
                    ptot1.add(new Chunk(glue1));
                    ptot1.add("Issued on: " + cal1 + "");
                    document.add(ptot1);

            if (Desktop.isDesktopSupported()) {

                Runtime.getRuntime().exec("evince " + "bse_Students.pdf");

            }
            document.close();//close a pdf document

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//registers the jdbc Driver
            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        String RESULT = "bse_Students.pdf";

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
            document.add(new Paragraph("  FEMALE  STUDENTS  IN  SOFTWARE  ENG  2019/2020 \n", FontFactory.getFont(FontFactory.TIMES_BOLD, 18)));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            document.add(new Paragraph("     "));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        PdfPTable table = new PdfPTable(6);//create table with 2 columns
         table.setWidthPercentage(110);
        
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM STUDENTS WHERE Reg_no LIKE \"%/bse/%\" AND Gender = \"Female\"",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery();

           table.addCell("REG NO");
            table.addCell("FIRST NAME");
            table.addCell("LAST NAME");
            table.addCell("GENDER");
            table.addCell("DISTRICT");
            table.addCell("WEIGHT");
            
            
            

            while (rs.next()) {
                table.addCell(rs.getString("Reg_no"));
                table.addCell(rs.getString("First_Name"));
                table.addCell(rs.getString("Last_Name"));
                table.addCell(rs.getString("Gender"));
                table.addCell(rs.getString("District"));
                table.addCell(rs.getString("Results"));

            }
            document.add(table);
            DateFormat df = new SimpleDateFormat("dd/MM/yy");
         Calendar calobj = Calendar.getInstance();
         String cal1 = df.format(calobj.getTime()).toString();
         
            
             Chunk glue1 = new Chunk(new VerticalPositionMark());
                    Paragraph ptot1 = new Paragraph("Generated by: Yiga Frank",FontFactory.getFont(FontFactory.TIMES_BOLD, 15, Font.ITALIC, BaseColor.BLACK));
                    ptot1.add(new Chunk(glue1));
                    ptot1.add("Issued on: " + cal1 + "");
                    document.add(ptot1);

            if (Desktop.isDesktopSupported()) {

                Runtime.getRuntime().exec("evince " + "bse_Students.pdf");

            }
            document.close();//close a pdf document

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");//registers the jdbc Driver
            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        String RESULT = "bsl_Students.pdf";

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
            document.add(new Paragraph("ADMITTED STUDENTS IN AGRIC LIVELIHOOD 2019/2020 \n", FontFactory.getFont(FontFactory.TIMES_BOLD, 18)));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            document.add(new Paragraph("     "));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        PdfPTable table = new PdfPTable(6);//create table with 2 columns
         table.setWidthPercentage(110);
        
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM STUDENTS WHERE Reg_no LIKE \"%/bsl/%\" ",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery();

           table.addCell("REG NO");
            table.addCell("FIRST NAME");
            table.addCell("LAST NAME");
            table.addCell("GENDER");
            table.addCell("DISTRICT");
            table.addCell("WEIGHT");
            
            
            

            while (rs.next()) {
                table.addCell(rs.getString("Reg_no"));
                table.addCell(rs.getString("First_Name"));
                table.addCell(rs.getString("Last_Name"));
                table.addCell(rs.getString("Gender"));
                table.addCell(rs.getString("District"));
                table.addCell(rs.getString("Results"));

            }
            document.add(table);
            DateFormat df = new SimpleDateFormat("dd/MM/yy");
         Calendar calobj = Calendar.getInstance();
         String cal1 = df.format(calobj.getTime()).toString();
         
            
             Chunk glue1 = new Chunk(new VerticalPositionMark());
                    Paragraph ptot1 = new Paragraph("Generated by: Yiga Frank",FontFactory.getFont(FontFactory.TIMES_BOLD, 15, Font.ITALIC, BaseColor.BLACK));
                    ptot1.add(new Chunk(glue1));
                    ptot1.add("Issued on: " + cal1 + "");
                    document.add(ptot1);

            if (Desktop.isDesktopSupported()) {

                Runtime.getRuntime().exec("evince " + "bsl_Students.pdf");

            }
            document.close();//close a pdf document

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//registers the jdbc Driver
            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        String RESULT = "bsl_Students.pdf";

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
            document.add(new Paragraph("   MALE  STUDENTS IN AGRIC  LIVELIHOOD  2019/2020 \n", FontFactory.getFont(FontFactory.TIMES_BOLD, 18)));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            document.add(new Paragraph("     "));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        PdfPTable table = new PdfPTable(6);//create table with 2 columns
         table.setWidthPercentage(110);
        
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM STUDENTS WHERE Reg_no LIKE \"%/bsl/%\" AND Gender = \"Male\"",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery();

           table.addCell("REG NO");
            table.addCell("FIRST NAME");
            table.addCell("LAST NAME");
            table.addCell("GENDER");
            table.addCell("DISTRICT");
            table.addCell("WEIGHT");
            
            
            

            while (rs.next()) {
                table.addCell(rs.getString("Reg_no"));
                table.addCell(rs.getString("First_Name"));
                table.addCell(rs.getString("Last_Name"));
                table.addCell(rs.getString("Gender"));
                table.addCell(rs.getString("District"));
                table.addCell(rs.getString("Results"));

            }
            document.add(table);
            DateFormat df = new SimpleDateFormat("dd/MM/yy");
         Calendar calobj = Calendar.getInstance();
         String cal1 = df.format(calobj.getTime()).toString();
         
            
             Chunk glue1 = new Chunk(new VerticalPositionMark());
                    Paragraph ptot1 = new Paragraph("Generated by: Yiga Frank",FontFactory.getFont(FontFactory.TIMES_BOLD, 15, Font.ITALIC, BaseColor.BLACK));
                    ptot1.add(new Chunk(glue1));
                    ptot1.add("Issued on: " + cal1 + "");
                    document.add(ptot1);

            if (Desktop.isDesktopSupported()) {

                Runtime.getRuntime().exec("evince " + "bsl_Students.pdf");

            }
            document.close();//close a pdf document

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");//registers the jdbc Driver
            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        String RESULT = "bsl_Students.pdf";

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
            document.add(new Paragraph(" FEMALE  STUDENTS IN AGRIC  LIVELIHOOD  2019/2020 \n", FontFactory.getFont(FontFactory.TIMES_BOLD, 18)));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            document.add(new Paragraph("     "));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        PdfPTable table = new PdfPTable(6);//create table with 2 columns
         table.setWidthPercentage(110);
        
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM STUDENTS WHERE Reg_no LIKE \"%/bsl/%\" AND Gender = \"Female\"",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery();

           table.addCell("REG NO");
            table.addCell("FIRST NAME");
            table.addCell("LAST NAME");
            table.addCell("GENDER");
            table.addCell("DISTRICT");
            table.addCell("WEIGHT");
            
            
            

            while (rs.next()) {
                table.addCell(rs.getString("Reg_no"));
                table.addCell(rs.getString("First_Name"));
                table.addCell(rs.getString("Last_Name"));
                table.addCell(rs.getString("Gender"));
                table.addCell(rs.getString("District"));
                table.addCell(rs.getString("Results"));

            }
            document.add(table);
            DateFormat df = new SimpleDateFormat("dd/MM/yy");
         Calendar calobj = Calendar.getInstance();
         String cal1 = df.format(calobj.getTime()).toString();
         
            
             Chunk glue1 = new Chunk(new VerticalPositionMark());
                    Paragraph ptot1 = new Paragraph("Generated by: Yiga Frank",FontFactory.getFont(FontFactory.TIMES_BOLD, 15, Font.ITALIC, BaseColor.BLACK));
                    ptot1.add(new Chunk(glue1));
                    ptot1.add("Issued on: " + cal1 + "");
                    document.add(ptot1);
            if (Desktop.isDesktopSupported()) {

                Runtime.getRuntime().exec("evince " + "bsl_Students.pdf");

            }
            document.close();//close a pdf document

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");//registers the jdbc Driver
            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        String RESULT = "bsc_Students.pdf";

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
            document.add(new Paragraph("ADMITTED STUDENTS IN EDUCATION MTC/CHEM 2019/2020\n", FontFactory.getFont(FontFactory.TIMES_BOLD, 18)));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            document.add(new Paragraph("     "));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        PdfPTable table = new PdfPTable(6);//create table with 2 columns
         table.setWidthPercentage(110);
        
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM STUDENTS WHERE Reg_no LIKE \"%/bsc/%\" ",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery();

           table.addCell("REG NO");
            table.addCell("FIRST NAME");
            table.addCell("LAST NAME");
            table.addCell("GENDER");
            table.addCell("DISTRICT");
            table.addCell("WEIGHT");
            
            
            

            while (rs.next()) {
                table.addCell(rs.getString("Reg_no"));
                table.addCell(rs.getString("First_Name"));
                table.addCell(rs.getString("Last_Name"));
                table.addCell(rs.getString("Gender"));
                table.addCell(rs.getString("District"));
                table.addCell(rs.getString("Results"));

            }
            document.add(table);
            DateFormat df = new SimpleDateFormat("dd/MM/yy");
         Calendar calobj = Calendar.getInstance();
         String cal1 = df.format(calobj.getTime()).toString();
         
            
             Chunk glue1 = new Chunk(new VerticalPositionMark());
                    Paragraph ptot1 = new Paragraph("Generated by: Yiga Frank",FontFactory.getFont(FontFactory.TIMES_BOLD, 15, Font.ITALIC, BaseColor.BLACK));
                    ptot1.add(new Chunk(glue1));
                    ptot1.add("Issued on: " + cal1 + "");
                    document.add(ptot1);

            if (Desktop.isDesktopSupported()) {

                Runtime.getRuntime().exec("evince " + "bsc_Students.pdf");

            }
            document.close();//close a pdf document

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//registers the jdbc Driver
            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        String RESULT = "bsc_Students.pdf";

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
            document.add(new Paragraph(" MALE  EDUCATION STUDENTS CHEM/MTC   2019/2020 \n", FontFactory.getFont(FontFactory.TIMES_BOLD, 18)));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            document.add(new Paragraph("     "));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        PdfPTable table = new PdfPTable(6);//create table with 2 columns
         table.setWidthPercentage(110);
        
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM STUDENTS WHERE Reg_no LIKE \"%/bsc/%\" AND Gender = \"Male\"",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery();

           table.addCell("REG NO");
            table.addCell("FIRST NAME");
            table.addCell("LAST NAME");
            table.addCell("GENDER");
            table.addCell("DISTRICT");
            table.addCell("WEIGHT");
            
            
            

            while (rs.next()) {
                table.addCell(rs.getString("Reg_no"));
                table.addCell(rs.getString("First_Name"));
                table.addCell(rs.getString("Last_Name"));
                table.addCell(rs.getString("Gender"));
                table.addCell(rs.getString("District"));
                table.addCell(rs.getString("Results"));

            }
            document.add(table);
            DateFormat df = new SimpleDateFormat("dd/MM/yy");
         Calendar calobj = Calendar.getInstance();
         String cal1 = df.format(calobj.getTime()).toString();
         
            
             Chunk glue1 = new Chunk(new VerticalPositionMark());
                    Paragraph ptot1 = new Paragraph("Generated by: Yiga Frank",FontFactory.getFont(FontFactory.TIMES_BOLD, 15, Font.ITALIC, BaseColor.BLACK));
                    ptot1.add(new Chunk(glue1));
                    ptot1.add("Issued on: " + cal1 + "");
                    document.add(ptot1);

            if (Desktop.isDesktopSupported()) {

                Runtime.getRuntime().exec("evince " + "bsc_Students.pdf");

            }
            document.close();//close a pdf document

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        // TODO add your handling code here:
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");//registers the jdbc Driver
            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        String RESULT = "bsc_Students.pdf";

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
            document.add(new Paragraph(" FEMALE EDUCATION STUDENTS CHEM/MTC   2019/2020 \n", FontFactory.getFont(FontFactory.TIMES_BOLD, 18)));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            document.add(new Paragraph("     "));
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         
         
        PdfPTable table = new PdfPTable(6);//create table with 2 columns
         table.setWidthPercentage(110);
        
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM STUDENTS WHERE Reg_no LIKE \"%/bsc/%\" AND Gender = \"Female\"",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery();

           table.addCell("REG NO");
            table.addCell("FIRST NAME");
            table.addCell("LAST NAME");
            table.addCell("GENDER");
            table.addCell("DISTRICT");
            table.addCell("WEIGHT");
            
            
            

            while (rs.next()) {
                table.addCell(rs.getString("Reg_no"));
                table.addCell(rs.getString("First_Name"));
                table.addCell(rs.getString("Last_Name"));
                table.addCell(rs.getString("Gender"));
                table.addCell(rs.getString("District"));
                table.addCell(rs.getString("Results"));

            }
            document.add(table);
            
            DateFormat df = new SimpleDateFormat("dd/MM/yy");
         Calendar calobj = Calendar.getInstance();
         String cal1 = df.format(calobj.getTime()).toString();
         
            
             Chunk glue1 = new Chunk(new VerticalPositionMark());
                    Paragraph ptot1 = new Paragraph("Generated by: Yiga Frank",
                            FontFactory.getFont(FontFactory.TIMES_BOLD, 15, Font.ITALIC, BaseColor.BLACK));
                    ptot1.add(new Chunk(glue1));
                    ptot1.add("Issued on: " + cal1 + "");
                    document.add(ptot1);
                    
            /*PdfPTable footable = new PdfPTable(1);
            PdfPCell footerCell = new PdfPCell();
            Phrase footer = new Phrase("Prepared by Yiga Frank");

            footerCell.setPhrase(footer);
            footerCell.setBorder(0);
            footable.addCell(footerCell);
            footable.setSpacingBefore(document.bottomMargin());
            footerCell.setHorizontalAlignment(90);
            footable.setWidthPercentage(105);

            document.add(footable);*/

            if (Desktop.isDesktopSupported()) {

                Runtime.getRuntime().exec("evince " + "bsc_Students.pdf");

            }
            document.close();//close a pdf document

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem16ActionPerformed

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
            java.util.logging.Logger.getLogger(Main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem PROGRAM;
    private javax.swing.JMenuItem addressmenu;
    private javax.swing.JMenuItem infomenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JMenuItem malemenu;
    private javax.swing.JMenu menucompscie;
    private javax.swing.JMenuItem menudepartment;
    private javax.swing.JMenuItem menuprogram;
    private javax.swing.JMenuItem reportFaculty;
    private javax.swing.JMenu studentinfomenu;
    private javax.swing.JMenuItem studentreport;
    private javax.swing.JMenu students;
    // End of variables declaration//GEN-END:variables
}
