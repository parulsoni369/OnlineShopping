package OnlineShoppingPackage.Runner;

import OnlineShoppingPackage.Utils.ParallelRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-reports/cucumber-html-report",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "junit:target/cucumber-reports/Cucumber.xml"
        },
        features = {"src/test/java/OnlineShoppingPackage/Features/"},
        tags = {"@test_parallel"},
        glue = "OnlineShoppingPackage/StepDefs",
        monochrome = true
)
public class TestRunnerParallel extends ParallelRunner {
}
