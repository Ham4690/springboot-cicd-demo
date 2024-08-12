package com.example.demo.controller;

import com.example.demo.dto.HelloResponse;
import com.example.demo.service.HelloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Hello", description = "Hello API")
public class HelloController {

    private final HelloService helloService;

    @GetMapping("/hello")
    @Operation(summary = "Get Hello Message", description = "Returns the hello message.")
    public ResponseEntity<HelloResponse> getHello() {
        return ResponseEntity.ok(helloService.getHelloMessage());
    }
}
