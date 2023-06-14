package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseMethods;
import pages.CreateLoginPage;

public class LoginTest extends BaseMethods {
	@BeforeTest
	public void setup() {
		sheets="Login";
		
	}
	@Test(dataProvider="getData")
	public void loginTest(String uname,String pwd)throws InterruptedException, IOException {
		//Create obj for loginPage
		CreateLoginPage lp=new CreateLoginPage(driver,node);
		lp.enterUserName(uname)
		.enterPassword(pwd)
		.clickLogin();
}
}