package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage {

	
	//constructor
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	//locators
	
	@FindBy(xpath="//input[@id='id_gender1']") WebElement radiogender;
	@FindBy(xpath="//input[@id='name']") WebElement txtName;
	@FindBy(xpath="//input[@id='email']") WebElement txtEmail;
	@FindBy(xpath="//input[@id='password']") WebElement txtPwd;
	@FindBy(xpath="//select[@id='days']") WebElement selDay;
	@FindBy(xpath="//select[@id='months']") WebElement selMon;
	@FindBy(xpath="//select[@id='years']") WebElement selYr;
	@FindBy(xpath="//input[@id='newsletter']") WebElement radioNewsLetter;
	@FindBy(xpath="//input[@id='optin']") WebElement radioOptin;
	@FindBy(xpath="//input[@id='first_name']") WebElement txtFName;
	@FindBy(xpath="//input[@id='last_name']") WebElement txtLName;
	@FindBy(xpath="//input[@id='company']") WebElement txtCompany;
	@FindBy(xpath="//input[@id='address1']") WebElement txtAdd1;
	@FindBy(xpath="//input[@id='address2']") WebElement txtAdd2;
	@FindBy(xpath="//select[@id='country']") WebElement sleCountry;
	@FindBy(xpath="//input[@id='state']") WebElement txtState;
	@FindBy(xpath="//input[@id='city']") WebElement txtCity;
	@FindBy(xpath="//input[@id='zipcode']") WebElement txtZip;
	@FindBy(xpath="//input[@id='mobile_number']") WebElement txtMob;
	@FindBy(xpath="//button[normalize-space()='Create Account']") WebElement btnCreate;
	@FindBy(xpath="//b[normalize-space()='Account Created!']") WebElement confimationMsg;
		
	
	//Action Methods
	
	public void setGender()
	{
		radiogender.click();
	}
	
	public String checkName()
	{
		try {
		return txtName.getText();
		}
		catch (Exception e)
		{
			return(e.getMessage());
		}
	}
	
	public String checkEmail()
	{
		try {
			return txtEmail.getText();
		}
		catch (Exception e)
		{
			return (e.getMessage());
		}
	}
	
	public void setPassword(String pass) {
		txtPwd.sendKeys(pass);
	}
	
	public void setDay(String mydate)
	{
		WebElement date = selDay;
		Select d = new Select (date);
		d.selectByVisibleText(mydate);
	}
	
	public void setMon(String mymonth)
	{
		WebElement month = selMon;
		Select m = new Select (month);
		m.selectByVisibleText(mymonth);
	}
	
	public void setYr(String myyear)
	{
		WebElement year = selYr;
		Select y = new Select (year);
		y.selectByVisibleText(myyear);
	}
	
	public void setNewsLetter()
	{
		radioNewsLetter.click();
	}

	public void setOptIn()
	{
		radioOptin.click();
	}
	
	public void setFname(String Fname)
	{
		txtFName.sendKeys(Fname);
	}
	
	public void setLname(String Lname)
	{
		txtLName.sendKeys(Lname);
	}
	
	public void setCompany(String companyName)
	{
		txtCompany.sendKeys(companyName);
	}
	public void setAdd1(String Address1)
	{
		txtAdd1.sendKeys(Address1);
	}
	public void setAdd2(String Address2)
	{
		txtAdd2.sendKeys(Address2);
	}
	
	public void setCountry(String myCountry)
	{
		WebElement coun = sleCountry;
		Select c = new Select (coun);
		c.selectByVisibleText(myCountry);
	}
	
	public void setState(String myState)
	{
		txtState.sendKeys(myState);
	}
	public void setCity(String myCity)
	{
		txtCity.sendKeys(myCity);
	}
	
	public void setZip (String myZip)
	{
		txtZip.sendKeys(myZip);
	}
	public void setMob (String Mob)
	{
		txtMob.sendKeys(Mob);
	}
	
	public void accountCreate()
	{
		btnCreate.click();
	}
	
	public String msgConfirmation() {
		try {
			return confimationMsg.getText();
		}
		catch (Exception e)
		{
			return e.getMessage();
		}
	}
	
}
