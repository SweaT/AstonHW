package problems;

import entity.Student;
import entity.Teacher;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ProblemsAndSolutions {

    public static void nPlusOneProblem() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Student> students = session.createQuery("from Student", Student.class).list();
        students.forEach(student -> System.out.println(student.getSchoolClass()));

        session.getTransaction().commit();
        session.close();

    }

    public static void nPlusOneProblemSolution() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Student> students = session.createQuery("from Student s join fetch s.schoolClass", Student.class).list();
        students.forEach(student -> System.out.println(student.getSchoolClass()));

        session.getTransaction().commit();
        session.close();
    }

    public static void lazyInitializationException(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Teacher teacher = session.get(Teacher.class, id);

        session.getTransaction().commit();
        session.close();

        System.out.println(teacher.getTeachersAndClasses());

    }

    public static void lazyInitializationExceptionSolution(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Teacher teacher = session.createQuery("from Teacher t join fetch t.teachersAndClasses where t.id = :IDvalue", Teacher.class)
                .setParameter("IDvalue", id).getSingleResult();

        session.getTransaction().commit();
        session.close();

        System.out.println(teacher.getTeachersAndClasses());
    }


}
