package cucumberRunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import helper.TestBase;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
		"html:target/cucumberHtmlReport" }, features = "src/test/resources/features/VerifyLogoTest.feature", glue = {
				"stepDefinitions" }, dryRun = false, tags = { "@verifyLogo" })

public class TestRunner extends TestBase {

	@AfterClass
	public static void close() {
		driver.quit();
	}

}
