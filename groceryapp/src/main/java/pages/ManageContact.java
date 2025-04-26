package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;
import utilities.PageUtilities;

public class ManageContact {

	public WebDriver driver;
	PageUtilities js = new PageUtilities();
	FakerUtility faker = new FakerUtility();

	public ManageContact(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// xpath for update contact details

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']")
	WebElement updateIcon;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phoneNumberField;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailField;
	@FindBy(xpath = "//textarea[@name='address' ]")
	WebElement addressField;
	@FindBy(xpath = "//textarea[@name='del_time' ]")
	WebElement deliveryTimeField;
	@FindBy(xpath = "//input[@id='del_limit' ]")
	WebElement deliveryChargeLimitField;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info' ]")
	WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successAlert;

	// methods for update contact details

	public ManageContact clickOnUpdateIcon() {
		updateIcon.click();
		return this;

	}

	public ManageContact enterPhoneNumber() {
		phoneNumberField.clear();
		phoneNumberField.sendKeys("9192939495");
		return this;
	}

	public ManageContact enterEmailId() {
		emailField.clear();
		emailField.sendKeys(faker.generateEmailAddress());
		return this;
	}

	public ManageContact enterAddress() {
		addressField.clear();
		addressField.sendKeys(faker.generateAddress());
		return this;
	}

	public ManageContact enterDeliveryTime() {
		deliveryTimeField.clear();
		deliveryTimeField.sendKeys("5 pm");
		return this;
	}

	public ManageContact enterDeliveryChargeLimit() {
		deliveryChargeLimitField.clear();
		deliveryChargeLimitField.sendKeys("50");
		return this;
	}

	public ManageContact clickOnUpdateButton() {
		// js.downScrollJavaScriptExecutor(updateButton, driver);
		js.clickJavaScriptExecutor(updateButton, driver);
		return this;
	}

	public boolean isAlertDisplayed() {
		return successAlert.isDisplayed();

	}

}
