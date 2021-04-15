package hotel.management.system;

import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
public class AddDriver extends JFrame implements ActionListener{

	JTextField t1, t2, t3, t4, t5;
	JComboBox c1, c2;
	JButton b1, b2;
	
	AddDriver(){
		
		JLabel driver = new JLabel("Add Driver");
		driver.setBounds(80, 10, 120, 30);
		driver.setFont(new Font("Tahuma", Font.PLAIN, 20));
		driver.setForeground(Color.BLUE);
		add(driver);
		
		JLabel name = new JLabel("Name");
		name.setBounds(40, 60, 100, 30);
		add(name);
		
		JLabel age = new JLabel("Age");
		age.setBounds(40, 100, 100, 30);
		add(age);
		
		JLabel gender = new JLabel("gender");
		gender.setBounds(40, 140, 100, 30);
		add(gender);
		
		JLabel carCompany = new JLabel("Car Company");
		carCompany.setBounds(40, 180, 100, 30);
		add(carCompany);
		
		JLabel carBrand = new JLabel("Car Brand");
		carBrand.setBounds(40, 220, 100, 30);
		add(carBrand);
		
		JLabel available = new JLabel("Available");
		available.setBounds(40, 260, 100, 30);
		add(available);
		
		JLabel location = new JLabel("Location");
		location.setBounds(40, 300, 100, 30);
		add(location);
		
		b1 = new JButton("Add");
		b1.setBounds(40, 360, 110, 30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBounds(180, 360, 110, 30);
		b2.addActionListener(this);
		add(b2);
		
		t1 = new JTextField();
		t1.setBounds(160, 60, 130, 30);
		add(t1);
		
		t2 = new JTextField();
		t2.setBounds(160, 100, 130, 30);
		add(t2);
		
		t3 = new JTextField();
		t3.setBounds(160, 180, 130, 30);
		add(t3);
		
		t4 = new JTextField();
		t4.setBounds(160, 220, 130, 30);
		add(t4);
		
		t5 = new JTextField();
		t5.setBounds(160, 300, 130, 30);
		add(t5);
		
		String[] str1 = {"Male", "Female"};
		c1 = new JComboBox(str1);
		c1.setBounds(160, 140, 130, 30);
		c1.setBackground(Color.WHITE);
		add(c1);
		
		String[] str2 = {"Yes", "No"};
		c2 = new JComboBox(str2);
		c2.setBounds(160, 260, 130, 30);
		c2.setBackground(Color.WHITE);
		add(c2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.jpg"));
		Image i2 = i1.getImage().getScaledInstance(450, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(320, 65, 450, 300);
		add(l1);
		
		getContentPane().setBackground(Color.WHITE);
		
		setLayout(null);
		setBounds(280, 220, 800, 500);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			String name = t1.getText();
			String age = t2.getText();
			String gender = (String) c1.getSelectedItem();
			String car_company = t3.getText();
			String car_brand = t4.getText();
			String available = (String) c2.getSelectedItem();
			String location = t5.getText();
			
			Conn c = new Conn();
			try {
				String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+car_company+"','"+car_brand+"','"+available+"','"+location+"')";
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null,  "New Driver Added");
				setVisible(true);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(ae.getSource() == b2){
			this.setVisible(false);
		}
	}
	public static void main(String [] args) {
		new AddDriver();
	}
}
