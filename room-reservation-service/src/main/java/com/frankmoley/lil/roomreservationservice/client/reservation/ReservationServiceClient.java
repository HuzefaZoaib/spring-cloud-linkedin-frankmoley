package com.frankmoley.lil.roomreservationservice.client.reservation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@FeignClient("reservation-service")
public interface ReservationServiceClient {

    final static String RESERVATIONS_URL_PART = "/reservations";
    final static String SLASH = "/";

    @GetMapping(RESERVATIONS_URL_PART)
    List<Reservation> getAll(
            @RequestParam(value = "dateString", required = false) String dateString,
            @RequestParam(value = "guestId", required = false) Long guestId);

    @PostMapping(RESERVATIONS_URL_PART)
    Reservation addReservation(@RequestBody Reservation reservation);

    @GetMapping(RESERVATIONS_URL_PART+SLASH+"{id}")
    Reservation getReservation(@PathVariable("id") long id);

    @PutMapping(RESERVATIONS_URL_PART+SLASH+"{id}")
    void updateReservation(@PathVariable("id") long id, @RequestBody Reservation reservation);

    @DeleteMapping(RESERVATIONS_URL_PART+SLASH+"{id}")
    void deleteReservation(@PathVariable("id") long id);

}
