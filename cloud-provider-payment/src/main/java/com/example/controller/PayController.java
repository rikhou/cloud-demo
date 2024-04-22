package com.example.controller;

import com.example.entities.Pay;
import com.example.entities.PayDTO;
import com.example.service.PayService;
import com.example.util.BeanCopyUtil;
import com.example.util.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@Tag(name = "Payment module",description = "Payment service")
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping("/add")
    @Operation(summary = "新增", description = "新增支付流水, 参数是JSON字符串")
    public Result<Integer> addPay(@RequestBody PayDTO payDTO) {
        try {
            Pay pay = new Pay();
            BeanUtils.copyProperties(payDTO, pay);
            return Result.success(payService.add(pay));
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    @DeleteMapping("/del/{id}")
    @Operation(summary = "删除", description = "删除支付流水, 参数是Id")
    public Result<Integer> deletePay(@PathVariable("id") Integer id) {
        try {
            return Result.success(payService.delete(id));
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    @PutMapping("/update")
    @Operation(summary = "更新", description = "更新支付流水, 参数是JSON字符串, 根据Id更新")
    public Result<Integer> updatePay(@RequestBody PayDTO payDTO) {
        try {
            Pay pay = new Pay();
            BeanUtils.copyProperties(payDTO, pay);
            return Result.success(payService.update(pay));
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "查询单个", description = "查询支付流水, 参数是Id")
    public Result<PayDTO> getById(@PathVariable("id") Integer id) {
        PayDTO payDTO = new PayDTO();
        BeanUtils.copyProperties(payService.getById(id), payDTO);
        return Result.success(payDTO);
    }

    @GetMapping("/getAll")
    @Operation(summary = "查询所有", description = "查询所有支付流水")
    public Result<List<PayDTO>> getAll() {
        try {
            List<Pay> pays = payService.getAll();
            List<PayDTO> payDTOs = BeanCopyUtil.copyListProperties(pays, PayDTO::new);
            return Result.success(payDTOs);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }
    @GetMapping(value = "test/{id}")
    public Result<String> test(@PathVariable("id") Integer id) {
        return Result.success("OK");
    }
}
