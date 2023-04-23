package packages.Graphics;

import packages.Database.DbConnection;
import javax.swing.JButton;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.sql.Connection;
import packages.Graphics.Editpanel;
public class Registerpanel {
	
	
	

	private JFrame frame;
	private JTextField Faculty_id;
	private JTextField First_name;
	private JTextField Last_name;
	private JTextField Address;
	private JTextField Contact_no;
	private JTextField Email_Id;

	/**
	 * Launch the application.
	 */
	public static void guicalled(Connection con) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registerpanel window = new Registerpanel();
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
	public Registerpanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1118, 785);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1102, 746);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Faculty ID");
		lblNewLabel.setBounds(95, 138, 120, 27);
		panel.add(lblNewLabel);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(95, 196, 120, 27);
		panel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(95, 244, 120, 27);
		panel.add(lblLastName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(95, 305, 120, 27);
		panel.add(lblAddress);
		
		JLabel lblContactNo = new JLabel("Contact No.");
		lblContactNo.setBounds(95, 383, 120, 27);
		panel.add(lblContactNo);
		
		JLabel lblEmailId = new JLabel("Email ID");
		lblEmailId.setBounds(95, 437, 120, 27);
		panel.add(lblEmailId);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("M");
		rdbtnNewRadioButton.setBounds(95, 487, 109, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("F");
		rdbtnNewRadioButton_1.setBounds(230, 487, 109, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		JButton CLear = new JButton("Clear");
		CLear.setBounds(96, 540, 362, 38);
		panel.add(CLear);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(95, 603, 363, 38);
		panel.add(btnRegister);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 9));
		panel_1.setBounds(622, 138, 331, 368);
		panel.add(panel_1);
		
		JButton btnFingerprint = new JButton("Click For Fingerprint");
		btnFingerprint.setBounds(622, 559, 331, 38);
		panel.add(btnFingerprint);
		
		Faculty_id = new JTextField();
		Faculty_id.setBounds(199, 141, 259, 20);
		panel.add(Faculty_id);
		Faculty_id.setColumns(10);
		
		First_name = new JTextField();
		First_name.setColumns(10);
		First_name.setBounds(199, 199, 259, 20);
		panel.add(First_name);
		
		Last_name = new JTextField();
		Last_name.setColumns(10);
		Last_name.setBounds(199, 247, 259, 20);
		panel.add(Last_name);
		
		Address = new JTextField();
		Address.setColumns(10);
		Address.setBounds(199, 308, 259, 51);
		panel.add(Address);
		
		Contact_no = new JTextField();
		Contact_no.setColumns(10);
		Contact_no.setBounds(199, 386, 259, 20);
		panel.add(Contact_no);
		
		Email_Id = new JTextField();
		Email_Id.setColumns(10);
		Email_Id.setBounds(199, 440, 259, 20);
		panel.add(Email_Id);


		// DEBUGGGING
		Faculty_id.setText("654456");
		First_name.setText("moahan");
		Last_name.setText("bhala");
		Address.setText("blah blah blah");
		Email_Id.setText("gg");
		Contact_no.setText("7714171414");
		
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Faculty_id.getText().isEmpty() && First_name.getText().isEmpty() && Last_name.getText().isEmpty() && Address.getText().isEmpty() && Contact_no.getText().isEmpty() && Email_Id.getText().isEmpty() ) {
					// unverified code
				}
				else{
					// varified code
					// DbConnection.entry(Faculty_id.getText(),First_name.getText(),Last_name.getText(), Address.getText(), Contact_no.getText(), Email_Id.getText());
					panel.setVisible(false);
					// System.exit(0);
					frame.setVisible(false);
					Editpanel.guicalled();
				}
			}
		});
	}
}