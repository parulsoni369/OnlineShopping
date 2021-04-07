package OnlineShoppingPackage.Pages;
import OnlineShoppingPackage.Utils.GenericMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoriesTab {
    WebDriver driver;

    //Finding elements on page:-
    @FindBy(xpath = "//*[@id='block_top_menu']//a[@title='Women']")
    private WebElement womenCategoryTab;

    @FindBy(xpath = "//*[@id='center_column']//img[@title='Faded Short Sleeve T-shirts']")
    private WebElement tShirtItem;

    @FindBy(xpath = "//*[@id='center_column']//li[1]//a[@title='Add to cart']/span")
    private WebElement tShirtAddToCartLink;

    @FindBy(xpath = "//*[@id='center_column']//li[5]//img[@title='Printed Summer Dress']")
    private WebElement dressItem;

    @FindBy(xpath = "//*[@id='center_column']//li[5]//a[@title='Add to cart']/span")
    private WebElement dressAddToCartLink;

    @FindBy(xpath = "//*[@id='layer_cart']//span[@title='Continue shopping']/span")
    private WebElement continueButtonOnPopUpLink;

    @FindBy(xpath = "//*[@id='layer_cart']//a[@title='Proceed to checkout']/span")
    private WebElement ProceedToCheckoutButton;

    // Constructor to initialize elements
    public CategoriesTab(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    //Action methods on Page:-
    public CategoriesTab clickOnWomenTab()
    {
        GenericMethods.waitForElement(womenCategoryTab);
        GenericMethods.clickElement(womenCategoryTab);
        return this;
    }

    public CategoriesTab hoverToTShirt() {
        GenericMethods.scrollByElement(tShirtItem);
        GenericMethods.hoverToElement(tShirtItem);
        return this;
    }

    public CategoriesTab clickOntShirtAddToCart()
    {
        GenericMethods.waitForElement(tShirtAddToCartLink);
        GenericMethods.clickElement(tShirtAddToCartLink);
        return this;
    }

    public CategoriesTab clickOnContinueButton()
    {
        GenericMethods.waitForElement(continueButtonOnPopUpLink);
        GenericMethods.clickElement(continueButtonOnPopUpLink);
        return this;
    }

    public CategoriesTab hoverToDress()
    {
        GenericMethods.scrollByElement(dressItem);
        GenericMethods.hoverToElement(dressItem);
        return this;
    }

    public CategoriesTab clickOnDressAddToCart()
    {
        GenericMethods.waitForElement(dressAddToCartLink);
        GenericMethods.clickElement(dressAddToCartLink);
        return this;
    }

    public CategoriesTab ProceedToCheckoutButtonClick()
    {
        GenericMethods.waitForElement(ProceedToCheckoutButton);
        GenericMethods.clickElement(ProceedToCheckoutButton);
        return this;
    }
}
