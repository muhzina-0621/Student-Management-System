import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Dashboard extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Dashboard window = new Dashboard();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Dashboard() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        setTitle("Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 501, 316);
        getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("WELCOME !");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblNewLabel.setBounds(21, 10, 205, 27);
        getContentPane().add(lblNewLabel);
        
        JButton btnNewButton = new JButton("View Grades");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		gradeview g=new gradeview();
        		g.setVisible(true);
        		dispose();
        	}
        });
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnNewButton.setBounds(101, 66, 205, 32);
        getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("View Fee Status");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		feedet f1=new feedet();
        		f1.setVisible(true);
        		dispose();
        	}
        });
        btnNewButton_1.setBackground(new Color(255, 255, 255));
        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
        btnNewButton_1.setBounds(101, 119, 205, 32);
        getContentPane().add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Change Password");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ChangePassword c1=new ChangePassword();
        		c1.setVisible(true);
        		dispose();
        	}
        });
        btnNewButton_2.setBackground(new Color(255, 255, 255));
        btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
        btnNewButton_2.setBounds(102, 177, 204, 32);
        getContentPane().add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("ADD-Ons");
        btnNewButton_3.setBackground(new Color(255, 255, 255));
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		jtableofcus j11=new jtableofcus();
        		j11.setVisible(true);
        		dispose();
        	}
        });
        btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 19));
        btnNewButton_3.setBounds(101, 228, 205, 27);
        getContentPane().add(btnNewButton_3);
    }
}
