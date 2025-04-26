package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNews;

public class ManageNewsTest extends BaseClass {
	LoginPage login;
	HomePage home;
	ManageNews news;

	@Test
	public void verifyAddNewNews() throws IOException {

		login = new LoginPage(driver);
		home = login.loginByUsingExcelData();
		news = home.clickOnManageNews().addNewNewsInManageNews().enterNewNews().clickSaveButton();

		boolean isAlertDisplayed = news.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Constants.LP_VERIFYADDNEWNEWS);

	}

	@Test
	public void verifyDeleteNews() throws IOException {

		login = new LoginPage(driver);
		home = login.loginByUsingExcelData();
		news = home.clickOnManageNews().clickOnDeleteIcon();

		boolean isDeleteAlertDisplayed = news.isDeleteAlertDisplayed();
		Assert.assertTrue(isDeleteAlertDisplayed, Constants.LP_VERIFYDELETENEWS);
	}
}
