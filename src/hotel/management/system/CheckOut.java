package hotel.management.system;


import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
public class CheckOut extends JFrame implements ActionListener{

	Choice c1;
	JTextField t1, t2;
	JButton b1, b2, b3;
	
	CheckOut(){
		JLabel l1 = new JLabel("Check Out");
		l1.setBounds(80, 10, 100, 30);
		l1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		l1.setForeground(Color.BLUE);
		add(l1);
		
		JLabel l2 = new JLabel("Customer Id");
		l2.setBounds(40, 50, 100, 30);
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
		
		c1.setBounds(160, 50, 100, 30);
		add(c1);
		
		JLabel l3 = new JLabel("Room Number");
		l3.setBounds(40, 90, 100, 30);
		add(l3);
		
		t1 = new JTextField();
		t1.setBounds(160, 90, 100, 30);
		add(t1);
		
		b1 = new JButton("Check-Out");
		b1.setBounds(40, 150, 100, 30);
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBounds(160, 150, 100, 30);
		b2.setForeground(Color.white);
		b2.setBackground(Color.BLACK);
		b2.addActionListener(this);
		add(b2);
		
		getContentPane().setBackground(Color.WHITE);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
		Image i2 = i1.getImage().getScaledInstance(20,  20, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		b3 = new JButton(i3);
		b3.setBounds(265, 50, 20, 20);
		b3.addActionListener(this);
		add(b3);
		
		ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/sixth.jpg"));
		Image img2  = img1.getImage().getScaledInstance(380, 250, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		JLabel img = new JLabel(img3);
		img.setBounds(300, 30, 380, 250);
		add(img);
		
		setLayout(null);
		setBounds(280, 250, 750, 400);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			String id = c1.getSelectedItem();
			String room = t1.getText();
			String str = "delete from customer where number ='"+id+"'";
			String str2 = "update room set available = 'Available' where room_number = '"+room+"'";
			Conn c = new Conn();
			try {
				c.s.executeUpdate(str);
				c.s.executeUpdate(str2);
				JOptionPane.showMessageDialog(null,  "CheckOut Done");
				
				new Reception().setVisible(true);
				this.setVisible(false);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(ae.getSource() == b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource() == b3) {
			String id = c1.getSelectedItem();
			Conn c = new Conn();
			try {
				ResultSet rs = c.s.executeQuery("Select * from customer where number = '"+id+"'");
				while(rs.next()) {
					t1.setText(rs.getString("room"));
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public static void main(String [] args) {
		new CheckOut();
	}
}
