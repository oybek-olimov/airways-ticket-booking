package org.example.airwaysticketbooking.DomainDriverDesign.authUser;

import lombok.RequiredArgsConstructor;
import org.example.airwaysticketbooking.DomainDriverDesign.order.OrderHistoryDTO;
import org.example.airwaysticketbooking.DomainDriverDesign.ticket.Ticket;
import org.example.airwaysticketbooking.DomainDriverDesign.ticket.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final UserRepository userRepository;

    @Override
    public UserProfile getProfile(Long userId) {
        return userProfileRepository.findByUserId(userId);
    }

    @Override
    public UserProfile updateProfile(Long userId, UserProfileDTO profileDTO) {
        UserProfile profile = userProfileRepository.findByUserId(userId);
        if (profile == null) {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));
            profile = new UserProfile();
            profile.setUser(user);
        }
        profile.setFirstName(profileDTO.getFirstName());
        profile.setLastName(profileDTO.getLastName());
        profile.setPhoneNumber(profileDTO.getPhoneNumber());
        profile.setAddress(profileDTO.getAddress());
        return userProfileRepository.save(profile);
    }
}
