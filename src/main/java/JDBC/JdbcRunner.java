package JDBC;

import DAO.StudentDAO;

import java.sql.SQLException;

public class JdbcRunner {

    public static void main(String[] args) throws SQLException {


        System.out.println(StudentDAO.getInstance().getAll());

    }
}
