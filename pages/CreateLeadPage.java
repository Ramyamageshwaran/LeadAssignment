package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseMethods;

public class CreateLeadPage extends BaseMethods {
	@SuppressWarnings("static-access")
	public CreateLeadPage(ChromeDriver driver,ExtentTest node)
	{
		this.driver=driver;
		this.node=node;
	}
	public CreateLeadPage entercmpName(String cname) throws IOException {
	try {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		reportStep("CompanyName is entered Successfully","pass");
	} catch (Exception e) {
		reportStep("CompanyName is not entered","fail");
	}
	return this;
	}
	public CreateLeadPage enterFirstName(String fname) throws IOException {
	try {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		reportStep("First Name is entered Successfully","pass");
	} catch (Exception e) {
		reportStep("First Name is not entered","fail");
	}
	return this;
	}
	public CreateLeadPage enterLastName(String lname) throws IOException {
	try {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		reportStep("Last Name is entered Successfully","pass");
	} catch (Exception e) {
		reportStep("Last Name is not entered","fail");
	}
	return this;
	}
	public CreateLeadPage enterPhoneName(String phno) throws IOException {
	try {
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phno);
		reportStep("Phone No is entered Successfully","pass");
	} catch (Exception e) {
		reportStep("Phone No is not entered","fail");
	}
	return this;
	}
	public CreateLeadPage clickSubmit() throws IOException {
	try {
		driver.findElement(By.name("submitButton")).click();
		reportStep("Submit Button is Clicked Successfully","pass");
	} catch (Exception e) {
		reportStep("Submit Button is not Clicked","fail");	
	}
	return this;
	}
	public CreateLeadPage viewLeads()throws InterruptedException, IOException{
		try {
			String View = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
			System.out.println(View);
			reportStep("Verified Successfully","pass");
		} catch (Exception e) {
			reportStep("Verification Failed","fail");
		}
		return this;
}
}