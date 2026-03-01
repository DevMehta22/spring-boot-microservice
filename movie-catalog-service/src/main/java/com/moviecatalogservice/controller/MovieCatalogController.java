package com.moviecatalogservice.controller;

import com.moviecatalogservice.model.CatalogItem;
import com.moviecatalogservice.model.Movie;
import com.moviecatalogservice.model.Rating;
import com.moviecatalogservice.model.UserRating;
import com.moviecatalogservice.service.MovieCatalogService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private MovieCatalogService movieCatalogService;

    @GetMapping("/{userId}")
    public List<CatalogItem> getMovieList(@PathVariable String userId){

        UserRating userRating = movieCatalogService.getUserRating(userId);

        return userRating != null ? userRating.getUserRating().stream().map(rating -> {
                    Movie movie = movieCatalogService.getMovie(rating);
                    return new CatalogItem(movie != null ? movie.getMovieName() : null, movie != null ? movie.getDescription() : null, rating.getRating());
                }).toList() : null;


    }
}
