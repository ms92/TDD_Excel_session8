package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddCustomerPage extends BasePage{
	
	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]") WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]") WebElement COMPANY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]") WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']") WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='address']") WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='city']") WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='state']") WebElement STATE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']") WebElement ZIP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id ='country']") WebElement COUNTRY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@id='submit']") WebElement SAVE_BUTTON_ADD_CUSTOMER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"summary\"]") WebElement SUMMARY_PROFILE_PAGE_ELEMENT;
	
	String enteredName;
	
	public void enterFullName(String fullName) {
		enteredName = fullName + randomGenerator(99);
		FULL_NAME_ELEMENT.sendKeys(enteredName);
	}
	
	public void enterCompanyName(String company) {
		selectDropdown(COMPANY_ELEMENT, company);
	}
	
	public void enterEmail(String email) {
		EMAIL_ELEMENT.sendKeys(randomGenerator(100) + email);
	}

	public void enterPhone(String phone) {
		PHONE_ELEMENT.sendKeys(phone + randomGenerator(989));
	}
	
	public void enterAddress (String address) {
		ADDRESS_ELEMENT.sendKeys(address + randomGenerator(99));	
	}
	
	public void enterCity(String city) {
		CITY_ELEMENT.sendKeys(city + randomGenerator(99));
	}
	
	public void enterState(String state) {
		STATE_ELEMENT.sendKeys(state + randomGenerator(99));
	}
	
	public void enterZip(String zip) {
		ZIP_ELEMENT.sendKeys(zip + randomGenerator(99));
	}
	
	
	  public void enterCountry(String country) { 
		selectDropdown(COUNTRY_ELEMENT,country);
	}
	 
	public void clickSaveButtonOnAddCustomerPage() {
		SAVE_BUTTON_ADD_CUSTOMER_ELEMENT.click();
		waitForElement(driver, 5, SUMMARY_PROFILE_PAGE_ELEMENT);
	}
	
	//tbody/tr[i]/td[3]
	//tbody/tr[2]/td[3]
	//tbody/tr[3]/td[3]
	//tbody/tr[i]/td[3]/following-sibling::td[4]/a[2]
	//tbody/tr[i]/td[3]/following-sibling::td[4]/a[2]
	//*[@id="uid4631"]/i
	//tbody/tr[1]/following.sibling::td[4]/a[2]
	
		
	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]";
	String after_xpath_delete_button = "]/td[3]/following-sibling::td[4]/a[2]";
	
	
	public void verifyEnteredNameAndDelete() {
		for(int i = 1; i <= 10; i++) {
		String	name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
		/*
		 * System.out.println(name); Assert.assertEquals(name, enteredName,
		 * "entered name doesnot match"); break;
		 */
		if (name.contains(enteredName)) {
			System.out.println("entered name exists!!!");
			//driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[3]/following-sibling::td[4]/a[2]")).click();
			//driver.findElement(By.xpath(before_xpath + i + after_xpath + "/following-sibling::td[4]/a[2]")).click();
			driver.findElement(By.xpath(before_xpath + i + after_xpath_delete_button)).click();
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/button[2]")).click();
		}
		break;
		}
	}
	
}
