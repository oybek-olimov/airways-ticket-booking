package org.example.airwaysticketbooking.DomainDriverDesign.authUser;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.airwaysticketbooking.DomainDriverDesign.securityConfig.JwtResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody UserRegisterDTO userRegisterDTO) {
        return ResponseEntity.ok(userService.registerUser(userRegisterDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDTO> login(@Valid @RequestBody UserLoginDTO userLoginDTO) {
        JwtResponseDTO jwtResponse = userService.loginUser(userLoginDTO);
        return ResponseEntity.ok(jwtResponse);
    }
}