package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtilities;

public class SubCategory {

	public WebDriver driver;

	PageUtilities page = new PageUtilities();
	FileUploadUtility upload = new FileUploadUtility();

	public SubCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // inbuilt class {pagefactory} //initialize web elements (initElements)

	}

	// xpath of add new item on subcategory

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement NewButton;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement subCategoryDropdown;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement subCategoryField;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFile;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successAlert;

	// xpath of search an item

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButtonOnTop;
	@FindBy(xpath = "//select[@id='un']")
	WebElement categoryDropdown;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement subCategoryFieldInSearchPage;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement searchButtonInSearchpage;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> tableSearch;
	@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']")
	WebElement notFoundAlert;

	// methods for add new items

	public SubCategory clickOnNewButton() {
		NewButton.click();
		return this;

	}

	public SubCategory selectCategory() {
		page.selectDropdownByVisibleText(subCategoryDropdown, "Vegetables");
		return this;

	}

	public SubCategory enterSubCategory() {
		subCategoryField.sendKeys("Carrots" + page.generateCurrentDateAndTime()); // to maintain the item unique so that
																					// current date and time is added
		return this;
	}

	public SubCategory uploadImage() {
		String path = Constants.LP_VERIFYADDNEWSUBCATEGORYWITHVALIDDETAILSIMAGE;
		upload.fileUploadSendkeys(chooseFile, path);
		return this;
	}

	public SubCategory clickOnSaveButton() {
		saveButton.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return successAlert.isDisplayed();

	}

	// methods for search functionality

	public SubCategory clickOnSearchButtonOnTop() {
		searchButtonOnTop.click();
		return this;

	}

	public SubCategory selectCategoryOnSearchPage() {
		page.selectDropdownByVisibleText(categoryDropdown, "Vegetables");
		return this;

	}

	public SubCategory enterSubCategoryOnSearchPage() {
		subCategoryFieldInSearchPage.sendKeys("beetroot");
		return this;
	}

	public SubCategory clickOnSearchButtonInSearchPage() {
		searchButtonInSearchpage.click();
		return this;

	}

	public boolean verifySearchResult(String element, List<WebElement> list) {

		int flag = 0;

		for (WebElement searchResult : list) {
			if (searchResult.getText().equals(element)) {
				System.out.println(searchResult.getText());
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			return true;

		} else {
			return false;

		}
	}

	public boolean verifySubcategorySearchResult() {
		String element = "beetroot";
		boolean result = verifySearchResult(element, tableSearch);
		return result;
	}

	public boolean isNotFoundAlertDisplayed() {

		return notFoundAlert.isDisplayed();

	}
}
