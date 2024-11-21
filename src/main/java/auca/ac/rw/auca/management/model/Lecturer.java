package auca.ac.rw.auca.management.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "lecturer")
public class Lecturer {

	@Id
	@Column(name = "lecturer_id")
	private UUID id = UUID.randomUUID();

	@Column(name = "teacher_name")
	private String teacherName;

	@Column(name = "teacher_code")
	private String code;

	@Enumerated(EnumType.STRING)
	@Column(name = "qualification")
	private EQualification qualification;

	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private ELecturerType type;

	@ManyToMany(mappedBy = "lecturers")
	private List<Course> courses;
}
