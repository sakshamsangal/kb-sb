package com.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is a controller class
 */
@RestController
@RequestMapping("/v1")
@Slf4j
public class PersonController {


    @GetMapping("/persons")
    ResponseEntity<String> getPersons() {
        log.info("getPersons");
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body("Custom header set");
    }


    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

}

