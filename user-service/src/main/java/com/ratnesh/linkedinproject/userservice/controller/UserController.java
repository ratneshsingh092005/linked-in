package com.ratnesh.linkedinproject.userservice.controller;

import com.ratnesh.linkedinproject.userservice.dto.LoginRequest;
import com.ratnesh.linkedinproject.userservice.dto.SignupRequest;
import com.ratnesh.linkedinproject.userservice.dto.UserProfileResponse;
import com.ratnesh.linkedinproject.userservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserProfileResponse> signup(@RequestBody SignupRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody  LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }


}
