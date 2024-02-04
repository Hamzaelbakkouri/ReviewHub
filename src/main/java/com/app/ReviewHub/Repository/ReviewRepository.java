package com.app.ReviewHub.Repository;

import com.app.ReviewHub.Model.Entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review , UUID> {
    Page<Review> searchAllByTitleLike(String title, Pageable pageable);
}
