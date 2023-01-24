package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AHome implements ActionListener{

	public  JFrame frame;
	public JLabel NewLabel1;
	public JLabel NewLabel2;
	public JButton bdbuttons;
	public JButton lbutton;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AHome window = new AHome();
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
	public AHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		/*add new jframe
		 * set bg color
		 * set exact location(bounds)
		 * set frame size as not editable 
		 */
		frame =  new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 833, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);		
		frame.getContentPane().setLayout(null);
		
		/*add label for set heading as tourism management
		 * set font style
		 * set text alignment
		 * set text location
		 * add label into the frame
		 */
		NewLabel1 = new JLabel("Tourism Management");
		NewLabel1.setFont(new Font("Tahoma", Font.BOLD, 21));
		NewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		NewLabel1.setBounds(220, 29, 391, 35);
		frame.getContentPane().add(NewLabel1);
		
		/*add label for set background image 
		 * select bg image
		 * set location
		 * add bg image into the frame
		 */
		NewLabel2 = new JLabel("");
		NewLabel2.setIcon(new ImageIcon("C:\\Users\\sayooj.p\\Desktop\\Project Docs\\Ahome Bg.png"));
		NewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		NewLabel2.setBounds(105, 54, 619, 280);
		frame.getContentPane().add(NewLabel2);
		
		/*add button for navigate to booked data
		 * set location for button
		 * add actionlistener for button to work
		 * add button into the frame
		 */
		bdbuttons = new JButton("Booked Data");
		bdbuttons.setBounds(189, 377, 118, 40);
		bdbuttons.addActionListener(this);
		frame.getContentPane().add(bdbuttons);
		
		/*add button for logout
		 * set button location
		 * add actionlistener for button to work
		 * add button into the frame
		 */
		lbutton = new JButton("Logout");
		lbutton.setBounds(522, 377, 118, 40);
		lbutton.addActionListener(this);
		frame.getContentPane().add(lbutton);
		
	}

	//Add functionality to buttons
	@Override
	public void actionPerformed(ActionEvent e) {
		/*add functionality to booked data button
		 * when click button it redirects to BookedData page
		 */
		if(e.getSource()==bdbuttons) {
			frame.dispose();
			BookedData bd = new BookedData();
			bd.frame.setVisible(true);
		}
		/*add functionality to logout button
		 *  when click logout button thn it redirects to admin login page
		 */
		if(e.getSource()==lbutton) {
			frame.dispose();
			AdminLogin al = new AdminLogin();
			al.frame.setVisible(true);
		}
		
	}
}