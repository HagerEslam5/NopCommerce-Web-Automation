package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import bases.BasePage;

public class P05_cart extends BasePage {
	 WebDriver driver;

	public P05_cart(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private final By prodsName = By.cssSelector(".product-name");

	public boolean verifyProdAdded(String prodName) {
		List<WebElement> allProds = driver.findElements(prodsName);
		boolean flag = allProds.stream().anyMatch(s -> s.getText().contains(prodName));
		return flag;
	}

}
