import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class feedet extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField textField, textField_1;
    private JTable data_table;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    feedet window = new feedet();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public feedet() {
        initialize();
    }
    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(SystemColor.menu);
        setBounds(100, 100, 748, 501);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("View Your Fee Status");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(206, 22, 236, 26);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Enter your Student id:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(209, 80, 207, 26);
        getContentPane().add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBackground(SystemColor.text);
        textField.setBounds(206, 116, 255, 26);
        getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Enter Your Fee account no :");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNewLabel_2.setBounds(235, 173, 215, 32);
        getContentPane().add(lblNewLabel_2);

        textField_1 = new JTextField();
        textField_1.setBounds(173, 215, 288, 26);
        getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JButton btnNewButton = new JButton("View Status");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnNewButton.setBounds(157, 269, 123, 26);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "hr", "9495558676Th#");
                    PreparedStatement st = conn.prepareStatement(
                            "Select fee_paid,amount_due,due_date,last_fee_paid_date  from fee_det where st_id=? and fee_id=?");
                    String st_id = textField.getText();
                    String fee_id = textField_1.getText();

                    st.setString(1, st_id);
                    st.setString(2, fee_id);
                    ResultSet rs = st.executeQuery();

                    if (!rs.isBeforeFirst()) {
                        System.out.println("No data found for the given student ID and hall ticket number.");
                    } else {
                        System.out.println("Data found, displaying results:");
                        DefaultTableModel model = new DefaultTableModel();

                        model.addColumn("Fee Paid Amount");
                        model.addColumn("Amount Due");
                        model.addColumn("Amount Paid Date");
                        model.addColumn("Due Date");

                        while (rs.next()) {
                            Object[] rowData = new Object[] { rs.getString("fee_paid"), rs.getString("amount_due"),
                                    rs.getString("due_date"), rs.getString("last_fee_paid_date") };
                            model.addRow(rowData);
                        }

                        data_table.setModel(model);
                        System.out.println("View Successful !!!!!!!!!!!!!!!");
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        getContentPane().add(btnNewButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(4, 321, 730, 133);
        getContentPane().add(scrollPane);

        data_table = new JTable();
        scrollPane.setViewportView(data_table);
        data_table.setBackground(SystemColor.WHITE);

        JButton btnNewButton_1 = new JButton("Go Back");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dashboard d3 = new Dashboard();
                d3.setVisible(true);
                dispose(); // Close the current frame
            }
        });
        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnNewButton_1.setBounds(316, 269, 130, 27);
        getContentPane().add(btnNewButton_1);
    }
}
