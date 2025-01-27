package org.example.airwaysticketbooking.DomainDriverDesign.authUser;

import lombok.RequiredArgsConstructor;
import org.example.airwaysticketbooking.DomainDriverDesign.securityConfig.SessionUser;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final UserRepository userRepository;
    private final SessionUser sessionUser;


    @Override
    public UserProfile getProfile() {
        Long userId = sessionUser.getCurrentUserId();
        return userProfileRepository.findByAuthUserId(userId);
    }

    @Override
    public UserProfile updateProfile(UserProfileDTO profileDTO) {
        Long userId = sessionUser.getCurrentUserId();
        UserProfile profile = userProfileRepository.findByAuthUserId(userId);
        if (profile == null) {
            AuthUser authUser = userRepository.findById(userId)
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));
            profile = new UserProfile();
            profile.setAuthUser(authUser);
        }
        profile.setFirstName(profileDTO.getFirstName());
        profile.setLastName(profileDTO.getLastName());
        profile.setPhoneNumber(profileDTO.getPhoneNumber());
        profile.setAddress(profileDTO.getAddress());
        return userProfileRepository.save(profile);
    }
}
