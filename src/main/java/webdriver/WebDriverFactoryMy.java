package webdriver;

import org.openqa.selenium.WebDriver;

public class WebDriverFactoryMy {

    private static ThreadLocal<WebDriver> driverMy = new ThreadLocal<>();

    private WebDriverFactoryMy() {
    }

    public static synchronized void setWebDriver(String browser) {
        WebDriverFactoryMy manager = new WebDriverFactoryMy();
        driverMy.set(manager.initDriver(browser));
    }

    public static synchronized WebDriver getWebDriver(String browser) {
        if (null == driverMy.get()) {
            setWebDriver(browser);
        }
        return getWebDriver();
    }

    public static synchronized WebDriver getWebDriver() {
        return driverMy.get();
    }

    public static synchronized void destroy() {
        driverMy.get().quit();
        driverMy.remove();
    }

    private WebDriver initDriver(String browser) {
        WebDriver web = DriverFactory.getWebDriver(browser);
        web.manage().deleteAllCookies();
        return web;
    }
}
