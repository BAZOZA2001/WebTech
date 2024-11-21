package auca.ac.rw.auca.management.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "semester")
public class Semester {

	@Id
	@Column(name = "semester_id")
	private UUID id = UUID.randomUUID();

	@Column(name = "semester_name")
	private String semesterName;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	@OneToMany(mappedBy = "semester")
	private List<StudentRegistration> studentRegistrations;

	@OneToMany(mappedBy = "semester")
	private List<Course> courses;

	public Semester() {
		super();
	}

	public Semester(String semesterName, Date startDate, Date endDate) {
		super();
		this.semesterName = semesterName;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getSemesterName() {
		return semesterName;
	}

	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<StudentRegistration> getStudentRegistrations() {
		return studentRegistrations;
	}

	public void setStudentRegistrations(List<StudentRegistration> studentRegistrations) {
		this.studentRegistrations = studentRegistrations;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}
