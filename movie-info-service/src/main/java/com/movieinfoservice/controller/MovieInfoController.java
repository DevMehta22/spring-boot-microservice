package com.movieinfoservice.controller;

import com.movieinfoservice.model.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {

    @GetMapping("/{movieId}")
    private Movie getMovie(@PathVariable String movieId){

        return new Movie(movieId,"Transformers");
    }

}
