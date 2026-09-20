package com.tyson.orders;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final ConcurrentHashMap<String, OrderResponse> orders = new ConcurrentHashMap<>();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse create(@Valid @RequestBody CreateOrderRequest request,
                                @RequestHeader("Idempotency-Key") String idempotencyKey) {
        return orders.computeIfAbsent(idempotencyKey,
            key -> new OrderResponse(UUID.randomUUID().toString(), request.productId(),
                                     request.quantity(), "CREATED"));
    }

    public record CreateOrderRequest(
        @NotBlank String productId,
        @Positive int quantity) {}

    public record OrderResponse(
        String orderId, String productId, int quantity, String status) {}
}
