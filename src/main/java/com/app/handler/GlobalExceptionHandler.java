package com.app.handler;

import com.app.exception.AppException;
import com.app.model.ApiError;
import com.app.util.constant.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public final class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private final MessageSourceAccessor messageSourceAccessor;

    public GlobalExceptionHandler(MessageSource messageSource) {
        messageSourceAccessor = new MessageSourceAccessor(messageSource);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> exceptionHandler(Exception e) {
        log.error("Exception = {}", e.getMessage(), e);
        ApiError apiError = new ApiError();
        apiError.setCode(HttpStatus.BAD_REQUEST.getReasonPhrase());

        String message = messageSourceAccessor.getMessage(ErrorMessage.code500);
        apiError.addMessage(message);
        return ResponseEntity.badRequest().body(apiError);
    }


    @ExceptionHandler(AppException.class)
    public ResponseEntity<Object> appExceptionHandler(AppException e) {
        log.error("AppException = {}", e.getMessage(), e);
        ApiError apiError = new ApiError();
        apiError.setCode(e.getCode());

        String message = messageSourceAccessor.getMessage(e.getMessage());
        apiError.addMessage(message);

        return new ResponseEntity<>(apiError, e.getHttpStatus());
    }


}

