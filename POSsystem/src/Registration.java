
//import com.sun.jdi.connect.spi.Connection;
import java.text.SimpleDateFormat;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author adaobi
 */
public class Registration extends javax.swing.JFrame {

    public String filename = null;
    static byte photo[] = null;
 private String generatedPassword;
    /**
     * Creates new form Registration
     */
    public Registration() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel3.setLayout(null);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("FIRST NAME");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(36, 31, 110, 16);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SURNAME");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(36, 91, 90, 16);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Staff ID");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(36, 176, 70, 16);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DEPARTMENT");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(36, 227, 100, 16);

        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(40, 590, 72, 23);

        jButton2.setText("CLEAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);
        jButton2.setBounds(410, 600, 72, 23);
        jPanel3.add(jLabel9);
        jLabel9.setBounds(176, 141, 0, 0);
        jPanel3.add(jTextField1);
        jTextField1.setBounds(176, 28, 416, 30);
        jPanel3.add(jTextField2);
        jTextField2.setBounds(176, 88, 416, 40);
        jPanel3.add(jTextField3);
        jTextField3.setBounds(176, 173, 416, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Department", "Sales", "Inventory/Stock", "IT" }));
        jComboBox1.setToolTipText("");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox1);
        jComboBox1.setBounds(176, 224, 416, 30);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesandicons/icons8-register-48.png"))); // NOI18N
        jButton3.setText("REGISTER");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(730, 520, 150, 55);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("E-MAIL");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(36, 484, 80, 16);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("DOB");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(36, 293, 90, 16);

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Password");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(33, 550, 110, 16);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Phone Number");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(36, 419, 100, 16);
        jPanel3.add(jTextField5);
        jTextField5.setBounds(176, 481, 416, 30);
        jPanel3.add(jTextField7);
        jTextField7.setBounds(180, 550, 410, 30);
        jPanel3.add(jTextField4);
        jTextField4.setBounds(176, 416, 416, 30);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gender");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(36, 357, 70, 16);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Male");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jRadioButton1);
        jRadioButton1.setBounds(176, 355, 70, 21);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Female");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jRadioButton2);
        jRadioButton2.setBounds(512, 355, 80, 21);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel10.setOpaque(true);
        jPanel3.add(jLabel10);
        jLabel10.setBounds(610, 40, 280, 220);

        jButton4.setText("Browse Image ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);
        jButton4.setBounds(690, 280, 140, 23);
        jPanel3.add(jDateChooser1);
        jDateChooser1.setBounds(176, 287, 416, 30);

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesandicons/Red Blue & White Remembrance Flower Memorial Day Instagram Post.png"))); // NOI18N
        jLabel12.setText("jLabel12");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(0, 0, 900, 640);

        jLabel5.setText("jLabel5");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(0, 10, 750, 580);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(-2, -5, 900, 650);

        setSize(new java.awt.Dimension(914, 667));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image", "jpg");
            jFileChooser1.setAcceptAllFileFilterUsed(false);
            jFileChooser1.addChoosableFileFilter(filter);
            jFileChooser1.showOpenDialog(null);

            jFileChooser1.showOpenDialog(null);
            File f = jFileChooser1.getSelectedFile();
            filename = f.getAbsolutePath();
            Image im = Toolkit.getDefaultToolkit().createImage(filename);
            im = im.getScaledInstance(jLabel10.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon ic = new ImageIcon(im);
            jLabel10.setIcon(ic);
            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] Byte = new byte[1024];

            for (int i; (i = fis.read(Byte)) != -1;) {
                baos.write(Byte, 0, i);
            }
            photo = baos.toByteArray();

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        // Add your signup logic here
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos", "root", "Nkoli1510");

            // Get values from UI components
            String firstname = jTextField1.getText();
            String Surname = jTextField2.getText();
            String StaffID = jTextField3.getText();
            String Department = jComboBox1.getSelectedItem().toString();

            // Get date of birth from the JDateChooser
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String DOB = dateFormat.format(jDateChooser1.getDate());
            String Gender = null;
            if (jRadioButton1.isSelected()) {
                Gender = "Male";

            } else if (jRadioButton2.isSelected()) {
                Gender = "Female";
            }

            String Phonenumber = jTextField4.getText();
            String Email = jTextField5.getText();
            String Password = jTextField7.getText();
            String tableName;
            switch (Department) {
                case "Sales":
                tableName = "sales_db";
               // this.dispose();
                new Sales_department(Email).setVisible(true);
                break;
                case "Inventory/Stock":
                tableName = "inventory_db";
                //this.dispose();
                new Stock().setVisible(true);
                break;
                case "IT":
                tableName = "it_db";
                //this.dispose();
                new IT_D().setVisible(true);
                break;
                default:
                // Handle the case where department is not recognized
                tableName = null;
                break;
            }

            // Prepare the SQL query
            String hashedPassword = hashPassword(Password);

            // Use the generated password in the email body
            String body = "Thank you for registering with us. Your password is: " + generatedPassword + firstname;

            // Email sender details
            String senderEmail = "arinzechiadaobiada@gmail.com";  // Replace with your email
            String senderPassword = "vycz vkxf fbht defd";
            String subject = "Registration Confirmation";

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");

            // Email session
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(senderEmail, senderPassword);
                }
            });
            try {
                // Create a message
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("arinzechiadaobiada@gmail.com"));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(Email)); // Use the 'Email' variable here
                message.setSubject(subject);
                message.setText(body);

                // Send the message
                Transport.send(message);

                System.out.println("Email sent successfully!");

            } catch (MessagingException e) {
                e.printStackTrace();
            }
            if (tableName != null) {
                // Prepare SQL query
                String sql = "INSERT INTO " + tableName + "(firstname, Surname, StaffID, Department,DOB, Gender,Phonenumber, Email,photo,password) VALUES (?, ?, ?,?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);

                // Set values for the parameters
                ps.setString(1, firstname);
                ps.setString(2, Surname);
                ps.setString(3, StaffID);
                ps.setString(4, Department);
                ps.setString(5, DOB);
                ps.setString(6, Gender);
                ps.setString(7, Phonenumber);
                ps.setString(8, Email);
                ps.setBytes(9, photo);
                ps.setString(10, hashedPassword);

                // Execute the query
                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Student record inserted successfully");

                    // Send email with generated password
                } else {
                    System.out.println("Failed to insert record");
                }

                // Close the resources
                ps.close();
                if (isBirthday(DOB)) {
                    showBirthdayNotification(firstname);
                    sendBirthdayEmail(firstname, Email);
                }
            } else {
                // Handle the case where department is not recognized
                System.out.println("Invalid department selected");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }

        

       private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            // Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

        private boolean isBirthday(String dob) {
            LocalDate today = LocalDate.now();
            LocalDate birthday = LocalDate.parse(dob);

            return today.getMonth() == birthday.getMonth() && today.getDayOfMonth() == birthday.getDayOfMonth();
        }
        private void showBirthdayNotification(String name) {
           
            JOptionPane.showMessageDialog(this, "Happy Birthday, " + name + "!", "Birthday Notification", JOptionPane.INFORMATION_MESSAGE);
        }

        private void sendBirthdayEmail(String name, String email) {
            
            String body = "Happy Birthday, " + name + "! We wish you a fantastic day.";

            // ... (existing email sending code)
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
         jTextField7.setText("");
        buttonGroup1.clearSelection();
        jComboBox1.setSelectedIndex(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Login Login2 = new Login();
        Login2.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    public static com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    public static javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    public static javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    public static javax.swing.JTextField jTextField5;
    public static javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
