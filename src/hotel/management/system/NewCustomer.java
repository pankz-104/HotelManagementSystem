package hotel.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;


public class NewCustomer extends JFrame implements ActionListener{

	JTextField t1, t2, t3, t4, t5;
	JButton b1, b2;
	JComboBox c1;
	Choice c2;
	JRadioButton r1, r2;

	NewCustomer() {
		JLabel l1 = new JLabel("New Customer Form");
		l1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		l1.setForeground(Color.BLUE);
		l1.setBounds(100, 20, 200, 30);
		add(l1);

		JLabel l2 = new JLabel("ID");
		l2.setBounds(50, 60, 50, 30);
		add(l2);

		c1 = new JComboBox(new String[] { "Passport", "Voter-ID", "Aadhar", "Driving License" });
		c1.setBounds(220, 60, 150, 30);
		c1.setBackground(Color.WHITE);
		add(c1);

		JLabel l3 = new JLabel("Number");
		l3.setBounds(50, 100, 50, 30);
		add(l3);

		t1 = new JTextField();
		t1.setBounds(220, 100, 150, 30);
		add(t1);

		JLabel l4 = new JLabel("Name");
		l4.setBounds(50, 140, 50, 30);
		add(l4);

		t2 = new JTextField();
		t2.setBounds(220, 140, 150, 30);
		add(t2);

		JLabel l5 = new JLabel("Gender");
		l5.setBounds(50, 180, 50, 30);
		add(l5);

		r1 = new JRadioButton("Male");
		r1.setBounds(220, 180, 60, 30);
		add(r1);

		r2 = new JRadioButton("Female");
		r2.setBounds(290, 180, 70, 30);
		add(r2);

		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);

		JLabel l6 = new JLabel("Country");
		l6.setBounds(50, 220, 50, 30);
		add(l6);

		t3 = new JTextField();
		t3.setBounds(220, 220, 150, 30);
		add(t3);

		JLabel l7 = new JLabel("Allocated Room Number");
		l7.setBounds(50, 260, 150, 33);
		add(l7);

		c2 = new Choice();
		try {
			Conn c = new Conn();
//			String str = "Select * from room";
			ResultSet rs = c.s.executeQuery("select * from room");

			while (rs.next()) {
				c2.add(rs.getString("room_number"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		c2.setBounds(220, 260, 150, 30);
		add(c2);

		JLabel l8 = new JLabel("Checked In");
		l8.setBounds(50, 300, 100, 30);
		add(l8);

		t4 = new JTextField();
		t4.setBounds(220, 300, 150, 30);
		add(t4);

		JLabel l9 = new JLabel("Deposit");
		l9.setBounds(50, 340, 150, 30);
		add(l9);

		t5 = new JTextField();
		t5.setBounds(220, 340, 150, 30);
		add(t5);

		b1 = new JButton("Add Customer");
		b1.setBounds(60, 390, 115, 30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);

		b2 = new JButton("Back");
		b2.setBounds(220, 390, 115, 30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fifth.png"));
		Image i2 = i1.getImage().getScaledInstance(410, 255, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel img = new JLabel(i3);
		img.setBounds(400, 70, 440, 300);
		add(img);

		getContentPane().setBackground(Color.WHITE);
		
		setLayout(null);
		setBounds(210, 170, 900, 500);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) {
			String id = (String) c1.getSelectedItem();
			String number = t1.getText();
			String name = t2.getText();
			String gender = null;
			if (r1.isSelected()) {
				gender = "Male";
			} else if (r2.isSelected()) {
				gender = "Female";
			}
			String country = t3.getText();
			String room = c2.getSelectedItem();
			String status = t4.getText();
			String deposit = t5.getText();

			String str = "insert into customer values('" + id + "','" + number + "','" + name + "','" + gender + "','"
					+ country + "','" + room + "','" + status + "','" + deposit + "')";
			
			String str2 = "update room set available = 'occupied' where room_number = '"+room+"'";
			try {
				Conn c = new Conn();
				c.s.executeUpdate(str);
				c.s.executeUpdate(str2);
				JOptionPane.showMessageDialog(null, "Data Inserted Suscessfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (ae.getSource() == b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}

	public static void main() {
		new NewCustomer();
	}
}
