package test;



import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.Base;
import page.Firstcryhome;
import utilities.Excelutils;

public class Firstcrytest extends Base{
	
	Firstcryhome fc=new Firstcryhome(driver);
	@Test
	public void searching()
	{
		
		fc.setValues("shirt");
	}

	@Test
	public void dragging()
	{
		
		fc.drag();
	}
	
	@Test
	public void clickingKart()
	{
		fc.clickcart();
	}
	
	@Test
	public void clickingFirstcryParenting()
	{
		
		
		
		
		
		fc.clickFirstcryParenting("lechu");
	}
	
	@Test
	
	public void clickingresgister()
	{
		fc.registering();
	}
	@Test
	public void registeringAccount()
	{
		
		String xl= "E:\\EXCEL\\Book2forautomation.xlsx";
		
		String Sheet="Sheet1";
		
		int rowCount=Excelutils.getRowCount(xl, Sheet);
		
		for(int i=1;i<=rowCount;i++)
		{
			String username=Excelutils.getCellValue(xl, Sheet, i, 0);
			System.out.println("username="+username);
			
			String phn=Excelutils.getCellValue(xl, Sheet, i, 1);
			System.out.println("phone="+phn);
			
			String email=Excelutils.getCellValue(xl, Sheet, i, 2);
			System.out.println("email="+email);
			
			String pswd=Excelutils.getCellValue(xl, Sheet, i, 3);
			System.out.println("password="+pswd);
			
			fc.enteringcredentials(username, phn, email, pswd);
			
			
		}
		
		
	}
}