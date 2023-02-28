 import java.sql.*;
 //customer

public class Customer
{
	String name;
	String address;
	String email;
	String phNo;
	String pwd;
	
	public Customer()
	{
		name=" ";
		address=" ";
		email=" ";
		phNo="";
		pwd=" ";
	}

	public Customer(String a,String b,String c,String d,String e)
	{
		name=a;
		address=b;
		email=c;
		phNo=d;
		pwd=e;
	}
	
	public String toString()
	{
		return name+ address + email +phNo +pwd;
	}
}
