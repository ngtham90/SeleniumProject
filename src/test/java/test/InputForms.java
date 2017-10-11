package test;



import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AjaxFormDemo;
import pages.CheckboxDemo;
import pages.InputFormSubmitDemo;
import pages.JqueryDemo;
import pages.RadioButtonsDemo;
import pages.SelectDropdownListDemo;
import pages.SimpleFormDemo;

public class InputForms {
	
	static WebDriver driver;
	SimpleFormDemo obj_simple_form;
	CheckboxDemo obj_checkbox;
	RadioButtonsDemo obj_radio_button;
	SelectDropdownListDemo obj_dropdown;
	InputFormSubmitDemo obj_input_form;
	JqueryDemo obj_jquery;
	AjaxFormDemo obj_ajax;
	static String baseUrl ="http://www.seleniumeasy.com/test/";
	
	
	@BeforeClass
	public static void setup() {
		
		System.setProperty("webdriver.chrome.driver", ".//driver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
	}

	@Test 
	public void test_Simple_Form() {
		
		//Navigate to http://www.seleniumeasy.com/test/basic-first-form-demo.html
		driver.get("http://www.seleniumeasy.com/test/basic-first-form-demo.html");	
		
		//Create Simple Form Demo page object
		obj_simple_form = new SimpleFormDemo(driver);
	
		obj_simple_form.MatchExpression("2", "3");
		
		//Verify the result
		Assert.assertTrue(obj_simple_form.getResult().contains("5"));
		
		System.out.println("SimpleFomrDemo page is passed!.........");
		
		
	}
	
	@Test
	public void test_Checkbox() {
		
		//Navigate to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
		driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
		
		//Create CheckboxDemo object
		obj_checkbox = new CheckboxDemo(driver);
	
		//Click 'Check All' button
		obj_checkbox.click_Check_All_Button();
		
		//Verify that 'Check All' button was changed to 'Uncheck All'
		Assert.assertTrue(obj_checkbox.get_Button_Name().toLowerCase().contains("uncheck all"));
		
		//Uncheck Option 2
		obj_checkbox.uncheck_Option2();
		
		//Verify that after unchecking Option 2, button was changed to 'Check All'
		Assert.assertTrue(obj_checkbox.get_Button_Name().toLowerCase().contains("check all"));
		
		System.out.println("CheckboxDemo page is passed!..........");
	
	}
	
	@Test
	public void test_Radio_Button() {
		
		//Navigate to http://www.seleniumeasy.com/test/basic-radiobutton-demo.html
		driver.get("http://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
		
		//Create RadioButtonsDemo object
		obj_radio_button = new RadioButtonsDemo(driver);
		
		obj_radio_button.try_Radio_Buttons();
		
		Assert.assertTrue(obj_radio_button.get_Result().toLowerCase().contains("sex : female age group: 5 - 15"));
		
		System.out.println("RadioButtonsDemo is passed!........");
		
	}
	
	
	@Test
	public void test_Dropdown()  {
		//Navigate to http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html
		driver.get("http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Create SelectDropdownList object
		obj_dropdown = new SelectDropdownListDemo(driver);
		
		obj_dropdown.select_values();
		
		obj_dropdown.click_button();
		obj_dropdown.get_Result();

		Assert.assertTrue(obj_dropdown.get_Result().toLowerCase().contains("options selected are : florida"));
		
		System.out.println("SelectDropdownListDemo is passed!..........");

	}
	
	@Test
	public void test_Input_Form() {
		
		//Navigate to http://www.seleniumeasy.com/test/input-form-demo.html
		driver.get("http://www.seleniumeasy.com/test/input-form-demo.html");
		
		//Create InputFromSubmitDemo object
		obj_input_form = new InputFormSubmitDemo(driver);
		
		obj_input_form.set_First_Name("T","Tham");
		
		
		obj_input_form.set_Last_Name("N", "Nguyen");
		
		
		obj_input_form.set_Email("1234", "12345@gmail.com");
		
		
		obj_input_form.set_Phone("01", "0123456789");
		
		
		obj_input_form.set_Address("DA", "Dong Anh");
		
		
		obj_input_form.set_City("HN", "Ha Noi");
		
		
		obj_input_form.set_State();
		
		
		obj_input_form.set_Zip("8", "01234");
		
		
		obj_input_form.set_Website("http://google.com");
		
		
		obj_input_form.choose_hosting();
		
		obj_input_form.set_Desp("a", "Hello World!. This is my first project");
		
		
		obj_input_form.click_Button();
		
		System.out.println("InputFormSubmitDemo is passed!.......");
		

	}
	
	@Test
	public void test_Ajax() throws InterruptedException {
		//Navigate to http://www.seleniumeasy.com/test/ajax-form-submit-demo.html
		driver.get("http://www.seleniumeasy.com/test/ajax-form-submit-demo.html");
		
		obj_ajax = new AjaxFormDemo(driver);
		
		obj_ajax.try_Ajax();
			
		obj_ajax.get_text();
	
		System.out.println("AjaxFormDemo page is passed!.....");
		
	
	}
	
	
	@Test
	public void test_Jquery() throws InterruptedException {
		driver.get("http://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html");
		obj_jquery = new JqueryDemo(driver);
		
		//Select Country
		obj_jquery.set_Country();

		//Verify selected country
		Assert.assertTrue(obj_jquery.get_Selected_Country().toLowerCase().contains("bangladesh"));

		//Select state
		obj_jquery.set_State();
				
		//Verify selected state
		obj_jquery.verify_Selected_State();
		
		//Select US Outlying Territories
		obj_jquery.set_Dropdown_Disable_value();
		
		//Verify selected US Outlying Territories
		Assert.assertTrue(obj_jquery.get_Dropdown_Disable_value().toLowerCase().contains("virgin islands"));
		
		//Select file
		obj_jquery.set_files();
	
		
		//Verify selected file
		obj_jquery.verify_file();
		
		System.out.println("JqueryDemo page is passed!.......");
	}
	
	
	@AfterClass
	public static void quit() {
		driver.quit();
	}

}
