package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage
{
	public static WebElement element = null;
	
	public static WebElement lnk_Account(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[contains(@class,'collapse')]/ul/ul/li[@class='']/a[@data-toggle='dropdown']"));
		return element;
	}
	
	public static WebElement lnk_Logout(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//li[@class='open']/ul/li/a[text()='  Logout']"));
		return element;
	}
}
