package com.app.service;


import com.app.model.dto.ApplicationResponse;
import com.app.model.dto.Student;
import com.app.persistence.entity.StudentEntity;
import com.app.persistence.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;
    public ApplicationResponse addStudent(Student stud) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirstName(stud.getFirstName());
        studentRepository.save(studentEntity);
        return new ApplicationResponse("saksham");
    }
}