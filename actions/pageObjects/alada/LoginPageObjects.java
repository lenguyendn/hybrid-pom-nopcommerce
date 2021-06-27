package pageObjects.alada;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.alada.LoginPageUI;

public class LoginPageObjects extends BasePage {
	private WebDriver driver;

	public LoginPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLoginButton() {
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public String getErrorMessageForEmail() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getTextElement(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageForPassword() {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_ERROR_MESSAGE);
		return getTextElement(driver, LoginPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageForNotCorrectEmailPassword() {
		waitForElementVisible(driver, LoginPageUI.FORM_ERROR_MESSAGE);
		return getTextElement(driver, LoginPageUI.FORM_ERROR_MESSAGE);
	}

	public String getPageUrl() {
		return getPageUrl(driver);
	}

	public void sendKeyToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void sendKeyToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}
}
