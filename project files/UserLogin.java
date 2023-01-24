package project;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JPasswordField;

public class UserLogin implements ActionListener{
	
	 static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	 static final String DB_URL = "jdbc:mysql://localhost/tourism";

	public JFrame frame;
	public JTextField textField;
	public JPasswordField passwordField;
	public JButton Lbutton;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin window = new UserLogin();
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
	public UserLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		

		/*add new jframe
		 * set exact location(bounds)
		 * set frame size as not editable 
		 */
		frame = new JFrame();
		frame.setBounds(100, 100, 833, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);		
		frame.getContentPane().setLayout(null);
		
		/*add label for set text as username
		 * set font style
		 * set text alignment
		 * set location
		 * add label into the frame
		 */
		JLabel userlabel = new JLabel("Username");
		userlabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		userlabel.setHorizontalAlignment(SwingConstants.CENTER);
		userlabel.setBounds(365, 171, 96, 22);
		frame.getContentPane().add(userlabel);
		
		/*add label for set text as password
		 * set text alignment
		 * set text font style
		 * set location
		 * add label into the frame
		 */
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblPassword.setBounds(365, 225, 96, 22);
		frame.getContentPane().add(lblPassword);
		
		/*add text field for give an input(username)
		 * set location
		 * add text field into the frame
		 */
		textField = new JTextField();
		textField.setBounds(471, 171, 161, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		/*add button for login and design
		 * set location
		 * add actionlistener for button to work
		 * add button into the frame
		 */
		Lbutton = new JButton("Login");	
		Lbutton.setBounds(508, 278, 89, 29);
		Lbutton.addActionListener(this);
		frame.getContentPane().add(Lbutton);
		
		/*add password field for give an input in the form of password
		 * set location
		 * add password field into the frame
		 */
		passwordField = new JPasswordField();
		passwordField.setBounds(471, 225, 161, 20);
		frame.getContentPane().add(passwordField);
		
		/*add background image for login page
		 * set location
		 * add label into the frame
		 */
		JLabel background = new JLabel(" ");
		background.setIcon(new ImageIcon("C:\\Users\\sayooj.p\\Desktop\\Project Docs\\LoginBg.png"));
		background.setBounds(0, 0, 827, 468);
		frame.getContentPane().add(background);
		
	}
 
	//To add functionality to buttons
	@Override
	public void actionPerformed(ActionEvent e) {
			String username = textField.getText();
	        String  password = new String( passwordField.getPassword());
	        
	      /*Button connect with database
	       * when click this button, check username and password using JDBC
	       * if the credentials is right, then it navigate to home page
	       */
	            if(e.getSource()==Lbutton) {
	            	
	                 try {
	                        Class.forName(JDBC_DRIVER);
	                        //String url = "jdbc:mysql://localhost:3306/tourism";
	                        String dbUsername = "root";
	                        String dbPassword = "@Sayooj123";

	                        Connection conn = DriverManager.getConnection(DB_URL, dbUsername, dbPassword);
	                        Statement stmt = conn.createStatement();
	                        String sql = "SELECT * FROM login WHERE username = '" + username + "' AND password = '" + password + "'";
	                        ResultSet rs = stmt.executeQuery(sql);

	
	                        if(rs.next()){
	                            JOptionPane.showMessageDialog(null, "Login successful!");
	                            frame.dispose();
	                            Home home=new Home();
	                            home.frame.setVisible(true);
	                        }else{
	                            JOptionPane.showMessageDialog(null, "Invalid username or password.");
	                            textField.setText("");
	                            passwordField.setText("");
	                        }
	                    } catch (SQLException ex) {
	                        ex.printStackTrace();
	                    } catch (ClassNotFoundException e1) {

	                        e1.printStackTrace();
	                    }
	                }
		}
	            }
			
		
		
	
	

