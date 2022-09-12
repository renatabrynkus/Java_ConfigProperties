import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class WebsiteTitleTest extends BaseTest {

    private final Logger logger = LoggerFactory.getLogger(WebsiteTitleTest.class);

    @Test
    @DisplayName(DataProvider.SII_PORTAL_TEST_NAME)
    @Tag(DataProvider.REGRESSION_TAG)
    void checkTitleForSiiPortal() {
        logger.info(">>>> Start test >>>>>");
        String actualTitle = driver.getTitle();

        logger.info("Actual title: {}", actualTitle);
        logger.info("Expected title: {}", System.getProperty("title"));
        assertThat(actualTitle).isEqualTo(System.getProperty("title"));

    }
}
