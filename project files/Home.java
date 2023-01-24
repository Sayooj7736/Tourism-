package project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Home implements ActionListener{
	public JFrame frame;
	public JButton viewbutton;
	public JButton packbutton;
	public JButton hotbutton;
	public JButton abtbutton;
	public JButton logbutton;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
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
		
		//add button(dummy)
		viewbutton = new JButton("DashBoard");
		viewbutton.setForeground(Color.WHITE);
		viewbutton.setBackground(Color.BLACK);
		viewbutton.setFont(new Font("Tahoma", Font.BOLD, 9));
		viewbutton.setBounds(0, 0, 91, 83);
		viewbutton.addActionListener(this);
		frame.getContentPane().add(viewbutton);
		
		/*add button for book package
		 * set background and foreground color
		 * set location
		 * add actionlistener for button to work
		 * add button into the frame
		 */
		packbutton = new JButton("package");
		packbutton.setForeground(Color.WHITE);
		packbutton.setBackground(Color.BLACK);
		packbutton.setBounds(0, 94, 91, 83);
		packbutton.addActionListener(this);
		frame.getContentPane().add(packbutton);
		
		/*add button for book hotels
		 * set background and foreground color
		 * set location
		 * add actionlistener for button to work
		 * add button into the frame
		 */
		hotbutton = new JButton("hotels");
		hotbutton.setForeground(Color.WHITE);
		hotbutton.setBackground(Color.BLACK);
		hotbutton.setBounds(0, 188, 91, 83);
		hotbutton.addActionListener(this);
		frame.getContentPane().add(hotbutton);
		
		/*add button for to show the about of this application
		 * set background and foreground color
		 * set font style
		 * set location
		 * add actionlistener for button to work
		 * add button into the frame
		 */
		abtbutton = new JButton("about us");
		abtbutton.setForeground(Color.WHITE);
		abtbutton.setBackground(Color.BLACK);
		abtbutton.setFont(new Font("Tahoma", Font.BOLD, 11));
		abtbutton.setBounds(0, 285, 91, 83);
		abtbutton.addActionListener(this);
		frame.getContentPane().add(abtbutton);
		
		/*add button for logout
		 * set background and foreground color
		 * set font style
		 * set location
		 * add actionlistener for button to work
		 * add button into the frame
		 */
		logbutton = new JButton("logout");
		logbutton.setForeground(Color.WHITE);
		logbutton.setBackground(Color.BLACK);
		logbutton.setFont(new Font("Tahoma", Font.BOLD, 11));
		logbutton.setBounds(0, 379, 91, 83);
		logbutton.addActionListener(this);
		frame.getContentPane().add(logbutton);
		
		/*add background image for home page
		 * add image
		 * set location
		 * add label into the frame
		 */
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("C:\\Users\\sayooj.p\\Desktop\\Project Docs\\Home2.png"));
		background.setBounds(101, 0, 726, 468);
		frame.getContentPane().add(background);
		
	}
	
	//To add functionality to buttons

	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*add functionality to package button
		 * when click this button, then it navigate to package page
		 */
		if(e.getSource()==packbutton) {
			frame.dispose();
			Package pack = new Package();
			pack.frame.setVisible(true);
		}
		
		/*add functionality to hotel button
		 * when click this button, then it navigate to hotel page
		 */
		if(e.getSource()==hotbutton) {
			frame.dispose();
			Hotel hotel = new Hotel();
			hotel.frame.setVisible(true);
		}
		
		/*add functionality to logout button
		 * when click this button, then it navigate to userlogin page
		 */
		if(e.getSource()==logbutton) {
			frame.dispose();
			UserLogin user = new UserLogin();
			user.frame.setVisible(true);
		}
		
		/*add functionality to about button
		 * when click this button, then it navigate to about page
		 */
		if(e.getSource()==abtbutton) {
			frame.dispose();
			About abt = new About();
			abt.frame.setVisible(true);
		}
		
		
	}
}
