package com.aditi.smartpark.repository;
import com.aditi.smartpark.model.*; import org.springframework.data.jpa.repository.*; import org.springframework.data.repository.query.Param; import jakarta.persistence.LockModeType; import java.util.List;
public interface ParkingSlotRepository extends JpaRepository<ParkingSlot,Long>{ List<ParkingSlot> findByStatusOrderBySlotCodeAsc(SlotStatus status); @Lock(LockModeType.PESSIMISTIC_WRITE) @Query("select s from ParkingSlot s where s.status=:status order by s.id") List<ParkingSlot> findAvailableForUpdate(@Param("status") SlotStatus status); }
