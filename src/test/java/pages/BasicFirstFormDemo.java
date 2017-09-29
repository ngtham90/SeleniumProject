package pages;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;



public class BasicFirstFormDemo {

	WebDriver driver;
	By enterMessage = By.id("user-message");
	By displayMessage = By.id("display");
	By showMsgBtn = By.xpath(".//*[@id='get-input']/button");
	
	
	public BasicFirstFormDemo(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Enter message
	public void sendMessage(String msg) {
		driver.findElement(enterMessage).sendKeys(msg);
	}
	
	
	//Click button Show Message
	public void clickBtn() {
		driver.findElement(showMsgBtn).click();
	}
	
	//Get message
	public String getMessage() {
		return driver.findElement(displayMessage).getText();
	}
}