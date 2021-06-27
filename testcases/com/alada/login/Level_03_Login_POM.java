package com.alada.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.alada.HomePageObject;
import pageObjects.alada.LoginPageObjects;

public class Level_03_Login_POM extends BasePage {
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObjects loginPage;
	String loginPageUrl, invalidEmail, notCorrectEmail, validEmail, invalidPassword, notCorrectPassword, validPassword;
	
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		openUrlPage(driver,"https://alada.vn/");
		openBrowserMaximum(driver);		
		homePage = new HomePageObject(driver);
		
		loginPageUrl = "https://alada.vn/tai-khoan/dang-nhap.html";
		invalidEmail = "abc@";
		notCorrectEmail ="automation" + getRamdomNumber() + "@hotmail.com";
		validEmail = "automationfc.vn@hotmail.com";
		invalidPassword = "123";
		notCorrectPassword = "123456789";
		validPassword = "123456";		
	}
	
	@Test
	public void TC_01_Login_No_Data() {
		homePage.clickToLoginLink();
		
		loginPage = new LoginPageObjects(driver);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageForEmail(), "Vui lòng nhập email");
		Assert.assertEquals(loginPage.getErrorMessageForPassword(), "Vui lòng nhập mật khẩu");
		Assert.assertEquals(loginPage.getPageUrl(), loginPageUrl);
	}
	
	@Test
	public void TC_02_Login_Invalid_Email() {
		loginPage.sendKeyToEmailTextbox(invalidEmail);
		loginPage.sendKeyToPasswordTextbox(validPassword);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageForEmail(), "Vui lòng nhập email hợp lệ");
		Assert.assertEquals(loginPage.getPageUrl(), loginPageUrl);		
	}
	
	@Test
	public void TC_03_Login_Not_Registered_Email() {
		loginPage.sendKeyToEmailTextbox(notCorrectEmail);
		loginPage.sendKeyToPasswordTextbox(validPassword);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageForNotCorrectEmailPassword(), "Email này chưa được đăng ký.");
		Assert.assertEquals(loginPage.getPageUrl(), loginPageUrl);;		
	}
	
	@Test
	public void TC_04_Login_Invalid_Password() {
		//Invalid password
		loginPage.sendKeyToEmailTextbox(validEmail);
		loginPage.sendKeyToPasswordTextbox(invalidPassword);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageForNotCorrectEmailPassword(), "Mật khẩu sai.");
		Assert.assertEquals(loginPage.getPageUrl(), loginPageUrl);
		
		//Not Correct Password
		loginPage.sendKeyToEmailTextbox(validEmail);
		loginPage.sendKeyToPasswordTextbox(notCorrectPassword);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageForNotCorrectEmailPassword(), "Mật khẩu sai.");
		Assert.assertEquals(loginPage.getPageUrl(), loginPageUrl);
	}
	
	@Test
	public void TC_05_Login_Valid_Data() {
		loginPage.sendKeyToEmailTextbox(validEmail);
		loginPage.sendKeyToPasswordTextbox(validPassword);
		loginPage.clickToLoginButton();
		
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.ismyCourseDisplay());
		
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
