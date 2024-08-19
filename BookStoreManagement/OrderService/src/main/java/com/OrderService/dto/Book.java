package com.OrderService.dto;

import org.springframework.data.annotation.Id;

public class Book {
    @Id
    private String id;
    private String title;
    private String author;
    private String price;
    private String stock;

}
