package com.app.config;

import com.app.property.BcciProp;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class BcciConfig {

    private final BcciProp bcciProp;

    /**
     * This is the bean for WebClient
     * WebClient is used to call client APIs
     *
     * @return WebClient
     */
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(bcciProp.getGetAllBooks())
                .build();
    }

}
