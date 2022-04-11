package com.example.mercadolivre.storage_implementation3_pi1.domain.service.impl;

import com.example.mercadolivre.storage_implementation3_pi1.domain.exception.TestCaseNotFoundException;
import com.example.mercadolivre.storage_implementation3_pi1.domain.model.TestCase;
import com.example.mercadolivre.storage_implementation3_pi1.domain.model.filter.TestCaseFilter;
import com.example.mercadolivre.storage_implementation3_pi1.domain.repository.ITestCaseRepository;
import com.example.mercadolivre.storage_implementation3_pi1.domain.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseServiceImpl implements ITestCaseService {

    @Autowired
    private ITestCaseRepository repository;

    @Override
    public TestCase save(TestCase model) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String dateFormated = formatter.format(date);
        model.setLast_update(dateFormated);
        return repository.save(model);
    }

    @Override
    public TestCase find(String id) {
        return repository.findById(id).orElseThrow( () -> new TestCaseNotFoundException(id));
    }

    @Override
    public List<TestCase> findAll(TestCaseFilter testCaseFilter) {
        return repository.findAll()
                .stream()
                .filter(obj -> testCaseFilter.filterDescription(obj.getDescription()))
                .filter(obj -> testCaseFilter.isTestedFilter(obj.getTested()))
                .filter(obj -> testCaseFilter.isPassedFilter(obj.getPassed()))
                .filter(obj -> testCaseFilter.filter(obj.getNumber_of_tries()))
                .filter(obj -> testCaseFilter.filterDate(obj.getLast_update()))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        repository.findById(id).orElseThrow( () -> new TestCaseNotFoundException(id));
        repository.deleteById(id);
    }
}
