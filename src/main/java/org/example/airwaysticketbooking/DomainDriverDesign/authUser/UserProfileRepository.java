package org.example.airwaysticketbooking.DomainDriverDesign.authUser;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    UserProfile findByAuthUserId(Long userId);

    Optional<UserProfile> findByAuthUserEmail(String email);


}
