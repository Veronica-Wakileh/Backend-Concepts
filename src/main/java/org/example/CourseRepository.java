package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {

    // 1
    public List<Courses> retrieveAllCourses() throws SQLException {

        List<Courses> courses = new ArrayList<>();

        PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement("SELECT * FROM Courses  ORDER BY id");

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            courses.add(new Courses((long) resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("description"), resultSet.getInt("capacity")));
        }
        return courses;
    }

    // 2
    public Courses retrieveCourse(Long id) throws SQLException {

        PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement("SELECT * FROM Courses WHERE id = ?");

        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return new Courses(resultSet.getString("title"), resultSet.getString("description"), resultSet.getInt("capacity"));
        }
        return null;
    }

    // 3
    public void createCourse(String title, String description, Integer capacity) throws SQLException {

        PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement("INSERT INTO Courses(title, description, capacity) VALUES (?, ?, ?)");

        statement.setString(1, "title");
        statement.setString(2, "description");
        statement.setInt(3, capacity);
        statement.executeUpdate();

    }

    // 4
    public void updateCourse(Long id,String title, String description, Integer capacity) throws SQLException {

        PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement("UPDATE Courses SET title = ?, description = ?, capacity = ? WHERE id = ?");

        statement.setString(1, "title");
        statement.setString(2, "description");
        statement.setInt(3, capacity);
        statement.executeUpdate();

    }

    // 5
    public void deleteCourse(Long id) throws SQLException {

        PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement("DELETE FROM Courses WHERE id = ?");

        statement.executeUpdate();

    }

}


