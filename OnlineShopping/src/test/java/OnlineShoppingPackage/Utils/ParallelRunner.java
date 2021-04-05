package OnlineShoppingPackage.Utils;

import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ParallelRunner {

    private static Logger log = LogManager.getLogger(ParallelRunner.class);

    private static Map<Object, List<Thread>> contextThreadMap = new ConcurrentHashMap<Object, List<Thread>>();
    private static HashMap<String, String> proxyParameters;
    private static HashMap<String, String> runnerParameters;
    public TestNGCucumberRunner testNGCucumberRunner;
    private static ThreadLocal<Object> scenarios = new ThreadLocal<Object>();
    private static ThreadLocal<Object> tests = new ThreadLocal<Object>();
    private List<String> categories = new ArrayList<String>();

    // Passing platform, browser name/version as parameters from suitefiles/testng.xml file
    // Note needs to be added at suite level
    @BeforeSuite
    @Parameters({
            "browserName",
            "browserVersion",
            "platform",
            "proxyProtocol",
            "proxyHost",
            "proxyPort"
    })
    public void beforeSuite(
            String browserName,
            String browserVersion,
            String platform,
            @Optional(" ")String proxyProtocol,
            @Optional(" ")String proxyHost,
            @Optional(" ")String proxyPort){

        log.debug("Setting up runner and proxy parameters");
        addRunnerParameters(browserName, browserVersion, platform);
        addProxyParameters(proxyProtocol, proxyHost, proxyPort);
    }

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        log.debug("Creating new TestNGCucumberRunner");
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickleEvent, FeatureWrapper cucumberFeature) throws Throwable {
        log.debug("Registering and running scenario (" + pickleEvent.toString() + " - " + cucumberFeature.toString());
        register(pickleEvent.toString());

        testNGCucumberRunner.runScenario(pickleEvent.getPickle());
    }

    @DataProvider(name="scenarios", parallel=true)
    public Object[][] scenarios() {
        if (testNGCucumberRunner == null) {
            return new Object[0][0];
        }

        log.debug("Generating scenarios");
        return testNGCucumberRunner.provideScenarios();

    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        if (testNGCucumberRunner == null) {
            return;
        }

        testNGCucumberRunner.finish();
    }

    public static void addRunnerParameters(String browserName, String browserVersion, String platform){
        runnerParameters = new HashMap<String, String>();
        runnerParameters.put("browserName", browserName);
        runnerParameters.put("browserVersion", browserVersion);
        runnerParameters.put("platform", platform);

    }

    public static void addProxyParameters(String proxyProtocol, String proxyHost, String proxyPort) {
        proxyParameters = new HashMap<String, String>();
        proxyParameters.put("proxyProtocol", proxyProtocol);
        proxyParameters.put("proxyHost", proxyHost);
        proxyParameters.put("proxyPort", proxyPort);
    }

    public static void register(String scenario){
        synchronized (contextThreadMap) {
            if(!contextThreadMap.containsKey(scenario)) {
                log.debug("Adding context for key " + scenario);
                contextThreadMap.put(scenario, new ArrayList<Thread>());
            }

            if(!contextThreadMap.get(scenario).contains(Thread.currentThread())){
                log.debug("Adding scenario for key " + scenario);
                scenarios.set(scenario);
                contextThreadMap.get(scenario).add(Thread.currentThread());
            }
        }
    }
}
