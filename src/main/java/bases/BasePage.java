package bases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	public BasePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void excuteScript(By locator) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", driver.findElement(locator));
	}
	
	public void waitForVisibiltyOfElem(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	public void sendData(By byLocator, String text) {
		driver.findElement(byLocator).sendKeys(text);
	}
	
	public void clickOnElem(By byLocator) {
		driver.findElement(byLocator).click();
	}
	public void scrollIntoView(By element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(element));
	}
	
	public void selectFromDropDown(By byLocator, String value) {
		Select dropDown = new Select(driver.findElement(byLocator));
		dropDown.selectByValue(value);
	}
	
	
	
}
