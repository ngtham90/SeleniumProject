package com.asksqa.tutorials;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;

import pages.BasicFirstFormDemo;



public class CheckYourMessage {
	
	public final static String baseUrl = "http://www.seleniumeasy.com/test/basic-first-form-demo.html";
	WebDriver driver = null; 
	BasicFirstFormDemo basicForm;
	
	@Test
	public void EnterMessage() {
		
		System.setProperty("webdriver.gecko.driver", ".\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
		
		basicForm = new BasicFirstFormDemo(driver);
		
		//Send Message
		basicForm.sendMessage("Nguyen Thi Tham");
		
		
		//Click Button
		basicForm.clickBtn();
		
		//VerifyMessage
		Assert.assertTrue(basicForm.getMessage().contains("Nguyen Thi Tham"));
		
		
		driver.quit();

	}
	

}
