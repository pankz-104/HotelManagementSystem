package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;


public class PickUp extends JFrame implements ActionListener{

	Choice c1;
	JCheckBox c2;
	JButton b1, b2;
	JTable t1;
	
	PickUp(){
		
		JLabel l1 = new JLabel("Pick Up Service");
		l1.setFont(new Font("Tahomas", Font.PLAIN, 20));
		l1.setBounds(330, 10, 200, 30);
		l1.setForeground(Color.BLUE);
		add(l1);
		
		JLabel l2 = new JLabel("Type Of Car");
		l2.setBounds(40, 40, 100, 20);
		add(l2);
		
		c1 = new Choice();
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from driver");
			while(rs.next()) {
				c1.add(rs.getString("car_brand"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		c1.setBounds(150, 40, 120, 30);
		add(c1);
		
		JLabel l3 = new JLabel("Name");
		l3.setBounds(50, 80, 100, 30);
		add(l3);
		
		JLabel l4 = new JLabel("Age");
		l4.setBounds(160, 80, 100, 30);
		add(l4);
		
		JLabel l5 = new JLabel("Gender");
		l5.setBounds(270, 80, 100, 30);
		add(l5);
		
		JLabel l6 = new JLabel("Company");
		l6.setBounds(370, 80, 100, 30);
		add(l6);
		
		JLabel l7 = new JLabel("Brand");
		l7.setBounds(490, 80, 100, 30);
		add(l7);
		
		JLabel l8 = new JLabel("Availability");
		l8.setBounds(600, 80, 100, 30);
		add(l8);
		
		JLabel l9 = new JLabel("Location");
		l9.setBounds(700, 80, 100, 30);
		add(l9);
		
		
		t1 = new JTable();
		t1.setBounds(0, 140, 800, 310);
		add(t1);
		
		
		b1 = new JButton("Load Data");
		b1.setBounds(40, 450, 100, 30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBounds(190, 450, 100, 30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
		
		getContentPane().setBackground(Color.WHITE);
		
		setLayout(null);
		setBounds(240, 200, 800, 550);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			try {
				String str = "select * from driver where car_brand= '"+c1.getSelectedItem()+"'";
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(str);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(ae.getSource() == b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	
	public static void main(String [] args) {
		new PickUp();
	}
}
