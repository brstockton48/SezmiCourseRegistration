package Sezmi.TridentTechCourseRegistration.major;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import Sezmi.TridentTechCourseRegistration.course.Course;


@Entity
@Table(name = "major")
public class Major 
{
	//declare variables (i.e table categories) for the Major table
	//Create the primary key within the database using the @ID tag.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "major_id", nullable = false, updatable = false)
	private String major_id;
	
	@Column(name = "major_name", nullable = false, updatable = false)
	private String major;
	
	//declare a set for the required courses for each major
	@ManyToMany
	@JoinTable(
			name = "major_course",
			joinColumns = @JoinColumn(name = "major_id"),
			inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Set<Course> requiredCourses = new HashSet<Course>();

	//create no arg constructor
	public Major()
	{}

	//create full arg constructor
	public Major(String major_id, String major) 
	{
		this.major_id = major_id;
		this.major = major;
	}


	public String getMajor_id()
	{
		return major_id;
	}

	
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void setMajor_id(String major_id) {
		this.major_id = major_id;
	}

	public Set<Course> getRequiredCourses() {
		return requiredCourses;
	}

	public void setRequiredCourses(Set<Course> requiredCourses) {
		this.requiredCourses = requiredCourses;
	}






}//end Major Class
