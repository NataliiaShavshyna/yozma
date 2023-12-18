package UI.component;

import UI.component.general.WebEntity;

/**
 * The type Home page.
 */
public class HomePage extends WebEntity {

    /**
     * Home page home page.
     *
     * @return the home page
     */
    public static HomePage homePage() {
        return new HomePage();
    }

    /**
     * Navigate to.
     *
     * @param url the url
     */
    public void navigateTo(String url) {
        webDriver.navigate().to(url);
    }

}
