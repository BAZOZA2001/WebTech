package auca.ac.rw.auca.management.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "academic_unit")
public class AcademicUnit {

	@Id
	@Column(name = "academic_unit_id")
	private UUID id = UUID.randomUUID();

	@Column(name = "academic_code", unique = true)
	private String academicCode;

	@Column(name = "academic_name", unique = true)
	private String academicName;

	@Column(name = "academic_type")
	@Enumerated(EnumType.STRING)
	private EAcademicUnitType academicType;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parent_id", nullable = true)
	private AcademicUnit academicUnit;

	@OneToMany(mappedBy = "academicUnit")
	private List<Course> courses;

	public String getAcademicCode() {
		return academicCode;
	}

	public AcademicUnit() {
		super();
	}

	public AcademicUnit(String academicCode, String academicName, EAcademicUnitType academicType,
			AcademicUnit academicUnit) {
		super();
		this.academicCode = academicCode;
		this.academicName = academicName;
		this.academicType = academicType;
		this.academicUnit = academicUnit;
	}

	public AcademicUnit(String academicCode, String academicName, EAcademicUnitType academicType) {
		super();
		this.academicCode = academicCode;
		this.academicName = academicName;
		this.academicType = academicType;
	}

	public void setAcademicCode(String academicCode) {
		this.academicCode = academicCode;
	}

	public String getAcademicName() {
		return academicName;
	}

	public void setAcademicName(String academicName) {
		this.academicName = academicName;
	}

	public EAcademicUnitType getAcademicType() {
		return academicType;
	}

	public void setAcademicType(EAcademicUnitType academicType) {
		this.academicType = academicType;
	}

	public AcademicUnit getAcademicUnit() {
		return academicUnit;
	}

	public void setAcademicUnit(AcademicUnit academicUnit) {
		this.academicUnit = academicUnit;
	}

}
