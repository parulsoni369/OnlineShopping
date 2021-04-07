package OnlineShoppingPackage.Pages;
import OnlineShoppingPackage.Utils.GenericMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    //Finding elements on page:-
    @FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")
    private WebElement homePageSignInLink;

    @FindBy(xpath = "//*[@id='email']")
    private WebElement emailUsername;

    @FindBy(xpath = "//*[@id='passwd']")
    private WebElement emailPassword;

    @FindBy(xpath = "//*[@id='SubmitLogin']/span")
    private WebElement SignInButton;

    // Constructor to initialize elements
    public HomePage(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    //Action methods on Page:-
    public HomePage ClickOnSignInLink() {
        GenericMethods.waitForElement(homePageSignInLink);

        GenericMethods.clickElement(homePageSignInLink);
        return this;
    }

     public HomePage EnterUsername(String username)
     {
         GenericMethods.waitForElement(emailUsername);
         GenericMethods.sendKeys(emailUsername, username);
         return this;
     }

    public HomePage EnterPassword(String password)
    {
        GenericMethods.waitForElement(emailPassword);
        GenericMethods.sendKeys(emailPassword, password);
        return this;
    }

    public HomePage ClickOnSignInButton()
    {
        GenericMethods.waitForElement(SignInButton);
        GenericMethods.clickElement(SignInButton);
        return this;
    }


}
