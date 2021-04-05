package OnlineShoppingPackage.Pages;

import OnlineShoppingPackage.Utils.GenericMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOrderPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id='center_column']//a[@title='Proceed to checkout']/span")
    private WebElement SummaryTabCheckoutButton;

    @FindBy(xpath = "//*[@id='center_column']//button/span[text()='Proceed to checkout']")
    private WebElement AddressTabCheckoutButton;

    @FindBy(xpath = "//*[@id='cgv']")
    private WebElement termsOfServiceCheckbox;

    @FindBy(xpath = "//*[@id='form']/p/button/span")
    private WebElement shippingTabCheckoutButton;

    @FindBy(xpath = "//*[@id='HOOK_PAYMENT']//a[@class='bankwire']")
    private WebElement payByBankWireButtonOnPaymentTab;

    @FindBy(xpath = "//*[@id='cart_navigation']/button/span[text()='I confirm my order']")
    private WebElement confirmOrderButtonOnPaymentTab;

    @FindBy(xpath = "//*[@id='center_column']/div/p[@class='cheque-indent']/strong")
    private WebElement textOnOrderConfirmation;

    public CheckoutOrderPage(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    public CheckoutOrderPage ClickOnSummaryTabCheckoutButton() {
        GenericMethods.scrollByElement(SummaryTabCheckoutButton);
        GenericMethods.waitForElement(SummaryTabCheckoutButton);
        GenericMethods.clickElement(SummaryTabCheckoutButton);
        return this;
    }
    public CheckoutOrderPage ClickOnAddressTabCheckoutButton() {
        GenericMethods.scrollByElement(AddressTabCheckoutButton);
        GenericMethods.waitForElement(AddressTabCheckoutButton);
        GenericMethods.clickElement(AddressTabCheckoutButton);
        return this;
    }

    public CheckoutOrderPage selectTermsOfServiceCheckBox() {
        GenericMethods.scrollByElement(termsOfServiceCheckbox);
        GenericMethods.waitForElement(termsOfServiceCheckbox);
        GenericMethods.selectCheckbox(termsOfServiceCheckbox);
        return this;
    }

    public CheckoutOrderPage ClickOnShippingTabCheckoutButton() {
        GenericMethods.scrollByElement(shippingTabCheckoutButton);
        GenericMethods.waitForElement(shippingTabCheckoutButton);
        GenericMethods.clickElement(shippingTabCheckoutButton);
        return this;
    }

    public CheckoutOrderPage ClickOnPayByBankWire() {
        GenericMethods.scrollByElement(payByBankWireButtonOnPaymentTab);
        GenericMethods.waitForElement(payByBankWireButtonOnPaymentTab);
        GenericMethods.clickElement(payByBankWireButtonOnPaymentTab);
        return this;
    }

    public CheckoutOrderPage ClickOnConfirmOrderButtonOnPaymentTab() {
        GenericMethods.scrollByElement(confirmOrderButtonOnPaymentTab);
        GenericMethods.waitForElement(confirmOrderButtonOnPaymentTab);
        GenericMethods.clickElement(confirmOrderButtonOnPaymentTab);
        return this;
    }

    public CheckoutOrderPage assertTextOnOrderConfirmation(String expectedText)
    {
        GenericMethods.scrollByElement(textOnOrderConfirmation);
        GenericMethods.assertTextValues(expectedText, GenericMethods.getText(textOnOrderConfirmation));
        return this;
    }
}
