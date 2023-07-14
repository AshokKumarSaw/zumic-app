package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);
	}

//Elements
	@FindBy(xpath = "//a[@class='login-tab']//span[contains(text(),'Register')]")
	WebElement tabRegister;

	@FindBy(id = "email-login")
	WebElement txtEmail;
	@FindBy(id = "password-login")
	WebElement txtPassword;
	@FindBy(id = "btn-login")
	WebElement btnLogin;

	// Methods
	public void clickTabRegister() {
		tabRegister.click();
	}

	public void setLoginEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setLoginPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void clickBtnLogin() {
		btnLogin.click();
	}

}
