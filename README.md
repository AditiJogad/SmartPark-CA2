# SmartPark – Continuous Assessment 2
**Student:** Aditi Jogad | **Backend:** Java 17, Spring Boot 3.5, Spring Data JPA | **Database:** PostgreSQL

## Features
Available slots; vehicle booking with requested or automatic slot allocation; active booking list; booking details; live fare estimate; checkout/payment status and slot release; daily revenue; Jakarta validation; standardized global errors; Swagger/OpenAPI; JUnit fee tests.

## Pricing
₹50 for every 3-hour block or fraction thereof: `ceil(duration_seconds / 10800) * 50`. Examples: 2h15m ₹50; exactly 3h ₹50; 3h5m ₹100. Zero elapsed time is ₹0 until a positive duration accrues.

## Requirements
JDK 17+, Maven 3.9+, PostgreSQL 14+.

## Database
Create database: `CREATE DATABASE smartpark;` Default connection is `jdbc:postgresql://localhost:5432/smartpark`, user `postgres`, password `postgres`. Override with environment variables `DB_URL`, `DB_USERNAME`, `DB_PASSWORD`. Hibernate creates/updates the development tables. `src/main/resources/schema.sql` is supplied as the schema/migration artifact; it is not auto-executed (`spring.sql.init.mode=never`).

## Run
```bash
mvn clean test
mvn spring-boot:run
```
App: http://localhost:8080 | Swagger: http://localhost:8080/swagger-ui.html

## Seed parking slots once
```sql
INSERT INTO parking_slots(slot_code,status) VALUES ('P-01','AVAILABLE'),('P-02','AVAILABLE'),('P-03','AVAILABLE'),('P-04','AVAILABLE'),('P-05','AVAILABLE'),('P-06','AVAILABLE'),('P-07','AVAILABLE'),('P-08','AVAILABLE'),('P-09','AVAILABLE'),('P-10','AVAILABLE') ON CONFLICT(slot_code) DO NOTHING;
```

## API
| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/api/slots/available` | Available slots |
| POST | `/api/bookings` | Book a slot |
| GET | `/api/bookings/active` | Occupied/active bookings |
| GET | `/api/bookings/{id}` | Booking details |
| GET | `/api/bookings/{id}/fare` | Current fare; optional `?at=2026-10-30T12:00:00` |
| POST | `/api/bookings/{id}/checkout` | Checkout; optional `?exitTime=2026-10-30T12:05:00` |
| GET | `/api/reports/revenue?date=2026-10-30` | Revenue for date |

### Booking request
```json
{"vehicleNumber":"MH31AB1234","slotId":1,"entryTime":"2026-10-30T09:00:00"}
```
`slotId` and `entryTime` are optional. If slot omitted, the first available slot is allocated. If entry time omitted, server time is used.

### Error response
```json
{"timestamp":"2026-10-30T12:00:00","status":404,"error":"Not Found","message":"Booking not found: 999","validationErrors":{}}
```
400 invalid input, 404 missing resource, 409 slot/booking conflict.

## Tests
`mvn test` runs fee edge cases: zero duration, 2h15m, exactly 3h, just over 3h, 6h, 7h and exit-before-entry.

## Before submitting
Run against your own PostgreSQL instance, seed slots, test each endpoint in Postman/Swagger, then push this folder to your GitHub repository. Never commit your real database password.
