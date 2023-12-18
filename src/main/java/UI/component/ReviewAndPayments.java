package UI.component;

import UI.component.general.WebEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The type Review and payments.
 */
public class ReviewAndPayments extends WebEntity {


    public void waitUntilPageLoaded() {
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.numberOfElementsToBe(
                By.xpath("//div[@class='loading-mask' and @style='display: none;']"), 1));

    }
    /**
     * Place order button click.
     */
    public void placeOrderButtonClick() {

        WebElement element = webDriver.findElement(By.xpath("//button[@class='action primary checkout']"));
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void emailInput(String email) {
        JavascriptExecutor jexe = (JavascriptExecutor) webDriver;
        jexe.executeScript(String.format("document.getElementById('customer-email').value='%s';", email));
    }

}
