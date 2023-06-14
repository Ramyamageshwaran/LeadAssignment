package pages;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseMethods;

public class EditLead extends BaseMethods {
	public String text;
	
	@SuppressWarnings("static-access")
	public EditLead(ChromeDriver driver,ExtentTest node)
	{
		this.driver=driver;
		this.node=node;
	}
	    
	    
	    public EditLead enterCompName(String cname) throws IOException
	    {
	    	try {
				driver.findElement(By.id("updateLeadForm_companyName")).clear();
				driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(cname);
				reportStep("CompanyName is entered Successfully","pass");
			} catch (Exception e) {
				reportStep("CompanyName is not entered","fail");
			}
	    	return this;
	    }
	    public EditLead updateButton() throws IOException
	    {
	    	try {
				driver.findElement(By.xpath("//input[@name='submitButton']")).click();
				reportStep("Submit Button is Clicked","pass");
			} catch (Exception e) {
				reportStep("Submit Button  is not Clicked","fail");
			}
	    	return this;
	    }
	    public EditLead verifyEditLeads() throws IOException
		{	
			 try {
				text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
				 System.out.println(text);
				 reportStep("Verified Successfully","pass");
			} catch (Exception e) {
				reportStep("Verification Failed","fail");
			}
		     return this;
		}
	   
	}



