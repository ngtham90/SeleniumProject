package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class RadioButtonsDemo {

	WebDriver driver;
	By sex = By.xpath(".//*[@value='Female'][@name='gender']");
	By age = By.xpath(".//*[@value='5 - 15']");
	By button = By.xpath(".//*[@class='btn btn-default'][text()='Get values']");
	By result = By.className("groupradiobutton");
	
	public RadioButtonsDemo(WebDriver driver) {
		this.driver = driver;
	}
	
	//Select Sex
	public void setSex() {
		driver.findElement(sex).click();
	}
	
	//Select Age Group
	public void set_Age_Group() {
		driver.findElement(age).click();
	}
	
	//Click "Get Values" button
	public void click_Button() {
		driver.findElement(button).click();
	}
	
	//Get result
	public String get_Result() {
		return driver.findElement(result).getText().replaceAll("\\r\\n|\\r|\\n", " ");
	}
	
	public void try_Radio_Buttons() {
		
		this.setSex();
		this.set_Age_Group();
		this.click_Button();
		this.get_Result();
	
	}
}
