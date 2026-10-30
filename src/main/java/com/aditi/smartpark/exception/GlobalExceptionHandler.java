package com.aditi.smartpark.exception;
import jakarta.validation.ConstraintViolationException; import org.springframework.dao.DataIntegrityViolationException; import org.springframework.http.*; import org.springframework.web.bind.MethodArgumentNotValidException; import org.springframework.web.bind.annotation.*; import org.springframework.http.converter.HttpMessageNotReadableException; import java.time.LocalDateTime; import java.util.*;
@RestControllerAdvice public class GlobalExceptionHandler {
 @ExceptionHandler(ResourceNotFoundException.class) public ResponseEntity<ApiError> missing(ResourceNotFoundException e){return make(HttpStatus.NOT_FOUND,e.getMessage(),Map.of());}
 @ExceptionHandler({ConflictException.class,DataIntegrityViolationException.class}) public ResponseEntity<ApiError> conflict(Exception e){return make(HttpStatus.CONFLICT,e instanceof ConflictException?e.getMessage():"Database conflict",Map.of());}
 @ExceptionHandler({BadRequestException.class,IllegalArgumentException.class,HttpMessageNotReadableException.class,ConstraintViolationException.class}) public ResponseEntity<ApiError> bad(Exception e){return make(HttpStatus.BAD_REQUEST,e.getMessage(),Map.of());}
 @ExceptionHandler(MethodArgumentNotValidException.class) public ResponseEntity<ApiError> invalid(MethodArgumentNotValidException e){Map<String,String> m=new LinkedHashMap<>();e.getBindingResult().getFieldErrors().forEach(x->m.put(x.getField(),x.getDefaultMessage()));return make(HttpStatus.BAD_REQUEST,"Validation failed",m);}
 @ExceptionHandler(Exception.class) public ResponseEntity<ApiError> other(Exception e){return make(HttpStatus.INTERNAL_SERVER_ERROR,"An unexpected error occurred",Map.of());}
 private ResponseEntity<ApiError> make(HttpStatus s,String m,Map<String,String> v){return ResponseEntity.status(s).body(new ApiError(LocalDateTime.now(),s.value(),s.getReasonPhrase(),m,v));}
}
