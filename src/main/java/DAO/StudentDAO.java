package DAO;

import entity.Student;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;


public class StudentDAO{

    private StudentDAO() {
    }

    private final static StudentDAO INSTANCE = new StudentDAO();

    public static StudentDAO getInstance() {
        return INSTANCE;
    }

    public Student create(Student student) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            session.persist(student);

            session.getTransaction().commit();
        }

        return student;
    }

    public Student getById(int id) {
        Student student;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            student = session.get(Student.class, id);

            session.getTransaction().commit();
        }

        return student;
    }

    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            students = session.createQuery("select s from Student s join fetch s.schoolClass ORDER BY s.id" , Student.class).list();

            session.getTransaction().commit();
        }

        return students;
    }

    public boolean update(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            session.merge(student);

            session.getTransaction().commit();
        }
        return true;
    }

    public boolean delete(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            session.remove(student);

            session.getTransaction().commit();
        }
        return true;
    }

    public boolean deleteByID(int id) {
        int result;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            Query<Student> query = session.createQuery("delete FROM Student s where s.id = :id");
            query.setParameter("id", id);
            result = query.executeUpdate();

            session.getTransaction().commit();
        }
        return result > 0;
    }
}
