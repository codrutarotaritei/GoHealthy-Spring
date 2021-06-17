package com.project.goHealthy.service.ReviewService;

import com.project.goHealthy.entity.Reviews;
import com.project.goHealthy.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    public Reviews create(Reviews reviews) {
        return reviewRepository.save(reviews);
    }

    @Override
    public List<Reviews> getAllReviews() {
        return (List<Reviews>) reviewRepository.findAll();
    }
}
