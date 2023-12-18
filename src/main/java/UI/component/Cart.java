package UI.component;

import UI.component.general.WebEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * The type Cart.
 */
public class Cart extends WebEntity {

    /**
     * Procced to check out web element.
     *
     * @return the web element
     */
    public WebElement proccedToCheckOut() {
        return webDriver.findElement(By.xpath("//button[@id='top-cart-btn-checkout']"));
    }
}
