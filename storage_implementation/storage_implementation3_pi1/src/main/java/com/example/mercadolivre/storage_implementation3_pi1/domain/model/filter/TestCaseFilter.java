package com.example.mercadolivre.storage_implementation3_pi1.domain.model.filter;

import lombok.Getter;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class TestCaseFilter {

    private String description;
    private Boolean tested;
    private Boolean passed;
    private Integer number_of_tries;
    private String last_update;

    public Boolean filterDescription(String descriptionFilter) {
        if(this.description != null) return this.description.equalsIgnoreCase(descriptionFilter);
        return true;
    }

    public Boolean isTestedFilter(Boolean testedFilter) {
         if(this.tested != null) return this.tested.equals(testedFilter);
         return true;
    }

    public Boolean isPassedFilter(Boolean passedFilter) {
        if(this.passed != null) return this.passed.equals(passedFilter);
        return true;
    }

    public Boolean filter(Integer number_of_tries_filter) {
        if(this.number_of_tries != null) return this.number_of_tries.equals(number_of_tries_filter);
        return true;
    }

    public Boolean filterDate(String last_update_filter) {
        if(this.last_update != null) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            try {
                return format.parse(this.last_update).after(format.parse(last_update_filter));
            } catch (ParseException err) {
                err.getMessage();
            }
        }
        return true;
    }
}
