 import java.sql.*;
 //customer

class Customer
{
	String name;
	String address;
	String email;
	int phNo;
	
	public Customer()
	{
		name=" ";
		address=" ";
		email=" ";
		phNo=0;
	}

	public Customer(String a,String b,String c,int d)
	{
		name=a;
		address=b;
		email=c;
		phNo=d;

	}
	
	public String toString()
	{
		return name+ address + email +phNo;
	}
}

//Employee

class Employee
{
	String name;
	int age;
	String email;
	String place;
	int phNo;
	
	public Employee(String a,int b,String c,String d,int e)
	{
		name=a;
		age=b;
		email=c;
		place=d;
		phNo=e;
	}		
	
	public String toString()
	{
		return name+ age + email + place + phNo;
	}
}



//DBHandler

class DBHandler
{
	Connection con;
	Statement st;
	public DBHandler()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/FoodWorld","root","");
			System.out.println("Connection successfull");
			st=con.createStatement();
		}
		catch(Exception ex)
		{
			System.out.println(ex);	
		}
	}
	
	public int insertCustomer(Customer c)
	{
		int x=0;
		try
		{
			String query="insert into Customer values('"+c.name+"' , '" +c.address +"' , '"+ c.email+ "' , "+c.phNo+")";
			x=st.executeUpdate(query);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return x;
	}
	
	public int deleteCustomer(String ph)
	{
		int x=0;
		try
		{
			String query="delete from Customer where phNo="+ph;
			x=st.executeUpdate(query);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return x;
	}
	
	//for Employee
	
	public int insertEmployee(Employee e)
	{
		int x=0;
		try
		{
			String query="insert into Employee values('"+e.name+"' , "+e.age+" , '"+e.email+"' , '"+e.place+"' , "+e.phNo+")";
			x=st.executeUpdate(query);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return x;
	}
}



public class MyTest
{
	public static void main(String ...args)
	{
		DBHandler d1=new DBHandler();
		
	}
}


