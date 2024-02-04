package com.app.ReviewHub.Repository;

import com.app.ReviewHub.Model.Entity.Person;
import com.app.ReviewHub.Model.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review , UUID> {
    List<Review> searchAllByTitleLike(String title);
}
