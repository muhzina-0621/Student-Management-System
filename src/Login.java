import java.awt.*;
import javax.swing.*;

import java.awt.Color;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel loginl1 = new JLabel("LOGIN");
		loginl1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		loginl1.setBounds(182, 21, 98, 34);
		frame.getContentPane().add(loginl1);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(54, 79, 125, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(54, 143, 125, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(153, 77, 206, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton.setBounds(140, 198, 140, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","hr","9495558676Th#");
					 PreparedStatement st = (PreparedStatement) conn.prepareStatement("Select st_id, password from Student_det where st_id=? and password=?");
					 String st_id = textField.getText();
					char[] charArray = passwordField.getPassword();
					String password = new String(charArray);
					 st.setString(1, st_id);
	                 st.setString(2, password);
	                 ResultSet rs = st.executeQuery();
	                 if (rs.next()) {
	                	
	                     System.out.println("Login Successful !!!!!!!!!!!!!!!");
	                     Dashboard d=new Dashboard();
	                     d.setVisible(true);
	                     
	                     
	                 } else {
	                	 System.out.println("Login not  Successful !!!!!!!!!!!!!!!");
	                 }
				}catch (SQLException sqlException) {
	                sqlException.printStackTrace();
	            }catch (ClassNotFoundException e1) {
	                e1.printStackTrace();
	            }
			
			
		}
		});
		frame.getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(153, 143, 206, 23);
		frame.getContentPane().add(passwordField);
	}
		
}