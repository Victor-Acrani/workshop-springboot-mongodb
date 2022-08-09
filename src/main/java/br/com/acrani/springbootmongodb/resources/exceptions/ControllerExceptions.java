package br.com.acrani.springbootmongodb.resources.exceptions;

import br.com.acrani.springbootmongodb.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptions {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandartError> resourceNotFoundException(RuntimeException e, HttpServletRequest request){

        String error = "Resource not found!";
        Map<String,String> message = new HashMap<>();
        message.put("Id:", e.getMessage());

        StandartError standartError = new StandartError(LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(), error, message, request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standartError);
    }
}
