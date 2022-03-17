package com.itbootcamp.mercadolivre.codigoMorse.service;

import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class MyService {

    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private String[] alphaMorseCode = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
            "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
    };

    private String[] numbersMorsecode = {
        ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----"
    };

    public String execute(String str) {
        List<String> alphabetList = Arrays.stream(alphabet.split("")).collect(Collectors.toList());
        List<String> strList = Arrays.stream(str.split("")).collect(Collectors.toList());
        List<String> listTraslated = new ArrayList<>();

        for(int i = 0; i < strList.size(); i++) {
            for(int j = 0; j < alphabetList.size(); j++) {
                if( alphabetList.get(j).equals(strList.get(i)) ) {
                    System.out.println(alphabetList.get(j));
                    listTraslated.add(alphaMorseCode[j] + " ");
                }
            }
        }

        return listTraslated.stream().collect(Collectors.joining());
    }
}
