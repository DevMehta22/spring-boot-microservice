package com.moviecatalogservice.service;

import com.moviecatalogservice.model.Movie;
import com.moviecatalogservice.model.Rating;
import com.moviecatalogservice.model.UserRating;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MovieCatalogService {

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "movieInfo",fallbackMethod = "getFallbackMovieInfo")
    public @Nullable Movie getMovie(Rating rating) {
        return restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
    }

    @CircuitBreaker(name = "userRating",fallbackMethod = "getFallbackUserRating")
    public @Nullable UserRating getUserRating(String userId) {
        return restTemplate.getForObject("http://ratings-data-service/rating/users/" + userId, UserRating.class);
    }

    private Movie getFallbackMovieInfo(Rating rating, Throwable t){
        return new Movie("","No movie found","");
    }

    private UserRating getFallbackUserRating(String userId, Throwable t){
        return new UserRating(List.of(new Rating("No user rated movies",0)));
    }
}
