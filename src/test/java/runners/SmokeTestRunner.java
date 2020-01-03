package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/default-cucumber-reports",
                "json:target/cucumber.json"
        },
        features="src/test/resources/features/",
        glue="stepDefinitions/",
        tags =  {"@smoke_test"},
        dryRun =false
        )
public class SmokeTestRunner {
}




