package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;
import utilities.ScreenshotUtility;
import utilities.WaitUtility;

public class BaseClass {

	public WebDriver driver;
	FileInputStream fileinput;
	Properties properties;
	WaitUtility waitutility = new WaitUtility();

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception {
		properties = new Properties();
		fileinput = new FileInputStream(Constants.CONFIGFILE);
		properties.load(fileinput);
		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("Invalid Browser");
		}
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
		waitutility.implicitWait(driver);
	}

	@AfterMethod(alwaysRun = true)
	public void driverQuit(ITestResult itestresult) throws IOException {

		if (itestresult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility screenshot = new ScreenshotUtility();
			screenshot.getScreenshot(driver, itestresult.getName());
		}
		 driver.quit();

	}

}
