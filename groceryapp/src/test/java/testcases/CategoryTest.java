package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.Category;
import pages.HomePage;
import pages.LoginPage;

public class CategoryTest extends BaseClass {

	LoginPage login;
	HomePage home;
	Category category;

	@Test
	public void verifyAddNewCategoryWithValidDetails() throws IOException {
		login = new LoginPage(driver);
		home = login.loginByUsingExcelData();
		category = home.clickOnCategory().clickOnNewButton().enterCategory().selectGroup().clickOnChooseFile()
				.selectRadioButtonOnTopMenu().selectRadioButtonOnLeftMenu().clickOnSaveButton();

		boolean isAlertDisplayed = category.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Constants.LP_VERIFYADDNEWCATEGORYWITHVALIDDETAILS);

	}
}
