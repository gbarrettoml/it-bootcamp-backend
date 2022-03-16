package com.market.example.service;

public interface CRUD<T> {

    T register();
    void findAll();
    void deleteById();
    void findById();

}
