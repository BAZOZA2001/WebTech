package auca.ac.rw.auca.management.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@Column(name = "course_id")
	private UUID courseId = UUID.randomUUID();

	@Column(name = "course_code", unique = true)
	private String courseCode;

	@Column(name = "course_name")
	private String courseName;

	@ManyToOne
	@JoinColumn(name = "semester_id")
	private Semester semester;

	@OneToOne(mappedBy = "course")
	private CourseDefinition defination;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "registration_course", joinColumns = { @JoinColumn(name = "course_id") }, inverseJoinColumns = {
			@JoinColumn(name = "registration_id") })
	private List<StudentRegistration> studentRegistrations;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "lecturer_course", joinColumns = { @JoinColumn(name = "course_id") }, inverseJoinColumns = {
			@JoinColumn(name = "lecturer_id") })
	private List<Lecturer> lecturers;

	@ManyToOne
	@JoinColumn(name = "depertment")
	private AcademicUnit academicUnit;

	public Course(String courseCode, String courseName,
			Semester semester, AcademicUnit academicUnit) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.semester = semester;
		this.academicUnit = academicUnit;
	}

	public Course(String courseCode, String courseName) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
