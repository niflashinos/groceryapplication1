package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;

public class Login_Test extends BaseClass {
	LoginPage login;

	@Test
	public void loginUsingValidCredentials() throws IOException {
		login = new LoginPage(driver);
		login.loginByUsingExcelData();

		boolean isHomePageLoaded = login.isHomePageLoaded();
		Assert.assertTrue(isHomePageLoaded, Constants.LP_VERIFYLOGINWITHVALIDCREDENTIALS);

	}

	@Test
	public void loginUsingValidUsernameAndInvalidPassword() {

		login = new LoginPage(driver);
		login.enterUsernameOnUsernameField("admin").enterPasswordOnPasswordField("adm123").signInButtonClick();

		boolean isalertdisplayed = login.isAlertMessageDisplayed();
		Assert.assertTrue(isalertdisplayed, Constants.LP_ALERTMESSAGE);

	}

	@Test
	public void loginUsingInValidUsernameAndValidPassword() {

		login = new LoginPage(driver);
		login.enterUsernameOnUsernameField("123adm").enterPasswordOnPasswordField("admin").signInButtonClick();

		boolean isalertdisplayed = login.isAlertMessageDisplayed();
		Assert.assertTrue(isalertdisplayed, Constants.LP_ALERTMESSAGE);

	}

	@Test(dataProvider = "invalidUsernameAndPassword")
	public void invalidCredentials(String u, String p) {

		login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(u).enterPasswordOnPasswordField(p).signInButtonClick();

		boolean isalertdisplayed = login.isAlertMessageDisplayed();
		Assert.assertTrue(isalertdisplayed, Constants.LP_ALERTMESSAGE);

	}

	@DataProvider
	public Object[][] invalidUsernameAndPassword() {

		return new Object[][] { { "adm", "123" }, { "123admin", "abcd" }, { "mkjbk", "122bjj" } };

	}
}
