package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


public class RadioButtonsDemo extends MyPage {


	final private static By sex = By.xpath(".//*[@value='Female'][@name='gender']");
	final private static By age = By.xpath(".//*[@value='5 - 15']");
	final private static By button = By.xpath(".//*[@class='btn btn-default'][text()='Get values']");
	final private static By result = By.className("groupradiobutton");
	
	
	
	//Select Sex
	public void setSex() {
		WebElement bSex = driver.findElement(sex);
		boolean bValue = bSex.isSelected();
		if(bValue == true) {
			System.out.println(" Sex is selected!");
		}else {
			bSex.click();
		}
		
	}
	
	
	//Select Age Group
	public void setAgeGroup() {
		WebElement bAge = driver.findElement(age);
		boolean bValue = bAge.isSelected();
		if(bValue == true) {
			System.out.println("Age Group is selected!");
		} else {
			bAge.click();
		}
	}
	
	//Click "Get Values" button
	public void clickOnGetValuesButton() {
		driver.findElement(button).click();
	}
	
	//Get result
	public String getResult() {
		return driver.findElement(result).getText().replaceAll("\\r\\n|\\r|\\n", " ");
	}
	
	public void tryRadioButtons() {
		
		this.setSex();
		this.setAgeGroup();
		this.clickOnGetValuesButton();
		this.getResult();
	
	}
}
