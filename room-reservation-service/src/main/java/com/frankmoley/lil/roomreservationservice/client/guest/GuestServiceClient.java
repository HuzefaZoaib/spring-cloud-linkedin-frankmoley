package com.frankmoley.lil.roomreservationservice.client.guest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "guest-service", fallback = GuestServiceFallback.class)
public interface GuestServiceClient {

    final static String GUESTS_URL_PART = "/guests";
    final static String SLASH = "/";

    @GetMapping(GUESTS_URL_PART)
    List<Guest> getAll();

    @PostMapping(GUESTS_URL_PART)
    Guest addGuest(@RequestBody Guest guest);

    @GetMapping(GUESTS_URL_PART+SLASH+"{id}")
    Guest getGuest(@PathVariable("id") long id);

    @PutMapping(GUESTS_URL_PART+SLASH+"{id}")
    void updateGuest(@PathVariable("id") long id, @RequestBody Guest guest);

    @DeleteMapping(GUESTS_URL_PART+SLASH+"{id}")
    void deleteGuest(@PathVariable("id") long id);
}
