package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseMethods;
import pages.CreateLoginPage;

public class MergeTestCase extends BaseMethods{
	@BeforeTest
	public void setup() {
		sheets="MergeLead";
		testName = "MergeLead";
		testDescription ="Merge Lead";
		testCategory = "Regression";
		testAuthor ="Ramya";
	}
	
	@Test(dataProvider="getData")
	public void createLeadTest(String uname,String pwd,String fname,String ftname,String leadID)throws InterruptedException, IOException {
		
		CreateLoginPage lp=new CreateLoginPage(driver,node);
		lp.enterUserName(uname)
		.enterPassword(pwd)
		.clickLogin()
		.myHomeCreate()
		.createnewLeads()
		.mergeLeads()
		.selectFromLead()
		.enterFirstNameForMerge(fname).findLeadsForMerge()
		.selectLeadIdforMerge().selectToLead().enterFirstNameToMerge(ftname)
		.clickFindLeadsToMerge().selectLeadIdToMerge().clickMergeButton()
		.selectFindLeadsToCheck().enterLeadIdToCheck(leadID).clickFindLeadsToVerify().verifyMergeMsg();
	}
}
