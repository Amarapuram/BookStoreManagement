package com.OrderService.feignClients;

import com.OrderService.dto.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient("book-service")
public interface BookServiceClient {
    @GetMapping("/api/books/{id}")
    Book getBookById(@PathVariable Long id);
}
