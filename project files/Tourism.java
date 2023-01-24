package project;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Tourism implements ActionListener{
	public JFrame frame;
	public JButton Lbutton;
	public JButton Sbutton;
	public JButton Qbutton;

	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tourism window = new Tourism();
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
	
	public Tourism() {
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
		
		/*this is for heading
		 * set font style
		 * set text alignment
		 * set text location
		 * add label into the frame
		 */
		JLabel head = new JLabel("Login");
		head.setFont(new Font("Arial Black",Font.BOLD,24));
		head.setHorizontalAlignment(SwingConstants.CENTER);
		head.setBounds(420, 86, 218, 82);
		frame.getContentPane().add(head);
		
		/*create login button and design
		 * set location
		 * add actionlistener for button to work
		 * add button into the frame
		 */
		Lbutton = new JButton("Login");
		Lbutton.setBounds(477, 222, 107, 29);
		Lbutton.addActionListener(this);
		frame.getContentPane().add(Lbutton);
		
		/*create signup button and design
		 * set location
		 * add actionlistener for button to work
		 * add button into the frame
		 */
		Sbutton = new JButton("Signup");
		Sbutton.setBounds(477, 276, 107, 29);
		Sbutton.addActionListener(this);
		frame.getContentPane().add(Sbutton);
		
		/*create quit button and design
		 * set location
		 * add actionlistener for button to work
		 * add button into frame
		 */
		Qbutton = new JButton("Quit");
		Qbutton.setBounds(477, 330, 107, 29);
		Qbutton.addActionListener(this);
		frame.getContentPane().add(Qbutton);
		
		/*Add background image for the page
		 * select image for bg
		 * set location
		 * add label into the frame
		 */
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("C:\\\\Users\\\\sayooj.p\\\\Desktop\\\\Project Docs\\\\LoginBg.png"));
		background.setBounds(0, 0, 827, 468);
		frame.getContentPane().add(background);
	}
	
	//To add functionality to buttons

	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*Add functionality to login button
		 * when click this button, it navigate to login page
		 */
		if(e.getSource()==Lbutton) {
			frame.dispose();
			UserLogin ulogin = new UserLogin();
			ulogin.frame.setVisible(true);	

			}
		
		/*Add functionality to signup button
		 * when click this button, it navigate to signup page
		 */
		if(e.getSource()==Sbutton) {
			frame.dispose();
			Signup sig = new Signup();
			sig.frame.setVisible(true);
		}
		
		/*Add functionality to quit button
		 * when click this button, app will close
		 */
		if(e.getSource()==Qbutton) {
			frame.dispose();
		}
	}
	
	
}
