package com.aditi.smartpark.dto;
import jakarta.validation.constraints.*; import java.time.LocalDateTime;
public record BookingRequest(@NotBlank @Pattern(regexp="(?i)^[A-Z]{2}[0-9]{1,2}[A-Z]{0,3}[0-9]{1,4}$",message="Use a valid vehicle registration, e.g. MH31AB1234") String vehicleNumber,@Positive Long slotId,LocalDateTime entryTime){}
