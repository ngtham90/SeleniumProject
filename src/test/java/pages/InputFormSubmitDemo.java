package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class InputFormSubmitDemo {

	WebDriver driver;
	final private static By firstName = By.name("first_name");
	final private static By error_fName = By.xpath(".//*[@data-bv-for='first_name'][@data-bv-validator='stringLength']");
	final private static By lastName = By.name("last_name");
	final private static By error_lName = By.xpath(".//*[@data-bv-for='last_name'][@data-bv-validator='stringLength']");
	final private static By email = By.name("email");
	final private static By error_email = By.xpath(".//*[@data-bv-for='email'][@data-bv-validator='emailAddress']");
	final private static By phone = By.name("phone");
	final private static By error_phone = By.xpath(".//*[@data-bv-validator='phone']");
	final private static By address = By.name("address");
	final private static By error_address = By.xpath(".//*[@data-bv-for='address'][@data-bv-validator='stringLength']");
	final private static By city = By.name("city");
	final private static By error_city = By.xpath(".//*[@data-bv-for='city'][@data-bv-validator='stringLength']");
	final private static By state = By.xpath(".//*[@name='state']");
	final private static By zipCode = By.name("zip");
	final private static By error_zip = By.xpath(".//*[@data-bv-for='zip'][@data-bv-validator='zipCode']");
	final private static By website = By.name("website");
	final private static By hosting = By.xpath(".//*[@value='yes']");
	final private static By desc = By.name("comment");
	final private static By error_desc = By.xpath(".//*[@data-bv-for='comment'][@data-bv-validator='stringLength']");
	final private static By button = By.xpath(".//*[@class='btn btn-default']");
	
	
	public InputFormSubmitDemo(WebDriver driver) {
		this.driver = driver;
	}
	
	public String setInvalidData(By locator, By errorLocator, String invalidData) {
		driver.findElement(locator).sendKeys(invalidData);
		
		WebElement errorElement = driver.findElement(errorLocator);
		
		if(errorElement != null) {
			String errorMess = errorElement.getText();
			return errorMess;
		}
		return null;
	}
	
	public boolean setValidData( By locator, String validData) {
		try {
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(validData);
			return true;
		} catch(Exception e) {
			return false;
		}
		
		
	}
	//Test First Name
	public String testInvalidFirstName( String text ) {
		
		return setInvalidData(firstName, error_fName, text);
	}
	
	public boolean testValidFirstName( String validData) {
		return setValidData(firstName, validData);
		
	}
	
	//Test Last Name
	public String testInvalidLastName(String invalidData) {
		return setInvalidData(lastName, error_lName, invalidData);
	}
	
	public boolean testValidLastName ( String validData) {
		return setValidData(lastName, validData);
	}

	//Test Email
	public String testInvalidEmail( String invalidData) {
		return setInvalidData(email, error_email, invalidData);
	}
	
	public boolean testValidEmail(String validData) {
		return setValidData(email, validData);
	}
	
	//Test Phone
	public String testInvalidPhone( String invalidData) {
		return setInvalidData(phone, error_phone, invalidData);
	}

	public boolean testValidPhone(String validData) {
		return setValidData(phone, validData);
	}

	//Test Address
	public String testInvalidAddress(String invalidData) {
		return setInvalidData(address, error_address, invalidData);
	}
	
	public boolean testValidAddress( String validData) {
		return setValidData(address, validData);
	}

	//Test City
	public String testInvalidCity(String invalidData) {
		return setInvalidData(city, error_city, invalidData);
	}
	
	public boolean testValidCity( String validData) {
		return setValidData(city, validData);
	}
		

	//Set State
	public void testState(int i) {
		Select state1 = new Select(driver.findElement(state));
		state1.selectByIndex(i);
			
		}
	
	//Get Select State
	public String getSelectedState() {
		Select ele = new Select(driver.findElement(state));
		String txt = ele.getFirstSelectedOption().getText();
		return txt;
	}
	
	
	//Test ZipCode
	public  String testInvaliZipCode(String invalidData) {
		return setInvalidData(zipCode, error_zip, invalidData);
		
	}
	public boolean testValidZipCode( String validData) {
		return setValidData(zipCode, validData);
	}
		


	//Set website or domani name
	public void testWebsite(String site) {
		driver.findElement(website).sendKeys(site);
			
		}
	
	

	//Choose hosting
	public void chooseHosting() {
		driver.findElement(hosting).click();
		}
	//Check selected hosting
	public boolean checkSelectedHosting() {
		boolean b = driver.findElement(hosting).isSelected();
		return b;
	}
	

	public String testInvalidDescription(String invalidData) {
		return setInvalidData(desc, error_desc, invalidData);
	}
	
	public boolean testValidDescription(String validData) {
		return setValidData(desc, validData);
	}

	//Click Send button
	public void clickOnSendButton() {
		driver.findElement(button).click();
	}
	
	

}
