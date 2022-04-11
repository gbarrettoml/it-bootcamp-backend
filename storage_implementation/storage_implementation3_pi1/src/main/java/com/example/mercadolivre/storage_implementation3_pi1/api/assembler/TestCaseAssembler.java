package com.example.mercadolivre.storage_implementation3_pi1.api.assembler;

import com.example.mercadolivre.storage_implementation3_pi1.api.model.TestCaseRequest;
import com.example.mercadolivre.storage_implementation3_pi1.api.model.TestCaseResponse;
import com.example.mercadolivre.storage_implementation3_pi1.domain.model.TestCase;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TestCaseAssembler {

    private final ModelMapper modelMapper;

    public TestCase toDomainObject(TestCaseRequest testCaseRequest) {
        return modelMapper.map(testCaseRequest, TestCase.class);
    }

    public TestCaseResponse toResponseObject(TestCase testCase) {
        return modelMapper.map(testCase, TestCaseResponse.class);
    }

}
