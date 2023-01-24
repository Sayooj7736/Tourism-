package project;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.*;
import javax.swing.*;

public class AdminLogin implements ActionListener{
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/tourism";

	public JFrame frame;
	public JTextField utext;
	public JPasswordField ptext;
	public JButton lbutton;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
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
	public AdminLogin() {
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
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setBounds(100, 100, 833, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);		
		frame.getContentPane().setLayout(null);
		
		/*add label for set heading as admin
		 * set font style for text
		 * set text alignment
		 * set exact location
		 * add label into the frame
		 */
		JLabel hlabel = new JLabel("Admin");
		hlabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		hlabel.setHorizontalAlignment(SwingConstants.CENTER);
		hlabel.setBounds(310, 42, 233, 77);
		frame.getContentPane().add(hlabel);
		
		/*add label for set text as username
		 * set font style for text
		 * set text alignment
		 * set exact location
		 * add label into the frame
		 */
		JLabel ulabel = new JLabel("Username");
		ulabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		ulabel.setHorizontalAlignment(SwingConstants.CENTER);
		ulabel.setBounds(253, 178, 154, 32);
		frame.getContentPane().add(ulabel);
		
		/*add label for set text as password
		 * set font style for text
		 * set text alignment
		 * set exact location
		 * add label into the frame
		 */	
		JLabel plabel = new JLabel("Password");
		plabel.setHorizontalAlignment(SwingConstants.CENTER);
		plabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		plabel.setBounds(253, 248, 154, 32);
		frame.getContentPane().add(plabel);
		
		/*add button for login
		 * set location for button
		 * add actionlistener for button to work 
		 * add button into the frame
		 */
		lbutton = new JButton("Login");
		lbutton.setBounds(379, 344, 95, 32);
		lbutton.addActionListener(this);
		frame.getContentPane().add(lbutton);
		
		/*add text field for give an input
		 * set text field location
		 * add textfield into the frame
		 */
		utext = new JTextField();
		utext.setBounds(476, 184, 152, 24);
		frame.getContentPane().add(utext);
		utext.setColumns(10);
		
		/*add button for give an input
		 * set password field location
		 * add password field into the frame
		 */
		ptext = new JPasswordField();
		ptext.setColumns(10);
		ptext.setBounds(476, 256, 152, 24);
		frame.getContentPane().add(ptext);
		
	}
	
	//Add functionality to buttons

	@Override
	public void actionPerformed(ActionEvent e) {
		String username = utext.getText();
        String  password = ptext.getText();
        /*button connect with JDBC
         *  when click button it check the username and password using jdbc
         *  if that is correct then it navigate to the admin home page
         */
            if(e.getSource()==lbutton) {
            	
                 try {
                        Class.forName(JDBC_DRIVER);
                        String dbUsername = "root";
                        String dbPassword = "@Sayooj123";

                        Connection conn = DriverManager.getConnection(DB_URL, dbUsername, dbPassword);
                        Statement stmt = conn.createStatement();
                        String sql = "SELECT * FROM admin WHERE username = '" + username + "' AND password = '" + password + "'";
                        ResultSet rs = stmt.executeQuery(sql);


                        if(rs.next()){
                            JOptionPane.showMessageDialog(null, "Login successful!");
                            frame.dispose();
                            AHome ahome = new AHome();
                            ahome.frame.setVisible(true);       
                            }else{
                            JOptionPane.showMessageDialog(null, "Invalid username or password.");
                            utext.setText("");
                            ptext.setText("");
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException e1) {

                        e1.printStackTrace();
                    }
                }
	}
}