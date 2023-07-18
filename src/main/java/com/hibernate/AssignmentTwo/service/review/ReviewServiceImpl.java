package com.hibernate.AssignmentTwo.service.review;

import com.hibernate.AssignmentTwo.entities.course.Course;
import com.hibernate.AssignmentTwo.entities.review.Review;
import com.hibernate.AssignmentTwo.repository.ReviewRepo;
import com.hibernate.AssignmentTwo.service.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    ReviewRepo reviewRepo;

    @Autowired
    CourseService courseService;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Review> getAllReviews() {
        return reviewRepo.findAll();
    }

    @Override
    public Review addReview(Review review) {
        return reviewRepo.save(review);
    }

    @Override
    @Transactional
    public String deleteReviewById(Long id) {
        String message = "-----Wrong Id------";
        if (id != null && id > 0){
            reviewRepo.findById(id).isPresent();
            reviewRepo.deleteById(id);
            message = "-------Item deleted Successfully-----";
        }
        return message;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String addReviewWithCourse(Review review, Long id) {
        Course course = courseService.getCourseById(id);
        reviewRepo.save(review);
        review.setCourse(course);
        return "------Review Added Successfully------";
    }

}
