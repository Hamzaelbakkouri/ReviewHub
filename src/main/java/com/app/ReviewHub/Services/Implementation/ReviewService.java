package com.app.ReviewHub.Services.Implementation;

import com.app.ReviewHub.Exceptions.NotFoundException;
import com.app.ReviewHub.Model.Dto.Review.ReviewDtoReq;
import com.app.ReviewHub.Model.Dto.Review.ReviewDtoResp;
import com.app.ReviewHub.Model.Entity.Review;
import com.app.ReviewHub.Repository.ReviewRepository;
import com.app.ReviewHub.Services.Interface.Review_S_Interface;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ReviewService implements Review_S_Interface {
    private ReviewRepository reviewRepository;
    private ModelMapper modelMapper;

    @Override
    public ReviewDtoResp save(ReviewDtoReq reviewDtoReq) {
        Review review = this.modelMapper.map(reviewDtoReq, Review.class);
        return this.modelMapper.map(this.reviewRepository.save(review), ReviewDtoResp.class);
    }

    @Override
    public ReviewDtoResp find(UUID uuid) {
        return this.modelMapper.map(this.reviewRepository.findById(uuid).orElseThrow(
                        () -> new NotFoundException("Review Not Found")),
                ReviewDtoResp.class
        );
    }

    @Override
    public Boolean remove(UUID uuid) {
        Optional<Review> review = this.reviewRepository.findById(uuid);
        if (review.isPresent()) {
            this.reviewRepository.deleteById(uuid);
            return true;
        }
        throw new NotFoundException("Review Not found");
    }

    @Override
    public Page<ReviewDtoResp> findAll(Pageable pageable) {
        Page<Review> reviews = this.reviewRepository.findAll(pageable);
        return reviews.map(review -> modelMapper.map(review, ReviewDtoResp.class));
    }

    @Override
    public Page<ReviewDtoResp> search(ReviewDtoReq reviewDtoReq, Pageable pageable) {
        Page<Review> reviews = this.reviewRepository.searchAllByTitleLike(reviewDtoReq.getTitle(), pageable);
        return reviews.map(review -> modelMapper.map(review, ReviewDtoResp.class));
    }
}
