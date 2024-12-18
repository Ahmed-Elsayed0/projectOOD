package university;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		Faculty f = new Faculty("Zeyad", "zoz09@mail.com"); 
		DB.addFaculty(f);
		
		Course c = new Course("Operation Research", 4); 
		DB.addCourse(c);
		
		Enrollment e = new Enrollment(f, c, 100.0); 
		DB.addEnrollment(e);
		
		
		
		
		System.out.println("\nList of Facultys:");
		System.out.println("----------------------------------");
		List<Faculty> Facultys = DB.getAllFacultys();

		if (Facultys.isEmpty()) {
			System.out.println("No items found.");
		} else {
			for (Faculty Faculty : Facultys) {
				System.out.println(Faculty);
			}
		}

		System.out.println("\n----------------------------------");
		
		
		System.out.println("\nList of courses:");
		System.out.println("----------------------------------");
		List<Course> courses = DB.getAllCourses(); 
		
		if (courses.isEmpty()) {
			System.out.println("No items found.");
		} else {
			for (Course course : courses) {
				System.out.println(course);
			}
		}

		System.out.println("\n----------------------------------");
		
		
		System.out.println("\nList of Enrollments:");
		System.out.println("----------------------------------");
		List<Enrollment> enrollments = DB.getAllEnrollments(); 
		
		if (enrollments.isEmpty()) {
			System.out.println("No items found.");
		} else {
			for (Enrollment enrollment : enrollments) {
				System.out.println(enrollment);
			}
		}
		
		System.out.println("\n----------------------------------");
		
		
	}

}