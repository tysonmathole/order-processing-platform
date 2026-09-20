package com.tyson.inventory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class InventoryConsumer {
 @KafkaListener(topics="order.created", groupId="inventory-service")
 public void consume(String event) {
   // Reserve inventory idempotently in a real implementation.
 }
}
