package com.hibernate.AssignmentTwo.service.course;

import com.hibernate.AssignmentTwo.entities.course.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course addCourse(Course course);
    String deleteCourseById(Long id);
    Course getCourseById(Long id);
}
