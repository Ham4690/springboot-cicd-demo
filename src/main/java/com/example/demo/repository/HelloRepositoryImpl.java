package com.example.demo.repository;

import org.springframework.stereotype.Repository;

@Repository
public class HelloRepositoryImpl implements HelloRepository {

    @Override
    public String getHelloMessage() {
        return "Hello World!";
    }
}
