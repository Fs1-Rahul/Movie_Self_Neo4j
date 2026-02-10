package com.example.MiniProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class MovieServiceImpl implements MovieService {
 
    @Autowired
    private MovieRepository movieRepository;
 
    @Override
    public Movie addMovie(Movie movie) {
        // Business logic could go here (e.g., checking if revenue is negative)
    	if(movieRepository.existsById(movie.getId())) {
    		throw new IdAlreadyExistsException(" Id:{movie.getId()} Already Exists");
    	}
    	System.out.println(movieRepository.existsById(movie.getId())+" "+movie.getId());
    	return movieRepository.save(movie);
    	}
 
    @Override
    public Movie updateMovie(Integer id, Movie movieDetails) {
        // The Service handles the logic of finding and then mapping new data
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));
        
        movie.setTitle(movieDetails.getTitle());
        movie.setUpvotes(movieDetails.getUpvotes());
        movie.setRevenue(movieDetails.getRevenue());
        movie.setReleased(movieDetails.getReleased());
        
        return movieRepository.save(movie);
    }
}