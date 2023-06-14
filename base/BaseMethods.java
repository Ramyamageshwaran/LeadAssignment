package base;
import java.io.File;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import util.ReadExcel;
public class BaseMethods {
	public ChromeDriver driver;
	public String sheets;
	public static ExtentReports extent;
	public static ExtentTest test,node;
	public String testName,testDescription,testAuthor,testCategory;
    @BeforeSuite
    public void startReport() {
        ExtentHtmlReporter reporter =new ExtentHtmlReporter("./reports/result.html");
        reporter.setAppendExisting(true);
        extent =new ExtentReports();
        extent.attachReporter(reporter);
    }
    @AfterSuite
    public void stopReport() {
         extent.flush();
    }
    @BeforeClass
    public void testDetail() {
        test = extent.createTest(testName,testDescription);
        
        test.assignCategory(testCategory);
        
        test.assignAuthor(testAuthor);
    }
    public int takeSnap() throws IOException {
        int ranNum=(int)(Math.random()*999999+1000000);
        File source = driver.getScreenshotAs(OutputType.FILE);
        File target=new File("./snaps/img"+ranNum+".png");//img11145.png
        FileUtils.copyFile(source, target);
        return ranNum;
    }
    public void reportStep(String stepDesc, String status) throws IOException {
        
        if(status.equalsIgnoreCase("pass")) {
            node.pass(stepDesc,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
        }
        else if(status.equalsIgnoreCase("fail")) {
            node.fail(stepDesc,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/Login.png").build());
           // throw new RuntimeErrorException(null, "Please look your report for failure ");
        }
        
        
    }
	@BeforeMethod
	public void basemethod()
	{
		node=test.createNode(testName);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30));
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
		
	@DataProvider
	public String[][] getData() throws IOException {
		String[][] readData = ReadExcel.readData(sheets);
		return readData;
	}
}
