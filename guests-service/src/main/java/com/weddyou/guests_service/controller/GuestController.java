package com.weddyou.guests_service.controller;

import com.weddyou.guests_service.dto.GuestRequest;
import com.weddyou.guests_service.dto.GuestResponse;
import com.weddyou.guests_service.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/guests")
public class GuestController {

    private final GuestService guestService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public  List<GuestResponse>getGuestList(){

        return guestService.getGuests();
    }

    @PostMapping("/add-guest")
    @ResponseStatus(HttpStatus.CREATED)
    public  void addGuest(@RequestBody GuestRequest guestRequest){
        guestService.addGuest(guestRequest);
    }

    @DeleteMapping("/{guest-name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGuest(@PathVariable("guest-name")String guestName){
        guestService.deleteGuest(guestName);
    }

    @PutMapping("/{guest-name}")
    @ResponseStatus(HttpStatus.OK)
    public void updateGuest(@PathVariable("guest-name")String guestName
                            ,@RequestBody GuestRequest guestRequest){


        guestService.updateGuest(guestName,guestRequest);


    }
}
