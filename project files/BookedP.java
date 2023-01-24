package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class BookedP implements ActionListener{
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/tourism";
	
	public JFrame frame;
	public JTable table;
	public JButton viewb;
	public JButton backb;
	public JButton delbutton;
	public JTextField phtext;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookedP window = new BookedP();
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
	public BookedP() {
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
		
		
		/*add scrollpane for jtable
		 * set location
		 * add scrollpane into the frame
		 */
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setBounds(74, 51, 688,310);
		frame.getContentPane().add(scrollpane);
		
		table = new JTable();
		scrollpane.setViewportView(table);
		
		/*add button for delete data from database
		 * set button location
		 * add actionlistener for button to work
		 * add button into the frame
		 */
		delbutton = new JButton("Delete");
		delbutton.setBounds(478, 395, 100, 29);
		delbutton.addActionListener(this);
		frame.getContentPane().add(delbutton);
		
		/*add button for show the data
		 * set button location
		 * add actionlistener for button to work
		 * add button into the frame
		 */
		viewb = new JButton("View");
		viewb.setBounds(353, 395, 100, 29);
		viewb.addActionListener(this);
		frame.getContentPane().add(viewb);
		
		/*add button for back
		 * set button location
		 * add actionlistener for button to work
		 * add button into the frame
		 */
		backb = new JButton("Back");
		backb.setBounds(228, 395, 95, 29);
		backb.addActionListener(this);
		frame.getContentPane().add(backb);
		
		/*add label for set text as phone
		 * set label alignment
		 * set text font style
		 * set location
		 * add label into the frame
		 */
		JLabel phlabel = new JLabel("Phone");
		phlabel.setHorizontalAlignment(SwingConstants.CENTER);
		phlabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		phlabel.setBounds(486, 11, 96, 29);
		frame.getContentPane().add(phlabel);
		
		/*add button for type number
		 * set location
		 * add text field into the frame
		 */
		phtext = new JTextField();
		phtext.setBounds(588, 20, 123, 14);
		frame.getContentPane().add(phtext);
		phtext.setColumns(10);
	}
	
	//Add functionality to buttons
	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*button connect with JDBC
		 *  when click this button, then it shows the data in the database table
		 */
		if(e.getSource()==viewb) {
			try {
				 Class.forName(JDBC_DRIVER); 
                String dbUsername = "root";
                String dbPassword = "@Sayooj123";

                Connection conn = DriverManager.getConnection(DB_URL, dbUsername, dbPassword);
                String query = "select * from package";
                PreparedStatement pst = conn.prepareStatement(query);
                ResultSet rs = pst.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (Exception ex) {
			    ex.printStackTrace();
			}
		}
		/*add functionality to deletebutton
		 *  when enter number and click this button, then data will be deleted from the database
		 */
		if(e.getSource()==delbutton) {
		
			try {
				String query = "delete from package where phone='"+phtext.getText()+"'";
				Connection conn = DriverManager.getConnection(DB_URL, "root", "@Sayooj123");
				PreparedStatement pst = conn.prepareStatement(query);
				
				pst.execute();
				JOptionPane.showMessageDialog(null, "Data Deleted");
				pst.close();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		/*add functionality to backbutton
		 *  when click this button, it will be navigate to BookedData page
		 */
		if(e.getSource()==backb) {
			frame.dispose();
			BookedData bd = new BookedData();
			bd.frame.setVisible(true);
		}
	}
}
	

