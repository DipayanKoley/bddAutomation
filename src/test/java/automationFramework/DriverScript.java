package automationFramework;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import pageObjectModel.Login;
import pageObjectModel.ProfilePage;
import pageObjectModel.TravelFirstPage;
import utility.Constant;
import utility.ExcelUtil;
import utility.Logging;

public class DriverScript
{
	public static WebDriver driver = null;
	
	public void setProperties() throws FileNotFoundException
	{
		DOMConfigurator.configure("log4j.xml");
		
		System.setProperty("webdriver.chrome.driver", Constant.driverPath);
		
		driver = new ChromeDriver();
		
		Logging.info("Chrome Driver set successfully");
		
		ExcelUtil.setExcel(Constant.excelFile, Constant.excelSheet);
		
		Logging.info("Chrome Driver set successfully");
	}
	
	@Test
	public void driverScript() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(Constant.url);
		
		Logging.info("Chrome Launched successfully");
		
		driver.manage().window().maximize();
		
		TravelFirstPage.dropMyAccount(driver).click();
		
		TravelFirstPage.lnk_Login(driver).click();
		
		for(int i = 1;i<ExcelUtil.rowLen-1;i++)
		{
			Login.txtBox_Email(driver).sendKeys(ExcelUtil.readExcel(i, 1));
			
			Login.txtBox_Password(driver).sendKeys(ExcelUtil.readExcel(i,2));
		
			Login.btn_Login(driver).click();
			
			ProfilePage.lnk_Account(driver).click();
			
			ProfilePage.lnk_Logout(driver).click();
		}
	}
	
	@AfterSuite
	public void postTest() throws InterruptedException
	{
		Thread.sleep(2000);
		
		driver.quit();
	}
}
