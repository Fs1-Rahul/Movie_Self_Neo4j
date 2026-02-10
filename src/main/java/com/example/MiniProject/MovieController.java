package com.example.MiniProject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
 
@RestController
@RequestMapping("/movies")
public class MovieController {
 
    @Autowired
    private MovieService movieService;
 
    @Autowired
    private MovieRepository movieRepository;
 
    // Use Service for adding
    @PostMapping("/add")
    public ResponseEntity<Movie> addMovie(@Valid @RequestBody Movie movie) {
        return new ResponseEntity<>(movieService.addMovie(movie), HttpStatus.CREATED);
    }
 
    // Use Repository for direct fetch
    @GetMapping("/list")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
 
    // Use Repository for simple existence check and Service for update logic
    @GetMapping("/{id}")
    public Movie FindMovie(@PathVariable Integer id, @RequestBody Movie movieDetails) {
        return movieRepository.FindbyId(id);
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Integer id) {
        if (!movieRepository.existsById(id)) {
            throw new ResourceNotFoundException("Delete failed: Movie " + id + " not found.");
        }
        movieRepository.deleteById(id);
        return ResponseEntity.ok("Successfully deleted movie " + id);
    }
 
    // --- EXCEPTION HANDLING ---
 
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleMovieNotFound(ResourceNotFoundException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("error", "Resource Not Found");
        response.put("message", ex.getMessage());
        response.put("status", HttpStatus.NOT_FOUND.value());
        
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = IdAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNoSuchMovieExistsException(IdAlreadyExistsException ex) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }
}