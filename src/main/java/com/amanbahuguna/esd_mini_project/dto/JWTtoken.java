package com.amanbahuguna.esd_mini_project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record JWTtoken(
        @JsonProperty
        String jwt
) {
}
