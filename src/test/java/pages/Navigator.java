package pages;

import org.openqa.selenium.WebDriver;

public class Navigator {

	WebDriver driver;
	
	public  Navigator(WebDriver driver) {
		this.driver = driver;
	}
	
	public void gotoPage(String a) {
		driver.get(a);
	}
	
	
	
}
