package com.app.controller;

import com.app.config.AppYml;
import com.app.model.ApplicationResponse;
import com.app.model.Student;
import com.app.service.StudentService;
import com.app.util.constant.Endpoint;
import io.micrometer.observation.annotation.Observed;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Properties;

/**
 * This is a controller class
 */
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@Slf4j
public class StudentController implements StudentControllerApi {

    private final StudentService studentService;
    private final AppYml appYml;

    @PostMapping(Endpoint.ADD_STUDENT)
    @Observed(name = "studentController.addStudent")
    @Override
    public ResponseEntity<ApplicationResponse> addStudent(@Valid @RequestBody Student stud) {
         return ResponseEntity.ok()
                 .body(studentService.addStudent(stud));
    }


    @Observed(name = "get.micro")
    @GetMapping("/micro")
    public String micro() {
        return appYml.getMyName()+ " Welcome this endpoint is not secure";
    }
}

