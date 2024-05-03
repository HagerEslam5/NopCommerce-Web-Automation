package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bases.BasePage;

public class P03_Search extends BasePage {
	WebDriver driver;

	public P03_Search(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private final By searchBox = By.id("small-searchterms");
	private final By searchBtn = By.cssSelector("button[class*='search-box-button']");
	private final By prodTitles = By.cssSelector(".product-title");
	private final By dropDownOptions = By.id("ui-id-1");
	private final By addToCartBtn = By
			.xpath("//h2[@class='product-title']/parent::div //div[@class='add-info']/div[2]/button[1]");
	private final By successMessg = By.cssSelector("div[class*='bar-notification']");

	List<WebElement> products;

	public void searchByName(String prodName) {
		sendData(searchBox, prodName);
		clickOnElem(searchBtn);
	}

	public boolean getDisplayedProds(String prodName) {
		products = driver.findElements(prodTitles);
		boolean flag = products.stream().anyMatch(s -> s.getText().contains(prodName));
		driver.findElement(searchBox).clear();
		return flag;
	}

	public boolean searchByAutoSuggs(String partialName, String prodName) throws InterruptedException {
		sendData(searchBox, partialName);
		Thread.sleep(1000);
		List<WebElement> dropDownOpts = driver.findElements(dropDownOptions);
		boolean flag = dropDownOpts.stream().anyMatch(s -> s.getText().contains(prodName));
		driver.findElement(searchBox).clear();
		return flag;
	}

	public void chooseProd(String prodName) {
		List<WebElement> product = products.stream().filter(s -> s.getText().contains(prodName))
				.map(s -> s.findElement(addToCartBtn)).collect(Collectors.toList());
		product.get(0).click();
	}

	public String getSuccessMessg() {
		waitForVisibiltyOfElem(successMessg);
		return driver.findElement(successMessg).getText();

	}

}
