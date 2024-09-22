package hibernate.starter;

import entity.*;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.time.Instant;

public class HibernateRunner {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            Teacher palPalich = session.get(Teacher.class, 2);
            SchoolClass schoolClass = session.get(SchoolClass.class, 2);

            schoolClass.setName("Класс Пал Палыча");

            session.merge(schoolClass);

            palPalich.getTeachersAndClasses().
                    forEach(teacher -> System.out.println("Пал палыч преподает в классе - " + teacher.getSchoolClass().getName()));

            schoolClass.getTeachersAndClasses().
                    forEach(teacher -> System.out.println("Имя учителя - " + teacher.getTeacher().getName()));


            session.getTransaction().commit();

        }
    }
}
