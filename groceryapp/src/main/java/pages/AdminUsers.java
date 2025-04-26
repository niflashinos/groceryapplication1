package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class AdminUsers {

	public WebDriver driver;

	PageUtilities page = new PageUtilities();

	public AdminUsers(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// xpath for add new admin users

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement clickNewButton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement usernameField;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordField;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement userTypeDropDown;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement clickSaveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement succesAlert;

	// xpath for delete admin users

	@FindBy(xpath = "//i[@class='fas fa-trash-alt']")
	WebElement deleteIcon;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement deleteAlert;

	// methods for add new admin users

	public AdminUsers clickOnNewButton() {
		clickNewButton.click();
		return this;

	}

	public AdminUsers enterDataOnUsernameField() {
		usernameField.sendKeys("mohan");
		return this;

	}

	public AdminUsers enterDataOnPasswordField() {
		passwordField.sendKeys("mohan123");
		return this;

	}

	public AdminUsers selectFromUsertypeDropdown() {
		page.selectDropdownByVisibleText(userTypeDropDown, "Staff");
		return this;
	}

	public AdminUsers clickOnSaveButton() {
		clickSaveButton.click();
		return this;

	}

	public boolean isAlertDisplayed() {
		return succesAlert.isDisplayed();

	}

	// methods for delete admin user

	public AdminUsers clickOnDeleteIcon() {
		deleteIcon.click();
		driver.switchTo().alert().accept();
		return this;

	}

	public boolean isDeleteAlertDisplayed() {
		return succesAlert.isDisplayed();

	}

}
