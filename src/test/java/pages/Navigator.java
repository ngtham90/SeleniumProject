package pages;



public class Navigator extends MyPage {


	

	
	public void goToScreen(String a) {
		switch(a) {
		case "AjaxFormDemo":
			driver.get("http://www.seleniumeasy.com/test/ajax-form-submit-demo.html");
			break;
		case "CheckboxDemo":
			driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
			break;
		case "InputFormSubmitDemo" :
			driver.get("http://www.seleniumeasy.com/test/input-form-demo.html");
			break;
		case "JqueryDemo" :
			driver.get("http://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html");
			break;
		case "RadioButtonsDemo":
			driver.get("http://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
			break;
		case "SelectDropdownListDemo":
			driver.get("http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
			break;
		case "SimpleFormDemo" :
			driver.get("http://www.seleniumeasy.com/test/basic-first-form-demo.html");
			break;
		default:
			System.out.println("Back to Homepage!");
			driver.get("http://www.seleniumeasy.com/");
			break;
		}
	}
	
	
}
