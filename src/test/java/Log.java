import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

public abstract class Log {

    public static void logTestStartInfo(Logger logger, String testName) {
        logger.info("The test {} has started", testName);
    }

    public static void logExpectedTitle(Logger logger, String expectedTitle) {
        logger.info("The expected title is: {}", expectedTitle);
    }

    public static void logActualTitle(Logger logger, String actualTitle) {
        logger.info("The actual title is: {}", actualTitle);
    }

    public static void logDriverInitMessage(Logger logger, WebDriver driver) {
        logger.info("WebDriver {} has been initialized", driver);
    }

    public static void logDriverQuitMessage(Logger logger, WebDriver driver) {
        logger.info("WebDriver {} has been quit", driver);
    }

    public static void logTestFailed(Logger logger, String testName) {
        logger.error("The test {} has failed", testName);
    }

    public static void logTestPassed(Logger logger, String testName) {
        logger.info("The test {} has passed", testName);
    }
}
