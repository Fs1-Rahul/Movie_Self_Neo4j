package com.example.MiniProject;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import java.util.List;
import jakarta.validation.constraints.Min;

@Node
public class Movie {
    @Id
    private Integer id;
    private String title;
    @Min(value = 100,message="Minimum 100 upvotes")
    private Integer upvotes;
    private Long revenue;
    private Integer released;
    
    public Movie() {}
    public Movie(Integer Id, String title, Integer upvotes, Long revenue,Integer released) {
    	this.id=Id;
    	this.title=title;
    	this.upvotes=upvotes;
    	this.revenue=revenue;
    	this.released=released;
    }
    public Integer getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public Integer getReleased() {
        return released;
    }
    public Integer getUpvotes() {
        return upvotes;
    }
    public Long getRevenue() {
        return revenue;
    }
    public void setId(int Id) {
        this.id = Id;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }
 
    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }
 
    public void setReleased(int released) {
        this.released = released;
    }
}
    
