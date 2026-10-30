package com.aditi.smartpark.dto;
import java.math.BigDecimal; import java.time.LocalDateTime;
public record FareResponse(Long bookingId,String vehicleNumber,LocalDateTime entryTime,LocalDateTime calculatedAt,long durationMinutes,BigDecimal estimatedFee){}
