package streaming.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import streaming.backend.dtos.ApiResponseDto;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptions {
    @ExceptionHandler(Exception.class)
    public ResponseEntity badRequestException(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponseDto(
                false,
                errors,
                "Error in payload."
        ));
    }
}
