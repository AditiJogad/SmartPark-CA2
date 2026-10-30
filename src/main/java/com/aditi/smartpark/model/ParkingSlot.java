package com.aditi.smartpark.model;
import jakarta.persistence.*;
@Entity @Table(name="parking_slots") public class ParkingSlot {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true,length=20) private String slotCode;
 @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private SlotStatus status=SlotStatus.AVAILABLE;
 protected ParkingSlot(){} public ParkingSlot(String code){slotCode=code;status=SlotStatus.AVAILABLE;}
 public Long getId(){return id;} public String getSlotCode(){return slotCode;} public SlotStatus getStatus(){return status;}
 public void occupy(){status=SlotStatus.OCCUPIED;} public void release(){status=SlotStatus.AVAILABLE;}
}
