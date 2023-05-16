package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.apache.logging.log4j.ThreadContext;

@CucumberOptions(features = "src/test/resources/features/",
        glue = {"stepdefinition"},
        plugin = {"pretty",
                "html:target/cucumber-reports",
                "json:target/cucumber.json",
        },
        monochrome = true,
        publish = true)

@Log4j2
public class TestRunner extends AbstractTestNGCucumberTests {
    @SneakyThrows
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "101.0");
        capabilities.setCapability("enableVNC", true);
        // This is so the uniqueThreadIdentifier value is not absent for log4j
        ThreadContext.put("uniqueThreadIdentifier", "testng");
        return super.scenarios();
    }

    @AfterMethod(alwaysRun = true)
    public void reportTestResult(ITestResult result) {
        if (result.isSuccess()) {
            log.info("Test finished successfully");
        } else {
            log.warn("Test finished with failure: ", result.getThrowable());
        }
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        //NOTE! Do not remove this method as it's required by cucumber-testng to initiate scenario execution
    }
}
