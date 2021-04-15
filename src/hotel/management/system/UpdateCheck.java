package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class UpdateCheck extends JFrame implements ActionListener{
	
	JLabel l1, l2, l3, l4, l5, l6, l7;
	Choice c1;
	JTextField t1, t2, t3, t4, t5;
	JButton b1, b2, b3;
	
	UpdateCheck() {
		l1 = new JLabel("Check-in Details");
		l1.setBounds(90, 20, 130, 30);
		l1.setForeground(Color.BLUE);
		l1.setFont(new Font("Tahomas", Font.PLAIN, 18));
		add(l1);
		
		l2 = new JLabel("Customer-ID");
		l2.setBounds(40, 60, 130, 30);
		add(l2);
		
		c1 = new Choice();
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("Select * from customer");
			while(rs.next()) {
				c1.add(rs.getString("number"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		c1.setBounds(190, 60, 130, 30);
		add(c1);
	
		l3 = new JLabel("Room Number");
		l3.setBounds(40, 100, 130, 30);
		add(l3);
		
		t1 = new JTextField();
		t1.setBounds(190, 100, 130, 30);
		add(t1);
		
		l4 = new JLabel("Name");
		l4.setBounds(40, 140, 130, 30);
		add(l4);
		
		t2 = new JTextField();
		t2.setBounds(190, 140, 130, 30);
		add(t2);
		
		l5 = new JLabel("Check-In");
		l5.setBounds(40, 180, 130, 30);
		add(l5);
		
		t3 = new JTextField();
		t3.setBounds(190, 180, 130, 30);
		add(t3);
		
		l6 = new JLabel("Amount Paid");
		l6.setBounds(40, 220, 130, 30);
		add(l6);
		
		t4 = new JTextField();
		t4.setBounds(190, 220, 130, 30);
		add(t4);
		
		l7 = new JLabel("Pending Amount");
		l7.setBounds(40, 260, 130, 30);
		add(l7);
		
		t5 = new JTextField();
		t5.setBounds(190, 260, 130, 30);
		add(t5);
		
		b1 = new JButton("Check");
		b1.setBounds(100, 320, 100, 30);
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Update");
		b2.setBounds(40, 360, 90, 30);
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		b2.addActionListener(this);
		add(b2);
		
		b3 = new JButton("Back");
		b3.setBounds(170, 360, 90, 30);
		b3.setForeground(Color.WHITE);
		b3.setBackground(Color.BLACK);
		b3.addActionListener(this);
		add(b3);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/nine.jpg"));
		Image i2  = i1.getImage().getScaledInstance(300, 150, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel img = new JLabel(i3);
		img.setBounds(400, 150, 300, 150);
		add(img);
		
		getContentPane().setBackground(Color.WHITE);
		
		setLayout(null);
		setBounds(250, 170, 800, 550);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			try {
				String room = null;
				String deposit = null;
				String amountPaid = null;
				int pendingAmount = 0;
				String price = null;
				Conn c = new Conn();
				String id = c1.getSelectedItem();
				String str = "select * from customer where number = '"+id+"'";
				ResultSet rs = c.s.executeQuery(str);
				while(rs.next()) {
					t1.setText(rs.getString("room"));
					t2.setText(rs.getString("name"));
					t3.setText(rs.getString("status"));
					t4.setText(rs.getString("deposit"));
					room = rs.getString("room");
					deposit = rs.getString("deposit");
				}
				
				ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '"+room+"'");
				while(rs2.next()) {
					price = rs2.getString("price");
					pendingAmount = Integer.parseInt(price) - Integer.parseInt(deposit);
					amountPaid = Integer.toString(pendingAmount);
					t5.setText(amountPaid);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(ae.getSource() == b2) {
			
		}
		else if(ae.getSource() == b3) {
			new Reception().setVisible(true);
			setVisible(false);
		}
	}
	
	public static void main(String [] args) {
		new UpdateCheck();
	}
}
