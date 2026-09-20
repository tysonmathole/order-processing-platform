package com.tyson.notification;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {
 @KafkaListener(topics="order.created", groupId="notification-service")
 public void consume(String event) {
   // Send notification with retry/DLQ handling in a real implementation.
 }
}
