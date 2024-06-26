package com.example.controller;

import com.example.util.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

//    public static final String payment_url = "http://localhost:8001";
    public static final String payment_url = "http://cloud-payment-service";
    @Resource

    private RestTemplate restTemplate;

    @GetMapping(value = "order/get/{id}")
    public Object getOrder(@PathVariable("id") Integer id) {
        Object obj = restTemplate.getForObject(payment_url + "/payment/get/" + id, Result.class, id);
//        System.out.println(obj);
        return obj;
    }

}
