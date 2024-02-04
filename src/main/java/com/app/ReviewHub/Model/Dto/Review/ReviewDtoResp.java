package com.app.ReviewHub.Model.Dto.Review;

import com.app.ReviewHub.Model.Entity.Comment;
import com.app.ReviewHub.Model.Entity.Person;
import com.app.ReviewHub.Model.Enum.ReactionType;
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
public class ReviewDtoResp {
    private UUID id;

    private LocalDate date;

    private String title;

    private ReactionType reaction;

    private Person user;

    private List<Comment> comments;
}
