package stepdefinition;

import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Value;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationStepDef {

    @Value("${login.url}")
    private String loginUrl;

    @Given("User is on the Hudl login page")
    public void userIsOnLoginScreen() {
        open(loginUrl);
    }
}
