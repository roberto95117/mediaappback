package com.xocop.mediaappbackend.exception;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//anotacion para que sea reconocida como clase de exceptions
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModelNotFoundException  extends  RuntimeException{

    public ModelNotFoundException(String message){
        super(message);
    }



}
