package com.app.ReviewHub.Services.Interface;

import com.app.ReviewHub.Model.Dto.Comment.CommentDtoRequest;
import com.app.ReviewHub.Model.Dto.Comment.CommentDtoResponse;

import java.util.UUID;

public interface Comment_S_Interface extends G_Type<CommentDtoRequest, CommentDtoResponse, UUID> {
    Boolean hideComment(UUID id);

    Boolean ShowComment(UUID id);
}
