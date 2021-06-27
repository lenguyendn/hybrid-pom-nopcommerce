package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Level_01_Register_login_Repeat_Yourself {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Select select;
	String firstName, lastName, dayOfBirthDay, monthOfBirthDay, yearOfBirthDay, emailAddress, companyName, password;

	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
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
		driver.findElement(By.className("ico-register")).click();

		driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.id("FirstName")).sendKeys(firstName);
		driver.findElement(By.id("LastName")).sendKeys(lastName);

		select = new Select(driver.findElement(By.name("DateOfBirthDay")));
		select.selectByVisibleText(dayOfBirthDay);

		select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		select.selectByVisibleText(monthOfBirthDay);

		select = new Select(driver.findElement(By.name("DateOfBirthYear")));
		select.selectByVisibleText(yearOfBirthDay);

		driver.findElement(By.id("Email")).sendKeys(emailAddress);
		driver.findElement(By.id("Company")).sendKeys(companyName);

		if (!driver.findElement(By.id("Newsletter")).isSelected()) {
			driver.findElement(By.id("Newsletter")).click();
		}

		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(password);

		driver.findElement(By.id("register-button")).click();
		Assert.assertEquals(driver.findElement(By.className("result")).getText(), "Your registration completed");
		driver.findElement(By.className("ico-logout")).click();
	}

	@Test(enabled = true)
	public void TC_02_Login() {
		driver.findElement(By.cssSelector(".ico-login")).click();
		driver.findElement(By.cssSelector("#Email")).sendKeys(emailAddress);
		driver.findElement(By.cssSelector("#Password")).sendKeys(password);
		driver.findElement(By.cssSelector(".login-button")).click();

		Assert.assertTrue(driver.findElement(By.cssSelector(".ico-account")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector(".ico-logout")).isDisplayed());
	}

	@Test(enabled = true)
	public void TC_03_My_Account() {
		driver.findElement(By.cssSelector(".ico-account")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText(), "My account - Customer info");
		Assert.assertTrue(driver.findElement(By.id("gender-female")).isSelected());
		Assert.assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"), firstName);
		Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"), lastName);
		Assert.assertEquals(driver.findElement(By.id("Email")).getAttribute("value"), emailAddress);
		Assert.assertEquals(driver.findElement(By.id("Company")).getAttribute("value"), companyName);

		select = new Select(driver.findElement(By.name("DateOfBirthDay")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), dayOfBirthDay);

		select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), monthOfBirthDay);

		select = new Select(driver.findElement(By.name("DateOfBirthYear")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), yearOfBirthDay);

		Assert.assertTrue(driver.findElement(By.cssSelector("#Newsletter")).isSelected());

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
