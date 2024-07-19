package com.moghoneim.user_service.external.service.impl;

import com.moghoneim.user_service.external.client.GuestFeignClient;
import com.moghoneim.user_service.external.dto.GuestRequest;
import com.moghoneim.user_service.external.dto.GuestResponse;
import com.moghoneim.user_service.external.service.GuestListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GuestListServiceImpl  implements GuestListService {


    private final GuestFeignClient guestFeignClient;

    @Override
    public List<GuestResponse> getUserGuestList() {

        return guestFeignClient.getUserGuestList(getCurrentUserId());
    }

    @Override
    public void addGuestForUser(GuestRequest request) {

        guestFeignClient.addGuestForUser(getCurrentUserId(),request);
    }

    @Override
    public void addGuestsForUser(List<GuestRequest> requests) {
        guestFeignClient.addGuestListForUser(getCurrentUserId(),requests);
    }

    @Override
    public void deleteGuestByUserId(String guestName) {

        guestFeignClient.deleteGuestByUserId(getCurrentUserId(),guestName);

    }

    @Override
    public void deleteGuestListByUserId() {

        guestFeignClient.deleteGuestListByUserId(getCurrentUserId());

    }

    @Override
    public void updateGuestForUser(String guestName, GuestRequest request) {

        guestFeignClient.updateGuestForUser(getCurrentUserId(),guestName,request);

    }

    private Long getCurrentUserId(){
        //this method should return the ID of the current authenticated user

        //for now, it returns 3 as user ID for testing purposes
        return 3L;
    }
}
