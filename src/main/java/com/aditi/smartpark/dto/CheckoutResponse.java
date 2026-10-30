package com.aditi.smartpark.dto;
import java.math.BigDecimal; import java.time.LocalDateTime;
public record CheckoutResponse(Long bookingId,String vehicleNumber,String slotCode,LocalDateTime entryTime,LocalDateTime exitTime,BigDecimal totalFee,String paymentStatus,String message){}
