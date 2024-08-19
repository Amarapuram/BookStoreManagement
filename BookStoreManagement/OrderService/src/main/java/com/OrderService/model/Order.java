package com.OrderService.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    private String id;

    @NotEmpty(message = "Customer ID cannot be empty")
    private String custId;

    @NotEmpty(message = "Book ID cannot be empty")
    private String bookId;

    @NotNull(message = "Quantity cannot be null")
    @Min(value = 1, message = "Quantity must be at least 1")
    private long quantity;

    @NotEmpty(message = "Status cannot be empty")
    @Pattern(regexp = "PENDING|CONFIRMED|CANCELLED", message = "Invalid status. Valid values are: PENDING, CONFIRMED, CANCELLED")
    private String status;
}
