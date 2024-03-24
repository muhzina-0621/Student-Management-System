
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import net.proteanit.sql.DbUtils;

public class jtableofcus extends JFrame {

    private static final long serialVersionUID = 1L;
    //private JFrame frame;
    private JTable table;
    private JTextField courseNameField;
    private JTextField courseIdField;
    private JTextField platformField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    jtableofcus window = new jtableofcus();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public jtableofcus() {
        initialize();
    }

    private void initialize() {
        setTitle("Course Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 786, 669);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 128, 128));
        panel.setBounds(0, 0, 772, 125);
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Course Management");
        lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 30));
        lblNewLabel.setBounds(44, 28, 535, 69);
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(0, 122, 772, 510);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(112, 30, 509, 300);
        panel_1.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "Course ID", "Course Name", "Platform" }
        ));

        JButton btnAddCourse = new JButton("Add Course");
        btnAddCourse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[] { courseIdField.getText(), courseNameField.getText(), platformField.getText() });
            }
        });
        btnAddCourse.setFont(new Font("Cambria", Font.BOLD, 15));
        btnAddCourse.setBounds(60, 399, 230, 42);
        panel_1.add(btnAddCourse);

        JButton btnDeleteCourse = new JButton("Delete Course");
        btnDeleteCourse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int selectedRowIndex = table.getSelectedRow();
                if (selectedRowIndex != -1) {
                    model.removeRow(selectedRowIndex);
                }
            }
        });
        btnDeleteCourse.setFont(new Font("Cambria", Font.BOLD, 15));
        btnDeleteCourse.setBounds(458, 399, 230, 42);
        panel_1.add(btnDeleteCourse);

        courseIdField = new JTextField();
        courseIdField.setBounds(112, 350, 140, 25);
        panel_1.add(courseIdField);
        courseIdField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Course ID:");
        lblNewLabel_1.setBounds(40, 350, 80, 25);
        panel_1.add(lblNewLabel_1);

        courseNameField = new JTextField();
        courseNameField.setColumns(10);
        courseNameField.setBounds(352, 350, 140, 25);
        panel_1.add(courseNameField);

        JLabel lblNewLabel_2 = new JLabel("Course Name:");
        lblNewLabel_2.setBounds(270, 350, 100, 25);
        panel_1.add(lblNewLabel_2);

        platformField = new JTextField();
        platformField.setColumns(10);
        platformField.setBounds(592, 350, 140, 25);
        panel_1.add(platformField);

        JLabel lblNewLabel_3 = new JLabel("Platform:");
        lblNewLabel_3.setBounds(530, 350, 60, 25);
        panel_1.add(lblNewLabel_3);
        
        JButton btnGoBack = new JButton("Go Back");
        btnGoBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dashboard dashboard = new Dashboard();
                dashboard.setVisible(true);
                dispose();
            }
        });
        btnGoBack.setFont(new Font("Cambria", Font.BOLD, 15));
        btnGoBack.setBounds(258, 460, 230, 42);
        panel_1.add(btnGoBack);
    }
}
