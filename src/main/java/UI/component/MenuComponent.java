package UI.component;

import UI.component.general.WebEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * The type Menu component.
 */
public class MenuComponent extends WebEntity {

    /**
     * The constant MENU.
     */
    public static final String MENU = "//div[@id='store.menu']";
    /**
     * The constant MENU_ITEM.
     */
    public static final String MENU_ITEM = "//li[contains(@class, 'ui-menu-item')]";
    /**
     * The constant SUB_MENU_ITEM.
     */
    public static final String SUB_MENU_ITEM = "//li[contains(@class, 'ui-menu-item')]";

    /**
     * Gets menu.
     *
     * @return the menu
     */
    public MenuComponent getMenu() {
        return this;
    }

    /**
     * Gets menu items.
     *
     * @return the menu items
     */
    public List<WebElement> getMenuItems() {
        return webDriver.findElements(By.xpath(MENU_ITEM));
    }

    /**
     * Gets sub menu items.
     *
     * @return the sub menu items
     */
    public List<WebElement> getSubMenuItems() {

        return webDriver.findElements(By.xpath(MENU_ITEM));
    }

    /**
     * Click menu item by name menu component.
     *
     * @param name the name
     * @return the menu component
     */
    public MenuComponent clickMenuItemByName(String name) {

        this.getMenuItems().stream()
                .filter(menuItem -> menuItem.getAttribute("innerText").equals(name))
                .findFirst()
                .ifPresent(WebElement::click);

        return this;
    }

    public MenuComponent waitUntilMenuLoaded(){
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']")));
        return this;
    }
    /**
     * Hover menu item by name menu component.
     *
     * @param name the name
     * @return the menu component
     */
    public MenuComponent hoverMenuItemByName(String name) {

        this.getMenuItems().stream()
                .filter(menuItem -> menuItem.getAttribute("innerText").equals(name))
                .forEach(menuItem -> {
                    Actions action = new Actions(webDriver);
                    action.moveToElement(menuItem).perform();
                });

        return this;
    }

    /**
     * Click sub menu item by name menu component.
     *
     * @param name the name
     * @return the menu component
     */
    public MenuComponent clickSubMenuItemByName(String name) {

        getMenuItems().stream()
                .filter(menuItem -> menuItem.getAttribute("innerText").equals(name))
                .findFirst()
                .ifPresent(WebElement::click);
        return this;
    }

}
