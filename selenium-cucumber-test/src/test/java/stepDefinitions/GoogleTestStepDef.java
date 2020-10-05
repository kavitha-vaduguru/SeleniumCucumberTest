package stepDefinitions;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.ReadProperyFile;
import helper.TestBase;
import pageObject.HomePage;
import pageObject.SearchPage;
import pageObject.ClickOnLinkPage;
import pageObject.VerifyLogoPage;

public class GoogleTestStepDef {
	
	WebDriver driver;
	
	/* This Method is used to launch the application URL */
	
	@Given("^I navigate to google webpage$")
	public void launchURL() {
		driver = TestBase.driverSetup();
		PageFactory.initElements(driver, this);
		String baseURL = ReadProperyFile.getConfigData("GoogleURL");
		String env = ReadProperyFile.getConfigData("environment");
		if (env.equalsIgnoreCase("INT")) {
			// provide URL for INT environment
		} else if (env.equalsIgnoreCase("STAG")) {
			// provide URL for STAG environment
		} else if (env.equalsIgnoreCase("QA")) {
			System.out.println(baseURL);
			driver.get(baseURL);
			driver.manage().window().maximize();
			int wait = Integer.parseInt(ReadProperyFile.getConfigData("implicitwait"));
			driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
			int pageloadTime = Integer.parseInt(ReadProperyFile.getConfigData("pageloadTimeout"));
			driver.manage().timeouts().pageLoadTimeout(pageloadTime, TimeUnit.SECONDS);
		}
	}

	@Then("^I see google homepage using \"([^\"]*)\"$")
	public void i_see_homepage_using(String strWebsiteName) {
		HomePage homepageObject = new HomePage(driver);
		String actualTitle = homepageObject.verifyHomepage();
		Assert.assertTrue(actualTitle.contains(strWebsiteName));
	}

	@When("^I search for keyword using \"([^\"]*)\"$")
	public void i_search_for_keyword_using(String strKeyword) throws Exception {
		SearchPage searchPageObject = new SearchPage(driver);
		searchPageObject.provideSearchInput(strKeyword);
	}

	@And("^I select search result$")
	public void i_select_result() throws Exception {
		ClickOnLinkPage clickOnLinkPage = new ClickOnLinkPage(driver);
		clickOnLinkPage.clickOnLink();
	}

	@Then("^I verify JP Mogan logo on home page$")
	public void i_verify_the_logo_on_home_page() throws Exception {
		VerifyLogoPage verifyLogoPage = new VerifyLogoPage(driver);
		boolean isLogoDisplayed = verifyLogoPage.verifyLogo();
		Assert.assertTrue(isLogoDisplayed);
	}

}
