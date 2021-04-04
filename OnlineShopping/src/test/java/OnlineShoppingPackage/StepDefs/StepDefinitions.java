package OnlineShoppingPackage.StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
    @Given("Login as TL")
    public void loginAsTL() {
        System.out.println("Print1");
    }

    @When("I upload data into quantum")
    public void iUploadDataIntoQuantum() {
        System.out.println("Print2");
    }

    @Then("case should be created")
    public void caseShouldBeCreated() {
        System.out.println("Print3");
    }
}
