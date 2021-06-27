package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Register_login_BasePage_Part_III extends BasePage{
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String firstName, lastName, dayOfBirthDay, monthOfBirthDay, yearOfBirthDay, emailAddress, companyName, password;

	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		openUrlPage(driver,"https://demo.nopcommerce.com/");
		openBrowserMaximum(driver);

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
		clickToElement(driver,"//a[@class='ico-register']");
		checkToCheckboxOrRadio(driver, "//input[@id='gender-female']");
		sendKeyToElement(driver, "//input[@id='FirstName']", firstName);
		sendKeyToElement(driver, "//input[@id='LastName']", lastName);
		
		selectItemInDefaultDropDown(driver, "//select[@name='DateOfBirthDay']", dayOfBirthDay);
		selectItemInDefaultDropDown(driver, "//select[@name='DateOfBirthMonth']", monthOfBirthDay);
		selectItemInDefaultDropDown(driver, "//select[@name='DateOfBirthYear']", yearOfBirthDay);

		sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendKeyToElement(driver, "//input[@id='Company']", companyName);

		checkToCheckboxOrRadio(driver, "//input[@id='Newsletter']");		

		sendKeyToElement(driver, "//input[@id='Password']", password);
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", password);

		clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(getTextElement(driver, "//div[@class='result']"), "Your registration completed");
		clickToElement(driver, "//a[@class='ico-logout']");
	}

	@Test(enabled = true)
	public void TC_02_Login() {
		
		clickToElement(driver, "//a[@class='ico-login']");
		sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendKeyToElement(driver, "//input[@id='Password']", password);
		clickToElement(driver, "//button[contains(concat(' ', normalize-space(@class), ' '), ' login-button ')]");

		Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-account']"));
		Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-logout']"));
	}

	@Test(enabled = true)
	public void TC_03_My_Account() {
		clickToElement(driver, "//a[@class='ico-account']");
		Assert.assertEquals(getTextElement(driver, "//div[@class='page-title']/h1"), "My account - Customer info");		
		Assert.assertTrue(isElementSelected(driver, "//input[@id='gender-female']"));
		Assert.assertEquals(getAttributeValue(driver, "//input[@id='FirstName']", "value"), firstName);
		Assert.assertEquals(getAttributeValue(driver, "//input[@id='LastName']", "value"), lastName);
		Assert.assertEquals(getAttributeValue(driver, "//input[@id='Email']", "value"), emailAddress);
		Assert.assertEquals(getAttributeValue(driver, "//input[@id='Company']", "value"), companyName);

		Assert.assertEquals(getFirstSelectedItemInDefaultDropDown(driver, "//select[@name='DateOfBirthDay']"), dayOfBirthDay);
		Assert.assertEquals(getFirstSelectedItemInDefaultDropDown(driver, "//select[@name='DateOfBirthMonth']"), monthOfBirthDay);
		Assert.assertEquals(getFirstSelectedItemInDefaultDropDown(driver, "//select[@name='DateOfBirthYear']"), yearOfBirthDay);

		Assert.assertTrue(isElementSelected(driver, "//input[@id='Newsletter']"));

	}

	@AfterClass
	public void AfterClass() {
		driver.quit();

	}

	public int getRamdomNumber() {
		Random rand = new Random();
		return rand.nextInt(10000);
	}

}
