package hotel.management.system;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class Dashboard extends JFrame implements ActionListener{
	JMenuBar mb;
	JMenu m1, m2;
	JMenuItem i1, i2, i3, i4;
	
	Dashboard(){
		
	mb = new JMenuBar();
	add(mb);
	
	m1 = new JMenu("Hotel Management");
	m1.setForeground(Color.RED);
	mb.add(m1);
	
	m2 = new JMenu("Admin");
	m2.setForeground(Color.BLUE);
	mb.add(m2);
	
	i1 = new JMenuItem("Reception");
	i1.addActionListener(this);
	m1.add(i1);
	
	i2 = new JMenuItem("Add Employee");
	i2.addActionListener(this);
	m2.add(i2);
	
	i3 = new JMenuItem("Add Rooms");
	i3.addActionListener(this);
	m2.add(i3);
	
	i4 = new JMenuItem("Add Driver");
	i4.addActionListener(this);
	m2.add(i4);
	
	mb.setBounds(0, 0, 1920, 30);
	
	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/third.jpg"));
	Image i2 = i1.getImage().getScaledInstance(1920,  1000, Image.SCALE_DEFAULT);
	ImageIcon i3 = new ImageIcon(i2);
	JLabel l1 = new JLabel(i3);
	l1.setBounds(0, 0, 1320, 760);
	add(l1);
	
	JLabel l2 = new JLabel("Hotel room inhabit a separate moral universe");
	l2.setBounds(310, 50, 700, 55);
	l2.setForeground(Color.WHITE);
	l2.setFont(new Font("Tahoma", Font.PLAIN, 35));
	l1.add(l2);
	
	setLayout(null);
	setBounds(0, 0, 1920, 1020);
	setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Reception")) {
			new Reception().setVisible(true);
		}
		else if(e.getActionCommand() == "Add Employee") {
			new AddEmployee().setVisible(true);
		}
		else if(e.getActionCommand() == "Add Rooms") {
			new AddRooms().setVisible(true);
		}
		else if(e.getActionCommand() == "Add Driver") {
			new AddDriver().setVisible(true);
		}
	}
	
	public static void main(String [] args) {
		new Dashboard();
	}
}
