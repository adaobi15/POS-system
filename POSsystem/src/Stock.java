
//import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.Timer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author adaobi
 */
public class Stock extends javax.swing.JFrame {

    String Email;
    // private List<String> notificationsList;

    /**
     * Creates new form Stock
     */
    public Stock(String email) {
        this.Email = email;
        initComponents();
        // this.notificationsList = new ArrayList<>();
        
        
    }

    public Stock() {
        // Call the parameterized constructor with a default or null value
        this(null);
    }

    private List<String> getExpiringProducts() {
        List<String> expiringProducts = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos", "root", "Nkoli1510")) {
            String query = "SELECT Name FROM product WHERE Exp_D <= DATE_ADD(CURDATE(), INTERVAL 7 DAY)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    String productName = resultSet.getString("Name");
                    expiringProducts.add(productName);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error retrieving expiring products.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return expiringProducts;
    }

    private void showExpirationNotification() {
        List<String> expiringProducts = getExpiringProducts();

        if (expiringProducts.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No products close to expiration.", "Notification", JOptionPane.INFORMATION_MESSAGE);
            jLabel1.setVisible(false);
        } else {
            jLabel1.setVisible(true);
            StringBuilder message = new StringBuilder("Expiration date alert!\n\nProducts close to expiration:\n");
            for (String product : expiringProducts) {
                message.append("- ").append(product).append("\n");
            }
sendNotificationEmail("Expired Stock Alert", message.toString());
            JOptionPane.showMessageDialog(this, message.toString(), "Notification", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private List<String> getLowStockProducts() {
        List<String> lowStockProducts = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos", "root", "Nkoli1510")) {
            String query = "SELECT Name FROM product WHERE Quantity <= 3";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    String productName = resultSet.getString("Name");
                    lowStockProducts.add(productName);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error retrieving low stock products.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return lowStockProducts;
    }

    private void showNotification() {
        List<String> lowStockProducts = getLowStockProducts();

        if (lowStockProducts.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No low stock products.", "Notification", JOptionPane.INFORMATION_MESSAGE);
            jLabel1.setVisible(false);
        } else {
            jLabel1.setVisible(true);
            StringBuilder message = new StringBuilder("Low stock alert!\n\nProducts running low on stock:\n");
            for (String product : lowStockProducts) {
                message.append("- ").append(product).append("\n");
            }
sendNotificationEmail("Low Stock Alert", message.toString());
            JOptionPane.showMessageDialog(this, message.toString(), "Notification", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void updateBadge() {
        List<String> lowStockProducts = getLowStockProducts();

        if (lowStockProducts.isEmpty()) {
            jLabel1.setVisible(false); // Hide badge if no notifications
        } else {
            jLabel1.setVisible(true);
        }

    

    }
     private void sendNotificationEmail(String subject, String body) {
    String senderEmail = "arinzechiadaobiada@gmail.com";  // Replace with your email
    String senderPassword = "reug vplu ikqf mpbg";

    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");

    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(senderEmail, senderPassword);
        }
    });

    try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(senderEmail));
        // Replace with the user's email
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("user@example.com"));
        message.setSubject(subject);
        message.setText(body);

        Transport.send(message);

        System.out.println("Notification email sent successfully!");

    } catch (MessagingException e) {
        e.printStackTrace();
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

        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton22 = new javax.swing.JButton();
        jTextField10 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton3.setText("ADD STOCK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(670, 510, 130, 23);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProductCode", "ProductName", "Manufacturing Date:", "Expiry Date", "Quantity", "Cost Price", "Selling Price"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(32, 163, 851, 345);

        jButton22.setText("ENTER");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton22);
        jButton22.setBounds(714, 134, 72, 23);

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField10);
        jTextField10.setBounds(263, 134, 321, 22);

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("PRODUCT ID");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(73, 137, 90, 16);

        jButton1.setText("VIEW CURRENT STOCK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(110, 510, 180, 23);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesandicons/icons8-bell-48.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(829, 0, 54, 55);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesandicons/icons8-ellipsis-48.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(889, 0, 31, 25);

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesandicons/icons8-manager-50.png"))); // NOI18N
        jLabel3.setText("INVENTORY/STOCK");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(290, 50, 400, 60);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesandicons/Red Blue & White Remembrance Flower Memorial Day Instagram Post.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 940, 580);

        setSize(new java.awt.Dimension(954, 585));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        try {
            String productID = jTextField10.getText();
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();

            // Clear existing rows in the table
            tableModel.setRowCount(0);

            String selectQuery = "SELECT * FROM product where productID = ? ";

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos", "root", "Nkoli1510");
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

            // Execute the query and process the results
            preparedStatement.setString(1, productID);

            ResultSet resultSet = preparedStatement.executeQuery();

            // Iterate through the result set and add rows to the tableModel
            while (resultSet.next()) {
                //column count
                Object[] row = new Object[7];

                // Replace "columnName1", "columnName2", ... with actual column names
                row[0] = resultSet.getObject("productID");
                row[1] = resultSet.getObject("Name");
                row[2] = resultSet.getObject("Man_D");
                row[3] = resultSet.getObject("Exp_D");
                row[4] = resultSet.getObject("Quantity");
                row[5] = resultSet.getObject("CostPrice");
                row[6] = resultSet.getObject("SellingPrice");
                // Add more columns as needed
                tableModel.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();

            // Clear existing rows in the table
            tableModel.setRowCount(0);

            String selectQuery = "SELECT * FROM product";

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos", "root", "Nkoli1510");
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

            // Execute the query and process the results
            ResultSet resultSet = preparedStatement.executeQuery();

            // Iterate through the result set and add rows to the tableModel
            while (resultSet.next()) {
                int quantity = resultSet.getInt("Quantity");

                // If quantity is less than or equal to zero, remove the item from the database
                if (quantity <= 0) {
                    String deleteQuery = "DELETE FROM product WHERE productID = ?";
                    PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
                    deleteStatement.setInt(1, resultSet.getInt("productID"));
                    deleteStatement.executeUpdate();
                    continue;  // Skip processing this item in the table if removed from the database
                }

                Object[] row = new Object[7];

                row[0] = resultSet.getObject("productID");
                row[1] = resultSet.getObject("Name");
                row[2] = resultSet.getObject("Man_D");
                row[3] = resultSet.getObject("Exp_D");
                row[4] = resultSet.getObject("Quantity");
                row[5] = resultSet.getObject("CostPrice");
                row[6] = resultSet.getObject("SellingPrice");

                if (quantity < 5) {
                    // Display a message indicating low stock
                    /* showLowStockAlert(resultSet.getString("Name"), quantity);*/
                    sendLowStockEmail(resultSet.getString("Name"), quantity, Email); // Replace with the actual recipient email address
                }

                if (resultSet.getString("Name") != null && Email != null) {
                    //  notificationsList.add("Low Stock Alert: " + resultSet.getString("Name") + " has only " + quantity + " units remaining.");
                }

                tableModel.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

        }

        private void sendLowStockEmail(String productName, int quantity, String recipientEmail) {
            if (productName != null && recipientEmail != null) {
                String senderEmail = "arinzechiadaobiada@gmail.com";
                String senderPassword = "reug vplu ikqf mpbg";
                String subject = "Low Stock Alert";
                String body = "Product: " + productName + "\nQuantity: " + quantity;

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
                    message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
                    message.setSubject(subject);
                    message.setText(body);

                    // Send the message
                    Transport.send(message);

                    System.out.println("Email sent successfully!");

                } catch (MessagingException e) {
                    e.printStackTrace();
                }

                System.out.println("Email sent successfully!");
            } else {
                System.out.println("Product name or recipient email is null.");
            }

            // TODO add your handling code here:*/
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        showNotification();
        showExpirationNotification();

        /* System.out.println("notificationsList contents: " + notificationsList);
        this.dispose();
        /* notifications notificationsFrame = new notifications(notificationsList);
        notificationsFrame.setVisible(true);*/
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
Product Login2 = new Product();
        Login2.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField10;
    // End of variables declaration//GEN-END:variables
}
