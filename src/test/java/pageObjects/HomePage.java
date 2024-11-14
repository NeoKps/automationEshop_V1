package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	// locators
	@FindBy(xpath="//a[normalize-space()='Signup / Login']") WebElement lnkAcc;
	@FindBy(xpath="//input[@placeholder='Name']") WebElement txtName;
	@FindBy(xpath="//input[@data-qa='signup-email']") WebElement txtEmail;
	@FindBy(xpath="//button[normalize-space()='Signup']") WebElement btnsubmit;
	
	
	// Action Methods
	public void clickLogin_SignUp()
	{
		lnkAcc.click();
	}

	public void setName(String Uname)
	{
		txtName.sendKeys(Uname);
	}
	public void setEmail(String Uemail)
	{
		txtEmail.sendKeys(Uemail);
	}
	
	public void btnSubmit()
	{
		btnsubmit.click();
	}
}
