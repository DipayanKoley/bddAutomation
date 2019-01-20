package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login
{
	public static WebElement element = null;
	
	public static WebElement txtBox_Email(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//input[@type='email' and @name = 'username']"));
		return element;
	}
	
	public static WebElement txtBox_Password(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//input[@type='password' and @name = 'password']"));
		return element;
	}
	
	public static WebElement btn_Login(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//button[text()='Login']"));
		return element;
	}
}
