package com.blogapp111.exception;

import com.blogapp111.dto.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
   @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorDetail> handleResourceNotFoundException(
           ResourceNotFound e, WebRequest webRequest){
          ErrorDetail error=new ErrorDetail(new Date(),e.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> globalExceptionHandler(Exception e){
//
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
@ExceptionHandler(Exception.class)
public ResponseEntity<ErrorDetail> globalExceptionHandler(
        Exception e,WebRequest webRequest){
   ErrorDetail error=new ErrorDetail(new Date(),e.getMessage(),webRequest.getDescription(false));
    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
}
}
