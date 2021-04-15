package hotel.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

	JTextField t1, t2;
	JButton b1, b2;
	JLabel l1, l2;

	Login() {
		// username positioning
		l1 = new JLabel("Username");
		l1.setBounds(20, 30, 100, 30);
		add(l1);

		l2 = new JLabel("Password");
		l2.setBounds(20, 70, 100, 30);
		add(l2);

		// placing the textfields
		t1 = new JTextField();
		t1.setBounds(100, 33, 110, 25);
		add(t1);

		t2 = new JPasswordField();
		t2.setBounds(100, 74, 110, 25);
		add(t2);

		b1 = new JButton("Login");
//		b1.setBackground(Color.BLACK);
//		b1.setForeground(Color.WHITE);
		b1.setBounds(130, 140, 100, 28);
		b1.addActionListener(this);
		add(b1);

		b2 = new JButton("Cancel");
		b2.setBounds(260, 140, 100, 28);
		b2.addActionListener(this);
		add(b2);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/Management/system/icons/second.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l3 = new JLabel(i3);
		l3.setBounds(300, 15, 100, 100);
		add(l3);

		// matches the background color image to the original background
		getContentPane().setBackground(Color.WHITE);

		setLayout(null);

		// login frame window
		setBounds(400, 200, 500, 280);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		// action performed by login button
		if (ae.getSource() == b1) {
			try {
				// get data from textfields t1 and t2
				String username = t1.getText();
				String password = t2.getText();
				Conn c = new Conn();

				String str = "Select * from login where username = '" + username + "' and password = '" + password
						+ "'";
				ResultSet rs = c.s.executeQuery(str);

				// uname and pswd matched
				if (rs.next()) {
					new Dashboard().setVisible(true);
					this.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Invalid credentials");
					this.setVisible(false);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// action performed by cancel button
		else if (ae.getSource() == b2) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new Login();
	}
}
