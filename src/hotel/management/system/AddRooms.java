package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener{
	
	JTextField t1, t2;
	JButton b1, b2;
	JComboBox c1, c2, c3;
	
	AddRooms() {
		
		JLabel l1 = new JLabel("Add Rooms");
		l1.setForeground(Color.BLUE);
		l1.setFont(new Font("Tohman", Font.PLAIN, 16));
		l1.setBounds(100, 20, 100, 30);
		add(l1);
		
		JLabel l2 = new JLabel("Room Number");
		l2.setBounds(40, 70, 100, 30);
		add(l2);
		
		JLabel l3 = new JLabel("Availability");
		l3.setBounds(40, 110, 100, 30);
		add(l3);
		
		JLabel l4 = new JLabel("Checking status");
		l4.setBounds(40, 150, 100, 30);
		add(l4);
		
		JLabel l5 = new JLabel("Price");
		l5.setBounds(40, 190, 100, 30);
		add(l5);
		
		JLabel l6 = new JLabel("Room Type");
		l6.setBounds(40, 230, 100, 30);
		add(l6);
		
		t1 = new JTextField();
		t1.setBounds(165, 70, 130, 30);
		add(t1);
		
		t2 = new JTextField();
		t2.setBounds(165, 190, 130, 30);
		add(t2);
		
		String str1[] = {"Available", "Occupied"};
		c1 = new JComboBox(str1);
		c1.setBounds(165, 110, 130, 30);
		c1.setBackground(Color.WHITE);
		add(c1);
		
		String str2[] = {"Cleaned", "Dirty"};
		c2 = new JComboBox(str2);
		c2.setBounds(165, 150, 130, 30);
		c2.setBackground(Color.WHITE);
		add(c2);
		
		String str3[] = {"Single Bed", "Double Bed"};
		c3 = new JComboBox(str3);
		c3.setBounds(165, 230, 130, 30);
		c3.setBackground(Color.WHITE);
		add(c3);
		
		b1 = new JButton("Add Room");
		b1.setBounds(60, 290, 100, 30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBounds(190, 290, 100, 30);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/twelve.jpg"));
		Image i2 = i1.getImage().getScaledInstance(410, 255, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l7 = new JLabel(i3);
		l7.setBounds(335, 70, 410, 255);
		add(l7);
		
//		getContentPane().setBackground(Color.WHITE);
		
		setLayout(null);
		setBounds(280, 180, 800, 500);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			
			String room = t1.getText();
			String available = (String) c1.getSelectedItem();
			String status = (String) c2.getSelectedItem();
			String price = t2.getText();
			String type = (String) c3.getSelectedItem();
			
			Conn c = new Conn();
			try {
				String str = "insert into room values('"+room+"','"+available+"','"+status+"','"+price+"','"+type+"')";
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "New Room added");
				setVisible(true);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(ae.getSource() == b2) {
			this.setVisible(false);
		}
	}
	
	public static void main(String [] args) {
		new AddRooms();
	}
}
