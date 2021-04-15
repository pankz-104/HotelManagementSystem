package hotel.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class CustomerInfo extends JFrame implements ActionListener{

	JTable t1;
	JButton b1, b2;
	
	CustomerInfo(){
	
		t1 = new JTable();
		t1.setBounds(0, 50, 900, 350);
		add(t1);
		
		b1 = new JButton("Load Data");
		b1.setBounds(250, 400, 100, 30);
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBounds(450, 400, 100, 30);
		b2.addActionListener(this);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		add(b2);
		
		JLabel l1 = new JLabel("ID");
		l1.setBounds(40, 10, 55, 40);
		add(l1);
		
		JLabel l2 = new JLabel("Number");
		l2.setBounds(145, 10, 55, 40);
		add(l2);
		
		JLabel l3 = new JLabel("Name");
		l3.setBounds(260, 10, 55, 40);
		add(l3);
		
		JLabel l4 = new JLabel("Gender");
		l4.setBounds(365, 10, 75, 40);
		add(l4);
		
		JLabel l5 = new JLabel("Country");
		l5.setBounds(485, 10, 55, 40);
		add(l5);
		
		JLabel l6 = new JLabel("Room");
		l6.setBounds(585, 10, 55, 40);
		add(l6);
		
		JLabel l7 = new JLabel("Status");
		l7.setBounds(705, 10, 55, 40);
		add(l7);
		
		JLabel l8  = new JLabel("Deposit");
		l8.setBounds(815, 10, 55, 40);
		add(l8);
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(210, 170, 900, 550);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource() == b1) {
			try {
				Conn c = new Conn();
				String str = "Select * from customer";
				
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
	
	public static void main(String [] args) {
		new CustomerInfo();
	}
}
