package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC002_User_Login extends BaseClass {
	
	@Test
	public void user_Login() throws IOException
	{
		LoginPage lp = new LoginPage(driver);
		logger.info("***Second Execution Starts***");
		lp.accountLogin();
		lp.setEmail(p.getProperty("UserName"));
		lp.setPassword(p.getProperty("PassWord"));
		lp.clickLogin();
		
		MyAccount ma = new MyAccount(driver);
		String myMessage = ma.loggedInMsg();
		logger.info("**Checking account message**");
		if(myMessage.equals("Logged in as Vilalan"))
		{
			logger.info("user_Login-Passed");
			captureScreenshot (driver, "user_Login");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("user_Login-Failed");
			captureScreenshot (driver, "user_Login");
			Assert.assertTrue(false);
		}
		
		ma.logOut();
		logger.info("Logged out successfully");
		
	}

}
