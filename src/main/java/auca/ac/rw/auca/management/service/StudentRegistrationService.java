package auca.ac.rw.auca.management.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auca.ac.rw.auca.management.model.Semester;
import auca.ac.rw.auca.management.model.Student;
import auca.ac.rw.auca.management.model.StudentRegistration;
import auca.ac.rw.auca.management.repository.ISemesterRepository;
import auca.ac.rw.auca.management.repository.IStudentRegistrationRepository;
import auca.ac.rw.auca.management.repository.IStudentRepository;

@Service
public class StudentRegistrationService {

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private IStudentRegistrationRepository registrationRepository;

    @Autowired
    private ISemesterRepository semesterRepository;

    public String saveStudentRegistration(StudentRegistration registration, UUID student, UUID semester) {

        Optional<Student> studentCheck = studentRepository.findById(student);

        Optional<Semester> semesterCheck = semesterRepository.findById(semester);

        StudentRegistration registrationCheck = registrationRepository.findByStudentAndSemester(studentCheck.get(),
                semesterCheck.get());
        if (registrationCheck != null) {
            registration.setStudent(studentCheck.get());
            registration.setSemester(semesterCheck.get());

        }

        return "";

    }
}
