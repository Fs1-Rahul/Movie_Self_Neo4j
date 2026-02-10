package com.example.MiniProject;

import java.util.List;
 
public interface MovieService {
    Movie addMovie(Movie movie);
    Movie updateMovie(Integer id, Movie movieDetails);
}