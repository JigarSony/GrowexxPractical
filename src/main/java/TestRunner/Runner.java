package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(features = {"src/main/java/Features/MMT.feature"},
        plugin = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"},
        glue = {"tests"})
@RunWith(Cucumber.class)
public class Runner {

}

