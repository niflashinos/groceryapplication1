package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategory;

public class SubCategoryTest extends BaseClass {
	LoginPage login;
	HomePage home;
	SubCategory subcategory;

	// add new item
	@Test
	public void verifyAddNewSubcategoryWithValidDetails() throws IOException {

		login = new LoginPage(driver);
		home = login.loginByUsingExcelData();
		subcategory = home.clickOnSubCategory().clickOnNewButton().selectCategory().enterSubCategory().uploadImage()
				.clickOnSaveButton();

		boolean isAlertDisplayed = subcategory.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Constants.LP_VERIFYADDNEWSUBCATEGORYWITHVALIDDETAILS);

	}

	// search an item
	@Test
	public void verifySearchNonExistingItem() throws IOException {
		login = new LoginPage(driver);
		home = login.loginByUsingExcelData();
		subcategory = home.clickOnSubCategory().clickOnSearchButtonOnTop().selectCategoryOnSearchPage()
				.enterSubCategoryOnSearchPage().clickOnSearchButtonInSearchPage();

		subcategory.verifySubcategorySearchResult();

		boolean isNotFoundAlertDisplayed = subcategory.isNotFoundAlertDisplayed();
		Assert.assertTrue(isNotFoundAlertDisplayed, Constants.LP_VERIFYSEARCHANEXISTINGITEM);

	}

}
