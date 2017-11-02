package test;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AjaxFormDemo;
import pages.CheckboxDemo;
import pages.InputFormSubmitDemo;
import pages.JqueryDemo;
import pages.MyPage;
import pages.Navigator;
import pages.RadioButtonsDemo;
import pages.SelectDropdownListDemo;
import pages.SimpleFormDemo;


public class InputForms extends MyPage{
	
	//static WebDriver driver;
	SimpleFormDemo simpleFormDemo;
	CheckboxDemo checkboxDemo;
	RadioButtonsDemo radioButtonsDemo;
	SelectDropdownListDemo selectDropdownListDemo;
	InputFormSubmitDemo inputFormSubmitDemo;
	JqueryDemo jqueryDemo;
	AjaxFormDemo ajaxFormDemo;
	Navigator navigator = new Navigator();
	
	static String baseUrl ="http://www.seleniumeasy.com/test/";
	
	
	@BeforeClass
	public static void setup() {
		
		System.setProperty("webdriver.chrome.driver", ".//driver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		
	}

	@Test 
	public void testSimpleForm() {
		
		//Navigate to http://www.seleniumeasy.com/test/basic-first-form-demo.html
		navigator.goToScreen("SimpleFormDemo");
		
		//Create Simple Form Demo page object
		simpleFormDemo = new SimpleFormDemo();
	
		simpleFormDemo.MatchExpression("2","3");
		
		//Verify the result
		Assert.assertTrue(simpleFormDemo.getResult().contains("5"));
		
		System.out.println("SimpleFomrDemo page is passed!.........");
		
		
	}
	
	@Test
	public void testCheckbox() {
		
		//Navigate to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
		navigator.goToScreen("CheckboxDemo");
		
		//Create CheckboxDemo object
		checkboxDemo = new CheckboxDemo();
	
		//Click 'Check All' button
		checkboxDemo.clickCheckAllButton();
		
		//Verify that 'Check All' button was changed to 'Uncheck All'
		Assert.assertTrue(checkboxDemo.getButtonName().toLowerCase().contains("uncheck all"));
		
		//Uncheck Option 2
		checkboxDemo.uncheckOption2();
		
		//Verify that after unchecking Option 2, button was changed to 'Check All'
		Assert.assertTrue(checkboxDemo.getButtonName().toLowerCase().contains("check all"));
		
		System.out.println("CheckboxDemo page is passed!..........");
	
	}
	
	@Test
	public void testRadioButton() {
		
		//Navigate to http://www.seleniumeasy.com/test/basic-radiobutton-demo.html
		navigator.goToScreen("RadioButtonsDemo");
		
		//Create RadioButtonsDemo object
		radioButtonsDemo = new RadioButtonsDemo();
		
		radioButtonsDemo.tryRadioButtons();
		
		Assert.assertTrue(radioButtonsDemo.getResult().toLowerCase().contains("sex : female age group: 5 - 15"));
		
		System.out.println("RadioButtonsDemo is passed!........");
		
	}
	
	
	@Test
	public void testDropdown()  {
		//Navigate to http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html
		navigator.goToScreen("SelectDropdownListDemo");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Create SelectDropdownList object
		selectDropdownListDemo = new SelectDropdownListDemo();
		
		selectDropdownListDemo.select_values();
		
		selectDropdownListDemo.click_button();
		selectDropdownListDemo.get_Result();

		Assert.assertTrue(selectDropdownListDemo.get_Result().toLowerCase().contains("options selected are : florida"));
		
		System.out.println("SelectDropdownListDemo is passed!..........");

	}
	
	@Test
	public void testInputForm() {
		
		//Navigate to http://www.seleniumeasy.com/test/input-form-demo.html
		navigator.goToScreen("InputFormSubmitDemo");
		
		//Create InputFromSubmitDemo object
		inputFormSubmitDemo = new InputFormSubmitDemo();
		
		
		Assert.assertEquals( "Please enter more than 2 characters",  inputFormSubmitDemo.testInvalidFirstName("A"));
		Assert.assertTrue( inputFormSubmitDemo.testValidFirstName("Tham"));
		
		Assert.assertEquals("Please enter more than 2 characters", inputFormSubmitDemo.testInvalidLastName("N"));
		Assert.assertTrue( inputFormSubmitDemo.testValidLastName("Nguyen"));
		
		Assert.assertEquals("Please supply a valid email address", inputFormSubmitDemo.testInvalidEmail("1"));
		Assert.assertTrue(inputFormSubmitDemo.testValidEmail("tham.0909@gmail.com"));
		
		Assert.assertEquals("Please supply a vaild phone number with area code", inputFormSubmitDemo.testInvalidPhone("01"));
		Assert.assertTrue(inputFormSubmitDemo.testValidPhone("0123456789"));
		
		Assert.assertEquals("Please enter more than 8 characters", inputFormSubmitDemo.testInvalidAddress("DA"));
		Assert.assertTrue(inputFormSubmitDemo.testValidAddress("Dong Anh"));
		
		Assert.assertEquals("Please enter more than 4 characters", inputFormSubmitDemo.testInvalidCity("HN"));
		Assert.assertTrue(inputFormSubmitDemo.testValidCity("Ha Noi") );
		
		inputFormSubmitDemo.testState(2);
		Assert.assertTrue(inputFormSubmitDemo.getSelectedState().toLowerCase().contains("alaska"));
		
		inputFormSubmitDemo.testWebsite("http://google.com");
		
		inputFormSubmitDemo.chooseHosting();
		Assert.assertTrue(inputFormSubmitDemo.checkSelectedHosting());
		
		Assert.assertEquals("Please supply a vaild zip code", inputFormSubmitDemo.testInvaliZipCode("09"));
		Assert.assertTrue(inputFormSubmitDemo.testValidZipCode("01234"));
		
		Assert.assertEquals("Please enter at least 10 characters and no more than 200", inputFormSubmitDemo.testInvalidDescription("ABC"));
		Assert.assertTrue( inputFormSubmitDemo.testValidDescription("This is a beautiful day"));
		

		
		System.out.println("InputFormSubmitDemo is passed!.......");
		

	}
	
	@Test
	public void testAjax() throws InterruptedException {
		//Navigate to http://www.seleniumeasy.com/test/ajax-form-submit-demo.html
		navigator.goToScreen("AjaxFormDemo");
				
		ajaxFormDemo = new AjaxFormDemo();
				
		//Test Ajax
		ajaxFormDemo.tryAjax();
							
		//Verify Ajax messsage
		Assert.assertNotNull("ajax result is null", ajaxFormDemo.getAjaxMessage());
		Assert.assertTrue(ajaxFormDemo.getAjaxMessage().toLowerCase().contains("ajax request is processing!"));
				
		//Get text message after submission	
		ajaxFormDemo.getTextAfterSubmission();	
				
		//Verify text message after submission
		Assert.assertNotNull("result message is null", ajaxFormDemo.getAjaxMessage());
		Assert.assertTrue(ajaxFormDemo.getTextAfterSubmission().toLowerCase().contains("form submited successfully!"));
				
				
		System.out.println("AjaxFormDemo page is passed!.....");
				
	
	}
	
	
	@Test
	public void testJquery() throws InterruptedException {
		navigator.goToScreen("JqueryDemo");
		jqueryDemo = new JqueryDemo();
		
		//Select Country
		jqueryDemo.setCountry();

		//Verify selected country
		Assert.assertTrue(jqueryDemo.getSelectedCountry().toLowerCase().contains("bangladesh"));

		//Select state
		
		jqueryDemo.waitForShowSearchResult();
		
		jqueryDemo.selectItem("Arizona");
		jqueryDemo.selectItem("Alaska");
		
	
		//Verify selected state
		Assert.assertEquals("Arizona", jqueryDemo.getSelectedState("Arizona"));
		Assert.assertEquals("Alaska", jqueryDemo.getSelectedState("Alaska"));
	
		

		
		
		//Select US Outlying Territories
		jqueryDemo.setDropdownDisableValue();
		
		//Verify selected US Outlying Territories
		Assert.assertTrue(jqueryDemo.getDropdownDisableValue().toLowerCase().contains("virgin islands"));
		
		//Select file
		jqueryDemo.setFile();
	
		//Verify selected file
		Assert.assertTrue(jqueryDemo.getSelectedFile().toLowerCase().contains("unknown script"));
		
		System.out.println("JqueryDemo page is passed!.......");
	}

	
	
	
	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}

}
