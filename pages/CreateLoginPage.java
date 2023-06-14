package pages;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseMethods;

public class CreateLoginPage extends BaseMethods {
	@SuppressWarnings("static-access")
	public CreateLoginPage(ChromeDriver driver,ExtentTest node)
	{
		this.driver=driver;
		this.node=node;
	}
	public CreateLoginPage enterUserName(String uname) throws IOException
	{ 

	         try {
				driver.findElement(By.id("username")).sendKeys(uname);
				reportStep("UserName is entered successfully","pass");
			} catch (Exception e) {
				reportStep("UserName is not entered","fail");				
			}
	         return this;
	
	}
    public CreateLoginPage enterPassword(String pwd) throws IOException
    {
    	
    	    try {
				driver.findElement(By.id("password")).sendKeys(pwd);
				reportStep("Password is entered Successfully","pass");
			} catch (Exception e) {
				reportStep("Password is not entered","fail");		
			}
    	    return this;
    	}
    public CreateHomePage clickLogin()throws InterruptedException, IOException
    {
    	Thread.sleep(2000);
    	try {
			driver.findElement(By.className("decorativeSubmit")).click();
			reportStep("Submit Button is Clicked","pass");
		} catch (Exception e) {
			reportStep("Submit Button  is not Clicked","fail");
		}
    	return new CreateHomePage(driver,node);
    }
}





