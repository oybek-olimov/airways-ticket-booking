package org.example.airwaysticketbooking.DomainDriverDesign.authUser;

public interface UserProfileService {

    UserProfile getProfile(Long userId);

    UserProfile updateProfile(Long userId, UserProfileDTO profileDTO);
}
