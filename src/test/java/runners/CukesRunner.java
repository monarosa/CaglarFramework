package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-report"
        },
        features="src/test/resources/features/",
        glue="stepDefinitions/",
        tags = "@dev",
        dryRun = false
        )
public class CukesRunner extends AbstractTestNGCucumberTests {
}




