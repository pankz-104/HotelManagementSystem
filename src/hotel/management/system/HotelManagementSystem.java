package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HotelManagementSystem extends JFrame implements ActionListener{
	HotelManagementSystem(){
		// sets location and frame size
		setBounds(10, 10, 1300, 700);
		
		// setting frame size
		// setSize(400, 400);
		
		// setting location of frame
		// setLocation(200, 200);
		// adding image to frame 
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/Management/System/icons/hotel1.jpg"));
		
		// adding image to label
		JLabel l1 = new JLabel(i1);
		// first two arguments -- location i.e. x and y coordinate 
		// 2nd two arguments -- i.e. height and width of component
		l1.setBounds(0, 0, 1300, 700);
		add(l1);
		
		JLabel l2 = new JLabel("Hotel Management system");
		l2.setBounds(300, 0, 800, 100);
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("serif", Font.PLAIN, 70));
		l1.add(l2);
		
		JButton b1 = new JButton("Next");
		b1.setBackground(Color.WHITE);
		b1.setForeground(Color.BLACK);
		b1.setBounds(1000, 550, 140, 50);
		b1.addActionListener(this);
		l1.add(b1);

		// setting layout for placing components
		setLayout(null);
		
		// making frame visible 
		setVisible(true);
		
		while(true) {
			l2.setVisible(false);
			try {
				Thread.sleep(500);
			}
			catch(Exception e) {

			}
			l2.setVisible(true);
			try {
				Thread.sleep(500);
			}
			catch(Exception e) {}
			
		}
	}

	public static void main(String[] args) {
		new HotelManagementSystem();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new Login().setVisible(true);
		
		// closing the previous page reference
		this.setVisible(false);
	}
}
