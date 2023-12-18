package UI.component;

import UI.component.general.WebEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The type Header.
 */
public class Header extends WebEntity {

    /**
     * Cart web element.
     *
     * @return the web element
     */
    public WebElement cart() {
        return webDriver.findElement(By.xpath("//div[@data-block='minicart']"));
    }

    /**
     * Wait until cart is not empty.
     */
    public void waitUntilCartIsNotEmpty() {

        WebDriverWait wait = new WebDriverWait(webDriver, 60);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='message-success success message']"),1));
    }
}

