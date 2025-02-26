package com.gvc.echodev_newsletter.controller;

import com.gvc.echodev_newsletter.application.dto.AuthenticationDTO;
import com.gvc.echodev_newsletter.application.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @Operation(summary = "Login with the Admin user to retrieve token")
    @ApiResponse(responseCode = "201", description = "Token generated!")
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody AuthenticationDTO authRequest) {
        String token = authService.authenticate(authRequest.getUsername(), authRequest.getPassword());
        return ResponseEntity.ok(Map.of("token", token));
    }
}
