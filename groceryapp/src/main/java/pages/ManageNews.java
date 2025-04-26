package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNews {

	public WebDriver driver;

	public ManageNews(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // inbuilt class {pagefactory} //initialize web elements (initElements)

	}

	// xpath for add new news

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement clickOnNewButton;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement enterNewsField;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement clickOnSaveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement succesAlert;

	// xpath for delete news

	@FindBy(xpath = "//i[@class='fas fa-trash-alt']")
	WebElement deleteIcon;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement deleteAlert;

	// methods for add new news

	public ManageNews addNewNewsInManageNews() {

		clickOnNewButton.click();
		return this;
	}

	public ManageNews enterNewNews() {

		enterNewsField.sendKeys("summer offer started");
		return this;
	}

	public ManageNews clickSaveButton() {

		clickOnSaveButton.click();
		return this;
	}

	public boolean isAlertDisplayed() {

		return succesAlert.isDisplayed();
	}

	// method for delete news

	public ManageNews clickOnDeleteIcon() {
		deleteIcon.click();
		driver.switchTo().alert().accept();
		return this;

	}

	public boolean isDeleteAlertDisplayed() {

		return deleteAlert.isDisplayed();
	}
}
