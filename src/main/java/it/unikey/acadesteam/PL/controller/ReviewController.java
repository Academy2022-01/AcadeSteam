package it.unikey.acadesteam.PL.controller;

import it.unikey.acadesteam.BLL.service.impl.ReviewService;
import it.unikey.acadesteam.PL.mapper.ReviewRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewRestMapper reviewMapper;

}
