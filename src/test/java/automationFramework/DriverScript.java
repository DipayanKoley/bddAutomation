package automationFramework;

import java.awt.color.ProfileDataException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjectModel.Login;
import pageObjectModel.ProfilePage;
import pageObjectModel.TravelFirstPage;
import utility.Constant;

public class DriverScript
{
	public static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", Constant.driverPath);
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(Constant.url);
		
		driver.manage().window().maximize();
		
		TravelFirstPage.dropMyAccount(driver).click();
		
		TravelFirstPage.lnk_Login(driver).click();
		
		Login.txtBox_Email(driver).sendKeys("user@phptravels.com");
		
		Login.txtBox_Password(driver).sendKeys("demouser");
		
		Login.btn_Login(driver).click();
		
		ProfilePage.lnk_Account(driver).click();
		
		ProfilePage.lnk_Logout(driver).click();
		
		Thread.sleep(2000);
		
		driver.quit();
	}
}
