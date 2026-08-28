package com.cricverse.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerDTO {

    private Long id;
    private String name;
    private String country;
    private String role;
}