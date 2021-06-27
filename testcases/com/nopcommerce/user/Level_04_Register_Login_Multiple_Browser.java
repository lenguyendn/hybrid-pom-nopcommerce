package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.MyAccountPageObject;
import pageObjects.nopcommerce.RegisterPageObject;

public class Level_04_Register_Login_Multiple_Browser extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MyAccountPageObject myAccountPage;
	
	String firstName, lastName, dayOfBirthDay, monthOfBirthDay, yearOfBirthDay, emailAddress, companyName, password;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void BeforeClass(String BrowserName, String url) {	
		
		driver = getBrowserDriver(BrowserName, url);
				
		homePage = new HomePageObject(driver);		
		driver.manage().window().maximize();

		firstName = "Le";
		lastName = "Nguyen";
		dayOfBirthDay = "31";
		monthOfBirthDay = "March";
		yearOfBirthDay = "1988";
		emailAddress = "lenguyen" + getRamdomNumber() + "@mailinator.com";
		companyName = "AFC";
		password = "123456";

	}

	@Test
	public void TC_01_Register() {
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		
		registerPage.clickToGenderFemaleRadio();
		registerPage.sendKeyToFirstNameTextbox(firstName);
		registerPage.sendKeyToLastNameTextbox(lastName);
		registerPage.selectDayDropdown(dayOfBirthDay);
		registerPage.selectMonthDropdown(monthOfBirthDay);
		registerPage.selectYearDropdown(yearOfBirthDay);
		registerPage.sendKeyToEmailTextbox(emailAddress);
		registerPage.sendKeyToCompanyTextbox(companyName);
		registerPage.clickToNewsletterCheckbox();
		registerPage.sendKeyToPasswordTextbox(password);
		registerPage.sendKeyToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isRegisterSuccessMessageDisplay());
		
		registerPage.clickToLogoutLink();
		homePage = new HomePageObject(driver);
		
		
		
	}

	@Test(enabled = true)
	public void TC_02_Login() {
		homePage.clickToLoginLink();		
		loginPage = new LoginPageObject(driver);
		
		loginPage.sendkeyToEMailTextbox(emailAddress);
		loginPage.sendkeyToPasswordTextbox(password);
		
		loginPage.clickToLoginButton();		
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplay());
		Assert.assertTrue(homePage.isLogoutLinkDisplay());
		
		
	}

	@Test(enabled = true)
	public void TC_03_My_Account() {
		homePage.clickToMyAccountLink();		
		myAccountPage = new MyAccountPageObject(driver);
		
		Assert.assertTrue(myAccountPage.isGenderFemaleRadioSelected());
		Assert.assertEquals(myAccountPage.getFirstNameTextboxValue(), firstName);
		Assert.assertEquals(myAccountPage.getLastNameTextboxValue(), lastName);
		Assert.assertEquals(myAccountPage.getEmailTextboxValue(), emailAddress);
		Assert.assertEquals(myAccountPage.getCompanyNameTextboxValue(), companyName);
		
		Assert.assertEquals(myAccountPage.getDayDropdownValue(), dayOfBirthDay);
		Assert.assertEquals(myAccountPage.getMonthDropdownValue(), monthOfBirthDay);
		Assert.assertEquals(myAccountPage.getYearDropdownValue(), yearOfBirthDay);
		
		Assert.assertTrue(myAccountPage.isNewsletterCheckboxSelected());		
		
	}

	@AfterClass
	public void AfterClass() {
		driver.quit();

	}
}
