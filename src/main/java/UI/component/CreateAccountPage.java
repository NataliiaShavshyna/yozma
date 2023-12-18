package UI.component;

import UI.component.general.WebEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.StringGenerator;

/**
 * The type Create account page.
 */
public class CreateAccountPage extends WebEntity {

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public WebElement getFirstName() {
        return webDriver.findElement(By.xpath("//input[@name='firstname']"));
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public WebElement getLastName() {
        return webDriver.findElement(By.xpath("//input[@name='lastname']"));
    }

    /**
     * Gets email fild.
     *
     * @return the email fild
     */
    public WebElement getEmailFild() {
        return webDriver.findElement(By.xpath("//input[@name='email']"));
    }

    /**
     * Gets password field.
     *
     * @return the password field
     */
    public WebElement getPasswordField() {
        return webDriver.findElement(By.xpath("//input[@name='password']"));
    }

    /**
     * Gets confirm password field.
     *
     * @return the confirm password field
     */
    public WebElement getConfirmPasswordField() {
        return webDriver.findElement(By.xpath("//input[@name='password_confirmation']"));
    }

    /**
     * Gets create account button.
     *
     * @return the create account button
     */
    public WebElement getCreateAccountButton() {
        return webDriver.findElement(By.xpath("//button[@title='Create an Account']"));
    }

    /**
     * Create account.
     */
    public void createAccount() {
        getFirstName().sendKeys(StringGenerator.randomAlpha(10));
        getLastName().sendKeys(StringGenerator.randomAlpha(10));
        getEmailFild().sendKeys(StringGenerator.randomEmail());
        String password = StringGenerator.randomAlphaNumeric(10);
        getPasswordField().sendKeys(password);
        getConfirmPasswordField().sendKeys(password);
        getCreateAccountButton().click();
    }
}
