package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AjaxFormDemo {

	WebDriver driver;
	WebDriverWait wait;
	By name = By.id("title");
	By comment = By.id("description");
	By button = By.id("btn-submit");
	By result = By.xpath(".//*[@id='submit-control']");
	
	public AjaxFormDemo(WebDriver driver) {
		this.driver = driver;
	}
	
	//Set Name
	public void set_Name(String var1) {
		driver.findElement(name).sendKeys(var1);
	}
	
	//Set Comment
	public void set_Comment(String var2) {
		driver.findElement(comment).sendKeys(var2);
	}
	
	//Click Submit button
	public void click_Button() {
		driver.findElement(button).click();
	}
	
	//Verify Ajax message
	public void try_Ajax() {
		this.set_Name("Tham");
		this.set_Comment("123");
		this.click_Button();
		WebElement ajax_result = driver.findElement(result);
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(ajax_result));
		
		String getResult = ajax_result.getText();
	
		Assert.assertTrue(getResult.toLowerCase().contains("ajax request is processing!"));
		
	}
	
	//Verify message after submission
	public void get_text() {
		
		WebElement divEle = driver.findElement(By.id("submit-control"));
		//Find child Node belong to div element
		int childCount = divEle.findElements(By.tagName("input")).size();
		if(childCount < 1){
			
			Assert.assertTrue(divEle.getText().toLowerCase().contains("form submited successfully!"));
			
		}
	}
	
}

