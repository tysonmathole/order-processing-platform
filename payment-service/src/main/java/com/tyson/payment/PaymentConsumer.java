package com.tyson.payment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentConsumer {
 @KafkaListener(topics="order.created", groupId="payment-service")
 public void consume(String event) {
   // Charge payment with an idempotency key in a real implementation.
 }
}
