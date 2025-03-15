package org.example.airwaysticketbooking.DomainDriverDesign.authUser;

import lombok.RequiredArgsConstructor;
import org.example.airwaysticketbooking.DomainDriverDesign.securityConfig.JwtResponseDTO;
import org.example.airwaysticketbooking.DomainDriverDesign.securityConfig.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final UserProfileRepository userProfileRepository;

    @Override
    @Transactional
    public AuthUserResponseDTO registerUser(UserRegisterDTO userRegisterDTO) {
        if (userRepository.existsByEmail(userRegisterDTO.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        AuthUser authUser = new AuthUser();
        authUser.setEmail(userRegisterDTO.getEmail());
        authUser.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        userRepository.save(authUser);

        UserProfile profile = new UserProfile();
        profile.setAuthUser(authUser);
        profile.setFirstName(userRegisterDTO.getFirstName());
        profile.setLastName(userRegisterDTO.getLastName());
        profile.setPhoneNumber(userRegisterDTO.getPhoneNumber());
        profile.setAddress(userRegisterDTO.getAddress());
        userProfileRepository.save(profile);

        jwtUtil.generateToken(authUser.getEmail());
        return new AuthUserResponseDTO(authUser.getId(), profile.getFirstName() + " " + profile.getLastName(), authUser.getEmail());

    }

    @Override
    @Transactional
    public JwtResponseDTO loginUser(UserLoginDTO userLoginDTO) {
        AuthUser authUser = userRepository.findByEmail(userLoginDTO.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        if (!passwordEncoder.matches(userLoginDTO.getPassword(), authUser.getPassword())) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        String token = jwtUtil.generateToken(authUser.getEmail());
        return new JwtResponseDTO(token);
    }


}
