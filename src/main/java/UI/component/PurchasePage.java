package UI.component;

import UI.component.general.WebEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PurchasePage extends WebEntity {

    private static final String ORDER_NUMBER = "//p[contains(text(),'Your order')]/span";

    public void waitUntilPageIsLoaded() {
        if (webDriver.getClass().getName().contains("firefox")) {
            WebDriverWait wait = new WebDriverWait(webDriver, 30);
            wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(ORDER_NUMBER), 1));
        }

    }

    public String orderNumberLabel() {
        String result = "";
        if (webDriver.getClass().getName().contains("firefox")) {
            result = webDriver.findElement(By.xpath(ORDER_NUMBER)).getText();
        }
        return result;
    }
}
