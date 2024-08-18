package com.frankmoley.lil.roomreservationservice.client.guest;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class GuestServiceFallback implements GuestServiceClient {

    @Override
    public List<Guest> getAll() {
        return Collections.emptyList();
    }

    @Override
    public Guest addGuest(Guest guest) {
        return new Guest();
    }

    @Override
    public Guest getGuest(long id) {
        return new Guest();
    }

    @Override
    public void updateGuest(long id, Guest guest) {
        return;
    }

    @Override
    public void deleteGuest(long id) {
        return;
    }
}
