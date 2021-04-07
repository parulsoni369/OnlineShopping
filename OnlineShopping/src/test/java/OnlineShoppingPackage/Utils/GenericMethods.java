package OnlineShoppingPackage.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class GenericMethods {
    private static final Logger log = LogManager.getLogger(GenericMethods.class);
    static String text = null;


    /**
     * Function to navigate to given address
     * @param url Address to navigate to
     */
    public static void navigateTo(String url){
        DriverManager.get().navigate().to(url);
        DriverManager.get().manage().window().maximize();
    }

    /**
     * Function to click Web element
     */
    public static void clickElement(WebElement element) {
        try {
            DriverManager.shortWait().until(ExpectedConditions.and(ExpectedConditions.visibilityOf(element),
                    ExpectedConditions.elementToBeClickable(element)));
            DriverManager.shortWait().until(ExpectedConditions.visibilityOf(element));
            element.click();
        } catch (TimeoutException | StaleElementReferenceException e) {

            log.error("Exception raised in clickElement : ", e);
            Assert.fail("The element is not present in the page");
        } catch (Exception e) {
            log.error("Exception raised in clickElement : ", e);
            Assert.fail("Failed to click the element");
        }
    }

    /**
     * Function to send keys to Web element
     */
    public static void sendKeys(WebElement element, String enterText) {
        try {
            //DriverManager.shortWait().until(ExpectedConditions.visibilityOf(element));
            element.click();
            element.sendKeys(enterText);
        } catch (TimeoutException | NoSuchElementException e) {

            log.error("Exception raised in sendKeys : ", e);
            Assert.fail("The element is not present in the page to enter the text");
        } catch (Exception e) {

            log.error("Exception raised in sendKeys : ", e);
            Assert.fail("Failed to enter text");
        }
    }

    /**
     * Function to get text of Web element
     */
    public static String getText(WebElement element) {
        try {
            DriverManager.shortWait().until(ExpectedConditions.visibilityOf(element));
            text = element.getText();
        } catch (NoSuchElementException e) {

            log.error("Exception raised in getText : ", e);
            Assert.fail("The element is not present in the page to get the text");
        } catch (Exception e) {

            log.error("Exception raised in getText : ", e);
            Assert.fail("Failed to fetch text");
        }
        return text;
    }

    /**
     * Function to clear text of Web element
     */
    public static void clearElement(WebElement element) {
        try {
            DriverManager.shortWait().until(ExpectedConditions.visibilityOf(element));
            element.clear();
        } catch (TimeoutException | NoSuchElementException e) {

            log.error("Exception raised in clearElement : ", e);
            Assert.fail("The element is not present in the page to clear text");
        } catch (Exception e) {

            log.error("Exception raised in clearElement : ", e);
            Assert.fail("Failed to clear text");
        }
    }

    /**
     * Function to select Web element by text
     */
    public static void selectByValue(WebElement element, String enterText) {
        try {
            DriverManager.shortWait().until(ExpectedConditions.textToBePresentInElement(element, enterText));
            Select s = new Select(element);
            s.selectByVisibleText(enterText);
        } catch (NoSuchElementException | StaleElementReferenceException e) {

            log.error("Exception raised in selectByValue : ", e);
            Assert.fail("The element is not present in the page to select the value");
        } catch (Exception e) {

            log.error("Exception raised in selectByValue : ", e);
            Assert.fail("Failed to select value from dropdown");
        }
    }

    /**
     * Function to assert Web element is displayed
     */
    public static boolean assertElementIsDisplayed(WebElement element) {
        try {
            DriverManager.mediumWait().until(ExpectedConditions.and(ExpectedConditions.visibilityOf(element)));
            Assert.assertTrue(isDisplayed(element));
        } catch (TimeoutException | NoSuchElementException e) {

            log.error("Exception raised in assertElementIsDisplayed : ", e);
            Assert.fail("The element is not present in the page");
            return false;
        } catch (Exception e) {

            log.error("Exception raised in assertElementIsDisplayed : ", e);
            Assert.fail("The element is not present in the page");
            return false;
        }
        return true;
    }

    /**
     * Function to assert Web element is displayed
     */
    public static boolean isDisplayed(WebElement element) {
        try {
            log.debug("Checking if element is displayed");
            element.isDisplayed();

            return true;
        } catch (Exception e) {

            log.debug("The element is not displayed");
            return false;
        }
    }

    /**
     * Function to get the title of web page
     */
    public static String getPageTitle(){
        try {
            log.debug("Fetching page title");
            String title = DriverManager.get().getTitle();
            log.debug("Page title is {}", title);
            return title;
        } catch (Exception e) {

            log.error("Exception raised in getPageTitle : ", e);
            Assert.fail("Failed to fetch page title");
            return null;
        }
    }

    /**
     * Function to get attribute of Web element
     */
    public static String getAttribute(WebElement element, String attributeName){
        log.debug("Fetching '{}' attribute from webElement", attributeName);
        String attribute = element.getAttribute(attributeName);
        log.debug("Attribute value is '{}'", attribute);
        return attribute;
    }

    /**
     * Function to select checkbox element
     */
    public static void selectCheckbox(WebElement element) {
        try {
            element.click();
        } catch (TimeoutException | NoSuchElementException e) {

            log.error("Exception raised in selectCheckbox : ", e);
            Assert.fail("The element is not present in the page to select");
        } catch (Exception e) {

            log.error("Exception raised in selectCheckbox : ", e);
            Assert.fail("Failed to select checkbox");
        }
    }

    /**
     * Function to wait for element to be visible on page
     */
    public static void waitForElement(WebElement element) {
        try {
            DriverManager.shortWait().until(ExpectedConditions.visibilityOfAllElements(element));
        } catch (java.util.NoSuchElementException e) {

            System.out.println("The element is not present in the page to click");
        } catch (Exception e) {

            System.out.println(e);
        }

    }

    /**
     * Function to scroll down by pixels
     */
    public static void scrollDownBy(String pixels)
    {
        WebDriver driver = DriverManager.get();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+pixels+")", "");
    }

    /**
     * Function to scroll up by pixels
     */
    public static void scrollUpBy(String pixels)
    {
        WebDriver driver = DriverManager.get();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-"+pixels+")", "");
    }

    /**
     * Function to scroll down to a particular element
     */
    public static void scrollByElement(WebElement element)
    {
        WebDriver driver = DriverManager.get();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    /**
     * Function to hover mouse on an element
     */
    public static void hoverToElement(WebElement element)
    {
        try{
        DriverManager.mediumWait().until(ExpectedConditions.and(ExpectedConditions.visibilityOf(element)));
        WebDriver driver = DriverManager.get();
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
         } catch (TimeoutException | NoSuchElementException e) {

        log.error("Exception raised in element not found : ", e);
        Assert.fail("The element is not present in the page");

         } catch (Exception e) {

        log.error("Exception raised in element not found : ", e);
        Assert.fail("The element is not present in the page");

        }
    }

    /**
     * Function to assert and compare two text values
     */
    public static void assertTextValues(String expectedValue, String actualValue) {

        try {

            Assert.assertEquals(expectedValue.toLowerCase(), actualValue.toLowerCase());
            log.info("Values match");
        } catch (AssertionError e) {
            Assert.fail("Values do not match");
        }

    }

}
