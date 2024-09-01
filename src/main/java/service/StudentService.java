package service;

import DAO.StudentDAO;
import DTO.StudentDTO;
import entity.Student;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService {
    private static final StudentService INSTANCE = new StudentService();
    private static final StudentDAO studentDAO = StudentDAO.getInstance();

    public List<StudentDTO> findall() throws SQLException {
        return studentDAO.getAll().stream()
                .map(student -> new StudentDTO(student.getId(), "%s - %s".formatted(
                        student.getName(),
                        student.getClassID()
                ))).collect(Collectors.toList());


    }

    public boolean addStudent(StudentDTO student) throws SQLException {
        studentDAO.save(new Student(student.id(), student.description()));
    }

    public static StudentService getInstance(){
        return INSTANCE;
    }

    private StudentService() {
    }
}
