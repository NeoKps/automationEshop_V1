package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageObjects.LoginPage;
import pageObjects.MyAccount;

public class BaseClass {

    public Logger logger;
    public Properties p;
    public WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void setup(String brw) throws IOException {
        FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
        p = new Properties();
        p.load(fis);

        // Logger setup
        logger = LogManager.getLogger(this.getClass());

        // Browser setup
        switch (brw.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Invalid Browser");
                return;
        }

        // Setting up WebDriver options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("App_url"));
        driver.manage().window().maximize();
    }

    // Helper method for retrying login
    public boolean retryLogin(String email, String pwd, LoginPage lp, MyAccount ma) {
        lp.accountLogin();
        lp.setEmail(email);
        lp.setPassword(pwd);
        lp.clickLogin();

        // Check if login was successful
        String loginMessage = ma.loggedInMsg();
        return loginMessage.contains("Logged in as");
    }

    public void captureScreenshot (WebDriver driver, String testName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "\\screenshots\\" + testName + ".jpeg");
        FileUtils.copyFile(source, target);
    }

	public String RandomGenString()
	{
		String random = RandomStringUtils.randomAlphabetic(5);
		return random;
	}
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
