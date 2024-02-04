package com.app.ReviewHub.Model.Dto.User;

import com.app.ReviewHub.Model.Entity.Comment;
import com.app.ReviewHub.Model.Entity.Review;
import com.app.ReviewHub.Model.Enum.Role;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class UserResponse {
    private UUID id;

    private String fullName;

    private LocalDate dateOfBirth;

    private String address;

    private String email;

    private Role role;

    private List<Review> reviews;

    private List<Comment> comments;
}
