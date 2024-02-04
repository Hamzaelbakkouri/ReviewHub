package com.app.ReviewHub.Model.Dto.Comment;

import com.app.ReviewHub.Model.Entity.Comment;
import com.app.ReviewHub.Model.Entity.Person;
import com.app.ReviewHub.Model.Entity.Review;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CommentDtoRequest {
    private UUID id;

    @NotBlank(message = "Text Must be Not Blank")
    private String text;

    @NotNull(message = "User Must be Not Null")
    private UUID user;


    @NotNull(message = "parentComment Must be Not Null")
    private UUID parentComment;

    @FutureOrPresent(message = "comment must be in the present")
    private LocalDate date;


    @NotNull(message = "review Must be Not Null")
    private UUID review;

    private Boolean hide;

    @NotNull(message = "blockedBy Must be Not Null")
    private UUID blockedBy;
}
