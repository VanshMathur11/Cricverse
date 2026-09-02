package com.cricverse.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePlayerRequest {

    @NotBlank(message = "Player name is required")
    @Size(min = 2, max = 50,
          message = "Player name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Country is required")
    private String country;

    @NotBlank(message = "Role is required")
    private String role;

    private String battingStyle;
    private String bowlingStyle;
}