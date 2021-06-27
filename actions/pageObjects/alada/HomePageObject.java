package pageObjects.alada;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.alada.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLoginLink() {
		clickToElement(driver,HomePageUI.LOGIN_LINK);		
	}

	public boolean ismyCourseDisplay() {
		waitForElementVisible(driver, HomePageUI.MY_COURSE_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_COURSE_LINK);
	}
	
}
