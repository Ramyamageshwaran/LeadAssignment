package pages;
import java.io.IOException;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseMethods;

public class ViewLeadsPage extends BaseMethods {
	
	@SuppressWarnings("static-access")
	public ViewLeadsPage(ChromeDriver driver,ExtentTest node)
	{
		this.driver=driver;
		this.node=node;
	}
	public EditLead clickEditButton() throws IOException
    {
    	try {
			driver.findElement(By.linkText("Edit")).click();
			reportStep("Button is clicked Successfully","pass");
		} catch (Exception e) {
			reportStep("Button is not clicked","fail");
		}
    	return new EditLead(driver,node);
    }
    public ViewLeadsPage clickDuplicateButton() throws IOException
    {
    	try {
			driver.findElement(By.linkText("Duplicate Lead")).click();
			reportStep("Button is clicked Successfully","pass");
		} catch (Exception e) {
			reportStep("Button is not clicked","fail");
		}
    	return this;
    }
    public ViewLeadsPage verifyDuplicate() throws IOException
	{
		try {
			String text = driver.findElement(By.id("viewLead_firstName_sp")).getText();
			System.out.println(text);
			reportStep("Verified Successfully","pass");
		} catch (Exception e) {
			reportStep("Verification Failed","fail");
		}
		return this;
	}
    public MyLeadsPage clickDeleteButton() throws IOException
    {
    	
    	 try {
			driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous'][text()='Delete']")).click();
			reportStep("Button is clicked Successfully","pass");
		} catch (Exception e) {
			reportStep("Button is not clicked","fail");
		}
    	
    	return new MyLeadsPage(driver,node);
    }

	
}
