package UI.component;

/**
 * Entry point class containing se of static methods for retrieving objects for UI pages classes.
 */
public class Pages {
    private Pages() {
    }

    /**
     * Home page home page.
     *
     * @return the home page
     */
    public static HomePage homePage() {
        return new HomePage();
    }

    /**
     * Catalog page catalog page.
     *
     * @return the catalog page
     */
    public static CatalogPage catalogPage() {
        return new CatalogPage();
    }
}