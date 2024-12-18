package university;

import java.util.*;
import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name = "Faculty.findall", query = "Select s From Faculty s"),
	@NamedQuery(name = "Faculty.findByID", query = "Select s From Faculty s where s.id = :id"),
	@NamedQuery(name = "Faculty.count", query = "Select count(s) From Faculty s"),
})
public class Faculty {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;

	@OneToMany(mappedBy = "Faculty", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Enrollment> enrollments;

	public Faculty() {
	}

	public Faculty(String name, String email) {
		this.name = name;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "\nid: " + id + "\nname: " + name + "\nemail: " + email;
	}

}
