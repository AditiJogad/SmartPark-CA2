package com.aditi.smartpark.repository;
import com.aditi.smartpark.model.*; import org.springframework.data.jpa.repository.JpaRepository; import java.time.LocalDateTime; import java.util.*;
public interface VehicleBookingRepository extends JpaRepository<VehicleBooking,Long>{ List<VehicleBooking> findByExitTimeIsNullOrderByEntryTimeAsc(); Optional<VehicleBooking> findFirstByVehicleNumberAndExitTimeIsNull(String vehicleNumber); List<VehicleBooking> findByPaymentStatusAndExitTimeBetween(PaymentStatus status,LocalDateTime start,LocalDateTime end); }
