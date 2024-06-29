package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import bases.BaseTest;
import bases.RetryFailures;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.HomePage;
import pages.P03_Search;
import pages.P05_cart;

public class T05_Cart extends BaseTest {
	String prodName = "HTC One M8 Android L 5.0 Lollipop";
	String SuccMessg = "The product has been added to your";
	P03_Search search;

	@Test
	@Severity(SeverityLevel.MINOR)
	public void searchByProdName() {

		search = new P03_Search(driver);
		search.searchByName(prodName);
		boolean flag = search.getDisplayedProds(prodName);
		Assert.assertTrue(flag);
	}

	@Test(dependsOnMethods = { "searchByProdName" }, retryAnalyzer = RetryFailures.class)
	@Severity(SeverityLevel.CRITICAL)
	public void addProdToCart() {
		search.chooseProd(prodName);
		String SuccessMessg = search.getSuccessMessg();
		Assert.assertTrue(SuccessMessg.contains(SuccMessg));
	}

	@Test(dependsOnMethods = { "addProdToCart" })
	public void verifyProdAddedToCart() {
		HomePage homePage = new HomePage(driver);
		P05_cart cart = homePage.goToCart();
		boolean flag = cart.verifyProdAdded(prodName);
		Assert.assertTrue(flag);
	}

}
