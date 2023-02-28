import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.Color;
import java.util.Scanner;
import java.io.File;

class MyHomePage extends JFrame 							//HomePage
{
	JButton customer,employee,exit;
	JPanel p1;
	JLabel l;
	Toolkit tools; 
	Dimension d;
	public MyHomePage()
	{
		setVisible(true);
		setTitle("Food World");
		l=new JLabel("                                       Welcome to Food World!!!");
		l.setFont(new Font("Serif",Font.BOLD,50));  
		buildComponents();
		designComponents();
		customer.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					//Payment p1=new Payment();
					CustomerFrame c1=new CustomerFrame();
					c1.setVisible(true);
				}
			}
		);
		
		employee.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					EmployeeFrame e1=new EmployeeFrame();
					e1.setVisible(true);
				}
			}
		);
		exit.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					if(JOptionPane.showConfirmDialog(new JFrame(),"Do you really want to exit..?")==JOptionPane.YES_OPTION)
					{
						System.exit(0);
					}
				}
			}
		);
				
	}
	
	public void buildComponents()
	{
		customer=new JButton("Customer");
		employee=new JButton("Employee");
		exit=new JButton("Exit");
		p1=new JPanel(new GridLayout(4,1));
		tools=Toolkit.getDefaultToolkit();
		d=tools.getScreenSize();
		setSize(d.width,d.height);
	}
	
	public void designComponents()
	{
		p1.add(l);
		p1.add(customer);
		p1.add(employee);
		p1.add(exit);
		add(p1);
		customer.setFont(new Font("Italic",Font.BOLD,30));
		employee.setFont(new Font("Italic",Font.BOLD,30));
		exit.setFont(new Font("Italic",Font.BOLD,30));
		p1.setBackground(Color.PINK);
	}
}

public class HomePage
{
	public static void main(String ... args)
	{
		System.out.println("Sangee");
		MyHomePage f1=new MyHomePage();
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class CustomerFrame extends JFrame									//customer
{

	JButton submit,back,b1;
	JTextField t1,t2,t3,t4;
	JPanel p1;
	JLabel name,address,email,phNo,password;
	JPasswordField pwd;
	public CustomerFrame()
	{
		setTitle("Customer");
		setSize(1300,800);
		setLocation(40,0);
		buildComponents();
		designComponents();
		back.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					setVisible(false);
				}
			}
		);
		submit.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					CustomerFrame c=new CustomerFrame();
					boolean var=(t1.getText().equals("")) || (t2.getText().equals("")) || (t3.getText().equals("")) ||(t4.getText().equals("")) || (pwd.getText().equals(""));
					if(var==false)
					{
						try
						{
							DBHandler db=new DBHandler();
							Customer cu=new Customer(t1.getText(), t2.getText(), t3.getText(),t4.getText(), pwd.getText());
							int res=db.insertCustomer(cu);
							if(res>0)
							{
								JOptionPane.showMessageDialog(c,"Registration successful");
								FoodOrder fo=new FoodOrder();
							}
							else
								JOptionPane.showMessageDialog(c,"Insertation unsuccessful","data base Problem" , JOptionPane.ERROR_MESSAGE);
						}
						catch(Exception aa)
						{
							aa.printStackTrace();
						}
					}
					else
					{
						JOptionPane.showMessageDialog(c,"Enter your Details " ,"Insufficient Data",JOptionPane.ERROR_MESSAGE); 
					}
			
				}
			}

		);		
		
		
	}
	public void buildComponents()
	{
		name=new JLabel("Name :        ");
		t1=new JTextField(20);
		address=new JLabel("Address:    ");
		t2=new JTextField(20);
		email=new JLabel("E-mail Id :   ");
		t3=new JTextField(20);
		phNo=new JLabel("Phone No :  ");
		t4=new JTextField(20);
		password=new JLabel("Password (atleast 8 characters) :");
		pwd=new JPasswordField(20);
		submit=new JButton("Submit");
		back=new JButton("<- Back");
		//b1=new JButton("Click here if you are already a customer");
		p1=new JPanel((new GridLayout(6,2)))
		{
			public void paintComponent(Graphics g)
			{
				ImageIcon icon=new ImageIcon("CustomerFrame.jpg");
				Image image=icon.getImage();
				g.drawImage(image,0,0,null);
			}
		};
	}
	
	public void designComponents()
	{
		p1.add(name);
		p1.add(t1);
		p1.add(address);
		p1.add(t2);
		p1.add(email);
		p1.add(t3);
		p1.add(phNo);
		p1.add(t4);
		p1.add(password);
		p1.add(pwd);
		p1.add(back);
		p1.add(submit,BorderLayout.SOUTH);
		//p1.add(b1,BorderLayout.NORTH);
		add(p1);
		name.setFont(new Font("Italic",Font.BOLD,30));
		address.setFont(new Font("Italic",Font.BOLD,30));
		email.setFont(new Font("Italic",Font.BOLD,30));
		phNo.setFont(new Font("Italic",Font.BOLD,30));
		password.setFont(new Font("Italic",Font.BOLD,30));
		submit.setFont(new Font("Serif",Font.BOLD,30));
		back.setFont(new Font("Serif",Font.BOLD,30));
		t1.setFont(new Font("Italic",Font.BOLD,30));
		t2.setFont(new Font("Italic",Font.BOLD,30));
		t3.setFont(new Font("Italic",Font.BOLD,30));
		t4.setFont(new Font("Italic",Font.BOLD,30));
		pwd.setFont(new Font("Italic",Font.BOLD,30));

	}
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
	}
	
}



class FoodOrder extends JFrame                                        //FoodOrder
{
	JButton breakfast;
	JButton lunch;
	JButton dinner;
	JButton dessert;
	JButton back;
	JPanel p1;
	Toolkit tools;
	Dimension d;
	public FoodOrder()
	{
		setVisible(true);
		setTitle("Online Food Order");
		buildComponents();
		designComponents();
		breakfast.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					BreakFastFrame bf=new BreakFastFrame();
					bf.setVisible(true);
				}
			}
		);
		lunch.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					LunchFrame lf=new LunchFrame();
					lf.setVisible(true);
				}
			}
		);
		dinner.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					DinnerFrame bf=new DinnerFrame();
					bf.setVisible(true);
				}
			}
		);
		dessert.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					DessertFrame def=new DessertFrame();
					def.setVisible(true);
				}
			}
		);
		back.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					setVisible(false);
				}
			}
		);
	}
	
	public void buildComponents()
	{
		breakfast=new JButton("Breakfast");
		lunch=new JButton("Lunch");
		dinner=new JButton("Dinner");
		dessert=new JButton("Dessert receips");
		back=new JButton("<- Back");
		p1=new JPanel(new GridLayout(5,1));
		tools=Toolkit.getDefaultToolkit();
		d=tools.getScreenSize();
		setSize(d.width,d.height);
	}
	
	public void designComponents()
	{
		p1.add(breakfast);
		p1.add(lunch);
		p1.add(dinner);
		p1.add(dessert);
		p1.add(back);
		add(p1);
		breakfast.setFont(new Font("Italic",Font.BOLD,30));
		lunch.setFont(new Font("Italic",Font.BOLD,30));
		dinner.setFont(new Font("Italic",Font.BOLD,30));
		dessert.setFont(new Font("Italic",Font.BOLD,30));
		back.setFont(new Font("Italic",Font.BOLD,30));
		breakfast.setBackground(Color.YELLOW);
		lunch.setBackground(Color.CYAN);
		dinner.setBackground(new Color(0.6f,0.2f,0.8f));
		dessert.setBackground(Color.GRAY);
		back.setBackground(Color.ORANGE);
	}
	
}

class BreakFastFrame extends JFrame  										 //breakfast
{
	JButton tamount;
	JButton back;
	JCheckBox c1,c2,c3,c4,c5;
	JTextField t1,t2,t3,t4,t5;
	JLabel l1,l2,l3,l4,l5;
	JLabel item,amount,quantity;
	JTextField total;
	JPanel p1;
	Toolkit tools;
	Dimension d;
	public BreakFastFrame()
	{
		setVisible(true);
		setTitle("BreakFast");
		buildComponents();
		designComponents();
		total.setEditable(false);
		back.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					setVisible(false);
				}
			}
		);
		tamount.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{

					int qty=0;
					int dosaAmt=0;
					int idlyAmt=0;
					int chpAmt=0;
					int pooriAmt=0;
					int pongalAmt=0;
					
					if (c1.isSelected())
					{
						qty= Integer.parseInt(t1.getText()); 
						dosaAmt= qty * 25 ;
					}
					if (c2.isSelected())
					{
						qty= Integer.parseInt(t2.getText()); 
						idlyAmt= qty * 30 ;
					}
					if (c3.isSelected())
					{
						qty= Integer.parseInt(t3.getText()); 
						chpAmt= qty * 40 ;
					}
					if (c4.isSelected())
					{
						qty= Integer.parseInt(t4.getText()); 
						pooriAmt= qty * 54 ;
					}
					if (c5.isSelected())
					{
						qty= Integer.parseInt(t5.getText()); 
						pongalAmt= qty * 68 ;
					}
					
					double billAmt = dosaAmt+ idlyAmt + chpAmt + pooriAmt + pongalAmt;
					total.setText(String.valueOf(billAmt));
					Payment p1=new Payment(total.getText());
					
				}
			}
		);
	} 
	public void buildComponents()
	{
		tools=Toolkit.getDefaultToolkit();
		d=tools.getScreenSize();                 
		setSize(d.width,d.height);
		tamount=new JButton("Total Amount");
		back=new JButton("<- Back");
		item=new JLabel(" Items ");
		amount=new JLabel(" Amount " );
		quantity=new JLabel(" No.Of items ");
		c1=new JCheckBox("  Dosa    ");
		c2=new JCheckBox("  Idly   ");
		c3=new JCheckBox("  Chapathi   ");
		c4=new JCheckBox("  Poori   ");
		c5=new JCheckBox("  Pongal vada");
		l1=new JLabel("  $25  ");
		l2=new JLabel("  $30  ");
		l3=new JLabel("  $40  ");
		l4=new JLabel("  $54  ");
		l5=new JLabel("  $68  ");
		t1=new JTextField(5);
		t2=new JTextField(5);
		t3=new JTextField(5);
		t4=new JTextField(5);
		t5=new JTextField(5);
		total=new JTextField(10);
		p1=new JPanel(new GridLayout(7,3))
		{
			public void paintComponent(Graphics g)
			{
				ImageIcon icon=new ImageIcon("breakfast.jpg");
				Image image=icon.getImage();
				g.drawImage(image,0,0,null);
			}
		};

	}
	
	public void designComponents()
	{ 
		p1.add(item);
		p1.add(amount);
		p1.add(quantity);
		p1.add(c1);
		p1.add(l1);
		p1.add(t1);
		p1.add(c2);
		p1.add(l2);
		p1.add(t2);
		p1.add(c3);
		p1.add(l3);
		p1.add(t3);
		p1.add(c4);
		p1.add(l4);
		p1.add(t4);
		p1.add(c5);
		p1.add(l5);
		p1.add(t5);
		p1.add(back,BorderLayout.SOUTH);
		p1.add(tamount);
		p1.add(total);
		add(p1);
		item.setFont(new Font("Italic",Font.BOLD,40));
		amount.setFont(new Font("Italic",Font.BOLD,40));
		quantity.setFont(new Font("Italic",Font.BOLD,40));
		c1.setFont(new Font("Italic",Font.BOLD,30));
		c2.setFont(new Font("Italic",Font.BOLD,30));
		c3.setFont(new Font("Italic",Font.BOLD,30));
		c4.setFont(new Font("Italic",Font.BOLD,30));
		c5.setFont(new Font("Italic",Font.BOLD,30));
		l1.setFont(new Font("Italic",Font.BOLD,30));
		l2.setFont(new Font("Italic",Font.BOLD,30));
		l3.setFont(new Font("Italic",Font.BOLD,30));
		l4.setFont(new Font("Italic",Font.BOLD,30));
		l5.setFont(new Font("Italic",Font.BOLD,30));
		t1.setFont(new Font("Italic",Font.BOLD,30));
		t2.setFont(new Font("Italic",Font.BOLD,30));
		t3.setFont(new Font("Italic",Font.BOLD,30));
		t4.setFont(new Font("Italic",Font.BOLD,30));
		t5.setFont(new Font("Italic",Font.BOLD,30));
		total.setFont(new Font("Italic",Font.BOLD,30));
		tamount.setFont(new Font("Serif",Font.BOLD,30));
		back.setFont(new Font("Serif",Font.BOLD,30));
	}
	
	
}

class Payment extends  JFrame											// Payment Methods
{
	JButton b1,b2;
	JButton back;
	JPanel p1;
	
	public Payment(String totalAmount)
	{
		setVisible(true);
		setTitle("Payment mode");
		setSize(950,800);
		setLocation(50,20);
		buildComponents();
		designComponents();
		back.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					setVisible(false);
				}
			}
		);
		b1.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					Cash ch=new Cash();
				}
			}
		);
		b2.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					PayNowFrame pn=new PayNowFrame(totalAmount);
				}
			}
		);
	}
	public void buildComponents()
	{
		b1=new JButton("Cash On Delivery");
		b2=new JButton("Pay Now");
		back=new JButton("<-Back");
		p1=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				ImageIcon icon=new ImageIcon("Payment.jpg");
				Image image=icon.getImage();
				g.drawImage(image,0,0,null);
			}
		};
	}
	
	public void designComponents()
	{
		p1.add(back,BorderLayout.SOUTH);
		p1.add(b1);
		p1.add(b2);
		b1.setFont(new Font("Italic",Font.BOLD,30));
		b2.setFont(new Font("Italic",Font.BOLD,30));
		back.setFont(new Font("Serif",Font.BOLD,30));
		add(p1);
	}
	
}

class PayNowFrame extends JFrame				//Online Payment
{
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4;
	JButton submit,back;
	JPanel p1;
	JComboBox cb;
	
	
	public PayNowFrame(String totalAmount)
	{
		setVisible(true);
		setSize(900,800);
		setTitle("Online Payment");
		setLocation(100,20);
		buildComponents();
		t4.setEditable(false);
		designComponents(totalAmount);
		back.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					setVisible(false);
				}
			}
		);
		submit.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					PayNowFrame p=new PayNowFrame(totalAmount);
					boolean var=(t1.getText().equals("")) || (t2.getText().equals("")) || (t3.getText().equals("")) ||(t4.getText().equals(""));
					if(var==false)
					{
						try
						{
							DBHandler db=new DBHandler();
							PayNow pay=new PayNow(t1.getText(), t2.getText(), t3.getText(),t4.getText());
							int res=db.insertPayment(pay);
							if(res>0)
							{
								int exp=Integer.parseInt(t2.getText());
								if(exp>2020)
								{
									p.setVisible(false);
									JOptionPane.showMessageDialog(p,"Succesfully paid..you will get the delivery soon...");
									
								}
								else
								{
									p.setVisible(false);
									JOptionPane.showMessageDialog(p,"Your card is expired..Use vaild card..");
								}
							}
							else
							{
								p.setVisible(false);
								JOptionPane.showMessageDialog(p,"Failed to pay","data base Problem" , JOptionPane.ERROR_MESSAGE);
							}	
						}
						catch(Exception aa)
						{
							aa.printStackTrace();
						}
					}
					else
					{
						JOptionPane.showMessageDialog(p,"Enter all the Details " ,"Insufficient Data",JOptionPane.ERROR_MESSAGE); 
					}
			
				}
			}

		);		
	}
	
	public void buildComponents()
	{
		l1=new JLabel(" Card No  (12-digit No.)" );
		l2=new JLabel(" Expiry Date (Enter the year): ");
		l3=new JLabel("  CCV Pin : ");
		l5=new JLabel(" Select the card : ");
		l4=new JLabel(" Total Amount : ");
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JTextField(20);
		t4=new JTextField(20);
		back=new JButton("<- Back");
		submit=new JButton("Submit");
		cb=new JComboBox();
		cb.addItem("Credit Card");
		cb.addItem("Debit Card");
		p1=new JPanel(new GridLayout(6,2))
		{
			public void paintComponent(Graphics g)
			{
				ImageIcon icon=new ImageIcon("PayNow.jpg");
				Image image=icon.getImage();
				g.drawImage(image,0,0,null);
			}
		};
	}
	
	public void designComponents(String totalAmount)
	{
		t4.setText(totalAmount);
		p1.add(l5);
		p1.add(cb,BorderLayout.NORTH);
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p1.add(l3);
		p1.add(t3);
		p1.add(l4);
		p1.add(t4);
		p1.add(back);
		p1.add(submit);
		add(p1);
		cb.setFont(new Font("Italic",Font.BOLD,50));
		l5.setFont(new Font("Italic",Font.BOLD,40));
		l1.setFont(new Font("Italic",Font.BOLD,30));
		l2.setFont(new Font("Italic",Font.BOLD,30));
		l3.setFont(new Font("Italic",Font.BOLD,30));
		l4.setFont(new Font("Italic",Font.BOLD,30));
		t1.setFont(new Font("Italic",Font.BOLD,30));
		t2.setFont(new Font("Italic",Font.BOLD,30));
		t3.setFont(new Font("Italic",Font.BOLD,30));
		t4.setFont(new Font("Italic",Font.BOLD,30));
		back.setFont(new Font("Serif",Font.BOLD,50));
		submit.setFont(new Font("Serif",Font.BOLD,50));
	}
}

class Cash extends JFrame implements ActionListener
{
	JLabel l1;
	JPanel p1;
	
	public Cash()
	{
		setVisible(true);
		setSize(900,800);
		setLocation(100,20);
		setTitle("Delivary");
		l1=new JLabel(" You will get the delivery soon..Thank you...");
		//getContentPane().add(l1,BorderLayout.NORTH);
		javax.swing.Timer timer=new javax.swing.Timer(100,this);
		timer.start();
		buildComponents();
		designComponents();
	}
	public void actionPerformed(ActionEvent ae)
	{
		String l2=l1.getText();
		String  l3=l2.substring(1) + l2.substring(0,1);
		l1.setText(l3);
	}
	
	public void buildComponents()
	{
		
		p1=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				ImageIcon icon=new ImageIcon("Cash.jpg");
				Image image=icon.getImage();
				g.drawImage(image,0,0,null);
			}
		};
	}
	
	public void designComponents()
	{
		p1.add(l1,BorderLayout.CENTER);
		add(p1);
		l1.setFont(new Font("Italic",Font.BOLD,40));
	}
	
}

class LunchFrame extends JFrame
{
	JButton tamount;
	JButton back;
	JCheckBox c1,c2,c3,c4,c5;
	JTextField t1,t2,t3,t4,t5;
	JLabel l1,l2,l3,l4,l5;
	JLabel item,amount,quantity;
	JTextField total;
	JPanel p1;
	Toolkit tools;
	Dimension d;
	public LunchFrame()
	{
		setVisible(true);
		setTitle("Lunch");
		buildComponents();
		designComponents();
		back.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					setVisible(false);
				}
			}
		);
		tamount.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					int qty=0;
					int mealsAmt=0;
					int chickenAmt=0;
					int muttonAmt=0;
					int vegAmt=0;
					int curdAmt=0;
					
					if (c1.isSelected())
					{
						qty= Integer.parseInt(t1.getText()); 
						mealsAmt= qty * 70 ;
					}
					if (c2.isSelected())
					{
						qty= Integer.parseInt(t2.getText()); 
						chickenAmt= qty * 120 ;
					}
					if (c3.isSelected())
					{
						qty= Integer.parseInt(t3.getText()); 
						muttonAmt= qty * 100 ;
					}
					if (c4.isSelected())
					{
						qty= Integer.parseInt(t4.getText()); 
						vegAmt= qty * 90 ;
					}
					if (c5.isSelected())
					{
						qty= Integer.parseInt(t5.getText()); 
						curdAmt= qty * 60 ;
					}
					
					double billAmt = mealsAmt + chickenAmt + muttonAmt+ vegAmt + curdAmt;
					total.setText(String.valueOf(billAmt));
					Payment p1=new Payment(total.getText());

				}
			}
		);
	} 
	public void buildComponents()
	{
		tools=Toolkit.getDefaultToolkit();
		d=tools.getScreenSize();                 
		setSize(d.width,d.height);
		tamount=new JButton("Total Amount");
		back=new JButton("<- Back");
		item=new JLabel(" Items ");
		amount=new JLabel(" Amount " );
		quantity=new JLabel(" No.Of items ");
		c1=new JCheckBox("  Meals    ");
		c2=new JCheckBox("  Chicken Biriyani   ");
		c3=new JCheckBox("  Mutton Biriyani   ");
		c4=new JCheckBox("  Veg Biriyani   ");
		c5=new JCheckBox("  Curd Rice ");
		l1=new JLabel("  $70  ");
		l2=new JLabel("  $120  ");
		l3=new JLabel("  $100  ");
		l4=new JLabel("  $90 ");
		l5=new JLabel("  $60  ");
		t1=new JTextField(5);
		t2=new JTextField(5);
		t3=new JTextField(5);
		t4=new JTextField(5);
		t5=new JTextField(5);
		total=new JTextField(20);
		p1=new JPanel(new GridLayout(7,3))
		{
			public void paintComponent(Graphics g)
			{
				ImageIcon icon=new ImageIcon("lunch.jpg");
				Image image=icon.getImage();
				g.drawImage(image,0,0,null);
			}
		};

	}
	
	public void designComponents()
	{ 
		p1.add(item);
		p1.add(amount);
		p1.add(quantity);
		p1.add(c1);
		p1.add(l1);
		p1.add(t1);
		p1.add(c2);
		p1.add(l2);
		p1.add(t2);
		p1.add(c3);
		p1.add(l3);
		p1.add(t3);
		p1.add(c4);
		p1.add(l4);
		p1.add(t4);
		p1.add(c5);
		p1.add(l5);
		p1.add(t5);
		p1.add(back,BorderLayout.SOUTH);
		p1.add(tamount);
		p1.add(total);
		add(p1);
		item.setFont(new Font("Italic",Font.BOLD,40));
		amount.setFont(new Font("Italic",Font.BOLD,40));
		quantity.setFont(new Font("Italic",Font.BOLD,40));
		c1.setFont(new Font("Italic",Font.BOLD,30));
		c2.setFont(new Font("Italic",Font.BOLD,30));
		c3.setFont(new Font("Italic",Font.BOLD,30));
		c4.setFont(new Font("Italic",Font.BOLD,30));
		c5.setFont(new Font("Italic",Font.BOLD,30));
		l1.setFont(new Font("Italic",Font.BOLD,30));
		l2.setFont(new Font("Italic",Font.BOLD,30));
		l3.setFont(new Font("Italic",Font.BOLD,30));
		l4.setFont(new Font("Italic",Font.BOLD,30));
		l5.setFont(new Font("Italic",Font.BOLD,30));
		t1.setFont(new Font("Italic",Font.BOLD,30));
		t2.setFont(new Font("Italic",Font.BOLD,30));
		t3.setFont(new Font("Italic",Font.BOLD,30));
		t4.setFont(new Font("Italic",Font.BOLD,30));
		t5.setFont(new Font("Italic",Font.BOLD,30));
		total.setFont(new Font("Italic",Font.BOLD,30));
		tamount.setFont(new Font("Serif",Font.BOLD,30));
		tamount.setFont(new Font("Serif",Font.BOLD,30));
		back.setFont(new Font("Serif",Font.BOLD,30));
	}
	
	
}

class DessertFrame extends JFrame
{
	JButton tamount;
	JButton back;
	JCheckBox c1,c2,c3,c4,c5;
	JTextField t1,t2,t3,t4,t5;
	JLabel l1,l2,l3,l4,l5;
	JLabel item,amount,quantity;
	JTextField total;
	JPanel p1;
	Toolkit tools;
	Dimension d;
	public DessertFrame()
	{
		setVisible(true);
		setTitle("Dessert Receipes");
		buildComponents();
		designComponents();
		back.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					setVisible(false);
				}
			}
		);
		tamount.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					int qty=0;
					int iceAmt=0;
					int cookAmt=0;
					int juiceAmt=0;
					int cakeAmt=0;
					int pastAmt=0;
					
					if (c1.isSelected())
					{
						qty= Integer.parseInt(t1.getText()); 
						iceAmt= qty * 50 ;
					}
					if (c2.isSelected())
					{
						qty= Integer.parseInt(t2.getText()); 
						cookAmt= qty * 45 ;
					}
					if (c3.isSelected())
					{
						qty= Integer.parseInt(t3.getText()); 
						juiceAmt= qty * 69 ;
					}
					if (c4.isSelected())
					{
						qty= Integer.parseInt(t4.getText()); 
						cakeAmt= qty * 88 ;
					}
					if (c5.isSelected())
					{
						qty= Integer.parseInt(t5.getText()); 
						pastAmt= qty * 96 ;
					}
					
					double billAmt = iceAmt + cookAmt + juiceAmt + cakeAmt + pastAmt;
					total.setText(String.valueOf(billAmt));
					Payment p1=new Payment(total.getText());
				}
			}
		);
	} 
	public void buildComponents()
	{
		tools=Toolkit.getDefaultToolkit();
		d=tools.getScreenSize();                 
		setSize(d.width,d.height);
		tamount=new JButton("Total Amount");
		back=new JButton("<- Back");
		item=new JLabel(" Items ");
		amount=new JLabel(" Amount " );
		quantity=new JLabel(" No.Of items ");
		c1=new JCheckBox("  Icecream    ");
		c2=new JCheckBox("  Cookies   ");
		c3=new JCheckBox("  Juice  ");
		c4=new JCheckBox("  Cake  ");
		c5=new JCheckBox("  Pastries ");
		l1=new JLabel("  $50  ");
		l2=new JLabel("  $45  ");
		l3=new JLabel("  $69  ");
		l4=new JLabel("  $88  ");
		l5=new JLabel("  $96 ");
		t1=new JTextField(5);
		t2=new JTextField(5);
		t3=new JTextField(5);
		t4=new JTextField(5);
		t5=new JTextField(5);
		total=new JTextField(10);
		p1=new JPanel(new GridLayout(7,3))
		{
			public void paintComponent(Graphics g)
			{
				ImageIcon icon=new ImageIcon("dessert.jpg");
				Image image=icon.getImage();
				g.drawImage(image,0,0,null);
			}
		};

	}
	
	public void designComponents()
	{ 
		p1.add(item);
		p1.add(amount);
		p1.add(quantity);
		p1.add(c1);
		p1.add(l1);
		p1.add(t1);
		p1.add(c2);
		p1.add(l2);
		p1.add(t2);
		p1.add(c3);
		p1.add(l3);
		p1.add(t3);
		p1.add(c4);
		p1.add(l4);
		p1.add(t4);
		p1.add(c5);
		p1.add(l5);
		p1.add(t5);
		p1.add(back,BorderLayout.SOUTH);
		p1.add(tamount);
		p1.add(total);
		add(p1);
		item.setFont(new Font("Italic",Font.BOLD,40));
		amount.setFont(new Font("Italic",Font.BOLD,40));
		quantity.setFont(new Font("Italic",Font.BOLD,40));
		c1.setFont(new Font("Italic",Font.BOLD,30));
		c2.setFont(new Font("Italic",Font.BOLD,30));
		c3.setFont(new Font("Italic",Font.BOLD,30));
		c4.setFont(new Font("Italic",Font.BOLD,30));
		c5.setFont(new Font("Italic",Font.BOLD,30));
		l1.setFont(new Font("Italic",Font.BOLD,30));
		l2.setFont(new Font("Italic",Font.BOLD,30));
		l3.setFont(new Font("Italic",Font.BOLD,30));
		l4.setFont(new Font("Italic",Font.BOLD,30));
		l5.setFont(new Font("Italic",Font.BOLD,30));
		tamount.setFont(new Font("Serif",Font.BOLD,30));
		back.setFont(new Font("Serif",Font.BOLD,30));
		t1.setFont(new Font("Italic",Font.BOLD,30));
		t2.setFont(new Font("Italic",Font.BOLD,30));
		t3.setFont(new Font("Italic",Font.BOLD,30));
		t4.setFont(new Font("Italic",Font.BOLD,30));
		t5.setFont(new Font("Italic",Font.BOLD,30));
		total.setFont(new Font("Italic",Font.BOLD,30));
		tamount.setFont(new Font("Serif",Font.BOLD,30));
	}
	
	
}



class DinnerFrame extends JFrame
{
	JButton tamount;
	JButton back;
	JCheckBox c1,c2,c3,c4,c5;
	JTextField t1,t2,t3,t4,t5;
	JLabel l1,l2,l3,l4,l5;
	JLabel item,amount,quantity;
	JTextField total;
	JPanel p1;
	Toolkit tools;
	Dimension d;
	public DinnerFrame()
	{
		setVisible(true);
		setTitle("Dinner");
		buildComponents();
		designComponents();
		back.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					setVisible(false);
				}
			}
		);
		tamount.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					int qty=0;
					int paroAmt=0;
					int idlyAmt=0;
					int gopiAmt=0;
					int gheeAmt=0;
					int nooAmt=0;
					
					if (c1.isSelected())
					{
						qty= Integer.parseInt(t1.getText()); 
						paroAmt= qty * 65 ;
					}
					if (c2.isSelected())
					{
						qty= Integer.parseInt(t2.getText()); 
						idlyAmt= qty * 25 ;
					}
					if (c3.isSelected())
					{
						qty= Integer.parseInt(t3.getText()); 
						gopiAmt= qty * 70 ;
					}
					if (c4.isSelected())
					{
						qty= Integer.parseInt(t4.getText()); 
						gheeAmt= qty * 57 ;
					}
					if (c5.isSelected())
					{
						qty= Integer.parseInt(t5.getText()); 
						nooAmt= qty * 120 ;
					}
					
					double billAmt = paroAmt + idlyAmt + gopiAmt + gheeAmt + nooAmt ;
					total.setText(String.valueOf(billAmt));
					Payment p1=new Payment(total.getText());
				}
			}
		);
	} 
	public void buildComponents()
	{
		tools=Toolkit.getDefaultToolkit();
		d=tools.getScreenSize();                 
		setSize(d.width,d.height);
		tamount=new JButton("Total Amount");
		back=new JButton("<- Back");
		item=new JLabel(" Items ");
		amount=new JLabel(" Amount " );
		quantity=new JLabel(" No.Of items ");
		c1=new JCheckBox("  Parotta    ");
		c2=new JCheckBox("  Idly   ");
		c3=new JCheckBox("  Gopi Manchurian   ");
		c4=new JCheckBox("  Ghee Rost		");
		c5=new JCheckBox("  Noodles");
		l1=new JLabel("  $65  ");
		l2=new JLabel("  $25  ");
		l3=new JLabel("  $70  ");
		l4=new JLabel("  $57  ");
		l5=new JLabel("  $120  ");
		t1=new JTextField(5);
		t2=new JTextField(5);
		t3=new JTextField(5);
		t4=new JTextField(5);
		t5=new JTextField(5);
		total=new JTextField(10);
		p1=new JPanel(new GridLayout(7,3))
		{
			public void paintComponent(Graphics g)
			{
				ImageIcon icon=new ImageIcon("dinner.jpg");
				Image image=icon.getImage();
				g.drawImage(image,0,0,null);
			}
		};

	}
	
	public void designComponents()
	{ 
		p1.add(item);
		p1.add(amount);
		p1.add(quantity);
		p1.add(c1);
		p1.add(l1);
		p1.add(t1);
		p1.add(c2);
		p1.add(l2);
		p1.add(t2);
		p1.add(c3);
		p1.add(l3);
		p1.add(t3);
		p1.add(c4);
		p1.add(l4);
		p1.add(t4);
		p1.add(c5);
		p1.add(l5);
		p1.add(t5);
		p1.add(back,BorderLayout.SOUTH);
		p1.add(tamount);
		p1.add(total);
		add(p1);
		item.setFont(new Font("Italic",Font.BOLD,40));
		amount.setFont(new Font("Italic",Font.BOLD,40));
		quantity.setFont(new Font("Italic",Font.BOLD,40));
		c1.setFont(new Font("Italic",Font.BOLD,30));
		c2.setFont(new Font("Italic",Font.BOLD,30));
		c3.setFont(new Font("Italic",Font.BOLD,30));
		c4.setFont(new Font("Italic",Font.BOLD,30));
		c5.setFont(new Font("Italic",Font.BOLD,30));
		l1.setFont(new Font("Italic",Font.BOLD,30));
		l2.setFont(new Font("Italic",Font.BOLD,30));
		l3.setFont(new Font("Italic",Font.BOLD,30));
		l4.setFont(new Font("Italic",Font.BOLD,30));
		l5.setFont(new Font("Italic",Font.BOLD,30));
		t1.setFont(new Font("Italic",Font.BOLD,30));
		t2.setFont(new Font("Italic",Font.BOLD,30));
		t3.setFont(new Font("Italic",Font.BOLD,30));
		t4.setFont(new Font("Italic",Font.BOLD,30));
		t5.setFont(new Font("Italic",Font.BOLD,30));
		total.setFont(new Font("Italic",Font.BOLD,30));
		tamount.setFont(new Font("Serif",Font.BOLD,30));
		tamount.setFont(new Font("Serif",Font.BOLD,30));
		back.setFont(new Font("Serif",Font.BOLD,30));
	}
	
}

class EmployeeFrame extends JFrame
{
	JButton b1;
	//JButton b2;
	JPanel p1;
	JButton back;
	
	public EmployeeFrame()
	{
		setTitle("Employee");
		setSize(1200,700);
		setLocation(40,0);
		buildComponents();
		designComponents();
		b1.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					TermsCond tc=new TermsCond();
				}
			}
		);
		
	/*	b2.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					SeeEmp s1=new SeeEmp();
				}
			}
		);*/
		back.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					setVisible(false);
				}
			}
		);
				
	}
	
	
	public void buildComponents()
	{
		back=new JButton("<- Back");
		b1=new JButton("Register Employee");
	//	b2=new JButton("See My details");
		p1=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				ImageIcon icon=new ImageIcon("employee.jpg");
				Image image=icon.getImage();
				
				
				g.drawImage(image,0,0,null);
			}
		};
	}
	
	public void designComponents()
	{
		//p1.add(b2);
		p1.add(back);
		p1.add(b1);
		add(p1);
		b1.setFont(new Font("Italic",Font.BOLD,30));
		back.setFont(new Font("Italic",Font.BOLD,30));
	}
}

class AddEmp extends JFrame
{
	JTextField t1,t2,t3,t4,t5;
	JLabel l1,l2,l3,l4,l5,l6;
	JPanel p1;
	JButton submit,back;
	JPasswordField pwd;
	
	public AddEmp() 
	{
		setVisible(true);
		setSize(1300,800);
		setLocation(40,0);
		setTitle("Register Employee");
		buildComponents();
		designComponents();
		back.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					setVisible(false);
				}
			}
		);
		submit.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
						AddEmp a=new AddEmp();
						boolean var=(t1.getText().equals("")) || (t2.getText().equals("")) || (t3.getText().equals("")) || (t4.getText().equals("")) || (t5.getText().equals("")) || (pwd.getText().equals(""));
						if(var==false)
						{
							try
							{
								DBHandler db=new DBHandler();
								Employee e=new Employee(t1.getText(),Integer.parseInt(t2.getText()),t3.getText(),t4.getText(),t5.getText(),pwd.getText());
								int res=db.insertEmployee(e);
								if(res>0)
								{
									int age= Integer.parseInt(t2.getText());
									if(age > 20)
									{
										a.setVisible(false);
										JOptionPane.showMessageDialog(a,"You resume have been accepted..");
									}
									else 
									{
										a.setVisible(false);
										JOptionPane.showMessageDialog(a,"You resume has not been accepted..");
									}
								}
								else
								{
									a.setVisible(false);
									JOptionPane.showMessageDialog(a,"Insertation unsuccessfull" , "data base Problem" ,JOptionPane.ERROR_MESSAGE);
								}
							}
							catch(Exception ee)
							{
								ee.printStackTrace();
							}
						}
						else
						{
							JOptionPane.showMessageDialog(a,"Enter your Details " , "Insufficient Data" , JOptionPane.ERROR_MESSAGE);
						}
				}
			}
		);
	}

	public void buildComponents()
	{
		l1=new JLabel("Name :");
		t1=new JTextField(20);
		l2=new JLabel("Age :");
		t2=new JTextField(20);
		l3=new JLabel("E-mail Id : ");
		t3=new JTextField(20);
		l4=new JLabel("Place :");
		t4=new JTextField(35);
		l5=new JLabel("Phone No : ");
		t5=new JTextField(20);
		l6=new JLabel("Set Password (atleast 8 characters) : ");
		pwd=new JPasswordField(10);
		submit=new JButton("Submit");
		back=new JButton("<- Back");
		p1=new JPanel(new GridLayout(7,1))
		{
			public void paintComponent(Graphics g)
			{
				ImageIcon icon=new ImageIcon("AddEmp.jpg");
				Image image=icon.getImage();
				g.drawImage(image,0,0,null);
			}
		};
	}
	
	public void designComponents()
	{
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p1.add(l3);
		p1.add(t3);
		p1.add(l4);
		p1.add(t4);
		p1.add(l5);
		p1.add(t5);
		p1.add(l6);
		p1.add(pwd);
		p1.add(back);
		p1.add(submit,BorderLayout.SOUTH);
		add(p1);
		l1.setFont(new Font("Italic",Font.BOLD,30));
		l2.setFont(new Font("Italic",Font.BOLD,30));
		l3.setFont(new Font("Italic",Font.BOLD,30));
		l4.setFont(new Font("Italic",Font.BOLD,30));
		l5.setFont(new Font("Italic",Font.BOLD,30));
		l6.setFont(new Font("Italic",Font.BOLD,30));
		t1.setFont(new Font("Italic",Font.BOLD,30));
		t2.setFont(new Font("Italic",Font.BOLD,30));
		t3.setFont(new Font("Italic",Font.BOLD,30));
		t4.setFont(new Font("Italic",Font.BOLD,30));
		t5.setFont(new Font("Italic",Font.BOLD,30));
		pwd.setFont(new Font("Italic",Font.BOLD,30));
		submit.setFont(new Font("Serif",Font.BOLD,40));
		back.setFont(new Font("Serif",Font.BOLD,40));
	}
}

class TermsCond extends JFrame
{
	JTextArea ta;
	JPanel p1;
	JButton next;
	JCheckBox c1;
	
	public TermsCond()
	{
		setVisible(true);
		setSize(500,600);
		setLocation(200,20);
		setTitle("Terms and Conditions");
		buildComponents();
		designComponents();
	}
	public void buildComponents()
	{
		ta=new JTextArea(20,20);
		c1=new JCheckBox("I accept the terms and conitions");
		p1=new JPanel();
		next=new JButton("next>>");
		next.setEnabled(false);
	}
	
	public void designComponents()
	{
		p1.add(ta);
		p1.add(c1);
		p1.add(next);
		add(p1);
		c1.setFont(new Font("Italic",Font.BOLD,20));
		next.setFont(new Font("Italic",Font.BOLD,20));
		try
		{
			File f1=new File("Terms and Conditions.txt");
			Scanner read=new Scanner(f1);
			while(read.hasNextLine())
			{
				ta.append(read.nextLine());
				ta.append("\n\n");
			}
			read.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		ta.setEditable(false);
		c1.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent ie)
			{
				if(ie.getStateChange()==ItemEvent.SELECTED)
					next.setEnabled(true);
				else
					next.setEnabled(false);
			}
		}
		);
		next.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					setVisible(false);
					AddEmp a1=new AddEmp();
					a1.setVisible(true);
				}
			}
		);
	
	}
}

/*class SeeEmp extends JFrame
{
	JButton submit,back;
	JPanel p1;
	JLabel email,pwd;
	JTextField t1;
	JPasswordField pas;
	public SeeEmp()
	{
		setVisible(true);
		setSize(300,200);
		setTitle("See My Details");
		buildComponents();
		designcomponents();
		back.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					setVisible(false);
				}
			}
		);
		submit.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{
					AddEmp a=new AddEmp();
						boolean var=(t1.getText().equals("")) || (pas.getText().equals(""));
						if(var==false)
						{
							try
							{
								DBHandler db=new DBHandler();
								Employee e=new Employee(t1.getText(),pas.getText());
								int res=db.insertEmployee(e);
								if(res>0)
								{
									JOptionPane.showMessageDialog(a,"You Were Hired Successfully");
									a.setVisible(false);
								}
								else
									JOptionPane.showMessageDialog(a,"Your are not hired","Register as a Employee" ,JOptionPane.ERROR_MESSAGE);
							}
							catch(Exception ee)
							{
								ee.printStackTrace();
							}
						}
						else
						{
							JOptionPane.showMessageDialog(a,"Enter your Details " , "Insufficient Data" , JOptionPane.ERROR_MESSAGE);
						}
				}
			}
		);
	}
	
	public void buildComponents()
	{
		email=new JLabel("E-mail :");
		pwd=new JLabel("Password :");
		t1=new JTextField(20);
		pas=new JPasswordField(10);
		back=new JButton("<- Back");
		submit=new JButton("Submit");
		p1=new JPanel();
	}
	
	public void designcomponents()
	{
		p1.add(email);
		p1.add(t1);
		p1.add(pwd);
		p1.add(pas);		
		p1.add(back,BorderLayout.SOUTH);
		p1.add(submit);
		add(p1);
	}
}*/