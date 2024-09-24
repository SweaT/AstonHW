package DAO;

import entity.Teacher;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class TeacherDAO {

    public Teacher save(Teacher teacher) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            session.persist(teacher);

            session.getTransaction().commit();

            return teacher;
        }
    }

    // other Teacher DAO logic


}
