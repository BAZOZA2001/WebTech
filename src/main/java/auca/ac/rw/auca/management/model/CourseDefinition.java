package auca.ac.rw.auca.management.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "course_definition")
public class CourseDefinition {

	@Id
	@Column(name = "id")
	private UUID id = UUID.randomUUID();

	@Column(name = "coruse_credit")
	private int courseCredit;

	@Column(name = "course_description")
	private String courseDescription;

	@OneToOne
	@JoinColumn(name = "course_id")
	private Course course;
}
