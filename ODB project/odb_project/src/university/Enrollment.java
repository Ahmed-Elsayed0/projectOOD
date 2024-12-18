package university;

import javax.persistence.*;

@Entity
public class Enrollment {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn (name = "Faculty", nullable = false)
	private Faculty Faculty;
	@ManyToOne
	@JoinColumn (name = "course", nullable = false)
	private Course course;
	private Double grade;

	public Enrollment() {}

	public Enrollment(Faculty Faculty, Course course, Double grade) {
		this.Faculty = Faculty;
		this.course = course;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Faculty getFaculty() {
		return Faculty;
	}

	public void setFaculty(Faculty Faculty) {
		this.Faculty = Faculty;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "\nid: " + id + "\n\nFaculty:\n\tid:" + Faculty.getId() + "\n\tname: "+ Faculty.getName() + "\n\temail: " + Faculty.getEmail() + "\n\ncourse:\n\tid:" + course.getId() + "\n\tname: " + course.getName() + "\n\tcredithours: " + course.getCreditHours() + "\n\ngrade: " + grade;
	}
	

}
