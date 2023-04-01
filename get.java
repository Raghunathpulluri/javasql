package regg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class login {

	private JFrame frame;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 874, 751);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("roll no");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(128, 207, 96, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lb1 = new JLabel("name:");
		lb1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb1.setBounds(188, 331, 240, 35);
		frame.getContentPane().add(lb1);
		
		JLabel lb2 = new JLabel("marks:");
		lb2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb2.setBounds(188, 391, 206, 35);
		frame.getContentPane().add(lb2);
		
		t1 = new JTextField();
		t1.setBounds(209, 216, 165, 24);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		JButton b = new JButton("get details");
		b.setFont(new Font("Tahoma", Font.BOLD, 25));
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String roll=t1.getText();
				String Name=lb1.getText();
				String marks=lb2.getText();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reg","root","mrec");
					String q="select name,marks from reg1 where roll=?";
					PreparedStatement ps=con.prepareStatement(q);
					ps.setString(1, roll);
					ResultSet rs=ps.executeQuery();
					rs.next();
					lb1.setText("name:"+rs.getString(1));
					lb2.setText("marks:"+rs.getInt(2));
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		b.setBounds(209, 285, 240, 35);
		frame.getContentPane().add(b);
	}

}
