package auca.ac.rw.auca.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import auca.ac.rw.auca.management.model.Student;
import auca.ac.rw.auca.management.service.StudentService;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/saveStudent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {
        String saveStudent = studentService.saveStudent(student);
        if (saveStudent.equalsIgnoreCase("student exists")) {
            return new ResponseEntity<>(saveStudent, HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(saveStudent, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/getStudent", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getStudentByFirstName(@RequestParam String firstName) {
        Student student = studentService.getStudentByFirstName(firstName);
        if (student == null) {
            return new ResponseEntity<>("No student found with the given first name", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/studentsbyfirstnameandlastname", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findByFirstNameAndLastName(@RequestParam String firstName,
            @RequestParam String lastName) {

        Student getStudent = studentService.findStudentByFirstNameAndLastName(firstName, lastName);
        if (getStudent != null) {
            return new ResponseEntity<>(getStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No student found with the given first name and last name",
                    HttpStatus.NOT_FOUND);
        }
    }
}
