package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) // constuctor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); // inbuilt class {pagefactory} //initialize web elements (initElements)

	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameField;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signInButton;

	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	WebElement welcomeText;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertMessage;

	public LoginPage enterUsernameOnUsernameField(String username) {
		userNameField.sendKeys(username);
		return this;

	}

	public LoginPage enterPasswordOnPasswordField(String password) {

		passwordField.sendKeys(password);
		return this;
	}

	public HomePage signInButtonClick() {

		signInButton.click();
		return new HomePage(driver);
	}

	public boolean isHomePageLoaded() {

		return welcomeText.isDisplayed();
	}

	public boolean isAlertMessageDisplayed() {

		return alertMessage.isDisplayed();
	}

	public HomePage loginByUsingExcelData() throws IOException {
		String username = ExcelUtility.getStringdata(1, 0, "loginpage");
		String password = ExcelUtility.getStringdata(1, 1, "loginpage");
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
		signInButton.click();
		return new HomePage(driver);
	}

}
