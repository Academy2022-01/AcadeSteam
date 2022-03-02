package it.unikey.acadesteam.PL.controller;

import it.unikey.acadesteam.BLL.dto.ReviewDto;
import it.unikey.acadesteam.BLL.exception.NotFoundException;
import it.unikey.acadesteam.BLL.service.impl.ReviewService;
import it.unikey.acadesteam.PL.mapper.ReviewRestMapper;
import it.unikey.acadesteam.PL.rest.ReviewRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewRestMapper reviewMapper;

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


}
