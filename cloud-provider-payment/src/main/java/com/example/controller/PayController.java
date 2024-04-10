package com.example.controller;

import com.example.util.Result;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Payment module",description = "Payment service")
public class PayController {
    @GetMapping(value = "payment/get/{id}")
    public Result<String> getById(@PathVariable("id") Integer id) {
        return Result.success("OK");
    }
}
