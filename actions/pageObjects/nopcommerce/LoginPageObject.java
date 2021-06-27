package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;
	
	public LoginPageObject(WebDriver _driver) {
		this.driver = _driver;
	}

	public void sendkeyToEMailTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);		
	}

	public void sendkeyToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWPORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWPORD_TEXTBOX, password);		
	}

	public void clickToLoginButton() {
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);		
	}

}
