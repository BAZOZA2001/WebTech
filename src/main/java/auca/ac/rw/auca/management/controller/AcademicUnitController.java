package auca.ac.rw.auca.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import auca.ac.rw.auca.management.model.AcademicUnit;
import auca.ac.rw.auca.management.model.EAcademicUnitType;
import auca.ac.rw.auca.management.service.AcademicUnitService;

@RestController
@RequestMapping(value = "/academicunit")
public class AcademicUnitController {

    @Autowired
    private AcademicUnitService academicUnitService;

    @PostMapping(value = "/saveacademicunit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveAcademicUnit(@RequestBody AcademicUnit unit,
            @RequestParam(required = false) String code) {
        if (unit.getAcademicType().toString().equalsIgnoreCase("PROGRAMME")) {
            unit.setAcademicType(EAcademicUnitType.PROGRAMME);
        } else if (unit.getAcademicType().toString().equalsIgnoreCase("FACULTY")) {
            unit.setAcademicType(EAcademicUnitType.FACULTY);
        } else {
            unit.setAcademicType(EAcademicUnitType.DEPARTMENT);
        }

        if (code == null) {
            String saveAcademicUnit = academicUnitService.saveAcademicUnit(unit);
            if (saveAcademicUnit.equalsIgnoreCase("Academic Unit with that code already exists")) {
                return new ResponseEntity<>(saveAcademicUnit, HttpStatus.CONFLICT);
            } else {
                return new ResponseEntity<>(saveAcademicUnit, HttpStatus.OK);
            }
        } else {
            String saveDepartmentOrFaculty = academicUnitService.saveDepartmentOrFaculty(unit, code);
            if (saveDepartmentOrFaculty.equalsIgnoreCase("Faculty or Department with that code is already exists")) {
                return new ResponseEntity<>(saveDepartmentOrFaculty, HttpStatus.CONFLICT);
            } else if (saveDepartmentOrFaculty.equalsIgnoreCase("Faculty or Department saved successfully")) {
                return new ResponseEntity<>(saveDepartmentOrFaculty, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(saveDepartmentOrFaculty, HttpStatus.NOT_FOUND);
            }
        }

    }

}
