package university;

import java.util.*;
import javax.persistence.*;

@Entity
public class Course {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int creditHours;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Enrollment> enrollments;

	public Course() {
	}

	public Course(String name, int creditHours) {
		this.name = name;
		this.creditHours = creditHours;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCreditHours() {
		return creditHours;
	}

	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}

	@Override
	public String toString() {
		return "\nid: " + id + "\nname: " + name + "\ncredit hours: " + creditHours;
	}

}
