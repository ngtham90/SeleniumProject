package pages;



import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckboxDemo extends MyPage {

	
	final private static By checkAll_Button = By.id("check1");
	final private static By option = By.className("cb1-element");


	
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
