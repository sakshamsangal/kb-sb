package com.app.service;


import com.app.bcci.service.AddStudent;
import com.app.exception.AppException;
import com.app.model.ApplicationResponse;
import com.app.model.Student;
import com.app.persistence.entity.StudentEntity;
import com.app.persistence.repo.StudentRepository;
import com.app.util.constant.ErrorMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final AddStudent student;
    private final StudentRepository studentRepository;

    public ApplicationResponse addStudent(Student stud) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirstName(stud.getFirstName());


//        if (StringUtils.equals(stud.getFirstName(), "1")) {
//            throw new AppException("NOT_FOUND", ErrorMessage.msg1, HttpStatus.ACCEPTED);
//        }
//        if (StringUtils.equals(stud.getFirstName(), "2")) {
//            throw new AppException("BAD_REQUEST", ErrorMessage.msg2, HttpStatus.BAD_REQUEST);
//        }
//        if (StringUtils.equals(stud.getFirstName(), "3")) {
//            throw new AppException("INTERNAL_SERVER_ERROR", ErrorMessage.msg3, HttpStatus.ALREADY_REPORTED);
//        }

        Student student1 = student.addStud(stud);

        studentRepository.save(studentEntity);
        return new ApplicationResponse(student1.getId());
    }
}