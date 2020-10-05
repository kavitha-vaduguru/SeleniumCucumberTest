package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	 WebDriver driver;
	 
	 public SearchPage(WebDriver driver) {
	 this.driver = driver;
	 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(xpath = "//input[@name='q']")
	 private WebElement searchBox;
public String verifyHomepage() {
	String pageTitle = driver.getTitle();
	return pageTitle;
}
/* This Method is used to provide the search data */
public void provideSearchInput(String strSearchData) {
	searchBox.sendKeys(strSearchData);
	searchBox.sendKeys(Keys.ENTER);
}
}