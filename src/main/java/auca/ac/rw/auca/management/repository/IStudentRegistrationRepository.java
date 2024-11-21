package auca.ac.rw.auca.management.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import auca.ac.rw.auca.management.model.Semester;
import auca.ac.rw.auca.management.model.Student;
import auca.ac.rw.auca.management.model.StudentRegistration;

@Repository
public interface IStudentRegistrationRepository extends JpaRepository<StudentRegistration, UUID> {

    StudentRegistration findByStudentAndSemester(Student student, Semester semester);
}
