package org.example.airwaysticketbooking.DomainDriverDesign.authUser;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;

    @GetMapping
    public ResponseEntity<UserProfile> getProfile() {
        return ResponseEntity.ok(userProfileService.getProfile());
    }

    @PutMapping
    public ResponseEntity<UserProfile> updateProfile( @RequestBody UserProfileDTO profileDTO) {
        return ResponseEntity.ok(userProfileService.updateProfile(profileDTO));
    }
}
