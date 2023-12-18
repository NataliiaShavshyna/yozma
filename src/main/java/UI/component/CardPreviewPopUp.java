package UI.component;

import UI.component.general.WebEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * The type Card preview pop up.
 */
public class CardPreviewPopUp extends WebEntity {
    /**
     * Proceed to checkout web element.
     *
     * @return the web element
     */
    public WebElement proceedToCheckout() {
        return webDriver.findElement(By.xpath("//button[@id='top-cart-btn-checkout']"));
    }
}
