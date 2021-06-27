package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.MyAccountPageUI;

public class MyAccountPageObject extends BasePage {
	private WebDriver driver;
	
	public MyAccountPageObject(WebDriver _driver) {
		this.driver = _driver;
	}

	public boolean isGenderFemaleRadioSelected() {
		waitForElementVisible(driver, MyAccountPageUI.GENDER_FEMAIL_RADIO);
		return isElementSelected(driver, MyAccountPageUI.GENDER_FEMAIL_RADIO);
	}

	public String getFirstNameTextboxValue() {
		waitForElementVisible(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX);
		return getAttributeValue(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX, "value");
	}

	public String getLastNameTextboxValue() {
		waitForElementVisible(driver, MyAccountPageUI.LAST_NAME_TEXTBOX);
		return getAttributeValue(driver, MyAccountPageUI.LAST_NAME_TEXTBOX, "value");
	}

	public String getEmailTextboxValue() {
		waitForElementVisible(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		return getAttributeValue(driver, MyAccountPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyNameTextboxValue() {
		waitForElementVisible(driver, MyAccountPageUI.COMPANY_TEXTBOX);
		return getAttributeValue(driver, MyAccountPageUI.COMPANY_TEXTBOX, "value");
	}

	public String getDayDropdownValue() {
		waitForElementVisible(driver, MyAccountPageUI.DAY_DROPDOWN);
		return getFirstSelectedItemInDefaultDropDown(driver, MyAccountPageUI.DAY_DROPDOWN);
	}

	public String getMonthDropdownValue() {
		waitForElementVisible(driver, MyAccountPageUI.MONTH_DROPDOWN);
		return getFirstSelectedItemInDefaultDropDown(driver, MyAccountPageUI.MONTH_DROPDOWN);
	}

	public String getYearDropdownValue() {
		waitForElementVisible(driver, MyAccountPageUI.YEAR_DROPDOWN);
		return getFirstSelectedItemInDefaultDropDown(driver, MyAccountPageUI.YEAR_DROPDOWN);
	}

	public boolean isNewsletterCheckboxSelected() {
		waitForElementVisible(driver, MyAccountPageUI.NEWSLETTER_CHECKBOX);
		return isElementSelected(driver, MyAccountPageUI.NEWSLETTER_CHECKBOX);
	}

}
