package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import bases.BasePage;

public class P01_Registration extends BasePage {

	WebDriver driver;

	public P01_Registration(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	By gender = By.id("gender-female");
	By firstNameBox = By.id("FirstName");
	By lastNameBox = By.id("LastName");
	By dayDropDown = By.name("DateOfBirthDay");
	By monthDropDown = By.name("DateOfBirthMonth");
	By yearDropDown = By.name("DateOfBirthYear");
	By emailBox = By.id("Email");
	By companyBox = By.id("Company");
	By passBox = By.id("Password");
	By ConfPassBox = By.id("ConfirmPassword");
	By registerBtn = By.id("register-button");
	By confMessg = By.cssSelector(".page-body .result");
	By logOutBtn= By.cssSelector(".ico-logout");

	public void register(String firstName, String lastName, String day, String month, String year, String email,
			String company, String password) {

		clickOnElem(gender);
		sendData(firstNameBox, firstName);
		sendData(lastNameBox, lastName);
		selectFromDropDown(dayDropDown, day);
		selectFromDropDown(monthDropDown, month);
		selectFromDropDown(yearDropDown, year);
		sendData(emailBox, email);
		scrollIntoView(companyBox);
		sendData(passBox, password);
		sendData(ConfPassBox, password);
		clickOnElem(registerBtn);
	}

	public String getConfMess() {
		waitForVisibiltyOfElem(confMessg);
		return driver.findElement(confMessg).getText();
	}
	
	public void logout() {
		clickOnElem(logOutBtn);
	}

}
