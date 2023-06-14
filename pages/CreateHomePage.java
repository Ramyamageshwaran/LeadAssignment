package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseMethods;

public class CreateHomePage extends BaseMethods {
	@SuppressWarnings("static-access")
	public CreateHomePage(ChromeDriver driver,ExtentTest node)
	{
		this.driver=driver;
		this.node=node;
	}
	public MyHomePage myHomeCreate()throws InterruptedException, IOException	{
		Thread.sleep(2000);
		try {
			driver.findElement(By.linkText("CRM/SFA")).click();
			reportStep("CRM/SFA is Clicked Successfully","pass");
		} catch (Exception e) {
			reportStep("CRM/SFA is not Clicked","fail");	
		}
		return new MyHomePage(driver,node);
	}
}