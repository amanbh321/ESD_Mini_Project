package com.amanbahuguna.esd_mini_project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record assignStudentsRequest(
          String studRollNo,
          String courseCode,
          int approved

//        @JsonProperty("approved")
//        int approved
){
}

