package com.moghoneim.user_service.external.service.impl;

import com.moghoneim.user_service.external.client.RsvpFeignClient;
import com.moghoneim.user_service.external.dto.RsvpRequest;
import com.moghoneim.user_service.external.dto.RsvpResponse;
import com.moghoneim.user_service.external.service.UserRsvpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserRsvpImpl implements UserRsvpService {
    private final RsvpFeignClient rsvpFeignClient;


    @Override
    public RsvpResponse getUserRsvp() {
        return rsvpFeignClient.getUserRsvp(getCurrentUserId());
    }

    @Override
    public void addRsvpForUser(RsvpRequest request) {

        rsvpFeignClient.addUserRsvp(getCurrentUserId(),request);

    }

    @Override
    public void deleteRsvpByUserId() {

        rsvpFeignClient.deleteUserRsvp(getCurrentUserId());

    }

    @Override
    public void updateRsvpForUser(RsvpRequest request) {

        rsvpFeignClient.updateUserRsvp(getCurrentUserId(),request);

    }

    private Long getCurrentUserId(){
        //this method should return the ID of the current authenticated user

        //for now, it returns 3 as user ID for testing purposes
        return 3L;
    }
}
