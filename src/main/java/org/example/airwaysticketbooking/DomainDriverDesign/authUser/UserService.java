package org.example.airwaysticketbooking.DomainDriverDesign.authUser;

import jakarta.validation.Valid;
import org.example.airwaysticketbooking.DomainDriverDesign.securityConfig.JwtResponseDTO;

public interface UserService {

    String registerUser(@Valid UserRegisterDTO userRegisterDTO);

    JwtResponseDTO loginUser(@Valid UserLoginDTO userLoginDTO);
}
