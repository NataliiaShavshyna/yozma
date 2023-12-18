package UI.component;

import UI.component.general.WebEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import schemas.ShipmentInfo;
import utils.StringGenerator;

import java.util.List;

/**
 * The type Shipping page.
 */
public class ShippingPage extends WebEntity {
    /**
     * Gets next button.
     *
     * @return the next button
     */
    public WebElement getNextButton() {
        return webDriver.findElement(By.xpath("//button[@class='button action continue primary']"));
    }

    /**
     * Gets email field.
     *
     * @return the email field
     */
    public WebElement getEmailField() {
        WebElement element = webDriver.findElement(By.xpath("//input[@type='email']"));
        return element;
    }

    /**
     * Enter value to email.
     *
     * @param text the text
     */
    public void enterValueToEmail(String text) {
       WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.id("checkout-loader"),0));


        JavascriptExecutor jexe = (JavascriptExecutor) webDriver;
        jexe.executeScript(String.format("document.getElementById('customer-email').focus();"));
        webDriver.findElement(By.id("customer-email")).click();

        jexe.executeScript(String.format("document.getElementById('customer-email').value='%s';", text));
        webDriver.findElement(By.id("customer-email")).sendKeys("m");
        jexe.executeScript(String.format("document.getElementById('customer-email').blur();"));

/*
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@class='fieldset']"),3));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("customer-email")));

        webDriver.findElement(By.id("customer-email")).click();
        webDriver.findElement(By.id("customer-email")).sendKeys("m");*/

    }

    /**
     * Gets name first field.
     *
     * @return the name first field
     */
    public WebElement getNameFirstField() {
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='firstname']")));

        return webDriver.findElement(By.xpath("//input[@name='firstname']"));
///div[@class='loading-mask']"
    }

    /**
     * Gets name lastt field.
     *
     * @return the name lastt field
     */
    public WebElement getNameLasttField() {
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='lastname']")));

        return webDriver.findElement(By.xpath("//input[@name='lastname']"));

    }

    /**
     * Gets street address field.
     *
     * @return the street address field
     */
    public WebElement getStreetAddressField() {
        return webDriver.findElement(By.xpath("//input[@name='street[0]']"));

    }

    /**
     * Gets city field.
     *
     * @return the city field
     */
    public WebElement getCityField() {
        return webDriver.findElement(By.xpath("//input[@name='city']"));

    }

    /**
     * Gets postal code field.
     *
     * @return the postal code field
     */
    public WebElement getPostalCodeField() {
        return webDriver.findElement(By.xpath("//input[@name='postcode']"));

    }

    /**
     * Gets country.
     *
     * @return the country
     */
    public WebElement getCountry() {
        return webDriver.findElement(By.xpath("//select[@name='country_id']"));
    }

    /**
     * Gets region.
     *
     * @return the region
     */
    public WebElement getRegion() {
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='region_id']")));
        return webDriver.findElement(By.xpath("//select[@name='region_id']"));
    }

    /**
     * Gets phone number field.
     *
     * @return the phone number field
     */
    public WebElement getPhoneNumberField() {
        return webDriver.findElement(
                By.xpath("//input[@name='telephone']"));
    }

    /**
     * Gets shipping method.
     *
     * @return the shipping method
     */
    public WebElement getShippingMethod() {
        return webDriver.findElement(
                By.xpath("//input[contains(@name,'ko_unique_')]"));
    }

    /**
     * State item random web element.
     *
     * @return the web element
     */
    public WebElement stateItemRandom() {
        return webDriver.findElement(By.xpath(
                String.format("//option[@value='%d']", Integer.valueOf(StringGenerator.randomNumeric(1)))));
    }

    /**
     * Wait until page loaded.
     */
    public void waitUntilPageLoaded() {
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.name("firstname"), 1));
    }

    /**
     * Create shipment shipment info.
     *
     * @return the shipment info
     */
    public ShipmentInfo createShipment() {
        ShipmentInfo shipmentInfo = new ShipmentInfo();
        shipmentInfo.setEmail(StringGenerator.randomEmail());
        enterValueToEmail(shipmentInfo.getEmail());
        shipmentInfo.setFirstName(StringGenerator.randomAlpha(10));
        getNameFirstField().sendKeys(shipmentInfo.getFirstName());
        shipmentInfo.setEmail(StringGenerator.randomEmail());
        shipmentInfo.setLastName(StringGenerator.randomAlpha(10));
        getNameLasttField().sendKeys(shipmentInfo.getLastName());
        shipmentInfo.setStreet(StringGenerator.randomAlpha(10));
        getStreetAddressField().sendKeys(shipmentInfo.getStreet());
        getRegion().click();
        stateItemRandom().click();
        shipmentInfo.setRegion(getRegion().getText());
        shipmentInfo.setCity(StringGenerator.randomAlpha(10));
        getCityField().sendKeys(shipmentInfo.getCity());
        shipmentInfo.setPostalCode(StringGenerator.randomNumeric(5));
        getPostalCodeField().sendKeys(shipmentInfo.getPostalCode());
        shipmentInfo.setPhoneNumber(StringGenerator.randomNumeric(7));
        getPhoneNumberField().sendKeys(shipmentInfo.getPhoneNumber());
        getShippingMethod().click();

        getNextButton().click();


        return shipmentInfo;
    }

    public void validateHttpRequestForOrder(ShipmentInfo shipmentInfo) {
        if (webDriver.getClass().getName().contains("chrome")) {
            List<String> logMessages = StringGenerator.performanceLogMessages(webDriver);
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(logMessages.stream().filter(p -> p.contains(shipmentInfo.getFirstName())).count() > 0);
            softAssert.assertTrue(logMessages.stream().filter(p -> p.contains(shipmentInfo.getLastName())).count() > 0);
            softAssert.assertTrue(logMessages.stream().filter(p -> p.contains(shipmentInfo.getCity())).count() > 0);
            softAssert.assertTrue(logMessages.stream().filter(p -> p.contains(shipmentInfo.getRegion())).count() > 0);
            softAssert.assertTrue(logMessages.stream().filter(p -> p.contains(shipmentInfo.getStreet())).count() > 0);
        }
    }


}
