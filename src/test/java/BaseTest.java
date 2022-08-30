import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.logging.Level;

public class BaseTest {
    private final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    protected WebDriver driver;

    @BeforeAll
    protected static void setDriver() {
        WebDriverManager.chromedriver().setup();
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
    }

    @BeforeEach
    protected  void setUp() {
        driver = new ChromeDriver();
        Log.logDriverInitMessage(logger, driver);
    }

    @AfterEach
    protected void tearDown() {
            driver.quit();
    }
}