import UI.component.*;
import org.testng.annotations.Test;
import schemas.ShipmentInfo;
import utils.FileOperations;

/**
 * The type Test required.
 */
public class TestRequired extends BaseTest {

    /**
     * Test full flow.
     */
    @Test
    public void testFullFlow() {

        HomePage.homePage().navigateTo("https://magento.softwaretestingboard.com/");
        MenuComponent menu = new MenuComponent();
        menu.waitUntilMenuLoaded();

        menu.getMenu().hoverMenuItemByName("Gear").clickSubMenuItemByName("Bags");
        CatalogPage catalog = new CatalogPage();
        catalog.waitUntilPageLoaded();
        //catalog.hoverHoverRandomCard();
        catalog.clickRandomCard();
        ProductDetailsPage pdp = new ProductDetailsPage();
        pdp.waitUntilPageLoaded();
        pdp.getAddToCardButton().click();
        Header header = new Header();
        header.waitUntilCartIsNotEmpty();
        header.cart().click();
        CardPreviewPopUp cardPreviewPopUp = new CardPreviewPopUp();
        cardPreviewPopUp.proceedToCheckout().click();

        ShippingPage shippingPage = new ShippingPage();
        shippingPage.waitUntilPageLoaded();
        ShipmentInfo shipmentInfo = shippingPage.createShipment();
        shippingPage.validateHttpRequestForOrder(shipmentInfo);

        ReviewAndPayments reviewAndPayments = new ReviewAndPayments();
        reviewAndPayments.waitUntilPageLoaded();
        reviewAndPayments.placeOrderButtonClick();
        PurchasePage purchasePage = new PurchasePage();
        purchasePage.waitUntilPageIsLoaded();
        purchasePage.orderNumberLabel();
        FileOperations.writeToFile(purchasePage.orderNumberLabel(),"test_data.txt");

    }
}
