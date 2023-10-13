package com.prm.japaneseapp.exception;

import com.prm.japaneseapp.model.response.ResponseFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final ResponseFactory responseFactory;

    @ExceptionHandler(BadCredentialsException.class)
    public CustomExceptionBody handleExceptionA(Exception e) {
        return new CustomExceptionBody(e);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUnwantedException(Exception e) {
        log.error(e.getMessage(), e.getStackTrace());
        return ResponseEntity.status(500).body(e.getMessage());
    }

//    @ResponseBody
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return this.createResponse(ResponseStatusCode.VALIDATION_FAILED, errors);
//    }

//    @ExceptionHandler({AuthenticationException.class})
//    @ResponseBody
//    public ResponseEntity<Object> handleAuthenticationException(AuthenticationException ex) {
////        responseFactory.success();
////        RestError re = new RestError(HttpStatus.UNAUTHORIZED.toString(),
////                "Authentication failed at controller advice");
////        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(re);
//        return this.createResponse(ResponseStatusCode.VALIDATION_FAILED, "errors");
//    }

//    private ResponseEntity<Object> createResponse(ResponseStatusCode response, Object errors) {
//        ResponseStatus responseStatus = new ResponseStatus(response);
//        GeneralResponse<Object> responseObject = new GeneralResponse<>();
//        responseObject.setStatus(responseStatus);
//        responseObject.setData(errors);
//        return new ResponseEntity<>(responseObject, HttpStatus.valueOf(response.getCode()));
//    }

}
