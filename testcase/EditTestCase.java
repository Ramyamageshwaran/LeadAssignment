package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.BaseMethods;
import pages.CreateLoginPage;

public class EditTestCase extends BaseMethods {
	@BeforeTest
	public void setup() {
		sheets="EditLeads";
		testName ="EditLeads";
		testDescription ="Edit Lead test";
		testCategory = "Regression";
		testAuthor ="Ramya";
		
	}
	
	@Test(dataProvider="getData")
	public void editLeadTest(String uname,String pwd,String phno,String cname)throws InterruptedException, IOException {
		
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
		.clickEditButton()
		.enterCompName(cname)
		.updateButton()
		.verifyEditLeads();	
		
	}

}


