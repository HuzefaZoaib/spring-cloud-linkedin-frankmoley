package com.frankmoley.lil.roomreservationservice.client.room;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("room-service")
public interface RoomServiceClient {

    final static String ROOMS_URL_PART = "/rooms";

    final static String SLASH = "/";

    @GetMapping(ROOMS_URL_PART)
    List<Room> getAll();

    @PostMapping(ROOMS_URL_PART)
    Room addRoom(@RequestBody Room room);

    @GetMapping(ROOMS_URL_PART+"/{id}")
    Room getRoom(@PathVariable("id") long id);

    @PutMapping(ROOMS_URL_PART+"/{id}")
    void updateRoom(@PathVariable("id") long id, @RequestBody Room room);

    @DeleteMapping(ROOMS_URL_PART+"/{id}")
    void deleteRoom(@PathVariable("id") long id);
}
