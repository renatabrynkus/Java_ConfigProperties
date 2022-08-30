import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class WebsiteTitleTest extends BaseTest {

    private final Logger logger = LoggerFactory.getLogger(WebsiteTitleTest.class);

    @ParameterizedTest
    @DisplayName(DataProvider.SII_PORTAL_NAME)
    @ValueSource(strings = DataProvider.SII_PORTAL_TITLE)
    @Tag(DataProvider.REGRESSION_TAG)
    @Tag(DataProvider.SII_PORTAL_TAG)
    void checkTitleForSiiPortal(String expectedTitle) {
        Log.logExpectedTitle(logger, expectedTitle);
        driver.get(DataProvider.SII_PORTAL_URL);
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        Log.logActualTitle(logger, actualTitle);
        try {
            assertThat(actualTitle).isEqualTo(expectedTitle);
        } catch (Error e) {
            Log.logTestFailed(logger, DataProvider.SII_PORTAL_NAME);
        }
    }

    @ParameterizedTest
    @DisplayName(DataProvider.ONET_NAME)
    @ValueSource(strings = DataProvider.ONET_TITLE)
    @Tag(DataProvider.REGRESSION_TAG)
    @Tag(DataProvider.ONET_TAG)
    void checkTitleForOnet(String expectedTitle) {
        Log.logExpectedTitle(logger, expectedTitle);
        driver.get(DataProvider.ONET_URL);
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        Log.logActualTitle(logger, actualTitle);
        try {
            assertThat(actualTitle).isEqualTo(expectedTitle);
        } catch (Error e) {
            Log.logTestFailed(logger, DataProvider.ONET_NAME);
        }
    }

    @ParameterizedTest
    @DisplayName(DataProvider.KOTUSZKOWO_NAME)
    @ValueSource(strings = DataProvider.KOTUSZKOWO_TITLE)
    @Tag(DataProvider.REGRESSION_TAG)
    @Tag(DataProvider.KOTUSZKOWO_TAG)
    void checkTitleForKotuszkowo(String expectedTitle) {
        Log.logExpectedTitle(logger, expectedTitle);
        driver.get(DataProvider.KOTUSZKOWO_URL);
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        Log.logActualTitle(logger, actualTitle);
        try {
            assertThat(actualTitle).isEqualTo(expectedTitle);
        } catch (Error e) {
            Log.logTestFailed(logger, DataProvider.KOTUSZKOWO_NAME);
        }
    }

    @ParameterizedTest
    @DisplayName(DataProvider.FILMWEB_NAME)
    @ValueSource(strings = DataProvider.FILMWEB_TITLE)
    @Tag(DataProvider.REGRESSION_TAG)
    @Tag(DataProvider.FILMWEB_TAG)
    void checkTitleForFilmweb(String expectedTitle) {
        Log.logExpectedTitle(logger, expectedTitle);
        driver.get(DataProvider.FILMWEB_URL);
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        Log.logActualTitle(logger, actualTitle);
        try {
            assertThat(actualTitle).isEqualTo(expectedTitle);
        } catch (Error e) {
            Log.logTestFailed(logger, DataProvider.FILMWEB_NAME);
        }
    }

    @ParameterizedTest
    @DisplayName(DataProvider.SELENIUM_NAME)
    @ValueSource(strings = DataProvider.SELENIUM_TITLE)
    @Tag(DataProvider.REGRESSION_TAG)
    @Tag(DataProvider.SELENIUM_TAG)
    void checkTitleForSeleniumDocumentation(String expectedTitle) {
        Log.logExpectedTitle(logger, expectedTitle);
        driver.get(DataProvider.SELENIUM_URL);
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        Log.logActualTitle(logger, actualTitle);
        try {
            assertThat(actualTitle).isEqualTo(expectedTitle);
        } catch (Error e) {
            Log.logTestFailed(logger, DataProvider.SELENIUM_NAME);
        }
    }
}
