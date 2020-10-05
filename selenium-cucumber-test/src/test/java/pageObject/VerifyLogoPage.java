package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.TestBase;

public class VerifyLogoPage {
	 WebDriver driver;
	 
	 public VerifyLogoPage(WebDriver driver) {
	 this.driver = driver;
	 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(xpath = "//div[@class='logo-desktop-only']//div[@class='logo container-fluid']")
		private WebElement jpMorganLogo;
	 
	 /* This Method is used to verify logo on the page */
		public boolean verifyLogo() {
			return TestBase.isWebElementVisible(jpMorganLogo);
		}

}