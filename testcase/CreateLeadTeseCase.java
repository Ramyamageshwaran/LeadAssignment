package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseMethods;
import pages.CreateLoginPage;

public class CreateLeadTeseCase extends BaseMethods{
	@BeforeTest
	public void setup() {
		sheets="CreateLead";
		testName = "CreateLead";
		testDescription ="Create Lead";
		testCategory = "Regression";
		testAuthor ="Ramya";
	}
	
	@Test(dataProvider="getData")
	public void createLeadTest(String uname,String pwd,String cname,String fname,String lname,String phno)throws InterruptedException, IOException {
		
		CreateLoginPage lp=new CreateLoginPage(driver,node);
		lp.enterUserName(uname)
		.enterPassword(pwd)
		.clickLogin()
		.myHomeCreate()
		.createnewLeads()
		.createLeads()
		.entercmpName(cname)
		.enterFirstName(fname)
		.enterLastName(lname)
		.enterPhoneName(phno)
		.clickSubmit()
		.viewLeads();
		
	}

}
