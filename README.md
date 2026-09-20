# Order Processing Platform

A production-style Java 21 / Spring Boot backend demo for an order-processing platform.

## Highlights
- REST APIs
- PostgreSQL persistence
- Kafka event-driven processing
- Idempotent order creation
- Optimistic locking
- Bean validation
- Docker Compose
- Spring Boot Actuator
- Unit/integration-test structure
- GitHub Actions CI

## Services
- order-service
- inventory-service
- payment-service
- notification-service

## Run
```bash
docker compose up --build
```

See `architecture/` for the high-level design.
