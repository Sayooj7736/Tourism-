package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class Hotel implements ActionListener{
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/tourism";

	public JFrame frame;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JButton backbutton;
	public JButton btnBook;
	public JButton viewbutton;
	public JButton checkbutton;
	public JComboBox comboBox;
	public JTextField pricetext;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hotel window = new Hotel();
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
	public Hotel() {
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
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 833, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);		
		frame.getContentPane().setLayout(null);
		
		/*add new label for set heading as BookHotel
		 * set font style
		 * set text alignment
		 * set location
		 * add label into the frame
		 */
		JLabel hotellabel = new JLabel("BOOK HOTEL");
		hotellabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		hotellabel.setHorizontalAlignment(SwingConstants.CENTER);
		hotellabel.setBounds(80, 57, 221, 43);
		frame.getContentPane().add(hotellabel);
		
		/*add label for set text as username
		 * set font style
		 * set text alignment
		 * set location
		 * add label into the frame
		 */
		JLabel userlabel = new JLabel("Username");
		userlabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		userlabel.setHorizontalAlignment(SwingConstants.CENTER);
		userlabel.setBounds(62, 133, 106, 43);
		frame.getContentPane().add(userlabel);
		
		/*add text field for give an input 
		 * set location
		 * add text field into the frame
		 */
		textField = new JTextField();
		textField.setBounds(221, 144, 144, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		/*add label for set text as select hotel
		 * set text alignment
		 * set font style
		 * set location
		 * add label into the frame
		 */
		JLabel selectlabel = new JLabel("Select Hotel");
		selectlabel.setHorizontalAlignment(SwingConstants.CENTER);
		selectlabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		selectlabel.setBounds(62, 187, 106, 43);
		frame.getContentPane().add(selectlabel);
		
		/*add combobox for show more than one option in a single text box
		 * create string variable and store datas
		 * set location
		 * add combobox into the frame
		 */
		String[] hotels = {"","Plaza Hotel","Paris Hotel"};
		comboBox = new JComboBox(hotels);
		comboBox.setBounds(221, 197, 144, 22);
		frame.getContentPane().add(comboBox);
		
		/*add label for set text as total days
		 * set text alignment
		 * set font style
		 * set location
		 * add label into the frame
		 */
		JLabel dayslabel = new JLabel("Total Days");
		dayslabel.setHorizontalAlignment(SwingConstants.CENTER);
		dayslabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		dayslabel.setBounds(62, 241, 106, 43);
		frame.getContentPane().add(dayslabel);
		
		/*add text field for give an input
		 * set location
		 * add text field into the frame
		 */
		textField_1 = new JTextField();
		textField_1.setBounds(221, 252, 144, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		/*add label for set text as phone
		 * set text alignment
		 * set font style
		 * set location
		 * add label into the frame
		 */
		JLabel phonelabel = new JLabel("Phone");
		phonelabel.setHorizontalAlignment(SwingConstants.CENTER);
		phonelabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		phonelabel.setBounds(62, 295, 106, 43);
		frame.getContentPane().add(phonelabel);
		
		/*add text field for give an input
		 * set location
		 * add textfield into the frame
		 */
		textField_2 = new JTextField();
		textField_2.setBounds(221, 306, 144, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		/*add button for navigate to the previous page
		 * set location
		 * add actionlistener for button to work
		 * add button into the frame
		 */
		backbutton = new JButton("Back");
		backbutton.setBounds(79, 371, 89, 30);
		backbutton.addActionListener(this);
		frame.getContentPane().add(backbutton);
		
		/*add button for book the hotel and stored in database
		 * set location
		 * add actionlistener for button to work
		 * add button into the frame
		 */
		btnBook = new JButton("Book");
		btnBook.setBounds(212, 371, 89, 30);
		btnBook.addActionListener(this);
		frame.getContentPane().add(btnBook);
		
		/*add label for set background image for hotel page
		 * set image alignment
		 * select bg image
		 * set location
		 * add label into the frame
		 */
		JLabel bglabel = new JLabel("");
		bglabel.setHorizontalAlignment(SwingConstants.CENTER);
		bglabel.setIcon(new ImageIcon("C:\\Users\\sayooj.p\\Desktop\\Project Docs\\Bookhotel.png"));
		bglabel.setBounds(386, 88, 431, 270);
		frame.getContentPane().add(bglabel);
		
		
		/*add button for check the price of the hotel
		 * set location
		 * add actionlistener for button to work
		 * add button into the frame
		 */
		checkbutton = new JButton("Check Price");
		checkbutton.setBounds(459, 375, 117, 30);
		checkbutton.addActionListener(this);
		frame.getContentPane().add(checkbutton);
		
		/*add text field for show the price of the hotel
		 * set location
		 * set textfield as not editable
		 * add textfield into the frame
		 */
		pricetext = new JTextField();
		pricetext.setBounds(610, 375, 117, 30);
		pricetext.setEditable(false);
		frame.getContentPane().add(pricetext);
		pricetext.setColumns(10);
	}
	
	//To add functionality to buttons

	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*connect button with JDBC
		 * when click this button, the data will be stored in database
		 */
		if(e.getSource()==btnBook) {
			String username = textField.getText();
			String value = comboBox.getSelectedItem().toString();
			String days = textField_1.getText();
			String phone = textField_2.getText();
			String price = pricetext.getText();
			
			//phone number should be 10 digits
			if(textField_2.getText().length()>9 && textField_2.getText().length()<11) {
				//username should be 4 letters
				if(username.length()>3) {
			
			try {
				 Class.forName(JDBC_DRIVER); 
                 String dbUsername = "root";
                 String dbPassword = "@Sayooj123";

                 Connection conn = DriverManager.getConnection(DB_URL, dbUsername, dbPassword);
                 Statement stmt = conn.createStatement();
                 String sql = "INSERT INTO hotel"+"(username,hotel,days,phone,price)"+"VALUES('"+ username +"','"+ value +"','"+ days +"','"+ phone +"','"+ price +"')";
                 stmt.executeUpdate(sql);
                 
                 stmt.close();
                 conn.close();
			}
			catch (SQLException ex) {
		          ex.printStackTrace();
		      } catch (ClassNotFoundException e1) {

		        e1.printStackTrace();
		    }
			JOptionPane.showMessageDialog(null, "Hotel Booked Successfully!");
			textField.setText("");
			comboBox.setSelectedIndex(0);
			textField_1.setText("");
			textField_2.setText("");
			pricetext.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "Username should be 4 letters");
				}
		}else {
			JOptionPane.showMessageDialog(null, "Phone number should be 10 digits");
			}
		}
		//when click this button, then it show the price
		if(e.getSource()==checkbutton) {
			if(comboBox.getSelectedIndex()==1) {
				pricetext.setText("14000");
			}
			if(comboBox.getSelectedIndex()==2) {
				pricetext.setText("16000");
			}
		}
		/*add functionality to back button
		 * when click this button, it will be navigate to home page
		 */
		if(e.getSource()==backbutton) {
			frame.hide();
			Home home = new Home();
			home.frame.setVisible(true);
		}
	}
}