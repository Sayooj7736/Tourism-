package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class About implements ActionListener{
	
	JFrame frame;
	JButton backb;
	TextArea t1;
    String A;
    
    /**
	 * Launch the application.
	 */
    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About window = new About();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }

    
    public About() {
    	

		/*add new jframe
		 * set bg color
		 * set exact location(bounds)
		 * set frame size as not editable 
		 */
    	frame = new JFrame();
    	frame.getContentPane().setBackground(new Color(0, 204, 204));
		frame.setBounds(100, 100, 833, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);		
		frame.getContentPane().setLayout(null);	
		
		//add texts to the screen
    	
    	A = "About Projects          \n  "
    			+ "\nThis app developed by Team1. Using this app you can book"
    			+ " hotel and tour packs"
    			;
    	TextArea t1 = new TextArea(A, 10, 40, Scrollbar.VERTICAL);
        t1.setEditable(false);
        t1.setBounds(200, 100, 450, 300);
        frame.add(t1);
        
        /*add button for navigate to previous page
         * set location
         * add actionlistener for button to work
         * add button into the frame
         */
        backb = new JButton("Back");
        backb.setBounds(356, 415, 118, 40);
        backb.addActionListener(this);
        frame.getContentPane().add(backb);
    }


  //To add functionality to buttons
    
	@Override
	public void actionPerformed(ActionEvent e) {
		/*add functionality to back button
		 * when click this button, it will be navigate to home page
		 */
		if(e.getSource()==backb) {
			frame.dispose();
			Home home = new Home();
			home.frame.setVisible(true);
		}
	}
}
