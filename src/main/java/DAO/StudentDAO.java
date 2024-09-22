//package DAO;
//
//import entity.Student;
//
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//public class StudentDAO{
//
//    private final static StudentDAO INSTANCE = new StudentDAO();
//    private final static String SAVE_SQL = """
//            INSERT INTO mydatabase.public."Students"(name, class_id)
//            VALUES (?,?)
//            """;
//
//    private final static String GET_SQL = """
//            SELECT * FROM mydatabase.public."Students" WHERE student_id = ?
//            """;
//
//    private final static String GET_ALL_SQL = """
//            SELECT * FROM mydatabase.public."Students"
//            ORDER BY student_id;
//            """;
//
//    private final static String UPDATE_SQL = """
//            UPDATE mydatabase.public."Students" SET name=?, class_id=? WHERE student_id = ?""";
//
//    private final static String DELETE_SQL = """
//            DELETE FROM mydatabase.public."Students"
//            where student_id = ?
//            """;
//
//    /** if DB doesn't return generated keys, method returns null */
//    public Student create(Student student) throws SQLException {
//        try (var connection = DBConnectionManager.open();
//             var statement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
//            statement.setString(1, student.getName());
//            statement.setInt(2, student.getClassID());
//            statement.executeUpdate();
//            var keys = statement.getGeneratedKeys();
//            if (keys.next()) {
//                student.setId(keys.getInt(1));
//            }
//            else return null;
//            return student;
//        }
//    }
//
//    public Student getById(int id) throws SQLException {
//        try (var connection = DBConnectionManager.open();
//             var statement = connection.prepareStatement(GET_SQL)) {
//            statement.setInt(1, id);
//            var rs = statement.executeQuery();
//            rs.next();
//            return new Student(rs.getInt("student_id"), rs.getString("name"), rs.getInt("class_id"));
//        }
//    }
//
//    public List<Student> getAll() throws SQLException {
//        try (var connection = DBConnectionManager.open();
//             var statement = connection.prepareStatement(GET_ALL_SQL)) {
//            var rs = statement.executeQuery();
//            List<Student> students = new ArrayList<>();
//            while (rs.next()) {
//                students.add(new Student(rs.getInt("student_id"), rs.getString("name"), rs.getInt("class_id")));
//            }
//            return students;
//        }
//    }
//
//    public boolean update(Student student) throws SQLException {
//        try (var connection = DBConnectionManager.open();
//             var statement = connection.prepareStatement(UPDATE_SQL)) {
//            statement.setString(1, student.getName());
//            statement.setInt(2, student.getClassID());
//            statement.setInt(3, student.getId());
//            return statement.executeUpdate() > 0;
//        }
//
//    }
//
//    public boolean delete(int id) throws SQLException {
//        try (var connection = DBConnectionManager.open();
//             var statement = connection.prepareStatement(DELETE_SQL)) {
//            statement.setInt(1, id);
//            return statement.executeUpdate() > 0;
//        }
//    }
//
//
//    public static StudentDAO getInstance() {
//        return INSTANCE;
//    }
//
//    private StudentDAO() {
//    }
//
//
//}
