package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AjaxFormDemo extends MyPage{

	
	//WebDriverWait wait;
	final private static By name = By.id("title");
	final private static By comment = By.id("description");
	final private static By button = By.id("btn-submit");
	By result = By.xpath(".//*[@id='submit-control']");
	
//	public AjaxFormDemo(WebDriver driver) {
//		this.driver = driver;
//	}
	
	//Set Name
	public void setName(String var1) {
		driver.findElement(name).sendKeys(var1);
	}
	
	//Set Comment
	public void setComment(String var2) {
		driver.findElement(comment).sendKeys(var2);
	}
	
	//Click Submit button
	public void clickOnSubmitButton() {
		driver.findElement(button).click();
	}
	
	//Test Ajax
	public void tryAjax() {
		this.setName("Tham");
		this.setComment("123");
		this.clickOnSubmitButton();		
	}
	
	//Get Ajax message
	public String getAjaxMessage() {
		
		WebElement ajax_result = driver.findElement(result);
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(ajax_result));	
		String getResult = ajax_result.getText();
		return getResult;
	}
	
	//Get message after submission
	public String getTextAfterSubmission() {
		
		WebElement divEle = driver.findElement(By.id("submit-control"));
		//Find child Node belong to div element
		int childCount = divEle.findElements(By.tagName("input")).size();
		if(childCount < 1){		
			
			return divEle.getText();
			
		}
		
		return null;
	}
	
}
