package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import bases.BaseTest;
import bases.RetryFailures;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.P03_Search;

public class T03_Search extends BaseTest {
	String prodName = "HTC One M8 Android L 5.0 Lollipop";
	P03_Search search;

	@Test(priority = 1)
	@Severity(SeverityLevel.MINOR)
	public void searchByProdName() {

		search = new P03_Search(driver);
		search.searchByName(prodName);
		boolean flag = search.getDisplayedProds(prodName);
		Assert.assertTrue(flag);
	}

	@Test(priority = 2, retryAnalyzer = RetryFailures.class)
	@Severity(SeverityLevel.NORMAL)
	public void searchByAutoSuggs() throws InterruptedException {
		boolean flag = search.searchByAutoSuggs("HTC", prodName);
		Assert.assertTrue(flag);

	}

}
