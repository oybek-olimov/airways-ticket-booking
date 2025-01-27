package org.example.airwaysticketbooking.domainDriverDesign.authUser;

import jakarta.validation.Valid;

public interface UserService {

    void registerUser(@Valid UserRegisterDTO userRegisterDTO);

    JwtResponseDTO loginUser(@Valid UserLoginDTO userLoginDTO);
}
