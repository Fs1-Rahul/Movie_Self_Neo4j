package com.example.MiniProject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 
// This annotation tells Spring to return a 404 status whenever this is thrown
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException()
	{}
	public ResourceNotFoundException(String message) {
        super(message);
    }
}