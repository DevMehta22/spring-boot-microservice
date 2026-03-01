package com.movieinfoservice.controller;

import com.movieinfoservice.model.Movie;
import com.movieinfoservice.model.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {

    @Value("${moviedb.api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{movieId}")
    private Movie getMovie(@PathVariable String movieId){

        MovieSummary movieSummary = restTemplate
                .getForObject("https://api.themoviedb.org/3/movie/"+movieId +"?api_key="+apiKey, MovieSummary.class);

        return new Movie(movieId, movieSummary != null ? movieSummary.getTitle() : null, movieSummary != null ? movieSummary.getOverview() : null);
    }

}
