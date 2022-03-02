package it.unikey.acadesteam.PL.controller;

import it.unikey.acadesteam.BLL.dto.ReviewDto;
import it.unikey.acadesteam.BLL.service.impl.ReviewService;
import it.unikey.acadesteam.PL.mapper.ReviewRestMapper;
import it.unikey.acadesteam.PL.rest.ReviewRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewRestMapper reviewMapper;

    @PostMapping
    private ResponseEntity<ReviewRest> postReview(@RequestBody ReviewRest review) {
        ReviewDto reviewDto = reviewService.insert(reviewMapper.fromReviewRestToReviewDto(review));
        return new ResponseEntity<>(reviewMapper.fromReviewDtoToReviewRest(reviewDto), HttpStatus.OK);
    }

}
