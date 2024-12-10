package com.example.authservice.controllers;


import com.example.authservice.common.constants.ApiPathConstants;
import com.example.authservice.common.dto.TokenResponse;
import com.example.authservice.common.dto.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.AUTH_ROUTE)
public interface AuthApi {

    @PostMapping(value = "/register")
    ResponseEntity<TokenResponse> createUser(@RequestBody @Valid UserRequest userRequest);

    @GetMapping
    ResponseEntity<String> getUser(@RequestAttribute(name = "X-User-Id") String userId);

    @PostMapping(value = "/login")
    ResponseEntity<TokenResponse> loginUser(@RequestBody @Valid UserRequest userRequest);

}
