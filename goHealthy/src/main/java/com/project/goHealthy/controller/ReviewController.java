package com.project.goHealthy.controller;

import com.project.goHealthy.entity.Reviews;
import com.project.goHealthy.service.ReviewService.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@ControllerAdvice
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/create")
    public ResponseEntity<Reviews> create(@RequestBody Reviews reviews) {
        return ResponseEntity.ok(reviewService.create(reviews));
    }

    @GetMapping("/getAllReviews")
    public ResponseEntity<List<Reviews>> getAllReviews() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }
}
