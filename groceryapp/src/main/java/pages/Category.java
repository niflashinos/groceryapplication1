package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtilities;

public class Category {
	public WebDriver driver;

	PageUtilities page = new PageUtilities();
	FileUploadUtility fileupload = new FileUploadUtility();

	public Category(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // inbuilt class {pagefactory} //initialize web elements (initElements)

	}

	// xpath for add new category

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement NewButton;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement Categoryfield;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement SelectGroupButton;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement ChooseFileButton;
	@FindBy(xpath = "//input[@name='top_menu' and @value='yes']")
	WebElement radioButtonOnTopYes;
	@FindBy(xpath = "//input[@name='top_menu' and @value='no']")
	WebElement radioButtonOnTopNo;
	@FindBy(xpath = "//input[@name='show_home' and @value='yes']")
	WebElement radioButtonOnLeftYes;
	@FindBy(xpath = "//input[@name='show_home' and @value='no']")
	WebElement radioButtonOnLeftNo;
	@FindBy(xpath = "//button[@name='create']")
	WebElement saveButton;
	@FindBy(xpath = "//i[@class='icon fas fa-check']")
	WebElement successAlert;

	// methods for add new category

	public Category clickOnNewButton() {
		NewButton.click();
		return this;

	}

	public Category enterCategory() {
		Categoryfield.sendKeys("food " + page.generateCurrentDateAndTime());
		return this;
	}

	public Category selectGroup() {
		page.clickJavaScriptExecutor(SelectGroupButton, driver);
		return this;
	}

	public Category clickOnChooseFile() {

		String path = Constants.LP_VERIFYADDNEWCATEGORYWITHVALIDDETAILSIMAGE;
		fileupload.fileUploadSendkeys(ChooseFileButton, path);
		return this;
	}

	public Category selectRadioButtonOnTopMenu() {
		page.clickJavaScriptExecutor(radioButtonOnTopYes, driver);
		// page.clickJavaScriptExecutor(radioButtonOnTopNo, driver);
		return this;

	}

	public Category selectRadioButtonOnLeftMenu() {
		// page.clickJavaScriptExecutor(radioButtonOnLeftYes, driver);
		page.clickJavaScriptExecutor(radioButtonOnLeftNo, driver);
		return this;

	}

	public Category clickOnSaveButton() {
		page.clickJavaScriptExecutor(saveButton, driver);
		return this;

	}

	public boolean isAlertDisplayed() {
		return successAlert.isDisplayed();
	}

}
