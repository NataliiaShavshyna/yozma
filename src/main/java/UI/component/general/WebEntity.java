package UI.component.general;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import webdriver.WebDriverFactoryMy;


public abstract class WebEntity {

    private static final Logger LOGGER = LogManager.getLogger();
    protected final WebDriver webDriver;

    protected WebEntity() {
        webDriver = WebDriverFactoryMy.getWebDriver();
    }
}
