package pages;


import org.openqa.selenium.By;



public class SimpleFormDemo extends MyPage {

	final private static By value_a = By.id("sum1");
	final private static By value_b = By.id("sum2");
	final private static By getTotal = By.xpath(".//*[@id='gettotal']/button");
	final private static By total = By.id("displayvalue");
	

		
	
	//Enter value a
	public void setValueA(String val1) {
		driver.findElement(value_a).sendKeys(val1);
	}
	
	//Enter value b
	public void setValueB(String val2) {
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
		
		this.setValueA(a);
		
		this.setValueB(b);
		
		this.clickGetTotalButton();
		
		this.getResult();
		
		
	}
	
}
