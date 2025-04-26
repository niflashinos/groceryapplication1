package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) // constuctor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); // inbuilt class {pagefactory} //initialize web elements (initElements)

	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")
	WebElement subCategoryLink;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']")
	WebElement CategoryLink;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	WebElement ManageNewsLink;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and text()='More info ']")
	WebElement AdminUsersLink;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")
	WebElement manageFooterTextLink;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']")
	WebElement ManageContactLink;

	public SubCategory clickOnSubCategory() {
		subCategoryLink.click();
		return new SubCategory(driver);

	}

	public Category clickOnCategory() {
		CategoryLink.click();
		return new Category(driver);

	}

	public ManageNews clickOnManageNews() {

		ManageNewsLink.click();
		return new ManageNews(driver);
	}

	public AdminUsers clickOnAdminUsers() {

		AdminUsersLink.click();
		return new AdminUsers(driver);
	}

	public ManageFooter clickOnManageFooterText() {
		manageFooterTextLink.click();
		return new ManageFooter(driver);

	}

	public ManageContact clickOnManageContact() {
		ManageContactLink.click();
		return new ManageContact(driver);

	}

}
