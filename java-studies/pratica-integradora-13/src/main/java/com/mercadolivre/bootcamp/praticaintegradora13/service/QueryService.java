package com.mercadolivre.bootcamp.praticaintegradora13.service;

import com.mercadolivre.bootcamp.praticaintegradora13.model.Person;
import lombok.AllArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@SuppressWarnings("unchecked")
public class QueryService {

    List<Person> query = new ArrayList<>();

    public List<Person> character(String string) {
        JSONArray starwarsList = serviceRead();

        starwarsList.forEach(object -> {
            JSONObject o = (JSONObject) object;
            String name = (String) o.get("name");
            String mass = String.valueOf(o.get("mass"));
            String height = String.valueOf(o.get("height"));

            if(name.contains(string)) {
                query.add(new Person(
                        (String) o.get("name"),
                        height,
                        mass,
                        (String) o.get("hairColor"),
                        (String) o.get("skinColor"),
                        (String) o.get("eyeColor"),
                        (String) o.get("birthYear"),
                        (String) o.get("gender"),
                        (String) o.get("homeworld"),
                        (String) o.get("species")
                ));
            }
        });
        return query;
    }

    private JSONArray serviceRead() {
        try {
            JSONParser jsonParser = new JSONParser();

            FileReader reader = new FileReader("starwars.json");
            Object obj = jsonParser.parse(reader);
            return (JSONArray) obj;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }





}
