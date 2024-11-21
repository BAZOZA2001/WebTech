package auca.ac.rw.auca.management.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import auca.ac.rw.auca.management.model.AcademicUnit;

@Repository
public interface IAcedemicUnitRepository
        extends JpaRepository<AcademicUnit, UUID> {
    Boolean existsByAcademicCode(String academicCode);

    Optional<AcademicUnit> findByAcademicCode(String code);
}
