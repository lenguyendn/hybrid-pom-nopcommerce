package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Register_login_BasePage_Part_I {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	BasePage basePage;
	String firstName, lastName, dayOfBirthDay, monthOfBirthDay, yearOfBirthDay, emailAddress, companyName, password;

	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		basePage = new BasePage();
		
		basePage.openUrlPage(driver,"https://demo.nopcommerce.com/");
		basePage.openBrowserMaximum(driver);

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
		basePage.clickToElement(driver,"//a[@class='ico-register']");
		basePage.checkToCheckboxOrRadio(driver, "//input[@id='gender-female']");
		basePage.sendKeyToElement(driver, "//input[@id='FirstName']", firstName);
		basePage.sendKeyToElement(driver, "//input[@id='LastName']", lastName);
		
		basePage.selectItemInDefaultDropDown(driver, "//select[@name='DateOfBirthDay']", dayOfBirthDay);
		basePage.selectItemInDefaultDropDown(driver, "//select[@name='DateOfBirthMonth']", monthOfBirthDay);
		basePage.selectItemInDefaultDropDown(driver, "//select[@name='DateOfBirthYear']", yearOfBirthDay);

		basePage.sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendKeyToElement(driver, "//input[@id='Company']", companyName);

		basePage.checkToCheckboxOrRadio(driver, "//input[@id='Newsletter']");		

		basePage.sendKeyToElement(driver, "//input[@id='Password']", password);
		basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", password);

		basePage.clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(basePage.getTextElement(driver, "//div[@class='result']"), "Your registration completed");
		basePage.clickToElement(driver, "//a[@class='ico-logout']");
	}

	@Test(enabled = true)
	public void TC_02_Login() {
		
		basePage.clickToElement(driver, "//a[@class='ico-login']");
		basePage.sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendKeyToElement(driver, "//input[@id='Password']", password);
		basePage.clickToElement(driver, "//button[contains(concat(' ', normalize-space(@class), ' '), ' login-button ')]");

		Assert.assertTrue(basePage.isElementDisplayed(driver, "//a[@class='ico-account']"));
		Assert.assertTrue(basePage.isElementDisplayed(driver, "//a[@class='ico-logout']"));
	}

	@Test(enabled = true)
	public void TC_03_My_Account() {
		basePage.clickToElement(driver, "//a[@class='ico-account']");
		Assert.assertEquals(basePage.getTextElement(driver, "//div[@class='page-title']/h1"), "My account - Customer info");		
		Assert.assertTrue(basePage.isElementSelected(driver, "//input[@id='gender-female']"));
		Assert.assertEquals(basePage.getAttributeValue(driver, "//input[@id='FirstName']", "value"), firstName);
		Assert.assertEquals(basePage.getAttributeValue(driver, "//input[@id='LastName']", "value"), lastName);
		Assert.assertEquals(basePage.getAttributeValue(driver, "//input[@id='Email']", "value"), emailAddress);
		Assert.assertEquals(basePage.getAttributeValue(driver, "//input[@id='Company']", "value"), companyName);

		Assert.assertEquals(basePage.getFirstSelectedItemInDefaultDropDown(driver, "//select[@name='DateOfBirthDay']"), dayOfBirthDay);
		Assert.assertEquals(basePage.getFirstSelectedItemInDefaultDropDown(driver, "//select[@name='DateOfBirthMonth']"), monthOfBirthDay);
		Assert.assertEquals(basePage.getFirstSelectedItemInDefaultDropDown(driver, "//select[@name='DateOfBirthYear']"), yearOfBirthDay);

		Assert.assertTrue(basePage.isElementSelected(driver, "//input[@id='Newsletter']"));

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
