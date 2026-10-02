package com.cricverse.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamDTO {

    private Long id;
    private String name;
    private String country;
    private String coach;
    private Integer foundedYear;

}
