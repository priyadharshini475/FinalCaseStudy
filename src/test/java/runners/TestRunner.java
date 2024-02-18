package runners;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		features="src//test//resources//features//",
		glue = {"stepDefinitions"},
		dryRun = false,
		monochrome = true,
		plugin = {"pretty",
				"html:target/Reports/HtmlReport.html"})
public class TestRunner extends AbstractTestNGCucumberTests{
    
}
