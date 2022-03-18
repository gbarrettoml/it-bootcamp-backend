package com.itbootcampmercadolivre.praticaintegradora11.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class AgeService {

    public Integer calculateAge(Integer d, Integer m, Integer y) {
        LocalDate birthDate = LocalDate.of(y, m, d);
        LocalDate date = LocalDate.now();
        return (int) ChronoUnit.YEARS.between(birthDate, date);
    }
}
