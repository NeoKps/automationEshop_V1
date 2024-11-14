package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_DDT_Login extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void Verify_DDT_Login(String email, String pwd, String res) {
        LoginPage lp = new LoginPage(driver);
        MyAccount ma = new MyAccount(driver);

        logger.info("TC003 Started");

        boolean isLoggedIn = false;

        // First attempt to login with the provided credentials
        isLoggedIn = retryLogin(email, pwd, lp, ma);

        // Check the result column from Excel for validation
        if (res.equals("valid")) {
            // Assert the login is successful
            Assert.assertTrue(isLoggedIn, "Login should be successful for valid credentials");
            logger.info("Login succeeded for valid credentials");

            // Log out after successful login
            if (isLoggedIn) {
                ma.logOut();
                logger.info("Logged out successfully");
            }
        } else if (res.equals("invalid")) {
            // Assert the login is not successful for invalid credentials
            Assert.assertFalse(isLoggedIn, "Login should fail for invalid credentials");
            logger.info("Login failed for invalid credentials");
        }

        // Capture screenshot for reporting
        try {
        	captureScreenshot(driver, "TC003_" + email);
        } catch (Exception e) {
            logger.error("Error taking screenshot: " + e.getMessage());
        }
    }
}
