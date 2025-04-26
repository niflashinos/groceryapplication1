package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageFooter;

public class ManageFooterTest extends BaseClass {

	LoginPage login;
	HomePage home;
	ManageFooter footer;

	@Test
	public void verifyUpdateFooterText() throws IOException {
		login = new LoginPage(driver);
		home = login.loginByUsingExcelData();
		footer = home.clickOnManageFooterText().clickOnUpdateIcon().enterAddressOnAddressField()
				.enterEmailOnEmailField().enterPhoneNumberOnPhoneNumberField().clickOnUpdateButton();

		boolean isAlertDisplayed = footer.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Constants.LP_VERIFYUPDATEFOOTERTEXT);

	}
}
