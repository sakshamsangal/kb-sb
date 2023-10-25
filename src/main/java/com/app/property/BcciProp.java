package com.app.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;


@Getter
@Setter
@RefreshScope
@Configuration
public class BcciProp {


    @Value("${bcci.get.all.books}")
    private String getAllBooks;

}
