package com.app.controller;

import com.app.model.ApplicationResponse;
import com.app.model.Student;
import com.app.service.StudentService;
import com.app.util.constant.Endpoint;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is a controller class
 */
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @PostMapping(Endpoint.ADD_STUDENT)
    public ResponseEntity<ApplicationResponse> addStudent(@RequestBody Student stud) {
         return ResponseEntity.ok()
                 .body(studentService.addStudent(stud));

    }
}

