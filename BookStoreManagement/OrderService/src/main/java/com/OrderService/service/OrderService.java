package com.OrderService.service;

import com.OrderService.exceptions.OrderNotFoundException;
import com.OrderService.exceptions.InvalidOrderException;
import com.OrderService.exceptions.InsufficientStockException;
import com.OrderService.model.Order;
import com.OrderService.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(String id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            return orderOptional.get();
        } else {
            throw new OrderNotFoundException("Order with ID " + id + " not found");
        }
    }

    public Order saveOrder(Order order) {
        if (order.getQuantity() <= 0) {
            throw new InvalidOrderException("Quantity must be greater than 0");
        }

        // Additional logic to check stock availability with Book Service
        // Check stock availability logic should be implemented here
        // Example:
        // int availableStock = bookClient.getBookStock(order.getBookId());
        // if (availableStock < order.getQuantity()) {
        //     throw new InsufficientStockException("Not enough stock for book with ID " + order.getBookId());
        // }

        return orderRepository.save(order);
    }

    public void deleteOrder(String id) {
        boolean exists = orderRepository.existsById(id);
        if (!exists) {
            throw new OrderNotFoundException("Order with ID " + id + " not found");
        }
        orderRepository.deleteById(id);
    }
}
