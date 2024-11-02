package com.moghoneim.user_service.external.client;


import com.moghoneim.user_service.external.dto.GuestRequest;
import com.moghoneim.user_service.external.dto.GuestResponse;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "GUESTS-SERVICE")
public interface GuestFeignClient {

    @GetMapping("/api/v1/guests/guest-list/{user-id}")
    public  List<GuestResponse>getUserGuestList(@PathVariable(value = "user-id"
                                                            ,required = false) Long userId);


    @PostMapping("/api/v1/guests/guest-list/{user-id}")
    public  void addGuestForUser(@PathVariable(value = "user-id",required = false) Long userId,
                                 @RequestBody GuestRequest guestRequest);

    @PostMapping("/api/v1/guests/guest-list/add-list/{user-id}")
    public  void addGuestListForUser(@Valid @PathVariable(value = "user-id",required = false) Long userId,
                                     @RequestBody List<GuestRequest> guestRequests);

    @DeleteMapping("/api/v1/guests/delete-guest/{user-id}/{guest-name}")
    public void deleteGuestByUserId(@PathVariable(value = "user-id",required = false) Long userId,
                                    @PathVariable("guest-name")String guestName);


    @DeleteMapping("/api/v1/guests/delete-guest-list/{user-id}")
    public void deleteGuestListByUserId(@PathVariable(value = "user-id",required = false) Long userId);


    @PutMapping("/api/v1/guests/update-guest/{user-id}/{guest-name}")
    public void updateGuestForUser(@PathVariable(value = "user-id",required = false) Long userId,
                                   @PathVariable("guest-name")String guestName,
                                   @RequestBody GuestRequest guestRequest);

}
