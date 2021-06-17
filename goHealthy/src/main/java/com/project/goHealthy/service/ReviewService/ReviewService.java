package com.project.goHealthy.service.ReviewService;

import com.project.goHealthy.entity.Reviews;

import java.util.List;

public interface ReviewService {

    Reviews create(Reviews reviews);

    List<Reviews> getAllReviews();


}
