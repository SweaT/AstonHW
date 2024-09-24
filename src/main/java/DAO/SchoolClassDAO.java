package DAO;

import entity.SchoolClass;
import entity.Student;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;

public class SchoolClassDAO {
    private final static SchoolClassDAO INSTANCE = new SchoolClassDAO();

    private SchoolClassDAO() {
    }

    public static SchoolClassDAO getInstance() {
        return INSTANCE;
    }

    public SchoolClass get(int id){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            SchoolClass schoolClass = session.get(SchoolClass.class, id);

            session.getTransaction().commit();

            return schoolClass;
        }
    }

    public SchoolClass save(SchoolClass schoolClass) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            session.persist(schoolClass);

            session.getTransaction().commit();

            return schoolClass;
        }
    }
}
