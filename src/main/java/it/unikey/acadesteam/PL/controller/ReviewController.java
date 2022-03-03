package it.unikey.acadesteam.PL.controller;

import it.unikey.acadesteam.BLL.dto.ReviewDto;
import it.unikey.acadesteam.BLL.exception.NotFoundException;
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
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/{id}")
    private ResponseEntity<ReviewRest> getReviewById(@PathVariable("id") Integer id){
        try {
            ReviewDto dto = reviewService.getById(id);
            return new ResponseEntity<>(reviewMapper.fromReviewDtoToReviewRest(dto), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(path = "/{id}")
    private ResponseEntity<Void> deleteReview(@PathVariable("id") Integer id){
        try {
            reviewService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    private ResponseEntity<ReviewRest> updateReview (@RequestBody ReviewRest reviewRest){
        try{
            ReviewDto reviewDto  = reviewMapper.fromReviewRestToReviewDto(reviewRest);
            ReviewDto dtoSaved= reviewService.update(reviewDto);
            return new ResponseEntity<>(reviewMapper.fromReviewDtoToReviewRest(dtoSaved), HttpStatus.OK);
        }
        catch (NotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
