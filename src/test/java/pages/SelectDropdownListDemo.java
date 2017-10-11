package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownListDemo {
	
	WebDriver driver;
	By state = By.id("multi-select");
	By button = By.xpath(".//*[@id='printAll']");
	By result = By.xpath(".//*[@class='getall-selected']");

	
	public SelectDropdownListDemo(WebDriver driver) {
		this.driver = driver;
	}
	

	//Select values of dropdown list
	public void select_values() {
		
		Select drop = new Select(driver.findElement(state));
	
		drop.selectByVisibleText("Florida");
		
	
	}
			
	
	//Click button 'Get All Selected'
	public void click_button() {
		driver.findElement(button).click();
	}
	
	//Get result
	public String get_Result() {
		return driver.findElement(result).getText();
		
	}
	
	public void check_Dropdown() {
	
		this.select_values();
		
		this.click_button();

		
	}
	
	

}
