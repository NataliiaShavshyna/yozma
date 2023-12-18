package UI.component;

import UI.component.general.WebEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The type Product details page.
 */
public class ProductDetailsPage extends WebEntity {

    /**
     * Gets add to card button.
     *
     * @return the add to card button
     */
    public WebElement getAddToCardButton() {
        return webDriver.findElement(By.xpath("//button[@id='product-addtocart-button']"));
    }

    public void waitUntilPageLoaded() {
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@id='product-addtocart-button']")));
    }
}
