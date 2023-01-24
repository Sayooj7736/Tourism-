package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.*;

import javax.swing.*;

public class Signup implements ActionListener{
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/tourism";

	public JFrame frame;
	public JTextField textField;
	public JPasswordField passwordField;
	public JButton btnSignup;
	public JButton backbutton;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup window = new Signup();
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
	public Signup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		/*add new jframe
		 * set bg color
		 * set exact location(bounds)
		 * set frame size as not editable 
		 */
		frame =  new JFrame();
		frame.getContentPane().setBackground(new Color(0, 204, 204));
		frame.setBounds(100, 100, 833, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);		
		frame.getContentPane().setLayout(null);
		
		/*add label for set text as signup(heading)
		 * set font style
		 * set text alignment
		 * set location
		 * add label into the frame
		 */
		JLabel signlabel = new JLabel("SIGNUP");
		signlabel.setFont(new Font("Arial Black", Font.BOLD, 18));
		signlabel.setHorizontalAlignment(SwingConstants.CENTER);
		signlabel.setBounds(272, 55, 284, 109);
		frame.getContentPane().add(signlabel);
		
		/*add label for set text as username
		 * set text alignment
		 * set font style
		 * set location
		 * add label into the frame
		 */
		JLabel userlabel = new JLabel("Username");
		userlabel.setHorizontalAlignment(SwingConstants.CENTER);
		userlabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		userlabel.setBounds(272, 175, 118, 26);
		frame.getContentPane().add(userlabel);
		
		/*add label for set text as password
		 * set text alignment
		 * set font style
		 * set location
		 * add label into the frame
		 */
		JLabel passlabel = new JLabel("Password");
		passlabel.setHorizontalAlignment(SwingConstants.CENTER);
		passlabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		passlabel.setBounds(272, 228, 118, 26);
		frame.getContentPane().add(passlabel);
		
		/*add text field for give an input(username)
		 * set location
		 * add text field into the frame
		 */
		textField = new JTextField();
		textField.setBounds(432, 175, 124, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		/*add password field for give an input(password)
		 * set location
		 * add password field into the frame
		 */
		passwordField = new JPasswordField();
		passwordField.setBounds(432, 233, 124, 20);
		frame.getContentPane().add(passwordField);
		
		/*add button for navigate to previous page
		 * add actionlistener for button to work
		 * set location
		 * add button into the frame
		 */
		backbutton = new JButton("Back");
		backbutton.addActionListener(this);
		backbutton.setBounds(301, 303, 89, 23);
		frame.getContentPane().add(backbutton);
		
		/*add button for registration
		 * set location
		 * add actionlistener for button to work
		 * add button into the frame
		 */
		btnSignup = new JButton("Signup");
		btnSignup.setBounds(432, 303, 89, 23);
		btnSignup.addActionListener(this);
		frame.getContentPane().add(btnSignup);
		
	}

	
   //To add functionality to buttons
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*Add functionality to backbutton
		 * when click the button, then it navigate to tourism page
		 */
        if(e.getSource()==backbutton) {
            frame.dispose();
            Tourism tourism = new Tourism();
            tourism.frame.setVisible(true);
        } 
        
        /*Button connect with JDBC
         * when click this button, data will be stored in database
         */
        if(e.getSource()==btnSignup) {

                  String username = textField.getText();
                  String password = passwordField.getText();

          //password needs should be 8-11 digits
          if(passwordField.getPassword().length>7 && passwordField.getPassword().length<12 && textField.getText().length()>4) {
        	  

            try {
                   Class.forName(JDBC_DRIVER); 
                   String dbUsername = "root";
                   String dbPassword = "@Sayooj123";

                   Connection conn = DriverManager.getConnection(DB_URL, dbUsername, dbPassword);
                   Statement stmt = conn.createStatement();
                   String sql1 = "INSERT INTO login"+" (username, password)"+" VALUES ( '"+ username + "','" + password + "')";         
                      stmt.executeUpdate(sql1);

                      stmt.close();
                   conn.close();

 

        } catch (SQLException ex) {
          ex.printStackTrace();
      } catch (ClassNotFoundException e1) {

        e1.printStackTrace();
    }
     
               JOptionPane.showMessageDialog(null, "Account created successfully!");
            frame.dispose();
               UserLogin user=new UserLogin();
               user.frame.setVisible(true);
               }
         else{
           JOptionPane.showMessageDialog(null, "Enter valid username or password."); }
          }

	}
}
