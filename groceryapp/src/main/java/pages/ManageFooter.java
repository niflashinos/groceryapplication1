package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;

public class ManageFooter {
	public WebDriver driver;
	FakerUtility faker = new FakerUtility();

	public ManageFooter(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // inbuilt class {pagefactory} //initialize web elements (initElements)

	}

	// xpath for update footer text

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']")
	WebElement updateIcon;
	@FindBy(xpath = "//textarea[@id='content']")
	WebElement addressField;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailField;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement passwordField;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successAlert;

	// methods for update footer text

	public ManageFooter clickOnUpdateIcon() {
		updateIcon.click();
		return this;

	}

	public ManageFooter enterAddressOnAddressField() {
		addressField.clear();
		addressField.sendKeys(faker.generateAddress());
		return this;

	}

	public ManageFooter enterEmailOnEmailField() {
		emailField.clear();
		emailField.sendKeys(faker.generateEmailAddress());
		return this;

	}

	public ManageFooter enterPhoneNumberOnPhoneNumberField() {
		passwordField.clear();
		passwordField.sendKeys(faker.generatePhone());
		return this;

	}

	public ManageFooter clickOnUpdateButton() {
		updateButton.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return successAlert.isDisplayed();
	}

}