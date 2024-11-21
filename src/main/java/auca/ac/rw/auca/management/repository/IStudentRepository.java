package auca.ac.rw.auca.management.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import auca.ac.rw.auca.management.model.Student;
import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student, UUID> {

    Optional<Student> findByFirstNameAndLastName(String firstName, String lastName);

    Optional<Student> findByFirstName(String firstName);

    List<Student> findByLastName(String lastName);
}
