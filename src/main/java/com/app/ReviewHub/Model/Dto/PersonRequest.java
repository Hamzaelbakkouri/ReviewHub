package com.app.ReviewHub.Model.Dto;

import com.app.ReviewHub.Model.Entity.Comment;
import com.app.ReviewHub.Model.Entity.Review;
import com.app.ReviewHub.Model.Enum.Role;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class PersonRequest {
    private UUID id;

    @NotBlank(message = "FullName must be not blank")
    private String fullName;

    @NotBlank(message = "password must be not blank")
    @Min(value = 6, message = "Password must be")
    private String password;

    @Past(message = "Date Of Birth must be in past")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Address must be not blank")
    private String address;

    @NotBlank(message = "Email must be not blank")
    private String email;

    @NotBlank(message = "Role must be not blank")
    private Role role;
}
