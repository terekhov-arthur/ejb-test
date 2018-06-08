package repository;

import model.Student;

import javax.ejb.Stateless;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class StudentRepository {

    private static final String SELECT_ALL = "select * from STUDENT";
    private static final String CONNECTION_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String CONNECTION_USER = "local";
    private static final String CONNECTION_PASSWORD = "pass";

    public List<Student> findAll() {
        List<Student> students;
        PreparedStatement statement = null;

        try {
            Connection connection = DriverManager
                    .getConnection(CONNECTION_URL, CONNECTION_USER, CONNECTION_PASSWORD);
            statement = connection.prepareStatement(SELECT_ALL);

            ResultSet resultSet = statement.executeQuery();
            students = extractAll(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException("Something went wrong", e);
        } finally {
            close(statement);
        }
        return students;
    }

    private void close(PreparedStatement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Can't close connection: " + e.getMessage());
            }
        }
    }

    private List<Student> extractAll(ResultSet resultSet) throws SQLException {
        List<Student> students = new ArrayList<>();

        while (resultSet.next()) {
            Student student = extract(resultSet);
            students.add(student);
        }

        return students;
    }

    private Student extract(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String fullName = resultSet.getString("full_name");
        return new Student(id, fullName);
    }
}
