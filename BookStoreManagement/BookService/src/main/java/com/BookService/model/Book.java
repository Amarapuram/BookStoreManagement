package com.BookService.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private String id;

    @NotEmpty(message = "Title cannot be empty")
    @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
    private String title;

    @NotEmpty(message = "Author cannot be empty")
    private String author;

    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be positive")
    private String price;

    @NotNull(message = "Stock cannot be null")
    @Positive(message = "Stock must be positive")
    private String stock;
}
