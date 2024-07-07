package pojoclass.org;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {

	private WebDriver driver;
	private String firstNameXpath = "//input[@id='firstName']";
	private String lastNameXpath = "//input[@id='lastName']";
	private String emailXpath = "//input[@id='userEmail']";
	private String genderRadioXpath = "//input[@name='gender']";
	private String mobiledXpath = "//input[@id='userNumber']";
	private String dobXpath = "//input[@id='dateOfBirthInput']";
	private String checkBoxXpath = "//input[@type='checkbox']";
	private String fileuplodXpath = "//input[@id='uploadPicture']";
	private String addressXpath = "//textarea[@id='currentAddress']";
	private String submitBtnXpath = "//button[@id='submit']";
	private String successMsgXpath = "//div[@id='example-modal-sizes-title-lg']";

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setFirstName(String firstName) {
		driver.findElement(By.xpath(firstNameXpath)).sendKeys(firstName);
	}

	public void setLastName(String lastName) {
		driver.findElement(By.xpath(lastNameXpath)).sendKeys(lastName);
	}

	public void setEmail(String email) {
		driver.findElement(By.xpath(emailXpath)).sendKeys(email);
	}

	public void selectGender(String gender) {
		List<WebElement> genderElements = driver.findElements(By.xpath(genderRadioXpath));
		for (WebElement element : genderElements) {
			if (element.getAttribute("value").equals(gender)) {

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				break;
			}
		}
	}

	public void setMobile(String mobile) {
		driver.findElement(By.xpath(mobiledXpath)).sendKeys(mobile);
	}

	public void setDOB(String dob) {
		WebElement element = driver.findElement(By.xpath(dobXpath));
		((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1];", element, dob);
	}

	public void selectHobbies(String hobby) {
		List<WebElement> hobbyElements = driver.findElements(By.xpath(checkBoxXpath + "/following-sibling::label"));
		for (int i = 0; i < hobbyElements.size(); i++) {
			if (hobbyElements.get(i).getText().trim().equals(hobby)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", hobbyElements.get(i));
				break;
			}
		}
	}

	public void uploadPicture(String picName) {
		String picLocation = System.getProperty("user.dir") + File.separator + picName;
		System.out.println("****************************************************" + picLocation);
		driver.findElement(By.xpath(fileuplodXpath)).sendKeys(picLocation);
	}

	public void setAddress(String address) {
		driver.findElement(By.xpath(addressXpath)).sendKeys(address);
	}

	public void clickSubmitBtn() {
		WebElement element = driver.findElement(By.xpath(submitBtnXpath));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public void verifyUserRegister() {
		String msg = driver.findElement(By.xpath(successMsgXpath)).getText();

		System.out.println("****************************************" + msg);
		Assert.assertEquals("Registration", "Thanks for submitting the form", msg );

	}

}
