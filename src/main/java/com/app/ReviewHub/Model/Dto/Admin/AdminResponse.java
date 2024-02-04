package com.app.ReviewHub.Model.Dto.Admin;

import com.app.ReviewHub.Model.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class AdminResponse {
    private UUID id;

    private String fullName;

    private LocalDate dateOfBirth;

    private String address;

    private String email;

    private Role role;
}
