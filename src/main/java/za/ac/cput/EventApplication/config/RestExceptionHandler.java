package za.ac.cput.EventApplication.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import za.ac.cput.EventApplication.models.ErrorDto;
import za.ac.cput.EventApplication.services.AppException;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = {AppException.class})
    @ResponseBody
    public ResponseEntity<ErrorDto> handleException(AppException ex) {
        return ResponseEntity.status(ex.getStatus())
                .body(new ErrorDto(ex.getMessage()));
    }

}
