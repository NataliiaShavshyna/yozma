package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Level;

/**
 * The enum Driver factory.
 */
public enum DriverFactory {

    /**
     * The Firefox.
     */
    FIREFOX("firefox") {
        @Override
        public WebDriver getWebDriver() {
            System.setProperty("webdriver.gecko.driver", "webdriver/geckodriver");
            String userAgent = "Mozilla/5.0 (iPhone; CPU iPhone OS 16_3_1 like Mac OS X) " +
                    "AppleWebKit/605.1.15 (KHTML, like Gecko) Version/16.3 Mobile/15E148 Safari/604.1 java";

            // Create FirefoxOptions
            FirefoxOptions options = new FirefoxOptions();

            // Set the user agent
            options.addPreference("general.useragent.override", userAgent);

            // Set the preference to reject third-party cookies
            options.addPreference("network.cookie.cookieBehavior", 1);

            WebDriver webDriver = new FirefoxDriver(options);
            webDriver.manage().window().maximize();
            return webDriver;
        }
    },
    /**
     * The Chrome.
     */
    CHROME("chrome") {
        @Override
        public WebDriver getWebDriver() {
            System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("webdriver/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
            options.addArguments("start-maximized");
            options.addArguments("--disable-cookies");
            DesiredCapabilities cap = DesiredCapabilities.chrome();
// logging prefs
            LoggingPreferences loggingPreferences = new LoggingPreferences();
            loggingPreferences.enable(LogType.BROWSER, Level.ALL);
            loggingPreferences.enable(LogType.CLIENT, Level.ALL);
            loggingPreferences.enable(LogType.PERFORMANCE, Level.ALL);
            loggingPreferences.enable(LogType.PROFILER, Level.ALL);
            cap.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);

// Set the preference to reject third-party cookies

            cap.setCapability(ChromeOptions.CAPABILITY, options);
            options.merge(cap);
            WebDriver webDriver = new ChromeDriver(options);
            webDriver.manage().deleteAllCookies();
            return webDriver;
        }
    },

    /**
     * The Null.
     */
    NULL("") {
        @Override
        public WebDriver getWebDriver() {
            throw new IllegalStateException("Browser name not provided");
        }
    };

    private String browserName;

    DriverFactory(String browserName) {
        this.browserName = browserName;
    }

    /**
     * Gets web driver.
     *
     * @return the web driver
     */
    public abstract WebDriver getWebDriver();

    /**
     * Gets web driver.
     *
     * @param text the text
     * @return the web driver
     */
    public static WebDriver getWebDriver(String text) {
        for (DriverFactory b : DriverFactory.values()) {
            if (b.browserName.equalsIgnoreCase(text)) {
                return b.getWebDriver();
            }
        }
        throw new IllegalStateException("Browser not found!");
    }
}
