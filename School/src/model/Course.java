package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the course database table.
 * 
 */
@Entity
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String course;

	private String grade;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="P_Id", referencedColumnName="P_Id")
	private Student student;

	public Course() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourse() {
		return this.course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", course=" + course + ", grade=" + grade
				+ ", student=" + student + "]";
	}
	
}