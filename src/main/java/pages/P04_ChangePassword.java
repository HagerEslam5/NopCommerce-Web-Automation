package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import bases.BasePage;

public class P04_ChangePassword extends BasePage {
	 WebDriver driver;

	public P04_ChangePassword(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	private final By myAcc = By.cssSelector(".ico-account");
	private final By changePassBtn = By.cssSelector("li[class*='change-pass'] a");
	private final By oldPassBox = By.cssSelector("input[id='OldPassword']");
	private final By newPassBox = By.cssSelector("input[id='NewPassword']");
	private final By confPassBox = By.cssSelector("input[id='ConfirmNewPassword']");
	private final By submitBtn = By.cssSelector("button[class*='change-password']");
	private final By successMessg = By.cssSelector("div[class*='bar-notification success'] p");

	public void goToMyAcc() {
		clickOnElem(myAcc);
	}

	public void goToChangPassPage() {
		clickOnElem(changePassBtn);
	}

	public void changePass(String oldPass, String newPass, String confPass) {
		sendData(oldPassBox, oldPass);
		sendData(newPassBox, newPass);
		sendData(confPassBox, confPass);
		clickOnElem(submitBtn);
	}

	public String getSuccessMessg() {
		waitForVisibiltyOfElem(successMessg);
		return driver.findElement(successMessg).getText();
	}

}
