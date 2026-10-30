package com.aditi.smartpark.dto;
import java.math.BigDecimal; import java.time.LocalDate;
public record RevenueResponse(LocalDate date,BigDecimal totalRevenue,long paidBookings){}
