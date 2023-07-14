package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_0003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void testLoginDDT(String email, String password, String expectedResult) {
		logger.info("*** Starting TC_0003_LoginDDT ***");
		try {
			HomePage homePage = new HomePage(driver);
			homePage.clickLoginRegister();
			LoginPage loginPage = new LoginPage(driver);
			loginPage.setLoginEmail(email);
			loginPage.setLoginPassword(password);
			loginPage.clickBtnLogin();
			MyAccountPage myAccountPage = new MyAccountPage(driver);
			myAccountPage.clickMyAccountDrpdwn();
			boolean logoutLnk = myAccountPage.isMyAccountVisible();
			if (expectedResult.equals("Valid")) {
				if (logoutLnk == true) {
					myAccountPage.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}

			}

			if (expectedResult.equals("Invalid")) {
				if (logoutLnk == true) {
					myAccountPage.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}

			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("*** Finished TC_0003_LoginDDT ***");
	}
}
