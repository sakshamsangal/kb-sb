package com.app.service;


import com.app.aspect.LogExecutionTime;
import com.app.model.swagger.ApplicationResponse;
import com.app.model.swagger.Student;
import com.app.persistence.entity.StudentEntity;
import com.app.persistence.repo.StudentRepository;
import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final BcciApiService student;
    private final StudentRepository studentRepository;

    @LogExecutionTime("saksham")
    @Observed(name = "studentService.addStudent")
    public ApplicationResponse addStudent(Student stud) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirstName(stud.getFirstName());

//        Student student1 = student.addStud(stud);

        studentRepository.save(studentEntity);
        return null;
//        return new ApplicationResponse(student1.getId());
    }
}