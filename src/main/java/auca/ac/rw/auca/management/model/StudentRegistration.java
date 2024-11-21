package auca.ac.rw.auca.management.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_registration")
public class StudentRegistration {

	@Id
	@Column(name = "registration_id")
	private UUID registrationId = UUID.randomUUID();

	private String registrationCode;

	private Date academicYear;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "student_id", nullable = false)
	private Student student;

	@ManyToOne
	@JoinColumn(name = "semester_id", nullable = false)
	private Semester semester;

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public Semester getSemester() {
		return this.semester;
	}

	public StudentRegistration(String registrationCode, Date academicYear, Student student) {
		super();
		this.registrationCode = registrationCode;
		this.academicYear = academicYear;
		this.student = student;
	}

	@ManyToMany(mappedBy = "studentRegistrations")
	List<Course> courses;

	public UUID getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(UUID registrationId) {
		this.registrationId = registrationId;
	}

	public String getRegistrationCode() {
		return registrationCode;
	}

	public void setRegistrationCode(String registrationCode) {
		this.registrationCode = registrationCode;
	}

	public Date getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(Date academicYear) {
		this.academicYear = academicYear;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
