import config.BrowserEnvironment;
import config.EnvironmentProperties;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.logging.Level;

public class BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    protected static WebDriver driver;
    private static BrowserEnvironment browserEnvironment;
    public static EnvironmentProperties environmentProperties;

    @BeforeAll
    protected static void setDriver() {
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        environmentProperties = EnvironmentProperties.getInstance();
        browserEnvironment = new BrowserEnvironment();
        driver = browserEnvironment.getDriver();
        logger.debug("Driver started succesfully");
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
        logger.debug("Driver closed");
    }
}
