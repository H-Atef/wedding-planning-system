package com.weddyou.guests_service.repository;

import com.weddyou.guests_service.model.GuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GuestRepository extends JpaRepository<GuestEntity,Long> {

    GuestEntity findByGuestName(String guestName);

}
