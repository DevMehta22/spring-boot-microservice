package com.ratingsdataservice.controller;

import com.ratingsdataservice.model.Rating;
import com.ratingsdataservice.model.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @GetMapping("/{movieId}")
    public Rating getMovieRating(@PathVariable String movieId){
        return new Rating(movieId,4);
    }

    @GetMapping("/users/{userId}")
    public UserRating getMoviesRatingByUserId(@PathVariable String userId){
        return new UserRating(
                Arrays.asList(
                        new Rating("100",5),
                        new Rating("200",4)
                )
        );
    }


}
