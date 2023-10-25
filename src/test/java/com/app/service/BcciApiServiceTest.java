package com.app.service;

import com.app.model.swagger.Student;
import com.app.property.BcciProp;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
class BcciApiServiceTest {
    private final MockWebServer mockWebServer = new MockWebServer();
    @Mock
    private BcciProp bcciProp;
    @InjectMocks
    private BcciApiService apiCaller;


    @BeforeEach
    void setUp() {
       apiCaller =  new BcciApiService(bcciProp, WebClient.create(mockWebServer.url("/").toString()));
    }

    @AfterEach
    void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    void getBooks() {
        mockWebServer.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .setBody("{\"id\": \"value for y\", \"lastName\": 789}")
        );
        Student s = apiCaller.getBooks();
        System.out.println("s = " + s);

    }
}