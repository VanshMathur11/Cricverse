package com.cricverse.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTeamRequest {
    
    @NotBlank(message = "Team name is required")
    @Size(min = 2, max = 40,
          message = "Team name must be between 2 and 40 characters")
    private String name;

    @NotBlank(message = "Country is required")
    private String country;

    @NotBlank(message = "Coach is required")
    private String coach;
    
    @NotNull(message = "Year cannot be NUll")
    private Integer foundedYear;
}
