package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentTest;
import base.BaseMethods;

	public class MergeLeads extends BaseMethods {
		      public String leadId,allWindows,allhandles,allhandles2;
		
	            @SuppressWarnings("static-access")
				public MergeLeads(ChromeDriver driver,ExtentTest node)
		        {
			    this.driver=driver;
			    this.node=node;
		        }
	            
	           
	            
	             public MergeLeads selectFromLead()
	             {
	            	 try {
						driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
					} catch (Exception e) {
						
					}
					return this;
	             }
	             public MergeLeads enterFirstNameForMerge(String fname)
	             {
	            	 Set<String> allWindows = driver.getWindowHandles();
	     			List<String> allhandles = new ArrayList<String>(allWindows);
	     			driver.switchTo().window(allhandles.get(1));
	     			driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fname);
	     			return this;
	             }
	             
	             public MergeLeads findLeadsForMerge()
	             {
	            	 driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	            	 return this;
	             }
	             
	             
	             public MergeLeads selectLeadIdforMerge() throws InterruptedException
	             {
	            	 
	            	 leadId=driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
	     			driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@class='linktext']")).click();
	            	 List<String> allhandles = new ArrayList<String>();
	            	 driver.switchTo().window(allhandles.get(0));
					return this;
	     	        
	             }
	             
	             public MergeLeads selectToLead()
	             {
	            	driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
					 return this;
	             }
	             
	             public MergeLeads enterFirstNameToMerge(String ftname)
	             {
	            	 Set<String> allWindows2 = driver.getWindowHandles();
	     			List<String> allhandles2 = new ArrayList<String>(allWindows2);
	     			driver.switchTo().window(allhandles2.get(1));
	     			driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(ftname);
	     			return this;
	             }
	             
	             public MergeLeads clickFindLeadsToMerge()
	             {
	            	 driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	            	 
	            	 return this;
	             }
	             
	             public MergeLeads selectLeadIdToMerge() throws InterruptedException
	             {
	            	
	     			driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	     			List<String> allhandles2 = new ArrayList<String>();
	     			driver.switchTo().window(allhandles2.get(0));
	     			return this;
	             }
	             public MergeLeads clickMergeButton()
	             {
	            	 driver.findElement(By.xpath("//a[text()='Merge']")).click();
	            	 driver.switchTo().alert().accept();
	            	 return this;
	             }
	             
	             public MergeLeads selectFindLeadsToCheck()
	             {
	            	 driver.findElement(By.linkText("Find Leads")).click();
	            	 return this;
	             }
	             public MergeLeads enterLeadIdToCheck(String leadId)
	             {	             
	             driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadId);
				 return this;
	             }
	             
	             public MergeLeads clickFindLeadsToVerify()
	             {
	 			  driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
				  return this;
	             }
	             public MergeLeads verifyMergeMsg()
	             {
	 			  String text = driver.findElement(By.className("x-paging-info")).getText();
	 			  if (text.equals("No records to display")) {
	 				System.out.println("Text matched");
	 			 } else {
	 				System.out.println("Text not matched");
	 			 }
	            	return this;            
	             }
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            

}
