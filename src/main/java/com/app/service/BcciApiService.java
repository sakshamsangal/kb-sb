package com.app.service;

import com.app.model.Student;
import com.app.property.BcciProp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@Slf4j
@Service
public class BcciApiService {

    private final WebClient webClient;

    private final BcciProp bcciProp;

    public Student getBooks() {

        return webClient.post()
                .uri(bcciProp.getGetAllBooks())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(Student.class)
                .block();
    }
}