package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import bases.BasePage;

public class P02_Login extends BasePage {
	 WebDriver driver;

	public P02_Login(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private final By emailBox = By.id("Email");
	private final By passBox = By.id("Password");
	private final By loginBtn = By.cssSelector("div[class*='returning-wrapper'] div[class='buttons'] button");

	public void login(String email, String password) {
		sendData(emailBox, email);
		sendData(passBox, password);
		clickOnElem(loginBtn);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

}
