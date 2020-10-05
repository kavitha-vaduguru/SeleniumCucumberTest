package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.ReadProperyFile;

public class ClickOnLinkPage {
	 WebDriver driver;
	 
	 public ClickOnLinkPage(WebDriver driver) {
	 this.driver = driver;
	 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(xpath = "//a[@href='https://www.jpmorgan.com/']")
		private WebElement LinkClick;
	 By verifyImage = By.xpath("//div[@class='logo-desktop-only']//div[@class='logo container-fluid']");

public String verifyHomepage() {
	String pageTitle = driver.getTitle();
	return pageTitle;
}

/* This Method is used to click link on the result page */
public void clickOnLink() {
	LinkClick.click();
	WebDriverWait wait = new WebDriverWait(driver,
			Integer.parseInt(ReadProperyFile.getConfigData("pageloadTimeout")));
	wait.until(ExpectedConditions.presenceOfElementLocated(verifyImage));
}
}