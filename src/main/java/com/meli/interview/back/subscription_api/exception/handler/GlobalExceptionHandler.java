package com.meli.interview.back.subscription_api.exception.handler;

import com.meli.interview.back.subscription_api.datos.DTO.ResponseInfoDTO;
import com.meli.interview.back.subscription_api.exception.UserNotLoggedInException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({UserNotLoggedInException.class})
    public ResponseEntity<ResponseInfoDTO> userNotLoggedInException(UserNotLoggedInException userNotLoggedInException, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ResponseInfoDTO(userNotLoggedInException.getMessage(),
                request.getRequestURI(),
                HttpStatus.FORBIDDEN.value()));
    }
}
