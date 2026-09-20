# Architecture

Client -> Order Service -> PostgreSQL
                     |
                     v
                   Kafka
              /       |       \
       Inventory   Payment   Notification

The order service owns order state. Kafka provides asynchronous communication
between services. Consumers should be idempotent because Kafka delivery can be
repeated.
