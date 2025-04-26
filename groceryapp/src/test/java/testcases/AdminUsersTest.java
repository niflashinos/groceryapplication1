package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUsers;
import pages.HomePage;
import pages.LoginPage;

public class AdminUsersTest extends BaseClass {

	LoginPage login;
	HomePage home;
	AdminUsers admin;

	@Test
	public void verifyAddNewAdminUsers() throws IOException {
		login = new LoginPage(driver);
		home = login.loginByUsingExcelData();
		admin = home.clickOnAdminUsers().clickOnNewButton().enterDataOnUsernameField().enterDataOnPasswordField()
				.selectFromUsertypeDropdown().clickOnSaveButton();

		boolean isAlertDisplayed = admin.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Constants.LP_VERIFYADDNEWADMINUSERS);

	}

	@Test
	public void verifyDeleteAdminUsers() throws IOException {
		login = new LoginPage(driver);
		home = login.loginByUsingExcelData();
		admin = home.clickOnAdminUsers().clickOnDeleteIcon();

		boolean isDeleteAlertDisplayed = admin.isDeleteAlertDisplayed();
		Assert.assertTrue(isDeleteAlertDisplayed, Constants.LP_VERIFYDELETEADMINUSERS);

	}

}
