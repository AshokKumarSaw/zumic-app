package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	// Element
	@FindBy(xpath = "//i[@class='icon-dotarr']")
	WebElement drpdwnMyAccount;
	@FindBy(xpath = "//a[normalize-space()='Log out']")
	WebElement lnkLogout;

	public void clickMyAccountDrpdwn() {
		drpdwnMyAccount.click();
	}

	public boolean isMyAccountVisible() {
		try {
			return lnkLogout.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void clickLogout() {
		drpdwnMyAccount.click();
		lnkLogout.click();
	}
}
