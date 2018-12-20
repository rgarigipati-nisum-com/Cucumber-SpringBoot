import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/integrationTest/resources/features",
//glue="experiment.service.steps",
tags="~@wip")
public class CucumberTest {
}
