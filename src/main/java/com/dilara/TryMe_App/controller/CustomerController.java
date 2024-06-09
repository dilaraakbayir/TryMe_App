package com.dilara.TryMe_App.controller;

import com.dilara.TryMe_App.dto.request.LoginRequestDto;
import com.dilara.TryMe_App.dto.request.RegisterRequestDto;
import com.dilara.TryMe_App.dto.response.LoginResponseDto;
import com.dilara.TryMe_App.dto.response.RegisterResponseDto;
import com.dilara.TryMe_App.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.dilara.TryMe_App.constants.RestApi.CUSTOMER;

@RestController
@RequiredArgsConstructor
@RequestMapping(CUSTOMER)
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterRequestDto dto){
        return ResponseEntity.ok(customerService.registerMapper(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto dto){
        return ResponseEntity.ok(customerService.login(dto));
    }


}
