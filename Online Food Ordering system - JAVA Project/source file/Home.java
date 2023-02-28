import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.JFrame;
class HomePage extends JFrame implements ActionListener
{
	JPanel p1;
	JLabel l1,l2;
	ImageIcon i1;
	JRadioButton admin,user;
	ButtonGroup bg1,bg2;
	public HomePage()
	{
		setVisible(true);
		setSize(550,500);
		setResizable(true);
		setTitle("HomePage");
		l1=new JLabel("Welcome to Online Safer Speeder Car Booking");
		l1.setFont(new Font("Serif",Font.BOLD,20));
		getContentPane().add(l1,BorderLayout.NORTH);
		javax.swing.Timer timer=new javax.swing.Timer(100,this);
		timer.start();
		buildComponents();
		designComponents();
		admin.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					Login log1=new Login();
				}
			}
		);
		user.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					User u1=new User();
					//u1.setBackground(Color.GREEN);
				}
			}
		);
	}
	
	public void actionPerformed(ActionEvent ae){
		String oldText=l1.getText();
		String newText=oldText.substring(1) + oldText.substring(0,1);
		l1.setText(newText);
	}
	public void buildComponents()
	{
		p1=new JPanel(new GridLayout(4,1,20,20));
		bg1=new ButtonGroup();
		bg2=new ButtonGroup();
		admin=new JRadioButton("Admin");
		user=new JRadioButton("User");
	}
	public void designComponents()
	{
		p1.add(l1);
		bg1.add(admin);bg2.add(user);
		admin.setFont(new Font("Serif",Font.BOLD,30));
		user.setFont(new Font("Serif",Font.BOLD,30));
		Box box1=Box.createHorizontalBox();
		p1.add(admin);p1.add(user);
		//p1.add(box1);
		p1.setBackground(Color.PINK);
		add(p1,BorderLayout.CENTER);
	}
}
public class Home
{
	public static void main(String[] args)
	{
		//System.out.println("Hello");
		HomePage f1=new HomePage();
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class Login extends JFrame implements ActionListener
{
	JButton submit;
	JPanel panel;
	JLabel label1,label2;
	JTextField text1;
	JPasswordField pwd;
	Login()
	{
		setVisible(true);
		setSize(200,200);
		setTitle("LOGIN FORM");
		setResizable(false);
		buildComponents();
		designComponents();
	
	}
	public void buildComponents()
	{
		panel=new JPanel();
		label1 = new JLabel("UserName:");
		text1 = new JTextField(15);
		label2 = new JLabel("Password");
		pwd= new JPasswordField(15);
		submit=new JButton("SUBMIT");
		//close=new JButton("CLOSE");
	}
	public void designComponents()
	{
		panel=new JPanel(new GridLayout(3,1,20,20));
		panel.add(label1);
		panel.add(text1);
		panel.add(label2);
		panel.add(pwd);
		panel.add(submit);
		//panel.add(close);
		panel.setBackground(Color.YELLOW);
		add(panel,BorderLayout.CENTER);
		submit.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String value1=text1.getText();
		String value2=pwd.getText();
		if (value1.equals("Gokila") && value2.equals("Gokila@123")) {
		AdminPage page=new AdminPage();
		page.setVisible(true);
		page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	else
	{
		System.out.println("enter the valid username and password");
		JOptionPane.showMessageDialog(this,"Incorrect login or password",
		"Error",JOptionPane.ERROR_MESSAGE);
	}
   }
}
	
class AdminPage extends JFrame 
{
	JLabel name,age,gender,email_id,mobileNo,address;
	JTextField t1,t2,t3,t4,t5,t6;
	JRadioButton r1,r2,r3;
	JPanel panel;
	JButton submit;
	public AdminPage()
	{
		setVisible(true);
		setSize(400,400);
		setResizable(false);
		setTitle("Registration Form");
		buildComponents();
		designComponents();//setBackground(Color.GREEN);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void buildComponents()
	{
		panel=new JPanel(new GridLayout(10,1,10,10));
		name=new JLabel("Name:");
		t1=new JTextField(20);
		age=new JLabel("Age:");
		t2=new JTextField(3);
		gender=new JLabel("Gender:");
		r1=new JRadioButton("Female");
		r2=new JRadioButton("Male");
		r3=new JRadioButton("Others");
		mobileNo=new JLabel("MobileNo:");
		t3=new JTextField(15);
		email_id=new JLabel("Emai-id:");
		t4=new JTextField(40);
		address=new JLabel("Address:");
		t5=new JTextField(50);
		submit=new JButton("Submit");
	}
	public void designComponents()
	{
		panel.add(name);
		panel.add(t1);
		panel.add(age);
		panel.add(t2);
		panel.add(gender);
		Box box1=Box.createHorizontalBox();
		box1.add(r1);box1.add(r2);box1.add(r3);
		panel.add(box1);
		panel.add(mobileNo);
		panel.add(t3);
		panel.add(email_id);
		panel.add(t4);
		panel.add(address);
		panel.add(t5);
		panel.add(submit,BorderLayout.SOUTH);
		add(panel,BorderLayout.CENTER);
		panel.setBackground(Color.GREEN);
		
	}
}
    
class User extends JFrame
{
	JLabel name,age,gender,email_id,mobileNo,address;
	JTextField t1,t2,t3,t4,t5;
	JRadioButton r1,r2,r3;
	JPanel panel;
	JButton submit;
	public User()
	{
		setVisible(true);
		setSize(400,400);
		setResizable(false);
		setTitle("Registration Form");
		buildComponents();
		designComponents();//setBackground(Color.GREEN);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void buildComponents()
	{
		panel=new JPanel(new GridLayout(10,1,10,10));
		name=new JLabel("Name:");
		t1=new JTextField(20);
		age=new JLabel("Age:");
		t2=new JTextField(3);
		gender=new JLabel("Gender:");
		r1=new JRadioButton("Female");
		r2=new JRadioButton("Male");
		r3=new JRadioButton("Others");
		mobileNo=new JLabel("MobileNo:");
		t3=new JTextField(15);
		email_id=new JLabel("Emai-id:");
		t4=new JTextField(40);
		address=new JLabel("Address:");
		t5=new JTextField(50);
		submit=new JButton("Submit");
	}
	public void designComponents()
	{
		panel.add(name);
		panel.add(t1);
		panel.add(age);
		panel.add(t2);
		panel.add(gender);
		Box box1=Box.createHorizontalBox();
		box1.add(r1);box1.add(r2);box1.add(r3);
		panel.add(box1);
		panel.add(mobileNo);
		panel.add(t3);
		panel.add(email_id);
		panel.add(t4);
		panel.add(address);
		panel.add(t5);
		panel.add(submit,BorderLayout.SOUTH);
		add(panel,BorderLayout.CENTER);
		panel.setBackground(Color.GREEN);
		
	}
}
