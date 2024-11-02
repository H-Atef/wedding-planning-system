package com.moghoneim.user_service.external.client;

import com.moghoneim.user_service.external.dto.RsvpRequest;
import com.moghoneim.user_service.external.dto.RsvpResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("RSVP-SERVICE")
public interface RsvpFeignClient {

    @GetMapping("/api/v1/rsvp/user-rsvp/{user-id}")
    public RsvpResponse getUserRsvp(
            @PathVariable(value = "user-id"
                    ,required = false) Long userId);

    @PostMapping("/api/v1/rsvp/add-user-rsvp/{user-id}")
    public void addUserRsvp(
            @PathVariable(value = "user-id"
                    ,required = false) Long userId,
            @RequestBody RsvpRequest request);


    @DeleteMapping("/api/v1/rsvp/delete-user-rsvp/{user-id}")
    public void deleteUserRsvp(
            @PathVariable(value = "user-id"
                    ,required = false) Long userId);

    @PutMapping("/api/v1/rsvp/update-user-rsvp/{user-id}")
    public void updateUserRsvp(
            @PathVariable(value = "user-id"
                    , required = false) Long userId,
            @RequestBody RsvpRequest request);
}
