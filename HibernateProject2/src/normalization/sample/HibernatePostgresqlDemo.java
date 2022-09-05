package normalization.sample;

import java.io.File;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernatePostgresqlDemo {
	public static void main(String[] args) {
		String confFile = "hibernate.cfg.xml";
		ClassLoader classLoader = HibernatePostgresqlDemo.class.getClassLoader();
		File f = new File(classLoader.getResource(confFile).getFile());
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
//CREATE
		for (int i = 0; i < 5; i++)
			saveStudentRecord(session);

//READ
//fetchStudentRecord(session);
//UPDATE
//updateStudentRecord(session);
//DELETE
//deleteStudentRecord(session);
		session.close();
	}

//	private static void deleteStudentRecord(Session session) {
//		int id = 1;
//		MyClass student1 = (MyClass) session.get(MyClass.class, new Integer(id));
//		session.beginTransaction();
//		session.delete(student1);
//		session.getTransaction().commit();
//		System.out.println("Record deleted successfully...");
//	}

	
//
//	private static void fetchStudentRecord(Session session) {
//		Query query = session.createQuery("FROM Student");
//		List<MyClass> MyClass = query.list();
//		MyClass.forEach(obj -> System.out.println(obj.getFirstName()));
//		System.out.println("Reading student records...");
//		for (MyClass studentObj : MyClass) {
//			System.out.println("First Name" + studentObj.getFirstName());
//			System.out.println("Last Name" + studentObj.getLastName());
//			System.out.println("Roll Number" + studentObj.getRoll());
//			System.out.println("Standard" + studentObj.getStandard());
//		}
//	}

	private static void saveStudentRecord(Session session) {
		Doctor myclass = new Doctor();
		myclass.setDoctorName("Ricky Lo");
		session.beginTransaction();
		session.save(myclass);
		session.getTransaction().commit();
		System.out.println("Record saved succesfully...");
	}
}