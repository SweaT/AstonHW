package hibernate.starter;

import DAO.SchoolClassDAO;
import DAO.StudentDAO;
import entity.*;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;

import org. hibernate. query. Query;
import problems.ProblemsAndSolutions;

import java.util.List;


public class HibernateRunner {

    public static void main(String[] args) {
        List<Teacher> teachers;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            SchoolClass schoolClass = session.get(SchoolClass.class, 5);

            Teacher teacher = session.get(Teacher.class, 3);

            session.persist(TeachersAndClasses.setTeacherAndClass(teacher, schoolClass));






//            StudentDAO.getInstance().delete();



            session.getTransaction().commit();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
