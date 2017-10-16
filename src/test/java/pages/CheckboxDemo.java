package pages;

import org.openqa.selenium.WebDriver;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckboxDemo {

	WebDriver driver;
	final private static By checkAll_Button = By.id("check1");
	final private static By option = By.className("cb1-element");

	public CheckboxDemo(WebDriver driver) {
		this.driver = driver;
	}
	
	//Click 'Check All' button
	public void clickCheckAllButton() {
		driver.findElement(checkAll_Button).click();
	}
	
	//Get name of button after clicking
	public String getButtonName() {
		return driver.findElement(checkAll_Button).getAttribute("value");
	}
	
	//Uncheck Option 2
	public void uncheckOption2() {
	
		List<WebElement> list = driver.findElements(option);
		
		list.get(1).click();
		
	}
	

	
	
	
	
}
