package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class AddEmployee extends JFrame implements ActionListener {

	JLabel name, age, gender, job, salary, phone, aadhar, email;
	JTextField t1, t2, t5, t6, t7, t8;
	JComboBox c1;
	JButton b1;
	JRadioButton r1, r2;

	public AddEmployee() {

		name = new JLabel("Name");
		name.setBounds(50, 20, 60, 30);
		name.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(name);

		age = new JLabel("Age");
		age.setBounds(50, 60, 60, 30);
		age.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(age);

		gender = new JLabel("Gender");
		gender.setBounds(50, 100, 60, 30);
		gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		gender.setBackground(Color.WHITE);
		add(gender);

		r1 = new JRadioButton("Male");
		r1.setBounds(160, 100, 68, 30);
		r1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		r1.setBackground(Color.WHITE);
		add(r1);

		r2 = new JRadioButton("Female");
		r2.setBounds(238, 100, 72, 30);
		r2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		r2.setBackground(Color.WHITE);
		add(r2);

		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);

		job = new JLabel("Job");
		job.setBounds(50, 140, 60, 30);
		job.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(job);

		String str[] = {"Manager", "Front Desk Clearks", "Porters", "HouseKeeping", "Kitehen Staff", "Room Service",
				"Waiter/Waitress", "Accountant", "Chef" };
		c1 = new JComboBox(str);
		c1.setBounds(160, 140, 150, 30);
		add(c1);

		salary = new JLabel("Salary");
		salary.setBounds(50, 180, 60, 30);
		salary.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(salary);

		phone = new JLabel("Phone");
		phone.setBounds(50, 220, 60, 30);
		phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(phone);

		aadhar = new JLabel("Aadhar");
		aadhar.setBounds(50, 260, 60, 30);
		aadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(aadhar);

		email = new JLabel("Email");
		email.setBounds(50, 300, 60, 30);
		email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(email);

		t1 = new JTextField();
		t1.setBounds(160, 20, 150, 30);
		add(t1);

		t2 = new JTextField();
		t2.setBounds(160, 60, 150, 30);
		add(t2);

		t5 = new JTextField();
		t5.setBounds(160, 180, 150, 30);
		add(t5);

		t6 = new JTextField();
		t6.setBounds(160, 220, 150, 30);
		add(t6);

		t7 = new JTextField();
		t7.setBounds(160, 260, 150, 30);
		add(t7);

		t8 = new JTextField();
		t8.setBounds(160, 300, 150, 30);
		add(t8);

		JLabel L1 = new JLabel("ADD EMPLOYEE DETAILS");
		L1.setBounds(400, 20, 500, 40);
		L1.setForeground(Color.BLUE);
		L1.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 25));
		add(L1);

		b1 = new JButton("Submit");
		b1.setBounds(160, 340, 150, 30);
		add(b1);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tenth.jpg"));
		Image i2 = i1.getImage().getScaledInstance(300, 270, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(400, 80, 300, 270);
		add(l1);

		// changing frame color
		getContentPane().setBackground(Color.WHITE);

		setLayout(null);
		setBounds(300, 180, 780, 550);
		setVisible(true);
		
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				// TODO Auto-generated method stub

				String name = t1.getText();
				String age = t2.getText();
				String salary = t5.getText();
				String phone = t6.getText();
				String aadhar = t7.getText();
				String email = t8.getText();

				String gender = null;
				if (r1.isSelected()) {
					gender = "male";
				} else if (r2.isSelected()) {
					gender = "female";
				}

				String job = (String) c1.getSelectedItem();

				try {
					Conn c = new Conn();
					String str = "Insert into employee values('" + name + "','" + age + "','" + gender + "','" + job
							+ "','" + salary + "','" + phone + "','" + aadhar + "','" + email + "')";

					c.s.executeUpdate(str);
					JOptionPane.showMessageDialog(null, "New employee added");
					setVisible(false);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	public static void main(String[] args) {
		new AddEmployee().setVisible(true);
	}

}
