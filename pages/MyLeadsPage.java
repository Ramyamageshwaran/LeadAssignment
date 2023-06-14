package pages;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseMethods;

public class MyLeadsPage extends BaseMethods {
	@SuppressWarnings("static-access")
	public MyLeadsPage(ChromeDriver driver,ExtentTest node)
	{
		this.driver=driver;
		this.node=node;
	}	
	public CreateLeadPage createLeads()throws InterruptedException, IOException
	{
		try {
			driver.findElement(By.linkText("Create Lead")).click();
			reportStep("Button is clicked Successfully","pass");
		} catch (Exception e) {
			reportStep("Button is not clicked","fail");
		}
		return new CreateLeadPage(driver,node);
	}
	
	public FindLeads findLeads() throws IOException
	{
		try {
			driver.findElement(By.linkText("Find Leads")).click();
			reportStep("Button is clicked Successfully","pass");
		} catch (Exception e) {
			reportStep("Button is not clicked","fail");
		}
		return new FindLeads(driver,node);
	}
	 public MergeLeads mergeLeads()
     {
     	try {
				driver.findElement(By.linkText("Merge Leads")).click();
			} catch (Exception e) {
				
			}
			return new MergeLeads(driver,node);
      }
	
	
	

}
