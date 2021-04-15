package hotel.management.system;


import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;
public class Room extends JFrame implements ActionListener{
	
	JTable t1;
	JButton b1, b2;
	
	Room(){
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eight.jpg"));
		Image i2 = i1.getImage().getScaledInstance(380, 275, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l7 = new JLabel(i3);
		l7.setBounds(480, 70, 380, 275);
		add(l7);
		
		t1 = new JTable();
		t1.setBounds(0, 70, 480, 330);
		add(t1);
		
		JLabel l1 = new JLabel("Room Number");
		l1.setBounds(10, 10, 90, 40);
		add(l1);
		
		JLabel l2 = new JLabel("Availability");
		l2.setBounds(110, 10, 85, 40);
		add(l2);
		
		JLabel l3 = new JLabel("Room Status");
		l3.setBounds(200, 10, 85, 40);
		add(l3);
		
		JLabel l4 = new JLabel("Price");
		l4.setBounds(320, 10, 85, 40);
		add(l4);
		
		JLabel l5 = new JLabel("Room Type");
		l5.setBounds(400, 10, 85, 40);
		add(l5);
		
		b1 = new JButton("Load Data");
		b1.setBounds(100, 400, 100, 30);
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBounds(250, 400, 100, 30);
		b2.addActionListener(this);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		add(b2);
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(210, 170, 900, 500);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			try {
				Conn c = new Conn();
				String str = "select * from room";
				
				ResultSet rs = c.s.executeQuery(str);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(ae.getSource() == b2) {
			new Reception().setVisible(true);
			setVisible(false);
		}
	}
	
	public static void main(String [] args)
	{
		new Room();
	}
}
