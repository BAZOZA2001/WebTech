package auca.ac.rw.auca.management.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import auca.ac.rw.auca.management.model.Semester;

@Repository
public interface ISemesterRepository extends JpaRepository<Semester, UUID> {

}
