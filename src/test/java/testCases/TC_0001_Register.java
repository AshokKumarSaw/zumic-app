package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC_0001_Register extends BaseClass {
	@Test(groups={"regression","master"})
	public void testRegistration() {
		// logger.debug("Application logs for debugging");
		logger.info("*** Starting TC_0001_Register ***");
		try {
			HomePage homePage = new HomePage(driver);
			homePage.clickLoginRegister();
			logger.info("Clicked on Login/Regisetr Link");
			LoginPage loginPage = new LoginPage(driver);
			loginPage.clickTabRegister();
			logger.info("Clicked on Register Tab");
			RegisterPage registerPage = new RegisterPage(driver);
			logger.info("Entering user details for Registration");
			registerPage.setEmail(randomAlphaNumeric() + "@gmail.com");
			registerPage.setPassword(randomNumber());
			registerPage.clickBtnRegister();
			logger.info("Clicked on Register button");

			logger.info("Validating successful Registration message");
			String confmsg = registerPage.getRegSuccessMsg();
			Assert.assertEquals(confmsg, "Success!", "Registration Test failed");

		} catch (Exception e) {
			logger.error(" Registration Test Failed");
			Assert.fail();
		}
		logger.info("*** Finished TC_0001_Register ***");
	}
}
