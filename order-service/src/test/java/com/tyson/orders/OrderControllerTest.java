package com.tyson.orders;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderControllerTest {
 @Test
 void sameIdempotencyKeyReturnsSameOrder() {
   var controller = new OrderController();
   var request = new OrderController.CreateOrderRequest("SKU-1", 2);
   var first = controller.create(request, "key-1");
   var second = controller.create(request, "key-1");
   assertEquals(first.orderId(), second.orderId());
 }
}
