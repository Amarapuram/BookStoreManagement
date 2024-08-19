package com.OrderService.feignClients;

import com.OrderService.dto.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CustomerService")
public interface CustomerServiceClient {
    @GetMapping("api/customers/{id}")
    Customer getCustomerById(@PathVariable("id") String id);
}

