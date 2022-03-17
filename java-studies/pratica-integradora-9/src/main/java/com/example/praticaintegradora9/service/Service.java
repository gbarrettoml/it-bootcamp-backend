package com.example.praticaintegradora9.service;
import lombok.AllArgsConstructor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@org.springframework.stereotype.Service
public class Service {

    public List<String> execute(String value) {
        List<String> conversor = new ArrayList<>();

        String firstNumber = null;
        String scndNumber = null;

        List<String> list = Arrays
                .stream(value.split("")).collect(Collectors.toList());
        Collections.reverse(list);

        for(int i = 0; i <= list.size(); i++) {
            Integer result = Integer.parseInt(list.get(i)) * (i + 1);

            for(int letters = result; letters >= result; result--) {
                if( list.get(i) == "1" ||
                    list.get(i) == "5" ||
                    list.get(i) == "10" ||
                    list.get(i) == "50" ||
                    list.get(i) == "100" ||
                    list.get(i) == "500" ||
                    list.get(i) == "1000") {

                }
            }
        }
        return list;
    }


}
