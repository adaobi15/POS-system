/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.plot.PiePlot;

/**
 *
 * @author adaobi
 */
public class Sales extends javax.swing.JFrame {

    /**
     * Creates new form Sales
     */
    public Sales() {
        initComponents();
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
sendNotificationEmail("Expiration Date Alert", message.toString());
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

        jPanel1 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SALES");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jButton6.setBackground(new java.awt.Color(204, 0, 0));
        jButton6.setForeground(new java.awt.Color(204, 0, 51));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesandicons/icons8-bell-48.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(740, 10, 70, 50);

        jLabel1.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesandicons/icons8-performance-100.png"))); // NOI18N
        jLabel1.setText("SALES PERFORMANCE");
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(109, 6, 349, 50);

        jButton1.setText("Best Selling products");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(560, 140, 190, 23);

        jButton5.setText("CASHIER PERFROMANCE ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(560, 470, 190, 23);

        jButton2.setText("Daily Report");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(560, 210, 190, 23);

        jButton3.setText("Weekly Report");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(560, 300, 190, 23);

        jButton4.setText("Yearly Report");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(560, 390, 190, 23);

        jTable1.setBackground(new java.awt.Color(153, 0, 0));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setForeground(new java.awt.Color(102, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "productID", "Name", "Quantity", "Total"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(10, 110, 513, 402);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesandicons/Red Blue & White Remembrance Flower Memorial Day Instagram Post.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 820, 610);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-1, -5, 820, 570);

        setSize(new java.awt.Dimension(831, 568));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
      /*DefaultPieDataset  pieDataset = new DefaultPieDataset();
      pieDataset.setValue("One", new Integer(10));
      pieDataset.setValue("two", new Integer(20));
      pieDataset.setValue("three", new Integer(30));
      pieDataset.setValue("four", new Integer(40));
      JfreeChart chart = ChartFactory.createPieChart("pie chart", pieDataset ,true,true,true);
      PiePlot P =( PiePlot)chart.getPlot();
     // P.setForegroundAlpha (TOP_ALIGNMENT);
      ChartFrame frame = new ChartFrame("Pie Chart", chart);
      frame.setVisible(true);
      frame.setSizee(450,500);*/
      /*  try {
        // Establish database connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos", "root", "Nkoli1510");

        // Prepare the SQL query
        String selectQuery = "SELECT * FROM purchases ORDER BY Quantity DESC LIMIT 10"; // Get top 10 selling items
        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

        // Execute the query and process the results
        ResultSet resultSet = preparedStatement.executeQuery();

        // Get jTable model
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();

        // Clear existing data in the jTable
        tableModel.setRowCount(0);

        // Populate jTable with data from the result set
        while (resultSet.next()) {
            Object[] row = new Object[4]; // Assuming you have 7 columns

            // Populate the row with data from the result set
            row[0] = resultSet.getObject("productID");
            row[1] = resultSet.getObject("Name");
           // row[2] = resultSet.getObject("Exp_D");
            row[2] = resultSet.getObject("Quantity");
            row[3] = resultSet.getObject("Total");

            // Add the row to the jTable model
            tableModel.addRow(row);
        }

        // Close resources
        resultSet.close();
        preparedStatement.close();
        connection.close();
    } catch (Exception e) {
        e.printStackTrace(); // Handle exceptions appropriately in your application
    }*/
 // TODO add your handling code here:
 try {
    // Establish database connection
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos", "root", "Nkoli1510");

    // Prepare the SQL query
    String selectQuery = "SELECT productID, Name, Quantity ,Total FROM purchases ORDER BY Quantity DESC LIMIT 10"; // Get top 10 selling items
    PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

    // Execute the query and process the results
    ResultSet resultSet = preparedStatement.executeQuery();

    // Create dataset for the pie chart
    DefaultPieDataset pieDataset = new DefaultPieDataset();
    
    // Get jTable model
    DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();

    // Clear existing data in the jTable
    tableModel.setRowCount(0);

    while (resultSet.next()) {
        String productName = resultSet.getString("Name");
        int quantity = resultSet.getInt("Quantity");
        pieDataset.setValue(productName, quantity);
        
         
        // Populate jTable model
        Object[] row = new Object[4];
        row[0] = resultSet.getObject("productID");
        row[1] = resultSet.getObject("Name");
        row[2] = resultSet.getObject("Quantity");
        row[3] = resultSet.getObject("Total");
        tableModel.addRow(row);
    }
    
    // Create pie chart
    JFreeChart chart = ChartFactory.createPieChart("Top 10 Selling Items", pieDataset, true, true, true);
    PiePlot plot = (PiePlot) chart.getPlot();
    plot.setCircular(true); // Optional: Set circular layout

    // Display chart in a frame
    ChartFrame frame = new ChartFrame("Sales performances", chart);
    frame.pack();
    frame.setVisible(true);

    // Close resources
    resultSet.close();
    preparedStatement.close();
    connection.close();
} catch (Exception e) {
    e.printStackTrace(); // Handle exceptions appropriately in your application
}

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         try {
        // Establish database connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos", "root", "Nkoli1510");

        // Prepare the SQL query to get daily sales from the purchases table
    String selectQuery = "SELECT * FROM purchases WHERE DATE(purchaseTimestamp) = CURDATE()";

        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

        // Execute the query and process the results
        ResultSet resultSet = preparedStatement.executeQuery();

        // Get jTable model for reports
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();

        // Clear existing data in the jTable
        tableModel.setRowCount(0);

        // Populate jTable with data from the result set
        while (resultSet.next()) {
            Object[] row = new Object[4]; // Assuming you have 4 columns in your jTable2

            // Populate the row with data from the result set
            row[0] = resultSet.getObject("productID");
            row[1] = resultSet.getObject("Name");
            row[2] = resultSet.getObject("Quantity");
            row[3] = resultSet.getObject("SellingPrice");

            // Add the row to the jTable model
            tableModel.addRow(row);
        }

        // Close resources
        resultSet.close();
        preparedStatement.close();
        connection.close();
    } catch (Exception e) {
        e.printStackTrace(); // Handle exceptions appropriately in your application
    }
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       try {
    // Establish database connection
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos", "root", "Nkoli1510");

    // Calculate the start date of the week (assuming the week starts on Sunday)
    LocalDate currentDate = LocalDate.now();
    LocalDate startOfWeek = currentDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));

    // Prepare the SQL query to get weekly sales from the purchases table
    String selectQuery = "SELECT * FROM purchases WHERE DATE(purchaseTimestamp) BETWEEN ? AND ?";
    PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

    // Set the start and end dates for the past week
    preparedStatement.setDate(1, Date.valueOf(startOfWeek));
    preparedStatement.setDate(2, Date.valueOf(currentDate));

    // Execute the query and process the results
    ResultSet resultSet = preparedStatement.executeQuery();

    // Get jTable model for reports
    DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();

    // Clear existing data in the jTable
    tableModel.setRowCount(0);

    // Populate jTable with data from the result set
    while (resultSet.next()) {
        Object[] row = new Object[4]; // Assuming you have 4 columns in your jTable2

        // Populate the row with data from the result set
        row[0] = resultSet.getObject("productID");
        row[1] = resultSet.getObject("Name");
        row[2] = resultSet.getObject("Quantity");
        row[3] = resultSet.getObject("SellingPrice");

        // Add the row to the jTable model
        tableModel.addRow(row);
    }

    // Close resources
    resultSet.close();
    preparedStatement.close();
    connection.close();
} catch (Exception e) {
    e.printStackTrace(); // Handle exceptions appropriately in your application
}
 // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
try {
    // Establish database connection
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos", "root", "Nkoli1510");

    // Calculate the start date of the year
    LocalDate currentDate = LocalDate.now();
    LocalDate startOfYear = LocalDate.of(currentDate.getYear(), 1, 1);

    // Prepare the SQL query to get yearly sales from the purchases table
    String selectQuery = "SELECT * FROM purchases WHERE YEAR(purchaseTimestamp) = ?";
    PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

    // Set the year for the past year
    preparedStatement.setInt(1, currentDate.getYear());

    // Execute the query and process the results
    ResultSet resultSet = preparedStatement.executeQuery();

    // Get jTable model for reports
    DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();

    // Clear existing data in the jTable
    tableModel.setRowCount(0);

    // Populate jTable with data from the result set
    while (resultSet.next()) {
        Object[] row = new Object[4]; // Assuming you have 4 columns in your jTable2

        // Populate the row with data from the result set
        row[0] = resultSet.getObject("productID");
        row[1] = resultSet.getObject("Name");
        row[2] = resultSet.getObject("Quantity");
        row[3] = resultSet.getObject("SellingPrice");

        // Add the row to the jTable model
        tableModel.addRow(row);
    }

    // Close resources
    resultSet.close();
    preparedStatement.close();
    connection.close();
} catch (Exception e) {
    e.printStackTrace(); // Handle exceptions appropriately in your application
}
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
     this.dispose();
        new  sales_perfomance ().setVisible(true);  // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
showNotification();
        showExpirationNotification();  
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
