package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentTest;

import base.BaseMethods;

public class FindLeads extends BaseMethods {
	      //public static String leadId;
	
            @SuppressWarnings("static-access")
			public FindLeads(ChromeDriver driver,ExtentTest node)
	        {
		    this.driver=driver;
		    this.node=node;
	        }
			public FindLeads clickPhoneButton() throws IOException
			{
				try {
					driver.findElement(By.xpath("//span[text()='Phone']")).click();
					reportStep("Phone Button is clicked Successfully","pass");
				} catch (Exception e) {
					reportStep("Phone Button is not clicked","fail");
				}
				return this;
			}
			public FindLeads enterPhoneNo(String pnum) throws IOException
			{
				driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).clear();
				try {
					driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(pnum);
					reportStep("Phone No is entered Successfully","pass");
				} catch (Exception e) {
					reportStep("Phone No is not entered","fail");
				}
				return this;
			}
			
			
			public FindLeads clickFindLeads() throws IOException
			{
				try {
					driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
					reportStep("Button is clicked Successfully","pass");
				} catch (Exception e) {
					reportStep("Button is not clicked","fail");
				}
				return this;
			}
			
		    public ViewLeadsPage clickLeadId() throws InterruptedException, IOException
		    {
		    	Thread.sleep(5000);
		    	try {
					driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@class='linktext']")).click();
					reportStep("Lead ID Button is clicked Successfully","pass");
				} catch (Exception e) {
					reportStep("Lead ID Button is not clicked","fail");
				}
		    	
		    	return new ViewLeadsPage(driver,node);
		    }	
		    
		    public FindLeads nameAndIdButton() throws IOException
		    {
		    	try {
					driver.findElement(By.xpath("//span[text()='Name and ID']")).click();
					reportStep("Name and ID Button is clicked Successfully","pass");
				} catch (Exception e) {
					reportStep("Name and ID Button is not clicked","fail");
				}
		    	return this;
		    }
		    
		    public FindLeads leadIdforcheackin() throws IOException
		    {
		    	try {
					driver.findElement(By.name("id")).sendKeys("100865");
					reportStep("ID is entered Successfully","pass");
				} catch (Exception e) {
					reportStep("ID is not entered","fail");
				}
		    	return this;
		    }
		    
		    public FindLeads verifyDelete()
			{
				String text = driver.findElement(By.className("x-paging-info")).getText();
				if (text.equals("No records to display")) {
					System.out.println("Leads Deleted");
				} else {
					System.out.println("Leads not Deleted");
				}
				return this;
			}
		 
}

