package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

import static org.junit.jupiter.api.Assertions.assertEquals;

import pages.DashboardPage;
import pages.MioSignInPage;

import static com.codeborne.selenide.Selenide.open;

@Log4j2
@Scope("cucumber-glue")
@RequiredArgsConstructor
public class MioSignInPageStepDef {
    private final MioSignInPage mioSignInPage;
    private final DashboardPage dashboardPage;

    @Value("${mio_sign_in_base_website_url}")
    private String mioHomepageUrl;
    @Value("${mio_username}")
    private String mioUserName;
    @Value("${mio_password}")
    private String mioUserPassword;
    @Value("${mio_dashboard_url}")
    private String mioDashboardUrl;

    @Given("User is on the MIO Sign In page")
    public void user_is_on_the_mio_sign_in_page() {
        open(mioHomepageUrl);
    }
    @Given("User is registered and signed into MIO")
    public void user_is_registered_and_signed_in() {
        user_is_on_the_mio_sign_in_page();
        user_signs_in_with_their_mio_username_and_password();
        user_is_signed_in_successfully();
    }

    @When("User signs in with their MIO username and password")
    public void user_signs_in_with_their_mio_username_and_password() {
        mioSignInPage.inputEmailAddress(mioUserName);
        mioSignInPage.inputPassword(mioUserPassword);
        mioSignInPage.clickSignIn();
    }

    @Then("User is signed into MIO successfully")
    public void user_is_signed_in_successfully() {
        assertEquals(mioDashboardUrl, dashboardPage.getPageUrl(),
                "This user has not been logged in successfully");
    }

}
