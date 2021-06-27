package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	
	public HomePageObject(WebDriver _driver) {
		this.driver = _driver;
	}

	public void clickToLoginLink() {
		clickToElement(driver, HomePageUI.LOGIN_LINK);
	}

	public void clickToRegisterLink() {
		clickToElement(driver, HomePageUI.REGISTER_LINK);		
	}

	public void clickToMyAccountLink() {
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	public boolean isMyAccountLinkDisplay() {
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	public boolean isLogoutLinkDisplay() {
		return isElementDisplayed(driver, HomePageUI.LOGOUT_LINK);
	}

}
