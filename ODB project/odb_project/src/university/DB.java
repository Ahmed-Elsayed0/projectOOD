package university;

import java.util.*;
import javax.persistence.*;

//CRUD Operations
public class DB {

	// Create

	public static void addFaculty(Faculty s) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}

	public static void addCourse(Course c) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}

	public static void addEnrollment(Enrollment e) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}

	// Retrieve (Lists w/ Queries)

	public static List<Faculty> getAllFacultys() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Faculty> query = em.createNamedQuery("Faculty.findall", Faculty.class);

		List<Faculty> Facultys = query.getResultList();

		em.close();
		emf.close();
		return Facultys;
	}

	public static List<Course> getAllCourses() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
		EntityManager em = emf.createEntityManager();

		List<Course> courses = em.createQuery("SELECT c FROM Course c", Course.class).getResultList();

		em.close();
		emf.close();
		return courses;
	}

	public static List<Enrollment> getAllEnrollments() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
		EntityManager em = emf.createEntityManager();

		List<Enrollment> enrollments = em.createQuery("SELECT e FROM Enrollment e", Enrollment.class).getResultList();

		em.close();
		emf.close();
		return enrollments;
	}
	
	// Retrieve (Single Objects w/ EntityManager)

	public static Faculty getFacultyById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
		EntityManager em = emf.createEntityManager();

		Faculty s = em.find(Faculty.class, id);

		em.close();
		emf.close();
		return s;
	}

	public static Course getCourseById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
		EntityManager em = emf.createEntityManager();

		Course c = em.find(Course.class, id);

		em.close();
		emf.close();
		return c;
	}

	public static Enrollment geEnrollmentById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
		EntityManager em = emf.createEntityManager();

		Enrollment e = em.find(Enrollment.class, id);

		em.close();
		emf.close();
		return e;
	}

	// Update

	public static void updateFaculty(int id, String newName, String newEmail) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
		EntityManager em = emf.createEntityManager();

		Faculty s = em.find(Faculty.class, id);

		try {
			if (s != null) {
				if (newName != null) {
					em.getTransaction().begin();
					s.setName(newName);
					em.getTransaction().commit();
				}
				if (newEmail != null) {
					em.getTransaction().begin();
					s.setEmail(newEmail);
					em.getTransaction().commit();
				}

			}
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}

	}
	
	public static void updateCourse(int id, String newName, Integer newCred) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
		EntityManager em = emf.createEntityManager();
		
		Course c = em.find(Course.class, id);	
		
		try {
			if (c != null) {
				if(newName != null) {
					em.getTransaction().begin();
					c.setName(newName);
					em.getTransaction().commit();
				}
				if (newCred != null) {
					em.getTransaction().begin();
					c.setCreditHours(newCred);
					em.getTransaction().commit();
				}
			}
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
	
	public static void updateEnrollment(int id, Faculty s, Course c, Double newGrade) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
		EntityManager em = emf.createEntityManager();
		
		Enrollment en = em.find(Enrollment.class, id);
		
		try {
			if (en != null) {
				if(s != null) {
					em.getTransaction().begin();
					en.setFaculty(s);
					em.getTransaction().commit();
				}
				if (c != null) {
					em.getTransaction().begin();
					en.setCourse(c);
					em.getTransaction().commit();
				}
				if (newGrade != null) {
					em.getTransaction().begin();
					en.setGrade(newGrade);
					em.getTransaction().commit();
				}
			}
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		
	}


	//Delete
	
	public static void deleteFaculty(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
		EntityManager em = emf.createEntityManager();

		Faculty s = em.find(Faculty.class, id);
		
		if (s != null) {
			em.getTransaction().begin();
			em.remove(s);
			System.out.printf("SUCCESS: Faculty with id : \"%d\" deleted successfully.", id);
			em.getTransaction().commit();
		} else {
			System.out.printf("ERROR: There's no Faculty with id : \"%d\" in the database.", id);
		}
		em.close();
		emf.close();
	}
	
	public static void deleteCourse(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
		EntityManager em = emf.createEntityManager();

		Course c = em.find(Course.class, id);
		
		if (c != null) {
			em.getTransaction().begin();
			em.remove(c);
			System.out.printf("SUCCESS: Course with id : \"%d\" deleted successfully.", id);
			em.getTransaction().commit();
		} else {
			System.out.printf("ERROR: There's no course with id : \"%d\" in the database.", id);
		}
		em.close();
		emf.close();
	}
	
	public static void deleteEnrollment(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbtest.odb");
		EntityManager em = emf.createEntityManager();

		Enrollment e = em.find(Enrollment.class, id);
		
		if (e != null) {
			em.getTransaction().begin();
			em.remove(e);
			System.out.printf("SUCCESS: Enrollment with id : \"%d\" deleted successfully.", id);
			em.getTransaction().commit();
		} else {
			System.out.printf("ERROR: There's no enrollment with id : \"%d\" in the database.", id);
		}
		em.close();
		emf.close();
	}
}
