-- PostgreSQL schema reference. Hibernate ddl-auto=update manages the development schema.
CREATE TABLE IF NOT EXISTS parking_slots (id BIGSERIAL PRIMARY KEY,slot_code VARCHAR(20) NOT NULL UNIQUE,status VARCHAR(20) NOT NULL DEFAULT 'AVAILABLE');
CREATE TABLE IF NOT EXISTS vehicle_bookings (id BIGSERIAL PRIMARY KEY,vehicle_number VARCHAR(15) NOT NULL,slot_id BIGINT NOT NULL REFERENCES parking_slots(id),entry_time TIMESTAMP NOT NULL,exit_time TIMESTAMP NULL,amount NUMERIC(10,2) NULL,payment_status VARCHAR(20) NOT NULL DEFAULT 'PENDING');
CREATE INDEX IF NOT EXISTS idx_booking_vehicle_active ON vehicle_bookings(vehicle_number,exit_time);
