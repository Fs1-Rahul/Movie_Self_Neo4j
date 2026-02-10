package com.example.MiniProject;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
 
@Repository
public interface MovieRepository extends Neo4jRepository<Movie, Integer> {
 
    // Derived query: Finds movies with upvotes greater than a specific number
    List<Movie> findByUpvotesGreaterThan(Integer votes);
 
    // Custom Cypher query: Finds movies by a title keyword (case-insensitive)
    @Query("MATCH (m:Movie) WHERE m.title CONTAINS $keyword RETURN m")
    List<Movie> findByTitleContaining(String keyword);
    
    @Query("MATCH (m:Movie) WHERE m.id=$keyword RETURN m")
    Movie FindbyId(Integer id);
}
