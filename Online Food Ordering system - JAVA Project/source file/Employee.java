import java.sql.*;

//Employee

public class Employee
{
	 public String name;
	 public int age;
	 public String email;
	 public String place;
	 public String phNo;
	 public String pwd;
	
	public Employee()
	{
		name=" ";
		age=0;
		email=" ";
		phNo=" ";
		pwd=" ";
	}
	
	public Employee(String a,int b,String c,String d,String e,String f)
	{
		name=a;
		age=b;
		email=c;
		place=d;
		phNo=e;
		pwd=f;
	}		
	
	public String toString()
	{
		return name+ age + email + place + phNo + pwd;
	}
	
}

