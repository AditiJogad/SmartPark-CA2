package com.aditi.smartpark.model;
import jakarta.persistence.*; import java.math.BigDecimal; import java.time.LocalDateTime;
@Entity @Table(name="vehicle_bookings",indexes=@Index(name="idx_booking_vehicle_active",columnList="vehicle_number, exit_time"))
public class VehicleBooking {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(name="vehicle_number",nullable=false,length=15) private String vehicleNumber;
 @ManyToOne(fetch=FetchType.EAGER,optional=false) @JoinColumn(name="slot_id",nullable=false) private ParkingSlot slot;
 @Column(name="entry_time",nullable=false) private LocalDateTime entryTime; @Column(name="exit_time") private LocalDateTime exitTime;
 @Column(precision=10,scale=2) private BigDecimal amount;
 @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private PaymentStatus paymentStatus=PaymentStatus.PENDING;
 protected VehicleBooking(){} public VehicleBooking(String v,ParkingSlot s,LocalDateTime e){vehicleNumber=v;slot=s;entryTime=e;}
 public void checkout(LocalDateTime e,BigDecimal a){exitTime=e;amount=a;paymentStatus=PaymentStatus.PAID;}
 public Long getId(){return id;} public String getVehicleNumber(){return vehicleNumber;} public ParkingSlot getSlot(){return slot;} public LocalDateTime getEntryTime(){return entryTime;} public LocalDateTime getExitTime(){return exitTime;} public BigDecimal getAmount(){return amount;} public PaymentStatus getPaymentStatus(){return paymentStatus;} public boolean isActive(){return exitTime==null;}
}
