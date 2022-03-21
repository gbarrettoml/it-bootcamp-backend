package com.itbootcampmercadolivre.praticaintegradora12.model;

import com.itbootcampmercadolivre.praticaintegradora12.dto.SportDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sport {

    private String name;
    private String experience;

    public Sport (SportDto sportDto) {
        this.name = sportDto.getName();
        this.experience = sportDto.getExperience();
    }
}
