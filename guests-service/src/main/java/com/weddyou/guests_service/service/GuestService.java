package com.weddyou.guests_service.service;

import com.weddyou.guests_service.dto.GuestRequest;
import com.weddyou.guests_service.dto.GuestResponse;

import java.util.List;

public interface GuestService  {
    public void addGuest(GuestRequest request);
    public void deleteGuest(String guestName);
    public List<GuestResponse> getGuests();
    public void updateGuest(String guestName,GuestRequest updatedGuest);

    public List<GuestResponse> getUserGuestList(Long userId);
    public void deleteGuestListByUserId(Long userId);
    public void deleteGuestByUserId(Long userId,String guestName);
    public void addGuestForUser(GuestRequest request,Long userId);
    public void addGuestsForUser(List<GuestRequest> requests, Long userId);
    public void updateGuestForUser(String guestName,Long userId,GuestRequest updatedGuest);

}
