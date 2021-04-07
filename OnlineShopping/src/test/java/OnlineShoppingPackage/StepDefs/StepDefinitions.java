package OnlineShoppingPackage.StepDefs;

import OnlineShoppingPackage.Pages.CategoriesTab;
import OnlineShoppingPackage.Pages.CheckoutOrderPage;
import OnlineShoppingPackage.Pages.HomePage;
import OnlineShoppingPackage.Utils.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class StepDefinitions {

    //Initializing different page objects:-
    WebDriver driver = DriverManager.get();
    HomePage homePG = new HomePage(driver);
    CategoriesTab womenCategory = new CategoriesTab(driver);
    CheckoutOrderPage checkoutOrder = new CheckoutOrderPage(driver);

    //Steps start here:-
    @Given("Login as Customer to Shopping url with {string} and {string}")
    public void loginAsCustomerToShoppingUrlWithAnd(String username, String password) {
        homePG.ClickOnSignInLink();
        homePG.EnterUsername(username);
        homePG.EnterPassword(password);
        homePG.ClickOnSignInButton();
    }

    @When("I click on the Women tab")
    public void iClickOnTheWomenTab()
    {
        womenCategory.clickOnWomenTab();
    }

    @And("Scroll down and select T-Shirt and Add To Cart")
    public void scrollDownAndSelectTShirtAndAddToCart() {
        womenCategory.hoverToTShirt();
        womenCategory.clickOntShirtAddToCart();
        womenCategory.clickOnContinueButton();
    }

    @And("Scroll down and select Dress and Add To Cart")
    public void scrollDownAndSelectDressAndAddToCart() {
        womenCategory.hoverToDress();
        womenCategory.clickOnDressAddToCart();
        womenCategory.ProceedToCheckoutButtonClick();
    }

    @Then("Proceed to Checkout and place Order")
    public void proceedToCheckoutAndPlaceOrder() {
        checkoutOrder.ClickOnSummaryTabCheckoutButton();
        checkoutOrder.ClickOnAddressTabCheckoutButton();
        checkoutOrder.selectTermsOfServiceCheckBox();
        checkoutOrder.ClickOnShippingTabCheckoutButton();
        checkoutOrder.ClickOnPayByBankWire();
        checkoutOrder.ClickOnConfirmOrderButtonOnPaymentTab();
    }

    @Then("Verify text for Order Confirmation is {string}")
    public void verifyTextForOrderConfirmationIs(String expectedText) {
        checkoutOrder.assertTextOnOrderConfirmation(expectedText);
    }
}
