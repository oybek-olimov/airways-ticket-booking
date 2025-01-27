package org.example.airwaysticketbooking.DomainDriverDesign.authUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    UserProfile findByAuthUserId(Long userId);
}
