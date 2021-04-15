package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;


public class SearchRoom extends JFrame implements ActionListener{

	JComboBox c1;
	JCheckBox c2;
	JButton b1, b2;
	JTable t1;
	
	SearchRoom(){
		
		JLabel l1 = new JLabel("Search Room");
		l1.setFont(new Font("Tahomas", Font.PLAIN, 20));
		l1.setBounds(330, 10, 200, 30);
		l1.setForeground(Color.BLUE);
		add(l1);
		
		JLabel l2 = new JLabel("Room bed type");
		l2.setBounds(40, 60, 100, 20);
		add(l2);
		
		c1 = new JComboBox(new String[] {"Single Bed", "Double Bed"});
		c1.setBounds(150, 60, 150, 30);
		c1.setBackground(Color.WHITE);
		add(c1);
		
		c2 = new JCheckBox("Only display available");
		c2.setBounds(550, 60, 150, 30);
		add(c2);

		JLabel l3 = new JLabel("Room Number");
		l3.setBounds(40, 110, 100, 30);
		add(l3);
		
		JLabel l4 = new JLabel("Availability");
		l4.setBounds(220, 110, 100, 30);
		add(l4);
		
		JLabel l5 = new JLabel("Status");
		l5.setBounds(380, 110, 100, 30);
		add(l5);
		
		JLabel l6 = new JLabel("Price");
		l6.setBounds(540, 110, 100, 30);
		add(l6);
		
		JLabel l7 = new JLabel("Bed Type");
		l7.setBounds(670, 110, 100, 30);
		add(l7);
		
		t1 = new JTable();
		t1.setBounds(0, 140, 800, 310);
		add(t1);
		
		
		b1 = new JButton("Submit");
		b1.setBounds(270, 450, 100, 30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBounds(430, 450, 100, 30);
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
				String str = "select * from room where bed_type = '"+c1.getSelectedItem()+"'";
				String str2 = "select * from room where available = 'Available' AND bed_type ='"+c1.getSelectedItem()+"'";
			
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(str);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
				
				if(c2.isSelected()) {
					ResultSet rs2 = c.s.executeQuery(str2);
					t1.setModel(DbUtils.resultSetToTableModel(rs2));
				}
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
		new SearchRoom();
	}
}
