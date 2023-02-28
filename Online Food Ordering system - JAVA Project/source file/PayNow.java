import java.sql.*;
//online Payment

public class PayNow
{
	String cardNo;
	String expDate;
	String ccv;
	String amt;
	
	public PayNow()
	{
		cardNo=" ";
		expDate=" ";
		ccv=" ";
		amt=" ";
	}
	
	public PayNow(String cardNo,String expDate,String ccv,String amt)
	{
		this.cardNo=cardNo;
		this.expDate=expDate;
		this.ccv=ccv;
		this.amt=amt;
	}
	
	public String toString()
	{
		return cardNo + expDate + ccv + amt;
	}
}	