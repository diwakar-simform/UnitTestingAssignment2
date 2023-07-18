package com.hibernate.AssignmentTwo.service.course;

import com.hibernate.AssignmentTwo.entities.course.Course;
import com.hibernate.AssignmentTwo.repository.CourseRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class CourseServiceImplTest {

    @Mock
    private CourseRepo courseRepo;

    private CourseService courseService;
    AutoCloseable autoCloseable;
    Course course;


    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        courseService = new CourseServiceImpl(courseRepo);
        course = new Course(1001L,"JavaScript");
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void testGetAllCourses() {
        mock(Course.class);
        mock(CourseRepo.class);

        when(courseRepo.findAll()).thenReturn(
                new ArrayList<Course>(Collections.singletonList(course))
        );

        assertThat(courseService.getAllCourses().get(0).getName()).isEqualTo(course.getName());
    }

    @Test
    void testAddCourse() {
        mock(Course.class);
        mock(CourseRepo.class);
        when(courseRepo.save(course)).thenReturn(course);
        assertThat(courseService.addCourse(course)).isEqualTo(course);
    }

    @Test
    void testDeleteCourseById() {
        mock(Course.class);
        mock(CourseRepo.class, CALLS_REAL_METHODS);

        doAnswer(Answers.CALLS_REAL_METHODS).when(courseRepo).deleteById(any());
        assertThat(courseService.deleteCourseById(1001L)).isEqualTo("------Item deleted Successfully-------");
    }

    @Test
    void testGetCourseById_ByName() {
        mock(Course.class);
        mock(CourseRepo.class);

        when(courseRepo.findById(1001L)).thenReturn(Optional.ofNullable(course));
        assertThat(courseService.getCourseById(1001L).getName()).isEqualTo(course.getName());
    }

}