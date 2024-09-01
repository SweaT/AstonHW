package DAO;

import entity.SchoolClass;
import utils.ConnectionManager;

import java.sql.SQLException;
import java.sql.Statement;

public class SchoolClassDAO {
    private final static SchoolClassDAO INSTANCE = new SchoolClassDAO();
    private final static String SAVE_SQL = """
            INSERT INTO mydatabase.public."Classes"(class_name)
            VALUES (?)
            """;

    public SchoolClass save(SchoolClass schoolClass) {
        try (var connection = ConnectionManager.open();
             var statement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, schoolClass.getName());
            statement.executeUpdate();
            var keys = statement.getGeneratedKeys();
            if (keys.next()) {
                schoolClass.setId(keys.getInt(1));
            }
            return schoolClass;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static SchoolClassDAO getInstance() {
        return INSTANCE;
    }

    private SchoolClassDAO() {
    }
}
