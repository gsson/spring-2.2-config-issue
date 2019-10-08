package se.fnord.configissue;

import lombok.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Value
@ConfigurationProperties("application")
class ApplicationConfiguration {
  private final String helloConfigKey;
}

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfiguration.class)
public class Main {
  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @Bean
  public RouterFunction<ServerResponse> routes(
      ApplicationConfiguration applicationConfiguration) {

    return RouterFunctions.route(RequestPredicates.GET("/"), r -> ServerResponse.ok()
        .bodyValue(String.format("%s%n",
            applicationConfiguration.getHelloConfigKey())));
  }
}
