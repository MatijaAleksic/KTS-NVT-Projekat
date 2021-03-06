package rs.ac.uns.kts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import rs.ac.uns.kts.pages.AdminTestPages.Utilities;

public class SingInPage {

	private WebDriver driver;

	@FindBy(id = "email")
	private WebElement emailInput;

	@FindBy(id = "password")
	private WebElement passwordInput;

	@FindBy(xpath = "//button[@id='login-button' and not(@disabled)]")
	private WebElement submitButton;

	@FindBy(xpath = "//*[contains(text(),'Logout')]")
	private WebElement logout;

	public SingInPage(WebDriver driver) {
		this.driver = driver;
	}

	public void logoutLinkClick() {
		Utilities.clickableWait(driver, this.logout, 1000).click();
	}

	public WebElement getEmailInput() {
		return Utilities.visibilityWait(driver, this.emailInput, 10);
	}

	public void setEmailInput(String value) {
		WebElement el = getEmailInput();
		el.clear();
		el.sendKeys(value);
	}

	public WebElement getPasswordInput() {
		return Utilities.visibilityWait(driver, this.passwordInput, 10);
	}

	public void setPasswordInput(String value) {
		WebElement el = getPasswordInput();
		el.clear();
		el.sendKeys(value);
	}

	public void submitBtnClick() {
		System.out.println(this.submitButton);
		Utilities.clickableWait(driver, this.submitButton, 100).click();
	}



}
