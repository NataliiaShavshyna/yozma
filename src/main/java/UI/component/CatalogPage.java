package UI.component;

import UI.component.general.WebEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.StringGenerator;

import java.util.List;
import java.util.Random;

/**
 * The type Catalog page.
 */
public class CatalogPage extends WebEntity {

    /**
     * Catalog page catalog page.
     *
     * @return the catalog page
     */
    public static CatalogPage catalogPage() {
        return new CatalogPage();
    }

    /**
     * Gets product cards.
     *
     * @return the product cards
     */
    public List<WebElement> getProductCards() {
        return webDriver.findElements(By.xpath("//li[@class='item product product-item']"));
    }

    public void waitUntilPageLoaded() {
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.xpath("//li[@class='item product product-item']"), 1));
    }

    public void hoverHoverRandomCard() {
        Actions action = new Actions(webDriver);
        action.moveToElement(getProductCards().get(Integer.valueOf(StringGenerator.randomNumeric(1)))).perform();
        webDriver.findElement(By.xpath("//button[@title='Add to Card']")).click();
    }
    /**
     * Click card by index.
     *
     * @param index the index
     */
    public void clickCardByIndex(int index) {
        getProductCards().get(index).click();
    }

    /**
     * Click random card.
     */
    public void clickRandomCard() {
        getProductCards().get(Integer.valueOf(StringGenerator.randomNumeric(1))).click();
    }
}
