package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoursesService {

    CourseRepository courseRepository = new CourseRepository();
    public List<Courses> GetAllCourses() {
        return courseRepository.retrieveAllCourses();
    }

    public Courses GetCourse(Long id) {
        return courseRepository.retrieveCourse(id);
    }

    public Courses PostCourse(String title, String description, Integer capacity) {
        if (title == null){
            // 400: title must not be blank
        } else if (title.length() > 15){
            // 400: title must not be more than 15 char
        } else if (description.length() > 50) {
            // 400: description must not be more than 50 char
        } else if (capacity <= 0) {
            // 400: capcity should be a postive number
        } else return courseRepository.createCourse(title, description, capacity);
    }

    public void PutCourse(Long id, String title, String description, Integer capacity) {
        if (title == null){
            // 400: title must not be blank
        } else if (title.length() > 15){
            // 400: title must not be more than 15 char
        } else if (description.length() > 50) {
            // 400: description must not be more than 50 char
        } else if (capacity <= 0) {
            // 400: capcity should be a postive number
        } else courseRepository.updateCourse(id, title, description, capacity);
    }


    public void DeleteCourse(Long id) {
        courseRepository.deleteCourse(id);
    }

}
