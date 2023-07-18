package com.hibernate.AssignmentTwo.repository;

import com.hibernate.AssignmentTwo.entities.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Long> {

}
