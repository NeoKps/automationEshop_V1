package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	//constructor
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}	
	
	//Locators
	
	@FindBy(xpath="//a[normalize-space()='Signup / Login']") WebElement lnkAcc;
	@FindBy(xpath="//input[@data-qa='login-email']") WebElement txtEmail;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement txtPassword;
	@FindBy(xpath="//button[normalize-space()='Login']") WebElement btnLogin;
	
	
	//Action Methods
	public void accountLogin()
	{
		lnkAcc.click();
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}

	public void setPassword(String pass)
	{
		txtPassword.sendKeys(pass);
	}
	public void clickLogin()
	{
		btnLogin.click();
	}
}
