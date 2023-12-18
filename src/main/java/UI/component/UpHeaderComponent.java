package UI.component;

import UI.component.general.WebEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * The type Up header component.
 */
public class UpHeaderComponent extends WebEntity {

    /**
     * Get create account button web element.
     *
     * @return the web element
     */
    public WebElement getCreateAccountButton(){
        return webDriver.findElement(By.xpath("//*[contains(text(),'Create an Accou')]"));
    }
}
