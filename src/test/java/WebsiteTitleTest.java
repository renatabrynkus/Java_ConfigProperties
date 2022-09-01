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
    @DisplayName(DataProvider.SII_PORTAL_TEST_NAME)
    @ValueSource(strings = DataProvider.SII_PORTAL_TITLE)
    @Tag(DataProvider.REGRESSION_TAG)
    @Tag(DataProvider.SII_PORTAL_TAG)
    void checkTitleForSiiPortal(String expectedTitle) {
        Log.logTestStartInfo(logger, DataProvider.SII_PORTAL_TEST_NAME);
        Log.logExpectedTitle(logger, expectedTitle);
        driver.get(DataProvider.SII_PORTAL_URL);
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        Log.logActualTitle(logger, actualTitle);
        assertThat(actualTitle).isEqualTo(expectedTitle);
        Log.logTestPassed(logger, DataProvider.SII_PORTAL_TEST_NAME);
    }

    @ParameterizedTest
    @DisplayName(DataProvider.ONET_TEST_NAME)
    @ValueSource(strings = DataProvider.ONET_TITLE)
    @Tag(DataProvider.REGRESSION_TAG)
    @Tag(DataProvider.ONET_TAG)
    void checkTitleForOnet(String expectedTitle) {
        Log.logTestStartInfo(logger, DataProvider.ONET_TEST_NAME);
        Log.logExpectedTitle(logger, expectedTitle);
        driver.get(DataProvider.ONET_URL);
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        Log.logActualTitle(logger, actualTitle);
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    @ParameterizedTest
    @DisplayName(DataProvider.KOTUSZKOWO_TEST_NAME)
    @ValueSource(strings = DataProvider.KOTUSZKOWO_TITLE)
    @Tag(DataProvider.REGRESSION_TAG)
    @Tag(DataProvider.KOTUSZKOWO_TAG)
    void checkTitleForKotuszkowo(String expectedTitle) {
        Log.logTestStartInfo(logger, DataProvider.KOTUSZKOWO_TEST_NAME);
        Log.logExpectedTitle(logger, expectedTitle);
        driver.get(DataProvider.KOTUSZKOWO_URL);
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        Log.logActualTitle(logger, actualTitle);
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    @ParameterizedTest
    @DisplayName(DataProvider.FILMWEB_TEST_NAME)
    @ValueSource(strings = DataProvider.FILMWEB_TITLE)
    @Tag(DataProvider.REGRESSION_TAG)
    @Tag(DataProvider.FILMWEB_TAG)
    void checkTitleForFilmweb(String expectedTitle) {
        Log.logTestStartInfo(logger, DataProvider.FILMWEB_TEST_NAME);
        Log.logExpectedTitle(logger, expectedTitle);
        driver.get(DataProvider.FILMWEB_URL);
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        Log.logActualTitle(logger, actualTitle);
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    @ParameterizedTest
    @DisplayName(DataProvider.SELENIUM_TEST_NAME)
    @ValueSource(strings = DataProvider.SELENIUM_TITLE)
    @Tag(DataProvider.REGRESSION_TAG)
    @Tag(DataProvider.SELENIUM_TAG)
    void checkTitleForSeleniumDocumentation(String expectedTitle) {
        Log.logTestStartInfo(logger, DataProvider.SELENIUM_TEST_NAME);
        Log.logExpectedTitle(logger, expectedTitle);
        driver.get(DataProvider.SELENIUM_URL);
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        Log.logActualTitle(logger, actualTitle);
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }
}
