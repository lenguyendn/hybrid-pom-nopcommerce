package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.RegisterPageUI;

public class RegisterPageObject extends BasePage{
	private WebDriver driver;
	
	public RegisterPageObject(WebDriver _driver) {
		this.driver = _driver;
	}

	public void clickToGenderFemaleRadio() {
		clickToElement(driver, RegisterPageUI.GENDER_FEMALE_RADIO);		
	}

	public void sendKeyToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);		
	}

	public void sendKeyToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}

	public void selectDayDropdown(String dayOfBirthDay) {
		waitForElementVisible(driver, RegisterPageUI.DAY_DROPDOWN);
		selectItemInDefaultDropDown(driver, RegisterPageUI.DAY_DROPDOWN, dayOfBirthDay);		
	}

	public void selectMonthDropdown(String monthOfBirthDay) {
		waitForElementVisible(driver, RegisterPageUI.MONTH_DROPDOWN);
		selectItemInDefaultDropDown(driver, RegisterPageUI.MONTH_DROPDOWN, monthOfBirthDay);		
	}

	public void selectYearDropdown(String yearOfBirthDay) {
		waitForElementVisible(driver, RegisterPageUI.YEAR_DROPDOWN);
		selectItemInDefaultDropDown(driver, RegisterPageUI.YEAR_DROPDOWN, yearOfBirthDay);
		
	}

	public void sendKeyToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
		
	}

	public void sendKeyToCompanyTextbox(String companyName) {
		waitForElementVisible(driver, RegisterPageUI.COMPANY_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.COMPANY_TEXTBOX, companyName);
		
	}

	public void clickToNewsletterCheckbox() {
		checkToCheckboxOrRadio(driver, RegisterPageUI.NEWSLETTER_CHECKBOX);		
	}

	public void sendKeyToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);		
	}

	public void sendKeyToConfirmPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);		
	}

	public void clickToRegisterButton() {
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);		
	}

	public boolean isRegisterSuccessMessageDisplay() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public void clickToLogoutLink() {
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);		
	}

}
