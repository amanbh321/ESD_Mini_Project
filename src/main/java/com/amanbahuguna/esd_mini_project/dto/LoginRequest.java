package com.amanbahuguna.esd_mini_project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LoginRequest (
        @JsonProperty("email")
        String email,

        @JsonProperty("password")
        String password
) {

}
