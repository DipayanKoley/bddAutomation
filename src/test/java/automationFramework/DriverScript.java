package automationFramework;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import pageObjectModel.Login;
import pageObjectModel.ProfilePage;
import pageObjectModel.TravelFirstPage;
import utility.Constant;
import utility.ExcelUtil;

public class DriverScript
{
	public static WebDriver driver = null;
	
	public void setProperties() throws FileNotFoundException
	{
		System.setProperty("webdriver.chrome.driver", Constant.driverPath);
		
		driver = new ChromeDriver();
		
		ExcelUtil.setExcel(Constant.excelFile, Constant.excelSheet);
	}
	
	@Test
	public void driverScript() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(Constant.url);
		
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
