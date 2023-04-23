package packages.Graphics;

import javax.swing.JButton;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.*;

import packages.Database.DbConnection;

public class Editpanel {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public static void guicalled() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Editpanel window = new Editpanel();
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
	public Editpanel() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1162, 699);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1146, 660);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Faculty ID :");
		lblNewLabel.setBounds(67, 53, 101, 30);
		panel.add(lblNewLabel);

		JLabel lblFirstName = new JLabel("First Name :");
		lblFirstName.setBounds(300, 53, 101, 30);
		panel.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(519, 53, 101, 30);
		panel.add(lblLastName);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(733, 44, 163, 49);
		panel.add(btnSearch);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(67, 156, 1000, 474);
		panel.add(panel_1);
		panel_1.setLayout(null);
		JTable table = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1000, 474);
		panel_1.add(scrollPane);
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!textField.getText().isEmpty() || !textField_1.getText().isEmpty()|| !textField_2.getText().isEmpty()) {
					Connection con = DbConnection.getconnection();
					ResultSet rs = DbConnection.filteredData(textField.getText(), textField_1.getText(), textField_2.getText());
					try {
						ResultSetMetaData rsm = rs.getMetaData();
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						int cols = rsm.getColumnCount();
						String[] colName = new String[cols];
						int count = model.getRowCount();
							for (int r = 0; r < count; r++) {
								model.removeRow(0);
								System.out.println("clear");
							}
						for (int i = 0; i < cols; i++) {
							colName[i] = rsm.getColumnName(i + 1);
							model.setColumnIdentifiers(colName);
							String Faculty_id, First_name, Last_name, Address, Contact_no, Email_Id;

							while (rs.next()) {
								Faculty_id = rs.getString(1);
								First_name = rs.getString(2);
								Last_name = rs.getString(3);
								Address = rs.getString(4);
								Contact_no = rs.getString(5);
								Email_Id = rs.getString(6);
								String[] row = { Faculty_id, First_name, Last_name, Address, Contact_no, Email_Id };
								model.addRow(row);
							}
						}
					} catch (SQLException en) {
						// TODO Auto-generated catch block
						en.printStackTrace();
					}
					System.out.println("added");
				}
			}
		});

		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(924, 44, 163, 49);
		panel.add(btnClear);

		textField = new JTextField();
		textField.setBounds(137, 58, 136, 20);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(373, 58, 136, 20);
		panel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(587, 58, 136, 20);
		panel.add(textField_2);

		Connection con = DbConnection.getconnection();
		ResultSet rs = DbConnection.getallentry();
		try {
			ResultSetMetaData rsm = rs.getMetaData();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			int cols = rsm.getColumnCount();
			String[] colName = new String[cols];
			for (int i = 0; i < cols; i++) {
				colName[i] = rsm.getColumnName(i + 1);
				model.setColumnIdentifiers(colName);
				String Faculty_id, First_name, Last_name, Address, Contact_no, Email_Id;
				while (rs.next()) {
					Faculty_id = rs.getString(1);
					First_name = rs.getString(2);
					Last_name = rs.getString(3);
					Address = rs.getString(4);
					Contact_no = rs.getString(5);
					Email_Id = rs.getString(6);
					String[] row = { Faculty_id, First_name, Last_name, Address, Contact_no, Email_Id };

					model.addRow(row);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		scrollPane.setViewportView(table);
		table.setBounds(67, 156, 10, 47);

	}
}