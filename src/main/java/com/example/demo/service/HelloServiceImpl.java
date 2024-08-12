package com.example.demo.service;

import com.example.demo.dto.HelloResponse;
import com.example.demo.repository.HelloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloServiceImpl implements HelloService {

    private final HelloRepository helloRepository;

    @Override
    public HelloResponse getHelloMessage() {
        return new HelloResponse(helloRepository.getHelloMessage());
    }
}
