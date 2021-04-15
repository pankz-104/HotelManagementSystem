package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;


public class Department extends JFrame implements ActionListener{

	JCheckBox c2;
	JButton b1, b2;
	JTable t1;
	
	Department(){
		
		JLabel l1 = new JLabel("Department");
		l1.setFont(new Font("Tahomas", Font.PLAIN, 20));
		l1.setBounds(190, 20, 180, 30);
		l1.setForeground(Color.BLUE);
		add(l1);
		
		JLabel l2 = new JLabel("Department");
		l2.setBounds(100, 60, 100, 20);
		add(l2);
		
		JLabel l3 = new JLabel("Budget");
		l3.setBounds(320, 60, 100, 20);
		add(l3);
		
		t1 = new JTable();
		t1.setBounds(85, 105, 305, 290);
		add(t1);
		
		
		b1 = new JButton("Load Data");
		b1.setBounds(115, 400, 100, 30);
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBounds(265, 400, 100, 30);
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		b2.addActionListener(this);
		add(b2);
		
//		getContentPane().setBackground(Color.WHITE);
		
		setLayout(null);
		setBounds(380, 200, 500, 500);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			try {
				String str = "select * from department";
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
		new Department();
	}
}
