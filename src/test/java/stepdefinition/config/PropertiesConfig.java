package stepdefinition.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.Collection;


@Slf4j
@Configuration
@PropertySources({
    @PropertySource("/config/config.properties"),
})
public class PropertiesConfig {

    @EventListener
    public void handleContextRefreshed(ContextRefreshedEvent event) {
        ConfigurableEnvironment env = (ConfigurableEnvironment) event.getApplicationContext().getEnvironment();
        env.getPropertySources()
           .stream()
           .filter(ps -> ps instanceof MapPropertySource)
           .map(ps -> ((MapPropertySource) ps).getSource().keySet())
           .flatMap(Collection::stream)
           .distinct()
           .sorted()
           .forEach(key -> {
               String value;
               try {
                   value = StringUtils.abbreviate(env.getProperty(key), 1000);
               } catch (Exception e) {
                   value = "ERROR: " + e.getClass().getName() + ": " + e.getLocalizedMessage();
               }
               log.debug("{}={}", key, value);
           });
    }
}
