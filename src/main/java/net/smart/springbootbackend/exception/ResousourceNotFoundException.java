package net.smart.springbootbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResousourceNotFoundException extends RuntimeException{
    
    public ResousourceNotFoundException(String message){
        super(message);
    }
}
