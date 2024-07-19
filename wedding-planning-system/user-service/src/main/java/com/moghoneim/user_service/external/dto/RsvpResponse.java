package com.moghoneim.user_service.external.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RsvpResponse {
    private Long rsvpId;
    private List<String> questions;
    private List<String> answers;
    private Long userId;
}
