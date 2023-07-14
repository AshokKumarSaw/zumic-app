package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	// Elements

	@FindBy(id = "email-reg")
	WebElement txtEmail;
	@FindBy(id = "password-reg")
	WebElement txtPassword;
	@FindBy(xpath = "//button[@type='submit']//span[contains(text(),'Register')]")
	WebElement btnRegister;
	@FindBy(xpath = "//h1[normalize-space()='Success!']")
	WebElement msgRegistrationSuccess;
	// Methods

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void clickBtnRegister() {
		
		/*
		 * JavascriptExecutor js=(JavascriptExecutor)driver;
		 * js.executeScript("arguments[0].click()",btnRegister);
		 */
		 
		btnRegister.click();
		
	}

	public String getRegSuccessMsg() {

		System.out.println(msgRegistrationSuccess.getText());
		return msgRegistrationSuccess.getText();
		
	}

}
