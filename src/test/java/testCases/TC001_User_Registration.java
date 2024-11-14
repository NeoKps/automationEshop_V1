package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_User_Registration extends BaseClass {
	
	@Test
	public void verify_registration() throws IOException
	{
		HomePage home = new HomePage(driver);
		logger.info("***Execution Starts***");
		home.clickLogin_SignUp();
		logger.info("****Clicked on Login/Signup****");
		home.setName("Vilalan");
		home.setEmail(RandomGenString()+"@gmail.com");
		home.btnSubmit();
		
		logger.info("****Registartion Page****");
		RegistrationPage reg = new RegistrationPage(driver);
		
		logger.info("****Filling details****");
		reg.setGender();
		
		String Name = reg.checkName();
		System.out.println(Name);
		//Assert.assertEquals(Name, "Viln");
		
		String email = reg.checkEmail();
		//Assert.assertEquals(email, "vilal123a4@gmail.com");
		System.out.println(email);
		
		reg.setPassword("Mol@1234");
		reg.setDay("21");
		reg.setMon("January");
		reg.setYr("1999");
		reg.setNewsLetter();
		reg.setOptIn();
		reg.setFname("Jolly");
		reg.setLname("KK");
		reg.setCompany("Kites");
		reg.setAdd1("address");
		reg.setAdd2("Add2");
		reg.setCountry("India");
		reg.setState("UP");
		reg.setCity("MP");
		reg.setZip("234567");
		reg.setMob("3456783456");
		reg.accountCreate();
		logger.info("**Filled Details**");
		String confirmation = reg.msgConfirmation();
		logger.info("*********Validation of confirmation Messgae*********");
		Assert.assertEquals(confirmation, "ACCOUNT CREATED!");
		// Capture screenshot after successful registration
	    captureScreenshot(driver,"TC001_User_Registration_Success");

	    logger.info("***Execution Completed***");
	}

}
