package com.app.ReviewHub.Repository;

import com.app.ReviewHub.Model.Entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment , UUID> {
    Page<Comment> searchAllByTextLike(String TEXT , Pageable pageable);
}
