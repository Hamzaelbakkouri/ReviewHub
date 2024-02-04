package com.app.ReviewHub.Model.Dto.Comment;

import com.app.ReviewHub.Model.Dto.PersonRequest;
import com.app.ReviewHub.Model.Dto.Review.ReviewDtoReq;
import com.app.ReviewHub.Model.Entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CommentDtoResponse {
    private UUID id;

    private String text;

    private PersonRequest user;

    private Comment parentComment;

    private LocalDate date;

    private ReviewDtoReq review;

    private Boolean hide;

    private PersonRequest blockedBy;

    private List<CommentDtoRequest> childComments;
}
