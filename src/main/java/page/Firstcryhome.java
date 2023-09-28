package page;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.Excelutils;



public class Firstcryhome {


	WebDriver driver;
	
	By searchbar=By.xpath("/html/body/div[1]/div[5]/div/div[2]/form/input");
	
	By shirt=By.xpath("//*[@id=\"maindiv\"]/div[1]/div/div[1]/div[1]/a/img");
	
	By addtokart=By.xpath("//*[@id=\"p_breadcrumb\"]/div[2]/div/div[2]/div[5]/div/div[2]/div[2]/div[1]/div/span[1]/span");
	
	By addtoshortlist=By.xpath("//*[@id=\"shortlist\"]");
	
	By toys=By.xpath("/html/body/div[1]/div[8]/div/div/div[1]/ul/li[5]/a");
	
	By ludo=By.xpath("/html/body/div[1]/div[8]/div/div/div[2]/div[6]/div/div/ul[3]/li[3]/a");
	
	By clubprice=By.xpath("//*[@id=\"maindiv\"]/div[6]/div/div[1]/div[6]/span[2]");
	
	By cart=By.xpath("//*[@id=\"cart_TotalCount\"]/span[1]");
	
	By removefromcart=By.xpath("//*[@id=\"delete_13968088\"]/span");
	
	By firstcryparenting=By.xpath("/html/body/div[1]/div[5]/div/div[3]/ul/li[5]/a/span");
	
	By infant=By.xpath("//*[@id=\"root\"]/div/main/div[2]/div/div[1]/div/div/section/div/ul/li[1]/div[1]");
	
	By childname=By.xpath("//*[@id=\"child-name\"]");
	
	By cancel=By.xpath("//*[@id=\"root\"]/div/main/div[1]/div/div[3]/div/div[5]/form/div[5]/button");
	
	By register=By.xpath("/html/body/div[1]/div[5]/div/div[3]/ul/li[7]/span[2]");
	 
	By Newtofirstcryregisterhere=By.xpath("//*[@id=\"login\"]/div[5]/p/a");
	
	By fullname=By.xpath("//*[@id=\"usrname\"]");
	
	By phonenumber=By.xpath("//*[@id=\"usrmb\"]");
	
	By emailid=By.xpath("//*[@id=\"usremail\"]");
	
	By password=By.xpath("//*[@id=\"usrpass\"]");
	
	By eyeicon=By.xpath("//*[@id=\"registersteptwo\"]/div[4]/span");
	
	By continueregistration=By.xpath("//*[@id=\"continueid\"]"); 
	
	
	
	
	public Firstcryhome(WebDriver driver) {
		
		this.driver=driver;
	}
	
	Actions actions = new Actions(driver);
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	
	//searching the values in searchbar and adding it to kart and adding to shortlist
	
	public void setValues(String word)
	{
		driver.findElement(searchbar).sendKeys(word,Keys.ENTER);
		
		driver.findElement(shirt).click();
		
		driver.findElement(addtokart).click();
		
		driver.findElement(addtoshortlist).click();
		
		driver.navigate().back();
		
	}
	
	//drag to toys in homepage and select ludo from the options and click on clubprice
	
	public void drag()
	{
		actions.moveToElement((WebElement) toys).perform();
		
		driver.findElement(ludo).click();
		js.executeScript("window.scrollBy(0, 500);");
		
		driver.findElement(clubprice).click();
		
		driver.navigate().back();
		driver.navigate().back();
			
	}
	
	//clicking on cart and removing items that are added in cart
	
	public void clickcart()
	{
		driver.findElement(cart).click();
		
		driver.findElement(removefromcart).click();
		
		driver.navigate().back();
		
	}
	
	//clicking on firstcry parenting and clicking on infant by using cross browser testing
	public void clickFirstcryParenting(String name) {
	    // Get the parent window handle before clicking on firstcryparenting
	    String parentWindowHandle = driver.getWindowHandle();

	    // Click on firstcryparenting
	    driver.findElement(firstcryparenting).click();

	    // Switch to the new tab/window (assuming it's the only new window opened)
	    
	    for (String windowHandle : driver.getWindowHandles()) {
	        if (!windowHandle.equals(parentWindowHandle)) {
	            driver.switchTo().window(windowHandle);
	            break;
	        }
	    }

	    // Perform actions in the new tab/window
	    driver.findElement(infant).click();
	    
	    driver.findElement(childname).sendKeys(name);
	    
	    driver.findElement(cancel).click();

	    // Close the new tab/window
	    driver.close();

	    // Switch back to the parent window
	    driver.switchTo().window(parentWindowHandle);
	}
	
	//registering to firstcry
	
	public void registering()
	{
		driver.findElement(register).click();
		
		driver.findElement(Newtofirstcryregisterhere).click();
	}
	
	public void enteringcredentials(String username,String phn,String email,String pswd)
	{
		
		
		driver.findElement(fullname).sendKeys(username);
		
		driver.findElement(phonenumber).sendKeys(phn);
		
		driver.findElement(emailid).sendKeys(email);
		
		driver.findElement(password).sendKeys(pswd);
		
		driver.findElement(eyeicon).click();
		
		driver.findElement(continueregistration).click();
		
			
		}
		
		
		
	}
	
	
	
	
