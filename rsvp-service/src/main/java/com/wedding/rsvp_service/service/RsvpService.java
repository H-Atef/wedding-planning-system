package com.wedding.rsvp_service.service;
import com.wedding.rsvp_service.dto.RsvpRequest;
import com.wedding.rsvp_service.dto.RsvpResponse;

import java.util.List;

public interface RsvpService {
    public List<RsvpResponse> getAllRsvps();
    public void addRsvp(RsvpRequest request);
    public void deleteRsvpById(Long rsvpId);
    public void updateRsvpById(Long rsvpId,RsvpRequest request);

    public RsvpResponse getUserRsvp(Long userId);
    public void addRsvpForUser(Long userId,RsvpRequest request);
    public void deleteRsvpByUserId(Long userId);
    public void updateRsvpForUser(Long userId,RsvpRequest request);
}
