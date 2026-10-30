package com.aditi.smartpark.service;
import org.junit.jupiter.api.Test;import java.math.BigDecimal;import java.time.LocalDateTime;import static org.junit.jupiter.api.Assertions.*;
class FeeCalculatorTest {private final LocalDateTime entry=LocalDateTime.of(2026,10,30,9,0);
 @Test void zeroDuration(){assertEquals(new BigDecimal("0.00"),FeeCalculator.calculate(entry,entry));}
 @Test void twoHoursFifteenMinutes(){assertEquals(new BigDecimal("50.00"),FeeCalculator.calculate(entry,entry.plusMinutes(135)));}
 @Test void exactlyThreeHours(){assertEquals(new BigDecimal("50.00"),FeeCalculator.calculate(entry,entry.plusHours(3)));}
 @Test void justOverThreeHours(){assertEquals(new BigDecimal("100.00"),FeeCalculator.calculate(entry,entry.plusHours(3).plusSeconds(1)));}
 @Test void sixHours(){assertEquals(new BigDecimal("100.00"),FeeCalculator.calculate(entry,entry.plusHours(6)));}
 @Test void sevenHours(){assertEquals(new BigDecimal("150.00"),FeeCalculator.calculate(entry,entry.plusHours(7)));}
 @Test void exitBeforeEntryRejected(){assertThrows(IllegalArgumentException.class,()->FeeCalculator.calculate(entry,entry.minusMinutes(1)));}}
