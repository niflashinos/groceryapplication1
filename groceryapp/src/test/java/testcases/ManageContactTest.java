package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContact;

public class ManageContactTest extends BaseClass {
	LoginPage login;
	HomePage home;
	ManageContact contact;

	@Test
	public void verifyUpdateContactInformation() throws IOException {
		login = new LoginPage(driver);
		home = login.loginByUsingExcelData();
		contact = home.clickOnManageContact().clickOnUpdateIcon().enterPhoneNumber().enterEmailId().enterAddress()
				.enterDeliveryTime().enterDeliveryChargeLimit().clickOnUpdateButton();

		boolean isAlertDisplayed = contact.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Constants.LP_VERIFYUPDATECONTACTINFORMATION);
	}
}
