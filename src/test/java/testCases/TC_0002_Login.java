package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_0002_Login extends BaseClass{

	@Test(groups={"sanity","master"})
	public void testLogin()
	{
		logger.info("*** Starting TC_0002_Login ***");
		try {
		 
		HomePage homePage = new HomePage(driver);
		homePage.clickLoginRegister();
		LoginPage loginPage=new LoginPage(driver);
		logger.info("Entering valid credentials to Login"); 
		loginPage.setLoginEmail(rb.getString("email"));
	//	loginPage.setLoginEmail(properties.getProperty("email"));
		loginPage.setLoginPassword(rb.getString("password"));
	//	loginPage.setLoginPassword(properties.getProperty("password"));
		logger.info("email and password entered sucessfully"); 
		loginPage.clickBtnLogin();
		logger.info("Clicked on Login Button"); 
		MyAccountPage myAccountPage= new MyAccountPage(driver);
		myAccountPage.clickMyAccountDrpdwn();
		logger.info("Clicked on My Account Icon");
		boolean logoutLnk=myAccountPage.isMyAccountVisible();
		Assert.assertEquals(logoutLnk, true,"Logout link is not present");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*** Finished TC_0002_Login ***"); 
	}
}
