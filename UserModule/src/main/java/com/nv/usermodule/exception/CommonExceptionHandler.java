package com.nv.usermodule.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nv.usermodule.dto.ExceptionDTOResponse;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class CommonExceptionHandler {

              
 @ExceptionHandler
 public ResponseEntity<ExceptionDTOResponse> invalidName(InvalidUserException e)
 {
  ExceptionDTOResponse dto = new ExceptionDTOResponse();
  dto.setErrorMsg(e.toString());
  dto.setDatetime(LocalDateTime.now()+"");
  return new ResponseEntity<ExceptionDTOResponse>(dto,HttpStatus.BAD_REQUEST);
 }
              
 @ExceptionHandler
 public ResponseEntity<ExceptionDTOResponse> invalidPassword(NullPointerException e)
 {
  ExceptionDTOResponse dto = new ExceptionDTOResponse();
  dto.setErrorMsg(e.toString());
  dto.setDatetime(LocalDateTime.now()+"");
  return new ResponseEntity<ExceptionDTOResponse>(dto,HttpStatus.BAD_REQUEST);
 }
              
              
              
              
}
