package stepdefinition.config;

import com.codeborne.selenide.Configuration;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.PostConstruct;

@Log4j2
@CucumberContextConfiguration
@ContextConfiguration(classes = {SpringIntegrationTestConfig.class})
@ComponentScan(basePackages = {"pages","helpers"})
@Import({PropertiesConfig.class})
public class SpringIntegrationTestConfig {

    @Value("${mio_sign_in_base_website_url}")
    private String mioBaseWebsiteUrl;

    @PostConstruct
    public void init() {
        Configuration.baseUrl = mioBaseWebsiteUrl;
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
