package org.example.airwaysticketbooking.DomainDriverDesign.authUser;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Authentication", description = "APIs for user authentication")
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody UserRegisterDTO userRegisterDTO) {
        userService.registerUser(userRegisterDTO);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/login")
    @Operation(
            summary = "Login user",
            description = "Authenticate user and return JWT token",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully logged in"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized")
            }
    )
    public ResponseEntity<JwtResponseDTO> login(@Valid @RequestBody UserLoginDTO userLoginDTO) {
        JwtResponseDTO jwtResponse = userService.loginUser(userLoginDTO);
        return ResponseEntity.ok(jwtResponse);
    }
}