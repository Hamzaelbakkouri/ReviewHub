package com.app.ReviewHub.Services.Implementation;

import com.app.ReviewHub.Model.Dto.Review.ReviewDtoReq;
import com.app.ReviewHub.Model.Dto.Review.ReviewDtoResp;
import com.app.ReviewHub.Repository.ReviewRepository;
import com.app.ReviewHub.Services.Interface.Review_S_Interface;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class ReviewService implements Review_S_Interface {
    private ReviewRepository reviewRepository;

    @Override
    public ReviewDtoResp save(ReviewDtoReq reviewDtoReq) {
        return null;
    }

    @Override
    public ReviewDtoResp find(UUID uuid) {
        return null;
    }

    @Override
    public Boolean remove(UUID uuid) {
        return null;
    }

    @Override
    public Page<ReviewDtoResp> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Page<ReviewDtoResp> search(ReviewDtoReq reviewDtoReq, Pageable pageable) {
        return null;
    }
}
