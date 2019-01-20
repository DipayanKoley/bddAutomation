package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class TravelFirstPage
{
	public static WebElement element = null;
	
	public static WebElement dropMyAccount(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[contains(@class,'collapse')]/ul/ul/li[@id='li_myaccount']/a[@data-toggle='dropdown']"));
		return element;
	}
	
	public static WebElement lnk_Login(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//ul/ul/li/ul/li/a[text()=' Login']"));
		return element;
	}
}
