package steps;

import common.Context;
import common.PageManager;
import common.ScenarioContext;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.BaseTest;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps extends BaseTest {

    PageManager pageManager = new PageManager();
    ScenarioContext scenarioContext = new ScenarioContext();


    @Given("Open the web site")
    public void open_the_web_site() {
        pageManager.loginPage.open();
    }

    @When("Enter {string} and {string} and click login button")
    public void fillLoginCredentialsAndClickLogin(String username, String password) {
        pageManager.loginPage.login(username,password);
    }

    @Then("Login successfully")
    public void loginSuccessfully() throws InterruptedException {
        assertThat(pageManager.homePage.getUrl()).contains("inventory");
    }

    @Then("Getting error as {string}")
    public void gettingErrorAs(String errorText) {
        assertThat(pageManager.loginPage.lblLoginError.getText()).isEqualTo(errorText);
    }

    @When("Enter user credentials from table")
    public void enterLoginCredentials(DataTable dataTable){
        String username = null;
        String password = null;
        List<Map<String, String>> data =dataTable.asMaps(String.class, String.class);
        for(Map<String, String> form : data){
            username = form.get("username");
            password = form.get("password");
        }
        pageManager.loginPage.login(username,password);
    }

    @When("I set scenario context value {string}")
    public void iSetScenarioContextValue(String value) {
        scenarioContext.setContext(Context.ID, value);
    }
    @Then("I use scenario context value")
    public void iUseScenarioContextValue() {
        String sharedValue = scenarioContext.getContext(Context.ID).toString();
        System.out.println(sharedValue);
    }

    @When("Get data on file and login and Getting error")
    public void getDataOnFileAndLogin() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String,String>> userList = mapper.readValue(new FileReader("src/test/resources/datas/user.json"), List.class);
        for (Map<String,String> user: userList) {
            pageManager.loginPage.login(user.get("username"),user.get("password"));
            assertThat(pageManager.loginPage.lblLoginError.isDisplayed()).isTrue();
        }
    }

    @When("User click google account")
    public void userClickGoogleAccount() {

    }

    @Then("Social Media Login page open")
    public void socialMediaLoginPageOpen() {

    }

    @When("User input credentials")
    public void userInputCredentials() {
    }

    @Then("Product list container is shown")
    public void productListContainerIsShown() {
        assertThat(pageManager.homePage.listProductContainer.isDisplayed()).isTrue();
    }

    @When("Click {string} button on Product Page")
    public void clickButton(String btnText) {
        pageManager.homePage.clickButton(btnText);
    }

    @Then("Check {string} button is shown")
    public void checkButtonIsShown(String btnText) {
        switch (btnText){
            case "remove":
                assertThat(pageManager.homePage.btnRemoveCartSauceLabsBackpack.isDisplayed()).isTrue();
                break;
            case "add to cart":
                assertThat(pageManager.homePage.btnAddCartSauceLabsBackpack.isDisplayed()).isTrue();
                break;
            default:
                throw new Error("Button not found");
        }
    }
}