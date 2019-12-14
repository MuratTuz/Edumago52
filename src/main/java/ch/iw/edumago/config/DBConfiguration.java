package ch.iw.edumago.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@SuppressWarnings("unused")
public class DBConfiguration {

    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    public String devDatabasConfiguration(){
        System.out.println(".....DEVELOPMENT.....");
        return "Running dev configuration";
    }

    @Profile("prod")
    @Bean
    public String prodDatabasConfiguration(){
        System.out.println(".....PRODUCTION.....");
        return "Running prod configuration";
    }

}
