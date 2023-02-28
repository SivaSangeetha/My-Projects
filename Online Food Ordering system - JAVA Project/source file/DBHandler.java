import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//DBHandler


public class DBHandler
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
			String query="insert into Customer values('"+c.name+"' , '" +c.address +"' , '"+ c.email+ "' , "+c.phNo+" , '" +c.pwd+"')";
			x=st.executeUpdate(query);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return x;
	}
	
/*	public int deleteCustomer(String ph)
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
	}*/
	
	//for Employee
	
	public int insertEmployee(Employee e)
	{
		int x=0;
		try
		{
			String query="insert into Employee values('"+e.name+"' , "+e.age+" , '"+e.email+"' , '"+e.place+"' , "+e.phNo+", '"+e.pwd+"' )";
			x=st.executeUpdate(query);
		}
		catch(Exception ex)
		{
			System.out.println(ex);                                                                                                                                                                                             
		}
		return x;
	}
	
	/*public boolean unique(Customer c1)throws Exception
	{
		String Email=c1.email;
		String Password=c1.pwd;
		String statement="select * from customer where Email ='"+Email+"' and Password='"+Password+"'";
		ResultSet s=st.executeQuery(statement);
		return !s.next();
		
	}*/
	public int insertPayment(PayNow p)
	{
		int x=0;
		try
		{
			String query="insert into PayNow values('"+p.cardNo+"' , "+p.expDate+" , '"+p.ccv+"' , "+p.amt+" )";
			x=st.executeUpdate(query);
		}
		catch(Exception ex)
		{
			System.out.println(ex);                                                                                                                                                                                             
		}
		return x;
	}
}


/*class DataBase
{
	public static void main(String ... args)
	{
		int x;
		DBHandler db=new DBHandler();
		try
		{
			Customer c=new Customer("Sangee","Surandai","Sangee@123","123455","fr675");
			x=db.insertCustomer(c);
			System.out.println(x);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}/*



/*public class MyDBHandler
{
	public static void main(String ...args)
	{
		DBHandler d1=new DBHandler();
		
	}
}*/
