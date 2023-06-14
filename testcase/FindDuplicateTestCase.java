package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseMethods;
import pages.CreateLoginPage;

public class FindDuplicateTestCase extends BaseMethods {
	@BeforeTest
	public void setup() {
		sheets="DuplicateLeads";
		testName = "DuplicateLeads";
		testDescription ="Find duplicate Lead";
		testCategory = "Regression";
		testAuthor ="Ramya";
		
	}
	
	@Test(dataProvider="getData")
	public void findDuplicateLeadTest(String uname,String pwd,String phno)throws InterruptedException, IOException {
		
		CreateLoginPage lp=new CreateLoginPage(driver,node);
		lp.enterUserName(uname)
		.enterPassword(pwd)
		.clickLogin()
		.myHomeCreate()
		.createnewLeads()
		.findLeads()
		.clickPhoneButton()
		.enterPhoneNo(phno)
		.clickFindLeads()
		.clickLeadId()
		.clickDuplicateButton()
		.verifyDuplicate();
		
		}


}
