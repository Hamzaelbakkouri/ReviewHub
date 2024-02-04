package com.app.ReviewHub.Services.Implementation;

import com.app.ReviewHub.Exceptions.NotFoundException;
import com.app.ReviewHub.Model.Dto.Comment.CommentDtoRequest;
import com.app.ReviewHub.Model.Dto.Comment.CommentDtoResponse;
import com.app.ReviewHub.Model.Entity.Comment;
import com.app.ReviewHub.Repository.CommentRepository;
import com.app.ReviewHub.Services.Interface.Comment_S_Interface;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class CommentService implements Comment_S_Interface {
    private CommentRepository commentRepository;
    private ModelMapper modelMapper;

    @Override
    public CommentDtoResponse save(CommentDtoRequest commentDtoRequest) {
        Comment comment = this.modelMapper.map(commentDtoRequest, Comment.class);
        return this.modelMapper.map(this.commentRepository.save(comment), CommentDtoResponse.class);
    }

    @Override
    public CommentDtoResponse find(UUID uuid) {
        return this.modelMapper.map(this.commentRepository.findById(uuid).orElseThrow(
                        () -> new NotFoundException("Comment Not Found")),
                CommentDtoResponse.class
        );
    }

    @Override
    public Boolean remove(UUID uuid) {
        this.commentRepository.findById(uuid).orElseThrow(() -> new NotFoundException("Comment Not Found"));
        this.commentRepository.deleteById(uuid);
        return true;
    }

    @Override
    public Page<CommentDtoResponse> findAll(Pageable pageable) {
        Page<Comment> comments = this.commentRepository.findAll(pageable);
        return comments.map(comment -> modelMapper.map(comment, CommentDtoResponse.class));
    }

    @Override
    public Page<CommentDtoResponse> search(CommentDtoRequest commentDtoRequest, Pageable pageable) {
        Page<Comment> comments = this.commentRepository.searchAllByTextLike(commentDtoRequest.getText(), pageable);
        return comments.map(comment -> modelMapper.map(comment, CommentDtoResponse.class));
    }

    @Override
    public Boolean hideComment(UUID id) {
        Comment comment = this.commentRepository.findById(id).orElseThrow(() -> new NotFoundException("Comment Not Found"));
        if (!comment.getHide()) {
            comment.setHide(true);
            commentRepository.save(comment);
            return true;
        }
        return false;
    }

    @Override
    public Boolean ShowComment(UUID id) {
        Comment comment = this.commentRepository.findById(id).orElseThrow(() -> new NotFoundException("Comment Not Found"));
        if (comment.getHide()) {
            comment.setHide(false);
            commentRepository.save(comment);
            return true;
        }
        return false;
    }
}
