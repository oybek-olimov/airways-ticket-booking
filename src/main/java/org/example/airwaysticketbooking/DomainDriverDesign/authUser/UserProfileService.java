package org.example.airwaysticketbooking.DomainDriverDesign.authUser;

public interface UserProfileService {

    UserProfile getProfile();

    UserProfile updateProfile(UserProfileDTO profileDTO);
}
