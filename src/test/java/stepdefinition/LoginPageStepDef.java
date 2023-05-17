package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import pages.HomePage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@Log4j2
@Scope("cucumber-glue")
@RequiredArgsConstructor
public class LoginPageStepDef {

    private final LoginPage loginPage;
    private final HomePage homePage;

    @Value("${user_email}")
    private String email;
    @Value("${user_password}")
    private String password;
    @Value("${homepage.url}")
    private String homepageUrl;
    @Value("${base_website_url}en_gb/")
    private String baseWebPageUrl;
    @Value("${login.url}help#")
    private String helpPageUrl;

    @Given("User enters a valid username and password")
    public void userEntersValidUsernameAndPassword() {
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
    }

    @Given("User enters an invalid {string} and {string}")
    public void userEntersInvalidCredentials(String email, String password) {
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
    }

    @Then("User should see an error message on the Login Page indicating {string}")
    public void userShouldSeeLoginErrorMessage(String errorMessage) {
        assertEquals(errorMessage, loginPage.getLoginErrorMessage(), "Login Error Message has NOT been displayed successfully!");
    }

    @Then("User should see an error message on the Login Help Page indicating {string}")
    public void userShouldSeePwdResetErrorMessage(String errorMessage) {
        assertEquals(errorMessage, loginPage.getPasswordResetErrorMessage(), "Password Reset Message Error has NOT been displayed successfully!");
    }

    @When("User clicks on the login button")
    public void userClicksOnTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @When("User clicks on the Need Help Link")
    public void userClicksOnTheNeedHelpLink() {
        loginPage.clickNeedHelpLink();
    }

    @Then("User should be redirected to the password reset page")
    public void userIsRedirectedToResetPasswordPage() {
        assertEquals(helpPageUrl, loginPage.getHelpPageUrl(), "Help Page has NOT been displayed successfully!");
    }

    @Then("User should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
        assertEquals(homepageUrl, homePage.getHomePageUrl(), "User has not been logged in successfully");
    }

    @And("User clicks on the user navigation bar")
    public void userClickUserMenuNav() {
        homePage.clickUserMenuNav();
    }

    @Then("User can logout successfully")
    public void userLogOut() {
        homePage.clickLogOut();
        assertEquals(baseWebPageUrl, homePage.getBasePageUrl(), "User has not been logged out successfully");
    }

    @When("User clicks the password reset button")
    public void userClicksPwdResetBtn() {
        loginPage.clickPasswordResetBtn();
    }
}
