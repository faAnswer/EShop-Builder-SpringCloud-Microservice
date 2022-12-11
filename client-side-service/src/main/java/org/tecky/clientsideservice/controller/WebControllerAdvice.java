package org.tecky.clientsideservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.faAnswer.web.util.CustomException;
import org.faAnswer.web.util.json.ResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@ControllerAdvice(annotations = {Controller.class, RestController.class})
public class WebControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<?> errorHandler(Exception ex) throws JsonProcessingException {

        if (ex instanceof MethodArgumentNotValidException) {

            List<ObjectError> errors = ((MethodArgumentNotValidException) ex).getBindingResult().getAllErrors();

            Map<String, String> map = new HashMap<>();

            for(ObjectError e : errors){

                FieldError err = (FieldError) e;

                map.put(err.getField(), err.getDefaultMessage());
            }

            return ResponseObject
                    .builder()
                    .setPayLoad(map)
                    .create(400);

        }

        if (ex.getClass() == CustomException.class) {

            return ResponseObject
                    .builder()
                    .setPayLoad("message", ex.getMessage())
                    .create(((CustomException) ex).getCode());

        }

        return ResponseObject
                .builder()
                .setPayLoad("message", ex.getMessage())
                .create(500);
    }
}