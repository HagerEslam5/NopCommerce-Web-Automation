package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import bases.BasePage;

public class HomePage extends BasePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	private final By registerBtn = By.cssSelector(".ico-register");
	private final By loginBtn = By.cssSelector(".ico-login");
	private final By wishlistBtn = By.cssSelector(".ico-wishlist");
	private final By cartBtn = By.cssSelector(".ico-cart");

	public P01_Registration goToRegistration() {
		excuteScript(registerBtn);
		P01_Registration Registration = new P01_Registration(driver);
		return Registration;
	}

	public P02_Login goToLogin() {
		excuteScript(loginBtn);
		P02_Login login = new P02_Login(driver);
		return login;
	}

	public P05_cart goToCart() {
		excuteScript(cartBtn);
		P05_cart cart = new P05_cart(driver);
		return cart;
	}

	public void goToWishlist() {
		excuteScript(wishlistBtn);
	}

}
