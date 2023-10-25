package com.app.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.context.config.annotation.RefreshScope;


@Configuration
@Getter
@Setter
@RefreshScope
public class AppProp {


    @Value("${my.name}")
    private String myName;

}
