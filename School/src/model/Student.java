package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="first_name")
	private String firstName;

	private String gpa;

	@Column(name="last_name")
	private String lastName;

	@Column(name="phone_no")
	private String phoneNo;

	//bi-directional many-to-one association to Course
	@OneToMany(mappedBy="student")
	private List<Course> courses;

	public Student() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGpa() {
		return this.gpa;
	}

	public void setGpa(String gpa) {
		this.gpa = gpa;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public List<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Course addCours(Course cours) {
		getCourses().add(cours);
		cours.setStudent(this);

		return cours;
	}

	public Course removeCours(Course cours) {
		getCourses().remove(cours);
		cours.setStudent(null);

		return cours;
	}
		
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", gpa="
				+ gpa + ", lastName=" + lastName + ", phoneNo=" + phoneNo
				+ ", courses=" + courses + "]";
	}

}