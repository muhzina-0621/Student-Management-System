import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class gradeview extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTable data_table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    gradeview window = new gradeview();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public gradeview() {
        initialize();
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 748, 501);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.menu);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("View Your Grades");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel.setBounds(206, 22, 236, 26);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Enter your Student id:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(209, 80, 207, 26);
        contentPane.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBackground(SystemColor.text);
        textField.setBounds(206, 116, 255, 26);
        contentPane.add(textField);

        JLabel lblNewLabel_2 = new JLabel("Enter your hall ticket no :");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNewLabel_2.setBounds(235, 173, 215, 32);
        contentPane.add(lblNewLabel_2);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(173, 215, 288, 26);
        contentPane.add(textField_1);

        JButton btnNewButton = new JButton("View Grades");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnNewButton.setBounds(126, 271, 123, 26);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "hr","9495558676Th#");
                    PreparedStatement st = conn.prepareStatement(
                            "Select program_name,course1,course2,course3,course4,course5,practical1,practical2  from grades where st_id=? and g_id=?");
                    String st_id = textField.getText();
                    String g_id = textField_1.getText();

                    st.setString(1, st_id);
                    st.setString(2, g_id);
                    ResultSet rs = st.executeQuery();

                    if (!rs.isBeforeFirst()) {
                        System.out.println("No data found for the given student ID and hall ticket number.");
                    } else {
                        System.out.println("Data found, displaying results:");
                        DefaultTableModel model = new DefaultTableModel();
                        model.addColumn("Program Name");
                        model.addColumn("Course 1");
                        model.addColumn("Course 2");
                        model.addColumn("Course 3");
                        model.addColumn("Course 4");
                        model.addColumn("Course 5");
                        model.addColumn("Practical 1");
                        model.addColumn("Practical 2");

                        while (rs.next()) {
                            Object[] rowData = new Object[] { rs.getString("program_name"), rs.getString("course1"),
                                    rs.getString("course2"), rs.getString("course3"), rs.getString("course4"),
                                    rs.getString("course5"), rs.getString("practical1"), rs.getString("practical2") };
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
        contentPane.add(btnNewButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(4, 321, 730, 133);
        contentPane.add(scrollPane);

        data_table = new JTable();
        scrollPane.setViewportView(data_table);
        data_table.setBackground(SystemColor.WHITE);
        
        JButton btnNewButton_1 = new JButton("Go Back");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Dashboard d2=new Dashboard();
        		d2.setVisible(true);
        		dispose();
        	}
        });
        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnNewButton_1.setBounds(318, 271, 124, 26);
        contentPane.add(btnNewButton_1);
    }
}
