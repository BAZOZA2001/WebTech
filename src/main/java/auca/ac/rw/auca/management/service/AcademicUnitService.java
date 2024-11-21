package auca.ac.rw.auca.management.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auca.ac.rw.auca.management.model.AcademicUnit;
import auca.ac.rw.auca.management.repository.IAcedemicUnitRepository;

@Service
public class AcademicUnitService {

    @Autowired
    private IAcedemicUnitRepository academicUnitRepository;

    public String saveAcademicUnit(AcademicUnit academicUnit) {

        if (academicUnitRepository.existsByAcademicCode(academicUnit.getAcademicCode())) {
            return "Academic Unit with that code already exists";
        }
        academicUnitRepository.save(academicUnit);
        return "Academic Unit saved successfully";
    }

    public String saveDepartmentOrFaculty(AcademicUnit unit, String code) {
        Optional<AcademicUnit> getParent = academicUnitRepository.findByAcademicCode(code);

        if (getParent.isPresent()) {
            if (academicUnitRepository.existsByAcademicCode(unit.getAcademicCode())) {
                return "Faculty or Department with that code is already exists";
            } else {
                unit.setAcademicUnit(getParent.get());
                academicUnitRepository.save(unit);
                return "Faculty or Department saved successfully";
            }
        } else {
            return "Parent with that code not found";
        }
    }
}
