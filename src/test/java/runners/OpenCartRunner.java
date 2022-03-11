package runners;




import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		publish = true,
		features = "src//test//resources//features//",
		glue = {"stepDefs"},
		dryRun = false,
		monochrome = true,
		plugin = { "pretty",
				 "html:target/reports/HTMLReports.html"
		}
		)



public class OpenCartRunner extends AbstractTestNGCucumberTests {

}
