import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import webdriver.WebDriverFactoryMy;

public class TestCookies extends BaseTest {

    @Test
    public void testCookies() {
        if (WebDriverFactoryMy.getWebDriver().getClass().getName().equals("chrome")) {
            WebDriverFactoryMy.getWebDriver().get("chrome://settings/cookies");
        } else {
            WebDriverFactoryMy.getWebDriver().get("about:preferences#privacy");
        }

    }
}
