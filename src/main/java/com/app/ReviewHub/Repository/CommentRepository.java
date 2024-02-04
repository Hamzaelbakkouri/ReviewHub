package com.app.ReviewHub.Repository;

import com.app.ReviewHub.Model.Entity.Comment;
import com.app.ReviewHub.Model.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment , UUID> {
    List<Comment> searchAllByTextLike(String TEXT);
}
