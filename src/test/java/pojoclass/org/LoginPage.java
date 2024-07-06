package pojoclass.org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

	private WebDriver driver;
	private String usernameXpath = "//input[@id='user-name']";
	private String passwordXpath = "//input[@id='password']";
	private String loginBtnXpath = "//input[@name='login-button']";
	private String headerXpath = "//span[@class='title']";
	private String menuXpath = "//button[@id='react-burger-menu-btn']";
	private String logoutBtnXpath = "//a[@id='logout_sidebar_link']";
	private String errorXpath = "//h3[@data-test='error']";

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setUsername(String username) {
		driver.findElement(By.xpath(usernameXpath)).sendKeys(username);
	}

	public void setPassword(String password) {
		driver.findElement(By.xpath(passwordXpath)).sendKeys(password);
	}

	public void clickLoginBtn() {
		driver.findElement(By.xpath(loginBtnXpath)).click();
	}

	public void verifyLoggedIn() {
		boolean isLoggedIn = driver.findElement(By.xpath(headerXpath)).getText().equals("Products");
		Assert.assertTrue(isLoggedIn, "Login");
	}

	public void clickLogoutBtn() throws InterruptedException {
		driver.findElement(By.xpath(menuXpath)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(logoutBtnXpath)).click();
	}

	public void verifyLoggedOut() {
		boolean isLoggedOut = driver.findElement(By.xpath(loginBtnXpath)).isDisplayed();
		Assert.assertTrue(isLoggedOut, "Logout");
	}

	public void verifyErrorMsg(String expErrorMsg) {
		String actErrorMsg = driver.findElement(By.xpath(errorXpath)).getText().trim();
		Assert.assertEquals(actErrorMsg, expErrorMsg);
	}

}
