package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;



public class SimpleFormDemo {

	WebDriver driver;
	By value_a = By.id("sum1");
	By value_b = By.id("sum2");
	By getTotal = By.xpath(".//*[@id='gettotal']/button");
	By total = By.id("displayvalue");
	

	public SimpleFormDemo(WebDriver driver) {
		this.driver = driver;
	}

		
	
	//Enter value a
	public void setValue_a(String val1) {
		driver.findElement(value_a).sendKeys(val1);
	}
	
	//Enter value b
	public void setValue_b(String val2) {
		driver.findElement(value_b).sendKeys(val2);
	}
	
	//Click "Get Total" button
	public void clickGetTotalButton() {
		driver.findElement(getTotal).click();
	}
	
	//Get the result
	public String getResult() {
		return driver.findElement(total).getText();
	}
		
	
	public void MatchExpression(String a, String b) {
		
		this.setValue_a(a);
		
		this.setValue_b(b);
		
		this.clickGetTotalButton();
		
		this.getResult();
		
		
	}
	
}