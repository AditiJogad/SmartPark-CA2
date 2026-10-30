package com.aditi.smartpark.dto;
import com.aditi.smartpark.model.*; import java.math.BigDecimal; import java.time.LocalDateTime;
public record BookingResponse(Long bookingId,String vehicleNumber,Long slotId,String slotCode,LocalDateTime entryTime,LocalDateTime exitTime,BigDecimal amount,PaymentStatus paymentStatus){public static BookingResponse from(VehicleBooking b){return new BookingResponse(b.getId(),b.getVehicleNumber(),b.getSlot().getId(),b.getSlot().getSlotCode(),b.getEntryTime(),b.getExitTime(),b.getAmount(),b.getPaymentStatus());}}
