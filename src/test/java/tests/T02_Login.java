package tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import bases.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.HomePage;
import pages.P01_Registration;
import pages.P02_Login;

public class T02_Login extends BaseTest {
	String regMessg = "Your registration completed";
	String pgTitle = "nopCommerce demo store";

	@Test(dataProvider = "getData")
	@Severity(SeverityLevel.CRITICAL)
	public void register(HashMap<String, String> input) {
		P01_Registration Registration = HomePage.goToRegistration();
		Registration.register(input.get("fName"), input.get("Lname"), input.get("day"), input.get("month"),
				input.get("year"), input.get("email"), input.get("company"), input.get("password"));
		String confirmationMessg = Registration.getConfMess();
		Registration.logout();
		Assert.assertEquals(confirmationMessg, regMessg);

	}

	@Test(dependsOnMethods = { "register" }, dataProvider = "getData")
	@Severity(SeverityLevel.CRITICAL)
	public void testLogin(HashMap<String, String> input) {
		P02_Login loginObj = HomePage.goToLogin();
		loginObj.login(input.get("email"), input.get("password"));
		String title = loginObj.getPageTitle();
		Assert.assertEquals(title, pgTitle);
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = readJsonData(
				System.getProperty("user.dir") + "\\src\\test\\java\\data\\registration.json");
		return new Object[][] { { data.get(1) } };

	}
}
