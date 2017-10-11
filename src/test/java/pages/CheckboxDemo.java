package pages;

import org.openqa.selenium.WebDriver;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckboxDemo {

	WebDriver driver;
	By checkAll_Button = By.id("check1");
	By option = By.className("cb1-element");

	public CheckboxDemo(WebDriver driver) {
		this.driver = driver;
	}
	
	//Click 'Check All' button
	public void click_Check_All_Button() {
		driver.findElement(checkAll_Button).click();
	}
	
	//Get name of button after clicking
	public String get_Button_Name() {
		return driver.findElement(checkAll_Button).getAttribute("value");
	}
	
	//Uncheck Option 2
	public void uncheck_Option2() {
	
		List<WebElement> list = driver.findElements(option);
		
		list.get(1).click();
		
	}
	

	
	
	
	
}
