package com.aditi.smartpark.controller;
import com.aditi.smartpark.dto.*;import com.aditi.smartpark.model.ParkingSlot;import com.aditi.smartpark.service.ParkingService;import jakarta.validation.Valid;import org.springframework.format.annotation.DateTimeFormat;import org.springframework.http.HttpStatus;import org.springframework.web.bind.annotation.*;import java.time.*;import java.util.List;
@RestController @RequestMapping("/api") public class ParkingController {private final ParkingService service;public ParkingController(ParkingService s){service=s;}
 @GetMapping("/slots/available") public List<ParkingSlot> available(){return service.availableSlots();}
 @PostMapping("/bookings") @ResponseStatus(HttpStatus.CREATED) public BookingResponse book(@Valid @RequestBody BookingRequest r){return service.book(r);}
 @GetMapping("/bookings/active") public List<BookingResponse> active(){return service.activeBookings();}
 @GetMapping("/bookings/{id}") public BookingResponse get(@PathVariable Long id){return service.getBooking(id);}
 @GetMapping("/bookings/{id}/fare") public FareResponse fare(@PathVariable Long id,@RequestParam(required=false) @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime at){return service.fare(id,at);}
 @PostMapping("/bookings/{id}/checkout") public CheckoutResponse checkout(@PathVariable Long id,@RequestParam(required=false) @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime exitTime){return service.checkout(id,exitTime);}
 @GetMapping("/reports/revenue") public RevenueResponse revenue(@RequestParam(required=false) @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate date){return service.revenue(date);}}
