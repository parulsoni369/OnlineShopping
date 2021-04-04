package OnlineShoppingPackage.Runner;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-reports/cucumber-html-report",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "junit:target/cucumber-reports/Cucumber.xml"
        },
        features = {"src/test/java/OnlineShoppingPackage/Features/"},
//        tags = {"@test_baseline"},
        tags = {"@test1"},
        glue = "OnlineShoppingPackage/StepDefs",
        monochrome = true
)
public class TestRunner {
}
