package com.app.ReviewHub.Model.Dto.Moderator;

import com.app.ReviewHub.Model.Entity.Comment;
import com.app.ReviewHub.Model.Entity.Review;
import com.app.ReviewHub.Model.Enum.Role;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class ModeratorResponse {
    private UUID id;

    private String fullName;

    private LocalDate dateOfBirth;

    private String address;

    private String email;

    private Role role;

    private List<Comment> comments;

    private List<Comment> commentBlocked;
}
