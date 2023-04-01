package regg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class reg {

	private JFrame frame;
	private JTextField n;
	private JTextField t1;
	private JTextField e1;
	private JTextField m1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reg window = new reg();
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
	public reg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 871, 736);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Roll no");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(116, 188, 85, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(116, 139, 85, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmail.setBounds(116, 249, 85, 27);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblMarks = new JLabel("Marks");
		lblMarks.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMarks.setBounds(116, 304, 85, 27);
		frame.getContentPane().add(lblMarks);
		
		JButton b1 = new JButton("Submit");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String roll=t1.getText();
				String Name=n.getText();
				String marks=m1.getText();
				
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reg","root","mrec");
					String q="Insert into reg1 values('"+roll+"','"+Name+"','"+marks+"')";
					Statement sta=con.createStatement();
					sta.executeUpdate(q);
					con.close();
					JOptionPane.showMessageDialog(b1, "SUCCESS!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		b1.setBounds(264, 424, 122, 46);
		frame.getContentPane().add(b1);
		
		n = new JTextField();
		n.setBounds(251, 146, 135, 20);
		frame.getContentPane().add(n);
		n.setColumns(10);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBounds(251, 195, 135, 20);
		frame.getContentPane().add(t1);
		
		e1 = new JTextField();
		e1.setColumns(10);
		e1.setBounds(251, 245, 135, 20);
		frame.getContentPane().add(e1);
		
		m1 = new JTextField();
		m1.setColumns(10);
		m1.setBounds(251, 311, 135, 20);
		frame.getContentPane().add(m1);
	}
}
