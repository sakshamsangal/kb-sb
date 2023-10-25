package com.app.bcci.service;

import com.app.model.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@Slf4j
@Service
public class BookService {
    public Student addStud(Student student) {
        String url = "https://jsonplaceholder.typicode.com/posts";

        WebClient webClient = WebClient.create();
        return webClient.post()
                .uri(url)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(Student.class)
                .block();
    }
}
