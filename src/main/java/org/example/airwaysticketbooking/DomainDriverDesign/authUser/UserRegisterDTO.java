package org.example.airwaysticketbooking.DomainDriverDesign.authUser;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegisterDTO {
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email must be in a valid format")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @NotBlank(message = "First name cannot be blank")
    @Size(max = 50, message = "First name cannot be longer than 50 characters")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Size(max = 50, message = "Last name cannot be longer than 50 characters")
    private String lastName;

    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(regexp = "^[+][0-9]{12}$", message = "Phone number must be in a valid format. Example: +998901234567")
    private String phoneNumber;

    @NotBlank(message = "Address cannot be blank")
    @Size(max = 100, message = "Address cannot be longer than 100 characters")
    private String address;
}
