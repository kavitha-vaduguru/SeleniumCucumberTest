package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	 WebDriver driver;
	 
	 public HomePage(WebDriver driver) {
	 this.driver = driver;
	 PageFactory.initElements(driver, this);
	 }
	 
public String verifyHomepage() {
	String pageTitle = driver.getTitle();
	return pageTitle;
}
}