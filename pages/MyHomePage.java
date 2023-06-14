package pages;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseMethods;

public class MyHomePage extends BaseMethods{
	@SuppressWarnings("static-access")
	public MyHomePage(ChromeDriver driver,ExtentTest node)
	{
		this.driver=driver;
		this.node=node;
	}
	
	public MyLeadsPage createnewLeads()throws InterruptedException, IOException {
		try {
			driver.findElement(By.linkText("Leads")).click();
			reportStep("Button is clicked Successfully","pass");
		} catch (Exception e) {
			reportStep("Button is not clicked","fail");
		}
		return new MyLeadsPage(driver,node);
		}
}
