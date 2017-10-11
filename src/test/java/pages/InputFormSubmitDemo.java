package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class InputFormSubmitDemo {

	WebDriver driver;
	By firstName = By.name("first_name");
	By error_fName = By.xpath(".//*[@data-bv-for='first_name'][@data-bv-validator='stringLength']");
	By lastName = By.name("last_name");
	By error_lName = By.xpath(".//*[@data-bv-for='last_name'][@data-bv-validator='stringLength']");
	By email = By.name("email");
	By error_email = By.xpath(".//*[@data-bv-for='email'][@data-bv-validator='notEmpty']");
	By phone = By.name("phone");
	By error_phone = By.xpath(".//*[@data-bv-validator='phone']");
	By address = By.name("address");
	By error_address = By.xpath(".//*[@data-bv-for='address'][@data-bv-validator='stringLength']");
	By city = By.name("city");
	By error_city = By.xpath(".//*[@data-bv-for='city'][@data-bv-validator='stringLength']");
	By state = By.xpath(".//*[@name='state']");
	By zipCode = By.name("zip");
	By error_zip = By.xpath(".//*[@data-bv-for='zip'][@data-bv-validator='notEmpty']");
	By website = By.name("website");
	By hosting = By.xpath(".//*[@value='yes']");
	By desc = By.name("comment");
	By error_desc = By.xpath(".//*[@data-bv-for='comment'][@data-bv-validator='stringLength']");
	By button = By.xpath(".//*[@class='btn btn-default']");
	
	
	public InputFormSubmitDemo(WebDriver driver) {
		this.driver = driver;
	}
	
	//Set First Name
	public void set_First_Name (String invalid_fname, String valid_fname) {
		driver.findElement(firstName).sendKeys(invalid_fname);
		String error_first_name = driver.findElement(error_fName).getText();
		if(error_first_name.equalsIgnoreCase("Please enter more than 2 characters")) {
			System.out.println(invalid_fname + " is invalid first name.");
		}
		driver.findElement(firstName).clear();
		driver.findElement(firstName).sendKeys(valid_fname);
		
	}

	
	//Set Last Name
	public void set_Last_Name(String invalid_lname, String valid_lname) {
		driver.findElement(lastName).sendKeys(invalid_lname);
		String error_last_name = driver.findElement(error_lName).getText();
		if(error_last_name.equalsIgnoreCase("Please enter more than 2 characters")) {
			System.out.println(invalid_lname + " is invalid last name.");
		}
		driver.findElement(lastName).clear();
		driver.findElement(lastName).sendKeys(valid_lname);
	}
	
	//Set email
	public void set_Email(String invalid_email, String valid_email) {
		driver.findElement(email).sendKeys(invalid_email);
		String error_e = driver.findElement(error_email).getText();
		if(error_e.equalsIgnoreCase("Please supply a valid email address")) {
			System.out.println(invalid_email + " is invalid email.");
		}
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(valid_email);
		
	}
	
	//Set Phone
	public void set_Phone(String invalid_num, String valid_num) {
		driver.findElement(phone).sendKeys(invalid_num);
		String error_p = driver.findElement(error_phone).getText();
		if(error_p.equalsIgnoreCase("Please supply a vaild phone number with area code")) {
			System.out.println(invalid_num + " is invalid phone");
		}
		driver.findElement(phone).clear();
		driver.findElement(phone).sendKeys(valid_num);
		
	}
	
	//Set Address
	public void set_Address(String invalid_addr, String valid_addr) {
		driver.findElement(address).sendKeys(invalid_addr);
		String error_addr = driver.findElement(error_address).getText();
		if(error_addr.equalsIgnoreCase("lease enter more than 8 characters")) {
			System.out.println(invalid_addr + " is invalid address.");
		}
		driver.findElement(address).clear();
		driver.findElement(address).sendKeys(valid_addr);
	}
	
	//Set City
	public void set_City(String invalid_town, String valid_town) {
		driver.findElement(city).sendKeys(invalid_town);
		String error_town = driver.findElement(error_city).getText();
		if(error_town.equalsIgnoreCase("Please enter more than 4 characters")) {
			System.out.println(invalid_town + " is invalid town.");
		}
		driver.findElement(city).clear();
		driver.findElement(city).sendKeys(valid_town);
	}
		
	//Set State
	public void set_State() {
		Select state1 = new Select(driver.findElement(state));
		state1.selectByIndex(2);
		
	}

	//Set Zip Code
	public void set_Zip(String invali_code, String valid_code) {
		driver.findElement(zipCode).sendKeys(invali_code);
		String error_code = driver.findElement(error_zip).getText();
		if(error_code.equalsIgnoreCase("Please supply a vaild zip code")) {
			System.out.println(invali_code + " is  invalid zipcode.");
		}
		driver.findElement(zipCode).clear();
		driver.findElement(zipCode).sendKeys(valid_code);
	}
		
	//Set website or domani name
	public void set_Website(String site) {
		driver.findElement(website).sendKeys(site);
		
	}

	//Choose hosting
	public void choose_hosting() {
		driver.findElement(hosting).click();
	}
	
	//Set Project Description
	public void set_Desp(String invalid_cmt, String valid_cmt) {
		driver.findElement(desc).sendKeys(invalid_cmt);
		String error_cmt = driver.findElement(error_desc).getText();
		if(error_cmt.equalsIgnoreCase("Please enter at least 10 characters and no more than 200")) {
			System.out.println(invalid_cmt + " is invalid description");
		}
		driver.findElement(desc).clear();
		driver.findElement(desc).sendKeys(valid_cmt);
	}
	
	//Click Send button
	public void click_Button() {
		driver.findElement(button).click();
	}
	
	

}
