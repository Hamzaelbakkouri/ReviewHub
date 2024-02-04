package com.app.ReviewHub.Services.Implementation;

import com.app.ReviewHub.Model.Dto.Comment.CommentDtoRequest;
import com.app.ReviewHub.Model.Dto.Comment.CommentDtoResponse;
import com.app.ReviewHub.Repository.CommentRepository;
import com.app.ReviewHub.Services.Interface.Comment_S_Interface;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class CommentService implements Comment_S_Interface {
    private CommentRepository commentRepository;

    @Override
    public CommentDtoResponse save(CommentDtoRequest commentDtoRequest) {
        return null;
    }

    @Override
    public CommentDtoResponse find(UUID uuid) {
        return null;
    }

    @Override
    public Boolean remove(UUID uuid) {
        return null;
    }

    @Override
    public Page<CommentDtoResponse> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Page<CommentDtoResponse> search(CommentDtoRequest commentDtoRequest,Pageable pageable) {
        return null;
    }
}
