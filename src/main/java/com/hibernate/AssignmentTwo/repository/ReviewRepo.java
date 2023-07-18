package com.hibernate.AssignmentTwo.repository;

import com.hibernate.AssignmentTwo.entities.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review,Long> {

}
