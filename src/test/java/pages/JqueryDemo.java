package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

public class JqueryDemo {

	WebDriver driver;
	WebDriverWait wait;
	By country = By.xpath("html/body/div[2]/div/div[2]/div[1]/div/div[2]/span/span[1]/span");
	By get_country = By.xpath(".//*[@id='select2-country-container']");
	By search_box = By.xpath("html/body/span/span/span[1]/input");
	By select_box = By.xpath(".//*[@id='select2-country-results']/li");
	By state = By.xpath(".//input[@class='select2-search__field']");
	By get_state = By.xpath(".//*[@class='select2-selection__choice']");
	By search_state = By.xpath(".//*[@class='select2-results']/ul/li");
	By us = By.xpath("html/body/div[2]/div/div[2]/div[3]/div/div[2]/span/span[1]/span/span[2]");
	By us_box = By.xpath("html/body/span/span/span[1]/input");
	By us_result = By.xpath(".//*[@class='select2-results__options']/li");
	By get_us = By.xpath("//label[contains(text(),'Select US Outlying Territories')]/following-sibling::span/span/span/span[1]");
	By file = By.id("files");
	By get_file= By.xpath("//label[contains(text(),'Select a file')]/following-sibling::select");
	
	public JqueryDemo(WebDriver driver) {
		this.driver = driver;
	}
	
	//Select Country
	public void set_Country() {
		
		driver.findElement(country).click();
		
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(search_box));
		driver.findElement(search_box).sendKeys("a");
		
		
		Actions action = new Actions(driver);
		WebElement drops = driver.findElement(select_box);
		action.moveToElement(drops);
		action.build().perform();
		
		driver.findElement(By.xpath(".//*[@id='select2-country-results']/li[2]")).click();
	}
	
	//Get selected Country
	public String get_Selected_Country() {
		return driver.findElement(get_country).getText();
	}
	

	
	//Select State
	public void set_State() throws InterruptedException {
		
		driver.findElement(state).click();
		wait = new WebDriverWait(driver, 5);
		driver.findElement(state).sendKeys("y");
	
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(search_state));
		driver.findElement(search_state);
		Actions act = new Actions(driver);
		WebElement drp = driver.findElement(search_state);
		act.moveToElement(drp);
		act.build().perform();
		driver.findElement(By.xpath(".//*[@class='select2-results']/ul/li[2]")).click();

		
		
		driver.findElement(state).sendKeys("y");
		driver.findElement(By.xpath(".//*[@class='select2-results']/ul/li[3]")).click();
		driver.findElement(state).sendKeys("y");
		driver.findElement(By.xpath(".//*[@class='select2-results']/ul/li[4]")).click();

	}
	
	//Verify selected state
	public void verify_Selected_State() {
	List<WebElement> ls = driver.findElements(get_state);
	Assert.assertTrue(ls.get(0).getText().toLowerCase().contains("×maryland"));
	Assert.assertTrue(ls.get(1).getText().toLowerCase().contains("×new jersey"));
	Assert.assertTrue(ls.get(2).getText().toLowerCase().contains("×new york"));
		
	}
	
	//Select US Outlying Territories 
	public void set_Dropdown_Disable_value() throws InterruptedException {
		
		driver.findElement(us).click();
		driver.findElement(us_box).sendKeys("v");

	
		Actions act = new Actions(driver);
		WebElement drp = driver.findElement(us_result);
		act.moveToElement(drp);
		act.build().perform();
		driver.findElement(By.xpath(".//*[@class='select2-results__options']/li[1]")).click();
	
	}
	
	//Get selected US Outlying Territories
	public String get_Dropdown_Disable_value() {
		return driver.findElement(get_us).getText();
	}
	
	
	//Select file
	public void set_files() {
		driver.findElement(file).click();
		driver.findElement(By.xpath(".//*[@id='files']/optgroup[@label='Other']/option[text()='Unknown Script']")).click();
	}
	
	//Verify selected file
	public void verify_file() {
		Select ddlLanguage = new Select(driver.findElement(By.id("files")));
		String b = ddlLanguage.getFirstSelectedOption().getText();
		Assert.assertTrue(b.toLowerCase().contains("unknown script"));
	
	}
}
