package com.example.mercadolivre.storage_implementation3_pi2.api.assembler;

import com.example.mercadolivre.storage_implementation3_pi2.api.model.TutorialRequest;
import com.example.mercadolivre.storage_implementation3_pi2.api.model.TutorialResponse;
import com.example.mercadolivre.storage_implementation3_pi2.domain.model.Tutorial;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class TutorialAssembler {

    private ModelMapper modelMapper;

    public Tutorial toDomainObject(TutorialRequest requestObj) {
        return modelMapper.map(requestObj, Tutorial.class);
    }

    public TutorialResponse toResponseObject(Tutorial entity) {
        return modelMapper.map(entity, TutorialResponse.class);
    }
}
