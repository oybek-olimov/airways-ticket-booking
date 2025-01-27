package org.example.airwaysticketbooking.DomainDriverDesign.securityConfig;

import lombok.RequiredArgsConstructor;
import org.example.airwaysticketbooking.DomainDriverDesign.authUser.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionUser {
    public Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails currentUser) {
            return currentUser.getAuthUser().getId();
        }
        throw new IllegalArgumentException("User not authenticated");
    }
}
