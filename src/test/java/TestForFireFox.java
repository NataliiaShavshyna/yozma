import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import webdriver.WebDriverFactoryMy;

public class TestForFireFox extends BaseTest {

    @Test
    public void testCheckPreferences() {
        WebDriverFactoryMy.getWebDriver().get("https://www.whatismybrowser.com/detect/what-is-my-user-agent/");
        new SoftAssert().assertTrue(WebDriverFactoryMy.getWebDriver().findElement(By.id("detected_value")).getText()
                .equals("Mozilla/5.0 (iPhone; CPU iPhone OS 16_3_1 like Mac OS X) " +
                        "AppleWebKit/605.1.15 (KHTML, like Gecko) Version/16.3 Mobile/15E148 Safari/604.1"));
    }
}
