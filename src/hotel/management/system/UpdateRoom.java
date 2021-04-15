package hotel.management.system;

import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class UpdateRoom extends JFrame implements ActionListener {

	JTextField j3, j4, j5;
	Choice c1;
	JButton b1, b2, b3;
	UpdateRoom() {
		JLabel l1 = new JLabel("Update room status");
		l1.setFont((new Font("Tahoma", Font.PLAIN, 19)));
		l1.setForeground(Color.BLUE);
		l1.setBounds(70, 10, 200, 30);
		add(l1);

		JLabel l2 = new JLabel("Guest ID");
		l2.setBounds(40, 75, 80, 30);
		add(l2);

		c1 = new Choice();
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			while (rs.next()) {
				c1.add(rs.getString("number"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		c1.setBounds(180, 75, 120, 30);
		add(c1);
		
		JLabel l3 = new JLabel("Room Number");
		l3.setBounds(40, 110, 100, 30);
		add(l3);
		
		j3 = new JTextField();
		j3.setBounds(180, 110, 120, 30);
		add(j3);
		
		JLabel l4 = new JLabel("Availability");
		l4.setBounds(40, 150, 100, 30);
		add(l4);
		
		j4 = new JTextField();
		j4.setBounds(180, 150, 120, 30);
		add(j4);
		
		JLabel l5 = new JLabel("Clean Status");
		l5.setBounds(40, 190, 100, 30);
		add(l5);
		
		j5 = new JTextField();
		j5.setBounds(180, 190, 120, 30);
		add(j5);

		b1 = new JButton("Check");
		b1.setBounds(120, 300, 100, 30);
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		add(b1);
		
		b2 = new JButton("Update");
		b2.setBounds(65, 345, 100, 30);
		b2.addActionListener(this);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		add(b2);
		
		b3 = new JButton("Back");
		b3.setBounds(175, 345, 100, 30);
		b3.addActionListener(this);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		add(b3);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/seventh.jpg"));
		Image i2 = i1.getImage().getScaledInstance(490,  350, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel img = new JLabel(i3);
		img.setBounds(350, 40, 490, 350);
		add(img);
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(210, 170, 900, 550);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae ) {
		if(ae.getSource() == b1) {
			String s1 = c1.getSelectedItem();
			String room = null;
			Conn c = new Conn();
			try {
				ResultSet rs = c.s.executeQuery("Select * from customer where number = '"+s1+"'");
				while(rs.next()) {
					j3.setText(rs.getString("room"));
					room = rs.getString("room");
				}
				
				ResultSet rs2 = c.s.executeQuery("Select * from room where room_number = '"+room+"'");
				while(rs2.next()) {
					j4.setText(rs2.getString("available"));
					j5.setText(rs2.getString("status"));
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(ae.getSource() == b2) {
			try {
				Conn c = new Conn();
				String room = j3.getText();
				String available = j4.getText();
				String status = j5.getText();
				
				String str = "update room set available = '"+available+"', status = '"+status+"' where room_number ='"+room+"'";
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null,  "Room Updated Suscessfully");
				new Reception().setVisible(true);
				this.setVisible(false);
			}
			catch(Exception e) {
				
			}
		}
		else if(ae.getSource() == b3) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new UpdateRoom();
	}
}
