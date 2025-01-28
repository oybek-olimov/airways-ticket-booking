package org.example.airwaysticketbooking.DomainDriverDesign.authUser;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.Session;
import org.apache.catalina.security.SecurityUtil;
import org.example.airwaysticketbooking.DomainDriverDesign.securityConfig.SessionUser;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfilePictureService {

    private static final String UPLOAD_DIR = "src/main/resources/uploads/profile-pictures";
    private final UserProfileRepository userProfileRepository;
    private final SessionUser sessionUser;
    private final UserRepository userRepository;

    public String saveProfilePicture(MultipartFile file) {
        try {
            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath);

            Long userId = sessionUser.getCurrentUserId();
            AuthUser user = userRepository.findById(userId)
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));

            String email = user.getEmail();
            UserProfile profile = userProfileRepository.findByAuthUserEmail(email)
                    .orElseThrow(() -> new RuntimeException("User profile not found"));
            profile.setProfilePicturePath(filePath.toString());
            userProfileRepository.save(profile);

            return filePath.toString();
        } catch (IOException e) {
            throw new RuntimeException("Failed to save profile picture: " + e.getMessage());
        }
    }

    public String getProfilePicturePath() {
        Long userId = sessionUser.getCurrentUserId();
        AuthUser user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        UserProfile profile = userProfileRepository.findByAuthUserEmail(user.getEmail())
                .orElseThrow(() -> new RuntimeException("User profile not found"));
        return profile.getProfilePicturePath();
    }
}
