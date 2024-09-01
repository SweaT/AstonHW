package utils;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class UtilDAO {
    public static ResultSet getRecords(String tableName) throws SQLException {
        String query = "SELECT * FROM " + tableName;
        ResultSet resultSet;

        try (Connection connection = ConnectionManager.open();
             Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(query);
        }
        return resultSet;
    }

    public static ResultSet getRecordById(String tableName, String idName, int id) throws SQLException {
        String query = "SELECT * FROM " + tableName + " WHERE " + idName + " = " + id;
        ResultSet resultSet;
        try (Connection connection = ConnectionManager.open();
             Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(query);
        }
        return resultSet;
    }

    public static void addRecord(String tableName, HashMap<String, Object> fieldsAndValues) throws SQLException {
        StringJoiner columns = mappingColumns(fieldsAndValues);
        StringJoiner values = mappingValues(fieldsAndValues);

        String query = "INSERT INTO " + tableName + " (" + columns + ") values(" + values + ")";

        try (Connection connection = ConnectionManager.open();
             PreparedStatement statement = connection.prepareStatement(query)) {
            int iterator = 1;
            for (Map.Entry<String, Object> entry : fieldsAndValues.entrySet()) {
                statement.setObject(iterator++, entry.getValue());
            }
            statement.execute();
        }
    }

    public static void updateRecord(String tableName, int id, HashMap<String, Object> fieldsAndValues) {
        StringJoiner columns = mappingColumns(fieldsAndValues);
        StringJoiner values = mappingValues(fieldsAndValues);

        StringBuilder query = new StringBuilder("UPDATE " + tableName + " set");
        int index = 1;
        for (Map.Entry<String, Object> entry : fieldsAndValues.entrySet()) {
            if (index++ == 1) {
                query.append(" ").append(entry.getKey()).append("=?");
            } else {
                query.append(", ").append(entry.getKey()).append("=?");
            }
        }
        query.append(" where id = ").append(id);

        try (Connection connection = ConnectionManager.open();
             PreparedStatement statement = connection.prepareStatement(String.valueOf(query))) {
            int iterator = 1;
            for (Map.Entry<String, Object> entry : fieldsAndValues.entrySet()) {
                statement.setObject(iterator++, entry.getValue());
            }
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static StringJoiner mappingColumns(HashMap<String, Object> fieldsAndValues) {
        StringJoiner columns = new StringJoiner(",");
        for (Map.Entry<String, Object> entry : fieldsAndValues.entrySet()) {
            columns.add(entry.getKey());
        }
        return columns;
    }

    public static StringJoiner mappingValues(HashMap<String, Object> fieldsAndValues) {
        StringJoiner values = new StringJoiner(",");
        for (Map.Entry<String, Object> entry : fieldsAndValues.entrySet()) {
            values.add(entry.getKey());
        }
        return values;
    }
}
