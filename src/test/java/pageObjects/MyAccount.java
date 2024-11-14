package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage{

	//constructor
	public MyAccount(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Locators
	@FindBy(xpath="//header[@id='header']//li[10]//a[1]") WebElement msgLoggedIn;
	@FindBy(xpath ="//a[normalize-space()='Logout']") WebElement btnLogOut;
	
	//Action Methods
	public String loggedInMsg()
	{
		try {
		return msgLoggedIn.getText();
		}
		catch (Exception e)
		{
			return e.getMessage();
		}
	}
	
	public Boolean isExist()
	{
		msgLoggedIn.isDisplayed();
		return true;
	}
	
	public void logOut()
	{
		btnLogOut.click();
	}
	

}
