package com.mercadolivre.storage_implementation2_pi1.api.assembler;

import com.mercadolivre.storage_implementation2_pi1.api.model.JewelRequest;
import com.mercadolivre.storage_implementation2_pi1.api.model.JewelResponse;
import com.mercadolivre.storage_implementation2_pi1.domain.model.Jewel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JewelAssembler {

    private final ModelMapper modelMapper;

    public Jewel toDomainObject(JewelRequest jewelRequest) {
        return modelMapper.map(jewelRequest, Jewel.class);
    }

    public JewelResponse toResponseObject(Jewel jewel) {
        return modelMapper.map(jewel, JewelResponse.class);
    }
}
