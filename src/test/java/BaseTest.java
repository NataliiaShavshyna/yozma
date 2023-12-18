import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import webdriver.WebDriverFactoryMy;

/**
 * The type Base test.
 */
public class BaseTest {

    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Start browser test.
     *
     * @param browser the browser
     */
    @BeforeTest(alwaysRun = true)
    @Parameters(value = {"browser"})
    public void startBrowserTest(@Optional("firefox") String browser) {
        String browserUpperCase = browser.toUpperCase();
        LOGGER.debug("Executing tests on: {}", browserUpperCase);
        WebDriverFactoryMy.setWebDriver(browser);
    }


    /**
     * End browser test.
     */
    @AfterTest(alwaysRun = true)
    public void endBrowserTest() {
        WebDriverFactoryMy.destroy();
    }
}
