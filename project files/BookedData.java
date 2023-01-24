package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BookedData implements ActionListener{
	
	public JFrame frame;
	public JButton vp;
	public JButton vh;
	public JButton backb;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookedData window = new BookedData();
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
	public BookedData() {
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
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 833, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
        /*add button for package
         * set button location
         * add actionlistener for button to work
         * add button into the frame
         */
        vp = new JButton("Package");
        vp.setBounds(225, 177, 121, 103);
        vp.addActionListener(this);
        frame.getContentPane().add(vp);
        
        /*add button for hotels
         * set button location
         * add actionlistener for button to work
         * add button into the frame 
         */
        vh = new JButton("Hotels");
        vh.setBounds(455, 177, 121, 103);
        vh.addActionListener(this);
        frame.getContentPane().add(vh);
        
        /*add home/back button
         * set button location 
         * add actionlistener for button to work
         * add button into the frame
         */
        backb = new JButton("Home");
        backb.setBounds(0,0,118,40);
        backb.addActionListener(this);
        frame.getContentPane().add(backb);
	}
	
	//Add functionality to buttons
	@Override
	public void actionPerformed(ActionEvent e) {
		//if click this button, it navigate to BookedPackage page
		if(e.getSource()==vp) {
			frame.dispose();
			BookedP bp = new BookedP();
			bp.frame.setVisible(true);
		}
		//if click this button, it navigate to BookedHotel page
		if(e.getSource()==vh) {
			frame.dispose();
			BookedH bh = new BookedH();
			bh.frame.setVisible(true);
		}
		//if click this button, it navigate to home page
		if(e.getSource()==backb) {
			frame.dispose();
			AHome ahome = new AHome();
			ahome.frame.setVisible(true);
		}
		
	}
	
}
