package com.example.handler;

import com.example.util.Result;
import com.example.util.ReturnCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<String> exception(Exception e) {
        e.printStackTrace();
        System.out.println("Global Exception Handler");
        log.error(e.getMessage());
        return Result.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
    }
}
