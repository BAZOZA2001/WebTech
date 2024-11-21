package auca.ac.rw.auca.management.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auca.ac.rw.auca.management.model.Student;
import auca.ac.rw.auca.management.repository.IStudentRepository;

@Service
public class StudentService {

    @Autowired
    private IStudentRepository studentRepository;

    public String saveStudent(Student student) {

        Optional<Student> checkStudent = studentRepository.findByFirstNameAndLastName(student.getFirstName(),
                student.getLastName());

        if (checkStudent.isPresent()) {
            return "student exists";
        } else {
            studentRepository.save(student);
            return "student saved successfully";
        }

    }

    public Student getStudentByFirstName(String firstName) {
        Optional<Student> student = studentRepository.findByFirstName(firstName);
        if (student.isPresent()) {
            return student.get();
        } else {
            return null;
        }
    }

    public Student findStudentByFirstNameAndLastName(String firstName, String lastName) {
        Optional<Student> student = studentRepository.findByFirstNameAndLastName(
                firstName, lastName);
        if (student.isPresent()) {
            return student.get();
        } else {
            return null;
        }
    }

}
